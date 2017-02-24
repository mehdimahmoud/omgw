'use strict';

angular
    .module("movieApp", ["ngRoute"])
    .config(function($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "../public/index.html",
                template:'This is the Route'
            })
            .when("/movies/:id", {
                templateUrl : "../public/movieDetails.html",
                controller: MovieDetailsCtrl,
                controllerAs: 'movie'
            })
            .when("/list", {
                templateUrl : "../public/moviesList.htm",
                template:'This is the list Route'
            })
            .otherwise({redirectTo:'/'})
    }).controller('MovieDetailsCtrl',['$routeParams','$http',MovieDetailsCtrl]);



function MovieDetailsCtrl($routeParams, $http) {
    var movieVm = this;
    movieVm.movieData;
    movieVm.name = 'MovieDetailsCtrl';
    movieVm.params = $routeParams;

    console.log('searchValue: ' + $routeParams.id);

    $http({
        method: 'GET',
        url: '/movies/'+$routeParams.id
    }).then(
        function successCallBack(message) {
            console.log("Response = "+message.data.Response);
            console.log("imdbID = "+message.data.imdbID);
            console.log("Title = "+message.data.Title);
            movieVm.movieData = message.data;
        },
        function failCallBack(error) {
            console.log("error = "+error);
        },
        function notifyCallBack(notify) {
            console.log("notify = "+notify);
        }
    );
}

