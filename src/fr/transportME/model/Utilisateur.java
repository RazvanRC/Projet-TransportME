package fr.transportME.model;

import java.util.*;

public class Utilisateur {

   /**
    * Default constructor
    */
   public Utilisateur() {
   }

   private int idUtil;

   private String nomUtil;

   private String prenomUtil;

   private String loginUtil;

   private String mdpUtil;

   private int telephoneUtil;

   private Date dateNaissanceUtil;

	public int getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}

	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getPrenomUtil() {
		return prenomUtil;
	}

	public void setPrenomUtil(String prenomUtil) {
		this.prenomUtil = prenomUtil;
	}

	public String getLoginUtil() {
		return loginUtil;
	}

	public void setLoginUtil(String loginUtil) {
		this.loginUtil = loginUtil;
	}

	public String getMdpUtil() {
		return mdpUtil;
	}

	public void setMdpUtil(String mdpUtil) {
		this.mdpUtil = mdpUtil;
	}

	public int getTelephoneUtil() {
		return telephoneUtil;
	}

	public void setTelephoneUtil(int telephoneUtil) {
		this.telephoneUtil = telephoneUtil;
	}

	public Date getDateNaissanceUtil() {
		return dateNaissanceUtil;
	}

	public void setDateNaissanceUtil(Date dateNaissanceUtil) {
		this.dateNaissanceUtil = dateNaissanceUtil;
	}
    
}