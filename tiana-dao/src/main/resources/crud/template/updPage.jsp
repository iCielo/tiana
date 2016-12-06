<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/form.jsp"%>
<title>${table.menuName} - 修改</title>
<script type="text/javascript">
	$(function() {
		$("#form").validator({
			fields : {
			#foreach( $item in $columns ) 
			#if( ${item.rules} != '' && ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime' ) 
			${item.javaName} : "${item.rules}", 
			#end 
			#end 
			}
		});
	});
</script>
</head>
<body>
	<article class="page-container">
		<form action="" method="post" class="form form-horizontal" id="form">
			#set($entity="{entity")
			#foreach( $item in $columns )
			#if( ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime' && ${item.inputType} == 'hidden' )
			<input type="hidden" id="${item.javaName}" name="${item.javaName}"  value="${mark}${entity}.$item.javaName}">
			#end
			#end
			#foreach( $item in $columns )
			#if( ${item.primaryKey} != '1' &&  ${item.javaName} != 'opUserId' &&  ${item.javaName} != 'opTime' && ${item.inputType} != 'hidden')
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">#if( ${item.nullable} != 1 )<span class="c-red">*</span>#end ${item.label}：</label>
					<div class="formControls col-xs-8 col-sm-9">
						#if( ${item.inputType} == 'input' )
							<input class="input-text"#if( ${item.placeholder} ) placeholder="${item.placeholder}" #end type="input" id="${item.javaName}" name="${item.javaName}"  value="<c:out value="${mark}${entity}.$item.javaName}"/>"/>
						#end
						#if( ${item.inputType} == 'textarea' )
							<textarea class="textarea"#if( ${item.placeholder} ) placeholder="${item.placeholder}" #end id="${item.javaName}" name="${item.javaName}">${mark}${entity}.$item.javaName}</textarea>
						#end
						#if( ${item.inputType} == 'select' )
							<span class="select-box">
							<select class="select" id="${item.javaName}" name="${item.javaName}" data-option-value="${mark}${entity}.$item.javaName}">
								<option value="">--请选择--</option>
							</select>
							</span>
						#end
						#if( ${item.inputType} == 'radio' )
							<input type="radio"  id="${item.javaName}" name="${item.javaName}"/>${item.label}
						#end
						#if( ${item.inputType} == 'check' )
							<input type="checkbox"  id="${item.javaName}" name="${item.javaName}"/>${item.label}
						#end
					</div>
				</div> 
			#end
			#end
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