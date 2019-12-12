$(document)
		.ready(
				function() {

					$(document)
					.on(
							"submit",
							"#saveSurname",
							function() {
								var idUser = $("#saveSurname .confirm")
										.data("iduser");
								var newSurname = $(
										"#saveSurname #surname").val();
								if (idUser != undefined
										&& idUser.length > 0
										&& newSurname != undefined) {
									$(".preloader").show();

									$
											.ajax({
												url : absolutePath
														+ "/ServletCommon",
												type : "POST",
												dataType : 'JSON',
												async : false,
												data : {
													"idUser" : idUser,
													"newSurname" : newSurname,
													"flag" : 3
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
														$(
																"#defaultModal")
																.modal(
																		"hide");
														setTimeout(
																function() {
																	showData();
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
									showAlert(1, "Errore parametri.");
								}
							});

			$(document)
					.on(
							"click",
							".changeSurname",
							function() {
								var idUser = $(this).data("iduser");
								var surname = $(this).data("surname");
								var title = '';
								var text = '';
								var footer = '';

								if (idUser != undefined
										&& idUser.length > 0
										&& surname != undefined
										&& surname.length > 0) {
									$(".preloader").show();

									title = 'Cambia Cognome';

									text += '<div class="form-group">';
									text += '	<label for="name">Inserire il nuovo Cognome:</label>';
									text += '	<input type="text" class="form-control" id="surname" placeholder="Cognome" minlength="1" maxlength="20" value="'
											+ surname + '" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-iduser="'
											+ idUser
											+ '" >Salva</button>';

									$("#defaultModal form").attr("id",
											"saveSurname");
									$("#defaultModal .modal-title")
											.html(title);
									$("#defaultModal .modal-body")
											.html(text);
									$("#defaultModal .modal-footer")
											.html(footer);

									$("#defaultModal").modal("show");

									$(".preloader").hide();
								} else {
									showAlert(1, "Errore parametri.");
								}
							});

			$(document)
					.on(
							"submit",
							"#saveName",
							function() {
								var idUser = $("#saveName .confirm")
										.data("iduser");
								var newName = $("#saveName #name")
										.val();
								if (idUser != undefined
										&& idUser.length > 0
										&& newName != undefined) {
									$(".preloader").show();

									$
											.ajax({
												url : absolutePath
														+ "/ServletCommon",
												type : "POST",
												dataType : 'JSON',
												async : false,
												data : {
													"idUser" : idUser,
													"newName" : newName,
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
														$(
																"#defaultModal")
																.modal(
																		"hide");
														setTimeout(
																function() {
																	showData();
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
									showAlert(1, "Errore parametri.");
								}
							});

			$(document)
					.on(
							"click",
							".changeName",
							function() {
								var idUser = $(this).data("iduser");
								var name = $(this).data("name");
								var title = '';
								var text = '';
								var footer = '';

								if (idUser != undefined
										&& idUser.length > 0
										&& name != undefined
										&& name.length > 0) {
									$(".preloader").show();

									title = 'Cambia Nome';

									text += '<div class="form-group">';
									text += '	<label for="name">Inserire il nuovo Nome:</label>';
									text += '	<input type="text" class="form-control" id="name" placeholder="Nome" minlength="1" maxlength="20" value="'
											+ name + '" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-iduser="'
											+ idUser
											+ '" >Salva</button>';

									$("#defaultModal form").attr("id",
											"saveName");
									$("#defaultModal .modal-title")
											.html(title);
									$("#defaultModal .modal-body")
											.html(text);
									$("#defaultModal .modal-footer")
											.html(footer);

									$("#defaultModal").modal("show");

									$(".preloader").hide();
								} else {
									showAlert(1, "Errore parametri.");
								}
							});					
					
					$(document)
							.on(
									"click",
									".toWorkingAdmin",
									function() {
										var idRequest = $(this).data(
												"idrequest");
										if (idRequest != undefined
												&& idRequest > 0) {
											if (confirm("Conferma l'inoltro della richiesta all'amministratore?")) {
												$(".preloader").show();

												$
														.ajax({
															url : absolutePath
																	+ "/ServletSecretary",
															type : "POST",
															dataType : 'JSON',
															async : false,
															data : {
																"flag" : 3,
																"idRequest" : idRequest
															},
															success : function(
																	msg) {
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
																				showData();
																			},
																			2000);
																}
															},
															error : function(
																	msg) {
																showAlert(1,
																		"Impossibile Recuperare i dati.");
															}
														});

												$(".preloader").hide();
											}
										} else {
											showAlert(1, "Errore parametri.");
										}

									});

					$(document)
							.on(
									"click",
									".saveCfu",
									function() {
										var idRequest = $(this).data(
												"idrequest");
										var cfu = $(this).closest("td")
												.children(".cfuToValidate")
												.val();
										if (idRequest != undefined
												&& idRequest > 0
												&& cfu != undefined && cfu < 13) {
											if (confirm("Conferma l'inserimento di "
													+ cfu
													+ " cfu per questa richiesta?")) {
												$(".preloader").show();

												$
														.ajax({
															url : absolutePath
																	+ "/ServletSecretary",
															type : "POST",
															dataType : 'JSON',
															async : false,
															data : {
																"flag" : 2,
																"idRequest" : idRequest,
																"cfu" : cfu
															},
															success : function(
																	msg) {
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
																				showData();
																			},
																			2000);
																}
															},
															error : function(
																	msg) {
																showAlert(1,
																		"Impossibile Recuperare i dati.");
															}
														});

												$(".preloader").hide();
											}
										} else {
											showAlert(1,
													"Si prega di compilare correttamente tutti i campi.");
										}

									});
				});

function showData() {
	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletSecretary",
		type : "POST",
		dataType : 'JSON',
		async : false,
		data : {
			"flag" : 1
		},
		success : function(msg) {
			if (!msg.result) {
				showAlert(1, msg.error);
			} else {
				$("#bodySegretaryBody").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}
