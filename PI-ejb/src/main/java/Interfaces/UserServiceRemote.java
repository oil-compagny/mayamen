package Interfaces;

import javax.ejb.Remote;

import Entities.User;
@Remote

public interface UserServiceRemote {
	public User findUserById(int id) ; 
	public User getUserByEmailAndPassword(String name, String password);

}
