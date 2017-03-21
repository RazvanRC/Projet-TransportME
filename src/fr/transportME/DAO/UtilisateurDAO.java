package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.transportME.model.Comment;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Utilisateur;

@Repository
@Transactional
public class UtilisateurDAO extends DAO<Utilisateur>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur find(int id) {
		return this.em.find(Conducteur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		try {
			TypedQuery<Utilisateur> myQuery = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Comment> findAllComments() {
		return this.em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();
	}

	@Override
	public Utilisateur save(Utilisateur object) {
		return this.em.merge(object);
	}
	

	public Utilisateur auth(String login, String mdp) {
		Utilisateur myUtilisateur = null;
		try {
			myUtilisateur =  em.createQuery("FROM Utilisateur WHERE login = :uti_login AND mdp = :uti_mdp", Utilisateur.class)
					.setParameter("uti_login", login)
					.setParameter("uti_mdp", mdp)
					.getSingleResult();
			
		}
		
		catch (Exception e)  {
			
		}
		
		
		
		return myUtilisateur;
	}

}
