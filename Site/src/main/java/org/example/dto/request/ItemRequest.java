package org.example.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private String nome;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataValidade;
    @NotNull
    @Positive
    private double valor;
    @NotBlank
    private String descricao;
    @NotNull
    @Positive
    private int estoque;
}
