/*
 * OOPS:
 * Use Case: Make My Trip
 * 
 * Object Oriented Programming Structure
 * > Object
 * > Class
 * 
 * Object is a Multi Value Container. It is meant to hold data
 * Data may be homo or hetro
 * Object will store the data as key/value pair -> attribute/data
 * 
 * Class is a textual representation of how our object will look like in memory i.e. we 
 * code the object as class
 * 
 * Principle of OOPS
 * 1. Think about Object: anything in problem statement which may have lot of data associated to it
 * Write data associated with it called attributes
 * 2. Create Class for that Object
 * 3. From the class create a real object in memory
 * 
 * Problem Statement: Client needs a travel web app. Solution needs:
 * Flight Booking, train booking, cab booking, bus etc.
 * 
 * Flight booking -> is an object
 * Attributes: sourceLocation, destinationLocation, travelDate, travellers, travelClass
 * 
 * 1. Consider Object
 * OneWayFlightBooking [from, to, departureDate, travelers, travelClass]
 * 
 * 2. Create class for the object
 * Definition of object in memory
 */
import java.util.Scanner;

class OneWayFlightBooking{
	
//	Attributes: Written in class, but they belong to object
	String from;
	String to;
	String departureDate;
	int travelers;
	int travelClass; // 1 -> economy, 2 -> business, 3 -> premium economy

	/*	
	 * Default Constructor | Same name as class, if we do not create it, compiler creates it with default data
		OneWayFlightBooking() {
			from = null;
			to = null;
			departureDate = null;
			travelers = 0;
			travelClass = 0;
		}
 	*/	
	
//	Default Constructor -> Sets the default data in Object
	OneWayFlightBooking() {
		System.out.println("OneWayFligthBooking constructed with Default constructor: "+this); // hashcode of object constructed
		from = "Delhi";
		to = "Bangalore";
		departureDate = "14th Aug, 2020";
		travelers = 1;
		travelClass = 1;
	}
	
//	Parameterized Constructor -> Take input and then set the data
	OneWayFlightBooking(String from, String to, String departureDate, int travelers, int travelClass) {
		System.out.println("OneWayFligthBooking constructed with Parameterized constructor: "+this); // hashcode of object constructed
		/*
		 * this is a reference variable which holds the hashcode of object
		 * LHS this.from means attribute of object
		 * RHS from means input of constructor
		 */
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
//	Method -> Property of object
	void showFlightBookingDetails() {
		System.out.println("Flight Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("From: "+from+" To: "+to+" On: "+departureDate);
		System.out.println("Travelers: "+travelers+" Class: "+travelClass);
		System.out.println();
	}
	
	void setOneWayFlightBookingDetails(String from, String to, String departureDate, int travelers, int travelClass) {
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.travelers = travelers;
		this.travelClass = travelClass;
	}
	
	void setOneWayFlightBookingDetails() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter From location: ");
		from = sc.nextLine();
		
		System.out.println("Enter To location: ");
		to = sc.nextLine();
		
		System.out.println("Enter Departure Date: ");
		departureDate = sc.nextLine();
		
		System.out.println("Enter Travellers: ");
		travelers = sc.nextInt();
		
		System.out.println("Enter Travel Class(1. Economy, 2. Business, 3. Premium Economoy): ");
		travelClass = sc.nextInt();
		
		sc.close();
	}	
	
}

// Class is fo(null)r execution of program
public class OOPS {

	public static void main(String[] args) {
		
		// 3. From the class create a real object in memory
		OneWayFlightBooking fRef1 = new OneWayFlightBooking();
		OneWayFlightBooking fRef2 = new OneWayFlightBooking();
		OneWayFlightBooking fRef3 = fRef1;
		
		OneWayFlightBooking fRef4 = new OneWayFlightBooking("Delhi","Goa","20th Aug, 2020",6,2);
		
//		new is operator which creates object dynamically i.e. at run time in the heap
//		executes constructor when object is constructed as 1st function call to initialize attributes with some default data
//		fref1, fref2, fref3 are reference variables which holds hashcode of objects and new returns the hashcode after creating the object 
		
		System.out.println("fRef1 is "+ fRef1);
		System.out.println("fRef2 is "+ fRef2);
		System.out.println("fRef3 is "+ fRef3);
		System.out.println("fRef4 is "+ fRef4);
		
		fRef1.departureDate = "1st September, 2020";
		
//		fRef2.setOneWayFlightBookingDetails("Delhi", "Hyderabad", "2nd October, 2020", 4, 3);
		fRef2.setOneWayFlightBookingDetails();
		
//		Operations on Object
//		1. Read Operation i.e. read data from object
//		We will use ref var with . operator to access the attribute of an object
//		System.out.println(fRef1.from+" "+fRef1.to+" "+fRef1.departureDate+" "+fRef1.travelers+" "+fRef1.travelClass);
//		System.out.println(fRef2.from+" "+fRef2.to+" "+fRef2.departureDate+" "+fRef2.travelers+" "+fRef2.travelClass);
//		System.out.println(fRef3.from+" "+fRef3.to+" "+fRef3.departureDate+" "+fRef3.travelers+" "+fRef3.travelClass);
//		System.out.println(fRef4.from+" "+fRef4.to+" "+fRef4.departureDate+" "+fRef4.travelers+" "+fRef4.travelClass);
		
		fRef1.showFlightBookingDetails();
		fRef2.showFlightBookingDetails();
		fRef3.showFlightBookingDetails();
		fRef4.showFlightBookingDetails();
		
//		Objects are deleted from memory automatically
//		Garbage collector will execute in some interval of time and pick up unused objects and mark them with mark and sweep algo
		
//		Here we request GC to run immediately on our request to clean the memory for unused objects
		System.gc();
	}

}
