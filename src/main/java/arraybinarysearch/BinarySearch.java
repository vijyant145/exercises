package arraybinarysearch;

public class BinarySearch {
	
	public static int binarySearch(int[] array, int value, int start, int end) {
		
		if(end <  start)
			return -1;
		int mid = (start+end)/2;
		
		if(value == array[mid])
			return mid;
		
		if (value <= array[mid])
			return binarySearch(array, value, 0, mid-1);
		else 
			return binarySearch(array, value,  mid+1, end);
		
	}
	
	public static int bitonicMax(int[] array, int start, int end) {
		
		if(end <  start)
			return -1;
		int mid = (start+end)/2;
		
		if( array[mid-1] < array[mid] && array[mid] > array[mid+1])
			return mid;
		
		if (array[mid]> array[mid-1] && array[mid]< array[mid+1])
			return bitonicMax(array,  mid+1, end);
		 
		if ( array[mid]< array[mid-1] && array[mid]> array[mid+1]) {}
			return bitonicMax(array, 0, mid-1);
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 30, 40, 50, 60, 70, 23, 23, 20};
		
		int[] sorted = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(binarySearch(sorted, 6, 0, sorted.length));
		System.out.println(bitonicMax(arr,  0, arr.length));
	}

}
