package fr.transportME.model;

import java.util.*;

/**
 * 
 */
public class Client extends Utilisateur {

   /**
    * Default constructor
    */
   public Client() {
   }

   /**
    * 
    */
   private int noCBCli;

   /**
    * 
    */
   private Date dateExpirationCli;

   /**
    * 
    */
   private int cryptogrammeCli;

   /**
    * 
    */
   private int idCli;

public int getNoCBCli() {
	return noCBCli;
}

public void setNoCBCli(int noCBCli) {
	this.noCBCli = noCBCli;
}

public Date getDateExpirationCli() {
	return dateExpirationCli;
}

public void setDateExpirationCli(Date dateExpirationCli) {
	this.dateExpirationCli = dateExpirationCli;
}

public int getCryptogrammeCli() {
	return cryptogrammeCli;
}

public void setCryptogrammeCli(int cryptogrammeCli) {
	this.cryptogrammeCli = cryptogrammeCli;
}

public int getIdCli() {
	return idCli;
}

public void setIdCli(int idCli) {
	this.idCli = idCli;
}

  

}