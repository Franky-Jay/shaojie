<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>新增用户</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<div class="row">
	   <div class="col-md-2"></div>
		<div class="col-md-8">
			<form role="form" action="${path }/role/doEdit.action" method="post">
			
			<input type="hidden" name="roleId" value="${role.roleId }">
			<!-- role修改是通过id进行修改，如果没有则默认是添加 -->
			
				<div class="form-group">
					<label for="name">角色名称</label> <input type="text" required="required"
						class="form-control" name="name" value="${role.name }" placeholder="请输入名称">
				</div>
				<div class="form-group">
					
				<!-- 	<label for="name">角色描述</label><textarea rows="12" cols="100"></textarea> -->
					
					<input type="" required="required"
						class="form-control" name="description" value="${role.description }" placeholder="请输入描述">
				
				<div class="text-center">
				<button type="submit" class="btn btn-primary">保存</button>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${path }/role/list.action" class="btn btn-default">返回</a>
				</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
</body>
</html>