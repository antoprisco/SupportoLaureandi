<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"
	import="controller.CheckSession, model.*, interfacce.*,java.util.ArrayList, model.SystemAttribute, java.text.SimpleDateFormat, java.time.*, controller.DbConnection, java.sql.Connection, java.sql.ResultSet, java.sql.Statement"%>

<%
	String pageName = "viewFormOU.jsp";
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
										<h1 class="text-center">Orientamento in uscita</h1>
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
											<label>Telefono</label> <input class="form-control" type="number" value="" id="telefono" required>
										</div>



																				<br>
										
										<h2 class="mt-3">Skill</h2>
										<div class="pr-5 pl-5"><table id="skill_table">
										<tr>
												<th class="pl-2">Skill</th>
												<th class="pl-2">Basso</th>
												<th class="pl-2">Medio</th>
												<th class="pl-2">Alto</th>
										</tr>
										
										<tr class="skills">
														<td data-skill="java"> Java </td>
														<fieldset id="java">
														<td><input type="radio" name="java" value="basso"></td>
														<td><input type="radio" name="java" value="medio"></td>
														<td><input type="radio" name="java" value="alto"></td>
														</fieldset>
														</tr>
										
										<tr class="skills">
														<td data-skill="mysql"> MySQL </td>
														<fieldset id="mysql">
														<td><input type="radio" name="mysql" value="basso"></td>
														<td><input type="radio" name="mysql" value="medio"></td>
														<td><input type="radio" name="mysql" value="alto"></td>
														</fieldset>
														</tr>
														
										<tr class="skills">
														<td data-skill="cpp"> C++ </td>
														<fieldset id="cpp">
														<td><input type="radio" name="cpp" value="basso"></td>
														<td><input type="radio" name="cpp" value="medio"></td>
														<td><input type="radio" name="cpp" value="alto"></td>
														</fieldset>
														</tr>
										
										<%Skill s= new Skill();
													SkillDAO sd= new SkillDAO();
													ArrayList<Skill> list= new ArrayList<Skill>();
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
										</table></div>
										<div class="form-group pr-5 pl-5">
											<label class="mt-1" for="nomeSkill">Indica le tue competenze informatiche e il livello</label>
											<div class="input-group"> 
												<input class="form-control" type="string" id="nomeSkill">
												<span class="input-group-btn">
	    										<button class="btn btn-outline-secondary" type="button" id ="aggiungiSkill">+</button>
	  											</span>
	  										</div>
										</div>
										
										<br>
										<h2>Soft Skill</h2>
										<div class="pr-5 pl-5"><table id=softskill_table>
											<tr class="softskills" style="visible:hidden"></tr>
										</table></div>
										<div class="form-group pr-5 pl-5">
											<label class="mt-1" for="nomeSoftSkill">Indica le soft skill che ritieni di possedere</label>
											<div class="input-group">
											<input class="form-control" type="string" id="nomeSoftSkill">
											<span class="input-group-btn">
											<button class="btn btn-outline-secondary" type="button" id ="aggiungiSoftSkill">+</button>
											</span>
											</div>
										</div>
										
																				<br>
										
										<h2 class="mt-3">Lingue</h2>
										<div class="pr-5 pl-5"><table>
										<tr>
												<th class="pl-2">Lingua</th>
												<th class="pl-2">Livello</th>
												<label>Indica il tuo livello di certificazione nelle seguenti lingue</label> 
										</tr>
										<tr>
										<td class="pl-2">Inglese</td>
										<td><select class="lingua ml-2" name="inglese" required>
											<option value="NA">NA</option>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
											<tr>
										<td class="pl-2">Francese</td>
										<td><select class="lingua ml-2" name="francese" required>
											<option value="NA">NA</option>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
											<tr>
										<td class="pl-2">Tedesco</td>
										<td><select class="lingua ml-2"  name="tedesco" required>
											<option value="NA">NA</option>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
										<td class="pl-2">Spagnolo</td>
										<td><select class="lingua ml-2" name="spagnolo" required>
											<option value="NA">NA</option>
											<option value="A1">A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
											</select></td>
											</tr>
										</table></div>



												<div class="form-group mt-5">
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
