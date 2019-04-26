var app = angular.module("movieDetailApp", []);
app.controller("movieDetailCtrl", function ($scope, $rootScope, $location, $timeout) {
  $timeout(function () {
    /**
     * https://www.cnblogs.com/v-weiwang/p/4834672.html?ptvd
     */
    $('#form_comment').bootstrapValidator({
      message: 'This value is not valid',
      feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
      },
      fields: {
        review: {
          validators: {
            notEmpty: {
              message: '评论不能为空'
            }
          }
        }
      }
    })
  })

  $scope.init = function () {
    $scope.score = 10;
    $scope.movieID = $location.search().movieID;
    $scope.downUrl = "/movie/uploadDownload/downloadImage";
    $scope.getMovieInfo();
    $scope.getReviewList();
  }
  $('#comment').on('hide.bs.modal', function () {
    $('#form_comment').bootstrapValidator('resetForm');
  });
  $scope.getMovieInfo = function () {
    var req = {
      id: $scope.movieID
    }
    $.ajax({
      url: "/movie/queryMovieByCond",
      type: "GET",
      contentType: "application/json",
      data: req,
      success: function (data) {
        $rootScope.$apply(function () {
          $scope.movie = data.movieList[0];
        })
      },
      error: function (data) {

      }
    })
  }
  $scope.getReviewList = function () {
    var req = {
      movie: {
        id: $scope.movieID
      },
      user: {}
    }
    $.ajax({
      url: "/movie/queryReviewByCond",
      type: "post",
      contentType: "application/json",
      data: JSON.stringify(req),
      success: function (data) {
        $rootScope.$apply(function () {
          $scope.total = data.total;
          $scope.reviewList = data.reviewList;
        })
      },
      error: function (data) {

      }
    })
  }

  $scope.$watch('score', function () {
    if ($scope.score > 10) {
      $scope.score = 10
    }
    if ($scope.score < 2) {
      $scope.score = 1
    }
  })
  $scope.dateTimeFormate = function () {
    var obj = {};
    var d = new Date();
    obj.year = d.getFullYear();
    obj.month = ('0' + (d.getMonth() + 1)).slice(-2);
    obj.day = ('0' + (d.getDate())).slice(-2);
    obj.hour = ('0' + (d.getHours())).slice(-2);
    obj.minutes = ('0' + (d.getMinutes())).slice(-2);
    obj.seconds = ('0' + (d.getSeconds())).slice(-2);
    return obj
  }
  $scope.submit = function () {
    var bootstrapValidator = $("#form_comment").data('bootstrapValidator');
    //手动触发验证
    bootstrapValidator.validate();
    if (bootstrapValidator.isValid()) {
      var date = $scope.dateTimeFormate();
      var req = {
        userId: $scope.userId,
        userName: $scope.userName,
        movieId: $scope.movieID,
        movieName: $scope.movie.name,
        score: $scope.score,
        review: $scope.review,
        createTime: date.year + date.month + date.day + date.hour + date.minutes + date.seconds,
      }
      $.ajax({
        url: "/movie/addReview",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(req),
        success: function (data) {
          $rootScope.$apply(function () {
            $scope.review = "";
            $scope.score = 10;
            $scope.getReviewList();
            $scope.getMovieInfo();
            $('#comment').modal("hide");
          })
        },
        error: function (data) {
          $("#comment").modal('hide');
        }
      })
    }
  }

  $scope.showAdd = function () {
    $.ajax({
      url: "/movie/getUserInfo",
      type: "GET",
      contentType: "application/json",
      // dataType: "json",
      success: function (data) {
        $rootScope.$apply(function () {
          $scope.userName = data.userName
          $scope.userId = data.id
          if ($scope.userName !== null && $scope.userName !== '') {
            $('#comment').modal();
          } else {
            top.location.href = "/movie/view/login/login.html";
          }
        })
      },
      error: function (data) {

      }
    })
  }

})

app.config(['$locationProvider', function ($locationProvider) {
  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  });
}]);

app.filter("newdate", function () {
  return function (date) {
    return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8) + " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12)
  }
})