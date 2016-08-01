angular.module('hojeEhDiaDeRuaAppAdmin', [])

.constant('diaDeRuaURL', {'url': '/admin'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaAdminController', ['$scope', '$http', '$location', 'diaDeRuaURL', ($scope, $http, $location, diaDeRuaURL) => {

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
                $location.path('index.jsp').replace();
             })
            .error((data) => {
                $location.path('error.jsp').replace();
             });
    };
}])