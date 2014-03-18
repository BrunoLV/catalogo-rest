/*
 * Script para definição dos controllers da aplicaçao.
 */

var catalogoControllers = angular.module('catalogoControllers', []);

// Definição do controller
catalogoControllers.controller('revistaController', ['$scope', '$http', 'Model', function ($scope, $http, Model) {
    $scope.revista = {};
    $scope.revistas = [];

    $scope.carregarTodasRevistas = function () {
    	Model.query(function (retorno) {
        	$scope.revistas = angular.fromJson(retorno);
        }, function(retorno) {
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
            	Model.create({acao:'gravar'}, $scope.revista, function (retorno) {
            		retornoRest = angular.fromJson(retorno);
            		alert("Mensagem: " + retornoRest.mensagem);
                    $scope.carregarTodasRevistas();
                }, function(retorno){
                	retornoRest = angular.fromJson(retorno);
                	alert("Mensagem: " + retornoRest.mensagem);
                });
            } else {
            	Model.save({acao:'editar'}, $scope.revista, function (retorno) {
                	retornoRest = angular.fromJson(retorno);
                	alert("Mensagem: " + retornoRest.mensagem);	
                    $scope.carregarTodasRevistas();
                }, function(retorno){
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
    	Model.destroy({acao:'deletar'}, {id:id}, function (retorno) { 
        	retornoRest = angular.fromJson(retorno);
        	alert("Mensagem: " + retornoRest.mensagem);
            $scope.carregarTodasRevistas();
        },function(retorno){
        	retornoRest = angular.fromJson(retorno);
        	alert("Mensagem: " + retornoRest.mensagem);
        });  
    };

    $scope.limpar = function() {
        $scope.cadastroForm.$setPristine();
        $scope.revista = {};
    };

}]);