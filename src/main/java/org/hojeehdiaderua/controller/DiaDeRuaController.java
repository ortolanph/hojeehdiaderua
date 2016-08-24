package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.beans.calendario.Calendario;
import org.hojeehdiaderua.beans.calendario.Localidade;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.service.DayOfWeekConverter;
import org.hojeehdiaderua.service.DiaDeRuaService;
import org.hojeehdiaderua.service.MonthConverter;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Controller
@RequestMapping(value = "/hojeehdiaderua/*",
        produces = {"application/json;charset=UTF-8"})
public class DiaDeRuaController {

    private static final DateTimeZone FUSO_HORARIO_SAO_PAULO = DateTimeZone.forID("America/Sao_Paulo");
    @Autowired
    private DayOfWeekConverter dayOfWeekConverter;
    @Autowired
    private MonthConverter monthConverter;
    @Autowired
    private DiaDeRuaService service;
    private ResultadoUtil<Calendario> resultadoUtil;

    @GetMapping(value = "/queRuaEhHoje")
    public
    @ResponseBody
    Resultado<Calendario> obterRuas() {
        LocalDate hoje = LocalDate.now(FUSO_HORARIO_SAO_PAULO.toTimeZone().toZoneId());

        List<LogradouroData> logradouroDatas = service.obterDia((byte) hoje.getDayOfMonth(), (byte) hoje.getMonth().getValue());

        Calendario calendario = new Calendario();

        calendario.setDia(hoje.getDayOfMonth());
        calendario.setAno(hoje.getYear());
        calendario.setMes(monthConverter.apply(hoje.getMonth()));
        calendario.setDiaSemana(dayOfWeekConverter.apply(hoje.getDayOfWeek()));

        List<Localidade> localidades = newArrayList();

        logradouroDatas.forEach(
                l -> localidades.add(
                        new Localidade(l.getCidade(), l.getUf(), l.getLatitude(), l.getLongitude())
                )
        );

        calendario.setLocalidades(localidades);

        List<String> festividades = new ArrayList<>();

        resultadoUtil = new ResultadoUtil<>();

        return resultadoUtil.comSucesso(calendario);
    }

}
