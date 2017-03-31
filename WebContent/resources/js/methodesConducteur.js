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
		
		if ($('#indisponible').prop("checked") == true)
			conducteur.statut = false;
		else
			conducteur.statut = true;
		
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contentType: 'application/json',
				url: 'http://localhost:8080/TransportME/api/conducteurs/' + conducteur.idUtil,
				data: JSON.stringify(conducteur),
				success: function() {
					$("#messageAction").html("Modification effectuée.");
				},
				error: function() {
					$("#messageAction").html("La modification a echouée.")
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
// TODO à faire
	}
	
	function modifStatutRefus() {
		// TODO à faire
			}
	
	$('#submitDemarrerCourse').on('click', demarrerCourse);
	$('#submitTerminerCourse').on('click', terminerCourse);
	$('#submitModifProfilConducteur').on('click', modifProfilConducteur);
	$('#submitAcceptation').on('click', modifStatutAccept);
	$('#submitRefus').on('click', modifStatutRefus);
});


