package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Reservation;
import com.escalade.oc.beans.StatutType;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.dao.DaoReservation;
import com.escalade.oc.metier.MetierReservation;
@Service
public  class MetierReservationImpl implements MetierReservation{
	@Autowired
	private DaoReservation daoReservation;

	@Override
	public Reservation ajouterMetierReservation(Grimpeur g, Topo t, StatutType s) {
		Reservation r =new Reservation(g,t,s);
		try {
			r=daoReservation.save(r);
		}catch(Exception e) {
			
		}
		return r;
	}

	@Override
	public Reservation modifierMetierReservation(StatutType s, Reservation r) {
		r.setStatut(s);
		try {
			r=daoReservation.save(r);
		}catch(Exception e) {
			
		}
		return r;
	}

	@Override
	public void supprimerMetierReservationt(Reservation r) {
		try {
			daoReservation.delete(r);
		}catch(Exception e) {
			
		}

	}

	@Override
	public Reservation trouverMetierReservation(Long id) {
		Reservation r =null;
		try {
			r=daoReservation.getOne(id);
		}catch(Exception e) {
			
		}
		return r;
	}

	@Override
	public List<Reservation> listeParStatutMetierReservation(StatutType s) {
		List<Reservation> list;
		List<Reservation> listReturn = new ArrayList<Reservation>();
		Reservation r ;
		try {
			list = daoReservation.findAll();
		
				for (int i = 0; i < list.size(); i++) {
					r = list.get(i);
					if (s.getIdStatut()==r.getStatut().getIdStatut()) {
						listReturn.add(r);
					}
				}
			
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public List<Reservation> listeParGrimpeurMetierReservation(Grimpeur g) {
		List<Reservation> list;
		List<Reservation> listReturn = null;
		Reservation r ;
		try {
			list = daoReservation.findAll();
		
				for (int i = 0; i < list.size(); i++) {
					r = list.get(i);
					if (g.getIdGrimpeur()==r.getEmprunteur().getIdGrimpeur()) {
						listReturn.add(r);
					}
				}
			
		} catch (Exception e) {

		}
		return listReturn;
	}

	@Override
	public List<Reservation> listeParTopoMetierReservation(Topo t) {
		List<Reservation> list;
		List<Reservation> listReturn = null;
		Reservation r ;
		try {
			list = daoReservation.findAll();
		
				for (int i = 0; i < list.size(); i++) {
					r = list.get(i);
					if (t.getIdTopo()==r.getTopo().getIdTopo()) {
						listReturn.add(r);
					}
				}
			
		} catch (Exception e) {

		}
		return listReturn;
	}


}
