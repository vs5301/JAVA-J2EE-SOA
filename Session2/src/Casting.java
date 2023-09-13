
public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iVar1 = 50;
		
//		Erroneous:
//		byte bVar1 = iVar1; // as we are copying data from 32 bits of container into 8 bits of container
		
//		copy the 8 bits of data from iVar1 from LSB
//		Casting (byte)
		byte bVar1 = (byte)iVar1; // Down-Casting
		System.out.println("bVar1 is:"+iVar1);
		
		int iVar2 = bVar1;		// Up-Casting (done by compiler)
		System.out.println("iVar2 is: "+iVar2);
		
//		Here, size is not the concern, type if concern
		int iVar3 = 97;
		char ch = (char)iVar3; 	// Type-Casting
				
		System.out.println("ch is: "+ch);
		
	}

}
