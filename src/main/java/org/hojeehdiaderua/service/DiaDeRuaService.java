package org.hojeehdiaderua.service;

import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaDeRuaService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    public List<LogradouroData> obterDia(byte dia, byte mes) {
        return logradouroDataRepository.findByDiaMes(dia, mes);
    }

}
