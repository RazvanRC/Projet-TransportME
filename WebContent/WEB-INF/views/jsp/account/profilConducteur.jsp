<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<div class="presentation">
	<h3 class="titre">  Votre profil
	</h3>
	<br>
	<br>

<fieldset>
		<div class="inscription">
		<div id="divprofilclient">
			<form method="post" class="inscription">

				<label for="pseudo"> Votre Login: </label> 
				
				<input type="text" name="loginUtil" value="${ utilisateur.loginUtil }"><br><br> 
				
				<label for="surname">Votre Nom de famille: </label> 
				<input type="text" name="nomUtil" value="${ utilisateur.nomUtil }"><br><br> 
				
				<label for="name">Votre prénom: </label> 
				<input type="text" name="prenomUtil" value="${ utilisateur.prenomUtil }"><br><br> 
				
				<label for="date_naissance">Votre date de naissance: </label> 
				<input type="text" name="dateNaissanceUtil" value="${ utilisateur.dateNaissanceUtil }"><br><br> 
				
				<label for="name">Téléphone: </label>  
				<input type="text" name="telephoneUtil" value="${ utilisateur.telephoneUtil }"><br><br> 
				
			<label for="name">Année Permis de conduire: </label> 
				<input type="text" name="telephoneUtil" value="${ conducteur.telephoneUtil }"><br> <br> 
				
				<label for="date_naissance">Marque de voiture: </label> 
				<input type="text" name="marqueVoiture" value="${ conducteur.marqueVoiture }"><br> <br> 
				
				<label for="name">Modele de voiture: </label> 
				<input type="text" name="modeleVoiture" value="${ conducteur.modeleVoiture }"><br> <br> 
				
				<label for="name">Nombre de passagers: </label> 
				<input type="text" name="nbrPassagers" value="${ conducteur.nbrPassagers }"><br> <br> 
				
				<label for="name">Imatriculation: </label> 
				<input type="text" name="immatriculation" value="${ conducteur.immatriculation }"><br> <br> 
				
				<label for="email">Votre e-mail: </label> 
				<input type="text" name="emailUtil" value="${ conducteur.emailUtil }"> <br> <br> <br>
					</form>
		</div>
		
		<div class="inputLogin">
					<div class="reset">
						<button id="reset"
							class="btn waves-effect waves-light orange darken-4" type="reset"
							name="Réinitialiser">
							Gerer disponibilité  <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<div class="reset">
					<div class="btnLogin">
						<button id="submit"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" name="Envoyer">
							Modification <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
				<br>
	
			<div class="comment">
					<div class="btnLogin">
						<button id="submit"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" name="Envoyer">
							Commentaire <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
		<br>
	  <h4>
           Statut :</h4> <br>

           <input type="radio" name="souhait" value="disponible" id="disponible" /> <label for="disponible">Disponible</label><br>
           <input type="radio" name="souhait" value="indisponible" id="indisponible" /> <label for="indisponible">indisponible</label>
           
   
		
		
		
		
		
		
		</div>
			</fieldset>
			
			



