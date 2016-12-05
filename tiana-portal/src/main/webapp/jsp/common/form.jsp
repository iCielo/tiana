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
		
		$('#form').on('valid.form', function(e) {
			var url = $(this).attr("action") ? $(this).attr("action") : baseUrl + "?method=addEntity";
			if($("#id").size()!=0&&$("#id").val()!=""){
				url = $(this).attr("action") ? $(this).attr("action") : baseUrl + "?method=updEntity";
			}
			Common.ajax({
				url : url,
				data : $(this).serialize(),
				success : function(data) {
					if (typeof (parent.query) == 'function') {
						parent.query();
					}
					MyLayer.close();
				}
			});
		});
	});
</script>