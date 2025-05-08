package com.auribises.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import com.auribises.model.Restaurant;

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
	
	public String saveObject(Object object) {
		transaction.begin();
		session.persist(object);
		transaction.commit();
		System.out.println("Object saved");
		return "Object Saved in Database :)";
	}
	
	public List<Restaurant> fetchAllObjects() {
		// Explore new API against createCriteria here :)
		HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Restaurant> query = builder.createQuery(Restaurant.class);
		JpaRoot<Restaurant> root = query.from(Restaurant.class);

		query.select(root);

		List<Restaurant> restaurants = session.createQuery(query).getResultList();
		return restaurants;
	}
	
	public void close() {
		session.close();
		sessionFactory.close();
		System.out.println("Session Closed");
	}

}
