
public class BabyLinkedList {
	static Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	public void addNodeAtEndOfList(int key) {
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

	public void findTail1(Node n) {
		Node current = n;

		if (current.next == null) {
			System.out.println(current.data);
		} else {

			findTail1(current.next);
		}

	}

	public Node findTail() {
		Node current = head;

		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	public Node makeNode(int key) {
		Node new_node = new Node(key);
		new_node.next = null;
		return new_node;
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

	public Node reverse(Node n) {
		Node current = n;
		Node previous = null;
		Node afterCurrent = null;
		while (current != null) {
			afterCurrent = current.next;
			current.next = previous;
			previous = current;
			current = afterCurrent;
		}

		n = previous;
		return n;

	}

	public void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

	}

	int count = 0;

	public void findNumber(Node n) {

		if (n != null) {
			count++;
			findNumber(n = n.next);
		} else {
			System.out.println(count);
		}
	}

	public static void main(String[] args) {
		BabyLinkedList bll = new BabyLinkedList();
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 10; i++) {
			bll.addNodeAtEndOfList(i);
		}
		Node current = head;

		bll.findNumber(current);

	}

}
