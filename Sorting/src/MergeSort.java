
public class MergeSort {

	public static void mergesort(int[] array) {
		mergesort(array,0,new int[array.length],array.length-1);
	}

	public static void mergesort(int[]array,int leftstart,int[]temp, int rightend) {
		if(leftstart>=rightend) {
			return;
		} 
		
		int middle = (leftstart+rightend)/2;
		mergesort(array, leftstart,temp,middle);
		mergesort(array,middle+1,temp,rightend);
		mergehalves(array,leftstart,temp, rightend);
		
	}
	public static void mergehalves(int[] array, int leftstart,int[]temp,int rightend ) {
		int leftend = (leftstart+rightend)/2;
		int rightstart = leftend+1;
		int size = rightend-leftstart+1;
		   
		int left = leftstart;
		int right = rightstart;
		int index = leftstart;
		
		while(left<=leftend && right<=rightend) {
			if(array[left]<=array[right]) {
				temp[index] = array[left];
				left++;
			}
			else {
				temp[index]=array[right];
				right++;
			}
			index++;
		}
		
		
		System.arraycopy(array, left, temp, index, leftend-left+1);
		System.arraycopy(array, right, temp, index, rightend-right+1);
		System.arraycopy(temp, leftstart,array , leftstart,size);
		
	}
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	public static void main(String[] args) {
		int[] arr = {2,4,1,6,8,5,3,7};
		mergesort(arr);
		
		printArray(arr);
		
	}
	 
}
