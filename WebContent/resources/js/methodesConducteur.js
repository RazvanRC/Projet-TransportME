$jq311(document).ready(function($) {
	
	function modifProfilConducteur() {
		
		var conducteur = {};
		
		conducteur.idUtil = $("input[name='idUtil']").val();
		conducteur.nomUtil = $("input[name='nomUtil']").val();
		conducteur.prenomUtil = $("input[name='prenomUtil']").val();
		conducteur.loginUtil = $("input[name='loginUtil']").val();
		conducteur.mdpUtil = $("input[name='mdpUtil']").val();
		conducteur.dateNaissanceUtil = $("input[name='dateNaissanceUtil']").val();
		conducteur.telephoneUtil = $("input[name='telephoneUtil']").val();
		conducteur.emailUtil = $("input[name='emailUtil']").val();
		conducteur.anneePermis = $("input[name='anneePermis']").val();
		conducteur.marqueVoiture = $("input[name='marqueVoiture']").val();
		conducteur.modeleVoiture = $("input[name='modeleVoiture']").val();
		conducteur.nbrPassagers = $("input[name='nbrPassagers']").val();
		conducteur.immatriculation = $("input[name='immatriculation']").val();
		
		if ($('#indisponible').prop("checked") == true) {
			conducteur.statut = false;
		} else {
			conducteur.statut = true;
		}
		
		$("#messageAction").hide();
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contentType: 'application/json',
				url: 'api/conducteurs/' + conducteur.idUtil,
				data: JSON.stringify(conducteur),
				beforeSend: function() {
					$("#messageAction").html("En cours de modification...");
					$("#messageAction").show();
				},
				success: function() {
					$("#messageAction").hide();
					$("#messageAction").html("Modification effectuée.");
					$("#messageAction").show();
					setTimeout(function() {
						$("#messageAction").hide();
					}, 3000);					
				},
				error: function() {
					$("#messageAction").hide();
					$("#messageAction").html("La modification a echouée.");
					$("#messageAction").show();
					setTimeout(function() {
						$("#messageAction").hide();
					}, 3000);	
				}
		})
	}
	
	function demarrerCourse() {
		var course = {};
		course.idCourse =  $("input[id='courseId']").val();	
		console.log("courseId = "+course.idCourse);
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contesponseTextentType: 'application/json',
				url: 'api/courses/'+course.idCourse+'/demarrer',
				data: JSON.stringify(course),
				success: function() {
					$("#messageAction").html("La course est démarrée.");
				},
				error: function() {
					$("#messageAction").html("Echec démarrage course.");
				}
		});
	}

	function terminerCourse() {
		
		var course = {};
		course.idCourse =  $("input[id='courseId']").val();		
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contentType: 'application/json',
				url: 'api/courses/'+course.idCourse+'/terminer',
				data: JSON.stringify(course),
				success: function() {
					$("#messageAction").html("La course est terminée.");
				},
				error: function() {
					$("#messageAction").html("Echec fin de course.");
				}
		});
	}
	
	function modifStatutAccept() {
		var course = {};
		course.idCourse =  $("input[id='courseId']").val();		
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contentType: 'application/json',
				url: 'api/courses/'+course.idCourse+'/accepter',
				data: JSON.stringify(course),
				success: function() {
					$("#messageAction").html("La course a été acceptée.");
				},
				error: function() {
					$("#messageAction").html("Echec acceptation de course.");
				}
		});			
	}
	
	function modifStatutRefus() {
			
			var course = {};
			course.idCourse =  $("input[id='courseId']").val();		
			
			$.ajax({
				
					method: 'PUT',
					dataType: 'json',
					contentType: 'application/json',
					url: 'api/courses/'+course.idCourse+'/refuser',
					data: JSON.stringify(course),
					success: function() {
						$("#messageAction").html("La course a été refusée.");
					},
					error: function() {
						$("#messageAction").html("Echec refus de course.");
					}
			});		
	}
	
	function disponibilite() {
		var statut = $("input[name='statut']").val();
		console.log(statut);
		if(statut == "false") {
			$('#indisponible').prop("checked", true);
		}
		else {
			$('#disponible').prop("checked", true);
			
		}
	}
	
	$('#submitDemarrerCourse').on('click', demarrerCourse);
	$('#submitTerminerCourse').on('click', terminerCourse);
	$('#submitModifProfilConducteur').on('click', modifProfilConducteur);
	$('#submitAcceptation').on('click', modifStatutAccept);
	$('#submitRefus').on('click', modifStatutRefus);
	
	disponibilite();
});


