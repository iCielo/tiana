<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>数据库表</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '模块代码',
				field : 'moduleCode',
				align : 'center'
			}, {
				title : '模块名',
				field : 'moduleName',
				align : 'center'
			}, {
				title : '菜单名',
				field : 'menuName',
				align : 'center'
			}, {
				title : '表名',
				field : 'tableName',
				align : 'center',
				formatter : function(value, row, index) {
					var html = [];
					html.push('<a href="${CP}/crud/column.do?method=list&tableName='+value+'">'+value+'</a>');
					return html.join("");
				}
			}, {
				title : '控制器映射路径',
				field : 'controllerUrl',
				align : 'center'
			},{
				title : '操作',
				align:'center',
				formatter : function(value, row, index) {
					var html = [];
					html.push('<a href="javascript:;" onclick="updateColumns(\''+row.tableName+'\')" title="更新表字段"><i class="fa fa-refresh fa-lg"></i></a>');
					html.push('    <a href="javascript:;" onclick="processCode(\''+row.tableName+'\')" title="生成代码"><i class="fa fa-play-circle-o fa-lg"></i></a>');
					return html.join("");
				}
			} ],
			url : "${CP}/crud/table.do?method=loadData",
			queryParams : getQueryParams
		});
	});
	
	//更新表字段
	function updateColumns(tableName){
		Common.ajax({
			url : "${CP}/crud/table.do?method=updateColumns",
			data : {
				tableName : tableName
			}
		});
	}
	
	//运行
	function processCode(tableName){
		Common.ajax({
			url : "${CP}/crud/table.do?method=processCode",
			data : {
				tableName : tableName
			}
		});
	}
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代码工厂 <span class="c-gray en">&gt;</span> 数据库表 <a
			class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="search">
			<form class="form-horizontal" onsubmit="return false;">
			<input type="text" class="input-text" placeholder="表名" id="tableName" name="tableName" >
			<button type="submit" class="btn btn-success" id="" name="">
				<i class="fa fa-search"></i> 查询
			</button>
			<button type="reset" class="btn btn-default" id="" name="">
				<i class="fa fa-times"></i> 清空
			</button>
			</form>
		</div>
		<div id="toolbar">
			<button class="btn btn-primary " action="add" >
				<i class="fa fa-plus"></i>&nbsp;新&nbsp;增
			</button>
			<button class="btn btn-primary" action="upd">
				<i class="fa fa-pencil-square-o"></i>&nbsp;修&nbsp;改
			</button>
			<button class="btn btn-danger " action="del">
				<i class="fa fa-trash"></i>&nbsp;删&nbsp;除
			</button>
		</div>
		<table id="dataTable"></table>
	</div>
</body>
</html>