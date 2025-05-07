package com.auribises.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.Document;

public class User {
	
	public String name;
	public String email;
	public String password;
	public String registeredOn;
	
	public User() {
		
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	public Document toDocument() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
		registeredOn = sdf.format(date);
		
//		Document is a HashMap and is available from library bson
		Document document = new Document();
		
		document.append("name", name);
		document.append("email", email);
		document.append("password", Util.encryptString(password));
		document.append("registeredOn", registeredOn);
		
		return document;
		
	}
	
}