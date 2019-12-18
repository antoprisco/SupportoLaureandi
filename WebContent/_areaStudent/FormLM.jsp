<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"
	import="controller.CheckSession, controller.*, model.SystemAttribute, model.*, java.util.ArrayList, java.text.SimpleDateFormat, java.time.*, controller.DbConnection, java.sql.Connection, java.sql.ResultSet, java.sql.Statement"%>


<%
	String pageName = "FormLM.jsp";
	String pageFolder = "_areaStudent";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
	if(!ck.isAllowed()){
	  response.sendRedirect(request.getContextPath()+ck.getUrlRedirect());  
	}
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


		<div class="sidebar-page-container basePage firstFormPage">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content">
							<div class="news-block-seven">

								<div
									class="col-lg-6 col-md-6 col-sm-12 col-xs-12 firstForm-container">
									<div class="panel">
										<h2 class="text-center">Richiesta</h2>
										<p class="text-center">Compila tutti i campi per
											effettuare la richiesta</p>
									</div>

									<form id="FormLM">

										<div class="form-group">
											<label >Curriculum al quale saresti interessato :</label> 
											
											<select class="form-control" id="curriculum" name="curriculum" required>
											
										
												
												<option value="DATA SCIENCE">DATA SCIENCE</option>
												<option value="CLOUD COMPUTING">CLOUD COMPUTING</option>
												<option value="SICUREZZA INFORMATICA">SICUREZZA INFORMATICA</option>
												<option value="INTERNET OF THINGS">INTERNET OF THINGS</option>
												<option value="SISTEMI INFORMATICI E TECNOLOGIE DEL SOFTWARE">SISTEMI INFORMATICI E TECNOLOGIE DEL SOFTWARE</option>
											
												
											</select>
										</div>

		
					
										<div class="form-group">
										
											<!-- ANNO -->
											
											<label> In quale anno accademico vorresti iscriverti?</label> 
											
											
											
											<select class="form-control" id="anno"  name="anno" required>
												<%
											    	Integer range = Integer.parseInt(new SystemAttribute().getValueByKey("request-matriculation-year-range"));
											    	for(int i = ((range*-0)+1); i <= 5; i++){
											    	  LocalDate year = LocalDate.now().plusYears(i);
											    	  
											    	  %>
												<option value="<%= year.getYear() %>"><%= year.getYear() %></option>
												<%
											    	}
											    %>
												
											</select>
										</div>
								

										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-submit" >Invia</button>
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
		src="<%= request.getContextPath() %>/js/pages/scripts_formLM.js"></script>

</body>
</html>

