package Services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Fleet;
import Entities.Trajet;
import Entities.User;
import Interfaces.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote{
	@PersistenceContext(unitName ="imputation-ejb")
	EntityManager em ;

	@Override
	public User findUserById(int id) {
		User u =em.find(User.class,id);		
		return u;
	}
	public User getUserByEmailAndPassword(String name, String password) {
		User user = null; 

		TypedQuery<User> query = em.createQuery("select e from User e where e.name like :name AND e.password like :password", User.class); 

		query.setParameter("name", name); 
		query.setParameter("password", password); 

		try { user = query.getSingleResult(); }
		catch (NoResultException nre) { System.out.println("Erreur : " + nre); }
		return user;
		}
	@Override
	public List<Trajet> PlusCourtChemin(String name) {
		List<Trajet>  trajet= null ;
       TypedQuery<Trajet> query = em.createQuery("select e from Trajet e where e.traveaux=0 AND e.addresse_arrivee=:name ORDER BY e.distance ASC)", Trajet.class); 
       query.setParameter("name", name); 
       try { trajet = query.getResultList(); }
		catch (NoResultException nre) { System.out.println("Erreur : " + nre); }
       return trajet;
	}
	@Override
	public List<Trajet> BlockedRoute(String name) {
		List<Trajet>  trajet= null ;
	       TypedQuery<Trajet> query = em.createQuery("select e from Trajet e where e.traveaux=1 AND e.addresse_arrivee=:name ORDER BY e.distance ASC)", Trajet.class); 
	       query.setParameter("name", name); 
	       try { trajet = query.getResultList(); }
			catch (NoResultException nre) { System.out.println("Erreur : " + nre); }
	       return trajet;
	}
	@Override
	public List<Trajet> AllRoutes(String name) {
		List<Trajet>  trajet= null ;
	       TypedQuery<Trajet> query = em.createQuery("select e from Trajet e where e.traveaux=0 AND e.addresse_arrivee=:name ORDER BY e.distance ASC)", Trajet.class); 
	       query.setParameter("name","%" + name + "%" ); 
	       try { trajet = query.getResultList(); }
			catch (NoResultException nre) { System.out.println("Erreur : " + nre); }
	       return trajet;
	}
	
	
   
}
