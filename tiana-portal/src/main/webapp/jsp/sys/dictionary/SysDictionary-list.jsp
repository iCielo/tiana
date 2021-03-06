<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>数据字典</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ {
				checkbox : true,
				align : 'center',
				valign : 'middle'
			}, {
				title : '分类',
				field : 'sort',
				align : 'center'
			}, {
				title : '字典键',
				field : 'dictKey',
				align : 'center'
			}, {
				title : '字典值',
				field : 'dictValue',
				align : 'center'
			}, {
				title : '排序值',
				field : 'seq',
				align : 'center'
			}, {
				title : '状态',
				field : 'status',
				align : 'center',
				formatter : statusFormatter
			} ],
			url : "${CP}/sys/dictionary.do?method=loadData",
			queryParams : getQueryParams
		});
	});

	//启用、禁用
	function opStatus(status) {
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length == 0) {
			if (status == "1") {
				MyLayer.msg("请选择要启用的记录！");
			} else {
				MyLayer.msg("请选择要禁用的记录！");
			}
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
		}
		Common.ajax({
			url : "${CP}/sys/dictionary.do?method=opStatus",
			data : {
				ids : ids.join(","),
				status : status
			},
			success : function(data) {
				if (data.msg) {
					MyLayer.alert(data.msg);
				}
				query();
			}
		});
	}
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 用户角色 <a
			class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="search">
			<form class="form-horizontal" onsubmit="return false;">
			<input type="text" class="input-text" placeholder="分类" id="sort" name="sort" >
			<input type="text" class="input-text" placeholder="字典键" id="dictKey" name="dictKey">
			<span class="select-box"><dict:select cssClass="select" sort="STATUS" id="status" name="status"  emptyOption="状态"/></span>
			<button type="submit" class="btn btn-success" id="" name="">
				<i class="fa fa-search"></i> 查询
			</button>
			<button type="reset" class="btn btn-default" id="" name="">
				<i class="fa fa-times"></i> 清空
			</button>
			</form>
		</div>
		<div id="toolbar">
			<button class="btn btn-primary " action="add" area-width="450px" area-height="450px">
				<i class="fa fa-plus"></i>&nbsp;新&nbsp;增
			</button>
			<button class="btn btn-primary" action="upd" area-width="450px" area-height="450px">
				<i class="fa fa-pencil-square-o"></i>&nbsp;修&nbsp;改
			</button>
			<button class="btn btn-danger " action="del">
				<i class="fa fa-trash"></i>&nbsp;删&nbsp;除
			</button>
			<button class="btn btn-primary " onclick="opStatus('1')">
				<i class="fa fa-check-circle-o"></i>启用
			</button>
			<button class="btn btn-primary " onclick="opStatus('0')">
				<i class="fa fa-ban"></i>禁用
			</button>
		</div>
		<table id="dataTable"></table>
	</div>
</body>
</html>