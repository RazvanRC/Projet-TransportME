var initMap;

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
							url : 'http://localhost:8080/TransportME/api/courses/'+idCourse+'/recuperer',   
							error : function(request, error) {
								console.log("pbe recherchePosClient - responseText: "
										+ request.responseText);
							},
							dataType : "json",
							success : function(data) {
													var image = {
														url : 'resources/images/client.png',   
													};
	
													marker = new google.maps.Marker(
															{
																// TODO latitude et longitude en dur du client
														
																position : new google.maps.LatLng(
																		50.605678999999995 ,//data.posDepartLat,
																		3.1521624),	//data.posDepartLong),
																map : map,
																icon : image
															});
	
													google.maps.event
															.addListener(
																	marker,
																	'click',
																	(function(
																			marker 
																			) {
																			var infoWindow = new google.maps.InfoWindow(
																					{
																						map : map
																					});
																			
																			var contentInfo = 'Passager : '
																				+ data.nomUtil;
																			
																			var contentClient = 	
																					"<input type='hidden' id='courseId' value='"+data.idcourse+"'>";
																			
																			$('#infoClient').html(contentClient);
																			
																			// Affichage de la légende de chaque lieu
																			infowindow
																					.setContent(contentInfo)
	
																			infowindow
																					.open(
																							map,
																							marker);
																		
																	})(marker));
	
	
							}
						});
	
		}
		CoursesAttribuees();
		//refresh des disponibilités toute les 3 secondes
		////////////setInterval(CoursesAttribuees(), 30000);  // TODO a modifier
	
		// Try HTML5 geolocation.
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
						// TODO coordonnées en dur du conducteur
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
