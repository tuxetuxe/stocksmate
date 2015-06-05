'use strict';

angular.module('stocksmateApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


