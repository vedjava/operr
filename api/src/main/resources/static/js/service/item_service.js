'use strict';
App.factory('ItemService', ['$http', '$q', function($http, $q){

	return {
			fetchAll: function() {
					return $http.get('http://localhost:8080/api/item/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching items');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    create: function(item){
					return $http.post('http://localhost:8080/api/item/', item)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating item');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    update: function(item, id){
					return $http.put('http://localhost:8080/api/item/'+id, item)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating item');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteById: function(id){
					return $http.delete('http://localhost:8080/api/item/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting item');
										return $q.reject(errResponse);
									}
							);
			}
	};

}]);