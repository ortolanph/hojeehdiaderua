package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.entities.Calendario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/hojeehdiaderua/*",
        produces = {"application/json;charset=UTF-8"})
public class DiaDeRuaController {

    @RequestMapping(value = "/queRuaEhHoje/{dia}/{mes}", method = RequestMethod.GET)
    public @ResponseBody Resultado<List<Calendario>> obterRuas(@PathVariable Integer dia, @PathVariable Integer mes) {
        return new Resultado();
    }

}
