package fr.transportME.noentity;

import fr.transportME.model.Utilisateur;

public class InscriptionUtilisateur extends Utilisateur {

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
	
	public void setProperties(Utilisateur util) {
		util.setNomUtil(this.getNomUtil());
		util.setPrenomUtil(this.getPrenomUtil());
		util.setMdpUtil(this.getMdpUtil());
		util.setLoginUtil(this.getLoginUtil());
	}

}
