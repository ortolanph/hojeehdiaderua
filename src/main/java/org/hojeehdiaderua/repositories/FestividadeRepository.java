package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.Festividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@RepositoryDefinition(
        domainClass=org.hojeehdiaderua.entities.Festividade.class,
        idClass=java.lang.Long.class)
public interface FestividadeRepository extends JpaRepository<Festividade, Long> {
}
