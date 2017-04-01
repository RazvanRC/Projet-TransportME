var map;
var panel;
var initialize;
var calculate;
var direction;
var autocompleteDepart;
var autocompleteDestination;

var initMap;

$jq311(document).ready(function($) {

	initMap = function() {

		$('#btncommande').hide();
		
		map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 50.632492,
				lng : 3.069908
			},
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.ROADMAP
	
		});
		
		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow
					.setContent(browserHasGeolocation ? 'Error: The Geolocation service failed.'
							: 'Error: Your browser doesn\'t support geolocation.');
		}
	
		function RefreshDisponibilitesConducteurs(lat, lng) {
	
			//return function() {
				$.ajax({
							//url : 'api/conducteurs/disponibilites?lat=50.6079121&lng=3.1672095', 	
							url : 'api/conducteurs/disponibilites?lat='+lat+'&lng='+lng, 	
							error : function(request, error) {
								console.log(request);
							},
							dataType : "json",
							success : function(data) {
								$.each(
												data,
												function(i, item) {
													console.log(item);
													var image = {
														url : 'resources/images/voitureS4.png',
													// This marker is 20 pixels wide by 32 pixels high.
													//size: new google.maps.Size(64, 64)
													// The origin for this image is (0, 0).
													//origin: new google.maps.Point(0, 0),
													// The anchor for this image is the base of the flagpole at (0, 32).
													//anchor: new google.maps.Point(0, 32)
													};
	
													marker = new google.maps.Marker(
															{
																position : new google.maps.LatLng(
																		item.posActuelleLat,
																		item.posActuelleLong),
																map : map,
																icon : image
															});
	
													google.maps.event
															.addListener(
																	marker,
																	'click',
																	(function(
																			marker,
																			i) {
																		return function() {
																			
																			//$('#btncommande').show();
																			
																			var infoWindow = new google.maps.InfoWindow(
																					{
																						map : map
																					});
																			
																			var contentInfo = '<img height="100" width="200" src="resources/images/' + item.modeleVoiture.toLowerCase() + '.jpg" />'
																			    + '<br />Conducteur : ' + item.nomUtil + ' ' + item.prenomUtil
																				+ '<br />'
																				+ 'Marque Voiture : ' + item.marqueVoiture
																				+ '<br />'
																				+ 'Modele Voiture : ' + item.modeleVoiture
																				+ '<br />'
																				+ 'Nb Max de passagers : ' + item.nbrPassagers
																				+ '<br />'
																				+ '<div class="btncommande">'
																				+ '<button id="btncommande"'
																				+ '	class="btn waves-effect waves-light orange darken-4" type="submit"'
																				+ '	onclick="passageCommande()" '
																				+ ' name="PassageCommande">'
																				+ '	Passage Commande <i class="material-icons right">send</i>'
																				+ '</button>'
																				+ '</div>';
																			
																			// ajout SD	
																			$('#infoConducteur').html(contentInfo);  																		
																			// memorisation idConducteur sélectionné
																			document.getElementById("idConducteur").value=item.idUtil;
																			document.getElementById("posActuelleLat").value=item.posActuelleLat;
																			document.getElementById("posActuelleLong").value=item.posActuelleLong;
																			// fin ajout SD	
																			
																			// Affichage de la légende de chaque lieu
																			infowindow
																					.setContent(contentInfo)
	
																			infowindow
																					.open(
																							map,
																							marker);
																		}
																	})(marker, i));
	
												})
	
							}
						});
	
			//}
		}
		
		
		// Try HTML5 geolocation.
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
					lat : position.coords.latitude,
					lng : position.coords.longitude,
	
				};
	
				$.ajax({
					method : 'GET',
					url : 'http://maps.googleapis.com/maps/api/geocode/json',
					data : {
						latlng : pos.lat + "," + pos.lng,
						sensor : 'true'
					},
					success : function(data) {
						
						var marker = new google.maps.Marker({
							position : new google.maps.LatLng(pos.lat, pos.lng),
							map : map
						});
	
						var contenuInfoBulle = 'Votre position est: ' + 'lat:='
								+ pos.lat + '  long:=' + pos.lng
								+ ' \n et votre adresse est: '
								+ data.results[0].formatted_address;
						
						var infoBulle = new google.maps.InfoWindow({
							content : contenuInfoBulle
						})
							
						
						var closure = function () {
							google.maps.event.addListener(marker, 'click', function() {
								//infoBulle.open(map, marker);							
								$('#inputDepart').val(data.results[0].formatted_address);
								//autocompleteDepart.set("place", data.results[0].formatted_address);
								
								//google.maps.event.trigger(autocompleteDepart, 'place_changed');
							});
						}();
	
						console.log(data.results[0].formatted_address + "xyz");
						console.log("inputDepart "+$('#inputDepart').val());
	
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
	
		//On cache l'input de destination
		$('#inputDestination').hide();
		
		var inputDepart = document.getElementById('inputDepart');
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(inputDepart);
		autocompleteDepart = new google.maps.places.Autocomplete(inputDepart);
		autocompleteDepart.bindTo('bounds', map);
	
		var inputDestination = document.getElementById('inputDestination');
		map.controls[google.maps.ControlPosition.TOP_RIGHT].push(inputDestination);	
		autocompleteDestination = new google.maps.places.Autocomplete(inputDestination);
		autocompleteDestination.bindTo('bounds', map);
	
		var types = document.getElementById('type-selector');
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(types);
	
		var infowindow = new google.maps.InfoWindow();
		var marker = new google.maps.Marker({
			map : map,
			anchorPoint : new google.maps.Point(0, -29)
		});
	
		autocompleteDepart.addListener('place_changed', function() {
			infowindow.close();
			marker.setVisible(false);
			var place = autocompleteDepart.getPlace();
			if (!place.geometry) {
				//On rend visible l'input de destination
				$('#inputDestination').hide();
	
				window.alert("Autocomplete's returned place contains no geometry");
				return;
			}
	
			//On rend visible l'input de destination
			$('#inputDestination').show();
			
	
			// If the place has a geometry, then present it on a map.
			if (place.geometry.viewport) {
				map.fitBounds(place.geometry.viewport);
			} else {
				map.setCenter(place.geometry.location);
				map.setZoom(17); // Why 17? Because it looks good.
			}
			marker.setIcon(/** @type {google.maps.Icon} */
			({
				url : place.icon,
				size : new google.maps.Size(71, 71),
				origin : new google.maps.Point(0, 0),
				anchor : new google.maps.Point(17, 34),
				scaledSize : new google.maps.Size(35, 35)
			}));
			marker.setPosition(place.geometry.location);
			marker.setVisible(true);
	
			var address = '';
			if (place.address_components) {
				address = [
						(place.address_components[0]
								&& place.address_components[0].short_name || ''),
						(place.address_components[1]
								&& place.address_components[1].short_name || ''),
						(place.address_components[2]
								&& place.address_components[2].short_name || '') ]
						.join(' ');
			}
	
			infowindow.setContent('<div><strong>' + place.name + '</strong><br>'
					+ address);
			infowindow.open(map, marker);
		});
	
	
		autocompleteDestination.addListener('place_changed', function() {
			
			var place = autocompleteDepart.getPlace();
			if (!place.geometry) {
				window.alert("Autocomplete's returned place contains no geometry");
				return;
			}
			
			var direction = new google.maps.DirectionsRenderer({
			    map   : map//,
			    //panel : panel // Dom element pour afficher les instructions d'itinÃƒÂ©raire
	
			});
			
		    origin   = document.getElementById('inputDepart').value; // Le point dÃƒÂ©part
		    destination = document.getElementById('inputDestination').value; // Le point d'arrivÃƒÂ©
			console.log("SD origin "+origin);
			console.log("SD destination "+destination);
		    if(origin && destination){
		        var request = {
		            origin      : origin,
		            destination : destination,
		            travelMode  : google.maps.DirectionsTravelMode.DRIVING // Mode de conduite
		        }
		        var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinÃƒÂ©raire
		        directionsService.route(request, function(response, status){ // Envoie de la requÃƒÂªte pour calculer le parcours
		          //console.log(response);
		            if(status == google.maps.DirectionsStatus.OK){
		                direction.setDirections(response); // Trace l'itinÃƒÂ©raire sur la carte et les diffÃƒÂ©rentes ÃƒÂ©tapes du parcours
		            }
		        });
		    }
			document.getElementById("posClientLat").value=place.geometry.location.lat();
			document.getElementById("posClientLong").value=place.geometry.location.lng();
		    RefreshDisponibilitesConducteurs(place.geometry.location.lat(), place.geometry.location.lng());
			//refresh des disponibilités toute les 3 secondes          TODO
			//setInterval(RefreshDisponibilitesConducteurs(), 3000);
	
		});
		
		// Sets a listener on a radio button to change the filter type on Places
		// Autocomplete
		function setupClickListener(id, types) {
			var radioButton = document.getElementById(id);
	
		}
	}
	
	$( "body" ).append('<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCMS6cNPjMWn-Q9uT2f5q_4T2aIrZx9H8&libraries=places&callback=initMap" async defer></script>');
});




