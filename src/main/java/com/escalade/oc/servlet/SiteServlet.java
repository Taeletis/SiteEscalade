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
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;

@WebServlet(urlPatterns = "/site")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSecteur metierSecteur;
	@Autowired
	private MetierSite metierSite;
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
		 	request.setAttribute("nom",site.getNom());
		 	request.setAttribute("lieu",site.getLieu());
		 	request.setAttribute("lienImage",site.getLienImage());
		 	List<Secteur> l= new ArrayList <Secteur>();
		 	l.addAll(metierSecteur.listeParSiteMetierSecteur(site));
			request.setAttribute("secteurs",l); 
		
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