package com.escalade.oc.dao;

import com.escalade.oc.beans.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoCommentaire extends JpaRepository <Commentaire,Long>{

}
