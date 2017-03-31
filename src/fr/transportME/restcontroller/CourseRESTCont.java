package fr.transportME.restcontroller;

import java.util.Date;
import java.util.List;

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

import fr.transportME.DAO.ConducteurDAO;
import fr.transportME.DAO.CourseDAO;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Course;

@RestController
@RequestMapping("/courses")
public class CourseRESTCont {
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private ConducteurDAO conducteurDAO;

	/**
	 * methode pour la commande d'une course (creation)
	 * @param course
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Course> commanderCourse(@RequestBody Course course, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
				return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
		
		//TODO validator a creer pour verifier que l'id client passï¿½ est bien existant dans la bdd sinon plantage 500 
		
		return new ResponseEntity<Course>(courseDAO.save(course), HttpStatus.OK);
	}
	
	/**
	 * methode pour recuperer une course precise
	 * @param idClient
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/{idCourse}/recuperer", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Course> recupererInfoCourse(@PathVariable("idCourse") int idCourse) {
		
		Course course=null;
		course = courseDAO.findByidCourse(idCourse);
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	/**
	 * methode pour recuperer une course attribuee à un conducteur et non commencee 
	 * @param idConducteur
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/recuperer", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Course> recupererCourseAttribuee(@RequestParam(value = "idConducteur", required = false) int idConducteur) {
		
		Course course=null;
		course = courseDAO.findByidConducteur(idConducteur);
		if (course == null) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	/**
	 * methode pour demarrer une course
	 * @param idCourse
	 * @return
	 */
	@RequestMapping(value="/{idCourse}/demarrer", method= RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Course> demarrerCourse(@PathVariable("idCourse") int idCourse) {
		
		System.out.println("demarrage de la course idCourse="+idCourse);
		Course myCourse = this.courseDAO.find(idCourse);
		
		// on rend indisponible le conducteur associé à la course
		Conducteur myConducteur = myCourse.getConducteur();
		System.out.println("id utilisateur "+myConducteur.getIdUtil());
		System.out.println("Telephone "+myConducteur.getTelephoneUtil());
		myConducteur.setStatut(false);
		conducteurDAO.save(myConducteur);
		
		myCourse.setDateDepart(new Date());
		
		System.out.println("sauvegarde");
		return new ResponseEntity<Course>(courseDAO.save(myCourse),	HttpStatus.OK);
	}
	
	/**
	 * methode pour terminer une course
	 * @param idCourse
	 * @return
	 */
	@RequestMapping(value="/{idCourse}/terminer", method= RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Course> terminerCourse(@PathVariable("idCourse") int idCourse) {
		
		System.out.println("terminer la course idCourse="+idCourse);
		Course myCourse = this.courseDAO.find(idCourse);
		myCourse.setPrixEstime(15.00f);
		
		// on rend disponible le conducteur associé à la course
		Conducteur myConducteur = myCourse.getConducteur();
		myConducteur.setStatut(true);
		conducteurDAO.save(myConducteur);

		Date dt = new Date();
		System.out.println("date "+dt);
		myCourse.setDateArrivee(dt);
		
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
