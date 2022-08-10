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
public class RequestClient {
    @NotBlank
    @JsonProperty("document_type")
    private String tipoDoc;
    @NotBlank
    @JsonProperty("document_number")
    private String NumeroDoc;
}
