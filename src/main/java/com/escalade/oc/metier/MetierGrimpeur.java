package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;

/**
 * @author Taeletis
 *
 *interface pour la couche metier du Grimpeur.
 */
public interface MetierGrimpeur {

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
	public Grimpeur ajouterMetierGrimpeur(String nom,String prenom,String email, String mdp);
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
	public Grimpeur modifierMetierGrimpeur(String nom, String prenom, String email, String mdp, Grimpeur g);
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
	public Grimpeur modifierMembreMetierGrimpeur(Grimpeur g, boolean membre);
	/**
	 * Méthode qui recherche les Grimpeurs par nom.
	 * @param name
	 * 		String du nom de grimpeur à recherhché.
	 * @return
	 * 		c
	 */
	public List<Grimpeur> chercherMetierGrimpeur(String name);
	/**
	 *  Méthode qui retouve un commentaire par son id.
	 * @param id
	 * 		Long id du Grimpeur recherché.
	 * @return
	 * 		renvoie le Grimpeur trouvé.
	 */
	public Grimpeur trouverMetierGrimpeur(Long id);
	/**
	 * Méthode qui supprime un Grimpeur.
	 * @param g
	 * 		Grimpeur à supprimer.
	 */
	public void supprimerMetierGrimpeur(Grimpeur g);
	/**
	 * Méthode qui renvoie tous les Grimpeurs.
	 * @return
	 * 		renvoie une liste de tous les Grimpeurs.
	 */
	public List<Grimpeur> listeTousMetierGrimpeur();
	/**
	 * Méthode qui vérifie que l'email n'existe pas déjà.
	 * @param email
	 * 		String email à verifier
	 * @return
	 * 		renvoie un boolean.
	 */
	public boolean verifierInscriptionMetierGrimpeur(String email);
	/**
	 * Méthode qui verifie les paramètre de connexion.
	 * @param email
	 * 		String email du Grimpeur à verifier.
	 * @param mdp
	 * 		String mdp crypté du Grimpeur à vérifier.
	 * @return
	 * 		renvoie un boolean.
	 */
	public boolean connexionMetierGrimpeur (String email, String mdp);
	/**
	 *  Méthode qui retouve un commentaire par son email.
	 * @param email
	 * 		String email du Grimpeur recherché.
	 * @return
	 * 		renvoie le Grimpeur trouvé.
	 */
	public Grimpeur trouverParEmailMetierGrimpeur(String email);
}
