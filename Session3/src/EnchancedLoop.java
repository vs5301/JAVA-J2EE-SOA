
public class EnchancedLoop {

	public static void main(String[] args) {
		
		int[] covid19ActiveCases = {148553, 52810, 87597, 79605, 10868};
		
		System.out.println("Regular For Loop");
		for (int idx = 0; idx < covid19ActiveCases.length; idx++) {
			System.out.println(covid19ActiveCases[idx]);
		}
		
		System.out.println();
		
		System.out.println("Enchanced For Loop");
//		Enhanced for loop: do not worry about indexing, read data and give it to us and will run from 0th index till last automatically
		
		for(int anyName: covid19ActiveCases) {
			System.out.println(anyName);
		}

	}

}
