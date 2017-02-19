package com.mmik.challenge.ne.dto.enumTypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mmik on 19/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ImDbType {
    @JsonProperty("episode")
    EPISODE,
    @JsonProperty("game")
    GAME,
    @JsonProperty("movie")
    MOVIE,
    @JsonProperty("series")
    SERIES;


    // 2nd solution :
    /*
    EPISODE("episode"),
    GAME("game"),
    MOVIE("movie"),
    SERIES("series");

    private String type;
    ImDbType(String s) {
        this.type =  s;
    }

    @JsonValue
    public String toValue() {
        return type;
    }*/
}
