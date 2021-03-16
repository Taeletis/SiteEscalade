package com.escalade.oc.dao;

import com.escalade.oc.beans.StatutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface qui permet la relation Entité et BD pour l'entité StatutType.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoStatutType extends JpaRepository <StatutType,Long>{

}
