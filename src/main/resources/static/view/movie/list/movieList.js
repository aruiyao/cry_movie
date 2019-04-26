var app = angular.module("movieListApp", []);
app.controller("movieListCtrl", function ($scope, $rootScope, $location) {
  $scope.imgName = "";
  $scope.init = function () {
    $scope.type = $location.search().type;
    $scope.downUrl = "/movie/uploadDownload/downloadImage"
    $scope.getMovieList();
  }

  $scope.getMovieList = function () {
    var req = {
      type: $scope.type
    }
    $.ajax({
      url: "/movie/queryMovieByCond",
      type: "GET",
      contentType: "application/json",
      data: req,
      success: function (data) {
        $rootScope.$apply(function () {
          $scope.movieList = data.movieList;
        })
      },
      error: function (data) {

      }
    })
  }
  $scope.gotoDetail = function (id) {
    window.location.href = "../detail/movieDetail.html?movieID=" + id
  }
})
app.config(['$locationProvider', function ($locationProvider) {
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  });
}]);
app.directive('repeatFinish', function () {
  return {
    link: function (scope, element, attr) {
      if (scope.$last == true) {
        scope.$emit('renderFinish');
      }
    }
  }
})