import java.util.Scanner;

public class LinkedList extends BabyLinkedList {
	BabyLinkedList bll = new BabyLinkedList();

	public void insertAfter(int insertAfter, int key) {
		Node new_node = bll.makeNode(key);
		if (head == null) {
			return;
		}
		Node current = head;

		while (current.data != insertAfter && current != null) {
			if (current.next == null) {
				System.out.println("No such key available" + "\n" + "Try the key which is present in the node");
				return;

			} else {

				current = current.next;
			}

		}

		if (current != null) {
			new_node.next = current.next;
			current.next = new_node;
		}
	}

	public void insertAfter(Node insertAfter, int key) {

		if (head == null) {
			System.out.println("No nodes present in the Linked List");
			return;
		}
		Node new_node = makeNode(key);
		Node current = head;
		while (current != insertAfter) {

			current = current.next;
			if (current == null) {
				System.out.println("No such node available");
				return;
			}

		}
		new_node.next = current.next;
		current.next = new_node;

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

	public void insertBefore(int insertBefore, int key) {
		Node new_node = bll.makeNode(key);
		if (head == null) {
			return;
		}
		if (insertBefore == head.data) {
			new_node.next = head;
			head = new_node;
			return;
		}
		Node current = head;
		Node previous = null;
		while (current != null && current.data != insertBefore) {
			previous = current;
			current = current.next;
		}
		new_node.next = current;
		previous.next = new_node;
	}

	public void addBetween(int position1, int position2, int key) {
		Node new_node = new Node(key);

		Node n1 = nodeAtPosition(position1);

		Node n2 = nodeAtPosition(position2);
		if (n1 == null || n2 == null) {
			return;

		}
		n1.next = new_node;
		new_node.next = n2;

	}

	void printMiddle() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("The middle element is [" + slow_ptr.data + "] \n");
		}
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

	/*public void findMiddle() {

		int i = 0;
		Node current = head;
		int numberOfNodes = count();
		if (numberOfNodes % 2 == 1) {
			while (i < (numberOfNodes / 2)) {
				current = current.next;
				i++;
			}
			System.out.println(current.data);
		}
		if (numberOfNodes % 2 == 0) {
			while (i < ((numberOfNodes / 2))) {
				current = current.next;
				i++;
			}
			System.out.println(current.data);
		}

	}*/

	public void delete(int key) {
		Node current = head;
		if(head==null) {
			System.out.println("Nothing is present in the list");
			return;
		}

		if (key == head.data) {
			head = head.next;
			return;

		}
		Node previous = null;
		while (current.data != key) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;

	}
	
	public void delete(Node spot) {
		if(spot==null) {
			System.out.println("No such node present in the linkedlist");
			return;
		}
		
		
		if(spot==head) {
			head = head.next;
			return;
		}
		Node current = head;
		Node previous = null;
		while(current!=spot) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		
		
	}

	public static void main(String[] args) {
		boolean startAgain = true;
		LinkedList ll = new LinkedList();
		Scanner input = new Scanner(System.in);

		while (startAgain == true) {

			System.out.println("List of Functionalities");
			System.out.println("1:Add a node at the end of the list" + "\n" + "2:Delete a node" + "\n"
					+"3: Delete a node on the basis of data it possess"+"\n"
					+ "4:Add a node after specified node" +"\n"
					+"5:Add a new node after a certain data"+"\n"
				 + "6:Add a node between two nodes" + "\n"
					+ "7:Find the middle node of the LinkedList" + "\n" + "8:Display the list" + "\n"
					+ "9:Terminate the program");
			System.out.println("Which Functionality do you want to use?");
			int value = input.nextInt();

			switch (value) {
			case 1:
				System.out.println("what you want to add to the node?");
				int variable = input.nextInt();
				ll.addNodeAtEndOfList(variable);
				break;
			case 2:
				System.out.println("Enter the spot of Node that you want to delete");
				int spot = input.nextInt();
				Node n = ll.nodeAtPosition(spot);
				ll.delete(n);
				break;
			case 3:
				System.out.println("Enter the data you want to delete");
				int data = input.nextInt();
				ll.delete(data);
				break;
			case 4:
				System.out.println("After which Node's location you want to add new node?" + "\n"
						+ "Also the value to be added in the new node");
				int location = input.nextInt();
				int data1 = input.nextInt();
				ll.insertAfter(ll.nodeAtPosition(location), data1);
				break;
			case 5:
				System.out.println("After which data you want to add a new node? and the value in the new node");
				int data2 = input.nextInt();
				int value1 = input.nextInt();
				ll.insertAfter(data2, value1);
				break;
				
				
				
			case 6:
				System.out.println("Between which two nodes you want to add a new node??");
				System.out.println("Enter the first location");
				int location1 = input.nextInt();
				System.out.println("Enter the second location?");
				int location2 = input.nextInt();
				System.out.println("Enter the value you want in the new node??");
				int data3 = input.nextInt();
				ll.addBetween(location1, location2, data3);
				break;

			case 7:
				System.out.print("The middle of the LinkedList is ");
				ll.printMiddle();
				break;

			case 8:

				ll.showList();
				break;

			case 9:

				System.out.println("Game over");
				startAgain = false;
				break;
				
			case 10:
				ll.insertBefore(2, 1);
			}
		}

		/*
		 * ll.addNodeAtEndOfList(3); ll.addNodeAtEndOfList(5); ll.addNodeAtEndOfList(7);
		 * ll.addNodeAtEndOfList(9); ll.addNodeAtEndOfList(2);
		 * ll.addNodeAtEndOfList(10); ll.addNodeAtEndOfList(45);
		 * ll.addNodeAtEndOfList(11); //ll.delete(11); //
		 * System.out.println(ll.nodeAtPosition(7).data);
		 * System.out.println("After which node you want your node to be added??"); int
		 * n = input.nextInt();
		 * System.out.println("what is the value in your new node?"); int key =
		 * input.nextInt(); ll.insertAfter(ll.nodeAtPosition(n), key); ll.showList();
		 * ll.addBetween(2,3,6); ll.showList();
		 */

		// ll.findMiddle(); ll.printMiddle();

		// ll.showList();

	}

}
