package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.StatutType;



public interface MetierStatutType {

	public StatutType ajouterMetierStatutType(String statut);
	public StatutType modifierMetierStatutType(String statut,StatutType s);
	public void supprimerMetierStatutType(StatutType s);
	public StatutType trouverMetierStatutType(Long id);
	public List<StatutType> listeTousMetierStatutType();
}
