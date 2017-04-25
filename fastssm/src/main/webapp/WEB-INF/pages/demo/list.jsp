<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="p" uri="/WEB-INF/PageElPermission.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>demo列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<style type="text/css">
</style>
</head>
<body style="width:98%">
	<div class="row">
		<div class="col-xs-12">
			<div>
				<input type="text" class="form-control-static" id="testname"
					placeholder="请输入姓名称">
					
				<button type="button" class="btn btn-default" id="search">查询</button>
				<p:permission privilege="com.mashen.demo.controller.DemoController:doEdit">
				<a  href="${path }/demo/edit.action" class="btn btn-primary" id="add">新增</a>
				</p:permission>
			</div>
			<div class="table-responsive">
				<table id="mydatatables"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>姓名</th>							
							<th>性别</th>
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
								"dom": 'tiprl',//自定义显示项
								//跟数组下标一样，第一列从0开始，这里表格初始化时，
								//第四列默认降序
								"order" : [ [ 4, "desc" ] ],
								"ajax" : {
									"url" : "${path}/demo/rest/doSearch.action",
									"type" : "POST",
									"data" : function(pdata) {
										
										pdata.searchColumns={
												"TestnameLike":$("#testname").val()
										}
										var data = JSON.stringify(pdata);
										//JSON.parse();
										return data;
									},
									dataType : "json",
									processData : false,
									contentType : 'application/json;charset=UTF-8',
									error:function(data,e){
										alert(data.responseText);
									}
								},
								"columns" : [ {
									"data" : "testid"
								}, {
									"data" : "testname"
								}, {
									"data" : "testsex"
								}, {
									"data" : "testid",
									"orderable":false
								},{
									"data" : "ctime",
									"visible" : false
									
								}],
								"columnDefs" : [
									
										{
											"render" : function(data, type, row) {
												return '<p:permission privilege="com.mashen.demo.controller.DemoController:doEdit"><a href="${path }/demo/edit.action?id='+data+'" class="tooltip-success" data-rel="tooltip" title="Edit"><span class="green"><i class="icon-edit bigger-120"></i></a></p:permission>&nbsp;&nbsp;'
												+'<p:permission privilege="com.mashen.demo.controller.DemoController:doDelete"><a href="javascript:void(0)" onclick="del(\''+data+'\')" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"><i class="icon-trash bigger-120"></i></a></p:permission>';
											},
											"targets" : 3
										} ],

								"language" : {
									"url" : "${path}/resources/assets/language/zh_CN.txt"
								}

							});

			$("#search").click(function() {
				
				mydatatables.ajax.reload();
			});
			
			$("#testname").keydown(function(e) {
				if(e.keyCode==13){
					mydatatables.ajax.reload();
				}
			});

		});
		
		function del(id){
			if(window.confirm("你确定要删除？")){
				$.getJSON("${path}/demo/rest/doDelete.action?id="+id,
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
