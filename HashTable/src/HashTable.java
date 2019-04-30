import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class HashTable {
	HashAndItsIndex[] HashTable;
	static int numberofclashes;

	HashTable(int tableLength) {
		HashTable = new HashAndItsIndex[tableLength];
		for (int i = 0; i < HashTable.length; i++) {
			HashTable[i] = new HashAndItsIndex("", -1);

		}

	}

	public int GenerateHashIndex(String name) {

		int nameCode = (((name.charAt(0) - 'a') * 26 * 26) + ((name.charAt(1) - 'a') * 26)
				+ ((name.charAt(2) - 'a') * 1));
		if (HashTable.length == 400) {
			int index = nameCode / 45;
			return index;
		} else if (HashTable.length == 200) {
			int index = nameCode / 100;
			return index;
		} else if (HashTable.length == 1000) {
			int index = nameCode / 18;
			return index;
		} else {

			return -1;
		}

	}

	public void AddToHashTable(String name) {

		int hashIndex = GenerateHashIndex(name);
		if (HashTable[hashIndex].GetHashValue() == -1) {
			HashTable[hashIndex] = new HashAndItsIndex(name, hashIndex);
		} else {
			int next = GenerateHashIndex(name);
			while (HashTable[hashIndex].GetHashValue() != -1) {
				numberofclashes++;
				next = next + 1;
			}
			HashTable[next] = new HashAndItsIndex(name, next);

		}
	}

	public void Show() {

		System.out.println("HashIndex" + "    " + " value");
		for (int i = 0; i < HashTable.length; i++) {

			if (HashTable[i].GetHashValue() != -1) {
				System.out.println(HashTable[i].GetName() + "-->" + HashTable[i].GetHashValue());
			}
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("What is the size of the HashTable(options available 200,400,1000)");
		int size = input.nextInt();
		System.out.println();
		HashTable h = new HashTable(size);

		/*System.out.print("Enter the text file you would like to read the names from:");

		String name = input.nextLine();
		*/

	

		try {
			DataInputStream in = new DataInputStream(new FileInputStream("names.txt"));
			String line = "";
			boolean looping = true;
			while (looping) {
				// Get a line of input from the file.
				if (null == (line = in.readLine())) {
					looping = false;
					// Close and free up system resource.
					in.close();
				} else {
					h.AddToHashTable(line);
				}
			} // End while.

		} // End try.

		catch (IOException e) {
			System.out.println("Error " + e);
		}
		// End catch.

		boolean again = true;

		while (again) {
			System.out.println("What do you want to do?");
			System.out.println("1: Do you Want to know the number of collisions occured with current HashTable\n"
					+ "5:Show the current hashTable\n");
			int Input = input.nextInt();
			input.nextLine();
			switch (Input) {

			case 4:
				System.out.println("The number of collisions in building the index is: " + numberofclashes);
				break;
			case 5:
				h.Show();
				break;

			}

		}
	}

}
