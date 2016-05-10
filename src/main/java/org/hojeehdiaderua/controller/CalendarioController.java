package org.hojeehdiaderua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/*",
        produces = {"application/json;charset=UTF-8"})
public class CalendarioController {

    @RequestMapping(value = "/processaDiaAtual", method = RequestMethod.GET)
    public int obtemDiaAtual() {
        return 0;
    }

    @RequestMapping(value = "/processaDia/{dia}/{mes}", method = RequestMethod.GET)
    public int obtemDiaAtual(@PathVariable Integer dia, @PathVariable Integer mes) {
        return 0;
    }

    @RequestMapping(value = "/limpaBase", method = RequestMethod.GET)
    public int limpaBase() {
        return 0;
    }

    @RequestMapping(value = "/limpaDia/{dia}/{mes}", method = RequestMethod.GET)
    public int limpaDia(@PathVariable Integer dia, @PathVariable Integer mes) {
        return 0;
    }
}
