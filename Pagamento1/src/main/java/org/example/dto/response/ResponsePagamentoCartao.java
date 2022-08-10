package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePagamentoCartao {
    private Long id;
    private String cartaoNum;
    private String cartaoNome;
    private String codigo;
    private String marca;
    private String mes;
    private String ano;
    private String moeda;
    private Double valor;
}
