package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.beans.Topo;
/**
 * interface pour la couche metier de Topo.
 * @author Taeletis
 *
 *
 */
public interface MetierTopo {

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
	public Topo ajouterMetierTopo(String nom,String lieu,boolean disponible,Grimpeur g,Site s);
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
	public Topo modifierMetierTopo(String nom,String lieu,boolean disponible, Topo t);

	/**
	 *  Méthode qui trouve un Topo.
	 * @param id
	 * 		Long id du Topo recherhcé.
	 * @return
	 *  	renvoie le topo trouvé.
	 */
	public Topo trouverMetierTopo(Long id);
	/**
	 * Méthode qui supprime un Topo.
	 * @param t
	 * 		Topo à supprimer.
	 */
	public void supprimerMetierTopo(Topo t);
	/**
	 * Méthode qui trouve les Topos par Site.
	 * @param s
	 * 		Site en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de tous les Topos appartenant au même Site.
	 */
	public List<Topo> listeParSiteMetierTopo(Site s);
	/**
	 * Méthode qui donne tous les Topos.
	 * @return
	 * 		renvoie une liste des tous les Topos.
	 */
	public List<Topo> listeTousMetierTopo();
}
