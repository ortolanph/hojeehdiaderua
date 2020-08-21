package org.hojeehdiaderua.service;

import org.hojeehdiaderua.entities.Country;
import org.hojeehdiaderua.entities.Location;
import org.hojeehdiaderua.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private CountryService countryService;

    public List<Location> getTodayLocations(String code) {
        Optional<Country> country = countryService.findByCode(code);
        LocalDate today = LocalDate.now(ZoneId.of(country.get().getTimezone()));
        return getLocationByDayAndMonth(code, today.getDayOfMonth(), today.getMonthValue());
    }

    public List<Location> getLocationByDayAndMonth(String code, int day, int month) {
        return repository.findByDayAndMonthAndCountryCode(day, month, code);
    }
}
