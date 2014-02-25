var catalogoApp = angular.module('catalogoApp', [ 'ngRoute',
    'catalogoControllers', 'catalogoDirectives' ]);

catalogoApp.config([ '$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'paginas/tela-cadastro.jsp',
        controller: 'revistaController'
    }).otherwise({
            redirectTo: 'erro.jsp'
        });
} ]);