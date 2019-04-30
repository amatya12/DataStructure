 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class BubbleSort {

	public int bubbleSort(int[] array) {
		int comparisons = 0;
		int swapCount = 0;
		boolean swapped;
		for (int i = 0; i < array.length; i++) {
			swapped = false;
			
			for (int j = 0; j < array.length - i - 1; j++) {
				comparisons++;
				if (array[j + 1] < array[j]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapCount++;
					swapped = true;
				}
				if (swapped = false) {
					break;
				}
			}
		}
		return comparisons;
		
	}
	public int comparisons(int[] array) {
		int numberofcomparisons = bubbleSort(array);
		return numberofcomparisons;
	}
	
	

	void writeMessage2File(String fileName, String message) {
		try {
			PrintWriter outFile = null;

			outFile = new PrintWriter(fileName, "utf-8");

			outFile.write(message);

			outFile.close();
		} catch (IOException e) {
			System.out.println("Error opening the output file - " + fileName);
			System.out.println("Error " + e);
		}
	}

	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();

		int[] array = new int[1000];
		String s = "";

		try {
			int i = 0;
			File file = new File("numbers.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				array[i] = Integer.parseInt(line);
				i++;
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		b.bubbleSort(array);
		System.out.println(b.comparisons(array));

		for (int i = 0; i < array.length; i++) {

			s += array[i] + " " + "\n";

		}
		s +="the number of comaparisons in bubble sort is "+b.comparisons(array)+"\n";

		b.writeMessage2File("cde.txt", s);
	

	}

}
