package CS281_S25;
import java.util.ArrayList;

public class Numbers {

	public static void main(String[] args) {
		// create an array list of integers
		ArrayList<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(47);
		list.add(56);
		list.add(63);
		
		if(list.isEmpty()) {
			return;
		} else {
			ArrayList<Integer> evenVal = new ArrayList<>();
			for(int num: list) {
				if(num %2 == 0) {
					evenVal.add(num);
				}
			}
			System.out.println(evenVal);
		}
		
//		if(!list.isEmpty()) {
//			
//		}
	}

}
