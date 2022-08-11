package org.example.dto.response;

import lombok.Data;

@Data
public class CartaoResponse {
    private String numero;
    private int cod;
    private String mesValidade;
    private String anoValidade;
    private String marca;
}
