package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.LogradouroData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@RepositoryDefinition(
        domainClass=org.hojeehdiaderua.entities.LogradouroData.class,
        idClass=java.lang.Long.class)
public interface LogradouroDataRepository extends JpaRepository<LogradouroData, Long> {
}
