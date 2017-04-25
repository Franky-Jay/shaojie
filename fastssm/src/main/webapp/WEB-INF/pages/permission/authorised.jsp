<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>添加菜单</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="${path}/resources/treeCss/tree.css" rel="stylesheet" />
	<link href="${path}/resources/assets/css/bootstrap.min.css"
		rel="stylesheet" />
	<script src="${path}/resources/assets/js/jquery-3.1.1.min.js"></script>
	<script src="${path}/resources/assets/js/bootstrap.min.js"></script>
	
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加权限</title>
</head>
<body>

	<div class="container">
	<div class="row clearfix">
		
		<div class="container-fluid">
    <div class="row-fluid">
        <div class="table-responsive">
        	<form action="toPermission.action" method="post">
        	<input type="hidden" value="${id }" name="roleid"/>
            <table class="table table-hover table-bordered" id="table">
                <thrad>
                    <tr>
                        <th>一级菜单</th>
                        <th>二级菜单</th>
                        <th>按钮权限</th>
                        <th>数据规则</th>
                    </tr>
                </thrad>
                
	                <c:forEach var="firstMenu" items="${set }">
	                <tbody>
		                <tr class="danger">
		                    <td rowspan="${firstMenu.size+1 }">${firstMenu.name }<input type="checkbox" value="@${firstMenu.permissionId },@${firstMenu.businessCode }"name="permissionId" class="root" onclick="root(this)"/></td>
		                </tr>
			                <c:forEach var="secondMenu" items="${firstMenu.subPermissionVO }">
				                <tr class="success">
				                	
				                    <td >${secondMenu.name }<input type="checkbox"  value="@${secondMenu.permissionId },@${secondMenu.businessCode }"name="permissionId" class="son" onclick="son(this)"></td>
				                    <td>
				                    	<c:forEach var="button" items="${secondMenu.subPermissionVO }">
				                    		${button.name }
				                    		<input type="checkbox" value="@${button.permissionId },@${button.businessCode }"name="permissionId" class="grandson" onclick="grandson(this)">
				                    	</c:forEach>
				                    </td>
				                    <td>
			                        <%-- <select type="text" class="form-control" name="rule" >
			                        	<option value=""> </option>
			                            <option value="${secondMenu.permissionId },@">无</option>
			                            <option value="${secondMenu.permissionId },CreatorUserIdEqualTo">本人(只能查看本人数据)</option>
			                            <option value="${secondMenu.permissionId },CreatorDepartmentIdEqualTo">本部门(只能查本部门数据，不包括下级部门)</option>
			                            <option value="${secondMenu.permissionId },CreatorDepartmentIdLike">本部门及下级(只能查本部门及下级部门数据)</option>
			                            <option value="${secondMenu.permissionId },currid">本角色可见(指定本角色可见)</option>
			                        </select> --%>
			                        <div class="control-group">
			                        <div class="input-group" style="float: left">
			                            <div class="input-group-btn">
			                                <button type="button" class="btn btn-default" tabindex="-1">无规则</button>
			                                <button type="button" class="btn btn-default dropdown-toggle"
			                                        data-toggle="dropdown" tabindex="-1">
			                                    <span class="caret"></span>
			                                </button>
			                                <ul class="dropdown-menu">
			                                    <li class="divider"></li>
								                <li>
								                	<button type="button" class="btn btn-block btn-small" onclick="select('${secondMenu.permissionId },@',this)" >无规则</button>
								                    <button type="button" class="btn btn-block btn-small" onclick="select('${secondMenu.permissionId },CreatorUserIdEqualTo',this)" >本人(只能查看本人数据)</button>
								                    <button type="button" class="btn btn-block btn-small" onclick="select('${secondMenu.permissionId },CreatorDepartmentIdEqualTo',this)" >本部门(只能查本部门数据，不包括下级部门)</button>
								                    <button type="button" class="btn btn-block btn-small" onclick="select('${secondMenu.permissionId },CreatorDepartmentIdLike',this)" >本部门及下级(只能查本部门及下级部门数据)</button>
								                    <button type="button" class="btn btn-block btn-small" onclick="select('${secondMenu.permissionId },currid',this)" >本角色可见(指定本角色可见)</button>
								                    <input type="hidden" value="" name="rule">
								                </li>
								                <li class="divider"></li>
			                                    
			                                </ul>
			                           </div>
			                            <!-- /btn-group -->
			                            <input type="hidden" class="form-control"  required readonly value="${secondMenu.permissionId },@">
		                        	</div>
		                        <!-- /input-group -->
		                        <!-- /.col-lg-6 -->
		                        <br>
		                    </div>
			                    </td>
				                </tr>
				                
	                		</c:forEach>
	                		</tbody>
					</c:forEach>
                
                

            </table>
            <button type="submit" class="btn btn-block btn-lg btn-success">保存</button>
            </form>
            <br />
            <a href="${path }/role/list.action"><button type="button" class="btn btn-warning btn-block btn-large">返回</button></a>
        </div>
    </div>
</div> 
			
	</div>
</div>


