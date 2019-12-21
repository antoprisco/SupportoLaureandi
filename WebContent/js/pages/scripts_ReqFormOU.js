$(document)
		.ready(
				function() {

					$(document)
							.on(
									'submit',
									'#ReqFormOU',
									function(e) {
										var nome = $("#nome").val();
										var cognome = $("#cognome").val();
										var datanascita = $("#datanascita").val();
										var email = $("email").val();
										var telefono = $("#telefono").val();
								
										if (  nome != undefined
												&& cognome != undefined
												&& datanascita != undefined
												&& email != undefined
												&& telefono != undefined
											) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/RequestOU",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"nome" : year,
															"cognome" : serial,
															"datanascita" : idEnte,
															"email" : expiryDate,
															"telefono" : releaseDate
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
															}
														},
														error : function(msg) {
															showAlert(1,
																	"Impossibile Recuperare i dati.");
														}
													});

											$(".preloader").hide();
										} else {
											showAlert(1,
													"Errore prelevamento campi.");
										}

										return false;
									});

				});