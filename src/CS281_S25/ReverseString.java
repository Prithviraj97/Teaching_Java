
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Java Class I";
		String reversed = "";
		
		//loop through all chars in string in reverse.
		for(int i = input.length()-1; i >=0; i--) {
			reversed += input.charAt(i);
		}
		System.out.println("Reversed chars are: " + reversed);
	}

}
