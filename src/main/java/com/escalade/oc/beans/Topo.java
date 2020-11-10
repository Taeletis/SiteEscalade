
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

	private String description;

	private Date dateParution;

	private boolean disponible;

	@ManyToOne
	@JoinColumn(name = "ID_CREATEUR")
	private Grimpeur createur;
	@OneToMany(mappedBy = "topo", fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;
	@OneToMany(mappedBy = "topo", fetch = FetchType.LAZY)
	private Collection<Site> sites;
	public Topo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topo(String nom,String lieu,String description, Date dateParutrion, boolean disponible, Grimpeur proprietaire) {
		super();
		this.nom = nom;
		this.lieu=lieu;
		this.description=description;
		this.dateParution = dateParutrion;
		this.disponible = disponible;
		this.createur = proprietaire;
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
	public Grimpeur getCreateur() {
		return createur;
	}
	public void setCreateur(Grimpeur createur) {
		this.createur = createur;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Collection<Site> getSites() {
		return sites;
	}
	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
}
