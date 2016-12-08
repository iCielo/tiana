<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%
    String contextPath = request.getContextPath();//工程名
	String absolutePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;//绝对路径，如http://localhost:8080/contextPath
	request.setAttribute("CP", contextPath);
	request.setAttribute("AP", absolutePath);
%>
<script type="text/javascript">
	var CP = "${CP}";
	var AP = "${AP}";
</script>
<!--[if lt IE 9]>
<script type="text/javascript" src="${CP}/static/js/lib/html5/html5.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/html5/respond.min.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/PIE-2.0beta1/PIE_IE678.js"></script>
<![endif]-->
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/cryption/jquery.md5.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/h-ui/js/H-ui.js"></script> 
<!-- layer -->
<script type="text/javascript" src="${CP}/static/js/lib/layer/layer.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/layer/myLayer.js"></script>
<script type="text/javascript" src="${CP}/static/js/core/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/common.js"></script>
<script type="text/javascript" src="${CP }/static/js/lib/nice-validator-0.10.0/jquery.validator.js?local=zh-CN"></script>
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui.admin/css/H-ui.login.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/Hui-iconfont/1.0.7/iconfont.css" />
<!--[if IE 6]>
<script type="text/javascript" src="${CP}/static/js/lib/PIE-2.0beta1/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>登录</title>
<script type="text/javascript">
$(function(){
	
	$("#form").validator({
		fields : {
			account : {
				rule :"required;",
				msg:"请输入账号"
			},
			password : {
				rule :"required;",
				msg:"请输入密码"
			}
		},
		msgClass : "n-right"
	});
	
	$('#form').on('valid.form', function(e) {
		Common.ajax({
			url : "${CP}/doLogin",
			data : {
				account : $("#account").val().trim(),
				password : $.md5($("#password").val().trim())
			},
			success : function(data) {
				if(data.success){
					window.location.href="${CP}";
				} else if(data.msg){
					MyLayer.alert(data.msg);
				}
			}
		});
	});
});
</script>
</head>

<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" method="post" id="form" onsubmit="return false;">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="account" name="account" type="text" placeholder="账号" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input class="input-text size-L" type="text" placeholder="验证码"  style="width:150px;">
						<img src="${CP }/static/images/VerifyCode.aspx.png"> <a id="kanbuq" href="javascript:;">看不清，换一张</a>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online" id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"> <input name="" type="reset"
							class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright Lezic.com by H-ui.admin.v2.5</div>
</body>
</html>
