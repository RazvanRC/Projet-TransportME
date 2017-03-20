package fr.transportME.model;

import java.util.*;

/**
 * 
 */
public class Trajet {

   /**
    * Default constructor
    */
   public Trajet() {
   }

   /**
    * 
    */
   private int idCond;

   /**
    * 
    */
   private int idTrajet;

   /**
    * 
    */
   private float posDepartLong;

   /**
    * 
    */
   private float posDepartLat;

   /**
    * 
    */
   private float posArretLong;

   /**
    * 
    */
   private float posArretLat;

   /**
    * 
    */
   private Date dateDepart;

   /**
    * 
    */
   private Date dateArrive;

   /**
    * 
    */
   private float prixEstime;

public int getIdCond() {
	return idCond;
}

public void setIdCond(int idCond) {
	this.idCond = idCond;
}

public int getIdTrajet() {
	return idTrajet;
}

public void setIdTrajet(int idTrajet) {
	this.idTrajet = idTrajet;
}

public float getPosDepartLong() {
	return posDepartLong;
}

public void setPosDepartLong(float posDepartLong) {
	this.posDepartLong = posDepartLong;
}

public float getPosDepartLat() {
	return posDepartLat;
}

public void setPosDepartLat(float posDepartLat) {
	this.posDepartLat = posDepartLat;
}

public float getPosArretLong() {
	return posArretLong;
}

public void setPosArretLong(float posArretLong) {
	this.posArretLong = posArretLong;
}

public float getPosArretLat() {
	return posArretLat;
}

public void setPosArretLat(float posArretLat) {
	this.posArretLat = posArretLat;
}

public Date getDateDepart() {
	return dateDepart;
}

public void setDateDepart(Date dateDepart) {
	this.dateDepart = dateDepart;
}

public Date getDateArrive() {
	return dateArrive;
}

public void setDateArrive(Date dateArrive) {
	this.dateArrive = dateArrive;
}

public float getPrixEstime() {
	return prixEstime;
}

public void setPrixEstime(float prixEstime) {
	this.prixEstime = prixEstime;
}

   
}