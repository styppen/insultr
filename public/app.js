/**
 * Created by styppen on 09/09/16.
 */
var app = angular.module('Insultr', []);
app.controller('InsultController', function($scope, $http) {
    $scope.copyController = new Clipboard(".btn");
    $scope.first = null;
    $scope.second = null;
    $scope.noun = null;
    $scope.loaded = false;

    $scope.insult = function() {
        $http.post(location.protocol + "//" + location.hostname + ":" + location.port + "/insult", {})
            .success(function (response) {

                $scope.first = response.first;
                $scope.second = response.second;
                $scope.noun = response.noun;
                $scope.loaded = true;
            });
    }

    $scope.copy = function() {

    }
});