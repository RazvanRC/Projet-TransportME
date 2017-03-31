<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<input id="pac-input" class="controls" type="text" placeholder="Enter a location">

<div id="map"></div>

<input id="pac-input2" class="controls" type="text" placeholder="Enter a location destination">

<div class="commandecourse">
	<div class="btnLogin">
		<button id="submit"
			class="btn waves-effect waves-light orange darken-4" type="submit"
			onclick="passageCommande()" name="PassageCommande">
			Passage Commande <i class="material-icons right">send</i>
		</button>
	</div>
</div>
<div id="infoConducteur"></div>

<div id="messageAction"></div>

<script src="${ pageContext.request.contextPath }/resources/js/commande.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/methodes.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCCMS6cNPjMWn-Q9uT2f5q_4T2aIrZx9H8&libraries=places&callback=initMap"></script>







