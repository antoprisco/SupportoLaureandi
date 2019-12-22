<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"
	import="controller.CheckSession, model.*, interfacce.*,java.util.ArrayList, model.SystemAttribute, java.text.SimpleDateFormat, java.time.*, controller.DbConnection, java.sql.Connection, java.sql.ResultSet, java.sql.Statement"%>

<%
	String pageName = "FormOU.jsp";
	String pageFolder = "_areaStudent";
	CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
	if (!ck.isAllowed()) {
		response.sendRedirect(request.getContextPath() + ck.getUrlRedirect());
	}
%>

<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<jsp:include page="/partials/head.jsp" />
</head>

<body onLoad="">
	<div class="page-wrapper">

		<!-- Preloader -->
		<!-- <div class="preloader"></div>  -->


		<jsp:include page="/partials/header.jsp">
			<jsp:param name="pageName" value="<%=pageName%>" />
			<jsp:param name="pageFolder" value="<%=pageFolder%>" />
		</jsp:include>


		<div class="sidebar-page-container basePage firstFormPage">
			<div class="auto-container">
				<div class="row clearfix">
					<div class="content-side col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="content">
							<div class="news-block-seven">

								<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 firstForm-container">
									<div class="panel">
										<h2 class="text-center">Orientamento in uscita</h2>
										<p class="text-center">Compila tutti i campi</p>
									</div>
						<%
							UserInterface user = (UserInterface) request.getSession().getAttribute("user");

						%>

									<form id="FormOU">

										<div class="form-group">
											<!-- Nome -->
											<label for="nome">Nome</label> <input class="form-control"
												type="string" value="<%=user.getName()%>" id="nome" required>
										</div>


										<div class="form-group">
											<!-- Cognome -->
											<label >Cognome</label> <input class="form-control" type="string" value="<%=user.getSurname()%>"id="cognome" required>
										</div>


										<div class="form-group">
											<div class="form-group">
											<label > Data di Nascita</label> <input class="form-control" type="date" value="1994-10-10" id="datanascita">
										</div>

										<div class="form-group">
											<label>Email</label> <input class="form-control" type="string" value="<%=user.getEmail() %>" id="email" required>
										</div>


										<div class="form-group">
											<label>Telefono</label> <input class="form-control" type="number" value="3661044433" id="telefono" required>
										</div>




										<h2>Skill</h2>
										<table id="skill_table">
										<tr>
												<th>Skill</th>
												<th>Basso</th>
												<th>Medio</th>
												<th>Alto</th>
										</tr>
										
										<%Skill s= new Skill();
													SkillDAO sd= new SkillDAO();
													ArrayList<Skill> list= new ArrayList<Skill>();
													list=sd.doRetrieveAll();
													for(Skill sk: list){
														%>
														<tr class="skills">
														<td data-skill="<%=sk.getNome()%>"><%=sk.getNome()%></td>
														<fieldset id="<%=sk.getNome()%>">
														<td><input type="radio" name="<%=sk.getNome()%>" value="basso"></td>
														<td><input type="radio" name="<%=sk.getNome()%>" value="medio"></td>
														<td><input type="radio" name="<%=sk.getNome()%>" value="alto"></td>
														</fieldset>
														</tr>
														<%
													}
													%>
										</table>
										<div class="form-group">
											<label for="nome">Aggiungi competenza</label> 
											<input class="form-control" type="string" id="nomeSkill">
												<h1><button type="button" id = "aggiungiSkill">+</button></h1>
												
										</div>
										
										<h2>Soft Skill</h2>
										<table id=softskill_table>
											<tr class="softskills" style="visible:hidden"></tr>
										</table>
										<label for="nome">Aggiungi soft Skill</label> <input class="form-control" type="string" id="nomeSoftSkill">
										<h1><button type="button" id = "aggiungiSoftSkill">+</button></h1>
										<table>
										<tr>
												<th>Lingua</th>
												<th>Livello</th>
										</tr>
										<tr>
										<td>Inglese</td>
										<td><select class="lingua" name="inglese" required>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
											<tr>
										<td>Francese</td>
										<td><select class="lingua" name="francese" required>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
											<tr>
										<td>Tedesco</td>
										<td><select class="lingua"  name="tedesco" required>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
											<td>Spagnolo</td>
										<td><select class="lingua" name="spagnolo" required>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
										</table>



												<div class="form-group">
														<button type="submit" class="btn btn-primary btn-submit">Invia</button>
												</div>

					<div class="clearfix"></div>

</form>
</body>
<jsp:include page="/partials/footer.jsp" />
</div>
<!--End pagewrapper-->

<jsp:include page="/partials/includes.jsp" />
<script 
	src="<%=request.getContextPath()%>/js/pages/scripts_ReqFormOU.js"></script>

</body>
</html>
