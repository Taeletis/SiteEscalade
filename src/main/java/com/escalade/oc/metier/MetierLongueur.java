package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Voie;

/**
 * interface pour la couche metier de Longueur.
 * @author Taeletis
 *
 *
 */
public interface MetierLongueur {

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
	public Longueur ajouterMetierLongueur(double hauteur,String cotation,Voie v);
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
	public Longueur modifierMetierLongueur(double hauteur,String cotation,Longueur l);
	/**
	 *  Méthode qui trouve une Longueur avec son id.
	 * @param id
	 * 		Long id de la Longueur recherché.
	 * @return
	 * 		renvoie la longueur trpouvé.
	 */
	public Longueur trouverMetierLongueur(Long id);
	/**
	 * Méthode qui supprime une Longueur.
	 * @param l
	 * 		Longueur à supprimer.
	 */
	
	public void supprimerMetierLongueur(Longueur l);
	/**
	 * Méthode qui trouve les Longueurs par Voie.
	 * @param v
	 * 		Voie en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de longeuur appartenant à la même Voie.
	 */
	public List<Longueur> listeParVoieMetierLongueur(Voie v);
}
