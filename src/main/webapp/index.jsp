<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaApp">
    <head>
        <link href="resources/style/hojeehdiaderua.css" rel="stylesheet" type="text/css" />
		    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
		    <script src="resources/scripts/hojeehdiaderua.js"></script>
        <title>Hoje é Dia de Rua!</title>
    </head>
    <body ng-controller="diaDeRuaController">
        <h1>Hoje é Dia de Rua!</h1>
        <div id="corpo">
            <div id="calendario">
                <p>
                    <a href="https://pt.wikipedia.org/wiki/{{diaderua.resultado.dia}}_de_{{diaderua.resultado.mes}}" target="_blank">
                        {{diaderua.resultado.dia}}
                    </a>
                </p>
                <p>{{diaderua.resultado.mes}}</p>
                <p>{{diaderua.resultado.ano}}</p>
                <p>{{diaderua.resultado.diaSemana}}</p>
            </div>

            <p>Comemora-se nesse dia:</p>
            <p ng-repeat="festividade in diaderua.resultado.festividades" id="flavor">{{festividade}}</p>
            <p ng-hide="diaderua.resultado.festividades.length">Nenhuma festividade para esse dia triste</li>

            <h2>Existem ruas com essa data em:</h2>
            <div id="cidade">
                <p ng-repeat="localidade in diaderua.resultado.localidades"><span>{{localidade.cidade}} - {{localidade.uf}}</span></p>
            </div>
            <p ng-hide="diaderua.resultado.localidades.length">Infelizmente nenhuma cidade decidiu batizar uma rua com essa data...</p>
        </div>

        <div id="rodape">
            <h3>Sobre</h3>
            <p>Este site foi construído por <a href="mailto:manutcloud@gmail.com">Paulo Henrique Ortolan</a>.</p>
            <p>Layout por <a href="mailto:teste.teste@gmail.com">Fabio Luis Ortolan</a>.</p>
        </div>
    </body>
</html>
