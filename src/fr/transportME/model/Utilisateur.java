package fr.transportME.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uti_id")
	@NotNull
	private int idUtil;

	@Column(name="uti_nom")
	@NotNull
	private String nomUtil;

	@Column(name="uti_prenom")
	@NotNull
	private String prenomUtil;

	@Column(name="uti_login")
	@NotNull
	private String loginUtil;

	@Column(name="uti_mdp")
	@NotNull
	private String mdpUtil;

	@Column(name="uti_telephone")
	@Size(min=10, max=10)
	@NotNull
	private String telephoneUtil;

	@Column(name="uti_dateNaissance")
	@NotNull
	private Date dateNaissanceUtil;
	
	@OneToMany(mappedBy="utilisateur")
	private List<Comment> comments;

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


	public String getTelephoneUtil() {
		return telephoneUtil;
	}

	public void setTelephoneUtil(String telephoneUtil) {
		this.telephoneUtil = telephoneUtil;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getDateNaissanceUtil() {
		return dateNaissanceUtil;
	}

	public void setDateNaissanceUtil(Date dateNaissanceUtil) {
		this.dateNaissanceUtil = dateNaissanceUtil;
	}
	
	/**
	    * Default constructor
	    */
	   public Utilisateur() {
	   }
    
}