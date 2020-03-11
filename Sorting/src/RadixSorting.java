import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class RadixSorting {

	static LinkedListForRadix[] bucket = new LinkedListForRadix[10];
	static int comparisons = 0;

	public static int GetMaxnoofdigit(String[] a) {
		int maximum = a[0].length();
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() > maximum) {
				maximum = a[i].length();
			}

		}
		return maximum;
	}

	public static String[] sort(String[] array) {
		int pass = GetMaxnoofdigit(array);

		for (int i = pass; i >= 1; i--) {
			for (int j = 0; j < array.length; j++) {
				int bucketnumber = SelectingBin(array[j], i);
				bucket[bucketnumber].add(array[j]);
			}
			int a = 0;
			for (int k = 0; k < bucket.length; k++) {
				while (bucket[k].IsThereonthebin() != null) {

					array[a] = (String) bucket[k].Remove();

					a++;
				}
			}

		}

		return array;
	}

	public static void show(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int SelectingBin(String number, int numberAt) {
		comparisons++;
		int length = number.length();

		if (length < numberAt) {
			return 0;
		} else {
			return (number.charAt(numberAt - 1) - '0');
		}
	}

	public static void main(String[] args) {

		// Making 10 buckets from 0 to 9 and it is of linked List nature;
		for (int i = 0; i < bucket.length; i++) {
			// bucket[i] = new LinkedList();
			bucket[i] = new LinkedListForRadix();
		}
		String[] listofnumbers = new String[10000];
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("numbers10000.txt"));
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

					listofnumbers[i] = (line);
					i++;

				}
			} // End while.

		} // End try.

		catch (IOException e) {
			System.out.println("Error " + e);
		}
		// End catch.

		String[] sortedarray = sort(listofnumbers);
		show(sortedarray);
		System.out.println("The number of comparisons made is " + comparisons);

	}

}
