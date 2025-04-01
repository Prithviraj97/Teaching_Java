
public class MergeSort {
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length <=1) {
			return;
		}
		mergeSortHelper(arr, 0, arr.length-1);
	}
	
	//method to recursively divide
	private static void mergeSortHelper(int[] arr, int left, int right) {
		if(left < right) {
			int mid = left + (right-left)/2;
			mergeSortHelper(arr, left, mid);
			mergeSortHelper(arr, mid+1, right);
			
			//merge the sorted array
			merge(arr, left, mid, right);
		}
	}
	
	//conquer or merger the sorted arrays
	public static void merge(int[] arr, int left, int mid, int right) {
		//find the sizes of two sub-arrays to be merged
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		//create temporary arrays
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		
		//copy data to temp arrays
		for(int i=0; i<n1; i++) {
			leftArray[i] = arr[left+i];
		}
		
		for(int j=0; j<n2; j++) {  
			rightArray[j] = arr[mid+1+j];
		}

		//merge the temp arrays
		int i=0, j=0;
		int k=left;
		while(i<n1 && j<n2) {
			if(leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		//copy remaining elements of leftArray[] if any
		while(i<n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		//copy remaining elements of rightArray[] if any
		while(j<n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}

	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		// initialize an array and use merge sort algo for sorting
		int[] arr = {12, 11, 13, 5, 6, 7};
		System.out.println("Given array is: ");
		printArray(arr);
		mergeSort(arr);
		System.out.println("Sorted array is: ");
		printArray(arr);

	}

}
