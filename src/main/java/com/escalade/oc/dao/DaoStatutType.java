package com.escalade.oc.dao;

import com.escalade.oc.beans.StatutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoStatutType extends JpaRepository <StatutType,Long>{

}
