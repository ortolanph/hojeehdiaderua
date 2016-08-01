<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppAdmin">
    <head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
		<script src="../resources/scripts/hojeehdiaderua-admin.js"></script>
        <title>Hoje é Dia de Rua! - Admin</title>
    </head>
    <body ng-controller="diaDeRuaAdminController">
        <h1>Hoje é Dia de Rua! - Admin</h1>

        <p><a href="" ng-click="logout()">logout</a></p>

        <fieldset>
            <legend>Processa dia atual</legend>
            <form ng-submit="processaDiaAtual()">
                <input type="submit" value="Processa dia atual" />
            </form>
            <details>
                <summary>Log</summary>
                <p>Início: {{logProcessaDiaAtual.resultado.timestampInicial}}</p>
                <p>Fim: {{logProcessaDiaAtual.resultado.timestampFinal}}</p>
                <p ng-repeat="log in logProcessaDiaAtual.resultado.log">{{log}}</p>
                <p ng-hide="logProcessaDiaAtual.resultado.log.length">Nenhum log no momento</p>
            </details>
        </fieldset>

        <fieldset>
            <legend>Processa outro dia</legend>

            <form ng-submit="processaDia()">
                Dia: <input type="number" min="1" max="31" step="1" ng-model="dia" /><br/>
                Mês: <input type="number" min="1" max="12" step="1" ng-model="mes" /><br/>
                <input type="submit" value="Processa informações para dia {{dia}}/{{mes}}" />
            </form>

            <details>
                <summary>Log</summary>
                <p>Início: {{logProcessaDia.resultado.timestampInicial}}</p>
                <p>Fim: {{logProcessaDia.resultado.timestampFinal}}</p>
                <p ng-repeat="log in logProcessaDia.resultado.log">{{log}}</p>
                <p ng-hide="logProcessaDia.resultado.log.length">Nenhum log no momento</p>
            </details>
        </fieldset>
    </body>
</html>