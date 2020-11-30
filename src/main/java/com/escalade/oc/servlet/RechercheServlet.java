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

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierSite;

@WebServlet(urlPatterns = "/recherche")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSite metierSite;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheServlet() {
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
		 if (!request.getParameterMap().containsKey("sites")) {
				request.setAttribute("sites",metierSite.listeMetierSite());
				
			}
		try {
		HttpSession session = request.getSession();
		
		Grimpeur g=(Grimpeur)session.getAttribute("grimpeur");
		System.out.println(g.getNom());
		
		request.setAttribute("utilisateur",g.getNom());
		
		
		
		}catch (Exception e) {
			
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String lieu = request.getParameter("lieu");

		try {
			List<Site> l= new ArrayList <Site>();
		
			l.addAll(metierSite.chercherParNomMetierSite(nom));
			
			l.addAll(metierSite.chercherParLieuMetierSite(lieu));
			request.setAttribute("sites", l);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
			
			System.out.println("recherche");

		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();
		}

	}
}