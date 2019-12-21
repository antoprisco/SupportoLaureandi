<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"
	import="controller.CheckSession , controller.Utils "%>

<%
  String pageName = request.getParameter("pageName");
  String pageFolder = request.getParameter("pageFolder");
  String menu = "";
  String hiddenMenu = "";
  String logoRedirect= "";		//tiene traccia del path a cui reindirizzare il sito quando si preme sul logo
  
  
  CheckSession ck = new CheckSession(pageFolder, pageName, request.getSession());
  if(!ck.isAllowed()){			//cliccando sul logo reinderizza a index se non si � loggati
	  logoRedirect = request.getContextPath()+ck.getUrlRedirect();
  }

  if (pageFolder.equals("_areaAdmin")) { //se stiamo in una pagina dell'area admin
	  logoRedirect = request.getContextPath()+"/_areaAdmin/viewRequest.jsp";
  
    if (pageName.equals("viewRequest.jsp") || pageName.equals("viewRequestLM.jsp") || pageName.equals("viewRequestOU.jsp")) {
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/viewRequest.jsp\">Richieste</a></li>";
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
           + "/viewRequestLM.jsp\">Laurea Magistrale</a></li>";
      menu +=  "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
        			 + "/viewReqOU.jsp\">Orientamento in uscita</li>";
      menu +=
          "<li><a href=\"" + request.getContextPath() + "/index.jsp\">Disconnetti</a></li>";
    }
    
  } else if (pageFolder.equals("_areaSecretary")) { //se stiamo in una pagina dell'area segreteria
	  logoRedirect = request.getContextPath()+"/_areaSecretary/viewRequest.jsp";
  
    if (pageName.equals("viewRequest.jsp")|| pageName.equals("viewRequestLM.jsp") || pageName.equals("viewRequestOU.jsp")) {
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/viewRequest.jsp\">Richieste</a></li>";
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
                  + "/viewRequestLM.jsp\">Laurea Magistrale</a></li>";
      menu +=  "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
              			 + "/viewRequestOU.jsp\">Orientamento in uscita</li>";
      menu +=
          "<li><a href=\"" + request.getContextPath() + "/index.jsp\">Disconnetti</a></li>";
    }
  } else if (pageFolder.equals("_areaStudent")) { //se stiamo in una pagina dell'area studente
	 logoRedirect = request.getContextPath()+"/_areaStudent/viewRequest.jsp";
  
    if (pageName.equals("viewRequest.jsp") || pageName.equals("FormLM.jsp") || pageName.equals("firstForm.jsp")) { //se stiamo in viewRequest
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/viewRequest.jsp\">Richieste</a></li>";
      menu += "<li><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/firstForm.jsp\">Compila Richiesta</a></li>";
      menu += "<li><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/uploadAttached.jsp\">Carica Allegato</a></li>";
      menu +="<li><a href=\"" + request.getContextPath() + "/" + pageFolder
    		  + "/FormLM.jsp\">Laurea Magistrale</li>";
      menu +=  "<li><a href=\"" + request.getContextPath() + "/" + pageFolder
     			 + "/viewFormOU.jsp\">Orientamento in uscita</li>";
      menu += "<li><a href=\"" + request.getContextPath() + "/" + pageFolder
    			  + "/gfdgd.sjp\">Iscrizione a corsi singoli</li>";
      menu +=
          "<li><a href=\"" + request.getContextPath() + "/logout.jsp\">Disconnetti</a></li>";
    }
    if (pageName.equals("uploadAttached.jsp")) {
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/uploadAttached.jsp\">Carica Allegato</a></li>";
      menu +=
          "<li><a href=\"" + request.getContextPath() + "/logout.jsp\">Disconnetti</a></li>";
    }
    if (pageName.equals("signUp.jsp")) {
		logoRedirect = request.getContextPath()+ck.getUrlRedirect();	//siccome signUp � raggiungibile solo quando non sono loggato
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath() + "/" + pageFolder
          + "/signUp.jsp\">Registrati</a></li>";
      menu += "<li><a href=\"" + request.getContextPath() + "/index.jsp\">Benvenuto</a></li>";
    }
  } else if (pageFolder.equals("")) { //se non siamo (o siamo) loggati
    if (pageName.equals("login.jsp")) { //se ci troviamo in login.jsp
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath()
          + "/login.jsp\">Login</a></li>";
      menu += "<li><a href=\"" + request.getContextPath() + "/index.jsp\">Benvenuto</a></li>";
    } else if (pageName.equals("index.jsp")) { //se ci troviamo in index.jsp
      menu += "<li class=\"current\"><a href=\"" + request.getContextPath()
          + "/index.jsp\">Benvenuto</a></li>";
    } else { //se ci troviamo in logout.jsp
      if (pageName.equals("logout.jsp") && ck.isAllowed()) {
        menu += "<li class=\"current\"><a href=\"" + request.getContextPath()
            + "/logout.jsp\">Disconnetti</a></li>";
        menu += "<li><a href=\"" + request.getContextPath() + "/login.jsp\">Accedi</a></li>";
      }
    }
  }


  hiddenMenu = menu;
%>
<!-- Modal -->
<div id="defaultModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<form action="#">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>
				</div>
			</div>
		</form>

	</div>
</div>
<!-- Main Header -->
<header class="main-header">
	<!--Header-Upper-->
	<div class="header-upper">
		<div class="auto-container">
			<div class="clearfix">

				<div class="logo-outer">
					<div class="logo">
						<a href="<%=logoRedirect%>"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--End Header Upper-->

	<!--Header Lower-->
	<div class="header-lower">
		<div class="auto-container">
			<div class="nav-outer clearfix">

				<!-- Main Menu -->
				<nav class="main-menu">
					<div class="navbar-collapse collapse clearfix"
						id="bs-example-navbar-collapse-1">
						<ul class="navigation clearfix">
							<%=menu%>
						</ul>
					</div>
				</nav>


				<!-- Hidden Nav Toggler -->
				<div class="nav-toggler">
					<button class="hidden-bar-opener">
						<span class="icon qb-menu1"></span>
					</button>
				</div>

			</div>
		</div>
	</div>
	<!--End Header Lower-->

</header>
<!--End Header Style Two -->

<!-- Hidden Navigation Bar -->
<section class="hidden-bar left-align">

	<div class="hidden-bar-closer">
		<button>
			<span class="qb-close-button"></span>
		</button>
	</div>

	<!-- Hidden Bar Wrapper -->
	<div class="hidden-bar-wrapper">
		<div class="logo">
			<a href="#"></a>
		</div>
		<!-- .Side-menu -->
		<div class="side-menu">
			<!--navigation-->
			<ul class="navigation clearfix">
				<%=hiddenMenu%>
			</ul>
		</div>
		<!-- /.Side-menu -->

	</div>
	<!-- / Hidden Bar Wrapper -->


</section>
<!-- End / Hidden Bar -->
