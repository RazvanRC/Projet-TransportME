/**
 * 
 */

$jq311(document).ready(function($) {
	// Code that uses jQuery's $ can follow here.
	$("#divClient").hide();
	$("#divConducteur").hide();

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
	
	$("#mySelect").on('change', function() {
		
		console.log($("#mySelect").val());
		if ($("#mySelect").val() == "conducteur") {
			$("#divConducteur").show();
			$("#divClient").hide();

		    disponibilite();	
		} else if ($("#mySelect").val() == "client") {
			$("#divConducteur").hide();
			$("#divClient").show();

		} else {
			$("#divConducteur").hide();
			$("#divClient").hide();

		}
	});
});
