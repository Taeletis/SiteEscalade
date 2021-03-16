package com.escalade.oc.dao;

import com.escalade.oc.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * interface qui permet la relation Entité et BD pour l'entité Topo.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoTopo extends JpaRepository <Topo,Long>{

}
