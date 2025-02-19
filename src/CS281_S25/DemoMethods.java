//import java.util.Random;
//import java.util.ArrayList;

public class DemoMethods {

	public static void main(String[] args) {
//		Random random = new Random();
//		ArrayList<Integer> nums = new ArrayList<>();
//		
//		for(int i=0; i<10; i++) {
//			int randNum = random.nextInt(10) + 1;
//			nums.add(randNum);
		
		System.out.println(findMax(6,8,2));
		int large = findMax(6,8,2);
		
		int small = large - 3;
		
		System.out.println("AREA OF RECT: " + calcArea(6,8));
		System.out.println("AREA OF SQUARE: " + calcArea(5));
		}

		public static int findMax(int a, int b, int c) {
			if(a >= b && a >=c) {
				return a;
			} else if(b >=a && b>=c) {
				return b;
			} else
				return c;
		}
		
		public static int calcArea(int side) {
			return side*side;
		}
		
		public static int calcArea(int length, int width) {
			return length*width;
		}
		
		
	}

