import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;




 class KeyValuePair{
	int key;
	String value;
	KeyValuePair( int key , String value) {
		this.key = key;
		this.value = value;
	}
	 
	public int GetKey() {
	return key;
	}
	
	public String GetValue() {
		return value;
	}
	
	public void SetValue(String value) {
		this.value=value;
	}
	

}



public class Hashing {
	KeyValuePair[] hashTable;
	static int count = 0;

	Hashing(int tableLength) {
		hashTable = new KeyValuePair[tableLength];
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new KeyValuePair(-1, "");

		}
	}

	public int nameCode(String name) {
		int nameCode = (((name.charAt(0) - 'a') * 26 * 26) + ((name.charAt(1) - 'a') * 26)
				+ ((name.charAt(2) - 'a') * 1));
		return nameCode;
	}

	public int GenerateHashIndex(String name) {

		int nameCode = nameCode(name);
		if (hashTable.length == 400) {
			int index = nameCode / 45;
			return index;
		} else if (hashTable.length == 200) {
			int index = nameCode / 100;
			return index;
		} else if (hashTable.length == 700) {
			int index = nameCode / 27;
			return index;
			
		}  else if (hashTable.length == 400) {
			int index = nameCode /44 ;
			return index;
		}
			else {
			return -1;
		}

	}

	public void AddToHashTable(String name) {

		int hashIndex = GenerateHashIndex(name);
		if (hashTable[hashIndex].GetKey() == -1) {
			hashTable[hashIndex] = new KeyValuePair(hashIndex, name);
		} else {
			getNextOpenPosition(name);

		}
	}

	public void ShowHashTable() {
		System.out.println("The number of hash clashes are= " + count);
		System.out.println("HashIndex--------------> value");
		for (int i = 0; i < hashTable.length; i++) {

			if (hashTable[i].key != -1) {
				System.out.println(hashTable[i].key + "---------------------->" + hashTable[i].value);
			}
		}
	}

	public void getNextOpenPosition(String name) {

		int index = GenerateHashIndex(name);
		while (hashTable[index].key != -1) {
			count++;
			index = index + 1;
		}
		hashTable[index] = new KeyValuePair(index, name);

	}

	public void Remove(String s) {
		int index = GenerateHashIndex(s);
		KeyValuePair pair = hashTable[index];
		boolean searching = true;
		while (searching) {
			if (pair.value.equals(s)) {
				hashTable[index] = new KeyValuePair(-1, "");
				searching = false;
			} else {
				index++;
			}
		}
	}

	public void Search(String s) {
		int index = GenerateHashIndex(s);
		boolean searching = true;
		while (searching) {
			KeyValuePair pair = hashTable[index];
			if (pair.value.equals(s)) {
				searching = false;

			} else {
				index = index + 1;
			}

		}
		System.out.println("The name " + s + " is found at a Hash Index of " + index);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How long you want your hashTable to be??(options available= 200, 400,700");
		int hashTableSize = input.nextInt();
		System.out.println();
		Hashing h = new Hashing(hashTableSize);
		boolean Continue = true;
		
		
		System.out.println();
		

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
		System.out.println(h.nameCode("zzz"));
		
		while (Continue) {
			System.out.println("What do you want to do?\n");
			System.out.println( "1:Add to HashTable\n" +"2: Search name with its hash index??\n"
					+ "3:Remove the data from the hashTable\n"
					+ "4: Do you Want to know the number of collisions occured with current HashTable\n"+"5:Show the current hashTable\n"+"6:Exit the program\n");
			int s = input.nextInt();
			input.nextLine();
			switch (s) {


			case 1:
				System.out.println("enter the name");
				String name = input.nextLine();
				h.AddToHashTable(name);
				break;
				
				
			case 2: 
				System.out.println("which name and its hashindex do you want to search??");
				String name1 = input.nextLine();
				h.Search(name1);
				break;

			
			
			case 3:
				System.out.println("which name do you want to delete from hashtable and make its space empty??");
				String name12 = input.nextLine();
				h.Remove(name12);
				break;
				
			case 4:
				System.out.println("The number of collisions in building the index is: "+ count );
				break;
			case 5: 
				h.ShowHashTable();
				break;
				
			case 6:
				Continue = false;
				break;
			}
			
		}
	}

}
