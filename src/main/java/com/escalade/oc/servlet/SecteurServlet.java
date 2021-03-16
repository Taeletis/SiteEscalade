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

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.metier.MetierLongueur;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierVoie;
/**
 * Servlet controlant la page d'information d'un secteur.
 * @author Taeletis
 *	
 */

@WebServlet(urlPatterns = "/secteur")
public class SecteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	 * @see HttpServlet#HttpServlet()
	 */
	public SecteurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGet qui permet l'envoi d'information sur les voies et leur longueurq d'un secteur.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 	try {
		 		String id= request.getParameter("id");
			 	Long secteurId= Long.parseLong(id);
			 	
		 	Secteur secteur=metierSecteur.trouverMetierSecteur(secteurId);
		 	request.setAttribute("idSite",secteur.getSite().getIdSite());
		 	request.setAttribute("nom",secteur.getNom());
		 	request.setAttribute("descrption",secteur.getDescription());
		 	request.setAttribute("lienImage",secteur.getLienCarte());
			List <Voie> voies= new ArrayList<Voie>();
		 	voies.addAll(metierVoie.listeParSecteurMetierVoie(secteur));
	
		 	HashMap<Voie,String> h= new HashMap <Voie,String>();

		 	for (Voie v: voies) {
				String cotation="";
				cotation=metierVoie.cotationMetierVoie(v);
				 h.put(v,cotation);
		 	}
		 	
		 	HashMap<HashMap<Voie,String>,List<Longueur>> h2 = new HashMap<HashMap<Voie,String>,List<Longueur>>();

			for (Voie v: h.keySet()) {
				String cotation="";
				 cotation=h.get(v);
				HashMap<Voie,String>h3= new HashMap <Voie,String>();
				
		 		List<Longueur> l=metierLongueur.listeParVoieMetierLongueur(v);
		 		h3.put(v,cotation);
				h2.put(h3,l);
				
			}
				request.setAttribute("voies",h2); 
			}
		 	catch (Exception e){System.out.println(e);}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Secteur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}
}