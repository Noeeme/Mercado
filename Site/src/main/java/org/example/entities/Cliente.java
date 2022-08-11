package org.example.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Cliente {

    @Id
    private String cpf;
    private String nome;
    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Cartao> cartaoList;
}
