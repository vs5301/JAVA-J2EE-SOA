
public class ArrayTypes {

	public static void main(String[] args) {
		
//		Data for 5 states for 3 days..
		int[] covid19IndiaCases9Aug = {135076, 134513, 23521, 12341, 4567};
		int[] covid19IndiaCases10Aug = {235076, 234513, 33521, 22341, 5567};
		int[] covid19IndiaCases11Aug = {335076, 334513, 43521, 32341, 6567};
		
//		For n number of days we need to write n number of arrays, instead create array of arrays
//		or 2D array
		
		int[][] covid19IndiaCasesAug = {
//				   0 		1 	   2	  3 	4
				{135076, 134513, 23521, 12341, 4567},	// 0
				{235076, 234513, 33521, 22341, 5567},	// 1
				{335076, 334513, 43521, 32341, 6567}	// 2
		};
		
		System.out.println("covid19IndiaCases9Aug: "+ covid19IndiaCases9Aug);	// Hashcode 
		System.out.println("covid19IndiaCases9Aug length: "+ covid19IndiaCases9Aug.length);	// 5
		
		System.out.println();
		
		System.out.println("covid19IndiaCasesAug: "+ covid19IndiaCasesAug); 	// Hashcode
		System.out.println("covid19IndiaCasesAug length: "+ covid19IndiaCasesAug.length);	// 3
		
		for(int i = 0; i < covid19IndiaCasesAug.length; i++) {
			for(int j = 0; j < covid19IndiaCasesAug[i].length; j++) {
				System.out.print(covid19IndiaCasesAug[i][j]+ " ");
			}
			System.out.println();
		}
		
//		Array of array of arrays
		int[][][] yearlyCases = {
				{
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521}
				},
				{
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521}
				},
				{
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521},
					{335076, 334513, 43521}
				}
		};
		
		System.out.println("yearlyCases is: "+ yearlyCases);			// Hashcode
		System.out.println("yearlyCases is: "+ yearlyCases[0]);			// Hashcode
		System.out.println("yearlyCases is: "+ yearlyCases[0][0]);		// Hashcode
		System.out.println("yearlyCases is: "+ yearlyCases[0][0][0]);	// 335076
		
	}

}
