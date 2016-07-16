angular.module('hojeEhDiaDeRuaApp', [])

.constant('diaDeRuaURL', {'url': '/hojeehdiaderua/queRuaEhHoje'})

.config(['$httpProvider', ($httpProvider) => {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaController', ['$scope', '$http', 'diaDeRuaURL', ($scope, $http, diaDeRuaURL) => {
     $http.get(diaDeRuaURL.url)
        .success((data) => {
            $scope.diaderua = data;
        })
        .error((data, status) => {
            $scope.diaderua = data;
        });
}])