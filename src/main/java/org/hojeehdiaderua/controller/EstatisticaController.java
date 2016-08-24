package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.beans.estatisticas.Estatisticas;
import org.hojeehdiaderua.service.EstatisticaService;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/estatistica/*",
        produces = {"application/json;charset=UTF-8"})
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    private ResultadoUtil<Estatisticas> resultadoUtil;

    @GetMapping("/mensal/{mes}")
    public
    @ResponseBody
    String getEstatisticasMensais(@PathVariable Integer mes) {
        return null;
    }

    @GetMapping("/anual")
    public
    @ResponseBody
    Resultado<Estatisticas> getEstatisticasAnuais() {
        resultadoUtil = new ResultadoUtil<>();

        Estatisticas dados = service.estatisticaAnual();

        return resultadoUtil.comSucesso(dados);
    }

    @GetMapping(value = "/dump", produces = {MediaType.TEXT_PLAIN_VALUE})
    public
    @ResponseBody
    String dump() {
        StringBuilder builder = new StringBuilder();

        service
                .all()
                .forEach(d -> builder.append(d));

        return builder.toString();
    }


}
