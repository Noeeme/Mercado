package com.sprint.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

@Data
public class Cartao {
    @JsonProperty("number_token")
    private String numberToken;
    @JsonProperty("cardholder_name")
    private String cardholderName;
    @JsonProperty("security_code")
    private String securityCode;
    private String brand;
    @JsonProperty("expiration_month")
    private String expirationMonth;
    @JsonProperty("cexpiration_year")
    private String expirationYear;
}
