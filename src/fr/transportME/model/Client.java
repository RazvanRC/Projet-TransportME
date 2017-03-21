package fr.transportME.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="client")
@PrimaryKeyJoinColumn(name="cli_id", referencedColumnName="uti_id")
public class Client extends Utilisateur {

	private static final long serialVersionUID = 1L;

	@Column(name="cli_noCB")
	private int noCBCli;

	@Column(name="cli_dateExpiration")
	private Date dateExpirationCli;

	@Column(name="cli_cryptogramme")
	private int cryptogrammeCli;
	
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Course> courses;

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
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * Default constructor
	 */
	public Client() {
	   }


}