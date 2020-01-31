package com.au.api.location.entity;

import com.au.api.location.domain.Place;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

import static com.au.utils.FileUtils.loadFileAsJsonObject;
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

        VenueResponse venueResponse = loadFileAsJsonObject("unit/foursquare/venues-response.json", VenueResponse.class);

        // When
        Collection<Place> places = VenueResponse.toLocation.apply(venueResponse);

        // Then
        assertThat(places, hasSize(30));
        assertThat(places, hasItem(trafalgarSquare));
    }

    @Test
    public void shouldMapBadVenuesResponseToPlaces() throws IOException {
        // Given
        VenueResponse badResponse = loadFileAsJsonObject("unit/foursquare/venues-bad-response.json", VenueResponse.class);

        // When
        Collection<Place> places = VenueResponse.toLocation.apply(badResponse);

        // Then
        assertThat(places, hasSize(0));
    }
}