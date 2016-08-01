<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="hojeEhDiaDeRuaApp">
    <head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
		<script src="resources/scripts/hojeehdiaderua.js"></script>
        <title>Hoje é Dia de Rua! - Admin</title>
    </head>
    <body>
        <h1>Hoje é Dia de Rua! - Admin</h1>

        <fieldset>
            <legend>Processa dia atual</legend>
            <input type="button" onclick="processaDiaAtual()" />
            <details>
                <summary>Log</summary>
                <p>Nenhum log no momento</p>
            </details>
        </fieldset>

        <fieldset>
            <legend>Processa outro dia</legend>

            <input type="button" onclick="processaDiaAtual()" />
            <details>
                <summary>Log</summary>
                <p>Nenhum log no momento</p>
            </details>
        </fieldset>
    </body>
</html>