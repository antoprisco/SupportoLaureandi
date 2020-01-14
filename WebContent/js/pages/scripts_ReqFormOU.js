$(document).ready(
				function() {
					$(document)
							.on(
									'submit',
									'#FormOU',
									function(e) {
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
											  if(nomeSkill != undefined) {
												  var checked = tr.find("input[type='radio']:checked");
												  if (checked.length > 0) {
													  livelloSkill=checked.val();
												  	  skills.push({skill: nomeSkill,value:livelloSkill});
												  } 
											  }	  
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
										
										
										if (nome != undefined
												&& cognome != undefined
												&& datanascita != undefined
												&& email != undefined
												&& telefono != undefined) {

											$(".preloader").show();
											$.ajax({
														url : absolutePath + "/ServletFormOU",
														type : "POST",
														dataType : 'JSON',
														async : false,
														data : {
															"nome" : nome,
															"cognome" : cognome,
															"datanascita" : datanascita,
															"email" : email,
															"telefono" : telefono,
															"skills" : JSON.stringify(skills),
															"softSkills" : JSON.stringify(softSkills),
															"lingue" : JSON.stringify(lingue),
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
						l=skill.length;
						$("#nomeSkill").val('');
						var contatore= 1;
						
							
							$("tr.skills").each(function() {
								content="";
								  tr=$(this);
								  var SkillEsistente=tr.first(skill).text().trim();
								  console.log(skill,contatore);
								  if(SkillEsistente!=skill  && skill!= undefined && l >= 1 && l <= 20){
									  contatore= contatore *1;
									  
								  }else{
									   contatore = contatore *0;
									  showAlert(1, "La skill è già presente o il formato non è corretto")
									  
								  }
								  
									  
							}); 
							
							if (contatore == 1){
								 console.log(skill,contatore);
								 content="<tr class=\"skills pl-2\"><td data-skill=\"" + skill + "\">" + skill + "</td>" +
								  "<fieldset id="+skill+">" +
								  "<td><input type=\"radio\" class=\"pl-2\" name="+skill+" value=\"basso\"></td>" + 
								  "<td><input type=\"radio\" class=\"pl-2\" name="+skill+" value=\"medio\"></td>" +
								  "<td><input type=\"radio\" class=\"pl-2\" name="+skill+" value=\"alto\"></td> " +
								  "</fieldset> </tr>";
								 $("#skill_table").append(content);
							  	  showAlert(0,skill+" inserito");
							 }
							
				

					   
					});
					
					$("#aggiungiSoftSkill").click(function() {
						content="";
						softskill = $("#nomeSoftSkill").val();
						lss= softskill.length;
						$("#nomeSoftSkill").val('');
						var contatoress= 1;
						
						
						$("#softskill_table").find('tr').each(function(){
							tr=$(this);
							var SoftSkillEsistente=tr.first(softskill).text().trim();
							
							if(SoftSkillEsistente!=softskill && softskill!= undefined && lss >= 3 && lss <= 25 )
								contatoress= contatoress *1;
							else{
								contatoress=contatoress*0;
								showAlert(1, "La Soft-Skill è già presente o il formato non è corretto")
							}
						});
						
						if(contatoress==1){
							content="<tr class=\"softskills\"><td class=\"pl-2\" data-softskill=\""+softskill+"\">"+softskill+"</td></tr>";
							$("#softskill_table").append(content);
							showAlert(0,softskill+" inserito");
							
						}
						
						
						
						
						
						/*$("softskill_table").each(function(){
							tr=$(this);
							value=tr.first('td').text().trim();
						showAlert(0,softskill+" inserito");
						});*/
					});

				});