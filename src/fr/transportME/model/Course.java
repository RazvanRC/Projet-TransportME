package fr.transportME.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cou_id")
	private int idcourse;

	@Column(name="cou_posDepLong")
	private float posDepartLong;

	@Column(name="cou_posDepLat")
	private float posDepartLat;

	@Column(name="cou_posArrLong")
	private float posArretLong;

	@Column(name="cou_posArrLat")
	private float posArretLat;

	@Column(name="cou_dateDepart")
	private Date dateDepart;

	@Column(name="cou_dateArrivee")
	private Date dateArrivee;

	@Column(name="cou_prixEstime")
	private float prixEstime;

	@Column(name="cou_noteClient")
	private float noteCommentClient;

	@Column(name="cou_texteClient")
	private String texteCommentClient;
	
	@Column(name="cou_noteConducteur")
	private float noteCommentConducteur;

	@Column(name="cou_texteConducteur")
	private String texteCommentConducteur;
	
	@ManyToOne
	@JoinColumn(name="cou_client")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="cou_conducteur")
	private Conducteur conducteur;

	public int getIdcourse() {
		return idcourse;
	}

	public void setIdcourse(int idcourse) {
		this.idcourse = idcourse;
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

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public float getPrixEstime() {
		return prixEstime;
	}

	public void setPrixEstime(float prixEstime) {
		this.prixEstime = prixEstime;
	}
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	
	
	public float getNoteCommentClient() {
		return noteCommentClient;
	}

	public void setNoteCommentClient(float noteCommentClient) {
		this.noteCommentClient = noteCommentClient;
	}

	public String getTexteCommentClient() {
		return texteCommentClient;
	}

	public void setTexteCommentClient(String texteCommentClient) {
		this.texteCommentClient = texteCommentClient;
	}

	public float getNoteCommentConducteur() {
		return noteCommentConducteur;
	}

	public void setNoteCommentConducteur(float noteCommentConducteur) {
		this.noteCommentConducteur = noteCommentConducteur;
	}

	public String getTexteCommentConducteur() {
		return texteCommentConducteur;
	}

	public void setTexteCommentConducteur(String texteCommentConducteur) {
		this.texteCommentConducteur = texteCommentConducteur;
	}

	/**
	    * Default constructor
	    */
	   public Course() {
	   }
   
}