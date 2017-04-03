<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="presentation">
	<h3 class="titre">  Profil Client
	</h3>
	<br>
	<br>

	<fieldset>
		<div class="inscription">
			<div id="divprofilclient">
				<form:form id="commande" action="commande" >

					<input type="hidden" id="idUtil" name="idUtil" value="${ client.idUtil }"><br> <br>
					
					<label for="loginUtil"> Votre Login: </label> 
					<input type="text" id="loginUtil" name="loginUtil" value="${ client.loginUtil }"><br> <br> 				
					
					<label for="mdpUtil">Votre mot de passe: </label> 
					<input type="password" id="mdpUtil" name="mdpUtil" value="${ client.mdpUtil }"><br> <br> 
					
					<label for="nomUtil">Votre Nom de famille: </label> 
					<input type="text" id="nomUtil" name="nomUtil" value="${ client.nomUtil }"><br> <br> 
					
					<label for="prenomUtil">Votre prénom: </label> 
					<input type="text" id="prenomUtil" name="prenomUtil" value="${ client.prenomUtil }"><br><br> 
					
					<label for="dateNaissanceUtil">Votre date de naissance: </label> 
					<input type="text" id="dateNaissanceUtil" name="dateNaissanceUtil" value="${ client.dateNaissanceUtil }"><br><br> 
					
					<label for="telephoneUtil">Téléphone: </label> 
					<input type="text" id="telephoneUtil" name="telephoneUtil" value="${ client.telephoneUtil }"><br> <br> 
					
					<label for="emailUtil">Votre e-mail: </label> 
					<input type="email" id="emailUtil" name="emailUtil" value="${ client.emailUtil }"><br> <br>
					
					<label for="noCBCli">Numéro de la carte bancaire: </label> 
					<input type="text" id="noCBCli" name="noCBCli" value="${ client.noCBCli }"><br> <br>
					 
					<label for="dateExpirationCli">Date d'Expiration CB: </label> 
					<input type="text" id="dateExpirationCli" name="dateExpirationCli" value="${ client.dateExpirationCli }"><br> <br>
					
					<label for="cryptogrammeCli">Cryptogramme: </label> 
					<input type="text" id="cryptogrammeCli" name="cryptogrammeCli" value="${ client.cryptogrammeCli }"><br> <br>
					
					<br> <br> <br>

					<div class="inputLogin">
								<div class="reset">
<!-- 									<button id="reset" -->
<!-- 										class="btn waves-effect waves-light orange darken-4" type="reset" -->
<!-- 										onclick="location.href='commande'" -->
<!-- 										name="Réinitialiser"> -->
<!-- 										Commander  <i class="material-icons right">send</i> -->
<!-- 									</button> -->
									<button id="subcommande"
									class="btn waves-effect waves-light orange darken-4"
									type="submit"  name="Envoyer">
									Commander <i class="material-icons right">send</i>
								</button>
								</div>
					</div>
					<div id="messageAction"></div>
				</form:form>				
			</div>
			<div class="reset">
						<div class="btnLogin">
							<button id="submitProfilClient"
								class="btn waves-effect waves-light orange darken-4"
								type="submit" name="Envoyer">
								Modification <i class="material-icons right">send</i>
							</button>
						</div>
			</div>
			
	<!-- 			<div class="comment"> -->
	<!-- 				<div class="btnLogin"> -->
	<!-- 					<button id="comment" -->
	<!-- 						class="btn waves-effect waves-light orange darken-4" type="submit" -->
	<!-- 						name="Envoyer"> -->
	<!-- 						Commentaires <i class="material-icons right">send</i> -->
	<!-- 					</button> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
				
		</div>
		<br>

	</fieldset>
</div>

<script src="${ pageContext.request.contextPath }/resources/js/methodesClient.js"></script>


