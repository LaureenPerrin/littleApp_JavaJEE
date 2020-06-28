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

import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.bean.Region;
import fr.eni.jpa.service.GestionBouteille;
import fr.eni.jpa.service.GestionCouleur;
import fr.eni.jpa.service.GestionRegion;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterServlet() {
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
		
		List<Couleur> listeCouleurs = gcouleur.listeCouleurs();
		List<Region> listeRegions = gregion.listeregions();
		
		request.getSession().setAttribute("listeCouleurs", listeCouleurs);
		request.getSession().setAttribute("listeRegions", listeRegions);
		RequestDispatcher rd = request.getRequestDispatcher("ajout_bouteille.jsp");
		rd.forward(request, response);
	}

}
