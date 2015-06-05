/* globals $ */
'use strict';

angular.module('stocksmateApp')
    .directive('stocksmateAppPagination', function() {
        return {
            templateUrl: 'scripts/components/form/pagination.html'
        };
    });
