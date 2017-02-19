package com.mmik.challenge.ne.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmik.challenge.ne.dto.enumTypes.ImDbType;

/**
 * Created by mmik on 19/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OmDetailsDTO extends BaseResponseDTO {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imDbId;

    @JsonProperty("Type")
    private ImDbType type;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("imdbRating")
    private String rating;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImDbId() {
        return imDbId;
    }

    public void setImDbId(String imDbId) {
        this.imDbId = imDbId;
    }

    public ImDbType getType() {
        return type;
    }

    public void setType(ImDbType type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "OmDetailsDTO{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imDbId='" + imDbId + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", plot='" + plot + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", rating='" + rating + '\'' +
                ", response='" + isResponse() + '\'' +
                '}';
    }
}
