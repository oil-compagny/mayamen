package Services;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Commande;
import Entities.Fleet;
import Entities.Reservation;
import Entities.User;
import Interfaces.ServiceWebInterface;
@Stateless
@LocalBean
public class ServiceWeb implements ServiceWebInterface{

	@PersistenceContext(unitName ="imputation-ejb")
	EntityManager em ;
	public List<Reservation> findReservationByDrierId(int id) {
		TypedQuery<Reservation> liste = em.createQuery("select r from Reservation r join r.utilisateur u  where u.id=:val",Reservation.class).setParameter("val",id);
		List<Reservation> listResultat = liste.getResultList();
		
		return  listResultat;
	}
	@Override
	public List<Reservation> findReservationByCommande(int id) {
		Commande commande =em.find(Commande.class,id);
		TypedQuery<Reservation> liste = em.createQuery("select r from Reservation r   where r.commande=:val",Reservation.class).setParameter("val",commande);
		List<Reservation> listResultat = liste.getResultList();
		
		return  listResultat;
	}
	@Override
	public Commande findCommandeById(int id) {
		System.out.println("find Commande by id ! ");
		Commande commande =em.find(Commande.class,id);
        System.out.println("ind Commande by id done ! " );			
        return commande;		
	}
	
	
}
