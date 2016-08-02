angular.module('hojeEhDiaDeRuaAppAdmin', [])

.constant('diaDeRuaURL', {'url': '/admin'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaAdminController', ['$scope', '$http', '$window', 'diaDeRuaURL', ($scope, $http, $window, diaDeRuaURL) => {

    $http.get(diaDeRuaURL.url + "/obtemDiasProcessadosNoMes")
        .success((data) => {
            $scope.diasProcessados = data.resultado;
        })
        .error((data) => {
            $scope.diasProcessados = data.resultado;
        });


    $scope.processaDiaAtual = () => {
        $http.post(diaDeRuaURL.url + '/processaDiaAtual')
            .success((data) => {
                $scope.logProcessaDiaAtual = data;
            });
    };

    $scope.processaDia = () => {
        $http.get(diaDeRuaURL.url + '/processaDia/' + $scope.dia + '/' + $scope.mes)
            .success((data) => {
                $scope.logProcessaDia = data;
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