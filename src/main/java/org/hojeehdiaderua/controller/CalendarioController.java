package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Execucao;
import org.hojeehdiaderua.beans.Resultado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin/*",
        produces = {"application/json;charset=UTF-8"})
public class CalendarioController {

    @RequestMapping(value = "/processaDiaAtual", method = RequestMethod.POST)
    public @ResponseBody
    Resultado<Execucao> obtemDiaAtual() {
        return null;
    }

    @RequestMapping(value = "/processaDia/{dia}/{mes}", method = RequestMethod.GET)
    public @ResponseBody
    Resultado<Execucao> obtemDiaAtual(@PathVariable Integer dia, @PathVariable Integer mes) {
        return null;
    }

    @RequestMapping(value = "/limpaBase", method = RequestMethod.GET)
    public @ResponseBody
    Resultado<Execucao> limpaBase() {
        return null;
    }

    @RequestMapping(value = "/limpaDia/{dia}/{mes}", method = RequestMethod.GET)
    public @ResponseBody
    Resultado<Execucao> limpaDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        return null;
    }
}
