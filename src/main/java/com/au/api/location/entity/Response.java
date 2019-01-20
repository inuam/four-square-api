package com.au.api.location.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venues",
    "confident"
})
public class Response {

    @JsonProperty("venues")
    private List<Venue> venues = new ArrayList<>();
    @JsonProperty("confident")
    private Boolean confident;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("venues")
    public List<Venue> getVenues() {
        return venues;
    }

    @JsonProperty("venues")
    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    @JsonProperty("confident")
    public Boolean getConfident() {
        return confident;
    }

    @JsonProperty("confident")
    public void setConfident(Boolean confident) {
        this.confident = confident;
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
