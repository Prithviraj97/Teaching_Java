package CS281_S25;
import java.util.ArrayList;
import java.util.Arrays;

public class ArraytoArrayList {

	public static void main(String[] args) {
		// conversion between arrays and arraylist.
		String[] array = {"Python", "Java", "C", "Prolog"};
		//create an array list from array
		ArrayList<String> langs = new ArrayList<>(Arrays.asList(array));
		
		//create an array from array list
		String[] prog_lang = new String[langs.size()];
		langs.toArray(prog_lang);
//		System.out.println(prog_lang);
		}

	}

