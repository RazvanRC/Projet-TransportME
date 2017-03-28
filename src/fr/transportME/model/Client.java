package fr.transportME.model;



import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="client")
@PrimaryKeyJoinColumn(name="cli_id", referencedColumnName="uti_id")
public class Client extends Utilisateur {

	private static final long serialVersionUID = 1L;

	
	@Column(name="cli_noCB")
	@Size(min=16, max=16)
	@NotNull
	private String noCBCli;

	@Column(name="cli_dateExpiration")
	@NotNull
	private Date dateExpirationCli;

	@Column(name="cli_cryptogramme")
	@Size(min=3, max=3)
	@NotNull
	private String cryptogrammeCli;
	
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Course> courses;

	

	public String getNoCBCli() {
		return noCBCli;
	}

	public void setNoCBCli(String noCBCli) {
		this.noCBCli = noCBCli;
	}

	public Date getDateExpirationCli() {
		return dateExpirationCli;
	}

	public void setDateExpirationCli(Date dateExpirationCli) {
		this.dateExpirationCli = dateExpirationCli;
	}

	
	
	public String getCryptogrammeCli() {
		return cryptogrammeCli;
	}

	public void setCryptogrammeCli(String cryptogrammeCli) {
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