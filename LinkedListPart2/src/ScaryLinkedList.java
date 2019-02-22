import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class ScaryLinkedList extends BabyLinkedList {

	BabyLinkedList bll = new BabyLinkedList();
	
	
	public Node sortedMerge(Node a, Node b)  
    { 
        Node result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        
        int value = ((a.data.compareTo(b.data)));
        if(value<=0) {
        	result = a;
        	result.next = sortedMerge(a.next , b);
        }
      
        else 
        { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
  
    } 
  
	
	
	public  Node mergeSort(Node h)  
	    { 
	        // Base case : if head is null 
	        if (h== null || h.next == null) 
	        { 
	            return h; 
	        } 
	  
	        // get the middle of the list 
	        Node middle = getMiddle(h);
	        Node nextofmiddle = middle.next; 
	  
	        // set the next of middle node to null 
	        middle.next = null; 
	  
	        // Apply mergeSort on left list 
	        Node left = mergeSort(h); 
	  
	        // Apply mergeSort on right list 
	        Node right = mergeSort(nextofmiddle); 
	  
	        // Merge the left and right lists 
	        Node sortedlist = sortedMerge(left, right); 
	        return sortedlist; 
	    } 
	 
	 
	 Node getMiddle(Node h)  
	    { 
	        //Base case 
	        if (h == null) 
	            return h; 
	        Node fastptr = h.next; 
	        Node slowptr = h; 
	          
	        // Move fastptr by two and slow ptr by one 
	        // Finally slowptr will point to middle node 
	        while (fastptr != null) 
	        { 
	            fastptr = fastptr.next; 
	            if(fastptr!=null) 
	            { 
	                slowptr = slowptr.next; 
	                fastptr=fastptr.next; 
	            } 
	        } 
	        return slowptr; 
	    } 
	
	public void showList() {
		Node temp = head;
		String result = "";
		if (temp == null) {
			System.out.println("Nothing is present in the list");
		}
		while (temp != null) {

			result += temp.data + "  ";
			temp = temp.next;
		}
		System.out.println(result);

	}

	public int count() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public int sectionLength(String ch) {
		int count = 0;
		Node temp = head;
		String str = "";
		while (temp != null) {
			if (temp.data.toLowerCase().startsWith(ch.toLowerCase())) {
				str = str + temp.data + "\n";
				count++;
			}
			temp = temp.next;
		}
		return count;

	}

	public String userchoice(String ch) {
		int count = 0;
		Node temp = head;
		String str = "";
		while (temp != null) {
			if (temp.data.toLowerCase().startsWith(ch.toLowerCase())) {
				str = str + temp.data + "\n";
				count++;
			}
			temp = temp.next;
		}

		return str;

	}

	public Node nodeAtPosition(int position) {

		int i = 0;
		Node current = head;
		while (i < position) {
			try {
				if (current == null) {

				}
				current = current.next;
				i++;
			} catch (Exception exception) {
				System.out.println("NO such location exists in current Linked List");
				break;
			}
		}
		return current;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ScaryLinkedList s = new ScaryLinkedList();
		boolean startAgain = true;

		try {
			File file = new File("names.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			StringBuffer stringBuffer = new StringBuffer();

			int count = 0;

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				s.addNodeAtEndOfList(line);
				count++;

			}
			System.out.println(count);
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (startAgain) {
			System.out.println("List Of functionalities:");
			System.out.println("1: Display the length of the list" + "\n" + "2:Delete a name from the list" + "\n"
					+ "3:Request the length of a section of the list. (How many people have a name that starts with “B”?)"
					+ "\n" + "4:Display the List" + "\n"
					+ "5:to print out sections of names, for example it should be able to print all peoples names that start with an “A”, “B”, etc."+"\n"
					+"6: Sort the existing list");

			System.out.println("which functionality do you want to use?????");
			int functionality = input.nextInt();
			input.nextLine();
			switch (functionality) {

			case 1:
				System.out.println("The length of the current list is: " + s.count());
				break;

			case 2:
				System.out.print("which name do you want to delete from the list??");

				String String1 = input.nextLine();
				String1.trim();
				s.delete(String1);
				break;

			case 3:
				System.out.println("How many people have a name that starts with a particular alphabet?");
				System.out.println("Enter the alphabet");
				String String2 = input.nextLine();
				System.out.println("The number of words starting with " + String2 + " is " + s.sectionLength(String2));

				break;

			case 4:
				s.showList();
				break;

			case 5:
				System.out.println("Enter the alphabet");
				String String3 = input.nextLine();
				int count = s.sectionLength(String3);
				if (count == 0) {
					System.out.println("There are no names in the current list Starting with " + String3);
				} else {
					System.out.println("The names Starting with " + String3 + " are " + "\n" + s.userchoice(String3));
				}
				break;
				
			case 6:
				s.head= s.mergeSort(head);
				s.showList();
				
			}

		}
	}
}
