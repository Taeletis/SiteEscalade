package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.dao.DaoTopo;
import com.escalade.oc.metier.MetierTopo;
@Service
public class MetierTopoImpl implements  MetierTopo {
	@Autowired
	private DaoTopo daoTopo;

	@Override
	public Topo ajouterMetierTopo(String nom,String lieu, boolean disponible, Grimpeur g,Site s) {
		Date date=new Date();

		Topo t= new Topo(nom,lieu, date,disponible,g,s);
		try {
			t=daoTopo.save(t);
		}catch (Exception e) {
		}
		return t;
	}

	@Override
	public Topo modifierMetierTopo(String nom,String lieu, boolean disponible, Grimpeur g, Topo t) {
		t.setNom(nom);
		t.setLieu(lieu);
		t.setDisponible(disponible);
		t.setProprietaire(g);
		try {
			t=daoTopo.save(t);
		}catch (Exception e) {
		}
		return t;
	}

	@Override
	public Topo trouverMetierTopo(Long id) {
		List<Topo> list = new ArrayList<Topo>();
		Topo t = null;
		try {
			list.addAll(listeTousMetierTopo());
			for (int i = 0; i < list.size(); i++) {
				t = list.get(i);
				Long idTopo = t.getIdTopo();
				if (idTopo == id) {
					break;
				}

			}
		} catch (Exception e) {
		}
		return t;
	}
	@Override
	public void supprimerMetierTopo(Topo t) {
		try {
			daoTopo.delete(t);
		}catch (Exception e) {
		}

	}
	@Override
	public List<Topo> listeParSiteMetierTopo(Site s) {
		List<Topo> list;
		List<Topo> listReturn = new ArrayList<Topo>();
		Topo t;
		try {
			list = listeTousMetierTopo();
			for (int i = 0; i < list.size(); i++) {
				t = list.get(i);
				if (t.getSite().getIdSite() == s.getIdSite()) {
					listReturn.add(t);
				}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}



	@Override
	public List<Topo> listeTousMetierTopo() {
		List<Topo> list = null;
		try {
			list = daoTopo.findAll();

		} catch (Exception e) {

		}
		return list;
	}


}
