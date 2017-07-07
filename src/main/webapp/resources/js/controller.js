/**
 * Created by shams on 4/3/2017.
 */


var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http) {

    $scope.refreshCart = function () {
        $http.get("/eMusicStore/rest/cart/" + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            }).error(function () {
            alert("error occured during getting cart.");
        });
    };

    $scope.clearCart = function () {
        $http.delete("/eMusicStore/rest/cart/" + $scope.cartId)
            .success(function (data) {
                $scope.refreshCart();
            });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.addToCart = function (productId) {

        $http.put("/eMusicStore/rest/cart/add/" + productId)
            .success(function () {
            alert("hello tabrez! Product successsfully added to cart.");
        }).error(function () {
            alert("Please sign in First for making order");
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put("/eMusicStore/rest/cart/remove/" + productId).success(function (data) {
            $scope.refreshCart();
        }).error(function () {
            alert("Please sign in First for making order"+productId);
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;
        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    };
});