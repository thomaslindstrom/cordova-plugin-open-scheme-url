/**
 * www: OpenSchemeUrl.js
**/

var exec = require('cordova/exec');

exports.open = function (url, success, error) {
    exec(success, error, 'OpenSchemeUrl', 'open', [url]);
};
