package com.sprint.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Pagamento {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long pedidoId;
    @CreationTimestamp
    private LocalDateTime data;
    private double total;


}
