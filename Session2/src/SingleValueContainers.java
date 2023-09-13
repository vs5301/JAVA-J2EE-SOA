// Single value containers are know as Primitive types
// Primitive types are the ones which works on Values. They store values i.e. Data directly
public class SingleValueContainers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integral
//		byte	8 bits
//		short 	16 bits
//		int 	32 bits
//		long 	64 bits
		
//		byte takes 8 bits -> 2 power 8 -> 256 | Range: -128 to 127
		
		byte age = 127;
//		byte age = 128; // error -> number is out of range
		System.out.println("age is: "+ age);
		
//		Integral literals can be either 32bit or 64bit
		
//		Literals can be made 64 bit by putting l in the end
		long salary = 9876543210L;
		
//		Floating Point 
//		float 32bits
//		double 64 bits
		
//		float pi = 3.14; // error as 3.14 is a literal which will take 64 bit in memory and pi as 32 bits
		float pi = 3.14F; // OK as 3.14f is a literal which will take 32 bit in memory
		double average = 8.3; // OK as 8.3 is 64 bits and so is average
		
//		Logical/Booleans
//		boolean : 8 bits
		boolean isInternetOn = true;
		isInternetOn = false;
		
//		Characters
//		16 bits in memory | ASCII and UNICODES
//		char ch = 'A';
//		char ch = 65;
		char ch = '\u0905';
		System.out.println("ch is: "+ch);
	}

}
