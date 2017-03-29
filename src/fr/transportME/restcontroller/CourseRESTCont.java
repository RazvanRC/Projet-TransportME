package fr.transportME.restcontroller;

import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.transportME.DAO.CourseDAO;
import fr.transportME.model.Client;
import fr.transportME.model.Course;

@RestController
@RequestMapping("/courses")
public class CourseRESTCont {
	
	@Autowired
	private CourseDAO courseDAO;

	/**
	 * methode pour la commande d'une course
	 * @param course
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Course> commanderCourse(@RequestBody Course course, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
				return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
		
		//TODO validator a creer pour verifier que l'id client pass� est bien existant dans la bdd sinon plantage 500 
		
		return new ResponseEntity<Course>(courseDAO.save(course), HttpStatus.OK);
	}
	
	/**
	 * methode pour recuperer une course
	 * @param idClient
	 * @param 
	 * @return
	 */
	@RequestMapping(value="", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Course> recupererCourse(@RequestParam(value = "idClient", required = false) int idClient) {
		
		Course course=null;
		course = courseDAO.findByIdCient(idClient);
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	/**
	 * methode pour demarrer une course
	 * @param idCourse
	 * @param dateDepart
	 * @return
	 */
	@RequestMapping(value="/{idCourse}/demarrer", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Course> demarrerCourse(@PathVariable("idCourse") int idCourse, 
			@RequestParam("dateDepart") Date dateDepart) {
		
		System.out.println("demarrage de la course idCourse="+idCourse);
		Course myCourse = this.courseDAO.find(idCourse);
		System.out.println("date de depart="+dateDepart);
		myCourse.setDateDepart(dateDepart);
		
		System.out.println("sauvegarde");
		return new ResponseEntity<Course>(courseDAO.save(myCourse),	HttpStatus.OK);
	}
	
	
	/**
	 * methode pour recuperer l'historique pour un client
	 * @param idClient
	 * @return
	 */
	@RequestMapping(value="/history", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> getClientCommentsHistory(@RequestParam("idClient") int idClient) {
//		Client myClient = this.clientDAO.find(idClient);
//		List<Course> myCourses = this.courseDAO.getClientCourses(idClient);
		
		return new ResponseEntity<List<Course>>(this.courseDAO.getClientCourses(idClient), HttpStatus.OK);
	}
}
