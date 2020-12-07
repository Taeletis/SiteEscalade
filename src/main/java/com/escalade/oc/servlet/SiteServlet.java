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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierCommentaire;
import com.escalade.oc.metier.MetierReservation;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;

@WebServlet(urlPatterns = "/site")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSecteur metierSecteur;
	@Autowired
	private MetierSite metierSite;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		 	HttpSession session = request.getSession();
		 	
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
		 	Iterator it= l.iterator();
			while(it.hasNext()) {
				Secteur s=(Secteur)it.next();
				String cotation=metierSecteur.cotationMetierSecteur(s);
				h.put(s,cotation);
			}
			request.setAttribute("secteurs",h); 
		
		 	}
		 	catch (Exception e){}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Site.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	}
}