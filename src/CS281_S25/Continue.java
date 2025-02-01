package CS281_S25;
public class Continue {

	public static void main(String[] args) {
		// A `continue` statement is used to skip the current iteration of the loop and proceed
		// to the next iteration, without terminating the loop.
		
		for(int i=1; i<= 10; i++) {
			if(i%3 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
