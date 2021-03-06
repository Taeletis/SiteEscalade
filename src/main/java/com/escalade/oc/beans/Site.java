
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

/**
 * Entité Secteur.
 *
 * @author Taeletis
 * 
 * 
 *
 */
@Entity
public class Site implements Serializable {

	
	private static final long serialVersionUID = -2808352874097614557L;
	@Id
	@GeneratedValue
	private long idSite;
	private String nom;
	private String lienImage;
	private String lieu;
	
	private boolean mention;
	
	@ManyToOne
	@JoinColumn(name = "ID_GRIMPEUR")
	private Grimpeur createur;
	@ManyToOne
	@JoinColumn(name = "ID_MODIFICATEUR")
	private Grimpeur modifieur;

	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
	private Collection<Secteur> secteurs;

	
	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
	private Collection<Topo> topo;

	@OneToMany(mappedBy = "site", fetch = FetchType.LAZY) 
	private	Collection<Commentaire> commentaires;

	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructeur d'un Site.
	 * @param nom
	 * 		String nom du site.
	 * @param lienImage
	 * 		String lien url de l'image du site.
	 * @param lieu
	 * 		String lieu du site.
	 * @param createur
	 * 		Grimpeur créatuer du site.
	 */
	public Site(String nom, String lienImage,String lieu,Grimpeur createur) {
		super();
		this.nom = nom;
		this.lienImage=lienImage;
		this.lieu = lieu;
		this.mention = false;
		this.createur = createur;
	}

	public long getIdSite() {
		return idSite;
	}

	public void setIdSite(long idSite) {
		this.idSite = idSite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLienImage() {
		return lienImage;
	}

	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public boolean isMention() {
		return mention;
	}

	public void setMention(boolean mention) {
		this.mention = mention;
	}

	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}



	public Collection<Topo> getTopo() {
		return topo;
	}
	public void setTopo(Collection<Topo> topo) {
		this.topo = topo;
	}
	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	public Grimpeur getCreateur() {
		return createur;
	}
	public void setCreateur(Grimpeur createur) {
		this.createur = createur;
	}
	public Grimpeur getModifieur() {
		return modifieur;
	}
	public void setModifieur(Grimpeur modifieur) {
		this.modifieur = modifieur;
	}
}
