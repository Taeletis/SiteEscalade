package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;


public interface MetierSite {
	public Site ajouterMetierSite(String nom,String lienImage,String lieu, Topo t);
	public Site modifierMetierSite(String nom,String lienImage,String lieu, Site s);
	public Site modifierMentionMetierSite(Site s, boolean mention);
	public Site trouverMetierSite(Long id);
	public void supprimerMetierSite(Site s);
	public List<Site> listeParTopoMetierSite(Topo t);
	public int cotationMetierSite (Site s);
}
