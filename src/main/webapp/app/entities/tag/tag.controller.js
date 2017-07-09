(function() {
    'use strict';

    angular
        .module('borovetsApp')
        .controller('TagController', TagController);

    TagController.$inject = ['Tag'];

    function TagController(Tag) {

        var vm = this;

        vm.tags = [];

        loadAll();

        function loadAll() {
            Tag.query(function(result) {
                vm.tags = result;
                vm.searchQuery = null;
            });
        }
    }
})();
