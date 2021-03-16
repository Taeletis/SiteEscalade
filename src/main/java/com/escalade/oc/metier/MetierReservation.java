package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;



/**
 * interface pour la couche metier de Reservation.
 * @author Taeletis
 * 
 * 
 *
 */
public interface MetierReservation {
	/**
	 * Méthode qui ajoute une reservation.
	 * 
	 * @param g
	 * 		L'emprunteur.
	 * @param t
	 * 		le topo réservé.
	 * @param s
	 * 		L'état de la réservation.
	 * @return
	 * 		renvoie un objet réservation
	 */
	public Reservation ajouterMetierReservation(Grimpeur g,Topo t,StatutType s);
	/**
	 * Méthode qui modifie une reservation.
	 * 
	 * @param s
	 * 		Le nouvel état de la reservation.
	 * @param r
	 * 		la reservation à modifier.	
	 * @return
	 * 		renvoie la reservation modifier.
	 */
	public Reservation modifierMetierReservation(StatutType s,Reservation r);
	/**
	 * Méthode qui supprime une reservation.
	 * 
	 * @param r
	 * 		la réservation à suprimmer.
	 */
	public void supprimerMetierReservationt(Reservation r);
	/**
	 * Méthode qui trouve une reservation.
	 * 
	 * @param id
	 * 		Id de la reservation recherché.
	 * 	
	 * @return
	 * 		renvoie une réservation.
	 */
	public Reservation trouverMetierReservation(Long id);
	/**
	 * Méthode qui trouve les réservations par Statut.
	 * 
	 * @param s
	 * 		Statut en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de résevations qui ont le même Statut.
	 */
	public List<Reservation> listeParStatutMetierReservation(StatutType s);
	/**
	 * Méthode qui trouve les réservations par Grimpeur.
	 * 
	 * @param g
	 * 		Grimpeur en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de résevations qui ont le même Grimpeur.
	 */
	public List<Reservation> listeParGrimpeurMetierReservation(Grimpeur g);
	/**
	 * Méthode qui trouve les réservations par Grimpeur.
	 * @param t
	 * 		Topo en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de résevations qui ont le même Topo.
	 */
	public List<Reservation> listeParTopoMetierReservation(Topo t);
}
