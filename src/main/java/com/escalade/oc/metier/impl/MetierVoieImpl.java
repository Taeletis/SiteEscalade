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

@Service
public class MetierVoieImpl implements MetierVoie {

	@Autowired
	private DaoVoie daoVoie;
	@Autowired
	private MetierLongueur metierLongueur;

	@Override
	public Voie ajouterMetierVoie(String nom, String annotation, Secteur s) {
		Voie v = new Voie(nom, annotation, s);

		try {
			v = daoVoie.save(v);
		} catch (Exception e) {
		}
		return v;
	}

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

	@Override
	public Voie trouverMetierVoie(Long id) {
		Voie v = null;
		try {
			v = daoVoie.getOne(id);
		} catch (Exception e) {
		}
		return v;
	}

	@Override
	public void supprimerMetierVoie(Voie v) {
		try {
			daoVoie.delete(v);
		} catch (Exception e) {
		}
	}

	@Override
	public List<Voie> listeParSecteurMetierVoie(Secteur s) {
		List<Voie> list;
		List<Voie> listReturn = new ArrayList<Voie>();
		Voie v ;
		try {
			list = daoVoie.findAll();
			for (int i = 0; i < list.size(); i++) {
				v = list.get(i);
				if (s.getIdSecteur()==v.getSecteur().getIdSecteur()) {
					listReturn.add(v);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public String cotationMetierVoie(Voie v) {
		List<Longueur> list = metierLongueur.listeParVoieMetierLongueur(v);
		String cotation = "";
		int valeur;
		int valeurHaute = 0;
		String niveau = "A";
		for (int i = 0; i < list.size(); i++) {
			Longueur l = list.get(i);
			String chiffre=l.getCotation().substring(0,1);
			valeur = Integer.parseInt(chiffre);
			if (valeurHaute < valeur) {
				String s = l.getCotation().substring(1);
				valeurHaute=valeur;
				cotation=valeurHaute+s;
			}
			if (valeurHaute == valeur) {
				String s = l.getCotation().substring(1);
				if(!niveau.equals(s)) {
					
					if(s.equals("B")&&niveau.equals("A")||s.equals("C")&&niveau.equals("A")||s.equals("C")&&niveau.equals("B")) {
						cotation=valeurHaute+s;
						niveau=s;
					}
				}
			}
			
		}
		System.out.println(cotation);
		return cotation;
	}
}
