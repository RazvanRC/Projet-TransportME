package fr.transportME.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;;


@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cou_id")
	private int idcourse;

	@Column(name="cou_posDepLong")
	private Float posDepartLong;

	@Column(name="cou_posDepLat")
	private Float posDepartLat;

	@Column(name="cou_posArrLong")
	private Float posArretLong;

	@Column(name="cou_posArrLat")
	private Float posArretLat;

	@Column(name="cou_dateDepart")
	private Date dateDepart;

	@Column(name="cou_dateArrivee")
	private Date dateArrivee;

	@Column(name="cou_prixEstime")
	private Float prixEstime;

	@Column(name="cou_noteClient")
	private Float noteCommentClient;

	@Column(name="cou_texteClient")
	private String texteCommentClient;
	
	@Column(name="cou_noteConducteur")
	private Float noteCommentConducteur;

	@Column(name="cou_texteConducteur")
	private String texteCommentConducteur;
	
	@Column(name="cou_statutCourse")
	private String statutCourse;
	
	@ManyToOne
	@JoinColumn(name="cou_client")
	private Client client;
	
	
	@ManyToOne
	@JoinColumn(name="cou_conducteur")
	private Conducteur conducteur;

	@Column(name="cou_lieuDep")
	private String lieuDepart;

	@Column(name="cou_lieuArr")
	private String lieuArrivee;

	public int getIdcourse() {
		return idcourse;
	}



	public void setIdcourse(int idcourse) {
		this.idcourse = idcourse;
	}



	public Float getPosDepartLong() {
		return posDepartLong;
	}



	public void setPosDepartLong(Float posDepartLong) {
		this.posDepartLong = posDepartLong;
	}



	public Float getPosDepartLat() {
		return posDepartLat;
	}



	public void setPosDepartLat(Float posDepartLat) {
		this.posDepartLat = posDepartLat;
	}



	public Float getPosArretLong() {
		return posArretLong;
	}



	public void setPosArretLong(Float posArretLong) {
		this.posArretLong = posArretLong;
	}



	public Float getPosArretLat() {
		return posArretLat;
	}



	public void setPosArretLat(Float posArretLat) {
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



	public Float getPrixEstime() {
		return prixEstime;
	}



	public void setPrixEstime(Float prixEstime) {
		this.prixEstime = prixEstime;
	}



	public Float getNoteCommentClient() {
		return noteCommentClient;
	}



	public void setNoteCommentClient(Float noteCommentClient) {
		this.noteCommentClient = noteCommentClient;
	}



	public String getTexteCommentClient() {
		return texteCommentClient;
	}



	public void setTexteCommentClient(String texteCommentClient) {
		this.texteCommentClient = texteCommentClient;
	}



	public Float getNoteCommentConducteur() {
		return noteCommentConducteur;
	}



	public void setNoteCommentConducteur(Float noteCommentConducteur) {
		this.noteCommentConducteur = noteCommentConducteur;
	}



	public String getTexteCommentConducteur() {
		return texteCommentConducteur;
	}



	public void setTexteCommentConducteur(String texteCommentConducteur) {
		this.texteCommentConducteur = texteCommentConducteur;
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

	


	public String getStatutCourse() {
		return statutCourse;
	}



	public void setStatutCourse(String statutCourse) {
		this.statutCourse = statutCourse;
	}

	


	public String getLieuDepart() {
		return lieuDepart;
	}



	public void setLieuDepart(String lieuDepart) {
		this.lieuDepart = lieuDepart;
	}



	public String getLieuArrivee() {
		return lieuArrivee;
	}



	public void setLieuArrivee(String lieuArrivee) {
		this.lieuArrivee = lieuArrivee;
	}



	/**
	    * Default constructor
	    */
	   public Course() {
	   }
   
}