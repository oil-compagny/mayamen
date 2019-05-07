package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Trajet;
import Entities.User;
@Remote

public interface UserServiceRemote {
	public User findUserById(int id) ; 
	public User getUserByEmailAndPassword(String name, String password);
	public List<Trajet>  PlusCourtChemin(String name);
	public List<Trajet>  BlockedRoute(String name);
	public List<Trajet>  AllRoutes(String name);

}
