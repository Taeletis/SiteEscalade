package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Voie;

public interface MetierVoie {
	public Voie ajouterMetierVoie(String nom,String lienPhoto,String annotation,Secteur s);
	public Voie modifierMetierVoie(String nom,String lienPhoto,String annotation,Voie v);
	public Voie trouverMetierVoie(Long id);
	public void supprimerMetierVoie(Voie v);
	public List<Voie> listeParSecteurMetierVoie(Secteur s);
	public String cotationMetierVoie (Voie v);

}
