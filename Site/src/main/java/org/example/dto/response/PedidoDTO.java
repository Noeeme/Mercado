package org.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    private String pedidoNum;
    private double total;
    private String status = "Em processamento";
    private List<PedidoItemDTO> itens;
}
