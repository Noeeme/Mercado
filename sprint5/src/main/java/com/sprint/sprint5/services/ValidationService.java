package com.sprint.sprint5.services;

import com.sprint.sprint5.dtos.request.RequestPedidoDTO;
import com.sprint.sprint5.exceptions.pedido.MarcaInvalida;
import com.sprint.sprint5.exceptions.pedido.TipoPagamentoInvalido;
import com.sprint.sprint5.models.Status;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ValidationService {
    public void validaTipoPagamento(RequestPedidoDTO requestPedidoDTO){
        boolean valido = Arrays.stream(Status.values()).anyMatch(tipo -> tipo.getValor().equals(requestPedidoDTO.getPagamento()));

        if(!valido){
            throw new TipoPagamentoInvalido();
        }
    }

    public void validaMarca(RequestPedidoDTO requestPedidoDTO){
        boolean valido = Arrays.stream(Status.values()).anyMatch(marca -> marca.getValor().equals(requestPedidoDTO.getPagamento().getMarca()));

        if(!valido){
            throw new MarcaInvalida();
        }
    }
}
