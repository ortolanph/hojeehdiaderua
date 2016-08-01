package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Execucao;
import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.service.CalendarioService;
import org.hojeehdiaderua.service.DiaDeRuaService;
import org.hojeehdiaderua.utils.ExecucaoManager;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/admin/*",
        produces = {"application/json;charset=UTF-8"})
public class CalendarioController {

    @Autowired
    private CalendarioService service;

    private ExecucaoManager execucaoManager;

    private ResultadoUtil<Execucao> resultadoUtil;


    @PostMapping(value="/processaDiaAtual")
    public
    @ResponseBody
    Resultado<Execucao> obtemDiaAtual() {
        LocalDate hoje = LocalDate.now();

        return obterDia(hoje.getDayOfMonth(), hoje.getMonthValue());
    }

    @GetMapping("/processaDia/{dia}/{mes}")
    public
    @ResponseBody
    Resultado<Execucao> obterDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        Execucao execucao = obterInformacoesDia(dia, mes);

        resultadoUtil = new ResultadoUtil<>();

        return resultadoUtil.comSucesso(execucao);
    }

    private Execucao obterInformacoesDia(Integer dia, Integer mes) {
        execucaoManager = new ExecucaoManager();

        execucaoManager.criarNovaExecucao();

        service.obterNomesDeRuas(dia, mes, execucaoManager);

        execucaoManager.finalizaExecucao();

        return execucaoManager.obtemRelatorioExecucao();
    }
}
