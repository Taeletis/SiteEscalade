
package com.escalade.oc.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StatutType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2644924319011714878L;
	@Id
	@GeneratedValue
	private long idStatut;
	private String statut;

	@OneToMany(mappedBy = "statut", fetch = FetchType.LAZY)
	private Collection<Reservation> reservations;

	public StatutType() {
		super();
		// TODO Auto-generated constructor stub }
	}
	public StatutType(String statut) {
		super();
		this.statut = statut;
	}

	public long getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(long idStatut) {
		this.idStatut = idStatut;
	}
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
