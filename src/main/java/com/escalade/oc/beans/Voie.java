
package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6879647161093382866L;
	@Id
	@GeneratedValue
	private long idVoie;
	private String nom;
	private String annotation;

	@ManyToOne

	@JoinColumn(name = "ID_SECTEUR")
	private Secteur secteur;

	@OneToMany(mappedBy = "voie", fetch = FetchType.LAZY)
	private Collection<Longueur> longueurs;

	public Voie() {
		super(); // TODO Auto-generated constructor stub

	}
	public Voie(String nom, String annotation, Secteur s) {
		this.nom=nom;
		this.annotation=annotation;
		this.secteur=s;

	}

	public long getIdVoie() {
		return idVoie;
	}
	public void setIdVoie(long idVoie) {
		this.idVoie = idVoie;
	}
	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public Collection<Longueur> getLongueurs() {
		return longueurs;
	}

	public void setLongueurs(Collection<Longueur> longueurs) {
		this.longueurs = longueurs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

}
