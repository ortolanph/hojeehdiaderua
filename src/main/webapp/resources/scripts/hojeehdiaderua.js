angular.module('hojeEhDiaDeRuaApp', [])

.constant('diaDeRuaURL', {'url': '/hojeehdiaderua/queRuaEhHoje'})

.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])

.controller('diaDeRuaController', ['$scope', '$http', 'diaDeRuaURL', function($scope, $http, diaDeRuaURL) {
     $http.get(diaDeRuaURL.url)
        .success(function (data) {
            $scope.diaderua = data;
        })
        .error(function (data, status) {
            $scope.diaderua = data;
        });
}])

/*

{
    "mensagem":"Processamento concluído com sucesso",
    "status":"SUCCESS",
    "resultado":
        {
            "dia":20,
            "diaSemana":
            "SEG",
            "mes":"JUN",
            "ano":2016,
            "localidades":
                [
                    {
                        "cidade":"São Paulo",
                        "uf":"SP"
                    }
                ],
            "festividades":
                [
                    "Dia de São Nunca",
                    "Nascimento de John Doe",
                    "Coroação de Hamlet na Dinamarca"
                ]
            }
        }
}
*/