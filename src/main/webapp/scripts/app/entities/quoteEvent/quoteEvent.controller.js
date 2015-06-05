'use strict';

angular.module('stocksmateApp')
    .controller('QuoteEventController', function ($scope, QuoteEvent, QuoteEventSearch, ParseLinks) {
        $scope.quoteEvents = [];
        $scope.page = 1;
        $scope.loadAll = function() {
            QuoteEvent.query({page: $scope.page, per_page: 20}, function(result, headers) {
                $scope.links = ParseLinks.parse(headers('link'));
                $scope.quoteEvents = result;
            });
        };
        $scope.loadPage = function(page) {
            $scope.page = page;
            $scope.loadAll();
        };
        $scope.loadAll();

        $scope.showUpdate = function (id) {
            QuoteEvent.get({id: id}, function(result) {
                $scope.quoteEvent = result;
                $('#saveQuoteEventModal').modal('show');
            });
        };

        $scope.save = function () {
            if ($scope.quoteEvent.id != null) {
                QuoteEvent.update($scope.quoteEvent,
                    function () {
                        $scope.refresh();
                    });
            } else {
                QuoteEvent.save($scope.quoteEvent,
                    function () {
                        $scope.refresh();
                    });
            }
        };

        $scope.delete = function (id) {
            QuoteEvent.get({id: id}, function(result) {
                $scope.quoteEvent = result;
                $('#deleteQuoteEventConfirmation').modal('show');
            });
        };

        $scope.confirmDelete = function (id) {
            QuoteEvent.delete({id: id},
                function () {
                    $scope.loadAll();
                    $('#deleteQuoteEventConfirmation').modal('hide');
                    $scope.clear();
                });
        };

        $scope.search = function () {
            QuoteEventSearch.query({query: $scope.searchQuery}, function(result) {
                $scope.quoteEvents = result;
            }, function(response) {
                if(response.status === 404) {
                    $scope.loadAll();
                }
            });
        };

        $scope.refresh = function () {
            $scope.loadAll();
            $('#saveQuoteEventModal').modal('hide');
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.quoteEvent = {ask: null, averageDailyVolume: null, bid: null, askRealtime: null, bidRealtime: null, bookValue: null, change_PercentChange: null, change: null, commission: null, currency: null, changeRealtime: null, afterHoursChangeRealtime: null, dividendShare: null, lastTradeDate: null, tradeDate: null, earningsShare: null, errorIndicationreturnedforsymbolchangedinvalid: null, ePSEstimateCurrentYear: null, ePSEstimateNextYear: null, ePSEstimateNextQuarter: null, daysLow: null, daysHigh: null, yearLow: null, yearHigh: null, holdingsGainPercent: null, annualizedGain: null, holdingsGain: null, holdingsGainPercentRealtime: null, holdingsGainRealtime: null, moreInfo: null, orderBookRealtime: null, marketCapitalization: null, marketCapRealtime: null, eBITDA: null, changeFromYearLow: null, percentChangeFromYearLow: null, lastTradeRealtimeWithTime: null, changePercentRealtime: null, changeFromYearHigh: null, percebtChangeFromYearHigh: null, lastTradeWithTime: null, lastTradePriceOnly: null, highLimit: null, lowLimit: null, daysRange: null, daysRangeRealtime: null, fiftydayMovingAverage: null, twoHundreddayMovingAverage: null, changeFromTwoHundreddayMovingAverage: null, percentChangeFromTwoHundreddayMovingAverage: null, changeFromFiftydayMovingAverage: null, percentChangeFromFiftydayMovingAverage: null, name: null, notes: null, open: null, previousClose: null, pricePaid: null, changeinPercent: null, priceSales: null, priceBook: null, exDividendDate: null, pERatio: null, dividendPayDate: null, pERatioRealtime: null, pEGRatio: null, priceEPSEstimateCurrentYear: null, priceEPSEstimateNextYear: null, symbol: null, sharesOwned: null, shortRatio: null, lastTradeTime: null, tickerTrend: null, oneyrTargetPrice: null, volume: null, holdingsValue: null, holdingsValueRealtime: null, yearRange: null, daysValueChange: null, daysValueChangeRealtime: null, stockExchange: null, dividendYield: null, percentChange: null, id: null};
            $scope.editForm.$setPristine();
            $scope.editForm.$setUntouched();
        };
    });
