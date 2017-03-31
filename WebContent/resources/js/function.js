/**
 * 
 */
$("#divClient").hide();
$("#divConducteur").hide();


function myFunction() {
	console.log($("#mySelect").val());
 if ($("#mySelect").val() == "conducteur")
	 {
	 $("#divConducteur").show();
	 $("#divClient").hide();
	 
	 disponibilite();

	 }
 else
	 if ($("#mySelect").val() == "client")
		 {
		 $("#divConducteur").hide();
		 $("#divClient").show();

		 }
	 else
		 {
		 $("#divConducteur").hide();
		 $("#divClient").hide();
		 
		 }
}