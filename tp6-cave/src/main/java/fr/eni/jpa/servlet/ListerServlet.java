package fr.eni.jpa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.bean.Region;
import fr.eni.jpa.service.GestionBouteille;
import fr.eni.jpa.service.GestionCouleur;
import fr.eni.jpa.service.GestionRegion;


/**
 * Servlet implementation class ListerServlet
 */
@WebServlet("/ListerServlet")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	GestionBouteille gbouteille;
	@Autowired
	GestionCouleur gcouleur;
	@Autowired
	GestionRegion gregion;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		SpringBeanAutowiringSupport
			.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
    public ListerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    List<Bouteille> listeBouteilles = gbouteille.listeBouteille();

		
		//créer une bouteille si besoin :
		String nom = request.getParameter("nom");
		String millesime = request.getParameter("millesime");
		String petillant = request.getParameter("petillant");
		String quantiteRecup = request.getParameter("quantite");
		String couleur = request.getParameter("couleur");
		String region = request.getParameter("region");
		
		if (nom != null && millesime != null && petillant != null && quantiteRecup != null && couleur != null && region != null 
				&& nom.trim().length() > 0 && millesime.trim().length() > 0
				&& couleur.trim().length() > 0 && region.trim().length() > 0 ){
			boolean petillantBO = petillant.equals("petillant_oui");
			
			int quantite = Integer.parseInt(quantiteRecup);
			Region regionTrouve = gregion.rechercherRegionByNom(region);
			Couleur couleurTrouve = gcouleur.rechercherCouleurByNom(couleur);

			
			Bouteille bouteille = new Bouteille(nom, petillantBO, millesime, quantite, regionTrouve, couleurTrouve);
            gbouteille.ajouterBouteille(bouteille);		
            listeBouteilles = gbouteille.listeBouteille();

		}
		
		//récupérer la liste des couleurs et des régions :
	    List<Couleur> couleurs = gcouleur.listeCouleurs();
	    Couleur couleurRouge = gcouleur.rechercherCouleurById(2);
	    Couleur couleurBlanc = gcouleur.rechercherCouleurById(1);
	    Couleur couleurRose=  gcouleur.rechercherCouleurById(3);
	    
	    List<Region> regions = gregion.listeregions();
	    Region regionBourgogne = regions.get(0);
	    Region regionBordeaux = regions.get(1);
	    Region regionAutre = regions.get(2);
	    Region regionBeaujolais = regions.get(3);
	    
	    Bouteille bouteille1 = new Bouteille("Gato negro", false, "2020", 10, regionAutre, couleurRouge);
	    Bouteille bouteille2 = new Bouteille("Cote de nuit", false, "2018", 12, regionBourgogne, couleurRouge);
	    Bouteille bouteille3 = new Bouteille("Saint emillion", false, "2015", 8, regionBordeaux, couleurRouge);
	    Bouteille bouteille4 = new Bouteille("Brouilly", false, "2017", 10, regionBeaujolais, couleurRouge);
	    Bouteille bouteille5 = new Bouteille("Macon village", false, "2019", 15, regionBourgogne, couleurBlanc);

	    
	    if (listeBouteilles == null) {
	    gbouteille.ajouterBouteille(bouteille1);
		gbouteille.ajouterBouteille(bouteille2);
		gbouteille.ajouterBouteille(bouteille3);
		gbouteille.ajouterBouteille(bouteille4);
		gbouteille.ajouterBouteille(bouteille5);
	    }
	    
	    String nomTriAsc = request.getParameter("nomTriAsc");
	    String nomTriDesc = request.getParameter("nomTriDesc");
	    String millesimeTriAsc = request.getParameter("millesimeTriAsc");
	    String millesimeTriDesc = request.getParameter("millesimeTriDesc");
	    String petillantTriAsc = request.getParameter("petillantTriAsc");
	    String petillantTriDesc = request.getParameter("petillantTriDesc");
	    String quantiteTriAsc = request.getParameter("quantiteTriAsc");
	    String quantiteTriDesc = request.getParameter("quantiteTriDesc");
	    String couleurTriAsc = request.getParameter("couleurTriAsc");
	    String couleurTriDesc = request.getParameter("couleurTriDesc");
	    String regionTriAsc = request.getParameter("regionTriAsc");
	    String regionTriDesc = request.getParameter("regionTriDesc");
	    String filtreNomVin = request.getParameter("filtre_nom_bouteille");

	    
	    
	    
	    
	    if (nomTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByNomAsc();
	    } else if (nomTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByNomDesc();
	    } else if (millesimeTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByMillesimeAsc();
	    } else if (millesimeTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByMillesimeDesc();
	    } else if (petillantTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByPetillantAsc();
	    } else if (petillantTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByPetillantDesc();
	    } else if (quantiteTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByQuantiteAsc();
	    } else if (quantiteTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByQuantiteDesc();
	    } else if (couleurTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByCouleurAsc();
	    } else if (couleurTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByCouleurDesc();
	    } else if (regionTriAsc != null) {
	    	listeBouteilles = gbouteille.trierListeByRegionAsc();
	    } else if (regionTriDesc != null) {
	    	listeBouteilles = gbouteille.trierListeByRegionDesc();
	    } else if (filtreNomVin != null) {	   
	    	listeBouteilles = gbouteille.rechercherBouteilleByNom(filtreNomVin);
	    }
		
		

		
		request.getSession().setAttribute("listeBouteilles", listeBouteilles);
		RequestDispatcher rd = request.getRequestDispatcher("listedesbouteilles.jsp");
		rd.forward(request, response);
	}

}
