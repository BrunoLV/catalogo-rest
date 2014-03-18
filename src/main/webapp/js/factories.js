var catalogoFactories = angular.module('catalogoFactories', []);

catalogoFactories.factory('Model', ['$resource', function($resource) {
	return $resource('rest/revistas/:acao/:id', {
		acao: '@acao', 
		id: '@id'
	},{
		query: {method: 'GET', isArray: true},
		save: {method: 'PUT'},
		create: {method: 'POST'},
		destroy: {method: 'DELETE'}
	});
}]);