package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.service.EstatisticaService;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/estatistica/*",
        produces = {"application/json;charset=UTF-8"})
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    private ResultadoUtil<List<Long>> resultadoUtil;

    @GetMapping("/mensal/{mes}")
    public
    @ResponseBody
    String getEstatisticasMensais(@PathVariable Integer mes) {
        return null;
    }

    @GetMapping("/anual")
    public
    @ResponseBody
    Resultado<List<Long>> getEstatisticasAnuais() {
        resultadoUtil = new ResultadoUtil<>();

        List<Long> dados = service.estatisticaAnualRuasPorAno();

        return resultadoUtil.comSucesso(dados);
    }
}
