package fr.transportME.noentity;



public class InscriptionUtilisateur extends Administrateur {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String passwordCheck;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	public void setProperties(Administrateur util) {
		util.setNom(this.getNom());
		util.setPrenom(this.getPrenom());
		util.setPassAdmin(this.getPassAdmin());
		util.setLoginAdmin(this.getLoginAdmin());
	}

}
