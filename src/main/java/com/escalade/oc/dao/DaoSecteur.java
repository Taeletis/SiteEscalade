package com.escalade.oc.dao;

import com.escalade.oc.beans.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoSecteur extends JpaRepository <Secteur,Long>{

}
