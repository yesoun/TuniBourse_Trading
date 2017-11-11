package bean;

import hibernateUtil.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.classic.*;
import java.util.List;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.event.ActionEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.Clients;
import persistance.Tunisiana;
import persistance.Utilisateurs;
import persistance.Telecom;
public class GestionTelecom {

	
	private Telecom te = new Telecom() ;
	public Telecom getTe() 
	{ 
		return te ;
	}

	public void setTe(Telecom te) 
	{
		this.te = te;
	}

	
private Utilisateurs ut= new Utilisateurs() ;
	public Utilisateurs getut()
			{ 
				return ut ;
			}

	public void setTe(Utilisateurs ut) 
			{
				this.ut = ut;
			}

	
private Telecom tev = new Telecom() ;
	public Telecom getTev() { 
		return tev ;
	}

	public void setTev(Telecom tev) {
		
		this.tev = tev;
	}

	
	
	
private Clients ct = new Clients() ;
	public Clients getCT() { 
		return ct ;
	}

	public void setTu(Clients ct) {
		
		this.ct = ct;
	}

	
	private List listP=new ArrayList(); 
	public List getListP() { return listP; } 
	public void setListP(List listP) { this.listP = listP; }
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////

public String Achat_telecom()
{
String etat = " ";
Session session = HibernateUtil.currentSession() ;
session.beginTransaction();
int pr =this.te.getNbreVente();
System.out.print(pr);
this.te.setNbreVente(pr);



//this.te.setLogin("client");
GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
System.out.print("le login depuis l'achat est :");
System.out.print(Cu.getUt().getLogin());
this.te.setLogin(Cu.getUt().getLogin());

this.te.setType("achat");



// Nbre client_ rest test si le nombre à acheter est supérieur ou pas à celui restant
// et aussi le prix d'achat est le même que celui dans la requéte précédente
List list = ((org.hibernate.classic.Session) session).find("from persistance.Telecom");
Iterator it = list.iterator();


int rest = 0;
float prix=0;
while(it.hasNext())
{
persistance.Telecom tel = (persistance.Telecom)it.next();

rest=tel.getNbreActionRest();
prix=tel.getPrixActuel();

}

System.out.print("nombre d'action restant telecom"+rest);
System.out.print("le prix d'achat"+prix);


this.te.setPrixActuel(prix);


int nbreachat=pr;
List<Clients> C1 = session.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 

try{
if(rest < nbreachat)
	{
	
	etat= "echec_achat";
	System.out.print(" nbre d'action telecom insuffisant");
	
	}

else
{
	this.te.setNbreActionRest(rest-nbreachat);
	session.beginTransaction(); 
	session.save(getTe());
	session.getTransaction().commit();
	System.out.println("1"); 
	  
	 
	 session.beginTransaction(); 
	 Clients d1 = (Clients) session.load(Clients.class, C1.get(0).getIdClients());
	 System.out.println("2"); 
	 d1.setNbreTelecom(C1.get(0).getNbreTelecom() + pr);
	 System.out.println("3"); 
	 session.save(d1);
	 
	  session.getTransaction().commit();
	etat = "success_achat" ;
}
}
catch(Exception i){
etat = "echec_achat" ;
}
System.out.println(etat);
return etat ;
}








/////////////////////////////////////////////////////////////////////////////////////
	
