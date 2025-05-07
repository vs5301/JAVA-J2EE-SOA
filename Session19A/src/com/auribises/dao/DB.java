package com.auribises.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
 * Hibernate APIs
 * 
 * 	SessionFactory 	-> it maintains Session Objects
 * 		to create SessionFactory Instance StandardServiceRegistry and MedataSources API
 * 
 * 	Session 		-> Session is connection with the database through Hibernate
 * 	Transaction 	-> Any CUD Operation in Hibernate is a Transaction
 */

public class DB {
	
	SessionFactory sessionFactory;
	Session session;
	Transaction transaction;
	
	public DB() {
		
		try {
//			Reading hibernate.cfg.xml file and managing the operations in the background
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
//		Obtain connection to the database
		session = sessionFactory.openSession();
		
//		Obtain transaction from the session
		transaction = session.getTransaction();
	}
	
	public void saveObject(Object object) {
		transaction.begin();
		session.persist(object);
		transaction.commit();
		System.out.println("Object saved");
	}
	
	public void close() {
		session.close();
		sessionFactory.close();
		System.out.println("Session Closed");
	}

}
