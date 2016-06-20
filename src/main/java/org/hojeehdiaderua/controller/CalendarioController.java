package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Execucao;
import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.repositories.LogradouroDataRepository;
import org.hojeehdiaderua.utils.ExecucaoManager;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/admin/*",
        produces = {"application/json;charset=UTF-8"})
public class CalendarioController {

    @Autowired
    private LogradouroDataRepository repository;

    private ExecucaoManager execucaoManager;

    private ResultadoUtil<Execucao> resultadoUtil;

    @RequestMapping(value = "/processaDiaAtual", method = RequestMethod.POST)
    public
    @ResponseBody
    Resultado<Execucao> obtemDiaAtual() {
        LocalDate hoje = LocalDate.now();

        return obterDia(hoje.getDayOfMonth(), hoje.getMonthValue());
    }

    @RequestMapping(value = "/processaDia/{dia}/{mes}", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> obterDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        Execucao execucao = obterInformacoesDia(dia, mes);

        resultadoUtil = new ResultadoUtil<>();

        return resultadoUtil.comSucesso(execucao);
    }

    @RequestMapping(value = "/limpaBase", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> limpaBase() {
        resultadoUtil = new ResultadoUtil<>();

        execucaoManager = new ExecucaoManager();

        execucaoManager.adicionaLog("Contagem de registros antes de deletar tudo: " + repository.count());
        execucaoManager.adicionaLog("Deletando tudo");
        repository.deleteAll();
        execucaoManager.adicionaLog("Contagem de registros após deletar tudo: " + repository.count());

        execucaoManager.finalizaExecucao();

        return resultadoUtil.comSucesso(execucaoManager.obtemRelatorioExecucao());
    }

    @RequestMapping(value = "/limpaDia/{dia}/{mes}", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> limpaDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        resultadoUtil = new ResultadoUtil<>();

        execucaoManager = new ExecucaoManager();

        execucaoManager.adicionaLog("Contagem de registros antes de deletar registros: " + repository.count());
        execucaoManager.adicionaLog("Deletando registros do dia " + dia + "/" + mes);
        LogradouroData logradouroData = new LogradouroData();
        logradouroData.setDia(dia.byteValue());
        logradouroData.setMes(mes.byteValue());

        repository.delete(logradouroData);
        execucaoManager.adicionaLog("Contagem de registros após deletar registros: " + repository.count());

        execucaoManager.finalizaExecucao();

        return resultadoUtil.comSucesso(execucaoManager.obtemRelatorioExecucao());
    }

    @RequestMapping(value = "/adicionaFestividade", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    Resultado<Execucao> insereFestividade() {
        return null;
    }

    @RequestMapping(value = "/adicionaFestividade/{dia}/{mes}", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> listaFestividades(@PathVariable Integer dia, @PathVariable Integer mes) {
        return null;
    }

    private Execucao obterInformacoesDia(Integer dia, Integer mes) {
        execucaoManager = new ExecucaoManager();

        execucaoManager.criarNovaExecucao();

        execucaoManager.adicionaLog("Some information here");

        execucaoManager.finalizaExecucao();

        return execucaoManager.obtemRelatorioExecucao();
    }
}
