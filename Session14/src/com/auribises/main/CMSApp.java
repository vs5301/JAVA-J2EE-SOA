package com.auribises.main;

import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

import com.auribises.model.Customer;
import com.auribises.dao.DB;

public class CMSApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DB db = new DB();
		db.createConnection();
		
		while(true) {
			
			System.out.println("-----------------------------------------");
			System.out.println("Welcome to CMS App");
			System.out.println("1. Add Customer");
			System.out.println("2. Show All Customers");
			System.out.println("3. Mark Exit for Customer");
			System.out.println("4. Show Customer by Phone");
			System.out.println("5. Delete Customer by ID");
			System.out.println("6. Delete Customer by Phone");
			System.out.println("7. See Customers with time spent > 30 mins");
			System.out.println("8. Execute Batch");
			System.out.println("0. Exit the App");
			System.out.println("-----------------------------------------");
			
			System.out.println();
			
			System.out.println("Enter Your Choice: ");
			int choice = scanner.nextInt();
			
			if(choice == 0) {
				System.out.println("Thank You For Using CMS APP ");
				break;
			}
			
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					Customer cRef = new Customer();
					
					System.out.println("Enter Customer Name: ");
					cRef.name = scanner.nextLine();
					
					System.out.println("Enter Customer Phone: ");
					cRef.phone = scanner.nextLine();
					
					System.out.println("Enter Customer Email: ");
					cRef.email = scanner.nextLine();
					
					System.out.println("Enter Customer Temperature: ");
					cRef.temperature = scanner.nextDouble();
					
					Date date = new Date(); // Date Object which is the time-stamp of our system
					cRef.entryDateTime = date.toString();
					cRef.exitDateTime = "NA";
					
					System.out.println("customer is:");
					System.out.println(cRef); // whenever we print reference variable toString method from Object class is executed automatically
					//System.out.println(cRef.toString()); // we have no toString in Customer class and we are executing it ? as it is thr in the Parent Class Object
					
					scanner.nextLine();
					
					System.out.println("Would You Like to Add Customer "+cRef.name+" ? (yes/no)");
					String save = scanner.nextLine();
					if(save.equals("yes")) {
//						String messageString = db.addCustomer(cRef);
//						System.out.println(messageString);
						db.executeProcedureInDB(cRef);
					}else {
						System.out.println("Thank You For Using CMS App ");
					}
					
					break;
					
				case 2:
					ArrayList<Customer> customers = db.fetchAllCustomers();
					customers.forEach((customer)->System.out.println(customer));
					break;
					
				case 3:
					String exitDateTime = new Date().toString();
					System.out.println("Enter customer ID: ");
					int customerId = scanner.nextInt();
					String message = db.markExit(exitDateTime, customerId);
					System.out.println(message);
					break;
					
				case 4:
					System.out.println("Enter Customer Phone: ");
					String customerPhone = scanner.nextLine();
					db.fetchCustomerWithPhone(customerPhone);
					break;
					
				case 5:
					System.out.println("Enter Customer ID: ");
					customerId = scanner.nextInt();
					
					message = db.deleteCustomer(customerId);
					System.out.println(message);
					break;
				
				case 6:
					break;
				
				case 7:
					break;
					
				case 8:
					db.executeBatchTransaction();
					break;
					
				default:
					System.out.println("Invalid Choice");
					break;
			}
			
		}
		
		db.closeConnection();
		scanner.close();

	}

}
