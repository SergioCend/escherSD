/* ========================================================================
 * Copyright 2014 Escher96
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 Escher96

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201410152247

*/
define([], function() {
    App.Model._UsuarioModel = Backbone.Model.extend({
        defaults: {
 
		 'name' : ''        },
        initialize: function() {
          var self = this;
          this.on('invalid',function(error){
                 Backbone.trigger(self.get('componentId') + '-' + 'error',{event: 'validation', message: error.validationError});
          });
        },
        getDisplay: function(name) {
         return this.get(name);
        }
    });

    App.Model._UsuarioList = Backbone.PageableCollection.extend({
        model: App.Model._UsuarioModel,
        initialize: function() {
        },
		queryParams: {
		    currentPage: "page",
		    pageSize: "maxRecords"
		},
        parseState: function (resp, queryParams, state, options) {
          return {totalRecords: resp.totalRecords};
        },
        parseRecords: function (resp, options) {
          return resp.records;
        }
    });
    return App.Model._UsuarioModel;
});