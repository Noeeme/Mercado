package com.sprint.sprint5.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class RequestPagamentoDto {

    @NotBlank
    private Long numCartao;
    @NotBlank
    private Long codSeguranca;
    @NotBlank
    private String marca;
    private int mesValidade;
    private int anoValidade;
    private String moeda;
    @NotNull
    private double valor;
}
