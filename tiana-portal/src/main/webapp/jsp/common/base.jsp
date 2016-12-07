<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="dict" uri="/dict"%>
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

<!--meta-->
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/favicon.ico" >
<LINK rel="Shortcut Icon" href="/favicon.ico" />

<!-- 基础css -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-table/bootstrap-table.css"/>
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/font-awesome-4.5.0/css/font-awesome.min.css" />

<!--基础js-->
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/jquery/jquery.form.js"></script>

<!-- layer -->
<script type="text/javascript" src="${CP}/static/js/lib/layer/layer.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/layer/myLayer.js"></script>

<!-- 自定义 -->
<script type="text/javascript" src="${CP}/static/js/core/lang/string.js"></script>
<script type="text/javascript" src="${CP}/static/js/core/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/common.js"></script>
<script type="text/javascript" src="${CP}/static/js/app/base.js"></script>

<!--[if lt IE 9]>
<script type="text/javascript" src="${CP}/static/js/lib/html5/html5.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/html5/respond.min.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/PIE-2.0beta1/PIE_IE678.js"></script>
<![endif]-->

<!-- H-UI -->
<script type="text/javascript" src="${CP}/static/js/lib/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${CP}/static/js/lib/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${CP}/static/js/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script> 
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui/css/H-ui.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/Hui-iconfont/1.0.7/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui.admin/skin/blue/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/h-ui.admin/css/style.css" />

<!--[if IE 6]>
<script type="text/javascript" src="${CP}/static/js/lib/PIE-2.0beta1/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<!-- 自定义css -->
<link rel="stylesheet" type="text/css" href="${CP}/static/css/base.css" />
<link rel="stylesheet" type="text/css" href="${CP}/static/css/style.css" />
