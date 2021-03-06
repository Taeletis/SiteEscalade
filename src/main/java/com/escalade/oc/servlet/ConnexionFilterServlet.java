package com.escalade.oc.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtre qui empeche l'acces au pages sans se connecter.
 * @author Taeletis
 *
 *
 */
@WebFilter(urlPatterns = { "/recherche", "/site","/secteur","/topo","/compte","/mesSites","/monSite","/reservation","/deconnexion","/grimpeur","/WEB-INF/jsp/Acceuil.jsp","/"})
public class ConnexionFilterServlet implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * méthode qui filtre les pages si la requete ne contient pas de session.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);

		if (session == null) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/connexion");
		} else {
			chain.doFilter(request, response);
		}
	}


	@Override
	public void destroy() {
	}

}