package com.escalade.oc.dao;

import com.escalade.oc.beans.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoReservation extends JpaRepository <Reservation,Long>{

}
