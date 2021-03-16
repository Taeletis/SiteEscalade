package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoVoie;
import com.escalade.oc.metier.MetierLongueur;
import com.escalade.oc.metier.MetierVoie;
/**
 * Class pour la couche metier de Voie.
 * @author Taeletis
 * 
 *         
 *
 */
@Service
public class MetierVoieImpl implements MetierVoie {
	/**
	 * injection de DaoVoie.
	 */
	@Autowired
	private DaoVoie daoVoie;
	/**
	 * injection de MetierLongueur.
	 */
	@Autowired
	private MetierLongueur metierLongueur;

	
	/**
	 * Méthode qui ajoute une Voie.
	 * @param nom
	 * 		String nom de la Voie.
	 * @param annotation
	 * 		String description de la Voie.
	 * @param s
	 * 		Secteur auquel appartient la Voie.
	 * @return
	 * 		renvoie le Secteur créer.
	 */
	@Override
	public Voie ajouterMetierVoie(String nom, String annotation, Secteur s) {
		Voie v = new Voie(nom, annotation, s);

		try {
			v = daoVoie.save(v);
		} catch (Exception e) {
		}
		return v;
	}
	/**
	 * Méthode qui modifie une Voie.
	 * @param nom
	 * 		String nom de la voie.

	 * @param annotation
	 * 		String information sur la voie.
	 * @param v
	 * 		Voie à modifier.
	 * @return
	 * 		renvoie le Secteur modifié.
	 */
	@Override
	public Voie modifierMetierVoie(String nom, String annotation, Voie v) {
		v.setNom(nom);
		v.setAnnotation(annotation);

		try {
			v = daoVoie.save(v);
		} catch (Exception e) {
		}
		return v;
	}
	/**
	 * Méthode qui trouve une Voie.
	 * @param id
	 * 		Long id du Secteur.
	 * @return
	 * 		renvoie le Secteur trouvé.
	 */
	@Override
	public Voie trouverMetierVoie(Long id) {
		Voie voie = null;
		List<Voie> list = new ArrayList<Voie>();
		try {
			list.addAll(daoVoie.findAll());
			for (int i = 0; i < list.size(); i++) {
				voie = list.get(i);
				Long idVoie = voie.getIdVoie();
				if (idVoie == id) {
					break;
				}
			}
		} catch (Exception e) {

		}
		return voie;
	}
	/**
	 *  Méthode qui supprime une Voie.
	 * @param v
	 * 		Voie à supprimer.
	 */
	@Override
	public void supprimerMetierVoie(Voie v) {
		try {
			daoVoie.delete(v);
		} catch (Exception e) {
		}
	}
	/**
	 * Méthode qui trouve les Voie par Secteur.
	 * @param s
	 * 		Secteur en paramètre de recherche.
	 * @return
	 * renvoie une liste de Voie appartenant au même Secteur.
	 */
	@Override
	public List<Voie> listeParSecteurMetierVoie(Secteur s) {
		List<Voie> list;
		List<Voie> listReturn = new ArrayList<Voie>();
		Voie v;
		try {
			list = daoVoie.findAll();
			for (int i = 0; i < list.size(); i++) {
				v = list.get(i);
				if (s.getIdSecteur() == v.getSecteur().getIdSecteur()) {
					listReturn.add(v);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}
	/**
	 * Méthode qui retourne la cotation de la Voie.
	 * @param v
	 * 		Voie demandé.
	 * @return
	 * 		renvoie la cotation du secteur.
	 */
	@Override
	public String cotationMetierVoie(Voie v) {
		List<Longueur> list = metierLongueur.listeParVoieMetierLongueur(v);
		String cotation = "";
		int valeur;
		int valeurHaute = 0;
		String niveau = "A";
		for (int i = 0; i < list.size(); i++) {
			Longueur l = list.get(i);
			String chiffre = l.getCotation().substring(0, 1);
			valeur = Integer.parseInt(chiffre);
			if (valeurHaute < valeur) {
				String s = l.getCotation().substring(1);
				valeurHaute = valeur;
				cotation = valeurHaute + s;
			}
			if (valeurHaute == valeur) {
				String s = l.getCotation().substring(1);
				if (!niveau.equals(s)) {

					if (s.equals("B") && niveau.equals("A") || s.equals("C") && niveau.equals("A")
							|| s.equals("C") && niveau.equals("B")) {
						cotation = valeurHaute + s;
						niveau = s;
					}
				}
			}

		}
		return cotation;
	}
}
