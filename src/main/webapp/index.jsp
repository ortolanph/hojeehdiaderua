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

            <h2>Existem ruas com essa data em:</h2>
            <div id="cidade">
                <p ng-repeat="localidade in diaderua.resultado.localidades">
                    <span>
                        <a
                            href="https://www.google.com/maps/@{{localidade.latitude}},{{localidade.longitude}},19z"
                            target="_blank">
                            {{localidade.cidade}} - {{localidade.uf}}
                        </a>
                    </span>
                </p>
            </div>
            <p ng-hide="diaderua.resultado.localidades.length">Infelizmente nenhuma cidade decidiu batizar uma rua com essa data...</p>
        </div>

        <div id="rodape">
            <h3>Sobre</h3>
            <p>Este site foi construído por <a href="mailto:paulo.ortolan@gmail.com">Paulo Henrique Ortolan</a>.</p>
            <p>Layout por <a href="mailto:teste.teste@gmail.com">Fabio Luis Ortolan</a>.</p>

            <p>Outros projetos:</p>
            <p><a href="http://randomweatherforecast.herokuapp.com/">Random Weather Forecast</a></p>
            <p><a href="http://mahousenshi.neocities.org/">Página de Fabio Ortolan</a></p>
        </div>
    </body>
</html>
