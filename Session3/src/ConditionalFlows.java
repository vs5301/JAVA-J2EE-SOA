import java.util.Scanner;

public class ConditionalFlows {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int KOTAK200 = 1;
		int ICICTREATS = 2;
		
		double amountToPay = 1635.0;
		
//		CONTROLLER
	
		/*
		 Simple if/else
		 if(amountToPay >= 399) {
			 System.out.println("You are eligible for applying Promo Code");	
			 System.out.println("1. KOTAK200 for orders abobe Rs. 399. 20% off upto 200");
			 System.out.println("2. ICICTreats for orders above Rs. 499. Flat 20%");
		 } else {
			System.out.println("You are NOT eligible for applying any Promo Code");
			System.out.println("Please Pay: \u20b9"+amountToPay);
		}
		*/
		
		if (amountToPay >= 399) {
			System.out.println("You are eligible for applying Promo Code");
			System.out.println("1. KOTAK200 for orders abobe Rs. 399. 20% off upto 200");
			System.out.println("2. ICICTreats for orders above Rs. 499. Flat 20%");
			
			int promoCode = scanner.nextInt();
			scanner.close();
			
			if (promoCode == ICICTREATS && amountToPay >= 499) {
				double discount = 0.20 * amountToPay;
				System.out.println("Promo Code Applied. You got Discount worth \u20b9"+discount);
				System.out.println("Please Pay: \u20b9"+(amountToPay - discount));
			} else if (promoCode == KOTAK200) {
				double discount = 0.20 * amountToPay;
				if (discount > 200) {
					discount = 200;
				}
				System.out.println("Promo Code KOTAK200 Applied. You got discount worth \u20b9"+discount);
				System.out.println("Please pay: \u20b9"+(amountToPay));
			}
			
		} else {
			System.out.println("You are NOT eligible for applying any Promo Code");
			System.out.println("Please Pay: \u20b9"+amountToPay);
		}
	}
}
