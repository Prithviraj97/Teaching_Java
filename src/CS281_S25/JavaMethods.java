
public class JavaMethods {

	public static void main(String[] args) {
		// methods in java
		System.out.println(addNum(4,5));
		int c = addNum(4,5);
		getSum(4.7,5.3);
		
		System.out.println(product(5.2, 3.4));
	}
	
	public static int addNum(int a, int b) {
		int sum = a+b;
		return sum;
	}
	
	public static void getSum(double x, double y) {
		double addition = x+y;
//		return addition;
		System.out.println("Addtion of values is: " + addition);
	}
	
	private static double product(double a, double b) {
		return a*b;
	}

}
