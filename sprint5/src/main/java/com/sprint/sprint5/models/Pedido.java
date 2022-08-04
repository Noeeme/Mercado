package com.sprint.sprint5.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;

    private Status status;

    private StatusPagamento statusPagamento;

    private TipoPagamento tipoPagamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id")
    private Pedido_Pagamento pagamento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_itens_id")
    private List<Pedido_itens> itens;
    private double total;

}
