package com.sprint.sprint5.dtos.request;

import com.sprint.sprint5.models.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Data
public class RequestPedidoDTO {

    @CPF
    private String cpf;
    @NotNull
    private RequestPagamentoDto pagamento;
    @NotNull
    @Size(min = 1)
    private List<Pedido_itens> itens;
    @NotNull
    private double total;
}
