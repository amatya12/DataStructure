class Node {
	Object data;
	Node next;
	
	Node(Object data) {
		this.data = data;
		next = null;
	}
}

public class LinkedListForRadix {
	Node head;
		
	
	public Node makeNode(Object data) {
		Node node = new Node(data);
		node.data=data;
		node.next=null;
		return node;
	}
	//it will add the node to the end of the linkedlist
	public void add(Object data) {
		Node node = makeNode(data);
		if(head==null) {
			head = node;
			
		}
		else {
			node.next=null;
			Node current = head;
			while(current.next!=null) {
				current= current.next;
			}
			current.next = node;
			
		}
		
	}
	//it will remove node at the front;
	public Object Remove() {
		if(head==null) {
			return null;
		}
		else {
		Node current = head;
		head = head.next;
		return current.data;
		}
	}
	
	
	public void show() {
		Node current= head;
		while(current!=null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	
	public Object IsThereonthebin() {
		if(head!=null) {
			return head;
		}
		else {
			return null;
		}
	}
	public static void main(String[] args) {
		LinkedListForRadix ll = new LinkedListForRadix();
		
		ll.add("23");
		ll.add("1");
		ll.show();
		System.out.println(ll.Remove());
		
		
	}
	

}
