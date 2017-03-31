<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    


<div class="presentation">
	<h3 class="titre">  Profil Conducteur</h3>
	<br>
	<br>
	

<fieldset>
	<div class="inscription">
		<div id="divprofilclient">
			<!-- <form method="post" name="inscription" class="inscription"> -->
			<form:form id="dispo" action="dispo" >
			
				<input type="hidden" id="idUtil" name="idUtil" value="${ conducteur.idUtil }"><br> <br>

				<label for="loginUtil"> Votre Login: </label> 
				<input type="text" id="loginUtil" name="loginUtil" value="${ conducteur.loginUtil }"><br><br> 
				
				<label for="mdpUtil">Votre mot de passe: </label> 
				<input type="password" id="mdpUtil" name="mdpUtil" value="${ conducteur.mdpUtil }"><br> <br> 
				
				<label for="nomUtil">Votre Nom de famille: </label> 
				<input type="text" id="nomUtil" name="nomUtil" value="${ conducteur.nomUtil }"><br><br> 
				
				<label for="prenomUtil">Votre prénom: </label> 
				<input type="text" id="prenomUtil" name="prenomUtil" value="${ conducteur.prenomUtil }"><br><br> 
				
				<label for="dateNaissanceUtil">Votre date de naissance: </label> 
				<input type="text" id="dateNaissanceUtil" name="dateNaissanceUtil" value="${ conducteur.dateNaissanceUtil }"><br><br> 
				
				<label for="telephoneUtil">Téléphone: </label>  
				<input type="text" id="telephoneUtil" name="telephoneUtil" value="${ conducteur.telephoneUtil }"><br><br> 
				
				<label for="emailUtil">Votre e-mail: </label> 
				<input type="text" id="emailUtil" name="emailUtil" value="${ conducteur.emailUtil }"> <br> <br>
				
				<label for="anneePermis">Année Permis de conduire: </label> 
				<input type="text" id="anneePermis" name="anneePermis" value="${ conducteur.anneePermis }"><br> <br> 
				
				<label for="marqueVoiture">Marque de voiture: </label> 
				<input type="text" id="marqueVoiture" name="marqueVoiture" value="${ conducteur.marqueVoiture }"><br> <br> 
				
				<label for="modeleVoiture">Modele de voiture: </label> 
				<input type="text" id="modeleVoiture" name="modeleVoiture" value="${ conducteur.modeleVoiture }"><br> <br> 
				
				<label for="nbrPassagers">Nombre de passagers: </label> 
				<input type="text" id="nbrPassagers" name="nbrPassagers" value="${ conducteur.nbrPassagers }"><br> <br> 
				
				<label for="immatriculation">Imatriculation: </label> 
				<input type="text" id="immatriculation" name="immatriculation" value="${ conducteur.immatriculation }"><br> <br> 
				
				<input type="hidden" id="statut" name="statut" value="${ conducteur.statut }"><br> <br> 
				
		<div id="statut">
			<h3> Statut :</h3> <br>

				<input type="radio" name="souhait" value="1" id="disponible" onload="disponibilite()"/> 
				<label for="disponible">Disponible</label><br>
           
				<input type="radio" name="souhait" value="0" id="indisponible" onload="disponibilite()"/> 
				<label for="indisponible">indisponible</label>
		</div>
		
				<br> <br> <br>
					<!-- </form> -->

		

			<div class="inputLogin">
						<div class="reset">
						
							<!--  <button id="reset"
								class="btn waves-effect waves-light orange darken-4" type="reset"
								onclick="location.href='dispo'"
								name="Réinitialiser">
								Gerer disponibilité  <i class="material-icons right">send</i>
							</button>
							-->
							
							<button id="subdispo"
							class="btn waves-effect waves-light orange darken-4"
							type="submit"  name="Envoyer">
							Gerer disponibilité <i class="material-icons right">send</i>
						</button>
						</div>
			</div>
		</form:form>
	</div>
				<div class="reset">
					<div class="btnLogin">
						<button id="submitModifProfilConducteur"
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
		
           

		</div>
	</fieldset>
		
			
</div>

<div class="comments">

	<ul>
	
		<c:forEach items = "${comments }" var = "comment">
			<li> 
			
				<div class="commentTotal">
				
					<div class="texteComment"></div>
					<div class="noteComment"></div>
					<div class="dateComment"></div>
				
				</div>
			
			
			</li>
		</c:forEach>
	
	</ul>

</div>

<script src="${ pageContext.request.contextPath }/resources/js/methodesConducteur.js"></script>

















