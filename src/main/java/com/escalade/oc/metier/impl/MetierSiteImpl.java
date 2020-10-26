package com.escalade.oc.metier.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.dao.DaoSite;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;

public class MetierSiteImpl implements MetierSite {
	@Autowired
	private DaoSite daoSite;

	@Autowired
	private MetierSecteur metierSecteur;

	@Override
	public Site ajouterMetierSite(String nom, String lienImage, String lieu, Topo t) {
		Site s = new Site(nom, lienImage, lieu, t);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	public Site modifierMetierSite(String nom, String lienImage, String lieu, Site s) {
		s.setNom(nom);
		s.setLienImage(lienImage);
		s.setLieu(lieu);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;

	}

	@Override
	public Site modifierMentionMetierSite(Site s, boolean mention) {
		s.setMention(mention);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	public Site trouverMetierSite(Long id) {
		Site s = null;
		try {
			s = daoSite.getOne(id);
		} catch (Exception e) {
		}
		return s;
	}

	@Override
	public void supprimerMetierSite(Site s) {
		try {
			daoSite.delete(s);
		} catch (Exception e) {
		}
	}

	@Override
	public List<Site> listeParTopoMetierSite(Topo t) {
		List<Site> list;
		List<Site> listReturn = null;
		Site s;
		try {
			list = daoSite.findAll();
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				if (t.getIdTopo() == s.getTopo().getIdTopo()) {
					listReturn.add(s);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public int cotationMetierSite(Site s) {
		List<Secteur> list = metierSecteur.listeParSiteMetierSecteur(s);
		int cotation = 0;
		for (int i = 0; i < list.size(); i++) {
			Secteur secteur = list.get(i);
			if (cotation < metierSecteur.cotationMetierSecteur(secteur)) {
				cotation = metierSecteur.cotationMetierSecteur(secteur);
			}
		}
		return cotation;
	}

}