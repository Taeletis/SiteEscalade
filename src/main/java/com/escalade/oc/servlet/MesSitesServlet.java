package com.escalade.oc.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Commentaire;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.metier.MetierCommentaire;
import com.escalade.oc.metier.MetierLongueur;
import com.escalade.oc.metier.MetierReservation;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierTopo;
import com.escalade.oc.metier.MetierVoie;
/**
 * Servlet controlant la page de sites possédé par l'utilsateur.
 * @author Taeletis
 *	
 */

@WebServlet(urlPatterns = "/mesSites")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MesSitesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * injection de MetierSite.
	 */@Autowired
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
		 * injection de MetierSecteur.
		 */
	 @Autowired
	private MetierSecteur metierSecteur;
	/**
	 * injection de MetierVoie.
	 */
	@Autowired
	private MetierVoie metierVoie;
	/**
	 * injection de MetierLongueur.
	 */
	@Autowired
	private MetierLongueur metierLongueur;
	/**
	 * injection de MetierCommentaire.
	 */
	@Autowired
	private MetierCommentaire metierCommentaire;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesSitesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGet qui permet l'envoi d'information detous les sites et leur topo de l'utilsateur.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();

			Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");

			List<Site> sites = metierSite.chercherParGrimpeurMetierSite(g);
			HashMap<Site, List<Topo>> liste = new HashMap<Site, List<Topo>>();
			for (Site s : sites) {
				List<Topo> t = metierTopo.listeParSiteMetierTopo(s);
				liste.put(s, t);
			}

			request.setAttribute("sites", liste);

		} catch (Exception e) {
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/MesSites.jsp").forward(request, response);
	}

	/**
	 * doPost qui permet d'enregistrer ou de modifié des Sites et leur topos.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");
		String type = request.getParameter("type");
		if (type.equals("site")) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String fileName = "";
			try {
				Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">

				fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				
				// String root = System.getProperty("user.dir") + "/src/main/resources/META-INF/resources";
				String root = getServletContext().getRealPath("");

				fileName = new File(fileName).getName();
				filePart.write(root + File.separator + fileName);
			} catch (Exception e) {

			}

			metierSite.ajouterMetierSite(nom, fileName, lieu, g);

		}
		if (type.equals("topo")) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String idSite = request.getParameter("idSite");
			Long siteId = Long.parseLong(idSite);
			boolean check = true;
			if (!"on".equals(request.getParameter("disponible")))
				check = false;
			Site site = metierSite.trouverMetierSite(siteId);
			metierTopo.ajouterMetierTopo(nom, lieu, check, g, site);

		}
		if (type.equals("modifierTopo")) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String idTopo = request.getParameter("idTopo");
			Long topoId = Long.parseLong(idTopo);
			boolean check = true;
			if (!"on".equals(request.getParameter("disponible")))
				check = false;
			Topo t = metierTopo.trouverMetierTopo(topoId);
			metierTopo.modifierMetierTopo(nom, lieu, check, t);

		}
		if (type.equals("modifierSite")) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String idd2 = request.getParameter("idSite");
			System.out.println(idd2);
			Long idSite = Long.parseLong(idd2);
			Site s = metierSite.trouverMetierSite(idSite);
			String fileName;
			if ("on".equals(request.getParameter("modifierImage"))) {
				Part filePart = request.getPart("carte"); // Retrieves <input type="file" name="file">
				fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				String root = getServletContext().getRealPath("");
				// String root = System.getProperty("user.dir") +
				// "/src/main/resources/META-INF/resources";
				fileName = new File(fileName).getName();

				filePart.write(root + fileName);

			} else {
				fileName = s.getLienImage();

			}
			metierSite.modifierMetierSite(nom, fileName, lieu, s);

		}
		if ("supprimerTopo".equals(type)) {

			if ("supprimer".equals(request.getParameter("supprimer"))) {

				String idTopo = request.getParameter("idTopo");
				Long topoId = Long.parseLong(idTopo);
				Topo t = metierTopo.trouverMetierTopo(topoId);
				List<Reservation> listReservation = metierReservation.listeParTopoMetierReservation(t);
				for (Reservation r : listReservation) {
					metierReservation.supprimerMetierReservationt(r);
				}
				metierTopo.supprimerMetierTopo(t);
				actualiserTopo(session);
			}
		}
		if ("supprimerSite".equals(type)) {

			if ("supprimer".equals(request.getParameter("supprimer"))) {

				String idSite = request.getParameter("idSite");
				Long siteId = Long.parseLong(idSite);
				Site site = metierSite.trouverMetierSite(siteId);
				List<Topo> listTopo = metierTopo.listeParSiteMetierTopo(site);
				for (Topo t : listTopo) {

					List<Reservation> listReservation = metierReservation.listeParTopoMetierReservation(t);
					for (Reservation r : listReservation) {
						metierReservation.supprimerMetierReservationt(r);
					}
					metierTopo.supprimerMetierTopo(t);
					actualiserTopo(session);

				}
				List<Commentaire> listCommentaire = metierCommentaire.listeParSiteMetierCommentaire(site);
				for (Commentaire c : listCommentaire) {

					metierCommentaire.supprimerMetierCommentaire(c);
				}

				List<Secteur> listSecteur = metierSecteur.listeParSiteMetierSecteur(site);
				for (Secteur s : listSecteur) {
					List<Voie> listVoie = metierVoie.listeParSecteurMetierVoie(s);
					for (Voie v : listVoie) {
						List<Longueur> listLongueur = metierLongueur.listeParVoieMetierLongueur(v);
						for (Longueur l : listLongueur) {
							metierLongueur.supprimerMetierLongueur(l);
						}
						metierVoie.supprimerMetierVoie(v);
					}
					metierSecteur.supprimerMetierSecteur(s);
				}
				metierSite.supprimerMetierSite(site);
			}
		}
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/mesSites");

	}
	
	/**
	 * Méthode qui permet d'actualiser les notifications topos.
	 * @param session
	 * 		HttpSession modifié.
	 */
	private void actualiserTopo(HttpSession session) {
		Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");
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

}
