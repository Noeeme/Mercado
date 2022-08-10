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
public class ResponseProcessoPagamento {
    @JsonProperty("authorization_code")
    private String autorizacaoCod;
    @JsonProperty("authorized_at")
    private String AutorizadoEm;
    @JsonProperty("reason_code")
    private String Cod;
    @JsonProperty("reason_message")
    private String mensagem;
}
