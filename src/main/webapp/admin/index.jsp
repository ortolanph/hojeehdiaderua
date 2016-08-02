<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaAppAdmin">
    <head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
		<script src="../resources/scripts/hojeehdiaderua-admin.js"></script>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Hoje é Dia de Rua! - Admin</title>
    </head>
    <body ng-controller="diaDeRuaAdminController">
        <div class="container">
            <h1>Hoje é Dia de Rua! - Admin</h1>

            <p><a href="" ng-click="logout()">logout</a></p>

            <fieldset>
                <legend>Dias processados no mês</legend>
                <table class="table">
                    <tbody>
                        <tr>
                            <td ng-repeat="dia in diasProcessados">{{dia}}</td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>

            <fieldset>
                <legend>Processa dia atual</legend>
                <form role="form" ng-submit="processaDiaAtual()">
                    <input type="submit" class="btn btn-default" value="Processa dia atual" />
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
                <form role="form" ng-submit="processaDia()">
                    <div class="form-group">
                        <label for="dia">Dia</label>
                        <input type="number" class="form-control" id="dia" min="1" max="31" step="1" ng-model="dia" placeholder="Dias (1-31)"/>
                    </div>
                    <div class="form-group">
                        <label for="mes">Mês</label>
                        <input type="number" class="form-control" id="mes" min="1" max="12" step="1" ng-model="mes" placeholder="Meses (1-12)"/>
                    </div>
                    <input type="submit" class="btn btn-default" value="Processa informações para dia {{dia}}/{{mes}}" />
                </form>

                <details>
                    <summary>Log</summary>
                    <p>Início: {{logProcessaDia.resultado.timestampInicial}}</p>
                    <p>Fim: {{logProcessaDia.resultado.timestampFinal}}</p>
                    <p ng-repeat="log in logProcessaDia.resultado.log">{{log}}</p>
                    <p ng-hide="logProcessaDia.resultado.log.length">Nenhum log no momento</p>
                </details>
            </fieldset>
        </div>
    </body>
</html>