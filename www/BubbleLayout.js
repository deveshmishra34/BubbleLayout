var exec = require('cordova/exec');

module.exports.add = function (arg0, success, error){
    exec(success, error,'BubbleLayout', 'add', [arg0]);
}

module.exports.subtract = function (arg0, success, error) {
    exec(success, error, 'BubbleLayout', 'subtract', [arg0]);
}
