
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

		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
