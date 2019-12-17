$(document).ready(function() {
	$('#anno').change( function(e) {	
		var anno = $("#anno").val();
		if (anno !== undefined && anno !== 'Open this select menu') {
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
						$('#graph-container').append('<div id= "notify" class="mt-5">Non ci sono richieste per l\'anno selezionato<div>');
						
						
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
								    "options":{
								    	"scales":{
								    		"xAxes":[{
								    			"ticks":{
								    				"beginAtZero": true,
								    				"precision": 0,
								    				"suggestedMax": 100
								    			}
								    		}]
								    	}
								    }
								  }
								)

						
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
