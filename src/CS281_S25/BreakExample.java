package CS281_S25;
public class BreakExample {

	public static void main(String[] args) {
		//A break statement is used to exit a loop immediately when a certain condition is met.
		//it stops the loop from continuing further.
		
		for(int i=1; i <=100; i++) {
			if(i%7 == 0) {
				System.out.println("First multiple of 7 between 1 and 100 is: " + i);
				break;
			}
		}
	}

}
