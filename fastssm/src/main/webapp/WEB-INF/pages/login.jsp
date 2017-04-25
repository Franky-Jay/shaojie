<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>系统登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/WEB-INF/pages/common/rs_css.jsp"%>
<script type="text/javascript">
if(window !=top){ 
	top.location.href=location.href;
}
</script>
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">MS</span> <span
									class="white">后台管理系统</span>
							</h1>
							<h4 class="blue">&copy; 码神软件</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入登录信息
										</h4>

										<div class="space-6"></div>

										<form action="${path }/doLogin.action" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="登录账号" name="account"/> <i
														class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control" placeholder="登录密码" name="pwd"/>
														<i class="icon-lock"></i>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix text-center">

													<button type="submit"
														class="width-35  btn btn-sm btn-primary">
														<i class="icon-key"></i> 登录
													</button>
												</div>
												<div class="clearfix text-center" style="color:red">
													&nbsp;${msg }
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>
									<!-- /widget-main -->

									<div class="toolbar clearfix">
										<div>
											<a href="#" class="user-signup-link"> </a>
										</div>

										<div>
											<a href="#" onclick="show_box('signup-box'); return false;"
												class="forgot-password-link"> 找回密码 <i
												class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->

						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->
	<%@ include file="/WEB-INF/pages/common/rs_js.jsp"%>

</body>
</html>
