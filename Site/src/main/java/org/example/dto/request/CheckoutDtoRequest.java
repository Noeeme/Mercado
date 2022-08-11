package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDtoRequest {

    @OneToMany
    private List<@Valid CheckouItensRequest> itens;
    @NotNull
    private @Valid CheckoutClientesRequest cliente;
}
