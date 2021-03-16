
package com.escalade.oc.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entité Reservation.
 * @author Taeletis
 * 
 *  
 *
 */
@Entity
public class Reservation implements Serializable {


	private static final long serialVersionUID = -4015727598146474332L;

	@Id
	@GeneratedValue
	private long idReservation;

	@ManyToOne

	@JoinColumn(name = "ID_GRIMPEUR")
	private Grimpeur emprunteur;

	@ManyToOne

	@JoinColumn(name = "ID_STATUT")
	private StatutType statut;

	@ManyToOne

	@JoinColumn(name = "ID_TOPO")
	private Topo topo;

	public Reservation() {
		super(); // TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructeur d'une Reservation.
	 * @param emprunteur
	 * 		Grimpeur qui emprunte la reservation.
	 * @param topo
	 * 		Topo auquel appartient la reservation.
	 * @param s
	 * 		StatutType que le commentaire contient.
	 */
	public Reservation(Grimpeur emprunteur, Topo topo,StatutType s) {
		super();
		this.emprunteur = emprunteur;
		this.topo = topo;
		this.statut = s;
	}
	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}

	
	public Grimpeur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Grimpeur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public StatutType getStatut() {
		return statut;
	}

	public void setStatut(StatutType statut) {
		this.statut = statut;
	}

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

}
