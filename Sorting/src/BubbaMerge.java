import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BubbaMerge {

	static int[] array1;
	static int[] array2;
	static int[] array3;
	static int[] array4;
	static int[] array5;
	static int numberofcomparisons = 0;
	//static int numberofcomparisonwithplainbubblesort = 0;

	
	public static int[] BubbleMe(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			boolean swap = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				numberofcomparisons++;

				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swap = true;
				}

			}
			if (swap == false) {
				break;
			}
		}

		
		return array;

	}

	public static int[] merge(int[] array1, int[] array2, int startofarray1, int startofarray2) {

		int[] temp = new int[(array1.length + array2.length)];
		int leftend = array1.length - 1;
		int rightend = array2.length - 1;
		int index = 0;

		while (startofarray1 <= leftend && startofarray2 <= rightend) {
			numberofcomparisons++;

			if (array1[startofarray1] <= array2[startofarray2]) {
				temp[index] = array1[startofarray1];
				startofarray1++;
			} else {
				temp[index] = array2[startofarray2];
				startofarray2++;
			}
			index++;
		}

		System.arraycopy(array1, startofarray1, temp, index, leftend - startofarray1 + 1);
		System.arraycopy(array2, startofarray2, temp, index, rightend - startofarray2 + 1);
		return temp;
	}

	public static void show(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println();

		array1 = new int[2000];
		array2 = new int[2000];
		array3 = new int[2000];
		array4 = new int[2000];
		array5 = new int[2000];

		for (int j = 0; j < 5; j++) {

			try {
				System.out.println("Enter the textfile you wanna load");

				String s = input.nextLine();
				DataInputStream in = new DataInputStream(new FileInputStream(s));
				String line = "";
				int i = 0;
				boolean looping = true;
				while (looping) {
					// Get a line of input from the file.
					if (null == (line = in.readLine())) {
						looping = false;
						// Close and free up system resource.
						in.close();
					} else {

						if (s.equals("number1.txt")) {
							array1[i] = Integer.parseInt(line);
							i++;
						}

						if (s.equals("number2.txt")) {
							array2[i] = Integer.parseInt(line);
							i++;
						}
						if (s.equals("number3.txt")) {
							array3[i] = Integer.parseInt(line);
							i++;
						}
						if (s.equals("number4.txt")) {
							array4[i] = Integer.parseInt(line);
							i++;
						}
						if (s.equals("number5.txt")) {
							array5[i] = Integer.parseInt(line);
							i++;
						}

					}
				} // End while.
				System.out.println("Load Successful");

			} // End try.

			catch (IOException e) {
				System.out.println("Error " + e);
			}
			// End catch.
		}
		
		array1 = BubbleMe(array1);

		//int comparisons = numberofcomparisons;
		array2 = BubbleMe(array2);
		
		//comparisons += numberofcomparisons;
		array3 = BubbleMe(array3);
		//comparisons += numberofcomparisons;

		array4 = BubbleMe(array4);
		//comparisons += numberofcomparisons;
		array5 = BubbleMe(array5);
		//comparisons += numberofcomparisons;

		int[] temp = merge(array1, array2, 0, 0);
		//comparisons += numberofcomparisons;
		int[] temp1 = merge(temp, array3, 0, 0);
		//comparisons += numberofcomparisons;
		int[] temp2 = merge(temp1, array4, 0, 0);
		//comparisons += numberofcomparisons;
		int[] temp3 = merge(temp2, array5, 0, 0);
		//comparisons += numberofcomparisons;
		System.out.println(numberofcomparisons);
		show(temp3);

	}
}
