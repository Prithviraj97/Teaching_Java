package CS281;

public class minmax {

    public static int minVal(int[] A, int N)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++)
        {
            if(A[i] < min){
                min = A[i];
            }
        }
        return min;
    }

    public static int maxVal(int[] A, int N)
    {
        int max = Integer.MIN_VALUE;
        for(int j=0; j<N; j++)
        {
            if(A[j] > max){
                max = A[j];
                }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {3,7,5,4,9,12,20,34,54,64};
        int n = arr.length;
        System.out.println("Minimum value in the array is: "+minVal(arr,n));
        System.out.println("Maximum value in the array is: " + maxVal(arr, n));
    }
}
