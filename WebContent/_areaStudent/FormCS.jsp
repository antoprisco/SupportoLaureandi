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

<style type="text/css">
.dropzoneUploader.dz-clickable {
    background-color: darkorange;
    border-radius: 5px;
    text-align: center;
    margin-bottom: 10px;
    height: auto;
}
</style>
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

										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="cognome">Cognome</label> 
												<input class="form-control"	type="text" id="cognome" value="<%=user.getSurname()%>" required>
										</div>

										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="nome">Nome</label> 
											<input class="form-control"	type="text" id="nome" value="<%=user.getName()%>" required>
										</div>

										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="luogoNascita">Luogo di Nascita:</label> 
											<input class="form-control" type="text" id="luogoNascita" value="" required>
										</div>

										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="provincia" >Provincia</label> 
											<input class="form-control" type="text" value="" id="provincia" required>
										</div>

									<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="dataNascita" >Data di nascita</label> 
											<input class="form-control" type="date" value="" id="dataNascita">
										</div>
				<!-- DATI RESIDENZA --> 
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
												<label for="residenza">Residenza</label> 
												<input class="form-control" type="text" id="residenza" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="provinciaR" >Provincia</label> 
											<input class="form-control" type="text" value="" id="provinciaR" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="indirizzo" >Indirizzo</label> 
											<input class="form-control" type="text" value="" id="indirizzo" required>
										</div>


										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="cap">CAP:</label> 
											<input class="form-control" type="number" value="" id="cap" required>
										</div>
          		<!-- FINE RESIDENZA --> 
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="telefonoF">Telefono fisso:</label> 
											<input class="form-control" type="text" value="" id="telefonoF" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="cellulare">Cellulare:</label> 
											<input class="form-control" type="text" value="" id="cellulare" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="cf">Codice fiscale:</label> 
											<input class="form-control" type="text" value="" id="cf" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="email">Email:</label> 
											<input class="form-control" type="text" value="<%=user.getEmail()%>" id="email" required>
										</div>
					<!-- DIPLOMA -->	
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="diploma">Diploma:</label> 
											<input class="form-control" type="text" value="" id="diploma" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="annoD">conseguito nell'anno:</label> 
											<input class="form-control" type="text" value="" id="annoD" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="istituto">presso l'istituto:</label> 
											<input class="form-control" type="text" value="" id="istituto" required>
										</div>
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="comune">comune:</label> 
											<input class="form-control" type="text" value="" id="comune" required>
										</div>
				<!-- TITOLO DI STUDIO --> 
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="laurea">Laurea (Titolo):</label> 
											<input class="form-control" type="text" value="" id="laurea" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="dataL">conseguito in data:</label> 
											<input class="form-control" type="date" value="" id="dataL" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="universita">presso l'università:</label> 
											<input class="form-control" type="text" value="" id="universita" required>
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="matricola">Matricola</label> 
											<input	class="form-control" type="number" value="512103683" id="matricola" required>
										</div>
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="voto">con voto</label> 
											<input	class="form-control" type="number" value="" id="voto" required>/110
										</div>
										
										<div class="col-lg-6 col-tb-6 col-sm-6 col-xs-6 form-cs">
											<label for="lode">Lode</label>
											<input type="radio"  class="lode" name="lode" value="si">Si
											<input type="radio"  class="lode" name="lode" value="no">No
										</div>
										<br>
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
										
										
						
										<center><h2>Seleziona corsi</h2></center>
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
										
									<center><h2>Carica allegati</h2></center>
										
										<div action='<%= request.getContextPath() + "/UploaderCS" %>'
											class='dropzoneUploader'>
											Trascina o clicca su questo riquadro per caricare i file
											</div>
											
	
											

										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-submit"
												id='aggiungiAllegati'>Concludi</button>
										</div>
									
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
	
			<script>
			$( document ).ready(function() {	
				$(".dropzoneUploader").dropzone({
					  maxFiles: 2,
					  acceptedFiles: ".pdf",
					  accept: function(file, done){
					    done();
					  },
					  init: function() {		
					      this.on("maxfilesexceeded", function(file, errorMessage){
					    	  this.removeFile(file);
					    	  showAlert(1, errorMessage);		    	  
					      });
	                      
					      this.on("error", function(file, errorMessage) {
					    	  this.removeFile(file);
					    	  showAlert(1, errorMessage);
	                      });
	                    
						  this.on("success", function(file, response) {
							  var msg = jQuery.parseJSON(response);
						  	  if(!msg.result){
						  		showAlert(1, msg.error);
						  	  }	            		    
						  	  else{
						  		file.previewElement.querySelector("[data-dz-name]").innerHTML = msg.content;
						  	  }
						  });
					  }		  						
				});					
			});
		</script>

	<script	src="<%= request.getContextPath() %>/js/pages/scripts_FormCS.js"></script>
	
	<script src="<%= request.getContextPath() %>/js/filesystem_dropzone.js"></script>
	
	<script	src="<%= request.getContextPath() %>/js/pages/scripts_UploadFiles.js"></script> 

</body>
</html>
