package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierSite;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = "/liste", loadOnStartup = 1)
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSite metierSite;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeServlet() {
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
		
		request.setAttribute("sites",metierSite.listeMetierSite());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Liste.jsp").forward(request, response);
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
			List<Site> l=metierSite.chercherParNomMetierSite(nom);
			l.addAll(metierSite.chercherParNomMetierSite(lieu));
			request.setAttribute("liste",l);
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);


		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();
		}

	}


	
}