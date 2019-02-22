package doublyLinkedList;

public class BasicDoublyLinkedList {
	Node head;

	class Node {
		int data;
		Node next;
		Node previous;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertAtFront(int data) {
		Node new_node = new Node(data);
		new_node.next = head;
		new_node.previous = null;
		if (head != null) {
			head.previous = new_node;
		}
		head = new_node;

	}

	public void insertAfter(int insertAfter, int key) {
		Node new_node = new Node(key);
		Node current = head;
		while (current.data != insertAfter) {
			current = current.next;
		}
		
	
		new_node.next = current.next;
		current.next=new_node;
		new_node.previous=current;
		if(new_node.next!=null) {
		new_node.next.previous = new_node;
		
		}
			
		
		
	}
	
	public void insertBefore(int insertBefore , int key) {
		Node new_node = new Node(key);
		if(head==null) {
			System.out.println("There cannot be null");
			return;
		}
		Node past = null;
		Node current = head;
		if(insertBefore == head.data) {
			new_node.next=head;
			head.previous = new_node;
			head=new_node;
			return;
		}
		
		
		while(current.data!=insertBefore) {
			past = current;
			current = current.next;
		}
		new_node.next = current;
		past.next = new_node;
		new_node.previous = past;
		new_node.next.previous=new_node;
		
		
		
		
		/*if(new_node.previous!=null) {
		new_node.previous = past;
		current.previous = new_node;
		}*/
		
	}
	
	
	
	public void insertAtTheEnd(int data) {
		Node new_node = new Node(data);
		new_node.next=null;
		Node current = head;
		
		
		if(head==null) {
			new_node.previous=null;
			head=new_node;
			return;
		}
		
		while(current.next !=null) {
			current = current.next;
		}
		current.next = new_node;
		new_node.previous = current;
		
	}
	
	public void printList() {
		Node current = head;
		Node past = null;
		System.out.println("printing in forward direction");
		while(current!=null) {
			past=current;
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println();
		System.out.println("printitng in backward direction");
		while(past!=null) {
			System.out.print(past.data+" ");
			past = past.previous;
		}
	}
	
	public static void main(String[] args) {
		BasicDoublyLinkedList b = new BasicDoublyLinkedList();
		/*b.insertAtTheEnd(1);
		b.insertAtTheEnd(2);*/
		
		b.insertAtFront(6);
		b.insertAtTheEnd(4);
		
		b.insertAfter(4, 70);
		b.printList();
	}
	

}
