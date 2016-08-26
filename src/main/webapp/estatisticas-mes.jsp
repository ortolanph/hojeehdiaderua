<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <p>Quantidade de Ruas: {{quantidadeDeRuas}}</p>
    <p>Quantidade de Cidades: {{quantidadeDeCidades}}</p>

    <highchart id="graficoRuasPorUF" config="ruasPorUF" style="width:75%"></highchart>
    <highchart id="graficoRuasPorDia" config="ruasPorDia" style="width:75%"></highchart>

    <p>Top Ten Cidades x Ruas</p>
    <table>
        <td>
            <tr>#</tr>
            <tr>Cidade</tr>
            <tr>Rua</tr>
        </td>
        <td ng-repeat="topTen in topTenCidadeRua">
            <tr>{{topTen.position}}</tr>
            <tr>{{topTen.cidade}}</tr>
            <tr>{{topTen.total}}</tr>
        </td>
    </table>