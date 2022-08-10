package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PagamentoRequest {
    @JsonProperty("order_id")
    private Long pedidoId;
    private Double valor;
}
