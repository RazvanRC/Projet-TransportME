
<body>
	 <div id="wrapper" >
		<div class="header">
		    <div class="header2">                  
		        <img src="css/img/logo.PNG">                  
		    </div>
		    
		</div>
       
        <div id="menu1">
            <ul>
                <li>
                    <a href="index.html">Acceuil</a>
                </li>
             
            </ul>
        </div>
        <div id="leftcolumn">
            <div id="sidebar_bg">
               
                <div id="menu2"></div>
               
            </div>
        </div>
        <!-- Contenu principal -->
                       
                    <br>
                        <br>
                
                

	<div class="presentation">
    <h3 class="titre">L'inscription ne prend que quelques secondes...
    </h3>
   
   
    <form method="post" class="inscription" id="inscription">
  
        <fieldset >
           	<br>
           	<br>
           	<label for="utilisateur">Utilisateur*:   </label>
           	<select>
				<option value="client">Client</option>
				<option value="conducteur">Conducteur</option> 
			</select>
<br>
<br>
             <label for="pseudo">  Votre Login*:   </label>
                <input type="text" class="form-text" name="loginUtil" id="loginUtil" required><br>
                <br>
                 <label for="password">Password*:   </label>
                <input type="password" class="form-password" name="password" id="password" required><br>
                <br>
                <label for="verif_password">Confirmation Password*:   </label>
                <input type="password" class="form-password" name="verif_password" id="verif_password" required><br>
                <br>
             <label for="surname">Votre Nom de famille:   </label>
                <input type="text" class="form-text" name="surname" id="surname" required><br>
                <br>
               <label for="name">Votre prénom:   </label>
                <input type="text" class="form-text" name="name" id="name" required><br>
                <br>
                <label for="date_naissance">Votre date de naissance:   </label>
                <input type="date" class="form-text" name="date_naissance" id="date_naissance" required><br>
                <br>
                 <label for="name">Téléphone:   </label>
                <input type="text" class="form-text" name="telephoneUtil" id="telephoneUtil" required><br>
                <br>
                 <label for="name">Numéro de la carte bancaire:   </label>
                <input type="text" class="form-text" name="telephoneUtil" id="telephoneUtil" required><br>
                <br>
                 <label for="date_naissance">Date d'Expiration CB:   </label>
                <input type="date" class="form-text" name="date_naissance" id="date_naissance" required><br>
                <br>
                 <label for="name">Cryptogramme:   </label>
                <input type="text" class="form-text" name="cryptogrammeCli" id="cryptogrammeCli" required><br>
                <br>

                <label for="email">Votre e-mail*:   </label>
                <input class="form-text" type="email" name="email" id="email" required>
                <br>
                <br>
                <div class="inputLogin">
	                <div class="reset">
	                    <button id="reset" class="btn waves-effect waves-light orange darken-4" type="reset" name="Réinitialiser">Réinitialiser
	                        <i class="material-icons right">send</i>
	                    </button>
	                </div>
	        	</div>
                <div class="reset">
	                <div class="btnLogin">
	                    <button id="submit" class="btn waves-effect waves-light orange darken-4" type="submit" name="Envoyer">Envoyer
	                        <i class="material-icons right">send</i>
	                    </button>
	                </div>
                </div>
<!--                   <input type="reset" value="Réinitialiser"> -->
<!--         <input type="submit" value="Envoyer" id="submit"> -->

        </fieldset>
        </form>
      
	</div>
           

</body>

