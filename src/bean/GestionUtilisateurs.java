package bean;
import hibernateUtil.HibernateUtil;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.classic.*;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.model.SelectItem;
import javax.faces.event.ActionEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import persistance.Utilisateurs;
import persistance.Clients;





public class GestionUtilisateurs {
//	@ManagedProperty(value="#{ut}")
	
	private List ListP = new ArrayList();
	
	private Utilisateurs ut = new Utilisateurs() ;
	
	
	public Utilisateurs getUt() { 
		return ut;
	}

	public void setUt(Utilisateurs ut) {
		this.ut = ut;
	}
	private Clients ct = new Clients() ;
	
	public Clients getCt() { 
		return ct;
	}

	public void setCt(Clients ct) {
		this.ct = ct;
	}
	
	
	
///////////////////////////////Verif_Utilisateur////////////////////////////////////
	@SuppressWarnings("unchecked")
	public String Verif_Utilisateur()
	
	{
		

		
		String etat = " ";
		String log= this.ut.getLogin();
		String pass= this.ut.getPassword();
		
	try
	{

		Session session = HibernateUtil.currentSession() ;
		session.beginTransaction();
		
		 List<Utilisateurs> L1 = session.createQuery("from persistance.Utilisateurs where Login = '"+log+"' and Password= '"+pass+ "' ").list(); 
			
			System.out.println(L1.get(0).getType());
	if 	((L1.get(0).getType().compareTo(("client")))==0)
		{
		System.out.println("client");
		
	etat="success_client";
	session.getTransaction().commit();
	System.out.println("okclient");
	}
	if 	((L1.get(0).getType().compareTo(("admin")))==0)
	{
	System.out.println("admin");
	
etat="success_admin";
session.getTransaction().commit();
System.out.println("okadmin");
}
	}
	catch (Exception i)	
	{
		etat="echec_verif";
	}
		
	System.out.print(etat);	
		return etat;

}
		

	
	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////// fonction ajout de utilisateurs chez l'intermédiaiare en Bourse/////////
	
		public String Ajout_Utilisateur()
		{
			String etat = " ";
			Session session = HibernateUtil.currentSession() ;
			session.beginTransaction();
			
			
			try{
				// enregitrement de l'utilisateur dans table Utilisateurs
				Utilisateurs uti = getUt();
				
				session.beginTransaction(); 
				session.save(getUt());
				
				session.getTransaction().commit();
			
			
				// si l'utilisateurs ajouté est un client alors on l'enregistre dans la clients
					
				if ((getUt().getType().compareTo(("client")))==0)
				{
				this.ct.setNbreOrange(0);
				this.ct.setNbreTelecom(0);
				this.ct.setNbreTunisiana(0);
				this.ct.setUtilisateurs(ut);

				session.beginTransaction(); 
				session.save(ct);
				
				session.getTransaction().commit();
			
				etat = "success_ajout" ;
				}
			
				else etat = "success_ajout" ;
					
			}
			catch(Exception i){
			etat = "echec_ajout" ;
			}

			return etat ;
					}
		
	
		// fin méthode Ajout d'un utilisateur
		

		
		
///////////////////////////////// méthode supprimer utilisateur ///////////////////////////////// 
		
		  public String Supprimer_Utilisateur()
		{
			String etat = " ";
		Session session = HibernateUtil.currentSession() ;
		session.beginTransaction();
        try{
		   etat = "success_supprimer" ;

		}
		catch(Exception i){
		etat = "echec_supprimer" ;
		}
		return etat ;
		}
		
		// fin méthode Supprimer un utilisateur

		
		  public String passeacceuil()
			{
		return "aller_acceuil";

}
}