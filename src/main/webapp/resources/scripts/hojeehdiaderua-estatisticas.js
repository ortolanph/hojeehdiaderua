angular.module('hojeEhDiaDeRuaAppEstatisticas', ["highcharts-ng"])

.constant('$diaDeRuaURL', {'url': '/estatistica'})

.constant('$defaultChartConfig',
{
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
    	        text: "Quantidade de Ruas", //have to set
    	        style: {"font-weight": "bold"}
    	    }
    	},
    	series: []
})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.service('estatisticas', ['$http', '$diaDeRuaURL', '$defaultChartConfig', function($http, $diaDeRuaURL, $defaultChartConfig) {

    this.anuais = function() {
        return $http.get($diaDeRuaURL.url + "/anual");
    };

    this.mensais = function(mes) {
        return $http.get($diaDeRuaURL.url + "/mensal/" + mes)
    };

    this.construirConfiguracaoRuasPorMes = function(ruasPorMes) {
        var ruasPorMesConfig = $defaultChartConfig;

        ruasPorMesConfig.title.text = "Ruas Por Mês"
        ruasPorMesConfig.xAxis.categories = ruasPorMes.categorias;
        ruasPorMesConfig.xAxis.title.text = "Meses";
        ruasPorMesConfig.yAxis.title.text = "Quantidade de Ruas";

        ruasPorMesConfig.series.push({
                "data": ruasPorMes.series,
                "name": "Ruas",
                "color": "#c0c0c0",
                "borderColor": "#ff0"
            }
        );

        return ruasPorMesConfig;
    };

}])

.controller('diaDeRuaStatController', ['$scope', 'estatisticas', ($scope, estatisticas) => {

    estatisticas.anuais().then((response) => {
        var dados = response.data;
        $scope.quantidadeDeRuas = dados.resultado.quantidadeDeRuas;
        $scope.quantidadeDeCidades = dados.resultado.quantidadeDeCidades;
        $scope.ruasPorMes = estatisticas.construirConfiguracaoRuasPorMes(dados.resultado.ruasPorMes);
        $scope.ruasPorUF = dados.resultado.ruasPorUF;
        $scope.ruasPorDia = dados.resultado.ruasPorDia;
    });
}])