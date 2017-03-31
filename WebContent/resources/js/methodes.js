$jq311(document).ready(function($) {
	
	function modifProfilClient() {
		
		var client = {};
		
		client.idUtil = $("input[name='idUtil']").val();
		client.nomUtil = $("input[name='nomUtil']").val();
		client.prenomUtil = $("input[name='prenomUtil']").val();
		client.loginUtil = $("input[name='loginUtil']").val();
		client.mdpUtil = $("input[name='mdpUtil']").val();
		client.dateNaissanceUtil = $("input[name='dateNaissanceUtil']").val();
		client.telephoneUtil = $("input[name='telephoneUtil']").val();
		client.emailUtil = $("input[name='emailUtil']").val();
		client.noCBCli = $("input[name='noCBCli']").val();
		client.dateExpirationCli = $("input[name='dateExpirationCli']").val();
		client.cryptogrammeCli = $("input[name='cryptogrammeCli']").val();
		
		
		$.ajax({
			
				method: 'PUT',
				dataType: 'json',
				contentType: 'application/json',
				url: 'http://localhost:8080/TransportME/api/clients/' + client.idUtil,
				data: JSON.stringify(client),
				success: function() {
					$("#messageAction").html("Modification effectuée.");
				},
				error: function() {
					$("#messageAction").html("La modification a echouée.");
				}
		});
	}
	
	
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
	
	function disponibilite() {
		
		
		statut = $("input[name='statut']").val();
		console.log(statut);
		if(statut == "false") {
			$('#indisponible').prop("checked", true);
		}
		else {
			$('#disponible').prop("checked", true);
			
		}
	}	
	
	function passageCommande() {
		
		var course = {};
		// TODO en cours
		course.idClient = $("input[name='idUtil']").val();	
		
		$.ajax({
			
				method: 'POST',
				dataType: 'json',
				contentType: 'application/json',
				url: 'http://localhost:8080/TransportME/api/courses',
				data: JSON.stringify(course),
				success: function() {
					$("#messageAction").html("Le passage de la commande est effectué.");
				},
				error: function() {
					$("#messageAction").html("Le passage de la commande a echoué.");
				}
		});
	}

});

