package com.mmik.challenge.ne.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmik on 19/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmSearchResponseDTO extends BaseResponseDTO{

    @JsonProperty("Search")
    private List<OmDetailsDTO> search = new ArrayList<>();
    private String totalResults;

    public List<OmDetailsDTO> getSearch() {
        return search;
    }

    public void setSearch(List<OmDetailsDTO> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "OmSearchResponseDTO{" +
                "search=" + search +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + isResponse() + '\'' +
                '}';
    }
}
