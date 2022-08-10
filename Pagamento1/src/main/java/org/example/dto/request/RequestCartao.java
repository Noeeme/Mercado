package org.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCartao {

    @NotBlank
    @JsonProperty("number_token")
    private String tokenNum;
    @NotBlank
    @JsonProperty("cardholder_name")
    private String nomeCartao;
    @NotBlank
    @JsonProperty("security_code")
    private String segurancaCod;
    @NotBlank
    @JsonProperty("brand")
    private String marca;
    @NotBlank
    @JsonProperty("expiration_month")
    private String mesExpiracao;
    @NotBlank
    private String anoExpiracao;
}
