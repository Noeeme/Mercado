package org.example.dto.response;

import lombok.Data;

@Data
public class PedidoItemDTO {
    private String nome;
    private double valor;
    private int qtd;
}
