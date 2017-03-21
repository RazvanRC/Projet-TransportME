package fr.transportME.validation;

public class WrongUsernameOrPasswordException extends Exception{

	private static final long serialVersionUID = 1L;

	public WrongUsernameOrPasswordException() {
		super();
		System.out.println("Le nom d'utilisateur ou le mot de passe est incorrect.");
	}

	public void rejectValue(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}
}
