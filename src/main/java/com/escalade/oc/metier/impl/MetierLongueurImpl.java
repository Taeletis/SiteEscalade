package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Longueur;
import com.escalade.oc.beans.Voie;
import com.escalade.oc.dao.DaoLongueur;
import com.escalade.oc.metier.MetierLongueur;
@Service
public class MetierLongueurImpl implements MetierLongueur {

	@Autowired
	private DaoLongueur daoLongueur;

	@Override
	public Longueur ajouterMetierLongueur(double hauteur, String cotation, String annotation, Voie v) {
		Longueur l = new Longueur(hauteur, cotation, annotation, v);

		try {
			l = daoLongueur.save(l);
		} catch (Exception e) {
		}
		return l;
	}

	@Override
	public Longueur modifierMetierLongueur(double hauteur, String cotation, String annotation, Longueur l) {
		l.setHauteur(hauteur);
		l.setCotation(cotation);
		l.setAnnotation(annotation);

		try {
			l = daoLongueur.save(l);
		} catch (Exception e) {
		}
		return l;
	}

	@Override
	public Longueur trouverMetierLongueur(Long id) {
		Longueur l = null;
		try {
			l = daoLongueur.getOne(id);
		} catch (Exception e) {
		}
		return l;
	}

	@Override
	public void supprimerMetierLongueur(Longueur l) {
		try {
			daoLongueur.delete(l);
		} catch (Exception e) {
		}
		
	}

	@Override
	public List<Longueur> listeParVoieMetierLongueur(Voie v) {
		List<Longueur> list;
		List<Longueur> listReturn = new ArrayList<Longueur>();;
		Longueur l;
		try {
			list = daoLongueur.findAll();
			for (int i = 0; i < list.size(); i++) {
				l = list.get(i);
				if (v.getIdVoie() == l.getVoie().getIdVoie()) {
					listReturn.add(l);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

}
