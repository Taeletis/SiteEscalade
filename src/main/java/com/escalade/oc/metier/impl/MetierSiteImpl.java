package com.escalade.oc.metier.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalade.oc.beans.Grimpeur;
import com.escalade.oc.beans.Secteur;
import com.escalade.oc.beans.Site;
import com.escalade.oc.dao.DaoSite;
import com.escalade.oc.metier.MetierSecteur;
import com.escalade.oc.metier.MetierSite;
/**
 * Class pour la couche metier de Site.
 * @author Taeletis
 * 
 *         
 *
 */
@Service
public class MetierSiteImpl implements MetierSite {
	/**
	 * injection de DaoSite.
	 */
	@Autowired
	private DaoSite daoSite;
	/**
	 * injection de MetierSecteur.
	 */
	@Autowired
	private MetierSecteur metierSecteur;
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
	@Override
	public Site ajouterMetierSite(String nom, String lienImage, String lieu,Grimpeur createur) {
		Site s = new Site(nom, lienImage, lieu,createur);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;
	}
	/**
	 * Méthode qui modifie un Site.
	 * @param nom
	 * 		String nom du Site à modifier.
	 * @param lienImage
	 * 		String lien url de l'image du Site.
	 * @param lieu
	 * 		String lieu du Site.
	 * @param s
	 * 		Site à modifier.
	 * @return
	 * 		renvoie le Site modiifé.
	 */
	@Override
	public Site modifierMetierSite(String nom, String lienImage, String lieu, Site s) {
		s.setNom(nom);
		s.setLienImage(lienImage);
		s.setLieu(lieu);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;

	}
	/**
	 * Méthode qui modifie un Site.
	 * @param s
	 * 		Site à modifier.
	 * @param mention
	 * 		Boolean metion à modifier.
	 * @return
	 * 		renvoie le Site modiifié
	 */
	@Override
	public Site modifierMentionMetierSite(Site s, boolean mention) {
		s.setMention(mention);
		try {
			s = daoSite.save(s);
		} catch (Exception e) {
		}
		return s;
	}
	/**
	 * Méthode qui trouve un Site.
	 * @param id
	 * 		Long id du Site recherché?
	 * @return
	 * 		renvoie le Site trouvé.
	 */
	@Override
	public Site trouverMetierSite(Long id) {
		List<Site> list = new ArrayList<Site>();
		Site s = null;
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				Long idSite = s.getIdSite();
				if (idSite == id) {
					break;
				}

			}
		} catch (Exception e) {

		}
		return s;
	}
	/**
	 * Méthode qui supprime un Site.
	 * @param s
	 * 		Site à supprimer.
	 */
	@Override
	public void supprimerMetierSite(Site s) {
		try {
			daoSite.delete(s);
		} catch (Exception e) {
		}
	}
	/**
	 * Méthode qui donne la cotation d'un Site.
	 * @param s
	 * 		Site demandé.
	 * @return
	 * 		renvoie la cotation du Site.
	 */
	@Override
	public String cotationMetierSite(Site s) {
		List<Secteur> list = metierSecteur.listeParSiteMetierSecteur(s);
		String cotation = "";
		int valeur;
		int valeurHaute = 0;
		String niveau = "A";
		for (int i = 0; i < list.size(); i++) {
			Secteur secteur = list.get(i);
			String cotationSecteur = metierSecteur.cotationMetierSecteur(secteur);
			if (cotationSecteur.length() == 2) {
				String chiffre = cotationSecteur.substring(0, 1);
				valeur = Integer.parseInt(chiffre);
				if (valeurHaute < valeur) {
					String lettre = cotationSecteur.substring(1);
					valeurHaute = valeur;
					cotation = valeurHaute + lettre;
				}
				if (valeurHaute == valeur) {
					String lettre = cotationSecteur.substring(1);
					if (!niveau.equals(lettre)) {
						if (lettre.equals("B") && niveau.equals("A") || lettre.equals("C") && niveau.equals("A")
								|| lettre.equals("C") && niveau.equals("B")) {
							cotation = valeurHaute + lettre;
							niveau=lettre;
						}
					}
				}

			}
		}
		return cotation;
	}
	/**
	 * Méthode qui donne tous les Sites.
	 * @return
	 * 		renoie une liste des tous les Sites.
	 */
	@Override
	public List<Site> listeMetierSite() {
		List<Site> list = null;
		try {
			list = daoSite.findAll();

		} catch (Exception e) {

		}
		return list;
	}
	/**
	 * Méthode qui trouve les Sites par nom.
	 * @param name
	 * 		String nom en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même nom.
	 */
	@Override
	public List<Site> chercherParNomMetierSite(String name) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		Site s;
		if(name!=null) {
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				String nom = s.getNom();
				if (nom.contains(name)) {
					listReturn.add(s);
				}

			}
			
		} catch (Exception e) {

		}
		}
		return listReturn;
	}
	/**
	 * Méthode qui trouve les Sites par lieu.
	 * @param endroit
	 * 		String lieu en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même lieu.
	 */
	@Override
	public List<Site> chercherParLieuMetierSite(String endroit) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		System.out.println(endroit+" metier");
		if(endroit!=null) {
		try {
			list.addAll(listeMetierSite());
			for (Site s: list) {
				
				String lieu = s.getLieu();
				if (lieu.contains(endroit)) {
					listReturn.add(s);
					System.out.println(listReturn);
				}

			}
			
		} catch (Exception e) {

		}
		}
		System.out.println(listReturn);
		return listReturn;
	}
	/**
	 * Méthode qui trouve les Sites par nom de Grimpeur.
	 * @param g
	 * 		String nom du Grimpeur en paramètre de recherche.
	 * @return
	 * 			renvoie une liste de Site. ayant le même nom de Grimpeur.
	 */	
	public List<Site> chercherParGrimpeurMetierSite(String  g) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		Site s;
		try {
			if(g!=null) {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				Grimpeur gg = s.getCreateur();
				if (gg.getNom().contains(g)) {
					listReturn.add(s);
				}

			}
			}
		} catch (Exception e) {

		}
		return listReturn;
	}
	/**
	 * Méthode qui trouve les Sites par Grimpeur.
	 * @param g
	 * 		Grimpeur en paramètre de recherche.
	 * @return
	 * 		renvoie une liste de Site. ayant le même Grimpeur.
	 */	
	public List<Site> chercherParGrimpeurMetierSite(Grimpeur  g) {
		List<Site> list = new ArrayList<Site>();
		List<Site> listReturn = new ArrayList<Site>();
		Site s;
		try {
			list.addAll(listeMetierSite());
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				Grimpeur gg = s.getCreateur();
				if (g.getIdGrimpeur().equals(gg.getIdGrimpeur())) {
					listReturn.add(s);
				}

			}
		
		} catch (Exception e) {

		}
		return listReturn;
	}
}