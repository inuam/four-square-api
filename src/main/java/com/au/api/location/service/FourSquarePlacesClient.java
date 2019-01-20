package com.au.api.location.service;

import com.au.api.location.LocationPaths;
import com.au.api.location.entity.VenueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FourSquarePlacesClient {

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    private final LocationPaths locationPaths;

    public FourSquarePlacesClient(RestTemplate restTemplate, LocationPaths locationPaths) {
        this.restTemplate = restTemplate;
        this.locationPaths = locationPaths;
    }

    public ResponseEntity<VenueResponse> getPlacesByName(String placeName) {
        return restTemplate.getForEntity(locationPaths.getVenuesUrl(placeName), VenueResponse.class);
    }
}
