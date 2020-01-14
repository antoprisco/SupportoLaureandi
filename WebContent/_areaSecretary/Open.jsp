<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>
<%@ page
	import="java.util.*, model.*, interfacce.*, java.sql.SQLException,java.text.SimpleDateFormat, java.time.*, model.Request,controller.DbConnection,controller.ServletAdmin,java.sql.ResultSet,java.sql.Statement"%>

<%
	String pageName = "Open.jsp";
String pageFolder = "_areaSecretary";
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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/cssOpen.css">
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
							
							<%UserInterface user = (UserInterface) request.getSession().getAttribute("user"); %>
							
							<div id="open">Salve <%=user.getName()+","%> <br> questo portale ti consente di monitorare e gestire servizi durante il percorso di laurea e per il post-laurea.<br>
							<b>Servizi pre-laurea:</b><li>Convalida dell'esame di inglese</li>
							<b>Servizi post-laurea:</b><li>Preferenza di iscrizione ad una Laurea Magistrale</li><li>Orientamento in uscita</li><li>Iscrizione corsi singoli</li>
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
