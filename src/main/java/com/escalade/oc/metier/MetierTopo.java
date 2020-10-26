package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Topo;

public interface MetierTopo {

	public Topo ajouterMetierTopo(String nom,String lieu,String description,boolean disponible,Grimpeur g);
	public Topo modifierMetierTopo(String nom,String lieu,String description,boolean disponible,Grimpeur g, Topo t);
	public Topo trouverMetierTopo(Long id);
	public void supprimerMetierTopo(Topo t);
	public List<Topo> chercherParNomMetierTopo(String name);
	public List<Topo> listeTousMetierTopo();
	public int cotationMetierTopo (Topo t);
	public List<Topo> chercherParCotationMetierTopo(int cotation);
}
