(function() {
  'use strict';

  angular
    .module('angular')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($resource, url, urlPhotoSearch, urlPhotoOne) {
    var vm = this;
    vm.urlPhotoOne = url + urlPhotoOne;
    vm.photoCriteria = {
      name:""
      ,description: ""
    };

    var Photo = $resource(url + urlPhotoSearch, {});
    vm.refresh = function () {
      vm.items = Photo.query(vm.photoCriteria);
    }

    vm.handleEvent = function (event) {
      vm.refresh();
    }

    vm.refresh();
  }
})();
