package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Commentaire;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.dao.DaoCommentaire;
import com.escalade.oc.metier.MetierCommentaire;
/**
 * Class pour la couche metier du Commentaire.
 * @author Taeletis
 *
 *
 */
@Service
public class MetierCommentaireImpl implements MetierCommentaire{
	/**
	 * injection de DaoCommentaire.
	 * 
	 * @see DaoCommentaire
	 */
	@Autowired
	private DaoCommentaire daoCommentaire;
	
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
	 * 	renvoi le commentaire créer.
	 * 	
	 */
	@Override
	public Commentaire ajouterMetierCommentaire(String description, Site s, Grimpeur auteur) {
	
		Date date=new Date();
		Commentaire c=new Commentaire(date,description,s,auteur);
		try {
			c=daoCommentaire.save(c);
		}catch (Exception e) {
		}
		return c;
	}
	
	/**
	 * Méthode qui modfie un commentaire.

	 * @param description
	 * 		String qui contient le commentaire édité. 
	 * @param c
	 * 		Commentaire concerné par la modification.
	 * @return
	 * 		renvoie le commentaire modifié.
	 * 	
	 */
	@Override
	public Commentaire modifierMetierCommentaire(String description, Commentaire c) {
		Date date=new Date();
		c.setDescription(description);
		c.setDateModification(date);
		try {
			c=daoCommentaire.save(c);
		}catch (Exception e) {
		}
		return c;
	}
	/**
	 *  Méthode qui retouve un commentaire par son id.
	 * 
	 * @param id
	 * 		id du commentaire recherché.
	 * @return
	 * 		renoive le commentaire trouvé.
	 * 
	 */
	@Override
	public Commentaire trouverMetierCommentaire(Long id) {
		Commentaire c=null;
		List<Commentaire> list = new ArrayList<Commentaire>();
		try {
			list = daoCommentaire.findAll();
			for (int i = 0; i < list.size(); i++) {
				c = list.get(i);
				Long idCommentaire = c.getIdCommentaire();
				if (idCommentaire == id) {
					break;
				}

			}
		
	}catch (Exception e) {
	}
	return c;
	}

	/**
	 *  Méthode qui supprime un commentaire.
	 * 
	 * @param c
	 * 		le commentaire à supprimer.
	 */
	@Override
	public void supprimerMetierCommentaire(Commentaire c) {
		try {
			daoCommentaire.delete(c);
		}catch (Exception e) {
		}
	}

	/**
	 *  Méthode qui retouve les Commentaires par Site.
	 * 
	 * @param s
	 * 		Site en paramètre de recherchee.
	 * @return
	 * 		renvoie une liste de Commentaires qui ont le même Site.
	 */
	@Override
	public List<Commentaire> listeParSiteMetierCommentaire(Site s) {
		List<Commentaire> list;
		List<Commentaire> listReturn = new ArrayList<Commentaire>();
		Commentaire t ;
		try {
			list = daoCommentaire.findAll();
		
				for (int i = 0; i < list.size(); i++) {
					t = list.get(i);
					if (s.getIdSite()==t.getSite().getIdSite()) {
						listReturn.add(t);
					}
				}
			
		} catch (Exception e) {

		}
		return listReturn;
	}


}
