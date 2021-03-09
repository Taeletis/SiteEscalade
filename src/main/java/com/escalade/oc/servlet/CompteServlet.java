package com.escalade.oc.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
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
		try {
	 	liste.addAll(metierReservation.listeParGrimpeurMetierReservation(g));
	 	System.out.println(liste);
	 	request.setAttribute("Reservations",liste); 
		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();

		}
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
						String cryptedMdp =securite	(motDePasse);	
						metierGrimpeur.modifierMetierGrimpeur(nom, prenom, email, cryptedMdp,g);
						System.out.println("inscription");
						this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Compte.jsp").forward(request,
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
	public  String securite(String motDePasse) {
		
		try {
			String cryptedMdp="";
			KeyGenerator k;
			k = KeyGenerator.getInstance("AES");
			Properties prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath + "/src/main/resources/config.properties");
			prop.load(input);
			String key=prop.getProperty("key");
			SecretKey sk;
			if("".equals(key)) {
		
				sk= k.generateKey();
				String encodedKey = Base64.getEncoder().encodeToString(sk.getEncoded());
				System.out.println(encodedKey);
				prop.setProperty("key", encodedKey);
				System.out.println(prop.getProperty("key"));
			}
		else {
		
		byte[] decodedKey = Base64.getDecoder().decode(prop.getProperty("key"));
		sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			}
			Cipher cipher=Cipher.getInstance("AES");
			byte[] text=motDePasse.getBytes("UTF-8");
			cipher.init(Cipher.ENCRYPT_MODE, sk);
			byte[] textCrypted=cipher.doFinal(text);
			cryptedMdp=new String(textCrypted);
			System.out.println(cryptedMdp);	
			
			
			return cryptedMdp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		} 
		
	}
}