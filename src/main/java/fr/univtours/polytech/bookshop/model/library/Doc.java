
package fr.univtours.polytech.bookshop.model.library;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author_key",
    "author_name",
    "cover_i",
    "ratings_count",
    "ratings_average",
    "first_sentence",
    "title"
})
@Generated("jsonschema2pojo")
public class Doc {

    @JsonProperty("author_key")
    private List<String> author_key;
    @JsonProperty("author_name")
    private List<String> author_name;
    @JsonProperty("cover_i")
    private Integer cover_i;
    @JsonProperty("ratings_count")
    private Integer ratings_count;
    @JsonProperty("ratings_average")
    private Double ratings_average;
    @JsonProperty("first_sentence")
    private List<String> first_sentence;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("author_key")
    public List<String> getAuthor_key() {
        return author_key;
    }

    @JsonProperty("author_key")
    public void setAuthor_key(List<String> author_key) {
        this.author_key = author_key;
    }

    @JsonProperty("author_name")
    public List<String> getAuthor_name() {
        return author_name;
    }

    @JsonProperty("author_name")
    public void setAuthor_name(List<String> author_name) {
        this.author_name = author_name;
    }

    @JsonProperty("cover_i")
    public Integer getCover_i() {
        return cover_i;
    }

    @JsonProperty("cover_i")
    public void setCover_i(Integer cover_i) {
        this.cover_i = cover_i;
    }

    @JsonProperty("ratings_count")
    public Integer getRatings_count() {
        return ratings_count;
    }

    @JsonProperty("ratings_count")
    public void setRatings_count(Integer ratings_count) {
        this.ratings_count = ratings_count;
    }

    @JsonProperty("ratings_average")
    public Double getRatings_average() {
        return ratings_average;
    }

    @JsonProperty("ratings_average")
    public void setRatings_average(Double ratings_average) {
        this.ratings_average = ratings_average;
    }

    @JsonProperty("first_sentence")
    public List<String> getFirst_sentence() {
        return first_sentence;
    }

    @JsonProperty("first_sentence")
    public void setFirst_sentence(List<String> first_sentence) {
        this.first_sentence = first_sentence;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
