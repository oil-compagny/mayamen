
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.User;
import Services.UserService;




@ManagedBean(name="loginBean",eager=true) 
@SessionScoped
public class loginBean  {

private String login; 
private String pwd; 
private User chauffeur; 
private Boolean loggedIn;
private int id;
private String name ;
//public  int iden; 

@EJB
private UserService us ;
public String doLogin()
{
	System.out.println("before testing function*************"+name+"***pass***:"+pwd);
	chauffeur = us.getUserByEmailAndPassword(name, pwd);
	String navigateTo = "null"; 
	
	System.out.println("Can " + chauffeur.getId()); 
	if (chauffeur.getId()!=0) {
		navigateTo = "/Driver?faces-redirect=true";
		loggedIn = true; 
	}
	else 
	{
		
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		loggedIn = false;
	}
	return navigateTo; 

}
public loginBean(String login, String pwd, User chauffeur, Boolean loggedIn, int id, UserService us,String name) {
	super();
	this.login = login;
	this.pwd = pwd;
	this.chauffeur = chauffeur;
	this.loggedIn = loggedIn;
	this.id = id;
	this.us = us;
	this.name=name ;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public loginBean() {
	super();
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public User getChauffeur() {
	return chauffeur;
}
public void setChauffeur(User chauffeur) {
	this.chauffeur = chauffeur;
}
public Boolean getLoggedIn() {
	return loggedIn;
}
public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public UserService getUs() {
	return us;
}
public void setUs(UserService us) {
	this.us = us;
}

}



