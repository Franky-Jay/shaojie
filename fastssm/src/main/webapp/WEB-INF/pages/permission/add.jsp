<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body>


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="tree well" style="background:#FFF; color:#000000;border:0 ">
			 <ul>
				 <c:forEach var="firstMenu" items="${set }">
					  <li>
						   <span class='btn btn-large btn-lg' >${firstMenu.name }</span> 
							   <button id='add' type='button' class='btn btn-xs btn-info' onclick="getPid('0',this)">添加同级菜单</button>--
							   <button id='addNext' type='button' class='btn btn-xs btn-info' onclick="getPermissionId('${firstMenu.permissionId}')">添加下级菜单</button>--
							   <button id='update' type='button' class='btn btn-xs btn-warning' onclick="getPermissionId('${firstMenu.permissionId}')">更新菜单</button>--
							   <button id='delete' type='button' class='btn btn-xs btn-danger' data-dismiss='alert' onclick="getPermissionId('${firstMenu.permissionId}')">删除</button>
						   <ul>
						   <c:forEach var="secondMenu" items="${firstMenu.subPermissionVO }">
						    <li>
						    	<span class='btn  btn-large'>${secondMenu.name }</span> 
							    	<button id='add' type='button' class='btn btn-xs btn-info' onclick="getPid('${secondMenu.permissionId}',this)">添加按钮</button>--
							   		<button id='update' type='button' class='btn btn-xs btn-warning' onclick="getPermissionId('${secondMenu.permissionId}')">更新菜单</button>--
							 		<button id='delete' type='button' class='btn btn-xs btn-danger' data-dismiss='alert' onclick="getPermissionId('${secondMenu.permissionId}')">删除</button>
						    	<ul>
						    		<c:forEach var="button" items="${secondMenu.subPermissionVO }">
						    		<li>
						    		<span class='btn btn-default btn-sm'>${button.name }</span>    			
							   				<button id='update' type='button' class='btn btn-xs btn-warning' onclick="getPermissionId('${button.permissionId}')">修改按钮</button>--
							   				<button id='delete' type='button' class='btn btn-xs btn-danger' data-dismiss='alert' onclick="getPermissionId('${button.permissionId}')">删除</button>
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
		</div>
	</div>
</div>




