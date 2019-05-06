package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Commande;

@Remote
public interface CommandeServiceRemote {

	public void addCommande(Commande c) ; 
	public void removeCommande(int id) ;
	public void updateCommande(Commande c) ;
	public Commande findCommandeById(int id) ; 
	public List<Commande> findAllCommande();
	public List<Commande> findAllCommandeTotreat();
	public List<Commande> findAllCommandeReceived();
	public List <Commande> findAllCommandeCanceled();
	
	

}
