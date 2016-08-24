package org.hojeehdiaderua.repositories;

import org.hojeehdiaderua.entities.LogradouroData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(
        domainClass = org.hojeehdiaderua.entities.LogradouroData.class,
        idClass = java.lang.Long.class)
public interface LogradouroDataRepository extends JpaRepository<LogradouroData, Long> {

    @Query("SELECT l FROM LogradouroData l WHERE " +
            "l.dia = :dia and l.mes = :mes")
    List<LogradouroData> findByDiaMes(@Param("dia") byte dia, @Param("mes") byte mes);

    @Query("SELECT l FROM LogradouroData l WHERE " +
            "l.mes = :mes")
    List<LogradouroData> findByMes(@Param("mes") byte mes);

    @Query("SELECT l.dia FROM LogradouroData l WHERE " +
            "l.mes = :mes")
    List<Byte> listAllProcessedDaysInMonth(@Param("mes") byte mes);

}