'use strict';

/*
This is an Angular module, which will represent our application
*/
window.globals = {
    address: {
        formated_address: "",
        lat: 0.0,
        lng: 0.0
    }
};
angular.module('SampleApplication', [
    'ngResource',
    'ngRoute',
    'ui.bootstrap.tabs',
    'ui.bootstrap.dropdownToggle',
    'SampleApplication.Angular.Caching',
    'SampleApplication.Config',
    'SampleApplication.Angular.Data',
    'SampleApplication.Angular.Loader',
    'angular-storage'

]).
config(['$routeProvider', '$provide', '$httpProvider', function ($routeProvider, $provide, $httpProvider) {

    $routeProvider.when(
    '/home', {
        templateUrl: '/app/index.html',
        controller: "HomeController"
    });

     	$routeProvider.when(
       '/signIn', {
           templateUrl: '/app/angular/data/signIn.html',
           controller: 'SignInController'
    });

	$routeProvider.when(
       '/register', {
           templateUrl: '/app/angular/data/register.html',
           controller: 'RegisterController'
    });
    
    	$routeProvider.when(
       '/driverReg', {
           templateUrl: '/app/angular/data/becomeDriver.html',
           controller: 'driverRegController'
    });
    
    	$routeProvider.when(
       '/PartnerReg', {
           templateUrl: '/app/angular/data/becomePartner.html',
           controller: 'partnerRegController'
    });
     	$routeProvider.when(
       '/AdminPortal', {
           templateUrl: '/app/angular/data/adminPortal.html',
           controller: 'AdminController'
    });
     	$routeProvider.when(
       '/PartnerPortal', {
           templateUrl: '/app/angular/data/partnerPortal.html',
           controller: 'PartnerController'
    });
    	$routeProvider.when(
       '/RestuarantPortal', {
           templateUrl: '/app/angular/data/RestuarantPortal.html',
           controller: 'RestuarantRegController'
    });
    	$routeProvider.when(
       '/updateProfile', {
           templateUrl: '/app/angular/data/updateProfile.html',
           controller: 'UpdateProfileController'
    });
        $routeProvider.when(
       '/updateEmailAndPassword', {
           templateUrl: '/app/angular/data/updateEmailAndPassword.html',
           controller: 'UpdateEmailAndPasswordController'
    });
    $routeProvider.when(
       '/orderHistory', {
           templateUrl: '/app/angular/data/orderHistory.html',
           controller: 'orderHistoryController'
    });
    $routeProvider.when(
       '/FAQs', {
           templateUrl: '/app/angular/data/FAQs.html',
           controller: 'FAQsController'
    });
    $routeProvider.when(
       '/termsAndConditions', {
           templateUrl: '/app/angular/data/TermsAndConditions.html',
           controller: 'termsAndConditionsController'
    });
    $routeProvider.when(
       '/forgotPassword', {
           templateUrl: '/app/angular/data/forgotPassword.html',
           controller: 'forgotPasswordController'
    });
     $routeProvider.when(
       '/sendforgotEmail', {
           templateUrl: '/app/angular/data/sendEmail.html',
           controller: 'sendforgotEmailController'
    });
     $routeProvider.when(
       '/viewRestaurant', {
           templateUrl: '/app/angular/data/viewRestaurants.html',
           controller: 'viewRestaurantController'
    });
     $routeProvider.when(
       '/menu', {
           templateUrl: '/app/angular/data/menu.html',
           controller: 'menuController'
    });
     $routeProvider.when(
       '/goToCart', {
           templateUrl: '/app/angular/data/shoppingCart.html',
           controller: 'shoppingCartController'
    });
     $routeProvider.when(
       '/reviewOrderDetails', {
           templateUrl: '/app/angular/data/reviewOrderDetails.html',
           controller: 'reviewOrderDetailController'
    });
     $routeProvider.when(
       '/cashPayment', {
           templateUrl: '/app/angular/data/cashPayment.html',
           controller: 'cashPaymentController'
    });
     $routeProvider.when(
       '/creditCardPayment', {
           templateUrl: '/app/angular/data/creditCardPayment.html',
           controller: 'creditCardPaymentController'
    });
    
    
    
    $routeProvider.otherwise({
        redirectTo: '/home'
    });

    $httpProvider.interceptors.push('SmartCacheInterceptor');
}])
;