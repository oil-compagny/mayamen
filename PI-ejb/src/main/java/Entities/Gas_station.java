package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Gas_station
 *
 */
@Entity

public class Gas_station implements Serializable {

@Id 
private int id;

private float Caisse;

private String Address;



@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
private User gerant ; 

@ManyToMany (cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
private List <User> workers=new ArrayList() ;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public float getCaisse() {
	return Caisse;
}

public void setCaisse(float caisse) {
	Caisse = caisse;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}



public User getGerant() {
	return gerant;
}

public void setGerant(User gerant) {
	this.gerant = gerant;
}

public List<User> getWorkers() {
	return workers;
}

public void setWorkers(List<User> workers) {
	this.workers = workers;
} 
   

}
