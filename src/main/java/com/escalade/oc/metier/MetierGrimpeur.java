package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;

public interface MetierGrimpeur {

	public Grimpeur ajouterMetierGrimpeur(String nom,String prenom,String email, String mdp);
	public Grimpeur modifierMetierGrimpeur(String nom, String prenom, String email, String mdp, Grimpeur g);
	public Grimpeur modifierMembreMetierGrimpeur(Grimpeur g, boolean membre);
	public List<Grimpeur> chercherMetierGrimpeur(String name);
	public Grimpeur trouverMetierGrimpeur(Long id);
	public void supprimerMetierGrimpeur(Grimpeur g);
	public List<Grimpeur> listeTousMetierGrimpeur();
	public boolean verifierInscriptionMetierGrimpeur(String email);
	public boolean connexionMetierGrimpeur (String email, String mdp);
}
