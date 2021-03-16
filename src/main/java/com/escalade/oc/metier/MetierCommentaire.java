package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Commentaire;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;

/**
 *  interface pour la couche metier du commentaire.
 * @author Taeletis
 * 
 *
 *
 */
public interface MetierCommentaire {

	/**
	 * Méthode qui ajoute un commentaire.
	 * 
	 * @param description
	 * 		String qui contient le commentaire.
	 * @param s
	 * 		Site concerné
	 * @param auteur
	 * 		Grimpeur auteur du commentaire.
	 * @return
	 * 		renvoi le commentaire créer.
	 * 	
	 */
	
	public Commentaire ajouterMetierCommentaire(String description, Site s, Grimpeur auteur);

	/**
	 * Méthode qui ajoute un commentaire.
	 * 
	 * @param description
	 * 		String qui contient le commentaire édité. 
	 * @param c
	 * 		Commentaire concerné par la modification.
	 * @return
	 * 		renoive le commentaire modifié.
	 */
	public Commentaire modifierMetierCommentaire(String description, Commentaire c);

	/**
	 *  Méthode qui retouve un commentaire par son id.
	 * 
	 * @param id
	 * 		id du commentaire recherché.
	 * @return
	 * 		renoive le commentaire trouvé.
	 * 
	 */
	public Commentaire trouverMetierCommentaire(Long id);

	/**
	 *  Méthode qui supprime un commentaire.
	 * 
	 * @param c
	 * 		le commentaire à supprimer.
	 */
	public void supprimerMetierCommentaire(Commentaire c);

	/**
	 *  Méthode qui retouve les Commentaires par Site.
	 * 
	 * @param s
	 * 		Site en paramètre de recherchee.
	 * @return
	 * 		renvoie une liste de Commentaires qui ont le même Site.
	 */
	public List<Commentaire> listeParSiteMetierCommentaire(Site s);
}