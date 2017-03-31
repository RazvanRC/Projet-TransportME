<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Contenu principal -->


<div class="presentation">
	<h3 class="titre">L'inscription ne prend que quelques secondes...
	</h3>

	<fieldset>
		<div class="inscription">
			<br> <br> <label for="utilisateur">Utilisateur*: </label> <select
				id="mySelect">
				<option value="">utilisateur</option>
				<option value="client">client</option>
				<option value="conducteur">conducteur</option>
			</select> <br> <br>
		</div>
		<h2 id="demo"></h2>
		<br> <br>
		<div id="divClient">
			<form:form modelAttribute="client" method="post" class="inscription" action="inscription/client">

				<label for="pseudo"> Votre Login*: </label> 
				<input type="text" class="form-text" name="loginUtil" id="loginUtil" required><br><br> 
				
				<label for="mdpUtil">Password*: </label> 
				<input type="password" class="form-password" name="mdpUtil" id="mdpUtil" required><br> <br>
				<form:errors path="mdpUtil" /> 
				
				<label for="verif_password">Confirmation Password*: </label> 
				<input type="password" class="form-password" name="verif_password" id="verif_password" required><br><br>
				<form:errors path="mdpUtil" />  
				
				<label for="nomUtil">Votre Nom de famille:* </label> 
				<input type="text" class="form-text" name="nomUtil" id="nomUtil" required><br><br> 

				<label for="prenomUtil">Votre prénom:* </label> 
				<input type="text" class="form-text" name="prenomUtil" id="prenomUtil" required><br><br> 
				
				<label for="dateNaissanceUtil">Votre date de naissance:* </label> 
				<input type="date" class="form-text" name="dateNaissanceUtil" id="dateNaissanceUtil" required><br><br> 
				
				<label for="telephoneUtil">Téléphone:* </label>  
				<input type="tel" class="form-text" name="telephoneUtil" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" id="telephoneUtil" required><br><br> 
				
				<label for="noCBCli">Numéro de la carte bancaire:* </label> 
				<input type="text" class="form-text" name="noCBCli" maxlength="16" id="noCBCli" required><br> <br> 
				
				<label for="dateExpirationCli">Date d'Expiration CB:* </label> 
				<input type="date" class="form-text" name="dateExpirationCli" id="dateExpirationCli" required value="2017-09-15"><br> <br> 
				
				<label for="cryptogrammeCli">Cryptogramme:* </label> 
				<input type="text" class="form-text" name="cryptogrammeCli" maxlength="3" id="cryptogrammeCli" required><br> <br> 
				
				<label for="emailUtil">Votre e-mail*: </label> 
				<input class="form-text" type="email" name="emailUtil" id="emailUtil" required> <br> <br> <br>
				<div class="inputLogin">
					<div class="reset">
						<button id="reset"
							class="btn waves-effect waves-light orange darken-4" type="reset"
							name="Réinitialiser">
							Réinitialiser <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<div class="reset">
					<div class="btnLogin">
						<button id="submit"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" name="Envoyer">
							Envoyer <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form:form>
		</div>



		
		<div id="divConducteur">
			<form:form modelAttribute="conducteur" method="post" class="inscription" action="inscription/conducteur">
				<label for="pseudo"> Votre Login*: </label> 
				<input type="text" class="form-text" name="loginUtil" id="loginUtil" required><br><br>
				 
				<label for="password">Password*: </label> 
				<input type="password" class="form-password" name="mdpUtil" id="mdpUtil" required> <br> <br> 
				
				<label for="verif_password">Confirmation Password:* </label> 
				<input type="password" class="form-password" name="verif_password" id="verif_password" required><br><br> 
				
				<label for="surname">Votre Nom de famille:* </label> 
				<input type="text" class="form-text" name="nomUtil" id="nomUtil" required><br> <br> 
				
				<label for="name">Votre prénom:* </label> 	
				<input type="text" class="form-text" name="prenomUtil" id="prenomUtil" required><br><br> 
				
				<label for="date_naissance">Votre date de naissance:* </label> 
				<input type="date" class="form-text" name="dateNaissanceUtil" id="dateNaissanceUtil" required><br> <br> 
				
				<label for="name">Téléphone:* </label> 
				<input type="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" size="10" maxlength="10" class="form-text" name="telephoneUtil" id="telephoneUtil" required><br> <br> 
				
				<label for="name">Année Permis de conduire:* </label> 
				<input type="text" class="form-text" name="anneePermis" id="anneePermis" required><br> <br> 
				
				<label for="date_naissance">Marque de voiture:* </label> 
				<input type="text" class="form-text" name="marqueVoiture" id="marqueVoiture" required><br> <br> 
				
				<label for="name">Modele de voiture:* </label> 
				<input type="text" class="form-text" name="modeleVoiture" id="modeleVoiture" required><br> <br> 
				
				<label for="name">Nombre de passagers:* </label> 
				<input type="text" class="form-text" name="nbrPassagers" id="nbrPassagers" required><br> <br> 
				
				<label for="name">Imatriculation:* </label> 
				<input type="text" class="form-text" name="immatriculation" id="immatriculation" required><br> <br> 
				
				<label for="emailUtil">Votre e-mail:* </label> 
				<input class="form-text" type="email" name="emailUtil" id="emailUtil" required> <br> <br>
				
				<br>
				<div class="inputLogin">
					<div class="reset">
						<button id="reset"
							class="btn waves-effect waves-light orange darken-4" type="reset"
							name="Réinitialiser">
							Réinitialiser <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<div class="reset">
					<div class="btnLogin">
						<button id="submit"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" name="Envoyer">
							Envoyer <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form:form>
		</div>

	</fieldset>

</div>
	<script src="${ pageContext.request.contextPath }/resources/js/function.js"></script>


