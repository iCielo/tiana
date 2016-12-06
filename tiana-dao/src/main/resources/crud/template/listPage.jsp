<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>${table.menuName}</title>
<script type="text/javascript">
	$(function() {
		$('#dataTable').myBootstrapTable({
			idField : "id",
			columns : [ 
	           {
					checkbox : true,
					align : 'center',
					valign : 'middle'
				}
				#foreach( $item in $columns )
				#if( ${item.rules} != '' )
					 , {
						title : '${item.label}',
						field : '${item.javaName}',
						align : 'center'
					}
				#end
				#end				
			],
			url : "${CP}${table.controllerUrl}?method=loadData",
			queryParams : getQueryParams
		});
	});
</script>
</head>
<body>
<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> ${table.moduleName} <span class="c-gray en">&gt;</span> ${table.menuName} <a
			class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="search">
			<form class="form-horizontal" onsubmit="return false;">
			<input type="text" class="input-text" placeholder="请输入" id="name" name="name" >
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
		</div>
		<table id="dataTable"></table>
	</div>
</body>
</html>