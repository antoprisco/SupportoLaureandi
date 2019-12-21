function showData() {

	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletViewReqOU",
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
				$("#bodySecretaryTable").html(msg.content);
			}
		},
		error : function(msg) {
			showAlert(1, "Impossibile Recuperare i dati.");
		}
	});

	$(".preloader").hide();
}


$(document).ready(function(){
	$(".b").hide();
  $("button").click(function(){
    $(".b").toggle();
    
  });
});