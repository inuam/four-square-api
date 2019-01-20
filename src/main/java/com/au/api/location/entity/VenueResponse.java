package com.au.api.location.entity;


import com.au.api.location.domain.Place;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.function.Function;

import static com.au.api.location.domain.Place.newPlace;
import static java.util.stream.Collectors.toList;

public class VenueResponse {
    @JsonProperty("meta")
    private Meta meta;
    @JsonProperty("response")
    private Response response = new Response();

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }
    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }
    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }
    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
    }

    public static Function<Venue, Place> toAPlace = venue -> newPlace()
            .withPlaceName(venue.getName())
            .withCity(venue.getLocation().getCity())
            .withState(venue.getLocation().getState())
            .withPostalCode(venue.getLocation().getPostalCode())
            .build();

    public static Function<VenueResponse, Collection<Place>> toLocation = r ->
            r.response.getVenues().stream()
            .map(toAPlace)
            .collect(toList());
}
