
public class Methods {
	
//	Functions or Methods
//	Methods -> Created inside the class, which will contain some piece of code, which we
//	need to execute again and again
//	void is return type i.e data type which method must return in the end, void means nothing 
//	should be returned
	
	int getMaxNumber1(int[] array) {
		int max = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
//	static is a method which can be executed without the object
	static int getMaxNumber2(int[] array) {
		int max = array[0];
		
		for(int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		
		int[] covid19IndiaCases9Aug = {135076, 134513, 23521, 12341, 4567};
		int[] covid19IndiaCases10Aug = {235076, 234513, 33521, 22341, 5567};
		int[] covid19IndiaCases11Aug = {335076, 334513, 43521, 32341, 6567};
		
		int[] iplData = {135, 175, 441, 189, 567};
		
		int max9Aug = covid19IndiaCases9Aug[0];
		
		/*
		for(int i = 1; i < covid19IndiaCases9Aug.length; i++) {
			if (covid19IndiaCases9Aug[i] > max9Aug) {
				max9Aug = covid19IndiaCases9Aug[i];
			}
		}
		
		System.out.println("Max cases on 9th Aug: "+ max9Aug);
		
		int max10Aug = covid19IndiaCases10Aug[0];
		
		for(int i = 1; i < covid19IndiaCases10Aug.length; i++) {
			if (covid19IndiaCases10Aug[i] > max9Aug) {
				max10Aug = covid19IndiaCases10Aug[i];
			}
		}
		
		System.out.println("Max cases on 10th Aug: "+ max10Aug);
		
		int maxPoints = iplData[0];
		
		for(int i = 1; i < iplData.length; i++) {
			if (iplData[i] > maxPoints) {
				maxPoints = iplData[i];
			}
		}
		
		System.out.println("Max points from IPL Data: "+ maxPoints);
		*/
		
		Methods mRef = new Methods();
		mRef.getMaxNumber1(covid19IndiaCases9Aug);
		mRef.getMaxNumber1(covid19IndiaCases10Aug);
		mRef.getMaxNumber1(covid19IndiaCases11Aug);
		mRef.getMaxNumber1(iplData);	
		
		System.out.println();
		
//		static methods -> executed with class name
		Methods.getMaxNumber2(covid19IndiaCases9Aug);
		Methods.getMaxNumber2(covid19IndiaCases10Aug);
		Methods.getMaxNumber2(covid19IndiaCases11Aug);
		Methods.getMaxNumber2(iplData);
		
		int result1 = mRef.getMaxNumber1(covid19IndiaCases10Aug);
		int result2 = Methods.getMaxNumber2(covid19IndiaCases10Aug);
		
		System.out.println("result1: "+ result1);
		System.out.println("result2: "+ result2);
		
		System.out.println("Max in IPL Data: "+ Methods.getMaxNumber2(iplData));
		
	}

}
