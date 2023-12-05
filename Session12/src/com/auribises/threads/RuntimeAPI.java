package com.auribises.threads;

class Student{
	
	int roll;
	String name;
	
	Student() {
		System.out.println("Student object constructed");
	}
	
	Student(int roll, String name) {
		System.out.println("Student object constructed with roll: "+roll+" and name: "+name);
	}
	
//	finalize is a protected function in Object class which we can Override
//	It is executed whenever object is removed from memory
	@Override
	protected void finalize() throws Throwable{	// acts as a destructor
		System.out.println("Student object removed: "+roll+" "+name);
	}
}

public class RuntimeAPI {

	public static void main(String[] args) {
		
		Student s1 = new Student(101, "John");
		Student s2 = new Student(201, "Jennie");
		Student s3 = new Student(301, "Jack");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("Max memory: "+runtime.maxMemory());
		System.out.println("Free memory: "+runtime.freeMemory());
		System.out.println("Total memory: "+runtime.totalMemory());
		
		System.out.println("Executing Garbage Collector");
//		Execute GC
		runtime.gc();
//		System.gc();
		
//		When we have references pointing to null, objects which have no reference will be available to GC to be removed from memory
		s1 = null;
		s2 = null;
		s3 = null;
		
		System.out.println("Executing Garbage Collector");
//		Execute GC
		runtime.gc();
//		System.gc();
		
		System.out.println("Max memory: "+runtime.maxMemory());
		System.out.println("Free memory: "+runtime.freeMemory());
		System.out.println("Total memory: "+runtime.totalMemory());
	}
}
