package com.escalade.oc.metier;

import java.util.List;


import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;


public interface MetierSecteur {

	public Secteur ajouterMetierSecteur(String nom,String lienCarte,String acces,String description,Site s);
	public Secteur modifierMetierSecteur(String nom,String lienCarte,String acces,String description, Secteur secteur);
	public Secteur trouverMetierSecteur(Long id);
	public void supprimerMetierSecteur(Secteur secteur);
	public List<Secteur> listeParSiteMetierSecteur(Site s);
	public int cotationMetierSecteur (Secteur s);
}
