package com.escalade.oc.dao;

import com.escalade.oc.beans.Grimpeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoGrimpeur extends JpaRepository <Grimpeur,Long> {

}
