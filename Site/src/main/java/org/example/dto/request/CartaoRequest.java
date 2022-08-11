package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoRequest {

    @NotBlank
    private String numero;
    @NotBlank
    private int cod;
    @NotBlank
    private String mesValidade;
    @NotBlank
    private String anoValidade;
    @NotBlank
    private String marca;
}
