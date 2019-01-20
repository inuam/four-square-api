package com.au.api.location.service;

import com.au.api.location.LocationPaths;
import com.au.api.location.domain.Place;
import com.au.api.location.entity.VenueResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationPaths.class);

    @Autowired
    private final FourSquarePlacesClient fourSquarePlacesClient;

    public LocationService(FourSquarePlacesClient fourSquarePlacesClient) {
        this.fourSquarePlacesClient = fourSquarePlacesClient;
    }

    public Collection<Place> findPlace(String placeName) {

        ResponseEntity<VenueResponse> placesResponse = fourSquarePlacesClient.getPlacesByName(placeName);
        Collection<Place> places = new ArrayList<>();

        if (placesResponse.getStatusCode().equals(HttpStatus.OK)) {
            places = VenueResponse.toLocation.apply(placesResponse.getBody());
        }

        return places;
    }

}
