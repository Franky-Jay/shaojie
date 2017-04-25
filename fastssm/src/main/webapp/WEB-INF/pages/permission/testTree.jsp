<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>测试树形结构</title>
</head>
	<link href="resources/treeCss/tree.css" rel="stylesheet" />
	<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>

<body>
<div class="tree well">
 <ul>
 <c:forEach var="firstMenu" items="${set }">
  <li>
   <span><i class="${firstMenu.icon }"></i> ${firstMenu.name }</span> <a href="">添加</a><a href="">删除</a><a href="">修改</a>
   <ul>
   <c:forEach var="secondMenu" items="${firstMenu.subPermissionVO }">
    <li>
      <span><i class="${secondMenu.icon }"></i> ${secondMenu.name }</span> <a href="">添加</a><a href="">删除</a><a href="">修改</a>
    	<ul>
    		<c:forEach var="button" items="${secondMenu.subPermissionVO }">
    		<li>
    			<span><i class="${button.icon }"></i> ${button.name }</span> <a href="">添加</a><a href="">删除</a><a href="">修改</a>
    		</li>
    		</c:forEach>
    	</ul>
    </li>
    </c:forEach>
   </ul>
  </li>
  </c:forEach>
 </ul>
</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>
	<script src="resources/treeJs/tress.js"></script>
</body>
</html>