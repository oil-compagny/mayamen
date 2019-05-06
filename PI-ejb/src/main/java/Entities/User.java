package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String name;

private String last_name;
private float salary;
//@Column(unique=true)
private String email;
private String Phone;
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
private String password;	


private Boolean isActif;

@Enumerated(EnumType.STRING)
private Role role;
@OneToMany(mappedBy="fournisseur")
private List <Commande> commandesF;
@OneToMany(mappedBy="gerant")
private List <Commande> commandesG;
@OneToMany(mappedBy = "utilisateur")
private List<Reservation> reservations;



public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations = reservations;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}

public List<Commande> getCommandesF() {
	return commandesF;
}
public void setCommandesF(List<Commande> commandesF) {
	this.commandesF = commandesF;
}
public List<Commande> getCommandesG() {
	return commandesG;
}
public void setCommandesG(List<Commande> commandesG) {
	this.commandesG = commandesG;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", last_name=" + last_name + ", salary=" + salary + ", email=" + email
			+ ", password=" + password + ", isActif=" + isActif + ", role=" + role + "]";
}

}