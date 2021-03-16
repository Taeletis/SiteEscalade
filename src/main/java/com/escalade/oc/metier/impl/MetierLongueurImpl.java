package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoLongueur;
import com.escalade.oc.dao.DaoReservation;
import com.escalade.oc.metier.MetierLongueur;
/**
 *  Class pour la couche metier de la Longueur.
 * @author Taeletis
 * 
 *        
 *
 */
@Service
public class MetierLongueurImpl implements MetierLongueur {
	/**
	 * injection de DaoLongueur.
	 * 
	 */
	@Autowired
	private DaoLongueur daoLongueur;
	/**
	 *  Méthode qui ajoute une Longueur.
	 * @param hauteur
	 * 		double  hauteur en m de la Longueur.
	 * @param cotation
	 * 		String  cotation de la longueur.	
	 * @param v
	 * 		Voie auquel appartient la longueur.
	 * @return
	 *  	renvoie la lmongueur creer.
	 */
	@Override
	public Longueur ajouterMetierLongueur(double hauteur, String cotation, Voie v) {
		Longueur l = new Longueur(hauteur, cotation, v);

		try {
			l = daoLongueur.save(l);
		} catch (Exception e) {
		}
		return l;
	}
	/**
	 *  Méthode qui modifie une Longueur.
	 * @param hauteur
	 * 		double  hauteur en m de la Longueur.
	 * @param cotation
	 * 		String  cotation de la longueur.	
	 * @param l
	 * 		Longueur à modifié.
	 * @return
	 * 		renvoie la Longueur modifié.
	 */
	@Override
	public Longueur modifierMetierLongueur(double hauteur, String cotation, Longueur l) {
		l.setHauteur(hauteur);
		l.setCotation(cotation);

		try {
			l = daoLongueur.save(l);
		} catch (Exception e) {
		}
		return l;
	}
	/**
	 *  Méthode qui trouve une Longueur avec son id.
	 * @param id
	 * 		Long id de la Longueur recherché.
	 * @return
	 * 		renvoie la longueur trpouvé.
	 */
	@Override
	public Longueur trouverMetierLongueur(Long id) {
		Longueur longueur = null;
		List<Longueur> list = new ArrayList<Longueur>();
		try {
			list.addAll(daoLongueur.findAll());
			for (int i = 0; i < list.size(); i++) {
				longueur = list.get(i);
				Long idLongueur = longueur.getIdLongueur();
				if (idLongueur == id) {
					break;
				}
			}
		} catch (Exception e) {

		}
		return longueur;
	}
	/**
	 * Méthode qui supprime une Longueur.
	 * @param l
	 * 		Longueur à supprimer.
	 */
	
	@Override
	public void supprimerMetierLongueur(Longueur l) {
		try {
			daoLongueur.delete(l);
		} catch (Exception e) {
		}
		
	}
	/**
	 * Méthode qui trouve les Longueurs par Voie.
	 * @param v
	 * 		Voie en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de longeuur appartenant à la même Voie.
	 */
	@Override
	public List<Longueur> listeParVoieMetierLongueur(Voie v) {
		List<Longueur> list;
		List<Longueur> listReturn = new ArrayList<Longueur>();;
		Longueur l;
		try {
			list = daoLongueur.findAll();
			for (int i = 0; i < list.size(); i++) {
				l = list.get(i);
				if (v.getIdVoie() == l.getVoie().getIdVoie()) {
					listReturn.add(l);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

}
