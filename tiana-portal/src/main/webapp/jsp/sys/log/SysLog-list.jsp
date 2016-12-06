<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>系统日志</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '主键',
				field : 'id',
				align : 'center'
			}, {
				title : '线索ID',
				field : 'clue',
				align : 'center'
			}, {
				title : '模块',
				field : 'module',
				align : 'center'
			}, {
				title : '菜单',
				field : 'menu',
				align : 'center'
			}, {
				title : '内容',
				field : 'detail',
				align : 'center'
			}, {
				title : '结果',
				field : 'result',
				align : 'center'
			}, {
				title : '耗时',
				field : 'costTime',
				align : 'center'
			}, {
				title : '用户ID',
				field : 'userId',
				align : 'center'
			} ],
			url : "${CP}/sys/log.do?method=loadData",
			queryParams : getQueryParams
		});
	});
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 系统日志 <a class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="search">
			<form class="form-horizontal" onsubmit="return false;">
				<input type="text" class="input-text" placeholder="线索ID" id="clue" name="clue">
				<button type="submit" class="btn btn-success" id="" name="">
					<i class="fa fa-search"></i> 查询
				</button>
				<button type="reset" class="btn btn-default" id="" name="">
					<i class="fa fa-times"></i> 清空
				</button>
			</form>
		</div>
		<div id="toolbar">
			<button class="btn btn-danger " action="del">
				<i class="fa fa-trash"></i>&nbsp;删&nbsp;除
			</button>
		</div>
		<table id="dataTable"></table>
	</div>
</body>
</html>
