/**
 * 基本公共类
 */
(function(window) {
	if (typeof (Common) == "undefined") {
		Common = function() {
		};
	}

	/**
	 * ajax提交统一控制，自动添加ajax=true参数，检测超时、禁止访问等
	 * 
	 * @param data
	 */
	Common.ajax = function(option) {
		var callback = option.success;
		if (option.success) {
			delete option.success;
		}
		if (option.url && option.url.indexOf("ajax=true")) {
			option.url = option.url + "&ajax=true";
		}
		var defaultOption = {
			url : "",
			type : "post",
			async : true,
			dataType : "json",
			data : {

			},
			/**
			 * 成功回调方法：再原有的基础上包上一层检测超时、禁止访问等
			 */
			success : function(data) {
				if (data && data.code) {
					if (data.code == "SUCCESS") {
						if (typeof (callback) == "function") {
							callback(data);
						} else if (data.msg) {
							MyLayer.alert(data.msg);
						}
					} else if (data.msg) {
						MyLayer.alert(data.msg);
					}
				}
			},
			error : function(data) {
				if (data.responseJSON) {
					//var status = data.responseJSON.status;
					var msg = data.responseJSON.msg;
					if (msg) {
						MyLayer.alert(msg);
					}
				} else {
					MyLayer.alert("系统错误！");
				}
			}
		};
		option = $.extend(true, {}, defaultOption, option);
		$.ajax(option);
	};
}(window));