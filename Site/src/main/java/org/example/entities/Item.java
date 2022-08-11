package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "skuid"))
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime dataValidade;
    private double valor;
    private String descricao;
    private int estoque;
    private String skuid;
}
