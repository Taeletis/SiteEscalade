package com.escalade.oc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalade.oc.beans.Longueur;
@Repository
public interface DaoLongueur extends JpaRepository <Longueur,Long> {

}
