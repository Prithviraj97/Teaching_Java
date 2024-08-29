
import java.util.Scanner;

public class simplescanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers seperated by space: ");

        String input= scanner.nextLine();
        String[] parts = input.split(" ");

        int firstNum = Integer.parseInt(parts[0]);
        int SecondNum = Integer.parseInt(parts[1]);

        System.out.println("First Num is:" + firstNum);
        System.out.println("Second Num is:" + SecondNum);
        scanner.close();
    }
}
