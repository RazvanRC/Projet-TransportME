package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.transportME.model.Comment;

@Repository
@Transactional
public class CommentDAO extends DAO<Comment>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Comment find(int id) {
		return this.em.find(Comment.class, id);
	}

	@Override
	public List<Comment> findAll() {
		try {
			TypedQuery<Comment> myQuery = em.createQuery("SELECT c FROM Comment c", Comment.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Comment save(Comment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment auth(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}

}
