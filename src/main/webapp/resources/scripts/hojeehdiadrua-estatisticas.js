angular.module('hojeEhDiaDeRuaAppEstatisticas', [])

.constant('diaDeRuaURL', {'url': '/admin'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaStatController', ['$scope', '$http', '$window', 'diaDeRuaURL', ($scope, $http, $window, diaDeRuaURL) => {
    var currentDate = new Date();
    $scope.month = currentDate.getMonth() + 1;

    $scope.obterDiasProcessados = (month) => {
        $http.get(diaDeRuaURL.url + "/obtemDiasProcessadosNoMes/" + month)
            .success((data) => {
                $scope.diasProcessados = data.resultado;
            })
            .error((data) => {
                $scope.diasProcessados = data.resultado;
            });
    };

    $scope.processaDiaAtual = () => {
        $http.post(diaDeRuaURL.url + '/processaDiaAtual')
            .success((data) => {
                $scope.logProcessaDiaAtual = data;
                $scope.obterDiasProcessados($scope.month);
            });
    };

    $scope.processaDia = () => {
        $http.get(diaDeRuaURL.url + '/processaDia/' + $scope.dia + '/' + $scope.mes)
            .success((data) => {
                $scope.logProcessaDia = data;
                $scope.obterDiasProcessados($scope.month);
            })
    };

    $scope.logout = () => {
        $http.post('logout', {})
            .success(() => {
                $window.location.href = "/";
             })
            .error((data) => {
                $window.location.href = 'error.jsp';
             });
    };
}])