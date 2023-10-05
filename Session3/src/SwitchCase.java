import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
//		Model
		int baseFare = 50;
		int kmCharge = 10;
		
		int distanceTravelled = 7;
		
		int olaMicro = 1;
		int olaMini = 2;
		int olaSedan = 3; 
		int olaBike = 4;
		int olaShared = 5;
		
		int amountToPay = 0;
		
//		View
		System.out.println("==============================");
		System.out.println("Select the type of Cab: ");
		System.out.println("1. OLA MICRO");
		System.out.println("2. OLA MINI");
		System.out.println("3. OLA SEDAN");
		System.out.println("4. OLA BIKE");
		System.out.println("5. OLA SHARED");
		System.out.println("==============================");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.close();
		
		switch (choice) {
		case 1:
			baseFare += 10;
			amountToPay = baseFare + (kmCharge * distanceTravelled);
			System.out.println("OLA MICRO BOOKED. PLEASE PAY: \u20b9"+amountToPay);
			break;
			
		case 2:
			baseFare += 20;
			amountToPay = baseFare + (kmCharge * distanceTravelled);
			System.out.println("OLA MINI BOOKED. PLEASE PAY: \u20b9"+amountToPay);
			break;
		
		case 3:
			baseFare += 50;
			amountToPay = baseFare + (kmCharge * distanceTravelled);
			System.out.println("OLA SEDAN BOOKED. PLEASE PAY: \u20b9"+amountToPay);
			break;
			
		case 4:
			baseFare += 5;
			amountToPay = baseFare + (kmCharge * distanceTravelled);
			System.out.println("OLA BIKE BOOKED. PLEASE PAY: \u20b9"+amountToPay);
			break;
			
		case 5:
			baseFare += 8;
			amountToPay = baseFare + (kmCharge * distanceTravelled);
			System.out.println("OLA SHARED BOOKED. PLEASE PAY: \u20b9"+amountToPay);
			break;
		
		default:
			System.out.println("Please select cab to proceed: ");
			break;
		}
	}

}