<script src="resources/treeJs/tress.js"></script>
<script>
$(document).ready(function () {
	getRolePermission();
	getDatarule();
})
function select(rule,object){
	var text =  $(object).html()
    $(object).next('input').val(rule)
    var a = $(object).parent().parent().parent().parent().find('input').val(rule)
   	// $("#rule").val(rule);
    $(object).parent().parent().parent().children("button[class='btn btn-default']").html(text)
    console.info(a)
    console.info(text)
}
function root(own){
    var html = $(own).parent().parent().parent()
    if(!$(own).attr("checked")){
        $(own).prop("checked", true);
        $(own).attr("checked", true);
        html.find("input[type='checkbox']").prop('checked', true);
        html.find("input[type='checkbox']").attr("checked", true);
        //console.info(!$(own).attr("checked"))
    }else {
        html.find("input[type='checkbox']").prop('checked', false);
        html.find("input[type='checkbox']").attr("checked", false);
        //console.info(!$(own).attr("checked"))
        $(own).prop("checked", false);
        $(own).attr("checked", false);
    }
}
function son(own){
    var html = $(own).parent().parent().parent()
    //console.info(!$(own).attr("checked",true))
    //html.find("input[class='root']").attr("checked", !$(own).attr("checked"));
    if($(own).is(':checked')){
        console.info("被选中")
        //
        $(own).prop("checked", true);
        $(own).attr("checked", true);
        html.find("input[class='root']").prop("checked", true);
        html.find("input[class='root']").attr("checked", true);
        //选中二级菜单时同时需要将本身下面的三级按钮都选中  .prop清空选中状态
        $(own).parent().siblings().find("input[type='checkbox']").prop("checked", true);
        $(own).parent().siblings().find("input[type='checkbox']").attr("checked", true);
    }else {
        console.info("取消选中")
        $(own).parent().siblings().find("input[type='checkbox']").prop("checked", false);
        $(own).parent().siblings().find("input[type='checkbox']").attr("checked", false);
        $(own).prop("checked", false);
        $(own).attr("checked", false);
    }
}

function grandson(own){
    var html = $(own).parent().parent().parent()
    if($(own).is(':checked')){
        console.info("被选中")
        //
        $(own).prop("checked", true);
        $(own).attr("checked", true);
        html.find("input[class='root']").prop("checked", true);
        html.find("input[class='root']").attr("checked", true);
        $(own).parent().siblings().find("input[class='son']").prop("checked", true);
        $(own).parent().siblings().find("input[class='son']").attr("checked", true);

    }else {
        console.info("取消选中")
        $(own).prop("checked", false);
        $(own).attr("checked", false);
    }
}
//拿到对应角色_权限中间表的json数据
function getRolePermission (){
    $.getJSON("toRolePermission.action?roleid=${id}",function(data){
        //console.log(data);
        $.each(data,function(n,item){
			//console.info(item.permissionId)
        	matching(item.permissionId);
        });
    })
}
//拿到对应角色的数据规则的json数据
function getDatarule (){
    $.getJSON("toDatarule.action?roleid=${id}",function(data){
        console.log(data);
        $.each(data,function(n,item){
			console.info(item.permissionId + "," + item.rule)
        	matchRule(item.permissionId,item.rule);
        });
    })
}
function matching(data){
	$("#table input[type='checkbox']").each(function(n,item){
        var val = $(item).val().toString()
        //console.info(val.toString())
        if (val.indexOf("@") != -1 && val.indexOf(",") != -1){
            var str = val.substring(1,val.indexOf(","))
            //console.info(str)
            if (str == data){
                //console.info(str)
                $(item).attr("checked", true);
            }
        }
    });
}


//匹配规则
function matchRule(permissionId,rule){
    $("#table button[class='btn btn-block btn-small']").each(function(n,item){
        var val = item.outerHTML     
        if (rule == null || rule==""){
            var text = val.substring(val.indexOf("(")+2,val.lastIndexOf("'"))
            //切割出来permissionId
            var a = text.substring(0,text.indexOf(","))
            if(a == permissionId){
                //拿到按钮的文本
                //var t = $(item).html()
                //console.info(t)
                $(item).parent().parent().parent().children("button[class='btn btn-default']").html("无规则")
                var c = $(item).parent().parent().parent().parent().find('input').val(a +",@")
                //console.info(a);
                //console.info(b);
            }
        }else {
            if(rule.indexOf("currid") != -1){
                //传过来的rule如果包涵：currid说明规则是json
                var text = val.substring(val.indexOf("(")+2,val.lastIndexOf("'"))
                //切割出来permissionId
                var a = text.substring(0,text.indexOf(","))
                if(a == permissionId){
                    //拿到按钮的文本
                    var t = $(item).html()
                    //console.info(t)
                    $(item).parent().parent().parent().children("button[class='btn btn-default']").html(t)
                    var c = $(item).parent().parent().parent().parent().find('input').val(a +",currid")
                    //console.info(a);
                    //console.info(b);
                }
            }else{
                //console.info(val)
                if(val != null && val.indexOf("onclick") != -1){
                    var text = val.substring(val.indexOf("(")+2,val.lastIndexOf("'"))
                    //切割出来permissionId
                    var a = text.substring(0,text.indexOf(","))
                    //切割出来rule
                    var b = text.substring(text.indexOf(",")+1,text.length)
                    //console.info("rule:" + b)
                    if(a == permissionId){
                        if(b == rule || rule == null){
                            //拿到按钮的文本
                            var t = $(item).html()
                            //console.info(t)
                            $(item).parent().parent().parent().children("button[class='btn btn-default']").html(t)
                            var c = $(item).parent().parent().parent().parent().find('input').val(a +","+b)
                            //console.info(a);
                            //console.info(b);
                        }
                    }
                    if(a == permissionId && b == rule){
                        //拿到按钮的文本
                        var t = $(item).html()
                        $(item).parent().parent().parent().children("button[class='btn btn-default']").html(t)
                        var c = $(item).parent().parent().parent().parent().find('input').val(a +","+ b)
                    }
                }
            }
        }   
    });
}
</script>
</body>
</html>