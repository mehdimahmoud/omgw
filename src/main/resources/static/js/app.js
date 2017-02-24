angular
    .module('movieApp', ['ngRoute'])
    .config(['$routeProvider',function ($routeProvider) {
        $routeProvider
            .when('/movies/:movieId',{
                templateUrl: '../public/movieDetails.html',
                controller: 'MovieDetailsCtrl',
                controllerAs: 'movie'
            })
            .when('/movies',{
                templateUrl: '../public/moviesList.html',
                controller: 'MovieListCtrl',
                controllerAs: 'movies'
            })
            .otherwise({
                redirectTo: '/'
            });
    }])
    .controller('MainCtrl', ['$route', '$routeParams', '$location',
        function MainCtrl($route, $routeParams, $location, $scope, $http) {
            this.$route = $route;
            this.$routeParams = $routeParams;
            this.$location = $location;

            this.searchSubmit = function() {
                console.log('searchValue: ' + $routeParams);
                $http({
                    method: 'GET',
                    url: '/movies',
                    params: {title: this.searchValue}
                }).then(function successCallBack(response) {

                });
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