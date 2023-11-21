public class StringOperations {

	public static void main(String[] args) {
		
//		Built In String Methods
		
		String names = "John, Jennie, Jim, Jack, Joe";
		System.out.println("names: "+ names);
		
		int length = names.length();
		System.out.println("Length of names is: "+ length);
		
		char ch = names.charAt(length - 1);
		System.out.println("ch is: "+ ch);
		
//		int idx = names.indexOf('o');
		int idx = names.lastIndexOf('o');
		System.out.println("idx of o is: "+ idx);
		
		idx = names.indexOf("Jennie");
		System.out.println("idx of Jennie is: "+ idx);
		
//		Strings are immutable, i.e. we cannot change them
//		Any manipulation on String will generate a new string
		
		String names1 = names.toUpperCase();
		System.out.println("names now is: "+ names);
		System.out.println("names1 now is: "+ names1);
		
		String names2 = names.replace('J', 'K');
		System.out.println("names after replace is: "+ names);
		System.out.println("names2 after replace is: "+ names2);
		
//		String name = names.substring(6);
		String name = names.substring(6, 12);
		System.out.println("name is: "+ name);
		
		String attendeeNameString = "john - 11576609";
		String[] data = attendeeNameString.split("-");
		System.out.println(data[0].trim());
		System.out.println(data[1].trim());
		
		String email = "john@example.com";
		if (email.contains("@") && email.contains(".com")) {
			System.out.println("A Valid Email");
		} else {
			System.out.println("Invalid Email");
		}
		
		String password = "";
		if (password.isEmpty()) {
			System.out.println("Please enter Password first");
		}
		
		String chatMessage = "Hi, My name is John. Please deliver the product on my address: 2144-B20 Redwood Shores";
		if (chatMessage.contains("address")) {
			System.out.println("Address found in the message");
			int i = chatMessage.indexOf("address");
			String address = chatMessage.substring(i);
			System.out.println("Delivery of product on below address");
			System.out.println(address);
		}
		
		String songName = "Hello.docx";
		if (songName.endsWith(".mp3")) {
			System.out.println("AudioPlayer shall play "+ songName);
		}else {
			System.out.println("Invalid file for play format: "+ songName);
		}
		
		System.out.println();
		
		String[] phoneNumber = {
				"+91 98765 12345",
				"+91 98765 11221",
				"+91 91625 28765",
				"+91 98141 12141",
				"+91 99155 66554",
				"+91 90909 12345"
		};
		
		String toSearch = "12";
		
		for(String phone: phoneNumber) {
//			if (phone.startsWith(toSearch)) {
			if (phone.contains(toSearch)) {
				System.out.println(phone);
			}	
		}
	}

}