<!-- 添加菜单（Modal） -->
<div class="modal fade" id="Modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <form id="myform" class="form-horizontal"  method="post" style="margin: 0 auto">
                    <input type="hidden" id="pid" value="" name="pid">
                    <input type="hidden" id="permissionId" value="" name="permissionId">
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="name">
                            	<h3 class="panel-title" style="color: red" id="nameTitle">请输入菜单的名称</h3>
                            </label>
                        </div>
                        <div class="controls">
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                    </div>
                    <br />
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="name">
                                <h3 class="panel-title">设置菜单状态</h3>
                            </label><br /> 
                            <label class="radio-inline"> 
                            	<input type="radio" value="1" name="status" checked="checked">可用
                        	</label> 
                        	<label class="radio-inline"> 
                        		<input type="radio" value="0" name="status" id="status">不可用
                        	</label>
                        </div>
                    </div>
                    <!-- <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="name">
                                <h3 class="panel-title">定义类型</h3>
                            </label><br /> 
                            <label class="radio-inline"> 
                            	<input type="radio" value="1" name="type" checked="checked">菜单
                        	</label> 
                        	<label class="radio-inline"> 
                        		<input type="radio" value="2" name="type" id="type">按钮
                        	</label>
                        </div>
                    </div> -->
                    <input type="hidden" class="form-control" id="type" name="type">
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="name">
                                <h3 class="panel-title">序号</h3>
                            </label><br /> 
                            <!-- <label class="radio-inline"> 
                            	<input type="radio" value="1" name="orders" checked="checked">排序
                        	</label> 
                        	<label class="radio-inline"> 
                        		<input type="radio" value="2" name="orders" id="orders">不排序
                        	</label> -->
                        	<div class="controls">
                            	<input type="text" class="form-control" id="orders" name="orders">
                        	</div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="name">
                                <h3 class="panel-title">是否可查询列表</h3>
                            </label><br /> 
                            <label class="radio-inline"> 
                            	<input type="radio" value="1" name="islist" checked="checked">是
                        	</label> 
                        	<label class="radio-inline"> 
                        		<input type="radio" value="0" name="islist" id="islist">否
                        	</label>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="input-group" style="float: left">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default" tabindex="-1">请选择菜单图标</button>
                                <button type="button" class="btn btn-default dropdown-toggle"
                                        data-toggle="dropdown" tabindex="-1">
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li class="divider"></li>
                                    <li><a href="#" class="one">icon-desktop</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#" class="two">icon-list</a></li>
                                    <li class="divider"></li>
                                </ul>
                            </div>
                            <!-- /btn-group -->
                            <input type="text" class="form-control"  required readonly name="icon" id="icon">
                        </div>
                        <!-- /input-group -->
                        <!-- /.col-lg-6 -->
                        <br>
                    </div> 
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="uri"><h3 class="panel-title">请输入URI路径</h3></label>
                        </div>
                        <div class="controls">
                            <input type="text" class="form-control" id="uri" name="uri">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="classpath"><h3 class="panel-title">请输入类的全路径</h3></label>
                        </div>
                        <div class="controls">
                            <input type="text" class="form-control" id="classpath" name="classpath">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="panel-heading">
                            <label class="control-label" for="uri"><h3 class="panel-title">业务数据编码</h3></label>
                        </div>
                        <div class="controls">
                            <input type="text" class="form-control" id="businessCode" name="businessCode" >
                        </div>
                    </div>
                    <div class="control-group">
                        <br /> <br />
                        <div class="row clearfix">
                            <div class="col-md-12 column">
                                <!--<button type="submit" class="btn btn-success btn-lg" >按钮</button>-->
                                <button type="submit"
                                        class="btn btn-success btn-lg btn-block" id="from"
                                        style="text-shadow: black 5px 3px 3px;">
                                    <span class="glyphicon glyphicon-plus" id="but"></span>
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script src="resources/treeJs/tress.js"></script>
</body>
<script>
    
    var id;
    var permissionId;
    //添加父级菜单
    $(document).ready(function () {
        $(document).on("click", "#add", function () {
            //alert("执行清理")
            clear();
            $("#myform").attr('action',"addPermission.action");
			$("#but").attr("class","glyphicon glyphicon-plus")
			
			
            $("#pid").val(id)
            
            $('#Modal').modal('show')

        });
    })
    //添加子菜单
     $(document).ready(function () {
        $(document).on("click", "#addNext", function () {
            //alert(id+"")
            clear();
            $("#myform").attr('action',"addPermission.action");
			$("#but").attr("class","glyphicon glyphicon-plus")
			$("#myModalLabel").html("添加子菜单")
			$("#nameTitle").html("请输入子菜单名称")
			$("#type").val("1")
            $("#pid").val(permissionId)
            $('#Modal').modal('show')

        });
    })
    //修改
    $(document).ready(function () {
        $(document).on("click", "#update", function () {
        	clear();
        	$("#nameTitle").html("请输入需要更改的名称")
            //alert(permissionId)
            $("#myform").attr('action',"upPermission.action");
            $("#myModalLabel").html("更新菜单")
            //$("#pid").val(permissionId)
            $("#but").attr("class","glyphicon glyphicon-pencil")
            getFirstCategory();
            $('#Modal').modal('show')

        });
    })
	//删除
    $(document).ready(function () {
        $(document).on("click", "#delete", function () {
			if(window.confirm("你确定要删除id='" + permissionId + "' 这个菜单吗？")){
				$.ajax({
	                type : "post",
	                url : "delPermission.action?permissionId=" + permissionId,
	                success : function(data) {
	                	
	                	parent.location.reload();
                        console.info("删除成功：" + permissionId);
	                }
	            });
            }/* else{
                return false;
            } */  
			location.reload();
        });
    })
    
    function getPid(pid,own){
    	//alert("执行赋值")
        id = pid;
        if($(own).html()=="添加按钮"){
        	$("#type").val("2")
        	$("#myModalLabel").html("添加按钮")
			$("#nameTitle").html("请输入按钮名称")
        }else{
        	$("#type").val("1")
        	$("#myModalLabel").html("添加同级菜单")
			$("#nameTitle").html("请输入菜单名称")
        } 
        //alert($(own).html())
    }

    function getPermissionId(permissionId){
        this.permissionId = permissionId;
    }


    $('#Modal').on('show.bs.modal', function () {
        //模态框显示时调用函数
    	
    })

    $(document).on("click", "#btn", function () { 
	     $("#myform").submit();
	})
    
    $(".one").click(function() {
        var text = $(this).html()
        $("[name='icon']").val(text)
    })

    $(".two").click(function() {
        var text = $(this).html()
        $("[name='icon']").val(text)
    })
    
    function getFirstCategory (){
        $.getJSON("${path}/getPermission.action?permissionId=" + permissionId,function(data){
        	console.log(data);
            $("#name").val(data.name);
            $("#uri").val(data.uri);
            $("#classpath").val(data.classpath);
            $("#icon").val(data.icon);
            $("#businessCode").val(data.businessCode);
            $("#permissionId").val(data.permissionId);
            $("#pid").val(data.pid)
            $("#orders").val(data.orders);
            $("#type").val(data.type);
            //alert("type:" + data.type)
            if(data.status == 0){
                $("#status").attr('checked', 'true');
            }
            /* if(data.type == 2){
            	$("#type").attr('checked', 'true');
            } */
            if(data.islist == 0){
            	$("#islist").attr('checked', 'true');
            }
            /* if(data.orders == 2){
            	$("#orders").attr('checked', 'true');
            } */
        })
    }
    function clear(){
    	
		$("#name").val("");
        $("#uri").val("");
        $("#classpath").val("");
        $("#icon").val("");
        $("#businessCode").val("");
        //$("#nameTitle").html("")
        //$("#myModalLabel").html("")
        $("#type").html("")
    }
    
</script>
</html>