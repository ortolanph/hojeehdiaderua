package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByDayAndMonthAndCountryCode(int day, int month, String countryCode);

}
