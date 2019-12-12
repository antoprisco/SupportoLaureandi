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
							
							
											
							
							
								<table id="adminTable" class="display data-results table table-striped table-hover table-bordered">
									<thead>
										<tr>
											<th class="text-center">CURRICULUM</th><th class="text-center">ANNO</th>
								
										</tr>
											
										<%
										Boolean d= (Boolean) request.getAttribute("denied");
									
										if(d!=null){
											ArrayList<RequestLM> list= (ArrayList<RequestLM>) request.getAttribute("list");
											
											for (int i=0; i<list.size(); i++){
												%>
												<tr><td><%=list.get(i).getCurr()%> </td> <td> <%=list.get(i).getYear()%></td></tr>
												<%
												
											}
										
										}
										else{
										
											
										RequestLM req= new RequestLM();
										RequestlmDAO rd= new RequestlmDAO();
									
									    ArrayList<RequestLM> ar= new ArrayList<RequestLM>();
									    
									    try {
									    	
									    	ar=rd.doRetrieveAll();
											for (int i=0; i<ar.size();i++) {
										
											
											%>
											<tr><td><%=ar.get(i).getCurr()%> </td> <td> <%=ar.get(i).getYear()%></td></tr>
											<%
										
											}
									    } catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
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
	<script
		src="<%= request.getContextPath() %>/js/pages/scripts_ReqFormLM.js"></script>
	
	
</body>
</html>
