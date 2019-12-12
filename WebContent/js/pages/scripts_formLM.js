$(document)
		.ready(
				function() {

					$(document)
							.on(
									'submit',
									'#FormLM',
									function(e) {
										var curriculum = $("#curriculum").val();
										var anno = $("#anno").val();
										
										

										if (curriculum != undefined
												&& anno!= undefined) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/ServletFormLM",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"curriculum" : curriculum,
															"anno" : anno,
															"flag" : 6
																										
															
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
																	"Impossibile recuperare i dati per FORMLM.");
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

