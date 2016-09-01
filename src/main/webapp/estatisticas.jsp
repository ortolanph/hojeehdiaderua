<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppEstatisticas">
    <head>
        <link href="resources/style/estatisticas.css" rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-resource.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-route.min.js"></script>
	    <script src="https://code.highcharts.com/highcharts.js"></script>
	    <script src="resources/scripts/highcharts-ng.js"></script>
	    <script src="resources/scripts/hojeehdiaderua-estatisticas.js"></script>
	    <link href="resources/style/hojeehdiaderua.css" rel="stylesheet" type="text/css" />
	    <link href="resources/style/estatisticas.css" rel="stylesheet" type="text/css" />
        <title>Hoje é Dia de Rua! - Estatísticas</title>
    </head>
    <body ng-controller="diaDeRuaStatController">
        <h1>Hoje é Dia de Rua! - Estatísticas</h1>
        <h2><a href="index.jsp">Voltar</a></h2>
        <nav>
             <div id="items">
                 <p><span><a href="#/mensal/1">Janeiro</a></span></p>
                 <p><span><a href="#/mensal/2">Fevereiro</a></span></p>
                 <p><span><a href="#/mensal/3">Março</a></span></p>
                 <p><span><a href="#/mensal/4">Abril</a></span></p>
                 <p><span><a href="#/mensal/5">Maio</a></span></p>
                 <p><span><a href="#/mensal/6">Junho</a></span></p>
                 <p><span><a href="#/mensal/7">Julho</a></span></p>
                 <p><span><a href="#/mensal/8">Agosto</a></span></p>
                 <p><span><a href="#/mensal/9">Setembro</a></span></p>
                 <p><span><a href="#/mensal/10">Outubro</a></span></p>
                 <p><span><a href="#/mensal/11">Novembro</a></span></p>
                 <p><span><a href="#/mensal/12">Dezembro</a></span></p>
                 <p><span><a href="#/anual">Anual</a></span></p>
            </div>
        </nav>
        <br/>
        <div ng-view />
    </body>
</html>