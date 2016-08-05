<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppEstatisticas">
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
	    <script src="https://code.highcharts.com/highcharts.js"></script>
	    <script src="resources/scripts/hojeehdiaderua-estatisticas.js"></script>
        <title>Hoje é Dia de Rua! - Estatísticas</title>
    </head>
    <body ng-controller="diaDeRuaStatController">
        <h1>Hoje é Dia de Rua! - Estatísticas</h1>

        {{estatisticasAnuais}}
        <!-- <div id="container" style="width: 70%">Placeholder for chart</div> -->
    </body>
</html>