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

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.metier.MetierGrimpeur;
import com.escalade.oc.metier.MetierSite;

@WebServlet(urlPatterns = "/grimpeur")
public class GrimpeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierGrimpeur metierGrimpeur;
	@Autowired
	private MetierSite metierSite;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GrimpeurServlet() {
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
		 		Long grimpeurId= Long.parseLong(id);
		 		Grimpeur g=metierGrimpeur.trouverMetierGrimpeur(grimpeurId);
		 		request.setAttribute("g",g);
		 		
		 	}
		 	catch (Exception e){System.out.println(e);}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Grimpeur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String grimpeur = request.getParameter("grimpeur");
		;
		try {
			List<Site> l= new ArrayList <Site>();
		
		if(!"".equals(grimpeur))
			l.addAll(metierSite.chercherParGrimpeurMetierSite(grimpeur));
		
		
			HashMap<Site,HashMap<Grimpeur,String>> h = new HashMap<Site,HashMap<Grimpeur,String>>();
			
			System.out.println(l);
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
			System.out.println("recherche");
			System.out.println(h);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Recherche.jsp").forward(request, response);
			
			

		} catch (Exception e) {
			System.out.println("truc");
			e.printStackTrace();
		}

		

	}
}