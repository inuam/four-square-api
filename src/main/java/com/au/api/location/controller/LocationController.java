package com.au.api.location.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/venues")
public class LocationController {

    @RequestMapping(path="/search", method = GET, produces = "application/json")
    public String search(@RequestParam(value="query") String query) {
        return "Hello World";
    }

}
