angular.module('hojeEhDiaDeRuaAppEstatisticas', ["highcharts-ng"]) //, "ngRoute"])

.constant('$diaDeRuaURL', {'url': '/estatistica'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.service('estatisticas', ['$http', '$diaDeRuaURL', function($http, $diaDeRuaURL) {

    this.anuais = function() {
        return $http.get($diaDeRuaURL.url + "/anual");
    };

    this.mensais = function(mes) {
        return $http.get($diaDeRuaURL.url + "/mensal/" + mes)
    };

    this.construirConfiguracaoRuasPorMes = function(ruasPorMes) {
        var ruasPorMesConfig = cleanCopy();

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
        var ruasPorUFConfig = cleanCopy();

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
        var ruasPorDiaConfig = cleanCopy();

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

        chartConfig.options = {};
        chartConfig.options.chart = {};
        chartConfig.options.chart.type = 'areaspline';

        chartConfig.title = {};
        chartConfig.title.style = {"fontWeight": "bold", "fontSize": "20px"};

    	chartConfig.xAxis = {};
    	chartConfig.xAxis.title = {};
    	chartConfig.xAxis.title.style = {"fontWeight": "bold"};
    	chartConfig.xAxis.lineColor = "#000";
    	chartConfig.xAxis.tickColor = "#000";

    	chartConfig.yAxis = {};
    	chartConfig.yAxis.title = {};
    	chartConfig.yAxis.title.text = "Quantidade de Ruas";
    	chartConfig.yAxis.title.style = {"font-weight": "bold"};

        chartConfig.series = [];

        return chartConfig;
    }
}])

.controller('diaDeRuaStatController', ['$scope', 'estatisticas', ($scope, estatisticas) => {
    estatisticas.anuais().then((response) => {
        var dados = response.data;
        $scope.quantidadeDeRuas = dados.resultado.quantidadeDeRuas;
        $scope.quantidadeDeCidades = dados.resultado.quantidadeDeCidades;
        $scope.ruasPorMes = estatisticas.construirConfiguracaoRuasPorMes(dados.resultado.ruasPorMes);
        $scope.ruasPorUF = estatisticas.construirConfiguracaoRuasPorUF(dados.resultado.ruasPorUF);
        $scope.ruasPorDia = estatisticas.construirConfiguracaoRuasPorDia(dados.resultado.ruasPorDia);
    });
}])