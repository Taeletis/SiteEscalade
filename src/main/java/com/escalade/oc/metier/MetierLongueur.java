package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Voie;


public interface MetierLongueur {

	public Longueur ajouterMetierLongueur(double hauteur,int cotation,String annotation,Voie v);
	public Longueur modifierMetierLongueur(double hauteur,int cotation,String annotation,Longueur l);
	public Longueur trouverMetierLongueur(Long id);
	public void supprimerMetierLongueur(Longueur l);
	public List<Longueur> listeParVoieMetierLongueur(Voie v);
}
