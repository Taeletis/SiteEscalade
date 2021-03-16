package com.escalade.oc.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entité Longueur.
 * @author Taeletis
 * 
 *  
 *
 */
@Entity
public class Longueur implements Serializable {

	private static final long serialVersionUID = -6651536758750954052L;
	@Id
	@GeneratedValue
	private long idLongueur;
	public long getIdLongueur() {
		return idLongueur;
	}
	public void setIdLongueur(long idLongueur) {
		this.idLongueur = idLongueur;
	}

	private double hauteur;
	private String cotation;

	@ManyToOne
	@JoinColumn(name = "ID_VOIE")
	private Voie voie;

	public Longueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *  Constructeur d'une Longueur.
	 * @param hauteur
	 * 		double hauteur de la longueur.
	 * @param cotation
	 * 		String cotation de la longueur.
	 * @param voie
	 * 		Voie auquel appartient la Longueur.
	 */
	public Longueur(double hauteur, String cotation, Voie voie) {
		super();
		this.hauteur = hauteur;
		this.cotation = cotation;
		this.voie = voie;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}


	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

}
