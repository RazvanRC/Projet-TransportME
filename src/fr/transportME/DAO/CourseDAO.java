package fr.transportME.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.transportME.model.Course;

@Repository
@Transactional
public class CourseDAO extends DAO<Course>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Course find(int id) {
		return this.em.find(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		try {
			TypedQuery<Course> myQuery = em.createQuery("SELECT c FROM Course c", Course.class);
			return myQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public Course findByIdCient(int idClient) {
//		try {
//			TypedQuery<Course> myQuery = em.createQuery("SELECT c FROM Course c where c.client.id = :idClient", Course.class);
//			myQuery.setParameter("idClient", idClient);
//			return myQuery.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("pbe findByIdClient "+e);
//			return null;
//		}
//	}

	@Override
	public Course save(Course object) {
		return this.em.merge(object);
	}

	@Override
	public Course auth(String login, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Course> getClientCourses(int id) {
		TypedQuery<Course> myCourses =  em.createQuery("FROM Course c WHERE c.client.id = :cou_client", Course.class)
				.setParameter("cou_client", id);
		return myCourses.getResultList();
		
	}
	
	public List<Course> getConducteurCourses(int id) {
		TypedQuery<Course> myCourses =  em.createQuery("FROM Course c WHERE c.conducteur.id = :cou_conducteur", Course.class)
				.setParameter("cou_conducteur", id);
		return myCourses.getResultList();
		
	}
	
	//TODO methode pour creer les comments

}
