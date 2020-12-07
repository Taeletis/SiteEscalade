package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.dao.DaoGrimpeur;
import com.escalade.oc.metier.MetierGrimpeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierGrimpeurImpl implements MetierGrimpeur {
	@Autowired
	DaoGrimpeur grimpeurDao;

	@Override
	public Grimpeur ajouterMetierGrimpeur(String nom, String prenom, String email, String mdp) {
		Grimpeur g = new Grimpeur(nom, prenom, email, mdp);
		try {
			g = grimpeurDao.save(g);
		} catch (Exception e) {
		}
		return g;
	}

	@Override
	public Grimpeur modifierMetierGrimpeur(String nom, String prenom, String email, String mdp, Grimpeur g) {
		try {
			g.setNom(nom);
			g.setPrenom(prenom);
			g.setEmail(email);
			g.setMdp(mdp);
			g = grimpeurDao.saveAndFlush(g);
		} catch (Exception e) {
		}
		return g;
	}

	@Override
	public Grimpeur modifierMembreMetierGrimpeur(Grimpeur g, boolean membre) {
		try {
			g.setMembre(membre);
			g = grimpeurDao.save(g);
		} catch (Exception e) {
		}
		return g;
	}

	@Override
	public List<Grimpeur> chercherMetierGrimpeur(String name) {
		List<Grimpeur> list;
		List<Grimpeur> listReturn = null;
		Grimpeur g;
		try {
			list = listeTousMetierGrimpeur();
			for (int i = 0; i < list.size(); i++) {
				g = list.get(i);
				String nom = g.getNom();
				if (nom.equalsIgnoreCase(name)) {
					listReturn.add(g);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
		public Grimpeur trouverMetierGrimpeur(Long id) {
			List<Grimpeur> list = new ArrayList<Grimpeur>();
			Grimpeur g = null;
			try {
				list.addAll(listeTousMetierGrimpeur());
				for (int i = 0; i < list.size(); i++) {
					g = list.get(i);
					Long idGrimpeur = g.getIdGrimpeur();
					if (idGrimpeur == id) {
						break;
					}

				}
			} catch (Exception e) {
			}
			return g;
	}
			
	@Override
	public void supprimerMetierGrimpeur(Grimpeur g) {
		try {

			grimpeurDao.delete(g);
		} catch (Exception e) {
		}

	}

	@Override
	public List<Grimpeur> listeTousMetierGrimpeur() {
		List<Grimpeur> list = null;
		try {

			list = grimpeurDao.findAll();
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public boolean connexionMetierGrimpeur(String email, String mdp) {
		boolean membre = false;
		List<Grimpeur> list = listeTousMetierGrimpeur();
		for (int i = 0; i < list.size(); i++) {
			Grimpeur g = list.get(i);
			System.out.println(g.getEmail() + email);
			System.out.println(g.getMdp() + mdp);
			if (g.getEmail().equals(email) && g.getMdp().equals(mdp)) {
				membre = true;
			}
		}
		return membre;
	}

	@Override
	public boolean verifierInscriptionMetierGrimpeur(String email) {
		boolean existe = false;
		List<Grimpeur> list = listeTousMetierGrimpeur();
		for (int i = 0; i < list.size(); i++) {
			Grimpeur g = list.get(i);
			if (g.getEmail().equals(email)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public Grimpeur trouverParEmailMetierGrimpeur(String email) {
		List<Grimpeur> list = listeTousMetierGrimpeur();
		Grimpeur g = null;
		for (int i = 0; i < list.size(); i++) {
			g = list.get(i);
			if (g.getEmail().equals(email)) {
				break;
			}
		}
		return g;
	}
}
