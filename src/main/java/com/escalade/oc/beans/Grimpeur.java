package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *  Entité Commentaire.
 * @author Taeletis
 * 
 *
 */

@Entity
public class Grimpeur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2530662483553723088L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrimpeur;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private boolean membre;
	@OneToMany(mappedBy = "emprunteur", fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;
	@OneToMany(mappedBy = "proprietaire", fetch = FetchType.LAZY)
	private Collection<Topo> topos;
	@OneToMany(mappedBy = "createur", fetch = FetchType.LAZY)
	private Collection<Site> sites;
	@OneToMany(mappedBy = "modifieur", fetch = FetchType.LAZY)
	private Collection<Site> sitesModif;
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY)
	private Collection<Commentaire> commentaires;

	public Grimpeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur d'un Grimpeur.
	 * @param nom
	 * 		String nom du Grimpeur.
	 * @param prenom
	 * 		String prénom du Grimpeur.
	 * @param email
	 * 		String prénom du Grimpeur.
	 * @param mdp
	 *		String mot de passe du Grimpeur.
	 */
	public Grimpeur(String nom, String prenom,String email, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email=email;
		this.mdp = mdp;
		this.membre = false;
	}

	public Long getIdGrimpeur() {
		return idGrimpeur;
	}

	public void setIdGrimpeur(Long idGrimpeur) {
		this.idGrimpeur = idGrimpeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Site> getSecteursModif() {
		return sitesModif;
	}

	public void setSecteursModif(Collection<Site> sitesModif) {
		this.sitesModif = sitesModif;
	}

	public void setMembre(boolean membre) {
		this.membre = membre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMembre() {
		return membre;
	}

	public Collection<Site> getSites() {
		return sites;
	}

	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
}
