package org.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CheckoutDtoResponse {
    private Long numeroPedido;
    private Double total;
    private String status;
    private List<CheckoutItensResponse> itens;
}
