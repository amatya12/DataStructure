
public class Bubble {
	int[] array;

	public static void SelectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = array[i];
			int minindex = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					minindex = j;
				}

			}
			
			swap(i , minindex, array);

		}

	}

	public static void swap(int i, int minindex, int[] array) {
		int temp=array[minindex];
		array[minindex]= array[i];
		array[i]=temp;
	}

	public static void BubbleMe(int[] array) {
		boolean swapping;
		int comparison=0;
		for (int j = 0; j < array.length; j++) {
			swapping=false;
			for (int i = 0; i < array.length - 1 - j; i++) {
				comparison++;
				if (array[i + 1] < array[i]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapping = true;
				}
				
				
			}
			if (swapping = false) {
				break;
			}
			
			
			
			
		}
		System.out.println(comparison);
		}
	
	

	public static void showList(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,};
		BubbleMe(array);
		
	}

}
