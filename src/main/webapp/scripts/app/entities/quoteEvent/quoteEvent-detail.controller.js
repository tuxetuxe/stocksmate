'use strict';

angular.module('stocksmateApp')
    .controller('QuoteEventDetailController', function ($scope, $stateParams, QuoteEvent) {
        $scope.quoteEvent = {};
        $scope.load = function (id) {
            QuoteEvent.get({id: id}, function(result) {
              $scope.quoteEvent = result;
            });
        };
        $scope.load($stateParams.id);
    });
