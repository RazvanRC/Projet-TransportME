package fr.transportME.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.transportME.model.Utilisateur;


public class UtilisateurSubscribeValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Utilisateur.class.equals(cls);
	}

	
	public void validate(Utilisateur utilisateur, Errors result, String confirmPassword) {
		System.out.println("utilisateur = "+utilisateur.getMdpUtil());
		System.out.println("confirmPassword = "+confirmPassword);
		if (!utilisateur.getMdpUtil().equals(confirmPassword))
		{
			result.rejectValue("mdpUtil", "result.code", "password differents");   // param 1 : nom du champ sur lequel on met l'erreur, 
			//param 2 : code de message bidon, param 3 : message d'erreur
		}
		
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

		
	}

}
