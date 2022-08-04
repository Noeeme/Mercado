package com.sprint.sprint5.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido_Pagamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numCartao;
    private Long codSeguranca;
    private Marca marca;
    private int anoValidade;
    private int mesValidade;
    private String moeda;
    private double valor;


}
