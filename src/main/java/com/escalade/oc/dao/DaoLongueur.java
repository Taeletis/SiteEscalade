package com.escalade.oc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalade.oc.beans.Longueur;
/**
 * interface qui permet la relation Entité et BD pour l'entité Longueur.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoLongueur extends JpaRepository <Longueur,Long> {

}
