package com.escalade.oc.metier;

import java.util.List;


import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;

/**
 * interface pour la couche metier de Secteur.
 * @author Taeletis
 *
 *
 */
public interface MetierSecteur {

	/**
	 * Méthode qui ajoute un Secteur.
	 * @param nom
	 * 		String nom du Secteur.
	 * @param lienCarte
	 * 		String lien url de l'image du Secteur.
	 * @param description
	 * 		String description du Secteur.
	 * @param s
	 * 		Site auquel appartient le Secteur.
	 * @return
	 * 		renvoie le Secteur créé.
	 */
	public Secteur ajouterMetierSecteur(String nom,String lienCarte,String description,Site s);
	/**
	 * Méthode qui modifie un Secteur.
	 * @param nom
	 * 		String nom du Secteur.
	 * @param lienCarte
	 * 		String lien url de l'image du Secteur.
	 * @param description
	 * 		String description du Secteur.
	 * @param secteur
	 * 		Secteur à modifier.
	 * @return
	 * 		renvoie le Secteur modifié.
	 */
	public Secteur modifierMetierSecteur(String nom,String lienCarte,String description, Secteur secteur);
	/**
	 * Méthode qui trouve un Secteur.
	 * @param id
	 * 		Long id du Secteur.
	 * @return
	 * 		renvoie le Secteur trouvé.
	 */
	public Secteur trouverMetierSecteur(Long id);
	/**
	 *  Méthode qui supprime un Secteur.
	 * @param secteur
	 * 		Secteur à supprimer.
	 */
	public void supprimerMetierSecteur(Secteur secteur);
	/**
	 * Méthode qui trouve les Secteur par Site.
	 * @param s
	 * 		Site en paramètre de recherche.
	 * @return
	 * renvoie une liste de Secteur appartenant au même Site.
	 */
	public List<Secteur> listeParSiteMetierSecteur(Site s);
	/**
	 * Méthode qui retourne la cotation de la Voie.
	 * @param s
	 * 		Secteur demandé.
	 * @return
	 * 		renvoie la cotation du secteur.
	 */
	public String cotationMetierSecteur (Secteur s);
}
