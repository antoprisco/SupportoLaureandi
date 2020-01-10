

function callChangData() {
	
	var name = $("#nome").val();
	var id = $("#idR").data();

	$.ajax({
		url : absolutePath + "/ServletChangeData",
		type : "POST",
		dataType : 'JSON',
		async : false,
		data : {
			"flag" : 1,
			"nome" : name,
			"id" : id
		},
		success : function(msg) {
			if (!msg.result) {
				showAlert(1, msg.error);
			} else {
				$("#bodySecretaryBody").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile cambiare i dati.");
		}
	});
}

function showData() {

	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletViewReqCS",
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
				$("#bodySecretaryBody").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}

$(document)
		.ready(
				function() {

					$(document)
					.on(
							"submit",
							"#saveSurname",
							function() {
								var idr = $("#saveSurname .confirm")
										.data("idr");
								var newSurname = $(
										"#saveSurname #surname").val();
								if (true) {
									$(".preloader").show();

									$
											.ajax({
												url : absolutePath
														+ "/ServletChangeData",
												type : "POST",
												dataType : 'JSON',
												async : false,
												data : {
													"id" : idr,
													"newSurname" : newSurname,
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
							".changeSurname",
							function() {
								var idr =parseInt($(this).data("idr"));
								var surname = $(this).data("surname");
								var title = '';
								var text = '';
								var footer = '';

								if (true) {
									$(".preloader").show();

									title = 'Cambia Cognome';

									text += '<div class="form-group">';
									text += '<label for="name">Inserire il nuovo Cognome:</label>';
									text += '<input type="text" class="form-control" id="surname" placeholder="nuovo Cognome" minlength="1" maxlength="20" value="'
											+'" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-idr="'+ idr +'">Salva</button>';

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
								var idr = $("#saveName .confirm")
										.data("idr");
								var newName = $("#saveName #name")
										.val();
								if (true) {
									$(".preloader").show();

									$
											.ajax({
												url : absolutePath
														+ "/ServletChangeData",
												type : "POST",
												dataType : 'JSON',
												async : false,
												data : {
													"id" : idr,
													"newName" : newName,
													"flag" : 1
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
								var idr = parseInt($(this).data("idr"));
								var name = $(this).data("name");
								var title = '';
								var text = '';
								var footer = '';

								if (true) {
									$(".preloader").show();

									title = 'Cambia Nome';

									text += '<div class="form-group">';
									text += '<label for="name">Inserire il nuovo Nome:</label>';
									text += '<input type="text" class="form-control" id="name" placeholder="nuovo Nome" minlength="1" maxlength="20" value="'
											+ '" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-idr="'+ idr +'">Salva</button>';

											

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
			
								
						});				
