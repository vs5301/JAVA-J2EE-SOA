
public class ImagePixelRotation {

	public static void main(String[] args) {
		
		int[] pixel1 = {255, 0, 0};	// Red
		int[] pixel2 = {0, 255, 0};	// Green
		int[] pixel3 = {0, 0, 255};	// Blue
		
		int[] pixel4 = {125, 111, 255};
		int[] pixel5 = {225, 211, 155};
		int[] pixel6 = {135, 101, 25};
		
		int[] pixel7 = {15, 11, 125};
		int[] pixel8 = {25, 11, 205};
		int[] pixel9 = {12, 11, 155};
		
		int[][][] image = {
				{pixel1, pixel2, pixel3},
				{pixel4, pixel5, pixel6},
				{pixel7, pixel8, pixel9},
		};

	}

}
