package org.example.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.PagamentoBanco;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDados {
    private Long id;
    private String cpf;
    private Double total;
    private String tipo_pagamento;
    private PagamentoBanco pagamento;
}
