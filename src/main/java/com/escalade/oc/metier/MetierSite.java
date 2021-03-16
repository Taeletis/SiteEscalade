package com.escalade.oc.metier;

import java.util.List;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Site;

/**
 * interface pour la couche metier de Site.
 * @author Taeletis
 *
 *
 */
public interface MetierSite {
	/**
	 *  Méthode qui ajoute un Site.
	 * @param nom
	 * 		String nom du Site.
	 * @param lienImage
	 * 		String lien url de l'image du Site.
	 * @param lieu
	 * 		String lieu du Site.
	 * @param createur
	 * 		Grimpeur créateur du SIte.
	 * @return
	 * 		renvoie le Site créé.
	 */
	public Site ajouterMetierSite(String nom,String lienImage,String lieu,Grimpeur createur);
	/**
	 * Méthode qui modifie un Site.
	 * @param nom
	 * 		String nom du Site.
	 * @param lienImage
	 * 		String lien url de l'image du Site.
	 * @param lieu
	 * 		String lieu du Site.
	 * @param s
	 * 		Site à modifier.
	 * @return
	 * 		renvoie le Site modiifé.
	 */
	public Site modifierMetierSite(String nom,String lienImage,String lieu, Site s);
	/**
	 * Méthode qui modifie un Site.
	 * @param s
	 * 		Site à modifier.
	 * @param mention
	 * 		boolean mention à modifier.
	 * @return
	 * 		renvoie le Site modifié
	 */
	public Site modifierMentionMetierSite(Site s, boolean mention);
	/**
	 * Méthode qui trouve un Site.
	 * @param id
	 * 		Long id du Site recherché.
	 * @return
	 * 		renvoie le Site trouvé.
	 */
	public Site trouverMetierSite(Long id);
	/**
	 * Méthode qui supprime un Site.
	 * @param s
	 * 		Site à supprimer.
	 */
	public void supprimerMetierSite(Site s);
	/**
	 * Méthode qui donne tous les Sites.
	 * @return
	 * 		renoie une liste des tous les Sites.
	 */
	public List<Site> listeMetierSite();
	/**
	 * Méthode qui donne la cotation d'un Site.
	 * @param s
	 * 		Site demandé.
	 * @return
	 * 		renvoie la cotation du Site.
	 */
	public String cotationMetierSite (Site s);
	/**
	 * Méthode qui trouve les Sites par nom.
	 * @param name
	 * 		String nom en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même nom.
	 */
	public List<Site> chercherParNomMetierSite(String name);
	/**
	 * Méthode qui trouve les Sites par lieu.
	 * @param endroit
	 * 		String lieu en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même lieu.
	 */
	public List<Site> chercherParLieuMetierSite(String endroit);
	/**
	 * Méthode qui trouve les Sites par Grimpeur.
	 * @param g
	 * 		Grimpeur en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même Grimpeur.
	 */
	public List<Site> chercherParGrimpeurMetierSite(Grimpeur g);
	/**
	 * Méthode qui trouve les Sites par nom de Grimpeur.
	 * @param g
	 * 		String nom du Grimpeur en paramètre de recherche.
	 * @return
	 * 			renvoie une liste de Site. ayant le même nom de Grimpeur.
	 */
	public List<Site> chercherParGrimpeurMetierSite(String g);
}
