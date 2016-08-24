<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppEstatisticas">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
	    <script src="https://code.highcharts.com/highcharts.js"></script>
	    <script src="resources/scripts/highcharts-ng.js"></script>
	    <script src="resources/scripts/hojeehdiaderua-estatisticas.js"></script>
        <title>Hoje é Dia de Rua! - Estatísticas</title>
    </head>
    <body ng-controller="diaDeRuaStatController">
        <h1>Hoje é Dia de Rua! - Estatísticas</h1>
        <p>Quantidade de Ruas: {{quantidadeDeRuas}}</p>
        <p>Quantidade de Cidades: {{quantidadeDeCidades}}</p>
        <p>ruasPorMes: {{ruasPorMes}}</p>
        <p>ruasPorUF: {{ruasPorUF}}</p>
        <p>ruasPorDia: {{ruasPorDia}}</p>
        <highchart id="graficoRuasPorMes" config="ruasPorMes" style="width:75%"></highchart>
    </body>
</html>