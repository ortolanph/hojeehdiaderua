<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppEstatisticas">
    <head>
        <link href="resources/style/estatisticas.css" rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
<!--        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-resource.min.js"></script> -->
<!--        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-route.min.js"></script> -->
	    <script src="https://code.highcharts.com/highcharts.js"></script>
	    <script src="resources/scripts/highcharts-ng.js"></script>
	    <script src="resources/scripts/hojeehdiaderua-estatisticas.js"></script>
        <title>Hoje é Dia de Rua! - Estatísticas</title>
    </head>
    <body ng-controller="diaDeRuaStatController">
        <h1>Hoje é Dia de Rua! - Estatísticas</h1>
<!--         <nav> -->
<!--             <div class="item"> -->
<!--                 <a href="#/mensal/1">Janeiro</a> -->
<!--                 <a href="#/mensal/2">Fevereiro</a> -->
<!--                 <a href="#/mensal/3">Março</a> -->
<!--                 <a href="#/mensal/4">Abril</a> -->
<!--                 <a href="#/mensal/5">Maio</a> -->
<!--                 <a href="#/mensal/6">Junho</a> -->
<!--                 <a href="#/mensal/7">Julho</a> -->
<!--                 <a href="#/mensal/8">Agosto</a> -->
<!--                 <a href="#/mensal/9">Setembro</a> -->
<!--                 <a href="#/mensal/10">Outubro</a> -->
<!--                 <a href="#/mensal/11">Novembro</a> -->
<!--                 <a href="#/mensal/12">Dezembro</a> -->
<!--                 <a href="#/anual">Anual</a> -->
<!--             </div> -->
<!--         </nav> -->
<!--         <br/> -->
<!--         <div ng-view /> -->

        <p>Quantidade de Ruas: {{quantidadeDeRuas}}</p>
        <p>Quantidade de Cidades: {{quantidadeDeCidades}}</p>
        <p>{{dados.resultado.ruasPorDia}}</p>
        <highchart id="graficoRuasPorMes" config="ruasPorMes" style="width:75%"></highchart>
        <highchart id="graficoRuasPorUF" config="ruasPorUF" style="width:75%"></highchart>
        <highchart id="graficoRuasPorDia" config="ruasPorDia" style="width:75%"></highchart>
    </body>
</html>