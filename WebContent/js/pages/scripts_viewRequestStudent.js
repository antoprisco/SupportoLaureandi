$(document).ready(function() {

});
				
function showData() {
	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletStudent",
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
				$("#bodyStudentTable").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}