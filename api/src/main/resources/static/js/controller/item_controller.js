'use strict';
App.controller('ItemController', ['$scope', 'ItemService', function($scope, ItemService) {
          var self = this;
          self.item = {id:null,name:'', description:'', selected:false};
          self.items=[];
              
          self.fetchAllItems = function(){
              ItemService.fetchAll()
                  .then(
      					       function(d) {
      						        self.items = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching items');
            					}
      			       );
          };
           
          self.createItem = function(item){
              ItemService.create(item)
		              .then(
                      self.fetchAllItems, 
				              function(errResponse){
					               console.error('Error while creating item.');
				              }	
                  );
          };

         self.updateItem = function(item, id){
              ItemService.update(item, id)
		              .then(
				              self.fetchAllItems, 
				              function(errResponse){
					               console.error('Error while updating Item.');
				              }	
                  );
          };

         self.deleteItem = function(id){
        	 	ItemService.deleteById(id)
		              .then(
				              self.fetchAllItems, 
				              function(errResponse){
					               console.error('Error while deleting Item.');
				              }	
                  );
          };

          self.deleteItems = function(){
      	 	ItemService.deleteItems(self.items)
		              .then(
				              self.fetchAllItems, 
				              function(errResponse){
					               console.error('Error while deleting Items.');
				              }	
                );
          };
        
        
          self.fetchAllItems();

          self.submit = function() {
              if(self.item.id==null){
                  console.log('Saving New Item', self.item);    
                  self.createItem(self.item);
              }else{
                  self.updateItem(self.item, self.item.id);
                  console.log('Item updated with id ', self.item.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.items.length; i++){
                  if(self.items[i].id == id) {
                     self.item = angular.copy(self.items[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              //clean form if the item to be deleted is shown there.
              if(self.item.id === id) {
                 self.reset();
              }
              self.deleteItem(id);
          };

          self.removeSelected = function(){
        	  	var haveSelected = false;
              angular.forEach(self.items, function(item) {
            	  	if(item.selected==true){
            	  		self.deleteItem(item.id);
            	  		haveSelected = true;
            	  	}
              });
              if(!haveSelected){
            	  	alert("Please select any item to delete.");
              }
          };
          
          self.reset = function(){
              self.item = {id:null,name:'', description:''};
              $scope.myForm.$setPristine(); //reset Form
          };
          
          
          self.selectAll = function() {
              angular.forEach(self.items, function(item) {
                item.selected = self.selectedAll;
              });
          };

          self.checkIfAllSelected = function() {
        	  	self.selectedAll = self.items.every(function(item) {
        	  		return item.selected == true
        	  	})
          };
          
      }]);