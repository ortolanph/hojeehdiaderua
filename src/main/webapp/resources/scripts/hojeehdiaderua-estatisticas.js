angular.module('hojeEhDiaDeRuaAppEstatisticas', [])

.constant('diaDeRuaURL', {'url': '/estatistica'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaStatController', ['$scope', '$http', 'diaDeRuaURL', ($scope, $http, diaDeRuaURL) => {
    $scope.obterEstatisticasAnuais = () => {
        $http.get(diaDeRuaURL.url + "/anual")
            .success((data) => {
                $scope.estatisticasAnuais = data.resultado;
                console.log($scope.estatisticasAnuais);
            })
            .error((data) => {
                $scope.error = data.resultado;
            });
    };

    $scope.obterEstatisticasAnuais();
}])