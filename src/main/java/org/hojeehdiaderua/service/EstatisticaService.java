package org.hojeehdiaderua.service;

import org.hojeehdiaderua.estatistica.MesRua;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class EstatisticaService {

    @Autowired
    private LogradouroDataRepository logradouroDataRepository;

    public List<Long> estatisticaAnualRuasPorAno() {
        List<Long> result = newArrayList();

        List<MesRua> ruasPorAno = logradouroDataRepository.estatisticaAnualRuasPorAno();

        IntStream
                .rangeClosed(1, 12)
                .forEach(i -> result.add(findMonthOfZero(ruasPorAno)));

        return result;
    }

    private Long findMonthOfZero(List<MesRua> ruasPorAno) {
        return null;
    }


}
