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
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.metier.MetierGrimpeur;
import com.escalade.oc.metier.MetierReservation;

@WebServlet(urlPatterns = "/compte")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierGrimpeur metierGrimpeur;
	
	@Autowired
	private MetierReservation metierReservation;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteServlet() {
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
		HttpSession session = request.getSession();
		Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");
		List<Reservation> liste=new ArrayList<Reservation>();
	 	liste.addAll(metierReservation.listeParGrimpeurMetierReservation(g));
	 	request.setAttribute("Reservations",liste); 

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Compte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");

		if (request.getParameter("action1") != null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String motDePasse = request.getParameter("motdepasse");
			String confirmation = request.getParameter("confirmation");

			try {
				if (motDePasse.equals(confirmation)) {

					if (!metierGrimpeur.verifierInscriptionMetierGrimpeur(email)||g.getEmail().equals(email)) {

						metierGrimpeur.modifierMetierGrimpeur(nom, prenom, email, motDePasse,g);
						System.out.println("inscription");
						this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request,
								response);

					} else {
						System.out.println("email deja pris");

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