package com.sprint.sprint5.dtos.response;

import com.sprint.sprint5.models.Pedido_itens;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePedidoDTO {

    private  Long id;
    private String cpf;
    private List<Pedido_itens> itens;
    private double total;

}
