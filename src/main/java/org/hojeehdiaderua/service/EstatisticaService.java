package org.hojeehdiaderua.service;

import org.hojeehdiaderua.beans.EstatisticasAnuais;
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

    public EstatisticasAnuais estatisticaAnualRuasPorMeses() {
        EstatisticasAnuais estatisticasAnuais = new EstatisticasAnuais();

        estatisticasAnuais.setRuasPorAno(getRuasPorAno());

        return estatisticasAnuais;
    }

    private List<Long> getRuasPorAno() {
        List<Long> result = newArrayList();

        List<MesRua> ruasPorAno = logradouroDataRepository.estatisticaAnualRuasPorMeses();

        IntStream
                .rangeClosed(1, 12)
                .forEach(i -> result.add(
                        getRuasPorMes(ruasPorAno, i)
                        )
                );

        return result;
    }

    private Long getRuasPorMes(List<MesRua> mesRuas, int mes) {
        return mesRuas.stream().filter(mr -> mr.getMes() == mes).findFirst().orElse(mesRuaZerado()).getRuas();
    }

    private MesRua mesRuaZerado() {
        return new MesRua() {
            @Override
            public byte getMes() {
                return 0;
            }

            @Override
            public long getRuas() {
                return 0;
            }
        };
    }

}
