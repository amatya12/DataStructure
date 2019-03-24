import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Node {
	String name;
	int nameCode;
	Node next;

	Node(String name) {
		this.name = name;
	}
}

public class Helper {
	Node head;

	public Node makeNode(String name) {
		Node n = new Node(name);
		n.next = null;
		n.nameCode = nameCode(name);
		return n;
	}

	public int nameCode(String name) {
		int nameCode = (((name.charAt(0) - 'a') * 26 * 26) + ((name.charAt(1) - 'a') * 26)
				+ ((name.charAt(2) - 'a') * 1));
		return nameCode;
	}

	public void insertAfter(Node insertAfter, Node key) {
		Node new_node = key;
		if (head == null) {
			return;
		}
		Node current = head;

		while (current != insertAfter && current != null) {
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

	public void insertBefore(Node insertBefore, Node key) {
		Node new_node = key;
		if (head == null) {
			return;
		}
		if (insertBefore == head) {
			new_node.next = head;
			head = new_node;
			return;
		}
		Node current = head;
		Node previous = null;
		while (current != null && current != insertBefore) {
			previous = current;
			current = current.next;
		}
		new_node.next = current;
		previous.next = new_node;
	}

	public void showList() {
		Node temp = head;
		String result = "";
		if (temp == null) {
			System.out.println("Nothing is present in the list");
		}
		while (temp != null) {

			result += temp.name + "  ";
			temp = temp.next;
		}
		System.out.println(result);

	}

	public void delete(String key) {
		Node current = head;
		if (head == null) {
			System.out.println("Nothing is present in the list");
			return;
		}

		if (head.name.trim().equalsIgnoreCase(key.trim())) {
			head = head.next;
			return;

		}
		Node previous = null;
		while (!current.name.equals(key)) {
			previous = current;
			current = current.next;
		}
		previous.next = current.next;

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

	public void sort(String word) {
		Node new_node = makeNode(word);
		if (head == null) {
			head = new_node;
			return;
		}

		if (new_node.nameCode < head.nameCode) {
			new_node.next = head;
			head = new_node;
		} else {
			Node current = head;
			while (current != null && new_node.nameCode > current.nameCode) {

				current = current.next;

			}
			insertBefore(current, new_node);

		}

	}

}
