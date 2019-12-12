$(document)
		.ready(
				function() {

					$(document)
							.on(
									'submit',
									'#formRLM',
									function(e) {
										
										var anno = $("#anno").val();
										
										

										if (anno!= undefined) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/ServletCercaLM",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"anno" : anno,
															"flag" : 7
																										
															
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
																	"Impossibile recuperare i dati per FORMRLM.");
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

