/**
 * Created by styppen on 09/09/16.
 */
var app = angular.module('Insultr', []);
app.controller('InsultController', function($scope, $http) {
    $scope.copyController = new Clipboard(".btn");
    $scope.first = "N/A";
    $scope.second = "N/B";
    $scope.noun = "N/C";

    $scope.insult = function() {
        $http.post(location.protocol + "//" + location.hostname + ":" + location.port + "/insult", {})
            .success(function (response) {
                
                $scope.first = response.first;
                $scope.second = response.second;
                $scope.noun = response.noun;
            });
    }

    $scope.copy = function() {

    }
});