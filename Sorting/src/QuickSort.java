
public class QuickSort {
	
	
	
	
	
	public void quicksort(int[]array , int start, int end) {
		if(start<end) {
			int index = partition(array, start, end);
			quicksort(array ,start , index-1);
			quicksort(array , index+1 , end);
		}
	}
	
	
	public int partition(int[]array,  int start, int end) {
		int pivot  = array[end];
		int partitionindex = start;
		for(int i = 0; i <array.length-1;i++) {
			if(array[i]<=pivot) {
				int temp = array[i];
				array[i] = array[partitionindex];
				array[partitionindex] = temp;
			//Swap(array[i], array[partitionindex]);
			partitionindex++;
		int[] ad=	array;
			}
		}
			int temp = array[end];
			array[end] = array[partitionindex];
			array[partitionindex] = temp;
			//Swap(pivot,array[partitionindex]);
		
 			return partitionindex;
			
	}
	public static void show(int[] array) {
		for(int i = 0; i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}
	
	public static void main(String[]args) {
		QuickSort q = new QuickSort();
		int[] array = {1,2,7,3,6,7};
		q.quicksort(array, 0, array.length-1);
		q.show(array);
	}
	}





/*class QuickSort 
{ 
     This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot 
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
     The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index 
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
             pi is partitioning index, arr[pi] is  
              now at right place 
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
     A utility function to print array of size n 
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} */