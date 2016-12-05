<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>用户角色 - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				name : "required;length(~255);remote(${CP}/sys/role.do?id=${entity.id}&method=chkName)",
				status : "required;",
				remark : "length(~255);",
			}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
			<input type="hidden" id="id" name="id" value="${entity.id}">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色代码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"  placeholder=""  id="code" name="code" value="${entity.code}" disabled="disabled">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text"  placeholder=""  id="name" name="name" value="${entity.name}">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><dict:select cssClass="form-control input-sm" sort="STATUS" id="status" name="status" key="${entity.status }"/></span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea class="textarea" placeholder=""  id="remark" name="remark">${entity.remark }</textarea>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="submit" class="btn btn-success radius" ><i class="icon-ok"></i> 确定</button>
					<button type="submit" class="btn btn-success radius"  onclick="MyLayer.close();"><i class="icon-cancel"></i> 关闭</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>
