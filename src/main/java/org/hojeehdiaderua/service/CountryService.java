package org.hojeehdiaderua.service;

import org.hojeehdiaderua.entities.Country;
import org.hojeehdiaderua.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> all() {
        return repository.findAll();
    }

    public Optional<Country> findById(long id) {
        return repository.findById(id);
    }

    public Optional<Country> findByCode(String code) {
        return repository.findCountryByCode(code);
    }

    public void save(Country country) {
        repository.save(country);
    }

    public Country updateCountryById(long id, Country country) {
        Optional<Country> optionalCountry = findById(id);

        return updateCountry(country, optionalCountry);
    }

    public Country updateCountryByCode(String code, Country country) {
        Optional<Country> optionalCountry = findByCode(code);

        return updateCountry(country, optionalCountry);
    }

    public void deleteCountryById(long id) {
        Optional<Country> optionalCountry = findById(id);
        deleteCountry(optionalCountry);
    }

    public void deleteCountryByCode(String code) {
        Optional<Country> optionalCountry = findByCode(code);
        deleteCountry(optionalCountry);
    }

    private Country updateCountry(Country newCountry, Optional<Country> optionalOldCountry) {
        if (optionalOldCountry.isPresent()) {
            Country oldCountry = optionalOldCountry.get();

            oldCountry.setName(newCountry.getName() != null ? newCountry.getName() : oldCountry.getName());
            oldCountry.setCode(newCountry.getCode() != null ? newCountry.getCode() : oldCountry.getCode());
            oldCountry.setTimezone(newCountry.getTimezone() != null ? newCountry.getTimezone() : oldCountry.getTimezone());

            return repository.save(oldCountry);
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }

    private void deleteCountry(Optional<Country> optionalCountry) {
        if (optionalCountry.isPresent()) {
            repository.delete(optionalCountry.get());
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }
}
