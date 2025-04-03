package com.auribises.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.auribises.model.Customer;

// Object of DB class will access the Database
public class DB {
	
//	Connection is an Interface whose reference we have declared
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	
	CallableStatement callableStatement;
	
//	1. Load the driver
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Loaded");
		} catch (Exception e) {
			System.out.println("Driver load failed: "+e);
		}
	}
	
//	2. Create the connection
	public void createConnection() {
		try {
			String urlString = "jdbc:mysql://localhost/auridb";
			
			String userString = "root";
			String password = "";
			
			connection = DriverManager.getConnection(urlString, userString, password);
			System.out.println("2. Connection created");
		} catch (Exception e) {
			System.out.println("Connection failed: "+ e);
		}
	}
	
//	3. Write and execute SQL statements
	public String addCustomer(Customer customer) { 
		
		String resultMessage = "";
		
/*		try {
			String sql = "INSERT INTO Customer VALUES(null, '"+customer.name+"', '"+customer.phone+"', '"+customer.email+"', '"+customer.temperature+"', '"+customer.entryDateTime+"', '"+customer.exitDateTime+"')";
			System.out.println("SQL: "+sql);
			
			statement = connection.createStatement();
			int i = statement.executeUpdate(sql); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if (i>0) {
				resultMessage = "4. "+customer.name+" added in database";
			} else {
				resultMessage = "4. "+customer.name+" NOT added in database";
			}
			
		} catch (Exception e) {
			resultMessage = "Operation failed: "+e;
		} */
		
		try {
			String sql = "INSERT INTO Customer VALUES(null, ?, ?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.name);
			preparedStatement.setString(2, customer.phone);
			preparedStatement.setString(3, customer.email);
			preparedStatement.setFloat(4, (float) customer.temperature);
			preparedStatement.setString(5, customer.entryDateTime);
			preparedStatement.setString(6, customer.exitDateTime);
			
			int i = preparedStatement.executeUpdate(); // executeUpdate -> will perform SQL insert, update and delete commands
			
			if (i>0) {
				resultMessage = "4. "+customer.name+" added in database";
			} else {
				resultMessage = "4. "+customer.name+" NOT added in database";
			}
			
		} catch (Exception e) {
			resultMessage = "Operation failed: "+e;
		}
		
		return resultMessage;
	}
	
	public void executeProcedureInDB(Customer customer) { 	
		try {
			String sql = "{ call addCustomer(null, ?, ?, ?, ?, ?, ?) }";
			
			callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, customer.name);
			callableStatement.setString(2, customer.phone);
			callableStatement.setString(3, customer.email);
			callableStatement.setFloat(4, (float) customer.temperature);
			callableStatement.setString(5, customer.entryDateTime);
			callableStatement.setString(6, customer.exitDateTime);
			
			callableStatement.execute();
			System.out.println("Procedure executed");
			
		} catch (Exception e) {
			System.out.println("Procedure failed: "+e);
		}
	}
	
	public void executeBatchTransaction() { 
		
		try {
			String sql1 = "UPDATE Customer SET Name='Fionna Flynn', email='fionna.flynn@example.com' where id=2";
			String sql2 = "DELETE FROM Customer WHERE cid=8";
			
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			
			statement.executeBatch();
			connection.commit();
			
			System.out.println("Batch Executed");
			
		} catch (Exception e) {
			System.out.println("Batch Commit failed: "+e);
			try {
				System.out.println("Error occurred and transaction rolledback");
				connection.rollback();
			} catch (Exception e2) {
				System.out.println("Rollback failed: "+e);
			}
		}
	}
	
	public String markExit(String exitDateTime, int customerId) {
		String message = "NA";
		
		try {
			String sql = "UPDATE Customer SET exitDateTime = ? where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, exitDateTime);
			preparedStatement.setInt(2, customerId);
			
			int i = preparedStatement.executeUpdate();
			
			if(i>0) {
				message = "4. "+customerId+" exit time updated in database";
			} else {
				message = "4. "+customerId+" exit time NOT updated in database";
			}
		} catch (Exception e) {
			message = "Update operation failed: "+e;
		}
		
		return message;
 	}
	
	public String deleteCustomer(int customerId) {
		String message = "NA";
		
		try {
			String sql = "DELETE FROM Customer where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			
			int i = preparedStatement.executeUpdate();
			
			if(i>0) {
				message = "4. "+customerId+" deleted from database";
			} else {
				message = "4. "+customerId+" NOT deleted from database";
			}
		} catch (Exception e) {
			message = "Delete operation failed: "+e;
		}
		
		return message;
 	}
	
	public String fetchCustomerWithPhone(String phone) {
		
		String message = "";
		
		try {
			String sql = "SELECT * FROM Customer WHERE Phone=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("Customer found");
				
				Customer customer = new Customer();
				customer.id = resultSet.getInt(1);
				customer.name = resultSet.getString(2);
				customer.phone = resultSet.getString(3);
				customer.email = resultSet.getString(4);
				customer.temperature = resultSet.getFloat(5);
				customer.entryDateTime = resultSet.getString(6);
				customer.exitDateTime = resultSet.getString(7);
				
				message = "Customer foumnd: "+customer;
 			} else {
				message = "Could not find customer";
			}
		} catch (Exception e) {
			message = "Fetch operation failed: "+e;
		}
		
		return message;
 	}
	
	public ArrayList<Customer> fetchAllCustomers(){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			String sql = "SELECT * FROM Customer";
			preparedStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.id = resultSet.getInt(1);
				customer.name = resultSet.getString(2);
				customer.phone = resultSet.getString(3);
				customer.email = resultSet.getString(4);
				customer.temperature = resultSet.getFloat(5);
				customer.entryDateTime = resultSet.getString(6);
				customer.exitDateTime = resultSet.getString(7);
				
				customers.add(customer);
			}
 		} catch (Exception e) {
			System.out.println("Fetch operation failed: "+e);
		}
		
		return customers;
	}
	
//	4. Close connection with database
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("4. Connection closed");
		} catch (Exception e) {
			System.out.println("Connection was not closed: "+e);
		}
	}

}
