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