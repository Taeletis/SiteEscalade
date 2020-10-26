package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Commentaire;
import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;


public interface MetierCommentaire {

	public Commentaire ajouterMetierCommentaire(String description,Site s,Grimpeur auteur);
	public Commentaire modifierMetierCommentaire(String description,Commentaire c);
	public Commentaire trouverMetierCommentaire(Long id);
	public void supprimerMetierCommentaire(Commentaire c);
	public List<Commentaire> listeParSiteMetierCommentaire(Site s);
}
