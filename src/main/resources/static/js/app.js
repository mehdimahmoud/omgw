angular
    .module('movieApp', ['ngRoute','ngAnimate'])
    .config(['$routeProvider','$locationProvider',function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/movies/:movieId',{
                templateUrl: '../public/movieDetail.html',
                controller: 'MovieDetailsCtrl',
                controllerAs: 'movie'
            })
            .when('/movies',{
                templateUrl: '../public/listMovies.html',
                controller: 'MovieListCtrl',
                controllerAs: 'movies'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }])
    .controller('MainCtrl', ['$route', '$routeParams', '$location',
        function MainCtrl($route, $routeParams, $location, $scope, $http) {
            this.$route = $route;
            this.$routeParams = $routeParams;
            this.$location = $location;

            $scope.searchSubmit = function () {
                $http({
                    method: 'GET',
                    url: '/movies',
                    params: {title: $scope.searchValue}
                }).then(function successCallBack(response) {

                })
            };
        }
        ])
    .controller('MovieDetailsCtrl',['$routeParams',
        function MovieDetailsCtrl($routeParams) {
            this.name = 'MovieDetailsCtrl';
            this.params = $routeParams;
        }])
    .controller('MovieListCtrl',['$routeParams',
        function MovieListCtrl($routeParams) {
            this.name = 'MovieListCtrl';
            this.params = $routeParams;
        }]);
