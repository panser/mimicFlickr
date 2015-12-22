(function() {
  'use strict';

  angular
    .module('angular')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log, $rootScope) {
    $rootScope.$on('$stateChangeError', function(){
      throw arguments[5];
    });

    $log.debug('runBlock end');
  }

})();
