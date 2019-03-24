import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * 
 * Multi-indexed lists are very much like singly linked lists, with the exception that they provide the programmer/user with the ability to enter the list from some other place than the front of the list.  By being able to jump into the list at multiple points, the efficiency of finding data can be increased.   
 
Consider an unordered list that has 10,000 nodes; each time data is requested from the list, on average, 5,000 nodes will need to be searched (if each data item is equally likely to be requested). 

 Since the list is not ordered, if the data is not present in the list, this fact would not be known until the entire list were searched. 
  That is a lot links to follow, just to find out that what you were looking for was not present. 
   If the list were ordered, the search could determine that an element were not present by finding the position that it should be, but for items in the list, the average number of elements to search would still be around 5000. 
   
   
 
A quick remedy would be to order the list and then create a index with multiple entries into the list.  For example, if the data was phone book information (name, address, prone number), the list would be built in alphabetical order.
  Then an index array with 26 elements could be created with the first element pointing into the list to first name in the 'A' section, the second element pointing to the first name in the 'B' section and so on. 
   Now when a search for a data item were executed, the search no longer start from the front and follow the links until either the item were found, it could go directly to the section and start searching there. 
    Instead of searching a large portion of the list (somwhere around half of list on average), the search portion of the list to be searched would be reduced to about 1/26 of the un-indexed search.  With an indexed list size of 

 
82 
10,000 the average number of nodes to be searched would be around 193.  That is quite an improvement over the 5000, required for the unordered list, and ordered non-indexed list. 

*/

// This is the implementation of the above idea.
class NodeIndex {
	char c;
	int namesInSection;
	Node StartOfSection;

	NodeIndex(Node StartOfSection, int namesInSection, char c) {
		this.StartOfSection = StartOfSection;
		this.namesInSection = namesInSection;
		this.c = c;
	}

}

public class IndexLinkedList extends Helper {

	NodeIndex[] array = new NodeIndex[26];

	public void BuildIndex() {
		int i = 0;
		for (char j = 'a'; j <= 'z'; j++) {
			Node myNode = findNodeWithLetter(j);
			int count = sectionLength(j, myNode);
			array[i] = new NodeIndex(myNode, count, j);
			i++;
		}
	}

	public Node findNodeWithLetter(char s) {
		Node current = head;
		while (current != null && current.name.charAt(0) != s) {

			current = current.next;

		}

		return current;

	}

	public int sectionLength(char ch, Node n) {
		int count = 0;
		Node temp = n;

		while (temp != null) {
			if (temp.name.charAt(0) == ch) {

				count++;
			}
			temp = temp.next;
		}
		return count;

	}

	public void SectionName(char c) {
		Node myNode = array[c - 'a'].StartOfSection;
		while (myNode != null && myNode.name.charAt(0) == c) {
			System.out.println(myNode.name);
			myNode = myNode.next;
		}

	}

	public static void main(String[] args) {

		IndexLinkedList li = new IndexLinkedList();
		Helper s = new Helper();
		Scanner input = new Scanner(System.in);
		boolean startAgain = true;

		try {
			File file = new File("names.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuffer stringBuffer = new StringBuffer();

			int count = 0;

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				li.sort(line);
				count++;

			}
			System.out.println(count);
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		li.BuildIndex();
		while (startAgain) {
			System.out.println("List Of functionalities:");
			System.out.println("1: Display the length of the list" + "\n" + "2:Delete a name from the list" + "\n"
					+ "3:Request the length of a section of the list. (How many people have a name that starts with “B”?)"
					+ "\n" + "4:Display the List" + "\n"
					+ "5:to print out sections of names, for example it should be able to print all peoples names that start with an “A”, “B”, etc."
					+ "\n");

			System.out.println("which functionality do you want to use?????");
			int functionality = input.nextInt();
			input.nextLine();
			switch (functionality) {

			case 1:
				System.out.println("The length of the current list is: " + li.count());
				break;

			case 2:
				System.out.print("which name do you want to delete from the list??");

				String String1 = input.nextLine();

				li.delete(String1);
				break;

			case 3:
				li.BuildIndex();
				System.out.println("How many people have a name that starts with a particular alphabet?");
				System.out.println("Enter the alphabet");
				char String2 = input.nextLine().charAt(0);
				Node myNode = li.array[String2 - 'a'].StartOfSection;

				System.out.println(
						"The number of words starting with " + String2 + " is " + li.sectionLength(String2, myNode));

				break;

			case 4:
				li.showList();
				break;

			case 5:
				li.BuildIndex();
				System.out.println("Enter the alphabet");
				String String3 = input.nextLine();
				char c = String3.charAt(0);

				Node myNode1 = li.array[c - 'a'].StartOfSection;
				int count = li.sectionLength(c, myNode1);
				if (count == 0) {
					System.out.println("There are no names in the current list Starting with " + String3);
				} else {
					System.out.println("The names Starting with " + String3 + " are " + "\n");
					li.SectionName(c);
					break;
				}

			}

		}

	}
}
