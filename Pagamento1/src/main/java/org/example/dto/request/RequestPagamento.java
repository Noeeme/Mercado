package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.PagamentoModel;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPagamento {
    private Long id;
    private String cpf;
    private double total;
    private String tipoPagamento;
    private PagamentoModel pagamento;
}
