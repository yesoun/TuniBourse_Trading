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
import persistance.Orange;
//import persistance.Telecom;
import persistance.Utilisateurs;

/*
 * 
Integer idOrange;
String login;
String type;
Float prixActuel;
Integer nbreVente;
Integer nbreActionRest;

 * 
 */
	
public class GestionOrange {

	
	private Orange ora = new Orange() ;
	public Orange get_Orange() { 
		return ora;
	}

	public void set_Orange( Orange oran) {
		this.ora = oran;
	}
	
	
	
	private Orange tov = new Orange() ;
	public Orange getTov() { 
		return tov ;
	}
	public void setTov(Orange tov) {
		
		this.tov = tov;
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
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	public String Modifier_prix()
	{
		String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();
	Float pr =this.ora.getPrixActuel();
	System.out.print(pr);
	
	this.ora.setPrixActuel(pr);
	System.out.println("1");
	this.ora.setLogin("admin");
	//this.ora.setNbreActionRest(90);
	System.out.println("2");
	this.ora.setNbreVente(0);
	List list0 = ((org.hibernate.classic.Session) session).find("from persistance.Orange");
	System.out.println("3");
	Iterator it0 = list0.iterator();
	System.out.println("4");
	int rest = 0;
	while(it0.hasNext())
	{
		persistance.Orange tor = (persistance.Orange)it0.next();
		System.out.println(rest);
		
		rest=tor.getNbreActionRest();
		System.out.println(rest + "/n");
		
	}
	System.out.println("5");
	
	this.ora.setNbreActionRest(rest);
	this.ora.setType("miseajour");
	
	
	
	try{
		session.beginTransaction(); 
		session.save(get_Orange());
		session.getTransaction().commit();
	  
		// telecom.prix_actuel=val
		//reference =0 // car c'est l'admin
		// Nbre_action_rest = Nbre_action_rest
		//Nbre
	   etat = "success_prix_modif" ;

	}
	catch(Exception i){
	etat = "echec_prix_modif" ;
	}
	System.out.println(etat);
	return etat;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	public String Achat_orange()
	{
		String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();
	int pr =this.ora.getNbreVente();
	System.out.print(pr);
	this.ora.setNbreVente(pr);
	//this.ora.setLogin("client");
	GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
	System.out.print("le login depuis l'achat est :");
	System.out.print(Cu.getUt().getLogin());
	this.ora.setLogin(Cu.getUt().getLogin());

	
	
	
	
	
	//this.ora.setNbreActionRest(90);
	this.ora.setType("achat");
	//this.ora.setPrixActuel((float) 8.5);
	// Nbre client_ rest test si le nombre à acheter est supérieur ou pas à celui restant
	// et aussi le prix d'achat est le même que celui dans la requéte précédente
	List list4 = ((org.hibernate.classic.Session) session).find("from persistance.Orange");
	Iterator it4 = list4.iterator();


	int rest = 0;
	float prix=0;
	while(it4.hasNext())
	{
	persistance.Orange oor = (persistance.Orange)it4.next();

	rest=oor.getNbreActionRest();
	prix=oor.getPrixActuel();

	}

	System.out.print("nombre d'action restant orange"+rest);
	System.out.print("le prix d'achat"+prix);


	this.ora.setPrixActuel(prix);


	int nbreachat=pr;
	List<Clients> C1 = session.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 

	try{
	if(rest < nbreachat)
		{
		
		etat= "echec_achat";
		System.out.print(" nbre d'action orange insuffisant");
		
		}

	else
	{
		this.ora.setNbreActionRest(rest-nbreachat);
		session.beginTransaction(); 
		session.save(get_Orange());
		session.getTransaction().commit();
		 session.beginTransaction(); 
		 // update dans la base clients lenbre orange
		 Clients d1 = (Clients) session.load(Clients.class, C1.get(0).getIdClients());
		 System.out.println("2"); 
		 d1.setNbreOrange(C1.get(0).getNbreOrange() + pr);
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

	
////////////////////////////////////// Vente Orange ////////////////////////////////////////////
	public String Vente_orange()
	{
	String etat = " ";
	Session sessionv = HibernateUtil.currentSession() ;
	sessionv.beginTransaction();
	int pr =this.tov.getNbreVente();
	System.out.print(pr);
	this.tov.setNbreVente(pr);
	
	
	
// pour récupérer le contexte de la session déjà entré dans la page acceuuil
	GestionUtilisateurs Cu = (GestionUtilisateurs) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cu");
	System.out.print("le login depuis la vente est :");
	System.out.print(Cu.getUt().getLogin());
	this.tov.setLogin(Cu.getUt().getLogin());
	
	this.tov.setType("vente");
// et aussi le prix d'achat est le même que celui dans la requéte précédente de la table tenisiana
			List lis = ((org.hibernate.classic.Session) sessionv).find("from persistance.Orange");
			Iterator it = lis.iterator();
			int rest = 0;
			float prix=0;
			while(it.hasNext())
			{
				persistance.Orange tun = (persistance.Orange)it.next();
			
				prix=tun.getPrixActuel();
				rest=tun.getNbreActionRest();
			}
			
			System.out.print("le prix vente"+prix);
			
			this.tov.setPrixActuel(prix);
			//il reste this.te.getNbreActionRest() dans le cas ou il va y avoir de vente valide
	

//si Nbre action tunisian restant pour le client  est supérieur ou pas à celui qu'il veut vendre
List<Clients> C1 = sessionv.createQuery("from persistance.Clients where Login = '"+Cu.getUt().getLogin()+"'  ").list(); 
System.out.print("nombre d'action orange pour le client "+C1.get(0).getNbreOrange());
this.ct.setUtilisateurs(ut)	;		
this.ct.setNbreOrange(C1.get(0).getNbreOrange()); // le nombre d'action orange et orange restent
this.ct.setNbreOrange(C1.get(0).getNbreTunisiana()); // les mêmes car il s'agit d'une vente orange
//pour le nombre d'action orange on fera un test si le nombre d'action restant est supérieur ou pas à celui 
// à celui demandé à vendre 	
	
	
	
	
	
	try{
		// si le nombre d'action que posséde le client est inférieur à celui qu'il veut vendre
		if(C1.get(0).getNbreOrange()< pr)
		{
			
			etat= "echec_achat";
			System.out.println(" nbre d'action orange insuffisant");

		}

		else
		// càd que la vente va se passer 
		{

		// le nombre d'action restant dans la table orange est
		 this.tov.setNbreActionRest(rest + pr);
		
		 // le nombre d'action orange restant pour le client dans sa table
		  this.ct.setNbreOrange(C1.get(0).getNbreOrange() - pr);
		
		//enregidstrement de la transaction vente dans la table orange
		  sessionv.beginTransaction(); 
		  sessionv.save(getTov());
		  sessionv.getTransaction().commit();
		 	  
			  
		  sessionv.beginTransaction(); 
		  Clients d1 = (Clients) sessionv.load(Clients.class, C1.get(0).getIdClients());
		  d1.setNbreOrange(C1.get(0).getNbreOrange() - pr);
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

////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public List getListorange() { 
		try {
			Session session = HibernateUtil.currentSession() ;
			session.beginTransaction();
			Query q = session.createQuery("from Orange "); 
			listP = q.list(); 
			session.getTransaction().commit(); 
			} 
		catch(Exception e)
		{ } 
		return listP;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	  public String get_historique_orange()
	  // on doit parcourir la table telecom et puis pour la réference de l'utilisateur on fera extraire le Prix_actuel , Nbre_action , 
	  // et date

	  {
		String etat = " ";
	Session session = HibernateUtil.currentSession() ;
	session.beginTransaction();

	try{
	return   etat = "success_historique_orange" ;

	}
	catch(Exception i){
	etat = "echec_historique_orange" ;
	}
	return etat ;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
