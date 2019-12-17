<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>
<%@ page
	import="java.util.*, model.*, java.sql.SQLException,java.text.SimpleDateFormat, java.time.*, model.Request,controller.DbConnection,controller.ServletAdmin,java.sql.ResultSet,java.sql.Statement"%>

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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/newCss.css">
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
				<div class="clearfix">
					<div class="content-side">
						<div class="content contentSL">
							<div class="news-block-seven">


		
								<div class="row pl-2">
						            <div class="col-md-4 pt-5">
						                <form id="formRLM" class="ml-5">
						                    <label for="scegliAnno">Iscritti per anno:</label>
						                    <select class="custom-select" id="anno" name="anno" required>
						                        <option selected>Open this select menu</option>
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
						                    <button type="submit"  class="btn btn-primary btn-action generateExcel">Search</button>
						                </form>
						            </div>
						            <div class="col-md-8" id="graph-container">
						                <canvas id="graficoBello"></canvas>
						                <div id="notify"></div>
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
		src="<%= request.getContextPath() %>/js/pages/scripts_ReqFormLM.js"></script>
	
	
</body>
</html>
