<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>表字段-修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				id : "required;length(~36);",
				tableName : "required;length(~50);",
				columnName : "required;length(~50);",
				columnType : "required;length(~50);",
				label : "required;length(~50);",
				placeholder : "length(~100);",
				inputType : "required;length(~50);",
				dictType : "length(~50);",
				dictList : "length(~255);",
				opUserId : "length(~36);",
			}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
			<input type="hidden" id="id" name="id" value="${entity.id}" />				
			<input type="hidden" id="javaMethodName" name="javaMethodName" value="${entity.javaMethodName}" />
			<input type="hidden" id="primaryKey" name="primaryKey" value="${entity.primaryKey}" />
			<input type="hidden" id="nullable" name="nullable" value="${entity.nullable}" />
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>表名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="tableName" name="tableName"
							value="<c:out value="${entity.tableName}"/>" readonly="readonly">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>列名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="columnName" name="columnName"
							value="<c:out value="${entity.columnName}"/>" readonly>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数据类型：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="columnType" name="columnType"
							value="<c:out value="${entity.columnType}"/>" readonly>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字符长度：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="length" name="length" value="<c:out value="${entity.length}"/>"
							readonly>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>java名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="javaName" name="javaName" value="<c:out value="${entity.javaName}"/>"
							readonly>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>java类型：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="javaType" name="javaType" value="<c:out value="${entity.javaType}"/>"
							readonly>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>显示名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="label" name="label" value="<c:out value="${entity.label}"/>">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>输入提示：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="placeholder" name="placeholder"
							value="<c:out value="${entity.placeholder}"/>">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>录入类型：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select class="form-control input-sm" id="inputType" name="inputType" data-option-value="${entity.inputType}">
							<option value="">--请选择--</option>
							<option value="input">输入框</option>
							<option value="textarea">文本域</option>
							<option value="select">下拉框</option>
							<option value="radio">单选框</option>
							<option value="checkbox">复选框</option>
							<option value="hidden">隐藏域</option>
							<option value="not_show">不显示</option>							
						</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>校验规则：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="rules" name="rules" value="<c:out value="${entity.rules}"/>">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数据字典类型：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<select class="form-control" id="dictType" name="dictType" data-option-value="${entity.dictType}">
							<option value="">--请选择--</option>
							<c:forEach items="${sortList }" var="item">
								<option value="${item.sort }">${item.sort }</option>
							</c:forEach>
						</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>自定义数据字典：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="dictList" name="dictList" value="<c:out value="${entity.dictList}"/>">
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
