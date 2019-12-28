$(document)
		.ready(
				function() {
					
							
					$(document)
							.on(
									'submit',
									'#UploadFiles',
									function(e) {
										
										var UPI = $("#UPI").val();
										var UPD = $("#UPD").val()
										
										if (UPI != undefined
												&& UPD != undefined
												
										) {
											$(".preloader").show();

											$
													.ajax({
														url : absolutePath
																+ "/ServletUploadFiles",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															
															
															 "UPI": UPI,
															 "UPD": UPD,
															
															
															
															 "flag" : 4
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
									}
							//INIZIO NUOVO FORM
									
									
							
							);//FINE ON
					

				});


function showData() {

	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletUploadFiles",
		type : "POST",
		dataType : 'JSON',
		async : false,
		data : {
			"flag" : 4
		},
		success : function(msg) {
			if (!msg.result) {
				showAlert(1, msg.error);
			} else {
				$("table").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}
