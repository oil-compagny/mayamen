package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trajet  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	int id;
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private String addresse_depart ;
	private String addresse_arrivee ;
	private int tempsApro ;
	private float langitude ;
	private float latitude ;
	private float distance ;
	private float latitudeArrivé ;
	private float distanceArrivé ;

	@OneToOne(mappedBy="trajet")
	private Commande commande ;
	private Boolean traveaux ;
	
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
	
	public float getLatitudeArrivé() {
		return latitudeArrivé;
	}
	public void setLatitudeArrivé(float latitudeArrivé) {
		this.latitudeArrivé = latitudeArrivé;
	}
	public float getDistanceArrivé() {
		return distanceArrivé;
	}
	public void setDistanceArrivé(float distanceArrivé) {
		this.distanceArrivé = distanceArrivé;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddresse_depart() {
		return addresse_depart;
	}
	public void setAddresse_depart(String addresse_depart) {
		this.addresse_depart = addresse_depart;
	}
	public String getAddresse_arrivee() {
		return addresse_arrivee;
	}
	public void setAddresse_arrivee(String addresse_arrivee) {
		this.addresse_arrivee = addresse_arrivee;
	}
	public int getTempsApro() {
		return tempsApro;
	}
	public void setTempsApro(int tempsApro) {
		this.tempsApro = tempsApro;
	}
	
	public Boolean getTraveaux() {
		return traveaux;
	}
	public void setTraveaux(Boolean traveaux) {
		this.traveaux = traveaux;
	}
	public Trajet() {
		super();
	}
	@Override
	public String toString() {
		return "Trajet [id=" + id + ", addresse_depart=" + addresse_depart + ", addresse_arrivee=" + addresse_arrivee
				+ ", tempsApro=" + tempsApro + ", langitude=" + langitude + ", latitude=" + latitude + ", distance="
				+ distance + ", latitudeArrivé=" + latitudeArrivé + ", distanceArrivé=" + distanceArrivé + ", commande="
				+ commande + ", traveaux=" + traveaux + "]";
	}
	
}
