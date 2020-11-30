package com.escalade.oc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
@WebServlet(urlPatterns = "/secteur")
public class SecteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSecteur metierSecteur;
	@Autowired
	private MetierVoie metierVoie;
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
		 	HashMap<Voie,List<Longueur>> h= new HashMap <Voie,List<Longueur>>();
			List <Voie> voies= new ArrayList<Voie>();
		 	voies.addAll(metierVoie.listeParSecteurMetierVoie(secteur));
		 	Iterator it=voies.iterator();
		 	while(it.hasNext())
		 	{
		 		Voie v =(Voie) it.next();
		 		List<Longueur> l=metierLongueur.listeParVoieMetierLongueur(v);
		 		h.put(v,l);	
		 	}
		 	System.out.println("camarche");
		 	request.setAttribute("voies",h); 
		
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