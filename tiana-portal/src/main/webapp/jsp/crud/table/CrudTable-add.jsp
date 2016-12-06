<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>数据库表-新增</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
				tableName : "required;length(~20);remote(${CP}/crud/table.do?method=chkTableName)",
				menuName : "required;length(~50);",
				moduleName : "required;length(~50);",
				moduleCode : "required;length(~20);",
				entity : "required;length(~255);",
				controllerUrl : "required;length(~255);",
				controller : "required;length(~255);",
				service : "required;length(~255);",
				listUrl : "required;length(~255);",
				listJsp : "required;length(~255);",
				addUrl : "required;length(~255);",
				addJsp : "required;length(~255);",
				updUrl : "required;length(~255);",
				updJsp : "required;length(~255);",
			}
		});
		
		$("#tableName").keyup(function() {
			var tableName = $(this).val().trim();
			var array = tableName.toLowerCase().split("_");
			if (array.length > 1) {
				var moduleCode = array[0];//模块代码
				var subModule = "";//子模块代码
				var entityName = "";//实体类名
				for (var i = 0; i < array.length; i++) {
					if (i > 0) {
						if (i == 1) {
							subModule += array[i].firstLowerCase();
						} else {
							subModule += array[i].firstUpperCase();
						}
					}
					entityName += array[i].firstUpperCase();
				}
				var basePackage = "com.lezic.tiana.app";
				var controllerUrl = "/" + moduleCode + "/" + subModule + ".do";
				var jsp = "/" + moduleCode + "/" + subModule + "/" + entityName;
				var mybatisXml = "/" + moduleCode + "/" + entityName + "-sql";
				var entity = entityName;
				var controller = entityName + "Controller";
				var service = entityName + "Service";

				$("#entity").val(entity);
				$("#entityBean").val(entity.firstLowerCase());
				$("#entityPackage").val(basePackage+".entity." +moduleCode);
				$("#controller").val(controller);
				$("#controllerBean").val(controller.firstLowerCase());
				$("#controllerPackage").val(basePackage+".action." +moduleCode);
				$("#service").val(service);
				$("#serviceBean").val(service.firstLowerCase());
				$("#servicePackage").val(basePackage+".service." +moduleCode);
				
				$("#moduleCode").val(moduleCode);
				$("#controllerUrl").val(controllerUrl);
				$("#listUrl").val(controllerUrl + "?method=list");
				$("#listJsp").val(jsp + "-list");
				$("#addUrl").val(controllerUrl + "?method=add");
				$("#addJsp").val(jsp + "-add");
				$("#updUrl").val(controllerUrl + "?method=upd");
				$("#updJsp").val(jsp + "-upd");
				$("#mybatisXml").val(mybatisXml);
			} else {
				$("#entity").val("");
				$("#controller").val("");
				$("#service").val("");
				$("#entityBean").val("");
				$("#controllerBean").val("");
				$("#serviceBean").val("");
				$("#entityPackage").val("");
				$("#controllerPackage").val("");
				$("#servicePackage").val("");
				$("#moduleCode").val("");
				$("#controllerUrl").val("");
				$("#listUrl").val("");
				$("#listJsp").val("");
				$("#addUrl").val("");
				$("#addJsp").val("");
				$("#updUrl").val("");
				$("#updJsp").val("");
				$("#mybatisXml").val("");
			}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
			<input type="hidden" id="id" name="id" value="${entity.id }">
			<input type="hidden" id="entityBean" name="entityBean" value="${entity.entityBean }">
			<input type="hidden" id="controllerBean" name="controllerBean" value="${entity.controllerBean }">
			<input type="hidden" id="serviceBean" name="serviceBean" value="${entity.serviceBean }">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>数据库表：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" placeholder="如sys_user，其中sys为模块码"  id="tableName" name="tableName" value="${entity.tableName }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" placeholder="请输入菜单名称" type="text" id="menuName" name="menuName"
							value="<c:out value="${entity.menuName }"/>">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模块名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" placeholder="请输入模块名称" type="text" id="moduleName" name="moduleName"
							value="<c:out value="${entity.moduleName }"/>">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>模块代码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="moduleCode" name="moduleCode" readonly value="${entity.moduleCode }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>实体类名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="entity" name="entity" readonly value="${entity.entity }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>包路径名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="entityPackage" name="entityPackage" readonly
							value="${entity.entity }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>控制器类：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="controller" name="controller" readonly value="${entity.controller }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>包路径名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="controllerPackage" name="controllerPackage" readonly
							value="${entity.controllerPackage}">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>服务层类：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="service" name="service" readonly value="${entity.service }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>包路径名：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="servicePackage" name="servicePackage" readonly
							value="${entity.servicePackage}">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>映射路径：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="controllerUrl" name="controllerUrl" readonly
							value="${entity.controllerUrl }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>mybatis配置：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="mybatisXml" name="mybatisXml" readonly
							value="${entity.mybatisXml }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>列表映射：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="listUrl" name="listUrl" readonly value="${entity.listUrl }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>列表&nbsp;JSP：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="listJsp" name="listJsp" readonly value="${entity.listJsp }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新增映射：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="addUrl" name="addUrl" readonly value="${entity.addUrl }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新增&nbsp;JSP：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="addJsp" name="addJsp" readonly value="${entity.addJsp }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>修改映射：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="updUrl" name="updUrl" readonly value="${entity.updUrl }">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>修改&nbsp;JSP：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input class="form-control" type="text" id="updJsp" name="updJsp" readonly value="${entity.updJsp }">
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
