<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<html>
  <head>

   <title>Place Autocomplete</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">

  </head>
  <body>
    <input id="pac-input" class="controls" type="text"
        placeholder="Enter a location">
   
    <div id="map"></div>

    <script>

    function initMap() {
    	  var map = new google.maps.Map(document.getElementById('map'), {
    	    center: {lat: 50.632492, lng: 3.069908}, 
    	    zoom: 15
    	  });
    	  var infoWindow = new google.maps.InfoWindow({map: map});

    	  // Try HTML5 geolocation.
    	  if (navigator.geolocation) {
    	    navigator.geolocation.getCurrentPosition(function(position) {
    	      var pos = {
    	        lat: position.coords.latitude,
    	        lng: position.coords.longitude
    	      };

    	      infoWindow.setPosition(pos);
    	      infoWindow.setContent('Location found.' + 'lat:=' + pos.lat + '  long:=' + pos.lng );
    	      map.setCenter(pos);
    	    }, function() {
    	      handleLocationError(true, infoWindow, map.getCenter());
    	    });
    	  } else {
    	    // Browser doesn't support Geolocation
    	    handleLocationError(false, infoWindow, map.getCenter());
    	  }

    	  function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    		  infoWindow.setPosition(pos);
    		  infoWindow.setContent(browserHasGeolocation ?
    		                        'Error: The Geolocation service failed.' :
    		                        'Error: Your browser doesn\'t support geolocation.');
    		}
  
  
  
  
  
  var input = /** @type {!HTMLInputElement} */(
      document.getElementById('pac-input'));

  var types = document.getElementById('type-selector');
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(types);

  var autocomplete = new google.maps.places.Autocomplete(input);
  autocomplete.bindTo('bounds', map);

  var infowindow = new google.maps.InfoWindow();
  var marker = new google.maps.Marker({
    map: map,
    anchorPoint: new google.maps.Point(0, -29)
  });

  autocomplete.addListener('place_changed', function() {
    infowindow.close();
    marker.setVisible(false);
    var place = autocomplete.getPlace();
    if (!place.geometry) {
      window.alert("Autocomplete's returned place contains no geometry");
      return;
    }

    // If the place has a geometry, then present it on a map.
    if (place.geometry.viewport) {
      map.fitBounds(place.geometry.viewport);
    } else {
      map.setCenter(place.geometry.location);
      map.setZoom(17);  // Why 17? Because it looks good.
    }
    marker.setIcon(/** @type {google.maps.Icon} */({
      url: place.icon,
      size: new google.maps.Size(71, 71),
      origin: new google.maps.Point(0, 0),
      anchor: new google.maps.Point(17, 34),
      scaledSize: new google.maps.Size(35, 35)
    }));
    marker.setPosition(place.geometry.location);
    marker.setVisible(true);

    var address = '';
    if (place.address_components) {
      address = [
        (place.address_components[0] && place.address_components[0].short_name || ''),
        (place.address_components[1] && place.address_components[1].short_name || ''),
        (place.address_components[2] && place.address_components[2].short_name || '')
      ].join(' ');
    }

    infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
    infowindow.open(map, marker);
  });

  // Sets a listener on a radio button to change the filter type on Places
  // Autocomplete.
  function setupClickListener(id, types) {
    var radioButton = document.getElementById(id);
    
  }


}

    </script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCMS6cNPjMWn-Q9uT2f5q_4T2aIrZx9H8&libraries=places&callback=initMap"
  async defer></script>



  
