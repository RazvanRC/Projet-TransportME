$jq311(document).ready(function($) {
	$.ajax({
		  url   : 'http://localhost:8080/TransportME/api/conducteurs/disponibilites?lat=50.6079121&lng=3.1672095',
		  error : function(request, error) { // Info Debuggage si erreur         
			  		alert("Erreur sous genre - responseText: "+request.responseText);
		          },                
		   dataType : "json",  
		   success  : function(data){
		                console.log(data[0].posActuelleLat + " "+ data[0].posActuelleLong);
	                	console.log(data[1].posActuelleLat + " "+ data[1].posActuelleLong);
	                	$.each(data.items, function(i,item){
	                		console.log(item);
		    }
		    
		 )}
	               });
});