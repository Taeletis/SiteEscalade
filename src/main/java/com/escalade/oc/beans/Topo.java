
package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Topo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1097578189529050880L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTopo;

	private String nom;
	
	private String lieu;

	private Date dateParution;

	private boolean disponible;

	@ManyToOne
	@JoinColumn(name = "ID_PROPIETAIRE")
	private Grimpeur proprietaire;
	@OneToMany(mappedBy = "topo", fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;
	@ManyToOne
	@JoinColumn(name = "ID_Site")
	private Site site;
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topo(String nom,String lieu, Date dateParutrion, boolean disponible, Grimpeur proprietaire,Site s) {
		super();
		
		this.nom = nom;
		this.lieu=lieu;
		this.dateParution = dateParutrion;
		this.disponible = disponible;
		this.proprietaire = proprietaire;
		this.site=s;
	}
	public Long getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(Long idTopo) {
		this.idTopo = idTopo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateParution() {
		return dateParution;
	}
	public void setDateParution(Date dateParutrion) {
		this.dateParution = dateParutrion;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Grimpeur getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Grimpeur proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
}
