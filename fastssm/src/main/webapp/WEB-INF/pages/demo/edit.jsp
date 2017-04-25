<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>demo编辑</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form role="form" action="${path }/demo/doEdit.action" method="post">
				<input type="hidden" name="testId" value="${demoVo.testid }">
					<div class="form-group">
						<input type="text" placeholder="请输入姓名"
							class="form-control" id="name" name="testname" value="${demoVo.testname }" />
					</div>
					<div >
						<label class="checkbox-inline"> <input type="radio" name="testsex"
							id="testSex1" value="男" ${demoVo.testsex eq '男' ?'checked':''  }>男
						</label>
					
						<label class="checkbox-inline"> <input type="radio" name="testsex"
							id="testSex2" value="女" ${demoVo.testsex eq '女' ?'checked':''  }>女
						</label>
					</div>

					<button type="submit" class="btn btn-primary">提交</button>
					<a href="${path }/demo/list.action" class="btn btn-default">返回</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>