import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import Entities.Commande;
import Entities.Fleet;
import Entities.Reservation;
import Entities.User;
import Services.ServiceWeb;


@ManagedBean(name = "chauffeurBean",eager=true) 
@SessionScoped

public class ChauffeurBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	private Date RegistrationDate ;
	private boolean canceled ;
	private Fleet fleet;
	private User chauffeur ;
	private Commande commande;
	private String img ;
	private List<Reservation> reservations;
	private String password;
	private String name;
	@EJB
	ServiceWeb sw ;
	
	@ManagedProperty("#{loginBean}")
	loginBean loginbean;
	
	
	public loginBean getLoginbean() {
		return loginbean;
	}


	public void setLoginbean(loginBean loginbean) {
		this.loginbean = loginbean;
	}


	public ChauffeurBean() {
		super();
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ChauffeurBean(int id, Date registrationDate, boolean canceled, Fleet fleet, User chauffeur,
			Commande commande, List<Reservation> reservations, ServiceWeb sw, String img) {
		super();
		this.id = id;
		RegistrationDate = registrationDate;
		this.canceled = canceled;
		this.fleet = fleet;
		this.chauffeur = chauffeur;
		this.commande = commande;
		this.reservations = reservations;
		this.sw = sw;
		this.img=img ;
	}

	public ServiceWeb getSw() {
		return sw;
	}

	public void setSw(ServiceWeb sw) {
		this.sw = sw;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public User getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(User chauffeur) {
		this.chauffeur = chauffeur;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<Reservation> getReservations() {
		return ChauffeurBeanMethode();
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Reservation> ChauffeurBeanMethode() {
		// TODO Auto-generated constructor stub
		reservations = sw.findReservationByDrierId(loginbean.getChauffeur().getId());//This is for testing purpose
		System.out.println("**************"+loginbean.getChauffeur().getId()+"*******************"+reservations.size());
		return reservations ;
	}
	
	/*public String refreshDriver(){
		
		reservations = sw.findReservationByDrierId(1);//This is for testing purpose
		System.out.println("*********************************"+reservations.size());
		return "/Driver?faces-redirect=true";
	}*/

	
}
