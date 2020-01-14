$(document)
		.ready(
				function() {
					
							
					$(document)
							.on(
									'submit',
									'#FormCS',
									function(e) {
										var cognome = $("#cognome").val();
										var nome = $("#nome").val();
										var luogoNascita = $("#luogoNascita").val();
										var provincia = $("#provincia").val();
										var dataNascita = $("#dataNascita").val();
										var residenza = $("#residenza").val();
										var provinciaR = $("#provinciaR").val();;
										var indirizzo = $("#indirizzo").val();
										var cap = $("#cap").val();
										var telefonoF = $("#telefonoF").val();
										var cellulare = $("#cellulare").val();
										var cf = $("#cf").val();
										var email = $("#email").val();
										var diploma = $("#diploma").val();
										var annoD = $("#annoD").val();
										var istituto = $("#istituto").val();
										var comune = $("#comune").val();
										var laurea = $("#laurea").val();
										var dataL = $("#dataL").val();
										var universita = $("#universita").val();
										var matricola = $("#matricola").val();
										var voto = $("#voto").val();
										var lode = $(".lode:checked").val();
										var year = $("#immatricolazione").val();
										var scelta =[];
										
										var flag=0;
										var primocheck=undefined;
										
										$("tr.esami").each(function() {
											  tr=$(this);
											  var nomeEsame=tr.first('td').text().trim();
											  var idEsame= tr.find("input[type='checkbox']:checked").val();
											  
											  $("input[type='checkbox']:checked").each(function(){
												   primocheck=tr.find("input[type='checkbox']:checked").val();
												   if(primocheck!=undefined){
													   scelta.push({esame: nomeEsame,value:idEsame});
												   }
												   else{
													   flag=1;
												   }
											  })
											  
											
										});
										/*
										if (flag==1){
											showAlert(1,"Seleziona almeno un corso per effettuare la richiesta");
											flag=2;
										}*/
										
										console.log(JSON.stringify(scelta));
										

										if (cognome != undefined
												&& nome != undefined
												&& luogoNascita != undefined
												&& provincia != undefined
												&& dataNascita != undefined
												&& residenza != undefined
												&& provinciaR != undefined
												&& indirizzo != undefined
												&& cap != undefined
												&& telefonoF != undefined
												&& cellulare != undefined
												&& cf != undefined
												&& email != undefined
												&& diploma != undefined
												&& annoD != undefined
												&& istituto != undefined
												&& comune != undefined
												&& laurea != undefined
												&& dataL != undefined
												&& universita != undefined
												&& matricola != undefined
												&& voto != undefined
												&& lode != undefined
												&& year != undefined
												&& scelta.length > 0
										) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/ServletFormCS",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															
															
															 "cognome": cognome,
															 "nome": nome,
															 "luogoNascita" : luogoNascita,
															 "provincia": provincia,
															 "dataNascita": dataNascita,
															 "residenza" : residenza,
															 "provinciaR": provinciaR,
															 "indirizzo" : indirizzo,
															 "cap": cap,
															 "telefonoF": telefonoF, 
															 "cellulare": cellulare,
															 "cf": cf,
															 "email": email,
															 "diploma": diploma,
															 "annoD": annoD,
															 "istituto": istituto,
															 "comune": comune,
															 "laurea": laurea,
															 "dataL": dataL,
															 "universita": universita,
															 "matricola" : matricola,
															 "voto" : voto,
															 "lode" : lode,	
															 "year" : year,
															 "scelta" : JSON.stringify(scelta),
															
															
															 "flag" : 8
														},
														success : function(msg) {
															if (!msg.result) {
																showAlert(
																		1,
																		msg.error);
															} else {
																showAlert(
																		0,
																		msg.content);
																
																

																setTimeout(
																		function() {
																			window.location.href = msg.redirect;
																		}, 2000);
																
																$(".preloader").show();
																window.location.href = absolutePath
																		+	"/DownloaderPDF?flag=1";
																$(".preloader").hide();
																//showData();
															}
														},
														error : function(msg) {
															showAlert(1,
																	"Impossibile Recuperare i dati.");
														}
													});

											$(".preloader").hide();
										} else {
											if(flag!=1){
											showAlert(1,
													"Errore prelevamento campi.");
											}
										}

										return false;
									}
							//INIZIO NUOVO FORM
									
									
							
							);//FINE ON
					
				
					

				});


function showData() {

	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletFormCS",
		type : "POST",
		dataType : 'JSON',
		async : false,
		data : {
			"flag" : 8
		},
		success : function(msg) {
			if (!msg.result) {
				showAlert(1, msg.error);
			} else {
				//$("#UploadFiles").show();
				$("#Allega").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}



