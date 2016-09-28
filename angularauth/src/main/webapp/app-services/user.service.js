(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};
        var path='http://localhost:9080/angularauthbackend/user/';

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get(path).then(handleSuccess, handleError('Error getting all users'));
        }

        function GetById(id) {
            return $http.get(path + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get(path + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            return $http.post(path, user).then(handleSuccess2, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put(path + user.id, user).then(handleSuccess2, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete(path + id).then(handleSuccess2, handleError('Error deleting user'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }
        
        function handleSuccess2(res) {
            return { success: true};
        }
        

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();