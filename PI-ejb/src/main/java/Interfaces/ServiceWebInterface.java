package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Commande;
import Entities.Reservation;
@Remote
public interface ServiceWebInterface {
	public List<Reservation> findReservationByDrierId(int id);
	 public List<Reservation> findReservationByCommande(int id);
		public Commande findCommandeById(int id) ; 

}
