package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.entities.Location;
import org.hojeehdiaderua.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService service;

    @GetMapping("/country/{code}/today")
    public @ResponseBody
    List<Location> getTodayLocationsByCountry(@PathVariable String code) {
        return service.getTodayLocations(code);
    }

    @GetMapping("/country/{code}/day/{day}/month/{month}")
    public @ResponseBody
    List<Location> getLocationsByCountry(@PathVariable String code, @PathVariable int day, @PathVariable int month) {
        return service.getLocationByDayAndMonth(code, day, month);
    }

}
