package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoSite;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;

@Service
public class MetierSiteImpl implements MetierSite {
	@Autowired
	private DaoSite daoSite;

	@Autowired
	private MetierSecteur metierSecteur;

	@Override
	public Site ajouterMetierSite(String nom, String lienImage, String lieu,Grimpeur createur) {
		Site s = new Site(nom, lienImage, lieu,createur);
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
		List<Site> list = new ArrayList<Site>();
		Site s = null;
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				Long idSite = s.getIdSite();
				if (idSite == id) {
					break;
				}

			}
			/*
			 * for (int i = 0; i < list.size(); i++) { s = list.get(i); String nom =
			 * s.getLieu(); if (nom.equalsIgnoreCase(name)) { listReturn.add(s); }
			 * 
			 * }
			 */
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
	public String cotationMetierSite(Site s) {
		List<Secteur> list = metierSecteur.listeParSiteMetierSecteur(s);
		String cotation = "";
		int valeur;
		int valeurHaute = 0;
		String niveau = "A";
		for (int i = 0; i < list.size(); i++) {
			Secteur secteur = list.get(i);
			String cotationSecteur = metierSecteur.cotationMetierSecteur(secteur);
			if (cotationSecteur.length() == 2) {
				String chiffre = cotationSecteur.substring(0, 1);
				valeur = Integer.parseInt(chiffre);
				if (valeurHaute < valeur) {
					String lettre = cotationSecteur.substring(1);
					valeurHaute = valeur;
					cotation = valeurHaute + lettre;
				}
				if (valeurHaute == valeur) {
					String lettre = cotationSecteur.substring(1);
					if (!niveau.equals(lettre)) {
						if (lettre.equals("B") && niveau.equals("A") || lettre.equals("C") && niveau.equals("A")
								|| lettre.equals("C") && niveau.equals("B")) {
							cotation = valeurHaute + lettre;
							niveau=lettre;
						}
					}
				}

			}
		}
		return cotation;
	}

	@Override
	public List<Site> listeMetierSite() {
		List<Site> list = null;
		try {
			list = daoSite.findAll();

		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<Site> chercherParNomMetierSite(String name) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		Site s;
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				String nom = s.getNom();
				if (nom.equalsIgnoreCase(name)) {
					listReturn.add(s);
				}

			}
			/*
			 * for (int i = 0; i < list.size(); i++) { s = list.get(i); String nom =
			 * s.getLieu(); if (nom.equalsIgnoreCase(name)) { listReturn.add(s); }
			 * 
			 * }
			 */
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public List<Site> chercherParLieuMetierSite(String endroit) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		Site s;
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				String lieu = s.getLieu();
				if (lieu.equalsIgnoreCase(endroit)) {
					listReturn.add(s);
				}

			}
			/*
			 * for (int i = 0; i < list.size(); i++) { s = list.get(i); String nom =
			 * s.getLieu(); if (nom.equalsIgnoreCase(name)) { listReturn.add(s); }
			 * 
			 * }
			 */
		} catch (Exception e) {

		}
		return listReturn;
	}
}