package com.sprint.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.dto.request.RequestAuth;
import com.sprint.dto.request.RequestBancoDto;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Data
public class ResponseBancoDto {

    WebClient.Builder builder = WebClient.builder();
    @JsonProperty("payment_id")
    private String paymentId;
    @JsonProperty("seller_id")
    private String sellerId;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("transaction_amount")
    private double transactionAmount;
    private String status;
    @JsonProperty("received_at")
    private LocalDateTime receivedAt;
    private ResponseAutorizacaoDto autorizacaoDto;

    public ResponseBancoDto autentica(){
        RequestBancoDto requestBancoDto = new RequestBancoDto();

        String urlPagamento = "https://pb-getway-payment.herokuapp.com/v1/payments/credit-card";

        return builder.build()
                .post()
                .uri(urlPagamento)
                .bodyValue(requestBancoDto)
                .headers(httpHeaders -> httpHeaders.setBearerAuth(new ResponseAuth().autentica().getAcessToken()))
                .retrieve()
                .bodyToMono(ResponseBancoDto.class)
                .block();
    }
}
