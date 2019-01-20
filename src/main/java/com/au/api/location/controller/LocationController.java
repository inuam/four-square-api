package com.au.api.location.controller;

import com.au.api.location.domain.Place;
import com.au.api.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(path="/place/search", method = GET, produces = "application/json")
    public ResponseEntity<Collection<Place>> places(@RequestParam(value = "placeName") String placeName) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(locationService.findPlace(placeName));
    }

}
