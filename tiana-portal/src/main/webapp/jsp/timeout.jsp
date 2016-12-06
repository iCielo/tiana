<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="./common/base.jsp"%>
<title>登录超时</title>
<script type="text/javascript">
	$(function(){
		setTimeout(function(){
			top.window.location.href = "${CP}/login";
		},3000);
	});
</script>
</head>

<body>登录超时。跳转中... ...
</body>
</html>
