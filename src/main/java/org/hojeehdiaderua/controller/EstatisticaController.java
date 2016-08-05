package org.hojeehdiaderua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/estatistica/*",
        produces = {"application/json;charset=UTF-8"})
public class EstatisticaController {

    @GetMapping("/mensal/{mes}")
    public
    @ResponseBody
    String getEstatisticasMensais(@PathVariable Integer mes) {
        return null;
    }

    @GetMapping("/anual")
    public
    @ResponseBody
    String getEstatisticasAnuais(@PathVariable Integer mes) {
        return null;
    }
}
