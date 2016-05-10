package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.LogradouroData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogradouroDataRepository extends JpaRepository<LogradouroData, Long> {
}
