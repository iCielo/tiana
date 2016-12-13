<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common/base.jsp"%>
<title>H-ui.admin v2.5</title>
<!-- 日期控件 -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/bootstrap-daterangepicker/daterangepicker.css" />
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="${CP}/static/js/lib/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- icheck -->
<link rel="stylesheet" type="text/css" href="${CP}/static/js/lib/icheck/icheck.css" />
<script type="text/javascript" src="${CP}/static/js/lib/icheck/jquery.icheck.min.js"></script>

<script type="text/javascript">
	$(function() {
		//单选框、复选框
		$('input[type=radio],input[type=checkbox]').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
		//日期
		$('#day').daterangepicker({
			singleDatePicker : true,
			showDropdowns : true,
		});
		//时间
		$('#time').daterangepicker({
			singleDatePicker : true,
			showDropdowns : true,
			timePicker : true,
			autoApply : true,
			startDate : moment().subtract(6, 'days'),
			locale : {
				format : 'YYYY-MM-DD HH:mm'
			}
		});
		//范围
		$('#range').daterangepicker({
			showDropdowns : true,
			autoApply : true,//是否显示确定、取消按钮
			startDate : moment().subtract(6, 'days'),
			endDate : moment()
		});
		//最近
		$('#recent').daterangepicker(
				{
					startDate : moment(),
					endDate : moment(),
					ranges : {
						'今天' : [ moment(), moment() ],
						'昨天' : [ moment().subtract(1, 'days'),
								moment().subtract(1, 'days') ],
						'最近一周' : [ moment().subtract(6, 'days'), moment() ],
						'最近一个月' : [ moment().subtract(29, 'days'), moment() ],
						'本月' : [ moment().startOf('month'),
								moment().endOf('month') ],
						'上个月' : [
								moment().subtract(1, 'month').startOf('month'),
								moment().subtract(1, 'month').endOf('month') ]
					}
				});
	});
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="panel panel-default">
			<div class="panel-header">表单组件</div>
			<div class="panel-body">
				<form action="" method="post" class="form form-horizontal" id="form">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下拉框：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<span class="select-box"> <select class="select" size="1" name="demo1">
									<option value="" selected>默认select</option>
									<option value="1">菜单一</option>
									<option value="2">菜单二</option>
									<option value="3">菜单三</option>
							</select>
							</span>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>复选框：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<div class="check-box">
								<input type="checkbox" id="checkbox-1"> <label for="checkbox-1">复选框</label>
							</div>
							<div class="check-box">
								<input type="checkbox" id="checkbox-2" checked> <label for="checkbox-2">复选框 checked状态</label>
							</div>
							<div class="check-box">
								<input type="checkbox" id="checkbox-disabled" disabled> <label for="checkbox-disabled">Disabled</label>
							</div>
							<div class="check-box">
								<input type="checkbox" id="checkbox-disabled-checked" checked disabled> <label for="checkbox-disabled-checked">Disabled &amp; checked</label>
							</div>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>单选：</label>
						<div class="formControls col-xs-8 col-sm-9">

							<div class="radio-box">
								<input type="radio" id="radio-1" name="demo-radio1"> <label for="radio-1">单选按钮</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="radio-2" name="demo-radio1" checked> <label for="radio-2">单选按钮 checked状态</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="radio-disabled" disabled> <label for="radio-disabled">Disabled</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="radio-disabled-checked" checked disabled> <label for="radio-disabled-checked">Disabled &amp; checked</label>
							</div>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>输入框：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" placeholder="迷你尺寸" class="input-text   size-MINI"> <input type="text" placeholder="小尺寸" class="input-text mt-20  size-S">
							<input type="text" placeholder="默认尺寸" class="input-text mt-20  size-M"> <input type="text" placeholder="大尺寸" class="input-text mt-20  size-L">
							<input type="text" placeholder="特大尺寸" class="input-text mt-20  size-XL">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上传按钮：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<span class="btn-upload"> <a href="javascript:void();" class="btn btn-primary radius"><i class="fa fa-cloud-upload" aria-hidden="true"></i>
									浏览文件</a> <input type="file" multiple name="file_0" class="input-file">
							</span>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>带文本框：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<span class="btn-upload "> <input class="input-text upload-url radius" type="text" name="uploadfile-1" id="uploadfile-1" readonly>
							<a
								href="javascript:void();" class="btn btn-primary radius"><i class="fa fa-cloud-upload" aria-hidden="true"></i> 浏览文件
							</a> <input type="file" multiple name="file-1" class="input-file">
							</span>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>文本域：</label>
						<div class="formControls col-xs-8 col-sm-9">
						<textarea class="textarea" placeholder=""  id="remark" name="remark"></textarea>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>日期：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text input-time" placeholder="" id="day" name="day">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>时间：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text input-time" placeholder="" id="time" name="time">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>范围：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text input-time" placeholder="" id="range" name="range">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>最近：</label>
						<div class="formControls col-xs-8 col-sm-9">
							<input type="text" class="input-text input-time" placeholder="" id="recent" name="recent">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-header">面板标题</div>
			<div class="panel-body">面板内容</div>
		</div>
		<div class="panel panel-secondary mt-20">
			<div class="panel-header">面板标题</div>
			<div class="panel-body">面板内容</div>
		</div>
		<div class="panel panel-success mt-20">
			<div class="panel-header">面板标题</div>
			<div class="panel-body">面板内容</div>
		</div>
		<div class="panel panel-warning mt-20">
			<div class="panel-header">面板标题</div>
			<div class="panel-body">面板内容</div>
		</div>
		<div class="panel panel-danger mt-20">
			<div class="panel-header">面板标题</div>
			<div class="panel-body">面板内容</div>
		</div>
	</div>
</body>
</html>