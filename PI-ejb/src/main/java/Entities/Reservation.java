package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	int id;
	@Temporal(TemporalType.DATE)
	private Date RegistrationDate ;
	private boolean canceled ;
	private String img ;

	@OneToOne
	@JoinColumn(name="Fleet")
	private Fleet fleet;
	
	@OneToOne
	@JoinColumn(name="commande")
	private Commande commande;
	
	@ManyToOne
	private User utilisateur;
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		RegistrationDate = registrationDate;
	}
	public boolean isCanceled() {
		return canceled;
	}
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	public Fleet getFleet() {
		return fleet;
	}
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", RegistrationDate=" + RegistrationDate + ", canceled=" + canceled
				+ ", fleet=" + fleet +  ", commande=" + commande + "]";
	}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande c)
	{
		this.commande=c;
	}



}
