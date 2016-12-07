<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>资源菜单 - 新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
															code : "required;length(~255);",
												name : "required;length(~255);",
												url : "required;length(~255);",
												parentCode : "required;length(~255);",
												type : "required;integer;",
																					}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
																																																																						<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span> 资源码：</label>
					<div class="formControls col-xs-8 col-sm-9">
													<input class="input-text" type="text" id="code" name="code"  value="<c:out value="${entity.code}"/>"/>
																																			</div>
				</div> 
													<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span> 资源名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
													<input class="input-text" type="text" id="name" name="name"  value="<c:out value="${entity.name}"/>"/>
																																			</div>
				</div> 
													<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span> 资源链接地址：</label>
					<div class="formControls col-xs-8 col-sm-9">
													<input class="input-text" type="text" id="url" name="url"  value="<c:out value="${entity.url}"/>"/>
																																			</div>
				</div> 
													<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span> 父资源：</label>
					<div class="formControls col-xs-8 col-sm-9">
													<input class="input-text" type="text" id="parentCode" name="parentCode"  value="<c:out value="${entity.parentCode}"/>"/>
																																			</div>
				</div> 
													<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span> 类型：</label>
					<div class="formControls col-xs-8 col-sm-9">
																									<span class="select-box"><dict:select cssClass="select" sort="SYS_RESOURCE_TYPE"  id="type" name="type"  key="${entity.type}"/></span>
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
