package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierGrimpeur;
import com.escalade.oc.metier.MetierSite;
/**
 * Servlet controlant la page d'information des Grimpeurs.
 * @author Taeletis
 *	
 */

@WebServlet(urlPatterns = "/grimpeur")
public class GrimpeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * injection de MetierGrimpeur.
	 */
	@Autowired
	private MetierGrimpeur metierGrimpeur;
	/**
	 * injection de MetierSite.
	 */
	@Autowired
	private MetierSite metierSite;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GrimpeurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * goGet donne l'information d'un grimpeur.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 	try {
		 		String id= request.getParameter("id");
		 		Long grimpeurId= Long.parseLong(id);
		 		Grimpeur g=metierGrimpeur.trouverMetierGrimpeur(grimpeurId);
		 		request.setAttribute("g",g);
		 		
		 	}
		 	catch (Exception e){System.out.println(e);}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Grimpeur.jsp").forward(request, response);
	}

	/**
	 * doPost renvoie vers la liste des sites avec le grimpeur de la page en paramtre de recherche.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String grimpeur = request.getParameter("idGrimpeur");
		Long grimpeurId= Long.parseLong(grimpeur);
 		Grimpeur grimp=metierGrimpeur.trouverMetierGrimpeur(grimpeurId);
		;
		try {
			List<Site> l= new ArrayList <Site>();
		
		if(!"".equals(grimpeur))
			l.addAll(metierSite.chercherParGrimpeurMetierSite(grimp));
		
		
			HashMap<Site,HashMap<Grimpeur,String>> h = new HashMap<Site,HashMap<Grimpeur,String>>();

			for(Site s: l) {
				
				String cotation=metierSite.cotationMetierSite(s);
				Grimpeur g=s.getCreateur();
				HashMap<Grimpeur,String> h2 = new HashMap<Grimpeur,String>();
				h2.put(g,cotation);
				h.put(s,h2);
				
			}
			request.setAttribute("sites", h);

			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}
}