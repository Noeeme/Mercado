package com.sprint.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.dto.request.RequestAuth;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;

@Data
public class ResponseAuth {

    WebClient.Builder builder = WebClient.builder();
    @JsonProperty("acess_token")
    private String acessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private int expiresIn;

    public ResponseAuth autentica(){
        RequestAuth requestAuth = new RequestAuth();

        String urlAtenticacao = "https://pb-getway-payment.herokuapp.com/v1/auth";

        return builder.build()
                .post()
                .uri(urlAtenticacao)
                .bodyValue(requestAuth)
                .retrieve()
                .bodyToMono(ResponseAuth.class)
                .block();
    }
}
