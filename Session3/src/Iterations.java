import java.util.Iterator;

public class Iterations {

	public static void main(String[] args) {

//		State Wise Data Representation for Active Cases
		
		int maharashtra = 148553;
		int tamilNadu = 52810;
		int andhraPradesh = 87597;
		int karnataka = 79605;
		int delhi = 10868;
		
//		If we have to represent data for all the states, we need to create many single value containers
//		For states, we need to maintain data for districts, cities, etc.
//		Computation will also take more development time.
		
		int totalActiveCases = maharashtra + tamilNadu + andhraPradesh + karnataka + delhi;
		System.out.println("Total Active Cases: "+ totalActiveCases);
		
//	 	To represent data for n-number of states, we use Multi-Value Container
//		Arrays: Homogeneous
//		Indexing					  0 	  1 	2 		3      4 
		int[] covid19ActiveCases = {148553, 52810, 87597, 79605, 10868};
		
		System.out.println("maharashtra: "+ maharashtra);					// single value container
		System.out.println("covid19ActiveCases: "+ covid19ActiveCases);		// multi value container
		
		totalActiveCases = 0;
		totalActiveCases = covid19ActiveCases[0] + covid19ActiveCases[1] + covid19ActiveCases[2] + covid19ActiveCases[3] + covid19ActiveCases[4];
		
		System.out.println("Total Active Cases: "+ totalActiveCases);
		
//		Arrays are created dynamically i.e. at run time in Java
//		i.e. when program starts, memory allocation happens dynamically.
		
//		In Java, a program running at JVM end i.e. GarbageCollector will look for unused memory and remove it but only from Heap.
		
//		Loops or Iterations
		int idx = 0;	// starting point
		
//		check condition when we enter the loop
		while (idx < 5) {	// go till 4 i.e. less than 
			totalActiveCases += covid19ActiveCases[idx];
			idx++;
		}
		System.out.println("Total Active Cases: "+totalActiveCases);
		
		totalActiveCases = 0;
		idx = 0;
		
		do {
			totalActiveCases += covid19ActiveCases[idx];
			idx++;
		} while (idx < 5);	// check condition when we exit the loop
		
		System.out.println("Total Active Cases from do-while Loops: "+totalActiveCases);
		
		totalActiveCases = 0;
		for(int i=0; i<5; i++) {
			totalActiveCases += covid19ActiveCases[i];
		}
		
		System.out.println("Total Active Cases from for Loops: "+totalActiveCases);
	}

}
