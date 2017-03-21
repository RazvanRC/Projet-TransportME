package fr.transportME.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import java.util.*;

@Entity
@Table(name="conducteur")
@PrimaryKeyJoinColumn(name="cond_id", referencedColumnName="uti_id")
public class Conducteur extends Utilisateur {

	private static final long serialVersionUID = 1L;

	@Column(name="cond_anneePermis")
	@NotNull
	private int anneePermis;

	@Column(name="cond_posActuelleLong")
	private float posActuelleLong;

	@Column(name="cond_posActuelleLat")
	private float posActuelleLat;

	@Column(name="cond_statut")
	@ColumnDefault("false")
	private boolean statut;
	
	@Column(name="cond_marque")
	@NotNull
	private String marqueVoiture;

	@Column(name = "cond_modele")
	@NotNull
	private String modeleVoiture;

	@Column(name = "cond_nbrPassagers")
	@NotNull
	private int nbrPassagers;

	@Column(name = "cond_immatriculation")
	@Size(min=7, max=7)
	@NotNull
	private String immatriculation;
	
	@OneToMany(mappedBy="conducteur")
	@JsonIgnore
	private List<Course> courses;

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
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * Default constructor
	 */
	public Conducteur() {
	}

}