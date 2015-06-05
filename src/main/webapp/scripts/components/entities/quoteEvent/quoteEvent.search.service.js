'use strict';

angular.module('stocksmateApp')
    .factory('QuoteEventSearch', function ($resource) {
        return $resource('api/_search/quoteEvents/:query', {}, {
            'query': { method: 'GET', isArray: true}
        });
    });
