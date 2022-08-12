package org.example.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Cliente {

    @Id
    private Long cpf;
    private String nome;
    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Cartao> cartaoList;
}
