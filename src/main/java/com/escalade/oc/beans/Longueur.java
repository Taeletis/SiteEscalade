package com.escalade.oc.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Longueur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6651536758750954052L;
	@Id
	@GeneratedValue
	private long idLongueur;
	private double hauteur;
	private String cotation;
	private String annotation;

	@ManyToOne
	@JoinColumn(name = "ID_VOIE")
	private Voie voie;

	public Longueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Longueur(double hauteur, String cotation,String annotation, Voie voie) {
		super();
		this.hauteur = hauteur;
		this.cotation = cotation;
		this.annotation=annotation;
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

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

}
