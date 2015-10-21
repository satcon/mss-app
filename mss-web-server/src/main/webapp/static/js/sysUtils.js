var sys = $.extend({}, sys);  // this object depends on jQuery.js

/**
 * Get The Project's Root Path
 * USAGE: sys.basePath()
 */
sys.basePath = function(){
	/*var currentPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = currentPath.indexOf(pathName);
	var localhostPath = currentPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);*/
	var local = window.location;  
    var contextPath = local.pathname.split("/")[1];  
    var basePath = local.protocol+"//"+local.host+"/"+contextPath; 
	
	return (basePath);
};


/**
 * Dynamic loading JS,CSS files
 * Usage: loading CSS file--dynamicLoading.css("test.css");
 *        loading JS  file--dynamicLoading.js("test.js");
 */
var dynamicLoading = {
	css : function(path) {
		if (!path || path.length === 0) {
			throw new Error('argument "path" is required !');
		}
		var head = document.getElementsByTagName('head')[0];
		var link = document.createElement('link');
		link.href = path;
		link.rel = 'stylesheet';
		link.type = 'text/css';
		head.appendChild(link);
	},
	js : function(path) {
		if (!path || path.length === 0) {
			throw new Error('argument "path" is required !');
		}
		var head = document.getElementsByTagName('head')[0];
		var script = document.createElement('script');
		script.src = path;
		script.type = 'text/javascript';
		head.appendChild(script);
	}
};