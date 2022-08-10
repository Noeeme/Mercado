package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseAuth {

    @JsonProperty("access_token")
    private String token;
    @JsonProperty("token_type")
    private String tokenTipo;
    @JsonProperty("expires_in")
    private String expiraEm;
}
