package org.example.entities;

import lombok.Data;

@Data
public class Cartao {

    private String numero;
    private int cod;
    private String mesValidade;
    private String anoValidade;
    private String marca;

}
