angular.module('hojeEhDiaDeRuaAppEstatisticas', ["highcharts-ng"])

.constant('$diaDeRuaURL', {'url': '/estatistica'})

.factory('config', function configFactory() {
    return {
        options: {
            chart: {
                type: 'areaspline'
            }
        },
        title: {
            style: {"fontWeight": "bold", "fontSize": "20px"}
        },
        xAxis: {
            title: {
                style: {"font-weight": "bold"}
            },
            lineColor: "#000",
            tickColor: "#000"
    	},
    	yAxis: {
    	    title: {
    	        text: "Quantidade de Ruas",
    	        style: {"font-weight": "bold"}
    	    }
    	},
    	series: []
    }
})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.service('estatisticas', ['$http', '$diaDeRuaURL', 'config', function($http, $diaDeRuaURL, config) {

    this.anuais = function() {
        return $http.get($diaDeRuaURL.url + "/anual");
    };

    this.mensais = function(mes) {
        return $http.get($diaDeRuaURL.url + "/mensal/" + mes)
    };

    this.construirConfiguracaoRuasPorMes = function(ruasPorMes) {
        var ruasPorMesConfig = config;

        ruasPorMesConfig.title.text = "Ruas Por Mês"
        ruasPorMesConfig.xAxis.categories = ruasPorMes.categorias;
        ruasPorMesConfig.xAxis.title.text = "Meses";

        ruasPorMesConfig.series.push({
                "data": ruasPorMes.series,
                "name": "Ruas",
                "color": "#c0c0c0",
                "borderColor": "#ff0"
            }
        );

        return ruasPorMesConfig;
    };

    this.construirConfiguracaoRuasPorUF = function(ruasPorUF) {
        var ruasPorUFConfig = config;

        ruasPorUFConfig.title.text = "Ruas Por UF"
        ruasPorUFConfig.xAxis.categories = ruasPorUF.categorias;
        ruasPorUFConfig.xAxis.title.text = "UF";

        ruasPorUFConfig.series.push({
                "data": ruasPorUF.series,
                "name": "Ruas",
                "color": "#c0c0c0",
                "borderColor": "#ff0"
            }
        );

        return ruasPorUFConfig;
    };

    this.construirConfiguracaoRuasPorDia = function(ruasPorDia) {
        var ruasPorDiaConfig = config;

        ruasPorDiaConfig.title.text = "Ruas Por Dia"
        ruasPorDiaConfig.xAxis.categories = ruasPorDia.categorias;
        ruasPorDiaConfig.xAxis.title.text = "Dias";

        ruasPorDiaConfig.series.push({
                "data": ruasPorDia.series,
                "name": "Ruas",
                "color": "#c0c0c0",
                "borderColor": "#ff0"
            }
        );

        return ruasPorDiaConfig;
    };

    cleanCopy = function() {
        var chartConfig = {};

        return chartConfig;
    }
}])

.controller('diaDeRuaStatController', ['$scope', 'estatisticas', ($scope, estatisticas) => {

    estatisticas.anuais().then((response) => {
        var dados = response.data;

        console.log(dados.resultado.ruasPorDia);

        $scope.quantidadeDeRuas = dados.resultado.quantidadeDeRuas;
        $scope.quantidadeDeCidades = dados.resultado.quantidadeDeCidades;
        $scope.ruasPorMes = estatisticas.construirConfiguracaoRuasPorMes(dados.resultado.ruasPorMes);
        $scope.ruasPorUF = estatisticas.construirConfiguracaoRuasPorUF(dados.resultado.ruasPorUF);
        $scope.ruasPorDia = esatatisticas.construirConfiguracaoRuasPorDia(dados.resultado.ruasPorDia);
    });
}])