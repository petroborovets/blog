(function() {
    'use strict';

    angular
        .module('borovetsApp')
        .controller('PhotoController', PhotoController);

    PhotoController.$inject = ['Photo'];

    function PhotoController(Photo) {

        var vm = this;

        vm.photos = [];

        loadAll();

        function loadAll() {
            Photo.query(function(result) {
                vm.photos = result;
                vm.searchQuery = null;
            });
        }
    }
})();
