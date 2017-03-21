package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.transportME.model.Conducteur;

@Repository
@Transactional
public class ConducteurDAO extends DAO<Conducteur>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Conducteur find(int id) {
		return this.em.find(Conducteur.class, id);
	}

	@Override
	public List<Conducteur> findAll() {
		try {
			TypedQuery<Conducteur> myQuery = em.createQuery("SELECT c FROM Conducteur c", Conducteur.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Conducteur save(Conducteur object) {
		return this.em.merge(object);
	}

}
