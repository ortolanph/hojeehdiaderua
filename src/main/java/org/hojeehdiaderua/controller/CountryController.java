package org.hojeehdiaderua.controller;

import lombok.extern.slf4j.Slf4j;
import org.hojeehdiaderua.entities.Country;
import org.hojeehdiaderua.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/countries")
@Slf4j
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    private @ResponseBody
    List<Country> all() {
        log.info("COUNTRIES: ALL");
        return service.all();
    }

    @GetMapping("{id}")
    private @ResponseBody
    Country findById(@PathVariable("id") long id) {
        log.info("COUNTRIES: BY ID");
        return service.findById(id).orElse(null);
    }

    @GetMapping("/code/{code}")
    private @ResponseBody
    Country findByCode(@PathVariable("code") String code) {
        log.info("COUNTRIES: BY COUNTRY CODE");
        return service.findByCode(code).orElse(null);
    }

    @PostMapping
    private void createCountry(@RequestBody Country country) {
        log.info("COUNTRIES: CREATE");
        service.save(country);
    }

    @PutMapping("{id}")
    private @ResponseBody Country saveCountry(@PathVariable long id, @RequestBody Country country) {
        log.info("COUNTRIES: UPDATE");
        return service.updateCountryById(id, country);
    }

    @PutMapping("/code/{code}")
    private @ResponseBody Country saveCountry(@PathVariable String code, @RequestBody Country country) {
        log.info("COUNTRIES: UPDATE BY COUNTRY CODE");
        return service.updateCountryByCode(code, country);
    }

    @DeleteMapping("{id}")
    private void deleteCountryById(@PathVariable long id) {
        log.info("COUNTRIES: DELETE");
        service.deleteCountryById(id);
    }

    @DeleteMapping("/code/{code}")
    private void deleteCountryByCode(@PathVariable String code) {
        log.info("COUNTRIES: DELETE BY COUNTRY CODE");
        service.deleteCountryByCode(code);
    }
}
