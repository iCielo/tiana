<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="base.jsp"%>

<!-- bootstrap-table -->
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/my-bootstrap-table.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>

<script type="text/javascript">
	$(function() {
		$(window).resize(function() {
			$("#dataTable").bootstrapTable('resetWidth');
			$(".panel").css({
				"min-height" : $(window).height() - 22
			});
		});
		$(".panel").css({
			"min-height" : $(window).height() - 22
		});
		//$("form select").change(query);
		$("form input").keyup(function(e) {
			if (Common.isEnterKey(e)) {
				query();
			}
		});
		$("form input").each(function(){
			if($(this).attr("title")!=""){
				$(this).attr("title",$(this).attr("placeholder"));
			}
		});
		$("button[type=submit]").click(query);
		$("button[type=reset]").click(function() {
			if ($("#searchForm > form").size() > 0) {
				$("#searchForm > form")[0].reset();
			}
		});
		
		//页面路径，如/sys/user.do
		var baseUrl = window.location.href.substring(0,window.location.href.indexOf(".do")+3);
		
		//新增
		$("[action=add]").click(function(){
			MyLayer.open({
				title : $(this).attr("title")?$(this).attr("title"):"新增"+$("title").text(),
				content : $(this).attr("content") ? $(this).attr("content") : baseUrl + "?method=add",
				area : [ $(this).attr("area-width") ? $(this).attr("area-width") : '50%', $(this).attr("area-height") ? $(this).attr("area-height") : '500px' ]
			});
		});
		//修改
		$("[action=upd]").click(function(){
			var rows = $("#dataTable").bootstrapTable('getSelections');
			if (rows.length != 1) {
				MyLayer.msg("请选择一条记录修改！");
				return;
			}
			MyLayer.open({
				title : $(this).attr("title")?$(this).attr("title"):"修改"+$("title").text(),
				content : $(this).attr("content") ? $(this).attr("content") : baseUrl + "?method=upd&id=" + rows[0].id,
				area : [ $(this).attr("area-width") ? $(this).attr("area-width") : '50%', $(this).attr("area-height") ? $(this).attr("area-height") : '500px' ]
			});
		});
		//删除
		$("[action=del]").click(function(){
			var rows = $("#dataTable").bootstrapTable('getSelections');
			if (rows.length == 0) {
				MyLayer.msg("请选择要删除的记录！");
				return;
			}
			var ids = [];
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			MyLayer.confirm("是否真的删除？", function(index) {
				Common.ajax({
					url : $(this).attr("content") ? $(this).attr("content") : baseUrl + "?method=delEntity",
					data : {
						ids : ids.join(",")
					},
					success : function(data) {
						query();
					}
				});
			});
		});
	});

	/* 查询 */
	function query() {
		$("#dataTable").bootstrapTable('refresh');
	}

	/* 查询参数 */
	function getQueryParams(params) {
		$("form input,form select").each(function(i, obj) {
			params[$(obj).prop("name")] = $(obj).val().trim();
		});
		params["ajax"]=true;
		return params;
	}

	/* 获取选中的某个字段值，返回数组。 */
	function getSelections(field) {
		if (!field) {
			field = "id";
		}
		var rows = $("#dataTable").bootstrapTable('getSelections');
		if (rows.length == 0) {
			return [];
		}
		var arr = [];
		for (var i = 0; i < rows.length; i++) {
			arr.push(rows[i][field]);
		}
		return arr;
	}
	
	/**获取状态的html值*/
	function statusFormatter(value, row, index){
		if(value=="1"){
			return '<span class="label label-success radius">已启用</span>';
		} else {
			return '<span class="label radius">已停用</span>';
		}
	}
</script>