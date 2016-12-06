<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>数据字典 - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				seq : "required;integer;",
				status : "required;length(~50);",
				sort : "required;length(~255);",
				remark : "length(~255);",
				dictKey : "required;length(~255);remote[${CP}/sys/dictionary.do?method=chkDictKey, id, sort]",
				dictValue : "required;length(~255);",
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
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>分类：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="sort" name="sort" value="${entity.sort }" disabled="disabled">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字典键：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="dictKey" name="dictKey" value="${entity.dictKey }" disabled="disabled">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>字典值：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="dictValue" name="dictValue"  value="${entity.dictValue }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排序值：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder=""  id="seq" name="seq"  value="${entity.seq }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><dict:select cssClass="select" sort="STATUS" id="status" name="status" key="${entity.status }"/></span>
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
					<button type="submit" class="btn btn-default radius"  onclick="MyLayer.close();"><i class="icon-cancel"></i> 关闭</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>
