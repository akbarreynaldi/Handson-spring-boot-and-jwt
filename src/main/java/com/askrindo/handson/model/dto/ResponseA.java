package com.askrindo.handson.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseA {
    @JsonProperty("result")
    private ResponseACS result;
}
