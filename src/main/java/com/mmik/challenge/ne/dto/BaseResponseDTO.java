package com.mmik.challenge.ne.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mmki on 19/02/2017.
 */
public class BaseResponseDTO {
    @JsonProperty("Response")
    private Boolean response;

    public Boolean isResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }
}
