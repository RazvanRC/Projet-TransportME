package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.Client;

@Repository
@Transactional
public class ClientDAO extends DAO<Client>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Client find(int id) {
		return this.em.find(Client.class, id);
		try {
			TypedQuery<Client> myQuery = em.createQuery("FROM Client WHERE SELECT c FROM Client c", Client.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Client> findAll() {
		try {
			TypedQuery<Client> myQuery = em.createQuery("SELECT c FROM Client c", Client.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Client save(Client object) {
		return this.em.merge(object);
	}

	@Override
	public Client auth(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}

}
