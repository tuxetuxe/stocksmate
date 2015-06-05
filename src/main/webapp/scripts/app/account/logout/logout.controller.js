'use strict';

angular.module('stocksmateApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
