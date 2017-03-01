'use strict';

angular
    .module("movieApp", ["ngRoute"])
    .config(function ($routeProvider) {
        $routeProvider
        /*.when("/", {
         templateUrl : "../public/index.html",
         controller: MainCtrl,
         controllerAs: 'main'
         // template: 'route !'
         })*/
            .when("/movies/:id", {
                templateUrl: "../public/movieDetails.html",
                controller: MovieDetailsCtrl,
                controllerAs: 'movie'
            })
            .when("/movies", {
                templateUrl: "../public/movieList.html",
                controller: MovieListCtrl,
                controllerAs: 'movies'
            })
            .otherwise({redirectTo: '/'})
    })
    .controller('MainCtrl', ['$scope', '$http', MainCtrl])
    .controller('MovieDetailsCtrl', ['$routeParams', '$http', MovieDetailsCtrl])
    .controller('MovieListCtrl', ['$routeParams', '$scope', '$http', MovieListCtrl]);

function MainCtrl($scope, $http) {
    console.log("MainCtrl = MainCtrl");
    $scope.$watch('searchValue', function () {
        fetch();
    });

    // Initialization
    console.log("$scope.searchValue = " + $scope.searchValue);
    $scope.searchValue = "Superman";

    function fetch() {
        if (!jQuery.isEmptyObject($scope.searchValue)) {
            $http({
                method: 'GET',
                url: '/movies',
                params: {'title': $scope.searchValue}
            }).then(
                function successCallBack(message) {
                    console.log("Response = " + message.data.Response);
                    $scope.movieList = message.data.Search;
                    $scope.totalResults = message.data.totalResults;
                    console.log("totalResults = " + $scope.totalResults);
                },
                function failCallBack(errorMessage) {
                    console.log("Error = " + errorMessage.data.Error);
                }
            );
        } else { // reset
            console.log("reset - $scope.searchValue = " + $scope.searchValue);
            $scope.movieList = {};
            $scope.totalResults = 0;
        }
    }

    $scope.update = function (movie) {
        $scope.searchValue = movie;
    };

    $scope.focusOnIt = function () {
        // this.setSelectionRange(0, $scope.searchValue.length);
        fetch();
    };

    $scope.searchSubmit = function () {
        // this.setSelectionRange(0, this.value.length);
        fetch();
    };
}

function MovieListCtrl($routeParams, $scope, $http) {
    // $scope.searchValue = "Batman";
    console.log("controller = MovieListCtrl");
    console.log("$scope = "+ $scope);
    console.log("$routeParams = "+ $routeParams[1]);
    console.log("searchValue = "+ $scope.searchValue);
    if (!jQuery.isEmptyObject($scope.searchValue)) {
        $http({
            method: 'GET',
            url: '/movies',
            params: {'title': $scope.searchValue}
        }).then(
            function successCallBack(message) {
                console.log("2 - Response = " + message.data.Response);
                console.log("2 - totalResults = " + message.data.totalResults);
                $scope.movieList = message.data.Search;
            },
            function failCallBack(errorMessage) {
                console.log("Error = " + errorMessage.data.Error);
            }
        );
    }else { // reset
        console.log("reset - searchValue = " + $scope.searchValue);
        $scope.movieList = {};
        $scope.totalResults = 0;
    }
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

    console.log('routeParams.id: ' + $routeParams.id);

    $http({
        method: 'GET',
        url: '/movies/' + $routeParams.id
    }).then(
        function successCallBack(message) {
            console.log("Response = " + message.data.Response);
            console.log("imdbID = " + message.data.imdbID);
            console.log("Title = " + message.data.Title);
            movieVm.movieData = message.data;
        },
        function failCallBack(messageError) {
            console.log("Error = " + messageError.data.Error);
        }
    );
}

