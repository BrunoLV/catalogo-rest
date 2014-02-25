/*
 * Script para definição dos controllers da aplicaçao.
 */

var catalogoControllers = angular.module('catalogoControllers', []);

// Definição do controller
catalogoControllers.controller('revistaController', ['$scope', '$http', function ($scope, $http) {
    $scope.revista = {};
    $scope.revistas = [];

    $scope.carregarTodasRevistas = function () {
        $http.get('rest/revistas').success(function (retorno) {
        	$scope.revistas = angular.fromJson(retorno);
        }).error(function(retorno) {
        	var retornoRest = angular.fromJson(retorno);
        	alert("Mensagem: " + retornoRest.mensagem);
		});
    };

    $scope.carregarTodasRevistas();

    /*
	 * Function para executar as ações de cadastrar/editar uma revista no
	 * sistema.
	 */
    $scope.salvar = function () {
        if ($scope.cadastroForm.$valid) {
        	var retornoRest = {}; 
            if ($scope.revista.id == null || $scope.revista.id == undefined || $scope.revista.id == 0) {
            	$http.post('rest/revistas/gravar', $scope.revista).success(function (retorno) {
            		retornoRest = angular.fromJson(retorno);
            		alert("Mensagem: " + retornoRest.mensagem);
                    $scope.carregarTodasRevistas();
                }).error(function(retorno){
                	retornoRest = angular.fromJson(retorno);
                	alert("Mensagem: " + retornoRest.mensagem);
                });
            } else {
                $http.put('rest/revistas/editar', $scope.revista).success(function (retorno) {
                	retornoRest = angular.fromJson(retorno);
                	alert("Mensagem: " + retornoRest.mensagem);	
                    $scope.carregarTodasRevistas();
                }).error(function(retorno){
                	retornoRest = angular.fromJson(retorno);
                	alert("Mensagem: " + retornoRest.mensagem);
                });
            } // fim do bloco if/else
            $scope.limpar();
        } // fim do bloco if
    };

    $scope.editar = function (revista) {
        $scope.revista = angular.copy(revista);
    };

    $scope.deletar = function (id) {
    	var retornoRest = {};
        $http.delete('rest/revistas/deletar/' + id).success(function (retorno) { 
        	retornoRest = angular.fromJson(retorno);
        	alert("Mensagem: " + retornoRest.mensagem);
            $scope.carregarTodasRevistas();
        }).error(function(retorno){
        	retornoRest = angular.fromJson(retorno);
        	alert("Mensagem: " + retornoRest.mensagem);
        });
    };

    $scope.limpar = function() {
        $scope.cadastroForm.$setPristine();
        $scope.revista = {};
    };

}]);