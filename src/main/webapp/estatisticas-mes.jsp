<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <p>Quantidade de Ruas: {{quantidadeDeRuas}}</p>
        <p>Quantidade de Cidades: {{quantidadeDeCidades}}</p>
        <highchart id="graficoRuasPorUF" config="ruasPorUF" style="width:75%"></highchart>
        <highchart id="graficoRuasPorDia" config="ruasPorDia" style="width:75%"></highchart>