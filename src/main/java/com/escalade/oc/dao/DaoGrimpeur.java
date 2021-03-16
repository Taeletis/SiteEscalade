package com.escalade.oc.dao;

import com.escalade.oc.beans.Grimpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * interface qui permet la relation Entité et BD pour l'entité Grimpeur.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoGrimpeur extends JpaRepository <Grimpeur,Long> {

}
