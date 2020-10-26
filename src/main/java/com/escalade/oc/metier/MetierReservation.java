package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;


public interface MetierReservation {
	public Reservation ajouterMetierReservation(Grimpeur g,Topo t,StatutType s);
	public Reservation modifierMetierReservation(StatutType s,Reservation r);
	public void supprimerMetierReservationt(Reservation r);
	public Reservation trouverMetierReservation(Long id);
	public List<Reservation> listeParStatutMetierReservation(StatutType s);
	public List<Reservation> listeParGrimpeurMetierReservation(Grimpeur g);
	public List<Reservation> listeParTopoMetierReservation(Topo t);
}
