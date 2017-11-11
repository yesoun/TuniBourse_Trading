package bean;

import hibernateUtil.HibernateUtil;

import java.util.ArrayList;
import org.hibernate.classic.*;
import java.util.List;
import javax.faces.component.UIParameter;
import javax.faces.model.SelectItem;
import javax.faces.event.ActionEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import persistance.Clients;
import persistance.Utilisateurs;


public class GestionClients {
	/*
	 *  private Integer idClients;
		private Utilisateurs utilisateurs;
		private Integer nbreOrange;
		private Integer nbreTelecom;
		private Integer nbreTunisiana;
	 * 
	 */

	private Utilisateurs uti = new Utilisateurs() ;
	
	private Clients cl = new Clients() ;
	
	
	public Clients getCl() { 
		return cl;
	}

	public void setCl(Clients cl) {
		this.cl = cl;
	}

	private List listP=new ArrayList(); public List getListP() { return listP; } public void setListP(List listP) { this.listP = listP; }
	 
	









///////////////////////////////ListPersonne////////////////////////////////////////////////////////////////////////
public List getListpersonne() { 
	try {
		Session session = HibernateUtil.currentSession() ;
		session.beginTransaction();
		Query q = session.createQuery("from Clients "); 
		listP = q.list(); 
		session.getTransaction().commit(); 
		} 
	catch(Exception e)
	{ } 
	return listP;
}


///////////////////////////////////////////ModifierClients////////////////////////////////////////////
public String Modifier_client() { 
	try {
		Session session = HibernateUtil.currentSession() ;
		session.beginTransaction();
		Query q = session.createQuery("from Clients "); 
		listP = q.list(); 
		session.getTransaction().commit(); 
		} 
	catch(Exception e)
	{ } 
	return "modif";
}


	

/////////////////////////////////////////////////////////////////////////////////


public String PasseAcceuil()
{

return"aller_en_acceuil";
}

public String PasseHistorique()
{
return"aller_en_historique";

}
public String PasseOrange()
{
return"aller_en_orange ";

}

public String PasseTelecom()
{
return"aller_en_telecom ";

}
public String PasseTunisiana()
{
return"aller_en_orange ";

}
	
	

	  
	














}
