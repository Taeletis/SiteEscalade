package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.metier.MetierGrimpeur;
import com.escalade.oc.metier.MetierReservation;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierStatutType;
import com.escalade.oc.metier.MetierTopo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = "/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierGrimpeur metierGrimpeur;
	@Autowired
	private MetierSite metierSite;
	
	@Autowired
	private MetierTopo metierTopo;
	
	@Autowired
	private MetierReservation metierReservation;
	
	@Autowired
	private MetierStatutType metierStatutType;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motdepasse");

		try {

			if (metierGrimpeur.connexionMetierGrimpeur(email, motDePasse)) {

				HttpSession session = request.getSession();
				Grimpeur g =metierGrimpeur.trouverParEmailMetierGrimpeur(email);
				boolean connecter=true;
				session.setAttribute("grimpeur",g);
				session.setAttribute("connecter",connecter);
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/recherche");
				List<Site> list= metierSite.chercherParGrimpeurMetierSite(g);
				List<Topo> list2= new ArrayList<Topo>();
				List<Reservation> list3= new ArrayList<Reservation>();
				for(Site s:list) {
					list2.addAll(metierTopo.listeParSiteMetierTopo(s));
				}
				for(Topo t:list2) {
					list3.addAll(metierReservation.listeParTopoMetierReservation(t));
				}
				
				int notif=0;
				for(Reservation r:list3) {
					StatutType s= r.getStatut();
					
					if("En attente de réponse".equals(s.getStatut()))
					notif++;
				}
				System.out.println(notif);
				session.setAttribute("notif",notif);
				session.setAttribute("resa",list3);
			} else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request, response);
			}
			System.out.println("connexion");

		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();
		}

	}
}