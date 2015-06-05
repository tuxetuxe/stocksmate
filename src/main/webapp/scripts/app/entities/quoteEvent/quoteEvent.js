'use strict';

angular.module('stocksmateApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('quoteEvent', {
                parent: 'entity',
                url: '/quoteEvent',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'stocksmateApp.quoteEvent.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/quoteEvent/quoteEvents.html',
                        controller: 'QuoteEventController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('quoteEvent');
                        return $translate.refresh();
                    }]
                }
            })
            .state('quoteEventDetail', {
                parent: 'entity',
                url: '/quoteEvent/:id',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'stocksmateApp.quoteEvent.detail.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/quoteEvent/quoteEvent-detail.html',
                        controller: 'QuoteEventDetailController'
                    }
                },
                resolve: {
                    translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                        $translatePartialLoader.addPart('quoteEvent');
                        return $translate.refresh();
                    }]
                }
            });
    });
