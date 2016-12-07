<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>表字段</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '表名',
				field : 'tableName',
				align : 'center'
			}, {
				title : '列名',
				field : 'columnName',
				align : 'center'
			}, {
				title : '数据类型',
				field : 'columnType',
				align : 'center'
			}, {
				title : '显示名',
				field : 'label',
				align : 'center'
			}, {
				title : '输入提示',
				field : 'placeholder',
				align : 'center'
			}, {
				title : '录入类型',
				field : 'inputType',
				align : 'center'
			}, {
				title : '数据字典',
				field : 'dictType',
				align : 'center'
			}, {
				title : '自定义数据字典',
				field : 'dictList',
				align : 'center'
			}, {
				title : '校验规则',
				field : 'rules',
				align : 'center'
			} ],
			url : "${CP}/crud/column.do?method=loadData",
			queryParams : getQueryParams
		});
		//选择表时，自动隐藏表名列
		if("${param.tableName }"!=""){
			$("#dataTable").bootstrapTable('hideColumn','tableName');
		}
		$("#tableName").change(function(){
			if($("#tableName").val()!=""){
				$("#dataTable").bootstrapTable('hideColumn','tableName');
			}
		});
	});
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 代码工厂 <span class="c-gray en">&gt;</span> 表字段 <a
			class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="search">
			<form class="form-horizontal" onsubmit="return false;">
			<input type="text" class="input-text" placeholder="表名" id="tableName" name="tableName" value="${param.tableName }">
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