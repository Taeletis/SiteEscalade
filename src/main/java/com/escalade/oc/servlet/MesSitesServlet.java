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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierTopo;
@WebServlet(urlPatterns = "/mesSites")
public class MesSitesServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MetierSite metierSite;
	@Autowired
	private MetierTopo metierTopo;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MesSitesServlet() {
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
		 	
		 	
			 	Grimpeur g=(Grimpeur) session.getAttribute("grimpeur");
			 	System.out.println(g);
			 	List<Site> sites=metierSite.chercherParGrimpeurMetierSite(g);
			 	HashMap<Site,List<Topo>> liste= new HashMap<Site,List<Topo>>();
			 	for(Site s:sites) {
			 		List<Topo> t=metierTopo.listeParSiteMetierTopo(s);
			 		liste.put(s,t);
			 	}
			 	System.out.println(sites);
			 
			request.setAttribute("sites",liste); 
		
		 	}
		 	catch (Exception e){}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/MesSites.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	 	
	 	
	 	Grimpeur g=(Grimpeur) session.getAttribute("grimpeur");
		String type = request.getParameter("type");
		System.out.println(type);
		if ("site".equals(type)) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			
			Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    String root =  System.getProperty("user.dir") + "/src/main/resources/META-INF/resources";
		    fileName = new File(fileName).getName();
			filePart.write( root+File.separator+  fileName);
			String carte= root+File.separator+  fileName;
			metierSite.ajouterMetierSite(nom, fileName, lieu, g);
			
		}
		if ("topo".equals(type)) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String idSite = request.getParameter("idSite");
			Long siteId = Long.parseLong(idSite);
			boolean check=true;
			if(!"on".equals(request.getParameter("disponible")))
					check=false;
			Site site = metierSite.trouverMetierSite(siteId);
			metierTopo.ajouterMetierTopo(nom, lieu,check, g,site);
			
		}
		if ("modifierTopo".equals(type)) {
			String nom = request.getParameter("nom");
			String lieu = request.getParameter("lieu");
			String idTopo = request.getParameter("idTopo");
			Long topoId = Long.parseLong(idTopo);
			boolean check=true;
			if(!"on".equals(request.getParameter("disponible")))
					check=false;
			Topo t = metierTopo.trouverMetierTopo(topoId);
			metierTopo.modifierMetierTopo(nom, lieu,check, g,t);
			
		}
		if (type.equals("modifierSecteur")) {
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
				String root = System.getProperty("user.dir") + "/src/main/resources/META-INF/resources";
				fileName = new File(fileName).getName();

				filePart.write(root + File.separator + fileName);
				
			}
			else {
				fileName=s.getLienImage();
			
			}
			metierSite.modifierMetierSite(nom,  fileName, lieu, s);

		}

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect("/mesSites");

	}
	
}

