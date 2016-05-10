package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Calendario;
import org.hojeehdiaderua.beans.Localidade;
import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.beans.Status;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.service.DayOfWeekConverter;
import org.hojeehdiaderua.service.MonthConverter;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Controller
@RequestMapping(value = "/hojeehdiaderua/*",
        produces = {"application/json;charset=UTF-8"})
public class DiaDeRuaController {

    @Autowired
    private DayOfWeekConverter dayOfWeekConverter;

    @Autowired
    private MonthConverter monthConverter;

    @Autowired
    private LogradouroDataRepository repository;

    private ResultadoUtil<Calendario> resultadoUtil;

    @RequestMapping(value = "/queRuaEhHoje", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Calendario> obterRuas() {
        LocalDate hoje = LocalDate.now();

        // Aqui acontece a pesquisa (hoje.getDayOfMonth(), hoje.getMonth().getValue())

        Calendario calendario = new Calendario();

        calendario.setDia(hoje.getDayOfMonth());
        calendario.setAno(hoje.getYear());
        calendario.setMes(monthConverter.apply(hoje.getMonth()));
        calendario.setDiaSemana(dayOfWeekConverter.apply(hoje.getDayOfWeek()));

        List<Localidade> localidades = newArrayList();

        Localidade localidade = new Localidade();

        localidade.setCidade("São Paulo");
        localidade.setUf("SP");

        localidades.add(localidade);

        calendario.setLocalidades(localidades);

        resultadoUtil = new ResultadoUtil<>();

        return resultadoUtil.comSucesso(calendario);
    }

}
