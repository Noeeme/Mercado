package org.example.service;

import org.example.dto.request.RequestRetornoRabbit;
import org.example.dto.response.ResponseBancoPagamento;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${custom.rabbit-payment-queue}")
    private String retornoPagamentoQueue;

    public void enviaRetornoDePagamentoParaQueue(Long id, ResponseBancoPagamento response) {
        RequestRetornoRabbit request = new RequestRetornoRabbit(id, response.getStatus());
        enviaRetornoPagamento(request);
    }

    private void enviaRetornoPagamento(RequestRetornoRabbit request) {
        rabbitTemplate.convertAndSend(retornoPagamentoQueue, request);
    }
}
