$(document).ready(function() {
	$(document).on('submit', '#formRLM', function(e) {
		
		var anno = $("#anno").val();
		if (anno != undefined) {
			$(".preloader").show();
			
			$.ajax({
				url : absolutePath + "/ServletCercaLM",
				type : "POST",
				dataType : 'JSON',
				async : false,
				data : {
					"anno" : anno,
					"flag" : 7
				},
				success : function(msg) {
					
					if (!msg.result) {
						$('#notify').remove();
						$('#graficoBello').remove();
						$('#graph-container').append('<div id= "notify">Non ci sono richieste per l anno selezionato<div>');
						
						
					} else {
						 $('#graficoBello').remove();
						 $('#notify').remove();
						  $('#graph-container').append('<canvas id="graficoBello"><canvas>');
						new Chart(
								  $("#graficoBello"),
								  {
								    "type": "horizontalBar",
								    "data": {
								      "labels": msg.curriculum,
								      "datasets": [
								        {
								          "label": "Studenti Potenziali",
								          "data": msg.count,
								          "fill": false,
								          "borderColor": "rgb(75, 192, 192)",
								          "lineTension": 0.1
								        }
								      ]
								    },
								    "options":{}
								  }
								)
						/*showAlert(0, msg.content);

						setTimeout(function() {
							window.location.href = msg.redirect;
						}, 2000);
						new Chart(
  $("#graficoBello"),
  {
    "type": "orizontal-bar",
    "data": {
      "labels": ["January", "February", "March", "April", "May", "June", "July"],
      "datasets": [
        {
          "label": "My First Dataset",
          "data": [65,59,80,81,56,55,40],
          "fill": false,
          "borderColor": "rgb(75, 192, 192)",
          "lineTension": 0.1
        }
      ]
    },
    "options":{}
  }
)
						*/
						
					}
				},
				error : function(msg) {
					showAlert(1, "Selezionare un anno accademico");
				}
			});

			$(".preloader").hide();
		} else {
			showAlert(1, "Errore prelevamento campi.");
		}

		return false;
	});

});