	public String Modifier_prix()
	{
		String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();
	Float pr =this.te.getPrixActuel();
	System.out.print(pr);
	this.te.setPrixActuel(pr);
	String log="admin";
	
	System.out.println(getut().getLogin());
	System.out.println("1");
	
	this.te.setLogin(log);
	this.te.setNbreVente(0);
	this.te.setType("miseajour");
	
	// nbre d'action restant
	List list = ((org.hibernate.classic.Session) session).find("from persistance.Telecom ");
	Iterator it2 = list.iterator();
		
	
	int rest = 0;
	while(it2.hasNext())
	{
		persistance.Telecom tel = (persistance.Telecom)it2.next();
		rest=tel.getNbreActionRest();
		
	}
	
	this.te.setNbreActionRest(rest);
	
	
	try
	{
		session.beginTransaction(); 
		session.save(getTe());
		session.getTransaction().commit();
	
	   etat = "success_prix_modif" ;
	}
	catch(Exception i){
	etat = "echec_prix_modif" ;
	}
	System.out.println(etat);
	return etat;
	}

	
	
////////////////////////////// Vnete Telecom ////////////////////////////////////
	public String Vente_telecom()
	{
	String etat = " ";
	Session sessionv = HibernateUtil.currentSession() ;
	sessionv.beginTransaction();
	int pr =this.tev.getNbreVente();
	System.out.print(pr);
	this.tev.setNbreVente(pr);
	
	
	
// pour récupérer le contexte de la session déjà entré dans la page acceuuil
	GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
	System.out.print("le login depuis la vente est :");
	System.out.print(Cu.getUt().getLogin());
	this.tev.setLogin(Cu.getUt().getLogin());
	
	this.tev.setType("vente");
// et aussi le prix d'achat est le même que celui dans la requéte précédente de la table tenisiana
			List lis = ((org.hibernate.classic.Session) sessionv).find("from persistance.Telecom");
			Iterator it = lis.iterator();
			int rest = 0;
			float prix=0;
			while(it.hasNext())
			{
				persistance.Telecom tun = (persistance.Telecom)it.next();
			
				prix=tun.getPrixActuel();
				rest=tun.getNbreActionRest();
			}
			
			System.out.print("le prix vente"+prix);
			
			this.tev.setPrixActuel(prix);
			//il reste this.te.getNbreActionRest() dans le cas ou il va y avoir de vente valide
	

//si Nbre action tunisian restant pour le client  est supérieur ou pas à celui qu'il veut vendre
List<Clients> C1 = sessionv.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 
System.out.print("nombre d'action telecom pour le client "+C1.get(0).getNbreTelecom());
this.ct.setUtilisateurs(ut)	;		
this.ct.setNbreOrange(C1.get(0).getNbreOrange()); // le nombre d'action orange et telecom restent
this.ct.setNbreTelecom(C1.get(0).getNbreTunisiana()); // les mêmes car il s'agit d'une vente telecom
//pour le nombre d'action telecom on fera un test si le nombre d'action restant est supérieur ou pas à celui 
// à celui demandé à vendre 	
	
	
	
	
	
	try{
		// si le nombre d'action que posséde le client est inférieur à celui qu'il veut vendre
		if(C1.get(0).getNbreTelecom()< pr)
		{
			
			etat= "echec_achat";
			System.out.println(" nbre d'action telecom insuffisant");

		}

		else
		// càd que la vente va se passer 
		{

		// le nombre d'action restant dans la table telecom est
		 this.tev.setNbreActionRest(rest + pr);
		
		 // le nombre d'action telecom restant pour le client dans sa table
		  this.ct.setNbreTelecom(C1.get(0).getNbreTelecom() - pr);
		
		//enregidstrement de la transaction vente dans la table telecom
		  sessionv.beginTransaction(); 
		  sessionv.save(getTev());
		  sessionv.getTransaction().commit();
		 	  
			  
		  sessionv.beginTransaction(); 
		  Clients d1 = (Clients) sessionv.load(Clients.class, C1.get(0).getIdClients());
		  d1.setNbreTelecom(C1.get(0).getNbreTelecom() - pr);
		  sessionv.save(d1);
		  sessionv.getTransaction().commit();
		  
				 
		}
	}
	catch(Exception i){
	etat = "echec_achat" ;
	}
	System.out.println(etat);
	return etat ;


		
		
		
	
	}
	
	
	
	
	
	
	


//////////////////////////////ListeTelecom/////////////////////////////////////////////////////////////
	  
		public List getListtelecom() { 
			try {
				Session session = HibernateUtil.currentSession() ;
				session.beginTransaction();
				Query q = session.createQuery("from Telecom "); 
				listP = q.list(); 
				session.getTransaction().commit(); 
				} 
			catch(Exception e)
			{ } 
			return listP;
		}
	  
/////////////////////////////////////////////////////////////////
	  public String PasseClients()
	  {
	  	
	  return"aller_en_client";
	  }

	  
	
	
}
