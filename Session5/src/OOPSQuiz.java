// class is just a representation of object
class FoodItem{
//	Anything written in the class is Property of Object
	String name;
	int quantity;
	int price;
	
	FoodItem() {
		this("NA", 0, 0); //Constructor Chaining -> Executing another constructor from a constructor
		// this will be used to execute the constructor
	}
	
	FoodItem(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	void showFoodItem() {
		System.out.println("Name: "+name+" Quantity: "+quantity+" Price: "+price);
	}
	
	void increment() {
		quantity++;
	}
	
	void decrement() {
		--quantity;
	}
}


public class OOPSQuiz {

	public static void main(String[] args) {
		
		FoodItem item1 = new FoodItem("Veggie Burger", 1, 100);
		FoodItem item2 = new FoodItem("Sandwich", 2, 50);
		FoodItem item3 = item1;
		
		item1.increment();
		item2.increment();
		item3.increment();
		
		item1.increment();
		item2.decrement();
		item3.decrement();
		
		item3.increment();
		
		item1.showFoodItem();
		item2.showFoodItem();
		item3.showFoodItem();
	}

}
