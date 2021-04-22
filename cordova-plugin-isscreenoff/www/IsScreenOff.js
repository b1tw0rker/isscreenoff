
var exec = require('cordova/exec');

/* 
Synopsis

    cordova.exec(function(winParam) {},
                 function(error) {},
                 "service",
                 "action",
                 ["firstArgument", "secondArgument", 42, false]);
*/

exports.CooleMethode = function (argument0, success, error) {

    cordova.exec(success, error, 'IsScreenOff', 'MeineCooleAktion', [argument0]);

};





exports.CheckMethode = function (fn) {

        cordova.exec(fn, null, 'IsScreenOff', 'MeineCheckerFunktion', []);

};