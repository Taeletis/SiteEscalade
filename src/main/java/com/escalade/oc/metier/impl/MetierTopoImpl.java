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
/**
 * Class pour la couche metier de Topo.
 * @author Taeletis
 * 
 *         
 *
 */
@Service
public class MetierTopoImpl implements  MetierTopo {
	/**
	 * injection de DaoTopo.
	 */
	@Autowired
	private DaoTopo daoTopo;
	/**
	 * Méthode qui ajoute un Topo.
	 * @param nom
	 * 		String nom du Topo.
	 * @param lieu
	 * 		String lieu du Topo.
	 * @param disponible
	 * 		boolean disponibilté du Topo.
	 * @param g
	 * 		Grimpeur créateur du Topo.
	 * @param s
	 * 		Site auquel appartient le Topo.
	 * @return
	 * 		renvoie le topo créé.
	 */
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
	/**
	 * Méthode qui modifie un Topo.
	 * @param nom
	 * 		String nom du Topo modifié.
	 * @param lieu
	 * 		String lieu du Topo modifié.
	 * @param disponible
	 * 		boolean disponiblité du Topo modifié.
	 * @param t
	 * 		Topo à modifier.
	 * @return
	 * 		renvoie le Topo modifié.
	 */
	@Override
	public Topo modifierMetierTopo(String nom,String lieu, boolean disponible, Topo t) {
		t.setNom(nom);
		t.setLieu(lieu);
		t.setDisponible(disponible);
		try {
			t=daoTopo.save(t);
		}catch (Exception e) {
		}
		return t;
	}
	/**
	 *  Méthode qui trouve un Topo.
	 * @param id
	 * 		Long id du Topo recherhcé.
	 * @return
	 *  	renvoie le topo trouvé.
	 */
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
	/**
	 * Méthode qui supprime un Topo.
	 * @param t
	 * 		Topo à supprimer.
	 */
	@Override
	public void supprimerMetierTopo(Topo t) {
		try {
			daoTopo.delete(t);
		}catch (Exception e) {
		}

	}
	/**
	 * Méthode qui trouve les Topos par Site.
	 * @param s
	 * 		Site en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de tous les Topos appartenant au même.
	 */
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


	/**
	 * Méthode qui donne tous les Topos.
	 * @return
	 * 		renvoie une liste des tous les Topos.
	 */
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
