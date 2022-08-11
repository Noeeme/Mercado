package org.example.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CheckoutClientesRequest {
    @NotBlank
    @CPF
    private String clientId;
    @Positive
    @NotNull
    private Long cartaoId;
}
