'use strict';

/* Controllers */

var productControllers = angular.module('productControllers', []);

productControllers.controller('ProductListCtrl',  function($scope, $routeParams,$http) {

  var searchTerm=$routeParams.searchTerm;
  var flow=$routeParams.flow;
  if (flow == null) {flow="A"; return;}
  if(searchTerm == null) searchTerm="bag";          
  			
  var searchUrl="http://localhost:4569/search?flow="+flow+"&searchTerm="+searchTerm;
  
 
  $http({method: 'GET', url: searchUrl}).
  
  success(function(data, status, headers, config) {
  
    $scope.items = data.tiles;
	if(data.count != null)
    $scope.itemCountMsg="Search results "+data.count +" found!";  
	else $scope.itemCountMsg="";
    $scope.orderProp = 'productId';
	
  }).
  error(function(data, status, headers, config) {
  alert('something went wrong : '+data+status);
 
  });

  });