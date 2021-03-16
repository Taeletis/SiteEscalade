package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.metier.MetierGrimpeur;
import com.escalade.oc.metier.MetierReservation;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierStatutType;
import com.escalade.oc.metier.MetierTopo;


/**
 * Servlet controlant la page de topo d'un site.
 * @author Taeletis
 *	
 */

@WebServlet(urlPatterns = "/topo")
public class TopoServlet extends HttpServlet {
	/**
	 * injection de MetierSite.
	 */
	@Autowired
	private MetierSite metierSite;
	/**
	 * injection de MetierTopo.
	 */
	@Autowired
	private MetierTopo metierTopo;
	/**
	 * injection de MetierGrimpeur.
	 */
	@Autowired	
	private MetierGrimpeur metierGrimpeur;
	/**
	 * injection de MetierStatutType.
	 */
	@Autowired
	private MetierStatutType metierStatutType;
	/**
	 * injection de MetierReservation.
	 */
	@Autowired
	private MetierReservation metierReservation;

	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGet qui permet l'envoi d'information des topos d'un site.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
		 		String id= request.getParameter("id");
			 	Long siteId= Long.parseLong(id);
			 	
		 	Site site=metierSite.trouverMetierSite(siteId);
		 	List<Topo> liste=new ArrayList<Topo>();
		 	liste.addAll(metierTopo.listeParSiteMetierTopo(site));
		 	request.setAttribute("topos",liste); 
		 	request.setAttribute("site",site); 
			}
			catch(Exception e) {
				
			}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Topo.jsp").forward(request, response);
	}

	/**
	 * doPost qui permet de reservé un topo.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 	HttpSession session = request.getSession();
		 	String id=request.getParameter("idTopo"); 
		 	String id2=request.getParameter("idGrimpeur");
		 	Long topoId= Long.parseLong(id);
		 	Long grimpeurId= Long.parseLong(id2);
		 	Long statutId=(long) 1;
		 	Topo t=metierTopo.trouverMetierTopo(topoId);
			Grimpeur g=metierGrimpeur.trouverMetierGrimpeur(grimpeurId);
			StatutType s=metierStatutType.trouverMetierStatutType(statutId);
			metierReservation.ajouterMetierReservation( g,  t,  s) ;
			List<Reservation> listResa = new ArrayList<Reservation>();
			listResa.addAll(metierReservation.listeParGrimpeurMetierReservation(g));

			int enAttente =(int) session.getAttribute("enAttente");
			enAttente++;
			session.setAttribute("enAttente", enAttente);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/recherche");
		}

	
}
