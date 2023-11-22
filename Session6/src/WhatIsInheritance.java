class Parent{
	
//	Attributes of Parent Object
	String fname;
	String lname;
	int wealth;
	
//	Constructor of Parent Object
	Parent() {
		fname = "John";
		lname = "Watson";
		wealth = 100000;
		System.out.println("Parent Object Constructed");
	}
	
//	Method of Parent Object
	void showDetails() {
		System.out.println("[P]: "+fname+" "+lname+" | "+wealth);
	}
}

/*
 * 	Inheritance relationship in Java
 *	with extends we relate 2 classes as parent and child | LHS(child) extends RHS(parent)
 */
class Child extends Parent{	// Inheritance Relationship in Java
	
	String fname;
	int wealth;
	
	public Child() {
		fname = "Fionna";
		wealth = 57500;
		System.out.println("Child Object Constructed");
	}
	
	void showDetails() {
		super.showDetails(); // execute showDetails of Parent as well
		System.out.println("[C]: "+fname+" "+lname+" | "+wealth);
	}
}

/*	1st rule of inheritance
	Before the object of child, JVM will create object of parent in the memory
	
	2nd rule of inheritance
	Child can access everything in the Parent, if it won't have it within it
	* -> private is not accessible
*/
public class WhatIsInheritance {

	public static void main(String[] args) {
		
		/*
		 * 	Parent pRef = new Parent();
		 *  pRef.showDetails();
		 */
		
		Child cRef = new Child();
//		child has no wealth attribute within it, but parent has it, so child will access it
//		but if child has wealth attribute it will access its own
		cRef.wealth -= 10000; 
		
//		showDetails is not in the child but available in parent and hence is accessible
//		if showDetails is in the child, it will execute its own and not the parent's
		cRef.showDetails();	
	}

}
