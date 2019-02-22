package CirclularLinkedList;

public class CircularLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = next;
		}
	}

	public void pushInFront(int key) {
		Node new_Node = new Node(key);

		new_Node.next = head;
		Node current = head;
		if (current != null) {
			while (current.next != head) {
				current = current.next;
			}
			current.next = new_Node;
		} else {
			new_Node.next = new_Node;
		}
		head = new_Node;
	}

	public void displayList() {
		Node current = head;
		if (current != null) {
			do {
				System.out.println(current.data);
				current = current.next;
			} while (current != head);
		}
	}

	public int count() {
		int count = 0;

		Node current = head;

		if (current == null) {

			return 0;
		}
		do {

			current = current.next;
			count++;
		} while (current != head);
		return count;
	}

	public Node findMiddle() {
		int numberOfNodes = count();
		int middlePosition=numberOfNodes/2;
		int i=0;
		Node current = head;
		while(i<middlePosition) {
			current=current.next;
			i++;
		}
		return current;
		
		
		
		/*if(numberOfNodes%2==0) {
			middlePosition = (numberOfNodes/2);
		}
		else {
			middlePosition=(numberOfNodes/2);
		}
		
		Node current = head;
		while(i<middlePosition) {
			current=current.next;
			i++;
		}
		return current;
		*/

	}
	
	
	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.pushInFront(7);
	    cll.pushInFront(6);  
		cll.pushInFront(5);
		  cll.pushInFront(4); 
		  cll.pushInFront(3);
		  cll.pushInFront(2);
		  cll.pushInFront(1);
		  cll.displayList();
		  
		 
		
		System.out.println(cll.findMiddle().data);
	}

}
