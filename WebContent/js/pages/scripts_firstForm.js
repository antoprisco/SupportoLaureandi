$(document)
		.ready(
				function() {

					$(document)
							.on(
									'submit',
									'#firstForm',
									function(e) {
										var year = $("#immatricolazione").val();
										var serial = $("#matricola").val();
										var idEnte = $("#ente").val();
										var releaseDate = $("#datarilascio")
												.val();
										var expiryDate = $("#datascadenza")
												.val();
										var certificateSerial = $("#seriale")
												.val();
										var level = $("#lvlcefr").val();
										;
										var requestedCfu = $("#cfu").val();

										if (year != undefined
												&& certificateSerial != undefined
												&& ente != undefined
												&& expiryDate != undefined
												&& releaseDate != undefined
												&& serial != undefined
												&& level != undefined
												&& requestedCfu != undefined) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/ServletStudent",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"year" : year,
															"serial" : serial,
															"idEnte" : idEnte,
															"expiryDate" : expiryDate,
															"releaseDate" : releaseDate,
															"certificateSerial" : certificateSerial,
															"level" : level,
															"requestedCfu" : requestedCfu,
															"flag" : 2
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

$(document).ready(function() {
	$(document).on('click', '.btn btn-primary generatePDF', function(e) {

		$.ajax({
			url : absolutePath + "/ServletStudent",
			type : "POST",
			dataType : 'JSON',
			async : false,
			data : {
				"flag" : 4
			},

		});

	});
});