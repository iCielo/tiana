<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/list.jsp"%>
<title>资源菜单</title>
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
													 , {
						title : '主键',
						field : 'id',
						align : 'center'
					}
																	 , {
						title : '资源码',
						field : 'code',
						align : 'center'
					}
																	 , {
						title : '资源名称',
						field : 'name',
						align : 'center'
					}
																	 , {
						title : '资源链接地址',
						field : 'url',
						align : 'center'
					}
																	 , {
						title : '父资源',
						field : 'parentCode',
						align : 'center'
					}
																	 , {
						title : '类型',
						field : 'type',
						align : 'center'
					}
																	 , {
						title : '操作用户ID',
						field : 'opUserId',
						align : 'center'
					}
																			],
			url : "${CP}/sys/resource.do?method=loadData",
			queryParams : getQueryParams
		});
	});
</script>
</head>
<body>
<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 资源菜单 <a
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
