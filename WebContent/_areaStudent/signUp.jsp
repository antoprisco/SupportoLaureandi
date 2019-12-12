<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>

<%
	String pageName = "signUp.jsp";
	String pageFolder = "_areaStudent";
%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp" />
</head>

<body onLoad="">
	<div class="page-wrapper">

		<!-- Preloader -->
		<!-- <div class="preloader"></div>  -->


		<jsp:include page="/partials/header.jsp">
			<jsp:param name="pageName" value="<%= pageName %>" />
			<jsp:param name="pageFolder" value="<%= pageFolder %>" />
		</jsp:include>


		<div class="sidebar-page-container basePage signUpPage">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content">
							<div class="news-block-seven">

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12 signUp-container">
									<div class="panel">
										<h2 class="text-center">Registrazione</h2>
										<p class="text-center">Compila tutti i campi per
											registrarti</p>
									</div>
									<form id="signUp">
										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<input type="text" class="form-control" id="name"
												placeholder="Nome" minlength="1" maxlength="20" required>
										</div>
										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<input type="text" class="form-control" id="surname"
												placeholder="Cognome" minlength="1" maxlength="20" required>
										</div>
										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<input type="email" class="form-control" id="email"
												placeholder="Email" minlength="1" required>
										</div>

										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<label class="radio-inline"><input type="radio"
												class="sex" name="sex" value="M" required>M</label> <label
												class="radio-inline"><input type="radio" class="sex"
												name="sex" value="F" required>F</label>
										</div>

										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<input type="password" class="form-control" id="password"
												placeholder="Password" minlength="8" required>
										</div>
										<div class="form-group col-lg-6 col-md-6 col-sm-12 col-xs-12">
											<input type="password" class="form-control"
												id="verifyPassword" placeholder="Verifica Password"
												minlength="8" required>
										</div>
										<div
											class="form-group col-lg-12 col-md-12 col-sm-12 col-xs-12">
											<button type="submit" class="btn btn-primary btn-submit">Registrati</button>
										</div>

										<div class="clearfix"></div>
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
	<script
		src="<%= request.getContextPath() %>/js/pages/scripts_signUp.js"></script>

</body>
</html>
