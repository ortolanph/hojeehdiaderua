package org.hojeehdiaderua.controller;

import org.hojeehdiaderua.beans.EstatisticasAnuais;
import org.hojeehdiaderua.beans.Resultado;
import org.hojeehdiaderua.entities.LogradouroData;
import org.hojeehdiaderua.service.EstatisticaService;
import org.hojeehdiaderua.utils.ResultadoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Controller
@RequestMapping(value = "/estatistica/*",
        produces = {"application/json;charset=UTF-8"})
public class EstatisticaController {

    @Autowired
    private EstatisticaService service;

    private ResultadoUtil<EstatisticasAnuais> resultadoUtil;

    @GetMapping("/mensal/{mes}")
    public
    @ResponseBody
    String getEstatisticasMensais(@PathVariable Integer mes) {
        return null;
    }

    @GetMapping("/anual")
    public
    @ResponseBody
    Resultado<EstatisticasAnuais> getEstatisticasAnuais() {
        resultadoUtil = new ResultadoUtil<>();

        EstatisticasAnuais dados = service.estatisticaAnualRuasPorMeses();

        return resultadoUtil.comSucesso(dados);
    }

    @GetMapping(value = "/dump", produces = {MediaType.TEXT_PLAIN_VALUE})
    public
    @ResponseBody
    String dump() {
        StringBuilder builder = new StringBuilder();

        service
                .all()
                .stream()
                .sorted((l1, l2) -> l1.getDia() - l2.getDia())
                .sorted((l1, l2) -> l1.getMes() - l2.getMes())
                .forEach(l -> builder.append(buildInsert(l)).append('\n'));

        return builder.toString();
    }

    private String buildInsert(LogradouroData logradouroData) {
        return String.format(Locale.ROOT, "insert into diaderua.logradourodata values (nextval('diaderua.seq_logdata'), %d, %d, '%s', '%s', %.10f, %.10f);",
                logradouroData.getDia(),
                logradouroData.getMes(),
                logradouroData.getCidade(),
                logradouroData.getUf(),
                logradouroData.getLatitude(),
                logradouroData.getLongitude());
    }
}
