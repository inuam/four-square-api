package com.au.api.location.service;

import com.au.api.location.domain.Place;
import com.au.api.location.entity.VenueResponse;
import com.au.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collection;

import static com.au.utils.FileUtils.loadFileAsJsonObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private FourSquarePlacesClient fourSquarePlacesClient;

    @InjectMocks
    private LocationService classToTest;

    private ResponseEntity<VenueResponse> responseEntity;

    @Test
    public void shouldReturnAListOfPlacesWhenSearchingByName() throws IOException {
        // Given
        VenueResponse entity = loadFileAsJsonObject("unit/foursquare/venues-response.json", VenueResponse.class);
        givenAResponseEntityFor(HttpStatus.OK, entity);
        String placeName = "London";

        given(fourSquarePlacesClient.getPlacesByName(placeName)).willReturn(responseEntity);

        // When
        Collection<Place> actual = classToTest.findPlace(placeName);

        // Then
        assertThat(actual, hasSize(30));
    }

    @Test
    public void shouldReturnNoResultsWhenNoMatchesFoundFor_Place() {
        // Given
        givenAResponseEntityFor(HttpStatus.BAD_REQUEST, null);
        String placeName = "UNKNOWN";

        given(fourSquarePlacesClient.getPlacesByName(placeName)).willReturn(responseEntity);

        // When
        Collection<Place> actual = classToTest.findPlace(placeName);

        // Then
        assertThat(actual, hasSize(0));
    }

    private void givenAResponseEntityFor(HttpStatus statusCode, VenueResponse body) {
        responseEntity = new ResponseEntity<>(body, statusCode);
    }
}