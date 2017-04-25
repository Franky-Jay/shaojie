<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>新增部门</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<form role="form" action="${path }/organization/doEdit.action"
				method="post">
				<input type="hidden" value="${organization.departmentId}"
					name="departmentId">
					
				<div class="form-group">
					<label for="name">上级部门名称</label> 
					<select type="text" class="form-control" name="pid" required="required">
					<option value="">请选择上级部门名称</option>
					<c:if test="${list == null or list == ''}"><option value="0">总经办</option></c:if>
						<c:forEach items="${list}" var="rs">
						
						
							<option value="${rs.departmentId}"
								<c:if test="${rs.departmentId eq organization.pid}"> selected="selected"</c:if>>${rs.name}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="name">组织名称</label> <input type="text"
						required="required" class="form-control" name="name"
						value="${organization.name }" placeholder="请输入组织名称">
				</div>
				<div class="form-group">
					<label for="name">组织描述</label> <input type="text"
						required="required" class="form-control" name="description"
						value="${organization.description }" placeholder="请输入组织描述(50字之内)" maxlength="50">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">保存</button>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${path }/organization/list.action" class="btn btn-default">返回</a>
				</div>
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
</body>
</html>