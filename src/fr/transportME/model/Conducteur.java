package fr.transportME.model;

//import java.util.*;

/**
 * 
 */
public class Conducteur extends Utilisateur {

   /**
    * Default constructor
    */
   public Conducteur() {
   }

   /**
    * 
    */
   private int anneePermis;

   /**
    * 
    */
   private float posActuelleLong;

   /**
    * 
    */
   private float posActuelleLat;

   /**
    * 
    */
   private boolean statut;

   /**
    * 
    */
   private int idVoiture;

   /**
    * 
    */
   private int idCond;

public int getAnneePermis() {
	return anneePermis;
}

public void setAnneePermis(int anneePermis) {
	this.anneePermis = anneePermis;
}

public float getPosActuelleLong() {
	return posActuelleLong;
}

public void setPosActuelleLong(float posActuelleLong) {
	this.posActuelleLong = posActuelleLong;
}

public float getPosActuelleLat() {
	return posActuelleLat;
}

public void setPosActuelleLat(float posActuelleLat) {
	this.posActuelleLat = posActuelleLat;
}

public boolean isStatut() {
	return statut;
}

public void setStatut(boolean statut) {
	this.statut = statut;
}

public int getIdVoiture() {
	return idVoiture;
}

public void setIdVoiture(int idVoiture) {
	this.idVoiture = idVoiture;
}

public int getIdCond() {
	return idCond;
}

public void setIdCond(int idCond) {
	this.idCond = idCond;
}

  
   

}