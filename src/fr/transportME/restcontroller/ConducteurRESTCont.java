package fr.transportME.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import fr.transportME.DAO.ConducteurDAO;
import fr.transportME.model.Comment;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Course;

@RestController
@RequestMapping("/conducteurs")
public class ConducteurRESTCont {
	
	@Autowired
	private ConducteurDAO conducteurDAO;
	
	/**
	 * methode pour la recherche d'un conducteur
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Conducteur> getClient(@PathVariable("id") int idConducteur, HttpSession session) {
		
//		return new ResponseEntity<Client>(this.clientDAO.find(((Client) session.getAttribute("utilisateur")).getIdUtil()),	HttpStatus.OK);
		Conducteur c = this.conducteurDAO.find(idConducteur);
		return new ResponseEntity<Conducteur>(c, HttpStatus.OK);
	}
	
	/**
	 * methode pour l'inscription d'un Conducteur
	 * @param conducteur
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="", method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Conducteur> createConducteur(@RequestBody Conducteur conducteur, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors())
				return new ResponseEntity<Conducteur>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Conducteur>(conducteurDAO.save(conducteur), HttpStatus.OK);
	}
	
	/**
	 * methode pour modification d'un Conducteur
	 * @param idConducteur
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Conducteur> modifConducteur(@PathVariable(value = "id", required = false) int idConducteur, 
											@RequestBody Conducteur conducteur, BindingResult bindingResult) {

		// TODO securite de la modif
//		System.out.println(myClient.getNomUtil());
		conducteur.setIdUtil(idConducteur);
		conducteur = this.conducteurDAO.save(conducteur);
//		System.out.println(myClient.getNomUtil());
		if (conducteur == null)
			return new ResponseEntity<Conducteur>( HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK);

	}
	
	/**
	 * methode pour recuperer les commentaires pour un Conducteur
	 * @param idConducteur
	 * @return
	 */
	@RequestMapping(value="/{id}/comments", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Comment>> getCommentsHistoryCond(@PathVariable(value="id", required=false) int idConducteur) {
		Conducteur myConducteur = this.conducteurDAO.find(idConducteur);
		return new ResponseEntity<List<Comment>>(myConducteur.getComments(), HttpStatus.OK);
	}
	
	/**
	 * methode pour recupere les trajets pour un Conducteur
	 * @param idConducteur
	 * @return
	 */
	@RequestMapping(value="/{id}/courses", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> getCoursesHistoryCond(@PathVariable(value="id", required=false) int idConducteur) {
		Conducteur myConducteur = this.conducteurDAO.find(idConducteur);
		return new ResponseEntity<List<Course>>(myConducteur.getCourses(), HttpStatus.OK);
	}

}
