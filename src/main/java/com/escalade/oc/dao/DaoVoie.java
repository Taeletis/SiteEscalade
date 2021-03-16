package com.escalade.oc.dao;

import com.escalade.oc.beans.Voie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * interface qui permet la relation Entité et BD pour l'entité Voie.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoVoie extends JpaRepository <Voie,Long>{

}

