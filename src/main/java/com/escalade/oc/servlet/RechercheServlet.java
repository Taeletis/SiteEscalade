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

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierSite;

@WebServlet(urlPatterns = "/recherche")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSite metierSite;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RechercheServlet() {
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
		 if (!request.getParameterMap().containsKey("sites")) {
			 List<Site> l= metierSite.listeMetierSite();
			 HashMap<Site,HashMap<Grimpeur,String>> h = new HashMap<Site,HashMap<Grimpeur,String>>();
				
				Iterator it= l.iterator();
				while(it.hasNext()) {
					Site s=(Site)it.next();
					String cotation=metierSite.cotationMetierSite(s);
					Grimpeur g=s.getCreateur();
					HashMap<Grimpeur,String> h2 = new HashMap<Grimpeur,String>();
					h2.put(g,cotation);
					h.put(s,h2);
					System.out.println(h);
					
				}
				request.setAttribute("sites",h);
				
			}
		try {
		HttpSession session = request.getSession();
		
		Grimpeur g=(Grimpeur)session.getAttribute("grimpeur");
		
		
		request.setAttribute("utilisateur",g.getNom());
		
		
		
		
		}catch (Exception e) {
			
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String lieu = request.getParameter("lieu");

		try {
			List<Site> l= new ArrayList <Site>();
		
			l.addAll(metierSite.chercherParNomMetierSite(nom));
			
			l.addAll(metierSite.chercherParLieuMetierSite(lieu));
			HashMap<Site,HashMap<Grimpeur,String>> h = new HashMap<Site,HashMap<Grimpeur,String>>();
			
			Iterator it= l.iterator();
			while(it.hasNext()) {
				Site s=(Site)it.next();
				String cotation=metierSite.cotationMetierSite(s);
				Grimpeur g=s.getCreateur();
				HashMap<Grimpeur,String> h2 = new HashMap<Grimpeur,String>();
				h2.put(g,cotation);
				h.put(s,h2);
				System.out.println(h);
				
			}
			request.setAttribute("sites", h);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
			
			System.out.println("recherche");

		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();
		}

	}
}