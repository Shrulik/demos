var app = angular.module("Quotes", []);

app.factory('Quote', function ($http) {
    return {
        query: function () {
            return $http.get('/quote').then(function (response) {
                return response.data;
            });
        },

        save: function (quote, successCallback, errorCallback) {
            return $http.post('/quote', quote).then(successCallback, errorCallback);
        }
    };
})

app.controller('AppCtrl', function ($scope, Quote) {

    $scope.title = "רק מרכאות";
    $scope.greeting = "ציטוטים הבאים";
    $scope.newQuote = {};

    $scope.quotes= Quote.query();

    $scope.addQuote = function () {
        Quote.save($scope.newQuote,
            function (response) {
                $scope.quotes.then(function (quotes) {
                    quotes.push(response.data)
                });
            }, function (errorResponse) {
                $scope.errors = errorResponse.data;
                console.log(errorResponse.data);
            }
        );

        $scope.newQuote = {};
    };

});