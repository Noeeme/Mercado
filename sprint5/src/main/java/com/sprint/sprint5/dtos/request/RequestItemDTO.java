package com.sprint.sprint5.dtos.request;

import com.sprint.sprint5.models.Pedido_itens_ofertas;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RequestItemDTO {

    @NotBlank
    private String nome;
    @CreationTimestamp
    private LocalDateTime dataCriação;
    private LocalDateTime dataValidade;
    @NotNull
    private double valor;
    @NotBlank
    private String descrição;
    private List<Pedido_itens_ofertas> ofertas;
}
