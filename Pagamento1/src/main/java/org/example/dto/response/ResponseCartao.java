package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCartao {
    @JsonProperty("number_token")
    private String tokenNum;
    @JsonProperty("cardholder_name")
    private String nomeCartao;
    @JsonProperty("security_code")
    private String SegurancaCod;
    @JsonProperty("brand")
    private String marca;
    @JsonProperty("expiration_month")
    private String mesExp;
    @JsonProperty("expiration_year")
    private String anoExp;
}
