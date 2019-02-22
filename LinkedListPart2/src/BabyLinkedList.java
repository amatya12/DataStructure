

public class BabyLinkedList {
	static Node head;

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			next = null;
		}

	}

	public void addNodeAtEndOfList(String key) {
		Node _node = makeNode(key);

		if (head == null) {
			head = _node;
			System.out.println("ADD SUCCESSFUL");
			return;
		}

		Node tail = findTail();
		tail.next = _node;
		System.out.println("ADD SUCCESSFUL");

	}

	public Node findTail() {
		Node current = head;

		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	public Node makeNode(String key) {
		Node new_node = new Node(key);
		new_node.next = null;
		return new_node;
	}

	public void delete(String key) {
		Node current = head;
		if (head == null) {
			System.out.println("Nothing is present in the list");
			return;
		}

		if (head.data.trim().equalsIgnoreCase(key.trim())) {
			head = head.next;
			return;

		}
		Node previous = null;
		while(!current.data.equals(key)){
			previous = current;
			current = current.next;
		}
		previous.next = current.next;

	}

}
