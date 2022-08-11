package org.example.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemResponse {
    private Long id;
    private String nome;
    private LocalDateTime dataValidade;
    private double valor;
    private String descricao;
    private int estoque;
    private String skuid;
}
