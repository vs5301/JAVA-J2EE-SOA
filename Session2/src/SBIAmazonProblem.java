/*
 	Amazon eCommerce Grand Sale
 		SBI: 10% Discount -> Card Usage
 			 2. HomeAndKitchen
 			 3. MobileDevice
 			 
 		SBI -> where SBI should advertise in an offline manner to sell credit cards more
 		
 		HomeAndKitchen 			discount
 		day1Sales -> 12345		10%
 		day2Sales -> 12345		10%
 		day3Sales -> 12345		10%
 		
 		MobileDevice			discount
 		day1Sales -> 1223451	10%
 		day2Sales -> 2323452	10%
 		day3Sales -> 3423549 	10%
 		
 	MODEL
 		Data Storage Containers -> Focus on storing data which we will process to solve the problem
 			1. Single Value Containers
 			2. Multi Value Containers
 				Homo : Same type of data
 				Hetro: different type of data
 				
 			Storage Containers -> 1. Fixed Size i.e in memory they will take a particular amount of memory which is pre-defined.
 			T						 This cannot be altered.
 								  2. Variable size i.e. memory can increase or decrease as per our requirements	dynamic storage 
 								  	 containers whose size cannot be altered.
 	VIEW
 		User interface i.e. where user can give data as input or we process data and show the output Web, Mobile, Desktop, CommandLine
 	CONTROLLER
 		Logical Processing on Data
 		1. Computation		 -> Mathematical Operations
 		2. Conditional Flows -> Taking the decision
 		3. Iterations 		 -> Doing something again and again
 */

public class SBIAmazonProblem {

//	main is a function
//	but in OOPS terminology, main is method
//	main will be executed and whatever we write in main will be executed
	public static void main(String[] args) {
		// TODO Auto-generated method stub223451
		
//		Model 
//		Data Storage Container Creation
//		int day1SalesHK is variable or storage container name
//		223451 is literal or constant
		int day1SalesHK = 223451;
		int day2SalesHK = 323452;
		int day3SalesHK = 423459;
		
//		int -> is a storage container which shall take 32 bits of size in memory
		int day1SalesMD = 1223451;
		int day2SalesMD = 2323452;
		int day3SalesMD = 3423459;
		
//		2. Update Container Data
		day3SalesHK = 516789;
		
//		3. Read the data from Storage Container
		System.out.println("Home and Kitchen 3 Day Sale: ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("day1SalesHK: "+ day1SalesHK);
		System.out.println("day1SalesHK: "+ day2SalesHK);
		System.out.println("day1SalesHK: "+ day3SalesHK);
		
		System.out.println("Mobile Device 3 Day Sale: ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("day1SalesMD: "+ day1SalesMD);
		System.out.println("day1SalesMD: "+ day2SalesMD);
		System.out.println("day1SalesMD: "+ day3SalesMD);
		
//		Model cannot be deleted from memory manually. It will be automatically 	deleted when program i.e. main will finish
		
//		Controller: Logical Processing on data -> Mathematical Computations
		int totalSalesHK = day1SalesHK + day2SalesHK + day3SalesHK;
		int totalSalesMD = day1SalesMD + day2SalesMD + day3SalesMD;
		
		System.out.println();
		
//		Display Sales
		System.out.println("Home and kitchen 3 day total sale: "+ totalSalesHK);
		System.out.println("Mobile device 3 day total sale: "+ totalSalesMD);
		
//		Compute discounts
		double totalDiscountHK = 0.10 * totalSalesHK;
		double totalDiscountMD = 0.10 * totalSalesMD;
		
//		Display Discounts
		System.out.println("Home and kitchen 3 day total discounts by SBI: "+ totalDiscountHK);
		System.out.println("Mobile device 3 day total discounts by SBI: "+ totalDiscountMD);	
		
		System.out.println();
		
		System.out.println("Final Outcome: ");
		
		if (totalSalesHK > totalSalesMD) {
			System.out.println("SBI must put stall in home and kitchen applicance shops");
		} else {
			System.out.println("SBI must put stall in mobile shops");
		}
		
		if (totalDiscountHK > totalDiscountMD) {
			System.out.println("SBI gave more discount for home and kitchen sales by "+ (totalDiscountHK - totalDiscountMD));
		} else {
			System.out.println("SBI gave more discount for mobile device sales by "+(totalDiscountMD - totalDiscountHK));
		}
	}

}
