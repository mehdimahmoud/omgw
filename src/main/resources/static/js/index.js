'use strict';

angular
    .module("movieApp", ["ngRoute"])
    .config(function($routeProvider) {
        $routeProvider
            /*.when("/", {
                templateUrl : "../public/index.html",
                controller: MainCtrl,
                controllerAs: 'main'
                // template: 'route !'
            })*/
            .when("/movies/:id", {
                templateUrl : "../public/movieDetails.html",
                controller: MovieDetailsCtrl,
                controllerAs: 'movie'
            })
            .when("/movies", {
                templateUrl : "../public/moviesList.html",
                controller: MovieListCtrl,
                controllerAs: 'movies'
            })
            .otherwise({redirectTo:'/'})
    })
    .controller('MainCtrl',['$scope', '$http',MainCtrl])
    .controller('MovieDetailsCtrl',['$routeParams','$http',MovieDetailsCtrl])
    .controller('MovieListCtrl',['$routeParams','$http', MovieListCtrl]);

function MainCtrl($scope, $http) {

    $scope.$watch('searchValue', function() {
        fetch();
    });

    $scope.searchValue = "Batman";

    function fetch(){
        $http({
            method: 'GET',
            url: '/movies',
            params: {'title':$scope.searchValue}
        }).then(
            function successCallBack(message) {
                console.log("Response = "+message.data.Response);
                console.log("title = "+message.data.Search[0].title);
                $scope.movieList = message.data.Search;
            },
            function failCallBack(errorMessage) {
                console.log("Error = "+errorMessage.data.Error);
            }
        );
    }

    $scope.update = function(movie){
        $scope.searchValue = movie.Title;
    };

    $scope.focusOnIt = function(){
        // this.setSelectionRange(0, $scope.searchValue.length);
        fetch();
    };

    $scope.searchSubmit = function(){
        // this.setSelectionRange(0, this.value.length);
        fetch();
    };
}

function MovieListCtrl($routeParams,$http) {
    /*var moviesVm = this;
    moviesVm.movieList;
    moviesVm.name = 'MovieListCtrl';
    moviesVm.params = $routeParams;

    console.log('searchValue: ' + $routeParams[0]);

    $http({
        method: 'GET',
        url: '/movies',
        params: {'title':$routeParams.title}
    }).then(
        function successCallBack(message) {
            console.log("Response = "+message.data.Response);
            console.log("Search = "+message.data.Search);
            console.log("totalResults = "+message.data.totalResults);
            moviesVm.movieList = message.data.Search;
        },
        function failCallBack(errorMessage) {
            console.log("Error = "+errorMessage.data.Error);
        }
    );*/
    /*return fetch();

    function fetch(){
        $http({
            method: 'GET',
            url: '/movies',
            params: {'title':$scope.searchValue}
        }).then(
            function successCallBack(message) {
                console.log("Response = "+message.data.Response);
                console.log("Search = "+message.data.Search[0].Title);
                console.log("Title = "+message.data.totalResults);
                $scope.movieList = message.data.Search;
            },
            function failCallBack(errorMessage) {
                console.log("Error = "+errorMessage.data.Error);
            }
        );
    }*/
}

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
        function failCallBack(messageError) {
            console.log("Error = "+messageError.data.Error);
        }
    );
}

