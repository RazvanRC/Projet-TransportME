package fr.transportME.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.transportME.noentity.InscriptionUtilisateur;


public class PasswordCheckValidator implements Validator{

		@Override
		public boolean supports(Class<?> cls) {
			return InscriptionUtilisateur.class.equals(cls);
		}


		@Override
		public void validate(Object obj, Errors e) {
			InscriptionUtilisateur myInscriptionUtilisateur = (InscriptionUtilisateur)obj;

			if (!myInscriptionUtilisateur.getMdpUtil().equals(myInscriptionUtilisateur.getPasswordCheck())) {
				e.rejectValue("password", "pwdcheck", "Les mots de passe ne correspondent pas.");
			}
		}

}
