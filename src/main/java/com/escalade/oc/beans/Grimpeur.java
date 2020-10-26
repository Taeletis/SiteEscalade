package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Grimpeur")
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
	private Collection<Secteur> secteurs;
	@OneToMany(mappedBy = "modifieur", fetch = FetchType.LAZY)
	private Collection<Secteur> secteursModif;
	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY)
	private Collection<Commentaire> commentaires;

	public Grimpeur() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Collection<Secteur> getSecteursModif() {
		return secteursModif;
	}

	public void setSecteursModif(Collection<Secteur> secteursModif) {
		this.secteursModif = secteursModif;
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
}
