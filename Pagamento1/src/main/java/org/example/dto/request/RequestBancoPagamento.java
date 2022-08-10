package org.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBancoPagamento {
    @NotBlank
    private String seller_id;
    @NotNull
    private RequestClient customer;
    @NotBlank
    @JsonProperty("payment_type")
    private String tipoPagamento;
    @NotBlank
    @JsonProperty("currency")
    private String moeda;
    @JsonProperty("transaction_amount")
    private double valor;
    @NotBlank
    private RequestCartao card;

}
