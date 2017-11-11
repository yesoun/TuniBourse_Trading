package bean;
import hibernateUtil.HibernateUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.classic.*;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIParameter;
import javax.faces.model.SelectItem;
import javax.faces.event.ActionEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.jdbc.Statement;


import persistance.Utilisateurs;
import persistance.Telecom;
import persistance.Tunisiana;
import persistance.Clients;
import persistance.Orange;
public class essai {
	/*
	Utilisateurs ut= new Utilisateurs() ;
	
	public Utilisateurs getUt() { 
		return ut;
	}

	public void setUt(Utilisateurs ut) {
		this.ut = ut;
	}

	
	 
	 
	 Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Clients ct= new Clients() ;
		Utilisateurs ut= new Utilisateurs() ;
		
		ut.setLogin("utils");
		ut.setPassword("abcd");
		ut.setType("client");
		
				
		
		
		ct.setNbreOrange(12);
		ct.setNbreTelecom(26);
		ct.setNbreTunisiana(18);
		ct.getUtilisateurs();
		session.save(ct); 
		session.getTransaction().commit();
	
		*/


	 public static  void main(String[] args){
		
		 /*
		  * 
		  * 
		  * Ajout à la table orange
		  * Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			Orange te = new Orange() ;
			te.setNbreActionRest(8);
			te.setLogin("yessine");
			te.setNbreVente(2);
			te.setPrixActuel((float) 9.2);
			te.setType("achat");
			session.save(te); 
			session.getTransaction().commit();
		
		  * 
		  */
		 
		 /* ajout à la table utilisateurs
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Utilisateurs ut = new Utilisateurs() ;
		ut.setLogin("fares");
		ut.setPassword("ghhhh");
		ut.setType("client");
		session.save(ut); session.getTransaction().commit();
		*/ 
		/* List ListP = new ArrayList();
		
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			//Utilisateurs ut = new Utilisateurs() ;
			
			 //Query q = session.createSQLQuery(" from Utilisateurs where Login =abc " );
			//Query q = session.createSQLQuery(" Select Password from Utilisateurs where Login =?abc " );
			//List list = ((org.hibernate.classic.Session) session).find("from Utilisateurs where Type= :client");	
			// ListP = q.list();
			String nom="fares";
			List<Utilisateurs> L1 = session.createQuery("from utilisateurs where Login = '"+nom+"'").list(); 
			
			
			System.out.println(L1.get(0));
			    	
		    System.out.println(ListP.get(2).toString());
		    
		    session.close();
		 */
		 	
		 
		// Utilisateurs ut = new Utilisateurs() ;
			/*String SQL_QUERY = "SELECT * FROM utilisateurs";

		 
			Query query = session.createQuery(SQL_QUERY);
	        session.getTransaction().commit();
	        for (Iterator it = query.iterate(); it.hasNext();) {
	            Object[] row = (Object[]) it.next();
	            System.out.println("ID: " + row[1]);

	        }*/
// selection de la table !!		 
		 Session session = HibernateUtil.currentSession();
		 session.beginTransaction();

		 List ListP = new ArrayList();
			
			String nom="yessine";
		 List<Orange> L1 = session.createQuery("from persistance.Orange where Login = '"+nom+"'").list(); 
			
			
			System.out.println(L1.get(0).getType());
			    	
		    //System.out.println(ListP.get(2).toString());
		    
		    session.close();
	
		
		 
		 
		 
		 
		 
	 }

	
}