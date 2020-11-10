package com.escalade.oc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escalade.oc.metier.MetierGrimpeur;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = "/inscription", loadOnStartup = 1)
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierGrimpeur metierGrimpeur;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String actionID = request.getParameter("hidden");
		// System.out.println(request.getParameter("action1"));

		if (request.getParameter("action1") != null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String motDePasse = request.getParameter("motdepasse");
			String confirmation = request.getParameter("confirmation");

			try {
				if (motDePasse.equals(confirmation)) {

					if (!metierGrimpeur.verifierInscriptionMetierGrimpeur(email)) {

						metierGrimpeur.ajouterMetierGrimpeur(nom, prenom, email, motDePasse);
						System.out.println("inscription");
						this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request,
								response);
						
					} else {
						System.out.println("deja existant");
						
					}
				} else {
					System.out.println("les mots de Passe ne correspondent pas");
				}

			} catch (Exception e) {
				System.out.println("truc");
				e.printStackTrace();

			}

		}

	}
}
