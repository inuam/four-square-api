package com.au.api.location.entity;

import com.au.api.location.domain.Place;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class VenueResponseTest {

    @Test
    public void shouldMapVenuesToPlaces() throws IOException {
        // Given
        Place trafalgarSquare = Place.newPlace()
                .withPlaceName("Trafalgar Square")
                .withCity("London")
                .withState("Greater London")
                .withPostalCode("WC2N 5DX")
                .build();

        VenueResponse venueResponse = loadFileAsJson("unit/foursquare/venues-response.json");

        // When
        Collection<Place> places = VenueResponse.toLocation.apply(venueResponse);

        // Then
        assertThat(places, hasSize(30));
        assertThat(places, hasItem(trafalgarSquare));
    }

    @Test
    public void shouldMapBadVenuesResponseToPlaces() throws IOException {
        // Given
        VenueResponse badResponse = loadFileAsJson("unit/foursquare/venues-bad-response.json");

        // When
        Collection<Place> places = VenueResponse.toLocation.apply(badResponse);

        // Then
        assertThat(places, hasSize(0));
    }

    private VenueResponse loadFileAsJson(String filePath) throws IOException {
        return new ObjectMapper().readValue(IOUtils.toString(FileUtils.class.getClassLoader().getResourceAsStream(filePath), Charset.defaultCharset()), VenueResponse.class);
    }
}