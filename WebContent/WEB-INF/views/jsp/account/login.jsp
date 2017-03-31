<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="loginPanel">
<div class="inscription">
	<div id="loginCenter" class="z-depth-5">
	<br>
	<br>
		<form class="col s6" method="POST">
			<div class="row">
			
				<div class="inputLogin">
					<div class="input-field col s6">
						<i class="material-icons prefix">account_box</i> <input
							name="loginUtil" id="icon_prefix" type="text" /> <label
							for="icon_prefix">Nom d'utilisateur</label>
					</div>

				</div>
				<div class="inputLogin">
					<div class="input-field col s6">
						<i class="material-icons prefix">lock</i> <input name="mdpUtil"
							id="icon_password" type="password" /> <label for="icon_password">Mot
							de passe</label>
					</div>
				</div>
				<br>
				<br>
				<div class="inputLogin">
					<div class="btnLogin">
						<button id="btnLogin"
							class="btn waves-effect waves-light orange darken-4"
							type="submit" name="actionC">
							Connexion <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</div>

			${ errormessage }
		</form>
<br>
		<button id="btnInsc"
			class="btn waves-effect waves-light orange darken-4"
			onclick="location.href='inscription'">
			Inscription <i class="material-icons right">send</i>
		</button>

	</div>
	







</div>		

</section>