<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>系统用户 - 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				account : "required;username;remote(${CP}/sys/user.do?method=chkAccount)",
				password : "required;password",
				name : "required;chinese",
				sex : "required;",
				phone : "phone",
				email : "required;email"
			}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="account" name="account" >
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" class="input-text" placeholder=""  id="password" name="password" >
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>姓名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="name" name="name" >
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<dict:select cssClass="select" sort="SEX" id="sex" name="sex" key="1"/>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>联系电话：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="phone" name="phone" >
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱地址：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="email" name="email" >
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><dict:select cssClass="select" sort="STATUS" id="status" name="status" key="1"/></span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3">备注：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<textarea class="textarea" placeholder=""  id="remark" name="remark"></textarea>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
					<button type="submit" class="btn btn-success radius" ><i class="icon-ok"></i> 确定</button>
					<button type="submit" class="btn btn-default radius"  onclick="MyLayer.close();"><i class="icon-cancel"></i> 关闭</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>
