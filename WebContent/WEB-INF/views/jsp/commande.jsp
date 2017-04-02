<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script src="${ pageContext.request.contextPath }/resources/js/methodesClient.js"></script>

<input id="inputDepart" name="origin" class="controls" type="text" placeholder="Entrer un départ">
<input id="inputDestination" name ="destination" class="controls" type="text" placeholder="Entrer une destination">

<div id="map"></div>
<!-- <input type="button" value="Calculer l'itinéraire" onclick="javascript:calculate()"> -->

<input type="hidden" id="idClient" name="idClient" value="${client.idUtil }">
<input type="hidden" id="idConducteur" name="idConducteur" >
<input type="hidden" id="posActuelleLat" name="posActuelleLat" >
<input type="hidden" id="posActuelleLong" name="posActuelleLong" >
<input type="hidden" id="posClientLat" name="posClientLat" >
<input type="hidden" id="posClientLong" name="posClientLong" >


  <div id="panel"></div>
        <div id="map"></div>


 <div id="infoConducteur"></div>
 
 <div class="commande">
	<div class="btncommande2">
		<button id="submitCommande"
			class="btn waves-effect waves-light orange darken-4" type="submit"
			name="commande">
			Passage commande <i class="material-icons right">send</i>
		</button>
	</div>
</div>

	






<div id="messageAction"></div>
<script src="${ pageContext.request.contextPath }/resources/js/commande.js"></script>









