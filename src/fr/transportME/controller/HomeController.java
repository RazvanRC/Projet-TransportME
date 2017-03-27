package fr.transportME.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.transportME.DAO.DAO;
import fr.transportME.model.Client;
import fr.transportME.model.Conducteur;
import fr.transportME.model.Utilisateur;
import fr.transportME.validation.UtilisateurSubscribeValidator;
import fr.transportME.validation.WrongUsernameOrPasswordException;

@Controller
public class HomeController {	

	private Boolean errorLogin = false;
	
	
	private Utilisateur utilisateur;
	
	@Autowired
	DAO<Utilisateur> utilisateurDao;

	// acc�s page Accueil
	@RequestMapping(value = {"/","/accueil"}, method = RequestMethod.GET)
	public String accGet(Model model) {
		model.addAttribute("page", "accueil");
		return "accueil";	
	}
	
	// affichage formulaire de connection
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String loginGet(Model model, HttpSession session) {
		model.addAttribute("formLogin", new Utilisateur());
		model.addAttribute("utilisateur", null);
		model.addAttribute("page", "login");
		model.addAttribute("errormessage", null);
		
		if (session.getAttribute("user") == null && errorLogin == false) {
			model.addAttribute("errormessage", null);
			return "login";
		}
		else if (session.getAttribute("user") == null && errorLogin == true) {
			model.addAttribute("errormessage", "Le login et/ou le mot de passe est incorrect !");
			return "login";
		}
		else {
			errorLogin = false;
			return "choix";
		}		
	}
	
	// recup�ration donn�es de connection et v�rification existance dans la BDD
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String loginPost(Model model, HttpSession session,
			@RequestParam(value = "loginUtil", required = false) String loginUtil,
			@RequestParam(value = "mdpUtil", required = false) String mdpUtil
			) {
		
			System.out.println("connection");
			
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/TransportME/api/verifLoginClient?user={loginUtil}&mdp={mdpUtil}"; 
			System.out.println("appel service url client = "+url);
			ResponseEntity<Utilisateur> response=null;
			try
			{
				response = restTemplate.getForEntity(url, Utilisateur.class, loginUtil, mdpUtil );
			}
			catch (RestClientException e) {
				// traiter l'exception TODO
			}
			System.out.println("sortie appel service");
			
			
			boolean client = false; 
				if (response.getBody()==null)
					// client non trouv�, verif si login conducteur existe
				{
					restTemplate = new RestTemplate();
					url = "http://localhost:8080/TransportME/api/verifLoginConducteur?user={loginUtil}&mdp={mdpUtil}"; 
					System.out.println("appel service url conducteur = "+url);
					try
					{
					response = restTemplate.getForEntity(url, Utilisateur.class, loginUtil, mdpUtil );
					}
					catch (RestClientException e)
					{
						// traiter l'exception TODO
					}
						if (response.getBody()==null)
						{
							System.out.println("dans if");
							model.addAttribute("errormessage", "utilisateur non trouv�");
							return "login";
						}
						else
						{
							System.out.println("dans else");
							client = false;
						}

				}
				else
				{
					System.out.println("dans else true");
					client = true;
				}
				
				System.out.println("statut ok "+response.getBody().getIdUtil());				
				session.setAttribute("idUtil", response.getBody().getIdUtil());
				

			
			System.out.println("aiguillage vers profil client ou conducteur suivant user");
			model.addAttribute("utilisateur", utilisateur);
			if (client)  {
				System.out.println("vers profil client");
				return "profilClient";	
			}
			else
				System.out.println("vers profil conducteur");
				return "profilConducteur";	
				
		}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String inscGet(Model model, HttpSession session) {
			model.addAttribute("page", "inscription");
			
			System.out.println("inscriptionnnn");
			return "inscription";
		}
	
	@RequestMapping(value = "/profilClient", method = RequestMethod.GET)
	public String profilClientGet(Model model, HttpSession session) {
			model.addAttribute("page", "profil Client");
			
			System.out.println(" profil client");
			return "profilClient";
		}
	
	@RequestMapping(value = "/profilConducteur", method = RequestMethod.GET)
	public String profilConducteurGet(Model model, HttpSession session) {
			model.addAttribute("page", "profil Conducteur");
			
			System.out.println(" profil conducteur");
			return "profilConducteur";
		}
	
	@RequestMapping(value = "/inscription/client", method = RequestMethod.POST)
	public String inscClientPost(@Valid @ModelAttribute("client") Client client, 
			BindingResult result, HttpSession session,
			@RequestParam String verif_password  // afin de recuperer le champ verif_password du jsp qui ne fait pas partie des propri�t�s de la classe Utilisateur
			) {
			
			System.out.println("validation inscription client");
			
			if (result.hasErrors()) {
				System.out.println("ERREURS de coherence champs formulaire et modele ");
				System.out.println("erreurs : "+result.getFieldError());
				System.out.println("==> retour formulaire inscription");
				return "inscription";
			}
			
			// validation personnalis�e
			System.out.println("appel validation du mot de passe");
			new fr.transportME.validation.UtilisateurSubscribeValidator().validate(client, result, verif_password);


			
			System.out.println("appel service ecriture inscription");
			
			
			return "profilClient"; 
		}
	
	@RequestMapping(value = "/inscription/conducteur", method = RequestMethod.POST)
	public String inscConducteurPost(@Valid @ModelAttribute("conducteur") Utilisateur conducteur, 
			BindingResult result, HttpSession session,
			@RequestParam String verif_password  // afin de recuperer le champ verif_password du jsp qui ne fait pas partie des propri�t�s de la classe Utilisateur
			) {
			
			System.out.println("validation inscription conducteur");
			
			// validation personnalis�e
			
			new UtilisateurSubscribeValidator().validate(conducteur, result, verif_password);

			if (result.hasErrors()) {
				return "inscription";
			}
			
			System.out.println("appel service ecriture inscription");
			
			
			return "profilConducteur"; 
		}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logoutGet(Model model, HttpSession session) {
		System.out.println("d�connexion");
		session.invalidate();
		return "redirect:login";
	}
}
