<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="base.jsp"%>

<style type="text/css">
.panel {
	margin-bottom: 0px;
}
</style>
<script type="text/javascript" src="${CP }/static/js/lib/nice-validator-0.10.0/jquery.validator.js?local=zh-CN"></script>

<script type="text/javascript">
	$(function() {
		
		//页面路径，如/sys/user.do
		var baseUrl = window.location.href.substring(0,window.location.href.indexOf(".do")+3);
		
		$('#form').on('valid.form', function(e,form) {
			var self = this;
			var url = $(this).attr("action") ? $(this).attr("action") : baseUrl + "?method=addEntity";
			if($("#id").size()!=0&&$("#id").val()!=""){
				url = $(this).attr("action") ? $(this).attr("action") : baseUrl + "?method=updEntity";
			}
			
			//使表单内所有按键都失灵，如Tab等。防止表单变更。
	        var readonly = function(event){
				if(Common.isF1ToF12(event)){
					return true;
				}
				return false;	
	        };
	        $(self).keydown(readonly);
	        //防止表单重复提交
			var me = $(form).data('validator');
	        me.holdSubmit();
	      	//提示提交中的loading层
	        var index = MyLayer.showLoading();
			Common.ajax({
				url : url,
				data : $(this).serialize(),
				success : function(data) {
					me.holdSubmit(false);
					MyLayer.closeLoading(index);
					 $(self).unbind("keydown",readonly);
					if (typeof (parent.query) == 'function') {
						parent.query();
					}
					MyLayer.close();
				}
			});
		});
	});
</script>