package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.Festividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestividadeRepository extends JpaRepository<Festividade, Long> {
}
