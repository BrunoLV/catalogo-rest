var catalogoApp = angular.module('catalogoApp', [ 'ngRoute', 'ngResource',
    'catalogoControllers', 'catalogoDirectives', 'catalogoFactories' ]);

catalogoApp.config([ '$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'paginas/tela-cadastro.jsp',
        controller: 'revistaController'
    }).otherwise({
            redirectTo: 'erro.jsp'
        });
} ]);