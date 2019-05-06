package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Reservation;
@Remote
public interface ServiceWebInterface {
	 List<Reservation> findReservationByDrierId(int id);
}
