package com.escalade.oc.dao;

import com.escalade.oc.beans.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoTopo extends JpaRepository <Topo,Long>{

}
