package fr.transportME.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		return new ResponseEntity<Course>(courseDAO.save(course), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/demarrer", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Course> demarrerCourse(@PathVariable("id") int idCourse, @RequestBody Course course, BindingResult bindingResult) {
		
		//TODO faire cette fonction
		
		return new ResponseEntity<Course>(this.courseDAO.find(idCourse),	HttpStatus.OK);
//		if (bindingResult.hasErrors())
//				return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
		
		//return new ResponseEntity<Course>(courseDAO.save(course), HttpStatus.OK);
	}
	
}
