package com.sprint.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestBancoDto {

    @JsonProperty("seller_id")
    private String sellerId;
    private Customer customer;

    @JsonProperty("payment_type")
    private String paymentType;
    private String currency;

    @JsonProperty("transaction_amount")
    private double transactionAmount;

    @JsonProperty("card")
    private Cartao cartao;

}
