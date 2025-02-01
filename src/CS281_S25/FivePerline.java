package CS281_S25;
public class FivePerline {

	public static void main(String[] args) {
		int START = 1000;
		int END = 2000;
		int PER_LINE = 5;
		
		for(int i = START; i <= END; i++) {
			System.out.print(i + " ");
			if((i+1) % PER_LINE == 0)
				System.out.println();
		}
		System.out.println();
	}

}
