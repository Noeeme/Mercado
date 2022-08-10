package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBancoPagamento {

    @JsonProperty("payment_id")
    private String pagamentoId;
    @JsonProperty("seller_id")
    private String seller_id;
    @JsonProperty("transaction_amount")
    private Double valor;
    @JsonProperty("currency")
    private String moeda;
    @JsonProperty("status")
    private String status;
    @JsonProperty("received_at")
    private LocalDateTime recebidoEm;
    @JsonProperty("authorization")
    private ResponseProcessoPagamento autorizacao;
}
