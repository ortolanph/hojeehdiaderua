package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Execucao;
import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.beans.Status;
import org.hojeehdiaderua.utils.ExecucaoManager;
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

    private ExecucaoManager execucaoManager;

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

        Resultado<Execucao> execucaoResultado = new Resultado<>();
        execucaoResultado.setMensagem("Sucesso");
        execucaoResultado.setStatus(Status.SUCCESS);
        execucaoResultado.setResultado(execucao);

        return execucaoResultado;
    }

    @RequestMapping(value = "/limpaBase", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> limpaBase() {
        return null;
    }

    @RequestMapping(value = "/limpaDia/{dia}/{mes}", method = RequestMethod.GET)
    public
    @ResponseBody
    Resultado<Execucao> limpaDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        return null;
    }

    private Execucao obterInformacoesDia(Integer dia, Integer mes) {
        execucaoManager = new ExecucaoManager();

        execucaoManager.adicionaLog("");

        execucaoManager.finalizaExecucao();

        return execucaoManager.obtemRelatorioExecucao();
    }


}
