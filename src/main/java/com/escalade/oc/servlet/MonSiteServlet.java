package com.escalade.oc.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.metier.MetierLongueur;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierVoie;

@WebServlet(urlPatterns = "/monSite")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MonSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private MetierSite metierSite;
	@Autowired
	private MetierSecteur metierSecteur;
	@Autowired
	private MetierVoie metierVoie;
	@Autowired
	private MetierLongueur metierLongueur;
	public static final int TAILLE_TAMPON = 10240;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonSiteServlet() {
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
		try {
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			Long siteId = Long.parseLong(id);

			Site site = metierSite.trouverMetierSite(siteId);
			request.setAttribute("site", site);
			request.setAttribute("cotSecteuration", metierSite.cotationMetierSite(site));
			List<Secteur> l = new ArrayList<Secteur>();
			l.addAll(metierSecteur.listeParSiteMetierSecteur(site));

			HashMap<HashMap<Secteur, String>, HashMap<HashMap<Voie, String>, List<Longueur>>> liste = new HashMap<HashMap<Secteur, String>, HashMap<HashMap<Voie, String>, List<Longueur>>>();
			for (Secteur s : l) {
				HashMap<Secteur, String> h = new HashMap<Secteur, String>();
				String cotation = metierSecteur.cotationMetierSecteur(s);
				h.put(s, cotation);
				List<Voie> voies = new ArrayList<Voie>();
				voies.addAll(metierVoie.listeParSecteurMetierVoie(s));

				HashMap<HashMap<Voie, String>, List<Longueur>> h2 = new HashMap<HashMap<Voie, String>, List<Longueur>>();
				for (Voie v : voies) {
					HashMap<Voie, String> h3 = new HashMap<Voie, String>();
					List<Longueur> l2 = metierLongueur.listeParVoieMetierLongueur(v);
					cotation = metierVoie.cotationMetierVoie(v);
					h3.put(v, cotation);
					h2.put(h3, l2);
				}
				liste.put(h, h2);

			}

			System.out.println(liste + "test");
			request.setAttribute("secteurs", liste);

		} catch (Exception e) {
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/MonSite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		System.out.println(type);

		if (type.equals("longueur")) {
			String hauteur = request.getParameter("hauteur");
			String cotation = request.getParameter("cotation");
			String idd2 = request.getParameter("idVoie");
			Long voieId = Long.parseLong(idd2);
			Voie v = metierVoie.trouverMetierVoie(voieId);
			metierLongueur.ajouterMetierLongueur(Double.parseDouble(hauteur), cotation, "", v);

		}
		if (type.equals("voie")) {
			String nom = request.getParameter("nom");
			String annotation = request.getParameter("annotation");
			String idd2 = request.getParameter("idSecteur");
			Long idSecteur = Long.parseLong(idd2);
			Secteur s = metierSecteur.trouverMetierSecteur(idSecteur);
			metierVoie.ajouterMetierVoie(nom, annotation, s);

		}
		if (type.equals("secteur")) {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String idd2 = request.getParameter("idSite");
			Long idSite = Long.parseLong(idd2);
			Site s = metierSite.trouverMetierSite(idSite);
			String carte ="";
			try {
			Part filePart = request.getPart("carte"); 
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
			//
			//String root = System.getProperty("user.dir") + "/src/main/resources/META-INF/resources";
			String root=getServletContext().getRealPath("");
			fileName = new File(fileName).getName();
			
			filePart.write(root + File.separator + fileName);
			carte = fileName;
}catch (Exception e){
				
			}
			metierSecteur.ajouterMetierSecteur(nom, carte, description, s);

		}

		if ("modifierLongueur".equals(type)) {
			String hauteur = request.getParameter("hauteur");
			String cotation = request.getParameter("cotation");
			String idLongueur = request.getParameter("idLongueur");
			Long longueurId = Long.parseLong(idLongueur);
			Longueur l = metierLongueur.trouverMetierLongueur(longueurId);
			metierLongueur.modifierMetierLongueur(Double.parseDouble(hauteur), cotation, "", l);
			

		}
		if ("modifierVoie".equals(type)) {
			String nom = request.getParameter("nom");
			String annotation = request.getParameter("annotation");
			String idd2 = request.getParameter("idSecteur");
			Long idVoie = Long.parseLong(idd2);
			Voie v = metierVoie.trouverMetierVoie(idVoie);
			metierVoie.modifierMetierVoie(nom, annotation, v);

		}
		if (type.equals("modifierSecteur")) {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String idd2 = request.getParameter("idSecteur");
			System.out.println(idd2);
			Long idSecteur = Long.parseLong(idd2);
			Secteur s = metierSecteur.trouverMetierSecteur(idSecteur);
			String fileName;
			if ("on".equals(request.getParameter("modifierImage"))) {
				Part filePart = request.getPart("carte"); // Retrieves <input type="file" name="file">
				fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				//String root = System.getProperty("user.dir") + "/src/main/resources/META-INF/resources";
				String root=getServletContext().getRealPath("");
				fileName = new File(fileName).getName();

				filePart.write(root + File.separator + fileName);
				
			}
			else {
				fileName=s.getLienCarte();
			
			}
			metierSecteur.modifierMetierSecteur(nom, fileName, description, s);

		}
if ("supprimerSecteur".equals(type)) {
			
			if("supprimer".equals(request.getParameter("supprimer"))) {
			
			String idSecteur = request.getParameter("idSecteur");
			Long secteurId = Long.parseLong(idSecteur);
				Secteur secteur = metierSecteur.trouverMetierSecteur(secteurId);
				
					List<Voie> listVoie =metierVoie.listeParSecteurMetierVoie(secteur);
					for(Voie v : listVoie) {
						List<Longueur> listLongueur =metierLongueur.listeParVoieMetierLongueur(v);
						for(Longueur l : listLongueur) {
							metierLongueur.supprimerMetierLongueur(l);
						}
						metierVoie.supprimerMetierVoie(v);
					}
					metierSecteur.supprimerMetierSecteur(secteur);
				}
			
		}
if ("supprimerVoie".equals(type)) {
	
	if("supprimer".equals(request.getParameter("supprimer"))) {
	
	String idVoie = request.getParameter("idVoie");
	Long voieId = Long.parseLong(idVoie);
	Voie v = metierVoie.trouverMetierVoie(voieId);
		
				List<Longueur> listLongueur =metierLongueur.listeParVoieMetierLongueur(v);
				for(Longueur l : listLongueur) {
					metierLongueur.supprimerMetierLongueur(l);
				}
				metierVoie.supprimerMetierVoie(v);
			}
			
		}
if ("supprimerLongueur".equals(type)) {
	
	if("supprimer".equals(request.getParameter("supprimer"))) {
	
	String idLongueur = request.getParameter("idLongueur");
	Long longueurId = Long.parseLong(idLongueur);
	Longueur l = metierLongueur.trouverMetierLongueur(longueurId);
				
					metierLongueur.supprimerMetierLongueur(l);
			
			}
			
		}


		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/monSite?id=" + request.getParameter("id"));

	}
}
