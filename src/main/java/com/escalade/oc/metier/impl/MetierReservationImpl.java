package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.dao.DaoReservation;
import com.escalade.oc.metier.MetierReservation;

/**
 *  Class pour la couche metier de Reservation.
 * @author Taeletis
 * 
 *        
 *
 */
@Service
public class MetierReservationImpl implements MetierReservation {
	/**
	 * injection de DaoReservation.
	 */
	@Autowired
	private DaoReservation daoReservation;

	/**
	 * Méthode qui trouve les réservations par Grimpeur.
	 * 
	 * @param t Topo en paramètre de recherche.
	 * 
	 * @return renvoie une liste de résevations qui ont le même Topo.
	 */
	@Override
	public Reservation ajouterMetierReservation(Grimpeur g, Topo t, StatutType s) {
		Reservation r = new Reservation(g, t, s);
		try {
			r = daoReservation.save(r);
		} catch (Exception e) {

		}
		return r;
	}

	/**
	 * Méthode qui modifie une reservation.
	 * 
	 * @param s Le nouvel état de la reservation.
	 * @param r la reservation à modifier.
	 * 
	 * @return renvoie la reservation modifier.
	 */
	@Override
	public Reservation modifierMetierReservation(StatutType s, Reservation r) {
		r.setStatut(s);
		try {
			r = daoReservation.save(r);
		} catch (Exception e) {

		}
		return r;
	}

	/**
	 * Méthode qui supprime une reservation.
	 * 
	 * @param r la réservation à suprimmer.
	 */
	@Override
	public void supprimerMetierReservationt(Reservation r) {
		try {
			daoReservation.delete(r);
		} catch (Exception e) {

		}

	}

	/**
	 * Méthode qui trouve une reservation.
	 * 
	 * @param id Id de la reservation recherché.
	 * 
	 * @return renvoie une réservation.
	 */
	@Override
	public Reservation trouverMetierReservation(Long id) {
		Reservation r = null;
		List<Reservation> list = new ArrayList<Reservation>();

		try {
			list.addAll(daoReservation.findAll());
			for (int i = 0; i < list.size(); i++) {
				r = list.get(i);
				Long idReservation = r.getIdReservation();
				if (idReservation == id) {
					break;
				}

			}
		} catch (Exception e) {
		}
		return r;
	}

	/**
	 * Méthode qui trouve les réservations par Statut.
	 * 
	 * @param s Statut en paramètre de recherche.
	 * @return renvoie une liste de résevations qui ont le même Statut.
	 */
	@Override
	public List<Reservation> listeParStatutMetierReservation(StatutType s) {
		List<Reservation> list;
		List<Reservation> listReturn = new ArrayList<Reservation>();
		Reservation r;
		try {
			list = daoReservation.findAll();

			for (int i = 0; i < list.size(); i++) {
				r = list.get(i);
				if (s.getIdStatut() == r.getStatut().getIdStatut()) {
					listReturn.add(r);
				}
			}

		} catch (Exception e) {

		}
		return listReturn;
	}

	/**
	 * Méthode qui trouve les réservations par Grimpeur.
	 * 
	 * @param g Grimpeur en paramètre de recherche.
	 * 
	 * @return renvoie une liste de résevations qui ont le même Grimpeur.
	 */
	@Override
	public List<Reservation> listeParGrimpeurMetierReservation(Grimpeur g) {
		List<Reservation> list;
		List<Reservation> listReturn = new ArrayList<Reservation>();
		Reservation r;
		try {
			list = daoReservation.findAll();

			for (int i = 0; i < list.size(); i++) {
				r = list.get(i);
				if (g.getIdGrimpeur().equals(r.getEmprunteur().getIdGrimpeur())) {
					listReturn.add(r);
				}
			}

		} catch (Exception e) {

		}
		return listReturn;
	}

	/**
	 * Méthode qui trouve les réservations par Grimpeur.
	 * 
	 * @param t Topo en paramètre de recherche.
	 * 
	 * @return renvoie une liste de résevations qui ont le même Topo.
	 */
	@Override
	public List<Reservation> listeParTopoMetierReservation(Topo t) {
		List<Reservation> list;
		List<Reservation> listReturn = new ArrayList<Reservation>();
		Reservation r;
		try {
			list = daoReservation.findAll();

			for (int i = 0; i < list.size(); i++) {
				r = list.get(i);
				if (t.getIdTopo() == r.getTopo().getIdTopo()) {
					listReturn.add(r);
				}
			}

		} catch (Exception e) {

		}
		return listReturn;
	}

}
