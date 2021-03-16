package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.StatutType;
import com.escalade.oc.dao.DaoStatutType;
import com.escalade.oc.metier.MetierStatutType;
/**
 * Class pour la couche metier de StatutType.
 * @author Taeletis
 * 
 *         
 *
 */
@Service
public class MetierStatutTypeImpl implements MetierStatutType{
	/**
	 * injection de DaoSecteur.
	 */
	@Autowired
	private DaoStatutType daoStatutType;
	/**
	 * Méthode qui ajoute un StatutType.
	 * @param statut
	 * 		String type du statut.
	 * @return
	 * 		renvoie le StatutType créé.
	 */
	@Override
	public StatutType ajouterMetierStatutType(String statut) {
		StatutType s =new StatutType(statut);
		try {
			s=daoStatutType.save(s);
		}catch(Exception e) {
			
		}
		return s;
		
	}
	/**
	 * Méthode qui modifie un StatutType.
	 * @param statut
	 * 		String type à modifier.
	 * @param s
	 * 		StatutType à modifier.
	 * @return
	 * renvoie le StatutType modifié.
	 */
	@Override
	public StatutType modifierMetierStatutType(String statut, StatutType s) {
		s.setStatut(statut);
		try {
			s=daoStatutType.save(s);
		}catch(Exception e) {
			
		}
		return s;
	}
	/**
	 * Méthode qui supprime un Site.
	 * @param s
	 * 		StatutType à supprimer.
	 */
	@Override
	public void supprimerMetierStatutType(StatutType s) {
		try {
			daoStatutType.delete(s);
		}catch(Exception e) {
			
		}

	}
	/**
	 * Méthode qui trouve les StatutTypes par id.
	 * @param id
	 * 		Long id du StatutType recherché.
	 * @return
	 * 		renvoie le StatutType trouvé.
	 */
	@Override
	public StatutType trouverMetierStatutType(Long id) {
		List<StatutType> list = new ArrayList<StatutType>();
		StatutType s = null;
		try {
			list.addAll(listeTousMetierStatutType());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				Long idGrimpeur = s.getIdStatut();
				if (idGrimpeur == id) {
					break;
				}

			}
		} catch (Exception e) {
		}
		return s;
}
	/**
	 * Méthode qui donne tous les StatutTypes.
	 * @return
	 * 		renvoie une avec tous les StatutTypes.
	 */
	@Override
	public List<StatutType> listeTousMetierStatutType() {
		List<StatutType> list=null;

		try {
			list = daoStatutType.findAll();
					
			
		} catch (Exception e) {

		}
		return list;
	}

}
