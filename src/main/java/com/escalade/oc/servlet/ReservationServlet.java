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


import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.metier.MetierReservation;
import com.escalade.oc.metier.MetierStatutType;

/**
 * Servlet controlant la page des demandes reservations.
 * @author Taeletis
 *	
 */
@WebServlet(urlPatterns = "/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * injection de MetierStatutType.
	 */
	@Autowired
	private MetierStatutType metierStatutType;
	/**
	 * injection de MetierReservation.
	 */
	@Autowired
	private MetierReservation metierReservation;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
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
		 		
		 		
		 	}
		 	catch (Exception e){System.out.println(e);}

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Reservation.jsp").forward(request, response);
	}

	/**
	 * doPost qui permet de modifier les états des reservations demandé.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		String choix = request.getParameter("choix");
		String idResa = request.getParameter("reservation");
		Long resaId = Long.parseLong(idResa);
		Reservation r=metierReservation.trouverMetierReservation(resaId);
		Long id;
		StatutType s;
		if("refuser".equals(choix)) {
			id=Long.valueOf(2);
			s=metierStatutType.trouverMetierStatutType(id);
			
			metierReservation.modifierMetierReservation(s, r);
		}
		else {
			id=Long.valueOf(3);
			s=metierStatutType.trouverMetierStatutType(id);
			metierReservation.modifierMetierReservation(s, r);
			
		}
		HttpSession session = request.getSession();
		int notif=(int)session.getAttribute("notif");
		notif--;
		List<Reservation> list= new ArrayList<Reservation>();
		 list.addAll((List<Reservation>) session.getAttribute("resa"));
		 Reservation removeResa=null;
		for(Reservation resa:list) {
	if(resa.getIdReservation()==r.getIdReservation())
		 removeResa = resa;
			
		}
		list.remove(removeResa);
		list.add(r);
		session.setAttribute("notif",notif);
		session.setAttribute("resa",list);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Reservation.jsp").forward(request, response);
			
		}catch (Exception e) {}

		

	}
}