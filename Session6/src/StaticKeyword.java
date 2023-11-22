// 1. Define Object:
// Order: date, time, customerName, customerEmail, dishes, totalPrice

// 2. Code the Object i.e. write the class

class Order{
	
//	Attributes: Property of object
	String date;
	String time;
	String customerName;
	String customerEmail;
	String dishes;
	double totalPrice;
	
//	int counter = 0; //	In the object
//	Every object will have its counter value
	
//	static will not go in the object i.e. it is not an attribute of object, not a property of object
//	static is property of class
	static int counter = 0;
	
//	Default Constructor
	public Order() {
		this("NA", "NA", "NA", "NA", "NA", 0);
		counter++;
	}

//	Parameterized Constructor
	Order(String date, String time, String customerEmail, String dishes, String customerName, double totalPrice) {
		counter++;	// property of class can be accessed in property of object
		this.date = date;
		this.time = time;
		this.customerName = customerName;	
		this.customerEmail = customerEmail;
		this.dishes = dishes;
		this.totalPrice = totalPrice;
	}
	
//	non static method: property of object 
	void showOrderDetails() {
		System.out.println("Order Details");
		System.out.println("~~~~~~~~~~~~~");
		System.out.println("Date: "+date+" Time: "+time);
		System.out.println("Name: "+customerName+" Email: "+customerEmail);
		System.out.println("Dishes: "+dishes);
		System.out.println("Total Price: \u20b9"+totalPrice);
		System.out.println();
	}
	
//	static method: property of class
	static int getOrderObjectCount() {
		// property of class cannot access property of object
//		System.out.println("customer name is: "+customerName); // error
		return counter;
	}
	
}

//	static can be accessed from non-static but not vice versa

public class StaticKeyword {

	public static void main(String[] args) {
		
		Order o1 = new Order("12th Aug, 2020", "10:00", "John", "john@example.com", "Noodles", 575.66);
		Order o2 = new Order("12th Aug, 2020", "11:00", "Fionna", "fionna@example.com", "Pizza", 475.66);
		Order o3 = new Order("12th Aug, 2020", "14:00", "Dave", "dave@example.com", "Burger", 375.66);
		
		System.out.println("Total Order Object: "+o1.counter);  // this shows counter value in class Order
		System.out.println("Total Order Object: "+o2.counter);  // this shows counter value in class Order
		System.out.println("Total Order Object: "+o3.counter);  // this shows counter value in class Order
		
		System.out.println("Total Order objects: "+Order.counter); // Right way to access

	}

}
