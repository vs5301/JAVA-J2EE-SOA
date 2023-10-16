// Recursion and Method Execution Stack
// Either static or no static, method execution stack remains same

public class Recursion {
	
//	function executing itself again to solve some problem -> Recursion
//	dynamic programming -> almost all of the problems are solved with Recursion
	static int getMaxNumber(int[] numbers, int length) {
		System.out.println("getMaxNumber executed with length: "+ length);
		int num = 0;
		
		if (length == 1) {
			return numbers[0];
		} else {
			num = getMaxNumber(numbers, length-1);
		}
		
		if (num > numbers[length - 1]) {
			return num;
		} else {
			return numbers[length - 1];
		}
	}

	public static void main(String[] args) {
		
		int[] data = {10, 20, 30};
		int max = Recursion.getMaxNumber(data, data.length);
		System.out.println(">> Max is: "+ max);

	}

}
