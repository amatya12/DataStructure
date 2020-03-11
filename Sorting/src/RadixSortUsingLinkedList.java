import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
public class RadixSortUsingLinkedList {
	
	static int  numberofcomparison=0;
	
	static int[]array;
	static LinkedList[] bin;

	public int NumberOfDigit(int[] array) { // This method finds the maximum digit from the list and gives the count of
											// which the max digit is made up of.
		int maximum = array[0];
		int numberofdigit = 0;
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] > maximum) {
				
				maximum = array[i];
			}
		}
		while (maximum > 0) {
			
			numberofdigit++;
			
			maximum = maximum / 10;

		}

		return numberofdigit;
	}
	
	public int ElementAt(int number , int position) {
		//numberofcomparison++;
		int element = (int) ((number/Math.pow(10, position))%10);
		return element;
	}
	
	public int[] sorting(int[] array) {
		int numberofpasses = NumberOfDigit(array);
		
		for(int i = 0 ; i < numberofpasses; i++) {
		
			   
			for(int j = 0 ;j<array.length; j++) {
				
				int binnumber = ElementAt(array[j] , i);
				
				
				bin[binnumber].offer(array[j]);
				numberofcomparison++;
				
			}
			int l = 0;
			for(int k = 0 ; k < bin.length ; k++) {
				while(bin[k].peek()!=null) {
					array[l]=(int)bin[k].poll();
					l++;
					
				}
			}
			
		}
		return array;
		
		
	}
	
	public static void main(String[] args) {
		
		RadixSortUsingLinkedList r = new RadixSortUsingLinkedList();
		array = new int[10000];
		bin = new LinkedList[10];
		
		for(int i = 0;i <10;i++) {
			bin[i] = new LinkedList();
		}
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("numbers10000.txt"));
			String line="";
			int  i = 0;
			boolean looping = true;
			while (looping) {
				// Get a line of input from the file.
				if (null == (line = in.readLine())) {
					looping = false;
					// Close and free up system resource.
					in.close();
				} else {
				
					array[i] = Integer.parseInt(line);
					i++;
					
				}
			} // End while.

		} // End try.

		catch (IOException e) {
			System.out.println("Error " + e);
		} 
		// End catch.
		
		int[] sortedarray=r.sorting(array);
		for(int i = 0 ;i<sortedarray.length;i++) {
			System.out.println(sortedarray[i]);
		}
		
		System.out.println("The number of comparison using radix sort is " +numberofcomparison);
		
	}
	

}
