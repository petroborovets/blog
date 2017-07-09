(function() {
    'use strict';
    angular
        .module('borovetsApp')
        .factory('Photo', Photo);

    Photo.$inject = ['$resource', 'DateUtils'];

    function Photo ($resource, DateUtils) {
        var resourceUrl =  'api/photos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.dateCreated = DateUtils.convertLocalDateFromServer(data.dateCreated);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(copy.dateCreated);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.dateCreated = DateUtils.convertLocalDateToServer(copy.dateCreated);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
