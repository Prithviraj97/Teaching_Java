package CS281_S25;

public class ArraySum {
    
    public static void main(String[] args) {
        int[] numArray = {1,2,3,4,5,6,7,8,9,10};
        int sum = 0;
        int product = 1;
        double average = 0;
        
        // for(int i=0; i < numArray.length; i++) {
        //     sum += numArray[i];
        //     product *= numArray[i];
        // }

        //using the enhanced for loop
        for(int num: numArray) {
            sum += num;
            product *= num;
        }
        average = sum / numArray.length;
        System.out.println("Sum of the array is: " + sum);
        System.out.println("Product of the array is: " + product);
        System.out.println("Average of the array is: " + average);
    }
}
