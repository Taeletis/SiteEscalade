package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Voie;
/**
 * 
 * interface pour la couche metier de Voie.
 * @author Taeletis
 *
 *
 */
public interface MetierVoie {
	/**
	 * Méthode qui ajoute une Voie.
	 * @param nom
	 * 		String nom de la Voie.
	 * @param annotation
	 * 		String annotation de la Voie.
	 * @param s
	 * 		Secteur auquel appartient la Voie.
	 * @return
	 * 		renvoie la Voie créé.
	 */
	public Voie ajouterMetierVoie(String nom,String annotation,Secteur s);
	/**
	 * Méthode qui modifie une Voie.
	 * @param nom
	 * 		String nom de la Voie à modifier.
	 * @param annotation
	 * 		String annotation de la Voie à modifier.
	 * @param v
	 * 		Voie à modifier.
	 * @return
	 * 		renvoie la Voie modifié.
	 */
	public Voie modifierMetierVoie(String nom,String annotation,Voie v);
	/**
	 * Méthode qui trouve une Voie.
	 * @param id
	 * 		Long id dr la Voie recherché.
	 * @return
	 * 		renvoie la Voie modifié.
	 */
	public Voie trouverMetierVoie(Long id);
	/**
	 * Méthode qui supprime une Voie.
	 * @param v
	 * 		Voie à supprimer.
	 */
	public void supprimerMetierVoie(Voie v);
	/**
	 * Méthode qui trouve les Voies par Secteur.
	 * @param s
	 * 		Secteur en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Voie appartenant au même Secteur.
	 */
	public List<Voie> listeParSecteurMetierVoie(Secteur s);
	/**
	 * Méthode qui retourne la cotation de la Voie.
	 * @param v
	 * 		Voie demandé.
	 * @return
	 * 		renvoie la cotation de la Voie.
	 */
	public String cotationMetierVoie (Voie v);

}
