package Algorithms;
import java.util.Arrays;
public class bubblesort {
    public static void Bubble(int[] arr)
    {
        int n = arr.length;
        boolean swapped;
        for(int i=0; i< n-1; i++){
            swapped = false;
            for(int j=0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;

                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,6,8,12,9};
        Bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
}
