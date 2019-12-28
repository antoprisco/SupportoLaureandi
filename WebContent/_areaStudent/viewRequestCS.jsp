<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="controller.CheckSession"%>
<%@ page import="java.util.*,model.Request, model.*, interfacce.*"%>
<%
	String pageName = "viewRequestCS.jsp";
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

<body onLoad="showData()">
	<div class="page-wrapper">

		<!-- Preloader -->
		<!--  <div class="preloader"></div> -->


		<jsp:include page="/partials/header.jsp">
			<jsp:param name="pageName" value="<%= pageName %>" />
			<jsp:param name="pageFolder" value="<%= pageFolder %>" />
		</jsp:include>


		<div class="sidebar-page-container basePage viewRequestStudent">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content">
							<div class="news-block-seven">
								<table id="studentTable" class="display data-results table table-striped table-hover table-bordered">
									<thead>
										<tr align="center">
											<th class="text-center" align="center">ID</th>
											<th class="text-center" align="center">Nome</th>
											<th class="text-center" align="center">Cognome</th>
											<th class="text-center" align="center">Stato</th>
										</tr>
										<%
										UserInterface user = (UserInterface) request.getSession().getAttribute("user");
									    String idUser = user.getEmail();
									    
										RequestCS r= new RequestCS();
										RequestCSDAO rd= new RequestCSDAO();
										ArrayList<RequestCS> list= new ArrayList<RequestCS>();
										list=rd.doRetrieveByNC(user.getName(), user.getSurname());
										if(!list.isEmpty()){
										
										for (RequestCS req: list){
											%>
											<tr>
											<td><%=req.getId() %></td>
											<td><%=req.getNome() %></td>
											<td><%=req.getCognome() %></td>
											<%
											Stato s= new Stato();
											StatoDAO sd= new StatoDAO();
											s=sd.doRetrieveById(req.getStato());
											
											
											%>
											<td><%=s.getDescr() %></td>
											</tr>
											<%
										} 
										}else{
											%><p>Non ci sono richieste</p><%
										}%>
									</thead>
									<tbody id="bodyStudentTable">
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
