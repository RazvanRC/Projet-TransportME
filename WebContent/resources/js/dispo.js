var initMap;
var idIntervalDispo = false;

$jq311(document).ready(function($) {

	initMap = function() {

		var map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 50.632492,
				lng : 3.069908
			},
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
	
		});
	
		
		function RecherchePosClient(idCourse) {
	
			//return function() {
			console.log("idCourse "+idCourse);
				$.ajax({
							url : 'api/courses/'+idCourse+'/recuperer',   
							error : function(request, error) {
								console.log("pbe recherchePosClient - responseText: "
										+ request.responseText);
							},
							dataType : "json",
							success : function(data) {
								
								// si on veut stopper le timer, on decommente ce code
//								if(data.length > 0 && idIntervalDispo) {
//									clearInterval(idIntervalDispo);
//									idIntervalDispo = false;
//									console.log("STOP TIMER REFRESH DISPO")
//								}
								
													//On cache les boutons 
													if (data != null)
													$('#demarrercourse').show();
													$('#terminercourse').show();
													$('#acceptation').show();
													$('#refus').show();
													
													var image = {
														url : 'resources/images/client.png',   
													};
	
													marker = new google.maps.Marker(
															{
																position : new google.maps.LatLng(
																		data.posDepartLat, //50.605678999999995 ,
																		data.posDepartLong), // 3.1521624),	
																map : map,
																icon : image
															});
	
													(function(marker) {
															var infoWindow = new google.maps.InfoWindow(
																	{
																		map : map
																	});
															

															
															
															var contentInfo =  "<input type='hidden' id='courseId' value='"+data.idcourse+"'>"
															+ "<h4> Passager: "+ data.client.prenomUtil+" "+data.client.nomUtil+"</h4>"
															+ "<h4> Départ: "+ data.lieuDepart+"</h4>"
															+ "<h4> Destination: "+ data.lieuArrivee+"</h4>"
															+ '<div class="btnAcceptation">'
															+	'<button id="submitAcceptation"'
															+	'	class="btn waves-effect waves-light orange darken-4" type="submit"'
															+ '		name="acceptation">'
															+	'	Acceptation <i class="material-icons right">send</i>'
															+	'</button>'
															+'</div>'	
															
															+	'<div class="refus">'
															+	'<div class="btnRefus">'
															+	'	<button id="submitRefus"'
															+	'		class="btn waves-effect waves-light orange darken-4" type="submit"'
															+	'		name="refus">'
															+	'		Refus <i class="material-icons right">send</i>'
															+	'	</button>'
															+	'</div>'
															+	'</div>'
															
															+	'<div class="demarrercourse">'
															+	'<div class="btnDemarrercourse">'
															+	'	<button id="submitDemarrerCourse"'
															+	'		class="btn waves-effect waves-light orange darken-4" type="submit"'
															+	'		name="Demarrer Course">'
															+	'		Démarrer course <i class="material-icons right">send</i>'
															+	'	</button>'
															+	'</div>'
															+	'</div>'

															+	'<div class="terminercourse">'
															+	'<div class="btnTerminercourse">'
															+	'	<button id="submitTerminerCourse"'
															+	'		class="btn waves-effect waves-light orange darken-4" type="submit"'
															+	'		name="Terminer Course">'
															+	'		Terminer course <i class="material-icons right">send</i>'
															+	'	</button>'
															+	'</div>'
															+	'</div>'
															;
															
															
															
															
															// Affichage de la légende de chaque lieu
															infowindow.setContent(contentInfo);

															google.maps.event.addListener(infowindow,'domready', function() {
																//contentElement dom element manipulations, such as:
																
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
																$('#submitAcceptation').on('click', modifStatutAccept);
																
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
																
																$('#submitRefus').on('click', modifStatutRefus);
																
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
																
																$('#submitDemarrerCourse').on('click', demarrerCourse);

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
																
																$('#submitTerminerCourse').on('click', terminerCourse);
															
															});
															
															infowindow.open(map, marker);
																	
															
															
																
													})(marker);
	
							}
						});
	
		}
		
		//On cache les boutons 
		$('#demarrercourse').hide();
		$('#terminercourse').hide();
		$('#acceptation').hide();
		$('#refus').hide();
		
		CoursesAttribuees();
		//refresh des disponibilités toute les 10 secondes          
		idIntervalDispo = setInterval(CoursesAttribuees, 10000);
	
		// Try HTML5 geolocation.
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
						// TODO coordonnées en dur du conducteur a laisser en dur pour l'instant 
					lat : 50.6082, //position.coords.latitude,
					lng :  3.16806 // position.coords.longitude,
				};
				
				$.ajax({
					method : 'GET',
					url : 'http://maps.googleapis.com/maps/api/geocode/json',
					data : {
						latlng : pos.lat + "," + pos.lng,
						sensor : 'true'
					},
					success : function(data) {
	
						
						var image = {
								url : 'resources/images/voitureS4.png'}
						
						var marker = new google.maps.Marker({
							position : new google.maps.LatLng(pos.lat, pos.lng),
							map : map,
							icon : image
						});
	
						var contenuInfoBulle = 'Votre position est: ' + 'lat:='
								+ pos.lat + '  long:=' + pos.lng
								+ ' \n et votre adresse est: '
								+ data.results[0].formatted_address;
	
						var infoBulle = new google.maps.InfoWindow({
							content : contenuInfoBulle
						})
	
						google.maps.event.addListener(marker, 'click', function() {
							infoBulle.open(map, marker);
						});
	
						console.log(data.results[0].formatted_address + "xyz");
	
						map.setCenter(pos);
	
					}
	
				});
			}, function() {
				handleLocationError(true, infoWindow, map.getCenter());
			});
	
		} else {
			// Browser doesn't support Geolocation
			handleLocationError(false, infoWindow, map.getCenter());
		}
	
		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow
					.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
							: 'Error: Your browser doesn\'t support geolocation.');
		}
	
	
		var infowindow = new google.maps.InfoWindow();
		var marker = new google.maps.Marker({
			map : map,
			anchorPoint : new google.maps.Point(0, -29)
		});
	
	
	
		// Sets a listener on a radio button to change the filter type on Places
		// Autocomplete.
		function setupClickListener(id, types) {
			var radioButton = document.getElementById(id);
	
		}
		
		function CoursesAttribuees() {
				
				var course = {};
				course.idConducteur = $("input[name='idConducteur']").val();   
				
				$.ajax({
							url : 'api/courses/recuperer?idConducteur='+course.idConducteur,  
							error : function(request, error) {
								console.log("Erreur dans courses attribuees - responseText: "
										+ request.responseText);
								document.getElementById("messageAction").value="aucune course attribuee";
							},
							dataType : "json",
							success : function(data) {
								console.log("dans appel ajax de recherchePosClient, data.idCourse= "+data.idcourse);
								RecherchePosClient(data.idcourse);
	
	
							}
						});
		}
	}
	
	
	$( "body" ).append('<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCMS6cNPjMWn-Q9uT2f5q_4T2aIrZx9H8&libraries=places&callback=initMap" async defer></script>');

});
