
public class methodsInJava {

	public static void main(String[] args) {
		// demo of methods in java
		int a = getSum(3,5);
		System.out.println(a);
		
//		int b = getProd(3,5);
//		System.out.println(b);
		getProd(3,5);
		
		hello.getSum2(4,8);
	}
	
	public static int getSum(int x, int y) {
		return x+y;
	}
	
	private static void getProd(int a, int b) {
//		return a*b;
		System.out.println("mutliplication: " + a*b);
	}

}

class hello{
	public static int getSum2(int a, int b) {
		return a+b;
	}
}
