package com.escalade.oc.dao;

import com.escalade.oc.beans.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoSite extends JpaRepository <Site,Long>{

}
