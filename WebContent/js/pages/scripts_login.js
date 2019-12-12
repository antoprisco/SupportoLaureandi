$(document).ready(function() {

	$(document).on("submit", "#login", function() {
		var email = $("#email").val();
		var password = $("#password").val();

		if (email != undefined && password != undefined) {
			$(".preloader").show();

			$.ajax({
				url : absolutePath + "/ServletCommon",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"email" : email,
					"password" : password,
					"flag" : 1
				},
				success : function(msg) {
					if (!msg.result) {
						showAlert(1, msg.error);
					} else {
						window.location.href = msg.redirect;
					}
				},
				error : function(msg) {
					showAlert(1, "Impossibile Recuperare i dati.");
				}
			});

			$(".preloader").hide();
		} else {
			showAlert(1, "Errore prelevamento dati.");
		}

		return false;
	});

});