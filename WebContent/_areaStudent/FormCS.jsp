<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"
	import="controller.CheckSession, interfacce.* , model.*,java.util.ArrayList, model.SystemAttribute, java.text.SimpleDateFormat, java.time.*, controller.DbConnection, java.sql.Connection, java.sql.ResultSet, java.sql.Statement"%>

<%
	String pageName = "FormCS.jsp";
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
											<%
							UserInterface user = (UserInterface) request.getSession().getAttribute("user");

						%>
									</div>
									<form id="FormCS">

										<div class="form-group">
											<label for="cognome">Cognome</label> 
												<input class="form-control"	type="text" id="cognome" value="<%=user.getSurname()%>" required>
										</div>

										<div class="form-group">
											<label for="nome">Nome</label> 
											<input class="form-control"	type="text" id="nome" value="<%=user.getName()%>" required>
										</div>

										<div class="form-group">
											<label for="luogoNascita">Luogo di Nascita:</label> 
											<input class="form-control" type="text" id="luogoNascita" value="" required>
										</div>

										<div class="form-group">
											<label for="provincia" >Provincia</label> 
											<input class="form-control" type="text" value="" id="provincia" required>
										</div>

										<div class="form-group">
											<label for="dataNascita" >Data di nascita</label> 
											<input class="form-control" type="date" value="" id="dataNascita">
										</div>
				<!-- DATI RESIDENZA --> <hr>
										<div class="form-group">
												<label for="residenza">Residenza</label> 
												<input class="form-control" type="text" id="residenza" required>
										</div>
										
										<div class="form-group">
											<label for="provinciaR" >Provincia</label> 
											<input class="form-control" type="text" value="" id="provinciaR" required>
										</div>
										
										<div class="form-group">
											<label for="indirizzo" >Indirizzo</label> 
											<input class="form-control" type="text" value="" id="indirizzo" required>
										</div>


										<div class="form-group">
											<label for="cap">CAP:</label> 
											<input class="form-control" type="number" value="" id="cap" required>
										</div>
          		<!-- FINE RESIDENZA --> <hr>
										<div class="form-group">
											<label for="telefonoF">Telefono fisso:</label> 
											<input class="form-control" type="text" value="" id="telefonoF" required>
										</div>
										
										<div class="form-group">
											<label for="cellulare">Cellulare:</label> 
											<input class="form-control" type="text" value="" id="cellulare" required>
										</div>
										
										<div class="form-group">
											<label for="cf">Codice fiscale:</label> 
											<input class="form-control" type="text" value="" id="cf" required>
										</div>
										
										<div class="form-group">
											<label for="email">Email:</label> 
											<input class="form-control" type="text" value="<%=user.getEmail()%>" id="email" required>
										</div>
					<!-- DIPLOMA -->	<hr>
										<div class="form-group">
											<label for="diploma">Diploma:</label> 
											<input class="form-control" type="text" value="" id="diploma" required>
										</div>
										
										<div class="form-group">
											<label for="annoD">conseguito nell'anno:</label> 
											<input class="form-control" type="text" value="" id="annoD" required>
										</div>
										
										<div class="form-group">
											<label for="istituto">presso l'istituto:</label> 
											<input class="form-control" type="text" value="" id="istituto" required>
										</div>
										<div class="form-group">
											<label for="comune">comune:</label> 
											<input class="form-control" type="text" value="" id="comune" required>
										</div>
				<!-- TITOLO DI STUDIO --> <hr>
										<div class="form-group">
											<label for="laurea">Laurea (Titolo):</label> 
											<input class="form-control" type="text" value="" id="laurea" required>
										</div>
										
										<div class="form-group">
											<label for="dataL">conseguito in data:</label> 
											<input class="form-control" type="date" value="" id="dataL" required>
										</div>
										
										<div class="form-group">
											<label for="universita">presso l'università:</label> 
											<input class="form-control" type="text" value="" id="universita" required>
										</div>
										
										<div class="form-group">
											<label for="matricola">Matricola</label> 
											<input	class="form-control" type="number" value="512103683" id="matricola" required>
										</div>
										<div class="form-group">
											<label for="voto">con voto</label> 
											<input	class="form-control" type="number" value="" id="voto" required>/100
										</div>
										
										<div class="form-group">
											<label for="lode">Lode</label>
											<input type="radio"  class="lode" name="lode" value="si">Si
											<input type="radio"  class="lode" name="lode" value="no">No
										</div>
										
										<div class="form-group">
											<label for="immatricolazione">Anno di immatricolazione:</label> 
												<select class="form-control"
												id="immatricolazione" required>
												<%
											    	Integer range = Integer.parseInt(new SystemAttribute().getValueByKey("request-matriculation-year-range"));
											    	for(int i = ((range*-0)+1); i <= 5; i++){
											    	  LocalDate year = LocalDate.now().plusYears(i);
											    	  LocalDate nextYear = LocalDate.now().plusYears(i+1);
											    	  %>
												<option value="<%= year.getYear()+"/"+nextYear.getYear()%>"><%= year.getYear() %>/<%= nextYear.getYear() %></option>
												<%
											    	}
											    %>
											</select>
										</div>
										
										
						
										<h2>Corsi</h2>
										<table id="Corsi">
										<tr>
											<th>ESAME</th>
											<th>CFU</th>
											<th>SEMESTRE</th>
											<th></th>
										</tr>
										
										<%
										Corsi c= new Corsi();
										CorsiDAO cd= new CorsiDAO();
										ArrayList<Corsi> lista= new ArrayList<Corsi>();
										lista=cd.doRetrieveAll();
										for (int i=0; i<lista.size();i++) {
											c=lista.get(i);
											%>
												<tr class="esami">
												<td data-esame="<%=c.getNome() %>"><%=c.getNome()%></td>
												<td><%=c.getCfu()%></td>
												<td><%=c.getSemestre()%></td>
												<td><input type="checkbox"  name="<%=c.getNome() %>" value="<%=c.getId()%>" ></td>
												</tr>
											<%
											
										}
										%>
										
										
										</table>
									
							
									
									

										<div class="form-group">
											<button  type="submit" class="btn btn-primary btn-submit">Genera PDF</button>
										</div>

										<div class="clearfix"></div>
										
									</form>
							
									
									
									
									<form id="UploadFiles">
									<div class="form-group">
									<h3>Allegare:</h3>
									
									
									<p>Domanda di iscrizione firmata</p>
									<ol>
									Allegare il file con l'opportuno nome: Iscrizione<%=user.getSurname()%>_Firmata.pdf
									</ol>
									
									<input id="UPI" class="form-control" type="file" name="myFile" required><br>
									
									<p>Un documento di riconoscimento</p>
									<ol>
									Allegare il file con l'opportuno nome: Documento<%=user.getSurname()%><%=user.getName()%>.pdf
									</ol>
									<input id="UPD" class="form-control" type="file" name="myFile" required><br>
  										<button type="submit" class="btn btn-primary btn-submit">Invia domanda</button>
  										
									</div>
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
	<script	src="<%= request.getContextPath() %>/js/pages/scripts_FormCS.js"></script>
	<script	src="<%= request.getContextPath() %>/js/pages/scripts_UploadFiles.js"></script>

</body>
</html>
