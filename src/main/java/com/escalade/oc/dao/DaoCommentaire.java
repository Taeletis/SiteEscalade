package com.escalade.oc.dao;

import com.escalade.oc.beans.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface qui permet la relation Entité et BD pour l'entité Commentaire.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoCommentaire extends JpaRepository <Commentaire,Long>{

}
