package com.escalade.oc.metier.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
import com.escalade.oc.dao.DaoTopo;
import com.escalade.oc.metier.MetierSite;
import com.escalade.oc.metier.MetierTopo;
@Service
public class MetierTopoImpl implements  MetierTopo {
	@Autowired
	private DaoTopo daoTopo;

	@Autowired
	private MetierSite metierSite;
	@Override
	public Topo ajouterMetierTopo(String nom,String lieu,String description, boolean disponible, Grimpeur g) {
		Date date=new Date();
		Topo t= new Topo(nom,lieu,description,date,disponible,g);
		try {
			t=daoTopo.save(t);
		}catch (Exception e) {
		}
		return t;
	}

	@Override
	public Topo modifierMetierTopo(String nom,String lieu,String description, boolean disponible, Grimpeur g, Topo t) {
		t.setNom(nom);
		t.setLieu(lieu);
		t.setDescription(description);
		t.setDisponible(disponible);
		t.setCreateur(g);
		try {
			t=daoTopo.save(t);
		}catch (Exception e) {
		}
		return t;
	}

	@Override
	public Topo trouverMetierTopo(Long id) {
		Topo t=null;
		try {
			t=daoTopo.getOne(id);
		}catch (Exception e) {
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
	public List<Topo> chercherParNomMetierTopo(String name) {
		List<Topo> list;
		List<Topo> listReturn = null;
		Topo t ;
		try {
			list = listeTousMetierTopo();
			for (int i = 0; i < list.size(); i++) {
				t = list.get(i);
				String nom = t.getNom();
				if (nom.equalsIgnoreCase(name)) {
					listReturn.add(t);
				}
				
			}
			for (int i = 0; i < list.size(); i++) {
				t = list.get(i);
				String nom = t.getLieu();
				if (nom.equalsIgnoreCase(name)) {
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
