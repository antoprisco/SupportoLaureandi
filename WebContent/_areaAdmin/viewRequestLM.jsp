<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>
<%@ page
	import="java.util.*, model.*, java.sql.SQLException, model.Request,controller.DbConnection,controller.ServletAdmin,java.sql.ResultSet,java.sql.Statement"%>

<%
	String pageName = "viewRequestLM.jsp";
	String pageFolder = "_areaAdmin";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
	if(!ck.isAllowed()){
	  response.sendRedirect(request.getContextPath()+ck.getUrlRedirect());  
	}
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js">  </script>
</head>

<body onLoad="showData()">
	<div class="page-wrapper">

		<!-- Preloader -->
		<!--  <div class="preloader"></div> -->


		<jsp:include page="/partials/header.jsp">
			<jsp:param name="pageName" value="<%= pageName %>" />
			<jsp:param name="pageFolder" value="<%= pageFolder %>" />
		</jsp:include>


		<div class="sidebar-page-container basePage viewRequestAdmin">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content ">
							<div class="news-block-seven">
							
					
							
							
							<form id="formRLM">
							<div class="form-group">
										
											<!-- ANNO -->
											
											<label> Scegli l'anno </label> 
											
											
											
											<select class="form-control" id="anno"  name="anno" required>
												
												<option value="2020">2020</option>
												<option value="2021">2021</option>
												<option value="2022">2022</option>
												<option value="2023">2023</option>
												<option value="2024">2024</option>
												<%
											    	
											    %>
											</select>
										</div>
							
							<button type="submit"  class="btn btn-primary btn-submit">Search</button>
							</form>
							<canvas id="graficoBello"></canvas>
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
		src="<%= request.getContextPath() %>/js/pages/scripts_ReqFormLM.js"></script>
	
	
</body>
</html>
