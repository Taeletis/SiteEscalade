package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Commentaire;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierCommentaire;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;
/**
 * Servlet controlant la page d'information d'un site.
 * @author Taeletis
 *	
 */

@WebServlet(urlPatterns = "/site")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * injection de MetierSecteur.
	 */
	@Autowired
	private MetierSecteur metierSecteur;
	/**
	 * injection de MetierSite.
	 */
	@Autowired
	private MetierSite metierSite;
	/**
	 * injection de MetierCommentaire.
	 */
	@Autowired
	private MetierCommentaire metierCommentaire;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGet qui permet l'envoi d'information sur les secteurs d'un site.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		 	
		 	}
			catch(Exception e) {
				
			}
		 	try {
		 		String id= request.getParameter("id");
			 	Long siteId= Long.parseLong(id);
			 	
		 	Site site=metierSite.trouverMetierSite(siteId);
		 	request.setAttribute("site",site);
		 	request.setAttribute("cotation",metierSite.cotationMetierSite(site));
		 	request.setAttribute("commentaires",metierCommentaire.listeParSiteMetierCommentaire(site));
		 	List<Secteur> l= new ArrayList <Secteur>();
		 	l.addAll(metierSecteur.listeParSiteMetierSecteur(site));
		 	HashMap<Secteur,String> h = new HashMap<Secteur,String>();

			for(Secteur s : l) {
				String cotation=metierSecteur.cotationMetierSecteur(s);
				h.put(s,cotation);
			}
			request.setAttribute("secteurs",h); 
		
		 	}
		 	catch (Exception e){}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Site.jsp").forward(request, response);
	}

	/**
	 * dopost qui permet l'ajout, la suppression ou la modification d'un commentaire.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Grimpeur g = (Grimpeur) session.getAttribute("grimpeur");
		String type = request.getParameter("type");
		String idSite = request.getParameter("idSite");
		Long siteId = Long.parseLong(idSite);
		Site s=metierSite.trouverMetierSite(siteId);
		if ("changerMention".equals(type)) {
			
			String choix = request.getParameter("choix");
			boolean mention=false;
			if("false".equals(choix))
				mention =false;
			if("true".equals(choix))
				mention =true;
			metierSite.modifierMentionMetierSite(s, mention);
			}
		
		if ("ajouterCommentaire".equals(type)) {
		String commentaire = request.getParameter("commentaire");
		
		metierCommentaire.ajouterMetierCommentaire(commentaire, s, g);
		
		}
		if ("supprimerCommentaire".equals(type)) {
			
			String idCommentaire = request.getParameter("idCommentaire");
			Long commentaireId = Long.parseLong(idCommentaire);
			Commentaire c=metierCommentaire.trouverMetierCommentaire(commentaireId);
			metierCommentaire.supprimerMetierCommentaire(c);
			
			}
		if ("modifierCommentaire".equals(type)) {
			String commentaire = request.getParameter("commentaire");
			String idCommentaire = request.getParameter("idCommentaire");
			Long commentaireId = Long.parseLong(idCommentaire);
			Commentaire c=metierCommentaire.trouverMetierCommentaire(commentaireId);
			metierCommentaire.modifierMetierCommentaire(commentaire, c);
			
			}
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/site?id="+idSite);
		
	}
}