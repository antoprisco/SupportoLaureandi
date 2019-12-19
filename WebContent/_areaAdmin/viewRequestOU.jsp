<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>
<%@ page
	import="java.util.*, java.sql.SQLException,model.*,model.Request,controller.DbConnection,controller.ServletAdmin,java.sql.ResultSet,java.sql.Statement"%>

<%
	String pageName = "viewRequestOU.jsp";
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
</head>

<body onLoad="showData()">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$(".b").hide();
  $("button").click(function(){
    $(".b").toggle();
    
  });
});
</script>


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
								<table id="adminTable" class="display data-results table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th class="text-center">Elenco richieste</th>
											
											
										</tr>
											<tr>
										<%
										RequestOU r= new RequestOU();
										RequestOUDAO rd= new RequestOUDAO();
										ArrayList<RequestOU> list= new ArrayList<RequestOU>();
									try{
										list=rd.doRetrieveAll();
										for(int i=0; i<list.size(); i++){
											UserBean u= new UserBean();
											UserBeanDAO ud= new UserBeanDAO();
											u=ud.doRetrieveByEmail(list.get(i).getEmail());
											%>
										
											<th> <button><%=u.getNome()%>  <%=u.getCognome()%></button>
											
											<div class="b">
											<br>
												<div>Informazioni</div>
												<p><%=u.getEmail() %></p>
											</div>
											
											</th>
											
											
											</tr>
											<%
										
											}
										}catch(SQLException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										
										%>
									</thead>
									<tbody id="bodyAdminTable">

									</tbody>
								</table>
																						
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
	
	
</body>
</html>
