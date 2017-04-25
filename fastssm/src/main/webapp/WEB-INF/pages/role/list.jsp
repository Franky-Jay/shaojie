<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="/WEB-INF/PageElPermission.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>角色列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<input type="text" class="form-control-static" id="searchName"
					placeholder="请输入角色名称">
				<button type="button" class="btn btn-default" id="search">查询</button>
				<%-- <p:permission privilege="com.mashen.role.controller.UserManageController:doAdd"> --%>
				<a  href="${path }/role/edit.action" class="btn btn-primary" id="add">新增</a>
				
				<%-- </p:permission> --%>
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center"><label> <input type="checkbox"
									class="ace" /> <span class="lbl"></span>
							</label></th>
							<th>角色名称</th>
							<th>角色描述</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>

	<script type="text/javascript">
	
		jQuery(function($) {
			mydatatables = $('#mydatatables').DataTable(
							{
								"lengthMenu" : [ [ 8, 10, 20, 50, 1000 ],
										[ 8, 10, 20, 50, "All" ] ],
								"pageLength" : 8,
								"searching" : true,
								"ordering" : true,
								"processing" : true,
								"serverSide" : true,
								"autoWidth" : false,
								"dom": '<"top"f >rt<"bottom"ilp><"clear">',//dom定位
							    "dom": 'tiprl',//自定义显示项
								//跟数组下标一样，第一列从0开始，这里表格初始化时，
								//第四列默认降序
								"order" : [ [ 4, "desc" ] ],
								"ajax" : {
									"url" : "${path}/role/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										/* pdata.search = {
											"value" : $("#searchvalue").val(),
											"regex" : "false"
										}; */
										
										pdata.searchColumns={
												"NameLike":$("#searchName").val(),
										}
										var data = JSON.stringify(pdata);
										
										return data;
									},
									dataType : "json",
									processData : false,
									contentType : 'application/json;charset=UTF-8',
									error:function(data,e){
										console.log(data);
										alert(e);
										alert(data);
									}
								},
								"columns" : [ {
									"data" : "roleId"
								}, {
									"data" : "name"
								}, {
									"data" : "description"
								}, {
									"data" : "roleId"
								}, {
									"data" : "ctime",
									"visible" : false
								}],
								"columnDefs" : [
										{
											"targets" : [ 0, 3 ],
											"orderable" : false,
											"visible" : true,
											"searchable" : false
										},
										{
											"render" : function(data, type, row) {
												return '<div class="checkbox"><label><input type="checkbox" value="'+data+'"></label></div>';
											},
											"targets" : 0
										},
										{
											"render" : function(data, type, row) {
												//row.account
												return '<a href="${path }/role/edit.action?id='+data+'" class="tooltip-success" data-rel="tooltip" title="Edit"><span class="green"><i class="icon-edit bigger-120"></i></a>&nbsp;&nbsp;'
												+'<a href="javascript:void(0)" onclick="del(\''+data+'\')" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"><i class="icon-trash bigger-120"></i></a>&nbsp;&nbsp;' + 
												'<a href="${path }/view.action?id='+data+'" class="tooltip-success" data-rel="tooltip" title="Edit"><span class="green"><i class="icon-edit bigger-120"></i>角色授权</a>';
											},
											"targets" : 3
										} ],

								"language" : {
									"url" : "${path}/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				/* var args = mydatatables.ajax.params(); */
				
				mydatatables.ajax.reload();
			});
			
			$("#searchvalue").keydown(function(e) {
				if(e.keyCode==13){
					mydatatables.ajax.reload();
				}
			});
			
			
			//全选
			$('table th input:checkbox').on(
					'click',
					function() {
						var that = this;
						$(this).closest('table').find(
								'tr > td:first-child input:checkbox').each(
								function() {
									this.checked = that.checked;
									$(this).closest('tr').toggleClass(
											'selected');
								});

			});

		});
		
		function del(id){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path}/role/doDel.action?id="+id,
							function(data){
						alert(data.msg);
						if(data.status==1){
							mydatatables.ajax.reload();
						}
					});
			}
		}
	</script>
</body>
</html>
