
public class TextualDataType {

	public static void main(String[] args) {

		char[] name1 = {'J', 'o', 'h', 'n'};
		System.out.println(name1);								// John -> Object class in java
		System.out.println("name1 is: "+ name1);				// HashCode
		System.out.println("name1 length is: "+ name1.length);	// 4
		
//		We can create a String rather than array of characters
		String name2 = "Jennie";			// Interned String
		String name3 = new String("Jim");	// Object String
		
		System.out.println("name2 is: "+ name2);
		System.out.println("name3 is: "+ name3);
		
		String name4 = "Jennie";
		String name5 = new String("Jennie");
		
		if (name2 == name4) {
			System.out.println("name2 == name4");
		} else {
			System.out.println("name2 != name4");
		}
		
		if (name4 == name5) {
			System.out.println("name4 == name5");
		} else {
			System.out.println("name4 != name5");
		}
		
//		== operator compares references and not data, hence, interned String can be compared with == operator but not Object strings
		
		if (name4.equalsIgnoreCase(name5)) {
			System.out.println("name4 is equal to name5");
		} else {
			System.out.println("name4 is not equal to name5");
		}
		
		if (name4.equalsIgnoreCase(name5)) {
			System.out.println("name4 is compared to name5");
		} else {
			System.out.println("name4 is not compared to name5");
		}
	}

}
