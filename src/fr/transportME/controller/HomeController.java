package fr.transportME.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

@Controller
public class HomeController {	

	private Boolean errorLogin = false;
	
	
	private Utilisateur utilisateur;
	
	@Autowired
	DAO<Utilisateur> utilisateurDao;
	
	@Autowired
	DAO<Client> clientDao;
	
	@Autowired
	DAO<Conducteur> conducteurDao;

	// accès page Accueil
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
	
	// recupération données de connection et vérification existance dans la BDD
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
				if (response == null || response.getBody()==null)
					// client non trouvé, verif si login conducteur existe
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
						System.out.println("exception conducteur "+e);
					}
						if (response.getBody()==null)
						{
							System.out.println("dans if");
							model.addAttribute("errormessage", "utilisateur non trouvé");
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
				System.out.println("vers profil client, getIdUtil ="+response.getBody().getIdUtil());
				Client monClient = clientDao.find(response.getBody().getIdUtil());
				model.addAttribute("client", monClient);
				return "profilClient";	
			}
			else
			{
				System.out.println("vers profil conducteur, getIdUtil ="+response.getBody().getIdUtil());
				Conducteur monConducteur = conducteurDao.find(response.getBody().getIdUtil());
				System.out.println("annee permis = "+monConducteur.getAnneePermis());
				model.addAttribute("conducteur", monConducteur);
				return "profilConducteur";
			}
				
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
			Model model,
			@RequestParam String verif_password  // afin de recuperer le champ verif_password du jsp qui ne fait pas partie des propriétés de la classe Utilisateur
			) {
			
			System.out.println("validation inscription client");
			
			if (result.hasErrors()) {
				System.out.println("ERREURS de coherence champs formulaire et modele ");
				System.out.println("erreurs : "+result.getFieldError());
			    
				// affichage detail des erreurs
				StringBuilder buffer=new StringBuilder();
				boolean isFirst=true;
				for(ObjectError error : result.getAllErrors()) {
			        if(isFirst) {
			            isFirst=false;
			        } else {
			            buffer.append("; and,\n");
			        }
			        buffer.append(error);
			    }
				System.out.println("erreurs suivantes: "+buffer.toString());
				//
				
				System.out.println("==> retour formulaire inscription");
				return "inscription";
			}
			
			// validation personnalisée
			System.out.println("appel validation du mot de passe, verif_password = "+ verif_password+" password= "+client.getMdpUtil());
			new fr.transportME.validation.UtilisateurSubscribeValidator().validate(client, result, verif_password);
			if (result.hasErrors()) {
				System.out.println("ERREURS de coherence entre mdp saisis ");
				System.out.println("erreurs : "+result.getFieldError());
				System.out.println("==> retour formulaire inscription");
				return "inscription";
			}
			
			// appel service ecriture inscription
			System.out.println("appel service ecriture inscription");
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/TransportME/api/clients"; 
			System.out.println("appel service url clients = "+url);
			ResponseEntity<Client> response=null;
			boolean erreur_trait=false;
			try
			{
				response = restTemplate.postForEntity(url, client, Client.class);
			}
			catch (RestClientException e) {
				System.out.println("dans exception RestClientException "+e);
				erreur_trait = true;
			}
			System.out.println("sortie appel service");
			
			// aiguillage vers le profil client si aucune erreur de traitement
			if (erreur_trait) {
				System.out.println("erreur de traitement => sortie de programme");
				model.addAttribute("errormessage", "pbe traitement");
				return "redirect:/inscription/client"; 
			}
			else
			{
				System.out.println("affichage variable session client avant appel login = "+client.getLoginUtil());
				model.addAttribute("errormessage", null);
				return "redirect:/login"; 
				}
		}
	
	@RequestMapping(value = "/inscription/conducteur", method = RequestMethod.POST)
	public String inscConducteurPost(@Valid @ModelAttribute("conducteur") Conducteur conducteur, 
			BindingResult result, HttpSession session,
			Model model,
			@RequestParam String verif_password  // afin de recuperer le champ verif_password du jsp qui ne fait pas partie des propriétés de la classe Utilisateur
			) {
			
			System.out.println("validation inscription conducteur");
			
			if (result.hasErrors()) {
				System.out.println("ERREURS de coherence champs formulaire et modele ");
				System.out.println("erreurs : "+result.getFieldError());
			    
				// affichage detail des erreurs
				StringBuilder buffer=new StringBuilder();
				boolean isFirst=true;
				for(ObjectError error : result.getAllErrors()) {
			        if(isFirst) {
			            isFirst=false;
			        } else {
			            buffer.append("; and,\n");
			        }
			        buffer.append(error);
			    }
				System.out.println("erreurs suivantes: "+buffer.toString());
				//
				
				System.out.println("==> retour formulaire inscription");
				return "inscription";
			}
			
			// validation personnalisée
			System.out.println("appel validation du mot de passe, verif_password = "+ verif_password+" password= "+conducteur.getMdpUtil());
			new fr.transportME.validation.UtilisateurSubscribeValidator().validate(conducteur, result, verif_password);
			if (result.hasErrors()) {
				System.out.println("ERREURS de coherence entre mdp saisis ");
				System.out.println("erreurs : "+result.getFieldError());
				System.out.println("==> retour formulaire inscription");
				return "inscription";
			}
			
			// appel service ecriture inscription
			System.out.println("appel service ecriture inscription conducteur");
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/TransportME/api/conducteurs"; 
			System.out.println("appel service url conducteurs = "+url);
			ResponseEntity<Conducteur> response=null;
			boolean erreur_trait=false;
			try
			{
				response = restTemplate.postForEntity(url, conducteur, Conducteur.class);
			}
			catch (RestClientException e) {
				System.out.println("dans exception RestClientException "+e);
				erreur_trait = true;
			}
			System.out.println("sortie appel service");
			
			// aiguillage vers le profil client si aucune erreur de traitement
			if (erreur_trait) {
				System.out.println("erreur de traitement => sortie de programme");
				model.addAttribute("errormessage", "pbe traitement");
				return "redirect:/inscription/conducteur"; 
			}
			else
			{
				System.out.println("affichage variable session client - login = "+conducteur.getLoginUtil());
				model.addAttribute("errormessage", null);
				return "redirect:/login"; 
				}
		}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logoutGet(Model model, HttpSession session) {
		System.out.println("déconnexion");
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value = "/commande", method = RequestMethod.GET)
	public String commandeGet(Model model, HttpSession session) {
			
			System.out.println(" acces ecran Commande");
			return "commande";
		}
	
	@RequestMapping(value = "/dispo", method = RequestMethod.POST)
	public String dispoGet(Model model, @ModelAttribute("dispo") Conducteur conducteur, HttpSession session) {
			
			System.out.println(" acces ecran Disponibilité "+conducteur.getLoginUtil());
			model.addAttribute("conducteur", conducteur);
			return "dispo";
		}
}
