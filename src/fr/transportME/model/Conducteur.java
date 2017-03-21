package fr.transportME.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import java.util.*;

@Entity
@Table(name="conducteur")
@PrimaryKeyJoinColumn(name="cond_id", referencedColumnName="uti_id")
public class Conducteur extends Utilisateur {

	private static final long serialVersionUID = 1L;

	@Column(name="cond_anneePermis")
	private int anneePermis;

	private float posActuelleLong;

	private float posActuelleLat;

	private boolean statut;

	@OneToOne
	private int idVoiture;

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

	/**
	    * Default constructor
	    */
	   public Conducteur() {
	   }

}