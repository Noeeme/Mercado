package com.sprint.sprint5.producer;

import com.sprint.sprint5.models.Pedido;
import com.sprint.sprint5.models.Pedido_Pagamento;
import com.sprint.sprint5.models.Status;
import com.sprint.sprint5.repositories.PedidoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Produtor {
    @Autowired
    private PedidoRepository pedidoRepository;

    public static final String QUEUE = "Fila_pedido";

    @RabbitListener(queues = QUEUE)
    public void consumidor(Pedido_Pagamento pedidoPagamento){
        if(pedidoPagamento != null){
            salvarPagamento(pedidoPagamento);
        }
    }

    public void salvarPagamento(Pedido_Pagamento pedidoPagamento){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoPagamento.getId());
        pedido.setStatus(Status.EM_ANDAMENTO);

        pedidoRepository.save(pedido);
    }
}
