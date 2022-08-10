package com.sprint.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Customer {

    @JsonProperty("document_type")
    private String documentType;
    @JsonProperty("document_number")
    private String documentNumber;
}
