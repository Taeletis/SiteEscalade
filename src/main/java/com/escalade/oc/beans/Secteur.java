
package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entité Secteur.
 *
 * @author Taeletis
 * 
 *  
 */
@Entity
public class Secteur implements Serializable {

	private static final long serialVersionUID = 2113762427496237130L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecteur;
	private String nom;	
	private String lienCarte;
	private String description;
	@ManyToOne
	@JoinColumn(name = "ID_SITE")
	private Site site;
	@OneToMany(mappedBy = "secteur", fetch = FetchType.LAZY)
	private Collection<Voie> voies;
	public Secteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructeur d'un Secteur.
	 * @param nom
	 * 		String nom du secteur.
	 * @param lienCarte
	 * 		String lien url de l'image du secteur.
	 * @param description
	 * 		String description du secteur.
	 * @param site
	 * 		Site auquel appartient le secteur.
	 */
	public Secteur(String nom,String lienCarte, String description, Site site) {
		super();
		this.nom = nom;
		this.lienCarte=lienCarte;
		this.description = description;
		this.site = site;
	}
	public Long getIdSecteur() {
		return idSecteur;
	}
	public void setIdSecteur(Long idSecteur) {
		this.idSecteur = idSecteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLienCarte() {
		return lienCarte;
	}
	public void setLienCarte(String lienCarte) {
		this.lienCarte = lienCarte;
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

	public Collection<Voie> getVoies() {
		return voies;
	}
	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}
}