package com.escalade.oc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.metier.MetierGrimpeur;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = "/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierGrimpeur metierGrimpeur;

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

		System.out.println(request.getParameter("action2"));

		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motdepasse");

		try {

			if (metierGrimpeur.connexionMetierGrimpeur(email, motDePasse)) {

				HttpSession session = request.getSession();
				Grimpeur g =metierGrimpeur.trouverParEmailMetierGrimpeur(email);
				session.setAttribute("grimpeur",g);
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/recherche");
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