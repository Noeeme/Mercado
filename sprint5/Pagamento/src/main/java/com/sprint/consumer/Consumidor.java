package com.sprint.consumer;

import com.sprint.model.Pagamento;
import com.sprint.rabbitMQ.PagamentoDto;
import com.sprint.repository.PagamentoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Consumidor {


    @Autowired
    private PagamentoRepository pagamentoRepository;

    public static final String QUEUE = "Fila_pedido";

    @RabbitListener(queues = QUEUE)
    public void consumidor(PagamentoDto pagamentoDto){
        if(pagamentoDto != null){
            salvarPagamento(pagamentoDto);
        }
    }

    public void salvarPagamento(PagamentoDto pagamentoDto){
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(pagamentoDto.getId());
        pagamento.setTotal(pagamentoDto.getTotal());

        pagamentoRepository.save(pagamento);
    }
}
