import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PlainBubbleSort {
	static int[] array;
	static int numberofcomparisonwithplainbubblesort = 0;

	public static int[] BubbleMePlain(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			boolean swap = false;
			for (int j = 0; j < array.length - i - 1; j++) {

				numberofcomparisonwithplainbubblesort++;
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

	

	

	public static void show(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println();

		array = new int[10000];

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

					array[i] = Integer.parseInt(line);
					i++;

				}
			} // End while.
			System.out.println("Load Successful");

		} // End try.

		catch (IOException e) {
			System.out.println("Error " + e);
		}
		// End catch.

		int[] sortedArray = BubbleMePlain(array);
		System.out.println("The number of comparison in plain bubble sort is "+ numberofcomparisonwithplainbubblesort);
		show(sortedArray);

	}
}
