package org.example.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.RabbitMqConfig;
import org.example.domain.PagamentoRequest;
import org.example.repositories.PagamentoRepository;
import org.example.service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class Consumidor {
    private final PagamentoService service;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void litenerRequestPaymentQueue(@Payload RequestDados dados){
        service.criarRequestPagamento(dados);
    }
}
