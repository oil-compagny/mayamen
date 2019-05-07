import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import Entities.Commande;
import Entities.Fleet;
import Entities.Reservation;
import Entities.Trajet;
import Entities.User;
import Services.ServiceWeb;
import Services.UserService;


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
	private String addresseAri="Gas Station Total Ariana" ;
	private float langitude ;
	private float latitude ;
	private MapModel simpleModel;
	private Trajet bestRoute;
	private List<Trajet> markers ;
	private List<Trajet> AllRoutes ;
	private List<Trajet> BlockedRoutes ;
	private Commande details ;

	@EJB
	ServiceWeb sw ;
	@EJB
	UserService us ;
	
	@ManagedProperty("#{loginBean}")
	loginBean loginbean;
	
	public List<Trajet> AllRoadMethode(String add){
	     addresseAri=add ;
	     AllRoutes= us.AllRoutes(add);
	     System.out.println("      *****************************************"+add);
		return AllRoutes;
	}
	public Commande MoreDetails(int add)
	{
		details= sw.findCommandeById(add);
		return details;
	}
	
	public Commande getDetails() {
		return details;
	}
	public void setDetails(Commande details) {
		this.details = details;
	}
	public List<Trajet> BlockedRoadMethode(String add){
	     addresseAri=add ;
	     BlockedRoutes= us.BlockedRoute(add);
	     System.out.println("      *****************************************"+add);
		return BlockedRoutes;
	}
	public loginBean getLoginbean() {
		return loginbean;
	}
	
	public void setLoginbean(loginBean loginbean) {
		this.loginbean = loginbean;
	}


	public List<Trajet> getMarkers() {
		return markers;
	}

	public void setMarkers(List<Trajet> markers) {
		this.markers = markers;
	}

	public String getAddresseAri() {
		return addresseAri;
	}


	public void setAddresseAri(String addresseAri) {
		this.addresseAri = addresseAri;
	}


	public float getLangitude() {
		return langitude;
	}


	public void setLangitude(float langitude) {
		this.langitude = langitude;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
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
	 reservations = sw.findReservationByDrierId(loginbean.getChauffeur().getId());
	 
	 System.out.println("**************"+loginbean.getChauffeur().getId()+"*******************"+reservations.size());
		return reservations ;
	}
	
	public void addMarker() {
        Trajet marker = new Trajet();
        marker.setAddresse_arrivee("Gas Station Total Ariana");
        us.PlusCourtChemin(addresseAri).get(0);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" +langitude + ", Lng:" + langitude));
    }
//*********************************
	public void AffichageKiosque(String add)
	{
		 List<Trajet> markers ;
	     addresseAri=add ;
	     markers= us.PlusCourtChemin("Gas Station Total Ariana");
	     simpleModel = new DefaultMapModel();
         
	     for( Trajet a : markers){
	    	 LatLng coord1 = new LatLng(a.getLatitudeArrivé(), a.getDistanceArrivé());
	      
	        simpleModel.addOverlay(new Marker(coord1,a.getAddresse_arrivee())); 	
		}
	}
	public Trajet BestRoad(String add){
	     addresseAri=add ;
	     markers= us.PlusCourtChemin("Gas Station Total Ariana");
	     System.out.println("      *****************************************"+add);
	     bestRoute=markers.get(0);
		return bestRoute;
	}
	
	public MapModel getSimpleModel() {
        return simpleModel;
    }

	public Trajet getBestRoute() {
		return bestRoute;
	}

	public void setBestRoute(Trajet bestRoute) {
		this.bestRoute = bestRoute;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public List<Trajet> getAllRoutes() {
		return AllRoutes;
	}

	public void setAllRoutes(List<Trajet> allRoutes) {
		AllRoutes = allRoutes;
	}

	public List<Trajet> getBlockedRoutes() {
		return BlockedRoutes;
	}

	public void setBlockedRoutes(List<Trajet> blockedRoutes) {
		BlockedRoutes = blockedRoutes;
	}
	
}

