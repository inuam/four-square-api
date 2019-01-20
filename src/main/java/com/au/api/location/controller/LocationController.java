package com.au.api.location.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api")
public class LocationController {

    @RequestMapping(path="/place", method = GET, produces = "application/json")
    public String place(@RequestParam(value="name") String name) {
        return "Hello World";
    }

}
