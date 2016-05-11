package org.hojeehdiaderua.service;

import org.hojeehdiaderua.repositories.FestividadeRepository;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaDeRuaService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    @Autowired
    private FestividadeRepository festividadeRepository;

}
