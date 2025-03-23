package com.auribises.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.events.Namespace;

class Outer{
	
	void show() {
		System.out.println("This is show of Outer");
	}
	
//	Nested class - class within the class to increase level of encapsulation or maybe used as helper class
	class Inner{
		void show() {
			System.out.println("This is show of Inner");
		}
	}
}

// Outer class will be for displaying the users
//Outer class methods can access Inner class and can fetch the data from DB
// Making code more maintainable
class DisplayUsersOnPage{
	class FetchUsersFromDB{
		
	}
}

/*
class Arrays{
	
	class ArrayList{
		
	}
}
*/

class ArrayToList{
	
	static ArrayList<String> toList(String...names){
		ArrayList<String> list = new ArrayList<String>();
		for(String name: names) {
			list.add(name);
		}
		
		return list;
	}
}

public class NestedClass {

	public static void main(String[] args) {
		
		Outer oRef = new Outer();
		oRef.show();
		
		Outer.Inner iRef = oRef.new Inner();
		iRef.show();

//		List<String> name = Arrays.asList("John","Jennie","Jim");
//		System.out.println(name.getClass());
		
		// Arrays.asList returns a nested ArrayList class Object, which is fixed in size. 
		// Hence, we can only update or get the data, not remove or add data.
		
		List<String> names = ArrayToList.toList("John","Jennie","Jim");
		System.out.println(names.getClass());
		
		names.add("Sia");
		System.out.println(names);
	}

}
