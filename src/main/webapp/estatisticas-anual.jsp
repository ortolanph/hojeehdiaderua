<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <p><h2>Estatísticas Anuais</h2></p>

    <div id="calendario">
        <p>Ruas</p>
        <p>{{quantidadeDeRuas}}</p>
    </div>
    <br/>
    <div id="calendario">
        <p>Cidades</p>
        <p>{{quantidadeDeCidades}}</p>
    </div>

    <br/>

    <highchart id="graficoRuasPorMes" config="ruasPorMes" style="width:75%"></highchart>
    <highchart id="graficoRuasPorUF" config="ruasPorUF" style="width:75%"></highchart>
    <highchart id="graficoRuasPorDia" config="ruasPorDia" style="width:75%"></highchart>

    <p>Top Ten Cidades x Ruas</p>
    <span ng-controller="anualController">
        <table>
            <tr>
                <th>#</th>
                <th>Cidade</th>
                <th>Ruas</th>
            </tr>
            <tr ng-repeat="t in topTenCidadeRua">
                <td>{{t.position}}</td>
                <td>{{t.cidade}}</td>
                <td>{{t.total}}</td>
            </tr>
        </table>
    </span>