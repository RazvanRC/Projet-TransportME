<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="presentation">
	<h3 class="titre">  Profil Client
	</h3>
	<br>
	<br>

	<fieldset>
		<div class="inscription">
			<div id="divprofilclient">
				<form method="post" class="inscription">

					<label for="pseudo"> Votre Login: </label> 
					<input type="text" name="loginUtil" value="${ client.loginUtil }"><br> <br> 				
					
					<label for="surname">Votre mot de passe: </label> 
					<input type="password" name="mdpUtil" value="${ client.mdpUtil }"><br> <br> 
					
					<label for="surname">Votre Nom de famille: </label> 
					<input type="text" name="nomUtil" value="${ client.nomUtil }"><br> <br> 
					
					<label for="firstname">Votre pr�nom: </label> 
					<input type="text" name="prenomUtil" value="${ client.prenomUtil }"><br><br> 
					
					<label for="date_naissance">Votre date de naissance: </label> 
					<input type="text" name="dateNaissanceUtil" value="${ client.dateNaissanceUtil }"><br><br> 
					
					<label for="tel">T�l�phone: </label> 
					<input type="text" name="telephoneUtil" value="${ client.telephoneUtil }"><br> <br> 
					
					<label for="email">Votre e-mail: </label> 
					<input type="email" name="emailUtil" value="${ client.emailUtil }">
					
					<label for="noCB">Num�ro de la carte bancaire: </label> 
					<input type="text" name="noCBCli" value="${ client.noCBCli }"><br> <br>
					 
					<label for="date_expiration">Date d'Expiration CB: </label> 
					<input type="text" name="dateExpirationCli" value="${ client.dateExpirationCli }"><br> <br>
					
					<label for="crypto">Cryptogramme: </label> 
					<input type="text" name="cryptogrammeCli" value="${ client.cryptogrammeCli }"><br> <br>
					
					<br> <br> <br>
				</form>
			</div>

			
		
		
		
		<div class="inputLogin">
					<div class="reset">
						<button id="reset"
							class="btn waves-effect waves-light orange darken-4" type="reset"
							onclick="location.href='commande'"
							name="R�initialiser">
							Commander  <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<div class="reset">
					<div class="btnLogin">
						<button id="submit"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" onclick="modifProfil()" name="Envoyer">
							Modification <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</div>
			<br>

			<div class="comment">
				<div class="btnLogin">
					<button id="comment"
						class="btn waves-effect waves-light orange darken-4" type="submit"
						name="Envoyer">
						Commentaire <i class="material-icons right">send</i>
					</button>
				</div>
			</div>







		
	</fieldset>
</div>


