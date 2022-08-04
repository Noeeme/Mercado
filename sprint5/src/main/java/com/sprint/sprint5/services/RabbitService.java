package com.sprint.sprint5.services;


import com.sprint.sprint5.dtos.PagamentoDto;
import com.sprint.sprint5.dtos.response.ResponsePedidoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(ResponsePedidoDTO mensagem) {
        PagamentoDto pagamentoDto = new PagamentoDto();
        pagamentoDto.setId(mensagem.getId());
        pagamentoDto.setTotal(mensagem.getTotal());

        String routingKey = "Fila_pedido";
        rabbitTemplate.convertAndSend(routingKey, pagamentoDto);
    }
}
