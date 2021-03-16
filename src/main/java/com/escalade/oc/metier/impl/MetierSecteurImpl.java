package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoReservation;
import com.escalade.oc.dao.DaoSecteur;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierVoie;

/**
 * Class pour la couche metier de Secteur.
 * @author Taeletis
 * 
 *         
 */
@Service
public class MetierSecteurImpl implements MetierSecteur {
	/**
	 * injection de DaoSecteur.
	 */
	@Autowired
	private DaoSecteur daoSecteur;
	/**
	 * injection de MetierVoie.
	 */
	@Autowired
	private MetierVoie metierVoie;
	/**
	 * Méthode qui ajoute un Secteur.
	 * @param nom
	 * 		String nom du Secteur.
	 * @param lienCarte
	 * 		String lien url de l'image du Secteur.
	 * @param description
	 * 		String description du Secteur.
	 * @param s
	 * 		Site auquel appartient le Secteur.
	 * @return
	 * 		renvoie le Secteur créer.
	 */
	@Override
	public Secteur ajouterMetierSecteur(String nom, String lienCarte, String description, Site s) {
		Secteur secteur = new Secteur(nom, lienCarte, description, s);
		try {
			secteur = daoSecteur.save(secteur);
		} catch (Exception e) {
		}
		return secteur;
	}
	/**
	 * Méthode qui modifie un Secteur.
	 * @param nom
	 * 		String nom du Secteur.
	 * @param lienCarte
	 * 		String lien url de l'image du Secteur.
	 * @param description
	 * 		String description du Secteur.
	 * @param secteur
	 * 		Secteur à modifier.
	 * @return
	 * 		renvoie le Secteur modifié.
	 */
	@Override
	public Secteur modifierMetierSecteur(String nom, String lienCarte, String description, Secteur secteur) {
		secteur.setNom(nom);
		secteur.setLienCarte(lienCarte);
		secteur.setDescription(description);
		try {
			secteur = daoSecteur.save(secteur);
		} catch (Exception e) {
		}

		return secteur;
	}
	/**
	 * Méthode qui trouve un Secteur.
	 * @param id
	 * 		Long id du Secteur.
	 * @return
	 * 		renvoie le Secteur trouvé.
	 */
	@Override
	public Secteur trouverMetierSecteur(Long id) {
		Secteur secteur = null;
		List<Secteur> list = new ArrayList<Secteur>();
		try {
			list.addAll(daoSecteur.findAll());
			for (int i = 0; i < list.size(); i++) {
				secteur = list.get(i);
				Long idSite = secteur.getIdSecteur();
				if (idSite == id) {
					break;
				}

			}
		} catch (Exception e) {

		}
		return secteur;
	}
	/**
	 *  Méthode qui supprime un Secteur.
	 * @param secteur
	 * 		Secteur à supprimer.
	 */
	@Override
	public void supprimerMetierSecteur(Secteur secteur) {
		try {
			daoSecteur.delete(secteur);
		} catch (Exception e) {
		}
		;
	}
	/**
	 * Méthode qui trouve les Secteur par Site.
	 * @param s
	 * 		Site en paramètre de recherche.
	 * @return
	 * renvoie une liste de Secteur appartenant au même Site.
	 */
	@Override
	public List<Secteur> listeParSiteMetierSecteur(Site s) {
		List<Secteur> list;
		List<Secteur> listReturn = new ArrayList<Secteur>();
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
	/**
	 * Méthode qui retourne la cotation de la Voie.
	 * @param s
	 * 		Secteur demandé.
	 * @return
	 * 		renvoie la cotation du secteur.
	 */
	public String cotationMetierSecteur(Secteur s) {
		List<Voie> list = metierVoie.listeParSecteurMetierVoie(s);

		String cotation = "";
		int valeur;
		int valeurHaute = 0;
		String niveau = "A";

		for (int i = 0; i < list.size(); i++) {
			Voie v = list.get(i);
			String cotationVoie = metierVoie.cotationMetierVoie(v);
			if (cotationVoie.length() == 2) {
				String chiffre = cotationVoie.substring(0, 1);
				valeur = Integer.parseInt(chiffre);
				if (valeurHaute < valeur) {
					String lettre = cotationVoie.substring(1);
					valeurHaute = valeur;
					cotation = valeurHaute + lettre;
				}
				if (valeurHaute == valeur) {
					String lettre = cotationVoie.substring(1);
					if (!niveau.equals(lettre)) {
						if (lettre.equals("B") && niveau.equals("A") || lettre.equals("C") && niveau.equals("A")
								|| lettre.equals("C") && niveau.equals("B")) {
							cotation = valeurHaute + lettre;
							niveau = lettre;
						}
					}
				}
			}

		}
		return cotation;
	}
}
