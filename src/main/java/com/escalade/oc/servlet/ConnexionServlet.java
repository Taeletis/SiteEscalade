package com.escalade.oc.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
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
 *  Servlet controlant la page d'inscription et de connexion.
 * @author Taeletis
 */

@WebServlet(urlPatterns = "/connexion",loadOnStartup = 1)
public class ConnexionServlet extends HttpServlet {
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
	 * injection de MetierTopo.
	 */
	@Autowired
	private MetierTopo metierTopo;
	/**
	 * injection de MetierReservation.
	 */
	@Autowired
	private MetierReservation metierReservation;

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
	 * doPost qui permet d'inscrire ou de connecter un utilisateur.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("inscription".equals(request.getParameter("action"))) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String motDePasse = request.getParameter("motdepasse");
			String confirmation = request.getParameter("confirmation");

			try {
				if (motDePasse.equals(confirmation)) {

					if (!metierGrimpeur.verifierInscriptionMetierGrimpeur(email)) {
						String cryptedMdp = securite(motDePasse);
						metierGrimpeur.ajouterMetierGrimpeur(nom, prenom, email, cryptedMdp);
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
		if ("connexion".equals(request.getParameter("action"))) {
			String email = request.getParameter("email");
			String motDePasse = request.getParameter("motdepasse");

			String cryptedMdp = securite(motDePasse);

			try {

				if (metierGrimpeur.connexionMetierGrimpeur(email, cryptedMdp)) {

					HttpSession session = request.getSession();
					Grimpeur g = metierGrimpeur.trouverParEmailMetierGrimpeur(email);
					boolean connecter = true;
					session.setAttribute("grimpeur", g);
					session.setAttribute("connecter", connecter);
					initSession(session, g);

					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Acceuil.jsp").forward(request,
							response);
				} else {
					this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request,
							response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Methode qui permet de donner à la sesion les notifications necessaires.
	 * 
	 * @param session HttpSession
	 * @param g       Grimpeur
	 */
	private void initSession(HttpSession session, Grimpeur g) {
		List<Site> list = metierSite.chercherParGrimpeurMetierSite(g);
		List<Topo> list2 = new ArrayList<Topo>();
		List<Reservation> list3 = new ArrayList<Reservation>();
		for (Site s : list) {
			list2.addAll(metierTopo.listeParSiteMetierTopo(s));
		}
		for (Topo t : list2) {
			list3.addAll(metierReservation.listeParTopoMetierReservation(t));
		}

		int notif = 0;
		for (Reservation r : list3) {
			StatutType s = r.getStatut();

			if ("En attente de réponse".equals(s.getStatut()))
				notif++;
		}
		session.setAttribute("notif", notif);
		session.setAttribute("resa", list3);
		List<Reservation> listResa = new ArrayList<Reservation>();
		listResa.addAll(metierReservation.listeParGrimpeurMetierReservation(g));

		int enAttente = 0;
		for (Reservation r : listResa) {
			StatutType s = r.getStatut();

			if ("En attente de réponse".equals(s.getStatut()))

				enAttente++;
		}
		session.setAttribute("enAttente", enAttente);
	}

	/**
	 * méthode qui crypte le mot de passe.
	 * 
	 * @param motDePasse mot de passe à crypter.
	 * @return renvoie le mot de passe crypté.
	 */
	private String securite(String motDePasse) {

		try {
			String cryptedMdp = "";
			KeyGenerator k;
			k = KeyGenerator.getInstance("AES");
			Properties prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath + "/src/main/resources/config.properties");
			prop.load(input);
			String key = prop.getProperty("key");
			SecretKey sk;
			if ("".equals(key)) {

				sk = k.generateKey();
				String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
				prop.setProperty("key", encodedKey);
			} else {

				byte[] decodedKey = Base64.getDecoder().decode(prop.getProperty("key"));
				sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			}
			Cipher cipher = Cipher.getInstance("AES");
			byte[] text = motDePasse.getBytes("UTF-8");
			cipher.init(Cipher.ENCRYPT_MODE, sk);
			byte[] textCrypted = cipher.doFinal(text);
			cryptedMdp = new String(textCrypted);

			return cryptedMdp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}
}