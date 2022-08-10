package com.sprint.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseAutorizacaoDto {
    @JsonProperty("authorization_code")
    private String authorizationCode;
    @JsonProperty("authorization_at")
    private String authorizationAt;
    @JsonProperty("reason_code")
    private String reasonCode;
    @JsonProperty("reason_message")
    private String reasonMessage;

}
