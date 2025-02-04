
public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "hello";
		char target = 'l';
		int count = 0;
		
		for(int i =0; i<input.length(); i++) {
			if(input.charAt(i) == target) {
				count++;
			}
		}
		System.out.println("The character '" + target + "' appears " + count + " times.");
	}

}
