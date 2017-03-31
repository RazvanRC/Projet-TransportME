<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!--  <input id="pac-input" class="controls" type="text" placeholder="Enter a location">-->

<div id="map"></div>

<!-- <input id="pac-input2" class="controls" type="text" placeholder="Enter a location destination"> -->

<div class="demarrercourse">
	<div class="btnLogin">
		<button id="submit"
			class="btn waves-effect waves-light orange darken-4" type="submit"
			onclick="demarrerCourse()" name="Demarrer Course">
			Démarrer course <i class="material-icons right">send</i>
		</button>
	</div>
</div>

<div class="terminercourse">
	<div class="btnLogin">
		<button id="submit"
			class="btn waves-effect waves-light orange darken-4" type="submit"
			onclick="terminerCourse()" name="Terminer Course">
			Terminer course <i class="material-icons right">send</i>
		</button>
	</div>
</div>

<div id="infoConducteur"></div>

<div id="messageAction"></div>

<input type="hidden" id="idConducteur" name="idConducteur" value="${ conducteur.idUtil }"><br> <br>

<script src="${ pageContext.request.contextPath }/resources/js/dispo.js"></script>
<script src="${ pageContext.request.contextPath }/resources/js/methodes.js"></script>








