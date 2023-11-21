public class MutableString {

	public static void main(String[] args) {
		
//		Strings are immutable
		String str = new String("Hello");
		String newStr = str.concat(" World");
		
		System.out.println("str is: "+ str);
		System.out.println("newStr is: "+ newStr);
		
//		Mutable Strings
//		StringBuffer | StringBuilder | Can only be used in object way
		
//		Thread safe i.e. synchronized
		StringBuffer buffer = new StringBuffer("Hello");
		buffer.append(" World");
		
		System.out.println("buffer is: "+ buffer);
		
//		Not thread safe
		StringBuilder builder = new StringBuilder("Hello");
		builder.append(" World");
		
		System.out.println("builder is: "+ builder);
		
//		builder.ensureCapacity(20); // We can ensure capacity of StringBuilder but this will grow dynamically if needed

	}

}
