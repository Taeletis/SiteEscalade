package com.escalade.oc.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoSecteur;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierVoie;
@Service
public class MetierSecteurImpl implements MetierSecteur {
	@Autowired
	private DaoSecteur daoSecteur;

	@Autowired
	private MetierVoie metierVoie;

	@Override
	public Secteur ajouterMetierSecteur(String nom, String lienCarte, String acces, String description, Site s) {
		Secteur secteur = new Secteur(nom, lienCarte, acces, description, s);
		try {
			secteur = daoSecteur.save(secteur);
		} catch (Exception e) {
		}
		return secteur;
	}

	@Override
	public Secteur modifierMetierSecteur(String nom, String lienCarte, String acces, String description, Secteur secteur) {
		secteur.setNom(nom);
		secteur.setLienCarte(lienCarte);
		secteur.setAcces(acces);
		secteur.setDescription(description);
		try {
			secteur = daoSecteur.save(secteur);
		} catch (Exception e) {
		}
		return secteur;
	}

	@Override
	public Secteur trouverMetierSecteur(Long id) {
		Secteur secteur = null;
		try {
			secteur = daoSecteur.getOne(id);
		} catch (Exception e) {
		}
		return secteur;
	}

	@Override
	public void supprimerMetierSecteur(Secteur secteur) {
		try {
			daoSecteur.delete(secteur);
		} catch (Exception e) {
		}
		;
	}

	@Override
	public List<Secteur> listeParSiteMetierSecteur(Site s) {
		List<Secteur> list;
		List<Secteur> listReturn = null;
		Secteur secteur;
		try {
			list = daoSecteur.findAll();
			for (int i = 0; i < list.size(); i++) {
				secteur = list.get(i);
				if (s.getIdSite() == secteur.getSite().getIdSite()) {
					listReturn.add(secteur);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public int cotationMetierSecteur(Secteur s) {
		List<Voie> list = metierVoie.listeParSecteurMetierVoie(s);
		int cotation = 0;
		for (int i = 0; i < list.size(); i++) {
			Voie v = list.get(i);
			if (cotation < metierVoie.cotationMetierVoie(v)) {
				cotation = metierVoie.cotationMetierVoie(v);
			}
		}
		return cotation;
	}

}
