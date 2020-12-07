package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;

public interface MetierTopo {

	public Topo ajouterMetierTopo(String nom,String lieu,boolean disponible,Grimpeur g,Site s);
	public Topo modifierMetierTopo(String nom,String lieu,boolean disponible,Grimpeur g, Topo t);
	public Topo trouverMetierTopo(Long id);
	public void supprimerMetierTopo(Topo t);
	public List<Topo> listeParSiteMetierTopo(Site s);
	public List<Topo> listeTousMetierTopo();
}
