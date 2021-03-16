package com.escalade.oc.dao;

import com.escalade.oc.beans.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *  interface qui permet la relation Entité et BD pour l'entité Site.
 * @author Taeletis
 * 
 */
@Repository
public interface DaoSite extends JpaRepository <Site,Long>{

}
