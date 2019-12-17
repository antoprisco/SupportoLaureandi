<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<meta charset="utf-8">
<title>Supporto Laureandi - Universit&agrave; degli Studi di
	Salerno</title>

<!-- Stylesheets -->
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/newCss.css">

<link href="<%= request.getContextPath() %>/css/bootstrap-grid.css"
	rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/bootstrap.css"
	rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/style.css"
	rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/responsive.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/autofill/2.3.2/css/autoFill.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.4/css/buttons.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/colreorder/1.5.0/css/colReorder.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedcolumns/3.2.5/css/fixedColumns.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.4/css/fixedHeader.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/keytable/2.5.0/css/keyTable.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.2/css/responsive.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/rowgroup/1.1.0/css/rowGroup.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/rowreorder/1.2.4/css/rowReorder.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/scroller/1.5.0/css/scroller.dataTables.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.2.6/css/select.dataTables.css"/>

<link href="<%= request.getContextPath() %>/css/font-awesome.css"
	rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/toastr.min.css"
	rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/styleEV.css"
	rel="stylesheet">
	

<!--Color Themes-->
<link id="theme-color-file"
	href="<%= request.getContextPath() %>/css/color-themes/default-theme.css"
	rel="stylesheet">

<!--Favicon-->
<link rel="apple-touch-icon" sizes="57x57"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="<%= request.getContextPath() %>/images/favicon/favicon.png">
<meta name="msapplication-TileImage"
	content="<%= request.getContextPath() %>/images/favicon/favicon.png">

<!-- Responsive -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!--[if lt IE 9]><script src="<%= request.getContextPath() %>/js/html5shiv.js"></script><![endif]-->
<!--[if lt IE 9]><script src="<%= request.getContextPath() %>/js/respond.js"></script><![endif]-->