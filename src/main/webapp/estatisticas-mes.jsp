<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <p>Quantidade de Cidades: {{quantidadeDeCidades}}</p>
        <p>{{dados.resultado.ruasPorDia}}</p>
        <highchart id="graficoRuasPorMes" config="ruasPorMes" style="width:75%"></highchart>
        <highchart id="graficoRuasPorUF" config="ruasPorUF" style="width:75%"></highchart>
        <highchart id="graficoRuasPorDia" config="ruasPorDia" style="width:75%"></highchart>