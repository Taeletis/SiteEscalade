package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.StatutType;


/**
 * interface pour la couche metier de StatutType.
 * @author Taeletis
 *
 *
 */
public interface MetierStatutType {

	/**
	 * Méthode qui ajoute un StatutType.
	 * @param statut
	 * 		String type du statut.
	 * @return
	 * 		renvoie le StatutType créé.
	 */
	public StatutType ajouterMetierStatutType(String statut);
	/**
	 * Méthode qui modifie un StatutType.
	 * @param statut
	 * 		String type à modifier.
	 * @param s
	 * 		StatutType à modifier.
	 * @return
	 * renvoie le StatutType modifié.
	 */
	public StatutType modifierMetierStatutType(String statut,StatutType s);
	/**
	 * Méthode qui supprime un Site.
	 * @param s
	 * 		StatutType à supprimer.
	 */
	public void supprimerMetierStatutType(StatutType s);
	/**
	 * Méthode qui trouve les StatutTypes par id.
	 * @param id
	 * 		Long id du StatutType recherché.
	 * @return
	 * 		renvoie le StatutType trouvé.
	 */
	public StatutType trouverMetierStatutType(Long id);
	/**
	 * Méthode qui donne tous les StatutTypes.
	 * @return
	 * 		renvoie une avec tous les StatutTypes.
	 */
	public List<StatutType> listeTousMetierStatutType();
}
