angular.module('hojeEhDiaDeRuaAppEstatisticas', ["highcharts-ng"])

.constant('diaDeRuaURL', {'url': '/estatistica'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaStatController', ['$scope', '$http', 'diaDeRuaURL', function ($scope, $http, diaDeRuaURL) {
    $scope.ruasPorMes = {};
    $scope.ruasPorMes.chartConfig = {
        options: {
            chart: {
                type: 'areaspline'
            }
        },
        title: {
            text: 'Ruas Por Mês',
            style: {"fontWeight": "bold", "fontSize": "20px"}
        },
        xAxis: {
    	    categories: ['Janeiro', 'Fevereiro', 'Março', 'Abril',
                         'Maio', 'Junho', 'Julho', 'Agosto',
                         'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
            title: {
                text: 'Meses',
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
    	}
    }

    $http.get(diaDeRuaURL.url + "/anual")
        .success((data) => {
            console.log(data.resultado);
            $scope.ruasPorMes.chartConfig.series = [{
                "data": data.resultado,
                "name": "Ruas",
                "color": "#c0c0c0",
                "borderColor": "#ff0",
            }];

            console.log($scope.ruasPorMes);
        })
        .error((data) => {
            $scope.error = data.resultado;
        });
}])