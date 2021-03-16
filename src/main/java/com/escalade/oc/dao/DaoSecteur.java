package com.escalade.oc.dao;

import com.escalade.oc.beans.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *  interface qui permet la relation Entité et BD pour l'entité Secteur.
 * @author Taeletis
 * 
 */
@Repository
public interface DaoSecteur extends JpaRepository <Secteur,Long>{

}
