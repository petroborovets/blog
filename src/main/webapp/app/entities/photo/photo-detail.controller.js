(function() {
    'use strict';

    angular
        .module('borovetsApp')
        .controller('PhotoDetailController', PhotoDetailController);

    PhotoDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Photo', 'User'];

    function PhotoDetailController($scope, $rootScope, $stateParams, previousState, entity, Photo, User) {
        var vm = this;

        vm.photo = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('borovetsApp:photoUpdate', function(event, result) {
            vm.photo = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
