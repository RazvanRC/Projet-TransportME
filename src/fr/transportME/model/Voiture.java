package fr.transportME.model;

//import java.util.*;


public class Voiture {

   /**
    * Default constructor
    */
   public Voiture() {
   }

   
   private int idVoiture;

   private String marqueVoiture;

   private String modeleVoiture;

   private int nbrPassagers;

   private String immatriculation;

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public String getModeleVoiture() {
		return modeleVoiture;
	}

	public void setModeleVoiture(String modeleVoiture) {
		this.modeleVoiture = modeleVoiture;
	}

	public int getNbrPassagers() {
		return nbrPassagers;
	}

	public void setNbrPassagers(int nbrPassagers) {
		this.nbrPassagers = nbrPassagers;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
   
   

}