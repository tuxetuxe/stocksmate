/* globals $ */
'use strict';

angular.module('stocksmateApp')
    .directive('stocksmateAppPager', function() {
        return {
            templateUrl: 'scripts/components/form/pager.html'
        };
    });
