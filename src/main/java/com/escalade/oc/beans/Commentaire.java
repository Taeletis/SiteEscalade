package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entité Commentaire.
 * @author Taeletis
 * 
 *
 */
@Entity
public class Commentaire implements Serializable {

	private static final long serialVersionUID = 3142441744759126334L;
	
	@Id @GeneratedValue
	private Long idCommentaire;
	
	private Date dateParution;
	
	private Date dateModification;
	
	private String description;
	
	@ManyToOne
	@JoinColumn (name="ID_SITE")
	private Site site;
	
	@ManyToOne
	@JoinColumn (name="ID_GRIMPEUR")
	private Grimpeur auteur;


	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  Constructeur d'un commentaire.
	 * @param dateParution
	 * 		 Date  creation du commentaire.
	 * @param description
	 * 		 String contenu du commentaire.
	 * @param site
	 * 		Site auquel appartient le commenantaire.
	 * @param auteur
	 * 		 Grimpeur auteur du commentaire.
	 */
	public Commentaire(Date dateParution, String description, Site site, Grimpeur auteur) {
		super();
		this.dateParution = dateParution;
		this.description = description;
		this.site = site;
		this.auteur = auteur;
	}


	public Grimpeur getGrimpeurId() {
		return auteur;
	}

	
	public void setGrimpeurId(Grimpeur grimpeurId) {
		this.auteur = grimpeurId;
	}

	
	public Date getDateParution() {
		return dateParution;
	}

	
	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}

	
	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Site getSite() {
		return site;
	}

	
	public void setSite(Site site) {
		this.site = site;
	}

	
	public Grimpeur getAuteur() {
		return auteur;
	}

	
	public void setAuteur(Grimpeur auteur) {
		this.auteur = auteur;
	}

	
	public Long getIdCommentaire() {
		return idCommentaire;
	}

	
	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	
}
