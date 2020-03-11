
public class Practice {
	public void mergesort(int[] array) {
		mergesort(array, 0, array.length-1, new int[array.length]);
	}
	
	public void mergesort(int[] array , int leftstart, int rightend, int[]temp) {
		if(leftstart>=rightend) {
			return;
		}
		int middle = (leftstart+rightend)/2;
		mergesort(array,leftstart,middle,temp);
		mergesort(array,middle+1,rightend,temp);
		mergehalves(leftstart, rightend, temp,array);
	}
	
	
	public void mergehalves(int leftstart , int rightend, int[]temp, int[]array) {
		int leftend = (leftstart+rightend)/2;
		int rightstart=leftend+1;
		int size = rightend-leftstart +1;
		int left = leftstart;
		int right = rightstart;
		int index= leftstart;
		while(leftstart<=leftend && rightstart<=rightend) {
			if(array[left]<=array[right]) {
				temp[index]=array[left];
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
		System.arraycopy(temp, leftstart, array, leftstart, size);
	}

}
