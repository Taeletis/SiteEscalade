package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;


public interface MetierSite {
	public Site ajouterMetierSite(String nom,String lienImage,String lieu,Grimpeur createur);
	public Site modifierMetierSite(String nom,String lienImage,String lieu, Site s);
	public Site modifierMentionMetierSite(Site s, boolean mention);
	public Site trouverMetierSite(Long id);
	public void supprimerMetierSite(Site s);
	public List<Site> listeMetierSite();
	public String cotationMetierSite (Site s);
	public List<Site> chercherParNomMetierSite(String name);
	public List<Site> chercherParLieuMetierSite(String endroit);
	public List<Site> chercherParGrimpeurMetierSite(Grimpeur g);
	public List<Site> chercherParGrimpeurMetierSite(String g);
}
