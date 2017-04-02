/**
 * 
 */

$jq311(document).ready(function($) {

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
	
});
