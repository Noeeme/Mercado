package com.sprint.sprint5.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido_itens {

     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nome;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     @CreationTimestamp
     private LocalDateTime dataCriacao;
     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     private LocalDateTime dataValidade;
     private double valor;
     private String descricao;

     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "oferta_id")
     @Nullable
     private List<Pedido_itens_ofertas> ofertas;


}
