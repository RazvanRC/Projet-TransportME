package fr.transportME.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id")
	private int idComment;

	@ManyToOne
	@JoinColumn(name="com_util_id")
	private int idUtil;
	
	@Column(name="com_note")
	private int noteComment;

	@Column(name="com_texte")
	private String texteComment;

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public int getNoteComment() {
		return noteComment;
	}

	public void setNoteComment(int noteComment) {
		this.noteComment = noteComment;
	}

	public String getTexteComment() {
		return texteComment;
	}

	public void setTexteComment(String texteComment) {
		this.texteComment = texteComment;
	}
   

}