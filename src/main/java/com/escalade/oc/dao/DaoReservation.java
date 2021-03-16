package com.escalade.oc.dao;

import com.escalade.oc.beans.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * interface qui permet la relation Entité et BD pour l'entité Reservation.
 * @author Taeletis
 *  
 */
@Repository
public interface DaoReservation extends JpaRepository <Reservation,Long>{

}
