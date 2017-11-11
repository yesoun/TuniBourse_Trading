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


import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import persistance.Clients;
import persistance.Tunisiana;
import persistance.Utilisateurs;
import bean.GestionUtilisateurs;


public class GestionTunisiana {
	private GestionUtilisateurs GestionUtilisateurs;
	private GestionUtilisateurs Cu = new GestionUtilisateurs() ;
	
	

	private Tunisiana tu = new Tunisiana() ;
	public Tunisiana getTu() { 
		return tu ;
	}

	public void setTu(Tunisiana tu) {
		
		this.tu = tu;
	}
	private Tunisiana tuv = new Tunisiana() ;
	public Tunisiana getTuv() { 
		return tuv ;
	}

	public void setTuv(Tunisiana tuv) {
		
		this.tuv = tuv;
	}

private Utilisateurs ut = new Utilisateurs() ;
	public Utilisateurs getUt() { 
		return ut;
	}

	public void setUt(Utilisateurs ut) {
		this.ut = ut;
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
	
	
////////////////////////////////////////////////////////////////////////////////////	
	public String Modifier_prix()
	{
		// Tunisiana tu = new Tunisiana() ;
		
	String etat = " ";
	
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();
	Float pr =this.tu.getPrixActuel();
	System.out.print(pr);
	this.tu.setPrixActuel(pr);
	this.tu.setLogin("admin");
	//this.tu.setNbreActionRest(90);
	this.tu.setNbreVente(0);
	this.tu.setType("miseajour");
	
	// nbre d'action restant
	List list = ((org.hibernate.classic.Session) session).find("from persistance.Tunisiana ");
	Iterator it2 = list.iterator();
		
	
	int rest = 0;
	while(it2.hasNext())
	{
		persistance.Tunisiana tel = (persistance.Tunisiana)it2.next();
		rest=tel.getNbreActionRest();
		
	}
	this.tu.setNbreActionRest(rest);
	

	
	try{
		session.beginTransaction(); 
		session.save(getTu());
		session.getTransaction().commit();
	  	
	  etat = "success_prix_modif" ;

	}
	catch(Exception i){
	etat = "echec_prix_modif" ;
	}
	System.out.println(etat);
	return etat ;
	}

	
	
/////////////////////////////////////////////////////////////////////////////////////

	public String Achat_tunisiana()
	{
		
	// Tunisiana tu = new Tunisiana() ;
		
	String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	//Session sessionv = HibernateUtil.currentSession() ;
	int pr =this.tu.getNbreVente();
	System.out.print(pr);
	this.tu.setNbreVente(pr);
	
	
	
	
	GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
	System.out.print("le login depuis l'achat est :");
	System.out.print(Cu.getUt().getLogin());
	
	//String ss =currentutilisateur.getUt().getLogin();
//System.out.print(ss);
	this.tu.setLogin(Cu.getUt().getLogin());

	//this.tu.setLogin("client");
	
	
	
	//this.tu.setNbreActionRest(90);
	this.tu.setType("achat");
	//this.tu.setPrixActuel((float) 8.5);
	
	
	
	
		// Nbre client_ rest test si le nombre à acheter est supérieur ou pas à celui restant
		// et aussi le prix d'achat est le même que celui dans la requéte précédente
		List list = ((org.hibernate.classic.Session) session).find("from persistance.Tunisiana");
		Iterator it = list.iterator();
			
		
		int rest = 0;
		float prix=0;
		while(it.hasNext())
		{
			persistance.Tunisiana tel = (persistance.Tunisiana)it.next();
		
			rest=tel.getNbreActionRest();
			prix=tel.getPrixActuel();
			
		}
		
		System.out.print("nombre d'action restant Tunisiana"+rest);
		System.out.print("le prix d'achat"+prix);
		
		
		this.tu.setPrixActuel(prix);
		
			
		int nbreachat=pr;
		
		List<Clients> C1 = session.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 

	
	
	
	
	try{
		if(rest < nbreachat)
		{
			
			etat= "echec_achat";
			System.out.print(" nbre d'action tunisiana insuffisant");

		}

		else

		{
		this.tu.setNbreActionRest(rest-nbreachat);
		session.beginTransaction(); 
		session.save(tu);
		session.getTransaction().commit();
		session.beginTransaction(); 
		 Clients d1 = (Clients) session.load(Clients.class, C1.get(0).getIdClients());
		System.out.print(" nbre d'action tunisiana insuffisant");
	    d1.setNbreTunisiana(C1.get(0).getNbreTunisiana() + pr);
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
	
/////////////////////////////////Vente_tunisana///////////////////////////////////////

	
	public String Vente_tunisiana()
	{
	String etat = " ";
	Session sessionv = HibernateUtil.currentSession() ;
	sessionv.beginTransaction();
	int pr =this.tuv.getNbreVente();
	System.out.print(pr);
	this.tuv.setNbreVente(pr);
	
	
	
// pour récupérer le contexte de la session déjà entré dans la page acceuuil
	GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
	System.out.print("le login depuis la vente est :");
	System.out.print(Cu.getUt().getLogin());
	this.tuv.setLogin(Cu.getUt().getLogin());
	
	this.tuv.setType("vente");
// et aussi le prix d'achat est le même que celui dans la requéte précédente de la table tunisiana
			List lis = ((org.hibernate.classic.Session) sessionv).find("from persistance.Tunisiana");
			Iterator it = lis.iterator();
			int rest = 0;
			float prix=0;
			while(it.hasNext())
			{
				persistance.Tunisiana tun = (persistance.Tunisiana)it.next();
			
				prix=tun.getPrixActuel();
				rest=tun.getNbreActionRest();
			}
			
			System.out.print("le prix vente"+prix);
			
			this.tuv.setPrixActuel(prix);
			//il reste this.tu.getNbreActionRest() dans le cas ou il va y avoir de vente valide
	

//si Nbre action tunisian restant pour le client  est supérieur ou pas à celui qu'il veut vendre
List<Clients> C1 = sessionv.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 
System.out.print("nombre d'action Tunisiana pour le client "+C1.get(0).getNbreTunisiana());
this.ct.setUtilisateurs(ut)	;		
this.ct.setNbreOrange(C1.get(0).getNbreOrange()); // le nombre d'action orange et telecom restent
this.ct.setNbreTelecom(C1.get(0).getNbreTelecom()); // les mêmes car il s'agit d'une vente tunisiana
//pour le nombre d'action tunisiana on fera un test si le nombre d'action restant est supérieur ou pas à celui 
// à celui demandé à vendre 	
	
	
	
	
	
	try{
		// si le nombre d'action que posséde le client est inférieur à celui qu'il veut vendre
		if(C1.get(0).getNbreTunisiana()< pr)
		{
			
			etat= "echec_achat";
			System.out.println(" nbre d'action tunisiana insuffisant");

		}

		else
		// càd que la vente va se passer 
		{

		// le nombre d'action restant dans la table tunisiana est
		 this.tuv.setNbreActionRest(rest + pr);
		
		 // le nombre d'action tunisiana restant pour le client dans sa table
		  this.ct.setNbreTunisiana(C1.get(0).getNbreTunisiana() - pr);
		
		//enregidstrement de la transaction vente dans la table tunisiana
		  sessionv.beginTransaction(); 
		  sessionv.save(getTuv());
		  sessionv.getTransaction().commit();
		 	  
			  
		  sessionv.beginTransaction(); 
		  Clients d1 = (Clients) sessionv.load(Clients.class, C1.get(0).getIdClients());
		  d1.setNbreTunisiana(C1.get(0).getNbreTunisiana() - pr);
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
	
	
	
	
///////////////////////////////////ListTunisiana///////////////////////////////////////////////	
	public List getListtunisiana() { 
		try {
			Session session = HibernateUtil.currentSession() ;
			session.beginTransaction();
			Query q = session.createQuery("from Tunisiana "); 
			listP = q.list(); 
			session.getTransaction().commit(); 
			} 
		catch(Exception e)
		{ } 
		return listP;
	}


/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	 
	  public String get_historique_tunisiana()
	  // on doit parcourir la table tunisiana et puis pour la réference de l'utilisateur on fera extraire le Prix_actuel , Nbre_action , 
	  // et date

	  {
		String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();

	try{
	return   etat = "success_historique_tunisiana" ;

	}
	catch(Exception i){
	etat = "echec_historique_tunisiana" ;
	}
	return etat ;
	}

	
	  
	  public String PasseClients()
	  {
	  	
	  return"aller_en_client";
	  }

	
}
