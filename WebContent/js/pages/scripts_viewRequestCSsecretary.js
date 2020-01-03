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
					.on(
							"click",
							".changeName",
							function() {
								var idR = $("#idR").val();
								var name = $("#nome").val();
								var title = '';
								var text = '';
								var footer = '';

								if (name != undefined
									|| name.length > 0) {
									$(".preloader").show();

									title = 'Cambia Nome';

									text += '<div class="form-group">';
									text += '	<label for="name">Inserire il nuovo Nome:</label>';
									text += '	<input type="text" class="form-control" id="nome" placeholder="Nome" minlength="1" maxlength="20" value="'
											+ name + '" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-id="'
											+ idR
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
					
							/*$(document)
												.on(
														"submit",
														"#saveName",
														function() {
															var idR = $("#saveName idR")
																	.val();
															var newName = $("#saveName #name")
																	.val();
															var cog = $("#cognome").val();
															if (name != undefined
																|| name.length > 0) {
																$(".preloader").show();

																$
																		.ajax({
																			url : absolutePath
																					+ "/ServletViewRequesCS",
																			type : "POST",
																			dataType : 'JSON',
																			async : false,
																			data : {
																				"flag" : 2,
																				"idR" : idR,
																				"nome" : newName,
																				"cognome" : cog
																				
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
																					//setTimeout(
																						//	function() {
																								showData();
																							//}, 2000);
																				}
																			},
																			error : function(msg) {
																				showAlert(1,
																						"Impossibile Recuperare i dati.");
																			}
																		});*/
        $(document)
					.on(
							"click",
							".changeSurname",
							function() {
								var idR = $("#idR").val();
								var cog = $("#cognome").val();
								var title = '';
								var text = '';
								var footer = '';

								if (cog != undefined
									|| cog.length > 0) {
									$(".preloader").show();

									title = 'Cambia Cognome';

									text += '<div class="form-group">';
									text += '	<label for="name">Inserire il nuovo Cognome:</label>';
									text += '	<input type="text" class="form-control" id="cognome" placeholder="Cognome" minlength="1" maxlength="20" value="'
											+ cog + '" required>';
									text += '</div>';

									footer += '<button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>';
									footer += '<button type="submit" class="btn btn-default btn-success confirm" data-id="'
											+ idR
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
