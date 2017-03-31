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
	
	$('#submitProfilClient').on('click', modifProfilClient);
	
});

