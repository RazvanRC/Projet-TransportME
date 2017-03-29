package fr.transportME.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.transportME.DAO.ConducteurDAO;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Course;
import fr.transportME.model.Utilisateur;


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
//	@RequestMapping(value="/{id}/comments", method= RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<Comment>> getCommentsHistoryCond(@PathVariable(value="id", required=false) int idConducteur) {
//		Conducteur myConducteur = this.conducteurDAO.find(idConducteur);
//		return new ResponseEntity<List<Comment>>(myConducteur.getComments(), HttpStatus.OK);
//	}
	
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
	
	
	/**
	 * methode pour rechercher les disponibilités conducteurs autour de l'endroit où se trouve le passager
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/disponibilites", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Conducteur>> getDispoCond(
			@RequestParam(value = "lat", required = false) double lat,
			@RequestParam(value = "lng", required = false) double lng
			) {
		
		System.out.println("lat ="+lat+" lng ="+lng);
		List<Conducteur> myConducteurs = this.conducteurDAO.findAllDispo();
		
		// recherche des positions des conducteurs
		String latlng_conducteurs;//"48.861322, 2.335196|50,4";
		StringBuffer latlng_conducteurs_buf = new StringBuffer();
		for (int i = 0; i < myConducteurs.size(); i++) {
			System.out.println("lat="+ myConducteurs.get(i).getPosActuelleLat() + " lng="+myConducteurs.get(i).getPosActuelleLong());
			if (i != 0) {
				latlng_conducteurs_buf.append("|");
			}
			latlng_conducteurs_buf.append(myConducteurs.get(i).getPosActuelleLat()+","+myConducteurs.get(i).getPosActuelleLong());
			System.out.println("latlng_conducteurs="+latlng_conducteurs_buf.toString());
		}
		latlng_conducteurs = latlng_conducteurs_buf.toString();
		
		// constitution url avec infos lat, lng origine et destination		
		String latlng_passager = lat + "," + lng;//"50.6079121,3.1672095";
		System.out.println("latlng_passager="+latlng_passager);

		String cleApi = "AIzaSyAlQBHwe0zERdQ2lehqHdbMVPN0daVd7gA";
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+latlng_passager+"&destinations="+latlng_conducteurs+"&key="+cleApi;
		System.out.println("url appelé = "+url);
		
		// appel service distancematrix
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try
		{
			response = restTemplate.getForEntity(url, String.class, latlng_passager, latlng_conducteurs );
		}
		catch (RestClientException e) {
			System.out.println("erreur "+e);
			return new ResponseEntity<List<Conducteur>>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		// parcours du JSON en sortie du service google matrix
		ObjectMapper objMap = new ObjectMapper();
		int distance;
		List<Conducteur> listCondDispo = new ArrayList<>();
		try {
			JsonNode rootMode = objMap.readValue(response.getBody(),  JsonNode.class);
			JsonNode elements  = rootMode.get("rows").get(0).get("elements");
			System.out.println(elements);
			for (int i = 0; i < elements.size(); i++) {
				System.out.println("distance i="+i+" "+elements.get(i).get("distance").get("value").asInt());
				if (elements.get(i).get("distance").get("value").asInt() <= 3000) {  // TODO mettre en constante
					System.out.println("conducteur disponible "+myConducteurs.get(i).getNomUtil());		
					System.out.println(myConducteurs.get(i));
					listCondDispo.add(myConducteurs.get(i));
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("erreur de parcours JSON "+e);
			return new ResponseEntity<List<Conducteur>>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		System.out.println("sortie de service");

		return new ResponseEntity<List<Conducteur>>(listCondDispo, HttpStatus.OK);
	}

}
