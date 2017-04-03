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
	
	function passageCommande() {
		
		var course = {};
		
		//  idClient 
		course.client.idUtil = document.getElementById("idClient").value;
		
		// idConducteur
		course.conducteur.idUtil = document.getElementById("idConducteur").value;	
		
		course.lieuDepart =  document.getElementById('inputDepart').value;
		course.lieuArrivee = document.getElementById('inputDestination').value;

		// latitude et longitude de depart (client) et de destination (conducteur)
		course.posDepartLat = document.getElementById("posClientLat").value;
	    course.posDepartLong =  document.getElementById("posClientLong").value;
	    course.posArretLat = document.getElementById("posActuelleLat").value;
	    course.posArretLong = document.getElementById("posActuelleLong").value;
	    
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
	
	$('#submitProfilClient').on('click', modifProfilClient);
	$('#btncommande').on('click', passageCommande);
	$('#submitCommande').on('click', passageCommande);
});


