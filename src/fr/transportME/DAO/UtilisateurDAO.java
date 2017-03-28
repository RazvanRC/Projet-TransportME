package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.transportME.model.Conducteur;
import fr.transportME.model.Utilisateur;
import fr.transportME.validation.WrongUsernameOrPasswordException;

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
	

	@Override
	public Utilisateur save(Utilisateur object) {
		return this.em.merge(object);
	}
	
	@Override
	public Utilisateur auth(String login, String mdp) throws WrongUsernameOrPasswordException {
		Utilisateur myUtilisateur = null;
		System.out.println("debut AUTH utilisateurDAO");
		try {
			myUtilisateur =  em.createQuery("FROM Utilisateur u WHERE u.loginUtil = :uti_login AND u.mdpUtil = :uti_mdp", Utilisateur.class)
					.setParameter("uti_login", login)
					.setParameter("uti_mdp", mdp)
					.getSingleResult();
			
		}
		
		catch (Exception e)  {  
			System.out.println("pbe select from Utilisateur "+e);
			throw new WrongUsernameOrPasswordException();
			}
		
//		if (myUtilisateur == null) 
//			
//		{
//			System.out.println("pbe myUtilisateur est null ");
//			throw new WrongUsernameOrPasswordException();
//		}
			
		System.out.println("retourne myUtilisateur");
		return myUtilisateur;
	}

}
