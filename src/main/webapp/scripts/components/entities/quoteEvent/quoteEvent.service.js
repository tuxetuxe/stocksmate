'use strict';

angular.module('stocksmateApp')
    .factory('QuoteEvent', function ($resource, DateUtils) {
        return $resource('api/quoteEvents/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });
