package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.consumer.RequestDados;
import org.example.domain.PagamentoRequest;
import org.example.dto.request.*;
import org.example.dto.response.ResponseAuth;
import org.example.dto.response.ResponseBancoPagamento;
import org.example.dto.response.ResponseProcessoPagamento;
import org.example.dto.response.ResponseToken;
import org.example.model.PagamentoModel;
import org.example.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RabbitMqService rabbitMQService;

    @Autowired
    private WebClient.Builder clientBuilder;

    private final String bancoAprovacao = "https://pb-getway-payment.herokuapp.com/v1/payments/credit-card";
    private final String autenticar = "https://pb-getway-payment.herokuapp.com/v1/auth";

    public ResponseBancoPagamento criarRequestPagamento(RequestDados requestPagamento){
        String auth = autorizacao();
        Long id = requestPagamento.getId();
        ResponseBancoPagamento processoPagamento = clientBuilder
                .build()
                .post()
                .uri(bancoAprovacao)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(auth))
                .bodyValue(assigns(requestPagamento))
                .retrieve()
                .bodyToMono(ResponseBancoPagamento.class)
                .block();
        repository.save(new PagamentoModel(null,
                requestPagamento.getId(), requestPagamento.getTotal(),
                requestPagamento.getCpf(), processoPagamento.getStatus(), LocalDateTime.now()));
        rabbitMQService.enviaRetornoDePagamentoParaQueue(requestPagamento.getId(), processoPagamento);
        return processoPagamento;

    }
    private RequestBancoPagamento assigns(RequestDados requestPagamento) {

        String numberToken = tokenService.encriptografa(String.valueOf(requestPagamento.getPagamento()
                .getNumeroCartao()));

        RequestBancoPagamento pagamento = new RequestBancoPagamento();
        RequestClient client = new RequestClient();
        RequestCartao cartao = new RequestCartao();

        client.setTipoDoc("CPF");
        client.setNumeroDoc(requestPagamento.getCpf());
        cartao.setTokenNum(numberToken);
        cartao.setNomeCartao(requestPagamento.getPagamento().getNomeCartao());
        cartao.setSegurancaCod(String.valueOf(requestPagamento.getPagamento()
                .getCodigoSeguranca()));
        cartao.setMarca(requestPagamento.getPagamento().getMarca());
        cartao.setMesExpiracao(String.valueOf(requestPagamento.getPagamento()
                .getMesExpiracao()));
        cartao.setAnoExpiracao(String.valueOf(requestPagamento.getPagamento()
                .getAnoExpiracao()));

        pagamento.setSeller_id("5a90a7ec-dd17-470e-9f12-b4a8143c9cc0");
        pagamento.setCustomer(client);
        pagamento.setTipoPagamento(requestPagamento.getTipo_pagamento());
        pagamento.setMoeda(requestPagamento.getPagamento().getMoeda());
        pagamento.setValor(Double.parseDouble(String.valueOf(requestPagamento.getTotal())));
        pagamento.setCard(cartao);

        return pagamento;
    }



    private String autorizacao() {
        RequestAuth requestAuth = new RequestAuth();
        ResponseAuth block = clientBuilder
                .build()
                .post()
                .uri(autenticar)
                .bodyValue(requestAuth)
                .retrieve()
                .bodyToMono(ResponseAuth.class)
                .block();

        return block.getToken();
    }

    public ResponseToken autenticacao() {
        RequestAuth token = RequestAuth.builder().client_id("client_id_noeeme")
                .api_key("036dbc65-d1e3-4070-ba99-d7b658fb216b").build();
        var retorno = clientBuilder.build()
                .post().uri(autenticar).bodyValue(token)
                .retrieve().bodyToMono(ResponseToken.class).block();

        log.info("AUTENTICACAO - O valor do Token é : " + retorno);

        return retorno;
    }

}
