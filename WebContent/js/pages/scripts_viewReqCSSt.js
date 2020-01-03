function showData() {

	$(".preloader").show();

	$.ajax({
		url : absolutePath + "/ServletViewRequestCSStudent",
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
				$("#bodyAdminTable").html(msg.content);
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
	  $(this).siblings(".b").toggle();
    
  });
});