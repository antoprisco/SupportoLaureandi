<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>

<%
	String pageName = "login.jsp";
	String pageFolder = "";
%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp" />
</head>

<body onLoad="">
	<div class="page-wrapper">

		<!-- Preloader -->
		<!-- <div class="preloader"></div> -->


		<jsp:include page="/partials/header.jsp">
			<jsp:param name="pageName" value="<%= pageName %>" />
			<jsp:param name="pageFolder" value="<%= pageFolder %>" />
		</jsp:include>


		<div class="sidebar-page-container basePage loginPage">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content">
							<div class="news-block-seven">

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12 login-container">
									<div class="panel">
										<h2 class="text-center">Login</h2>
										<p class="text-center">Compilare username e password per
											accedere</p>
									</div>
									<form id="login">
										<div class="form-group">
											<input type="email" class="form-control" id="email"
												placeholder="Email" minlength="6" required>
										</div>
										<div class="form-group">
											<input type="password" class="form-control" id="password"
												placeholder="Password" minlength="8" required>
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-submit">Accedi</button>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/partials/footer.jsp" />
	</div>
	<!--End pagewrapper-->

	<jsp:include page="/partials/includes.jsp" />
	<script src="<%= request.getContextPath() %>/js/pages/scripts_login.js"></script>

</body>
</html>
