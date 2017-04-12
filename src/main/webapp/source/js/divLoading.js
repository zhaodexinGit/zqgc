/* 
* divLoading 1.0
* Copyright (c) 2014 fanYongWei
* Date: 2013-01-09
* 显示加载层
*/ 
;(function($) {
		   
$.divLoading   = function(path,info) { showLoading(path,info); };
$.unDivLoading = function() { hideLoading(); };

//显示动画
function showLoading(path,info) {
	 if(($("#masklayer").length!=1)){
		 var $masklayerDiv = $('<div id="masklayer" style="background: #000;filter: alpha(opacity=30);-moz-opacity: 0.1;opacity: 0.1;'
		+' top: 0px;left: 0px;position: fixed;z-index: 10000;display: none;"></div>'
		+'<div id="checkFlash" style="display:none;width:298px;height:58px;position:fixed;background:#ffffff;z-index:10001;border:1px solid #ffcc00;">'
		 +' <p style="height:32px;margin:0;padding:0;line-height:32px;padding-top:15px;padding-left:42px;font-size:12px;color:#ff6600;"> '
			  +'<span style="float:left;margin-right:8px;"><img src="'+path+'"></span> '
			 + '<span name="info"></span> '
		 + '</p>'
		+'</div>'); 
		 $("body").append($masklayerDiv);
	  }
	resetPosition();
	$("#masklayer").show();
	$("#checkFlash > p > span[name=info]").html(info);
	$("#checkFlash").show();
	$(window).bind("resize", function(){resetPosition();});
}
//隐藏动画
function hideLoading() {
	$("#checkFlash").hide();
	$("#masklayer").hide();
	$(window).unbind("resize");
}
function resetPosition() {
	$("#masklayer").css({'width':$(window).width(),'height':$(window).height()});
	var left = $(window).width() / 2 - $("#checkFlash").width() / 2;
	var top = $(window).height() / 2 - $("#checkFlash").height() / 2;
	if(typeof(nested) != "undefined" && typeof($bookSelectedButton) != "undefined"){
		top = $bookSelectedButton.offset().top;
	}
	$("#checkFlash").css({'left':left,'top':top});
}
})(jQuery);
