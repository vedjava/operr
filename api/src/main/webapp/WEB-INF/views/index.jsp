<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS Demo of Operr</title>  
     <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
     <link href="<c:url value='resources/css/app.css' />" rel="stylesheet"></link>
  </head>
  
  <body ng-app="operr" class="ng-cloak">
      <div class="generic-container" ng-controller="ItemController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Item Information</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.item.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.item.name" name="itemname" class="itemname form-control input-sm" placeholder="Enter Item Name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.itemname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.itemname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.itemname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Description</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.item.description" class="form-control input-sm" placeholder="Enter item description. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.item.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Items </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                          	 <th><label><input type="checkbox" ng-model="ctrl.selectedAll" ng-click="ctrl.selectAll()" /></label></th>
                              <th>ID</th>
                              <th>Name</th>
                              <th>Description</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="itm in ctrl.items">
                          	<td>
								<span><input type="checkbox" ng-model="itm.selected" ng-click="ctrl.checkIfAllSelected()"/></span>
                          	</td>	
                              <td><span ng-bind="itm.id"></span></td>
                              <td><span ng-bind="itm.name"></span></td>
                              <td><span ng-bind="itm.description"></span></td>
                              <td>
                              	<button type="button" class="btn btn-default btn-sm" ng-click="ctrl.edit(itm.id)">
          							<span class="glyphicon glyphicon-pencil"></span> 
        							</button>
        							<button type="button" class="btn btn-default btn-sm" ng-click="ctrl.remove(itm.id)" >
          							<span class="glyphicon glyphicon-trash"></span> 
        							</button>
                              </td>
                          </tr>
                      </tbody>
                      <tfoot ng-if="ctrl.items.length>0"><tr><td colspan="5"><button type="button" ng-click="ctrl.removeSelected()" class="btn btn-default">Delete Selected</button></td></tr></tfoot>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='resources/js/app.js' />"></script>
      <script src="<c:url value='resources/js/service/item_service.js' />"></script>
      <script src="<c:url value='resources/js/controller/item_controller.js' />"></script>
  </body>
</html>