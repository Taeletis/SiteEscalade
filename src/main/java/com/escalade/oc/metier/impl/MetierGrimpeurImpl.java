package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.dao.DaoCommentaire;
import com.escalade.oc.dao.DaoGrimpeur;
import com.escalade.oc.metier.MetierGrimpeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class pour la couche metier du Grimpeur.
 * @author Taeletis
 *
 *
 */
@Service
public class MetierGrimpeurImpl implements MetierGrimpeur {
	/**
	 * injection de DaoGrimpeur.
	 */
	@Autowired
	DaoGrimpeur grimpeurDao;

	/**
	 * Méthode qui ajoute un Grimpeur.
	 * @param nom
	 * 		String du nom du grimpeur.
	 * @param prenom
	 * 		String du prénpm du grimpeur.
	 * @param email
	 * 		String de l'email du grimpeur.
	 * @param mdp
	 * 		String du mot de passe codé du grimpeur.
	 * @return
	 * 		renvoie le grimpeur créer.
	 */
	@Override
	public Grimpeur ajouterMetierGrimpeur(String nom, String prenom, String email, String mdp) {
		Grimpeur g = new Grimpeur(nom, prenom, email, mdp);
		try {
			g = grimpeurDao.save(g);
		} catch (Exception e) {
		}
		return g;
	}
	/**
	 * Méthode qui modifie un Grimpeur.
	 * 
	 * @param nom
	 * 		String du nom du grimpeur.
	 * @param prenom
	 * 		String du prénpm du grimpeur.
	 * @param email
	 * 		String de l'email du grimpeur.
	 * @param mdp
	 * 		String du mot de passe codé du grimpeur.
	 * @param g
	 * 		Grimpeur à modifier
	 * 
	 * @return
	 * 		renvoie le grimpeur modifié.
	 */
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
	/**
	 * Méthode qui modifie l'état membre d'un Grimpeur.
	 * @param g
	 * 		Grimpeur à modifier
	 * 
	 * @param membre
	 * 		boolean modifié.
	 * @return
	 * 		renvoie le grimpeur modifié.
	 */
	@Override
	public Grimpeur modifierMembreMetierGrimpeur(Grimpeur g, boolean membre) {
		try {
			g.setMembre(membre);
			g = grimpeurDao.save(g);
		} catch (Exception e) {
		}
		return g;
	}
	/**
	 * Méthode qui recherche les Grimpeurs par nom.
	 * @param name
	 * 		String du nom de grimpeur à recherhché.
	 * @return
	 * 		c
	 */
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
	/**
	 *  Méthode qui retouve un commentaire par son id.
	 * @param id
	 * 		Long id du Grimpeur recherché.
	 * @return
	 * 		renvoie le Grimpeur trouvé.
	 */
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
	/**
	 * Méthode qui supprime un Grimpeur.
	 * @param g
	 * 		Grimpeur à supprimer.
	 */	
	@Override
	public void supprimerMetierGrimpeur(Grimpeur g) {
		try {

			grimpeurDao.delete(g);
		} catch (Exception e) {
		}

	}
	/**
	 * Méthode qui renvoie tous les Grimpeurs.
	 * @return
	 * 		renvoie une liste de tous les Grimpeurs.
	 */
	@Override
	public List<Grimpeur> listeTousMetierGrimpeur() {
		List<Grimpeur> list = null;
		try {

			list = grimpeurDao.findAll();
		} catch (Exception e) {
		}
		return list;
	}
	/**
	 * Méthode qui verifie les paramètre de connexion.
	 * @param email
	 * 		String email du Grimpeur à verifier.
	 * @param mdp
	 * 		String mdp crypté du Grimpeur à vérifier.
	 * @return
	 * 		renvoie un boolean.
	 */

	@Override
	public boolean connexionMetierGrimpeur(String email, String mdp) {
		boolean membre = false;
		List<Grimpeur> list = listeTousMetierGrimpeur();
		for (int i = 0; i < list.size(); i++) {
			Grimpeur g = list.get(i);
			if (g.getEmail().equals(email) && g.getMdp().equals(mdp)) {
				membre = true;
			}
		}
		return membre;
	}
	/**
	 * Méthode qui vérifie que l'email n'existe pas déjà.
	 * @param email
	 * 		String email à verifier
	 * @return
	 * 		renvoie un boolean.
	 */
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

	/**
	 *  Méthode qui retouve un commentaire par son email.
	 * @param email
	 * 		String email du Grimpeur recherché.
	 * @return
	 * 		renvoie le Grimpeur trouvé.
	 */
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
