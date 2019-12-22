$(document).ready(
				function() {
					showAlert(1,"entro nello script.");
					$(document)
							.on(
									'submit',
									'#FormOU',
									function(e) {
										showAlert(1,"prelevo i campi");
										var nome = $("#nome").val();
										var cognome = $("#cognome").val();
										var datanascita = $("#datanascita").val();
										var email = $("#email").val();
										var telefono = $("#telefono").val();
										var skills = [];
										var softSkills = []; 
										var lingue = [];
										
										$("tr.skills").each(function() {
											  tr=$(this);
											  var nomeSkill=tr.first('td').text().trim();
											  var checked = tr.find("input[type='radio']:checked");
											  if (checked.length > 0)
												  livelloSkill=checked.val();
											  skills.push({skill: nomeSkill,value:livelloSkill});
										});
										
										$("#softskill_table").find('tr').each(function(){
											tr=$(this);
											var valueSkill=tr.first('td').text().trim();
											softSkills.push({softskill:valueSkill});
										});
										
										$(".lingua").each(function() {
											  lingua=$(this);
											  var nameLanguage=lingua.attr('name');
											  var valueLanguage = lingua.val();
											  lingue.push({lang: nameLanguage,value:valueLanguage});
										});
										
										console.log(JSON.stringify(skills),JSON.stringify(softSkills),JSON.stringify(lingue));
										
										if (nome != undefined
												&& cognome != undefined
												&& datanascita != undefined
												&& email != undefined
												&& telefono != undefined 
												&& skills.length>0) {
											
											$(".preloader").show();
											$.ajax({
														url : absolutePath
																+ "/ServletFormOU",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"nome" : nome,
															"cognome" : cognome,
															"datanascita" : datanascita,
															"email" : email,
															"telefono" : telefono,
															"skills" : skills,
															"softSkills" : softSkills,
															"lingue" : lingue
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
									});
					$("#aggiungiSkill").click(function() {
						skill = $("#nomeSkill").val();
						$("#nomeSkill").val('');
						content="<tr class=\"skills\"><td data-skill=\"" + skill + "\">" + skill + "</td><fieldset id="+skill+">" +
						"<td><input type=\"radio\" name="+skill+" value=\"basso\"></td>" + 
							"<td><input type=\"radio\" name="+skill+" value=\"medio\"></td>" +
								"<td><input type=\"radio\" name="+skill+" value=\"alto\"></td> </fieldset> </tr>";
						$("#skill_table").append(content);
						
						$("tr.skills").each(function() {
						  tr=$(this);
						  value=tr.first('td').data("skill");
						  checked = tr.find("input[type='radio']:checked");
						  if (checked.length > 0)
							  value+=checked.val();
						  else
							  value+="Nessun valore";
						 
								
						  showAlert(0,value);
						});


					   
					});
					
					$("#aggiungiSoftSkill").click(function() {
						softskill = $("#nomeSoftSkill").val();
						$("#nomeSoftSkill").val('');
						content="<tr class=\"softskills\"><td data-softskill=\""+softskill+"\">"+softskill+"</td></tr>";
						$("#softskill_table").append(content);
						
						$("#softskill_table").find('tr').each(function(){
							value=$(this).first('td').text();
							showAlert(0,value);
						});
					});

				});

