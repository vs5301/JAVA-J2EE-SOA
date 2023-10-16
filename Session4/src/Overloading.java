
public class Overloading {

//	Overloading: Same method name with different i.e. unique inputs
	
	/*
	void processBankingPayments(String userName, String password, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT <<");
		System.out.println(">> Processing payment for user: "+ userName);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}
	
	void processCardPayments(String cardNumber, int cvv, int amountToPay) {
		System.out.println(">> ONLINE CARD PAYMENT <<");
		System.out.println(">> Processing payment for card: "+ cardNumber);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}
	
	void processUPIPayments(String upi, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT <<");
		System.out.println(">> Processing payment for UPI: "+ upi);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}*/
	
	/*
	 *  Overloading is simplifying the usage for us in execution of function
	 *  Rules: 
	 *  1. Method name must be same
	 *  2. Inputs must be different
	 *  3. Return type must have no role to play
	 *  
	 *  Polymorphism: Compile time: Same method can do different operations 
	 */
	
	void processPayments(String userName, String password, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT <<");
		System.out.println(">> Processing payment for user: "+ userName);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}
	
	void processPayments(String cardNumber, int cvv, int amountToPay) {
		System.out.println(">> ONLINE CARD PAYMENT <<");
		System.out.println(">> Processing payment for card: "+ cardNumber);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}
	
	void processPayments(String upi, int amountToPay) {
		System.out.println(">> ONLINE BANKING PAYMENT <<");
		System.out.println(">> Processing payment for UPI: "+ upi);
		System.out.println(">> Thank you for making a payment of: "+ amountToPay);
		System.out.println();
	}
	
//	JVM won't create object of Overloading class to execute the main method
//	JVM uses class name and executes the main method
	public static void main(String[] args) {	// static -> it can be accessed with class name

		Overloading oRef = new Overloading();
		/*
		oRef.processBankingPayments("john.watson", "john@12345", 1000);
		oRef.processCardPayments("4566 6789 1345 1111", 234, 1500);
		oRef.processUPIPayments("fionna@paytm", 2000);
		*/
		oRef.processPayments("john.watson", "john@12345", 1000);
		oRef.processPayments("4566 6789 1345 1111", 234, 1500);
		oRef.processPayments("fionna@paytm", 2000);
		
	}

}
