package org.hojeehdiaderua.service;

import org.hojeehdiaderua.entities.Location;
import org.hojeehdiaderua.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public List<Location> getTodayLocations(String code) {
        LocalDate today = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        return getLocationByDayAndMonth(code, today.getDayOfMonth(), today.getMonthValue() - 1);
    }

    public List<Location> getLocationByDayAndMonth(String code, int day, int month) {
        return repository.findByDayAndMonthAndCountryCode(day, month, code);
    }
}
