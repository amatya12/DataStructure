
public class reversingLinkedList extends BabyLinkedList {
	
	
	
	public void reversing(Node node) {
		
	}
	
	public static void main(String[] args) {
		reversingLinkedList rll = new reversingLinkedList();
		BabyLinkedList bll = new BabyLinkedList();
		rll.head = bll.new Node(1); 
	        rll.head.next = bll.new Node(2); 
	        rll.head.next.next =bll.new Node(3); 
	        rll.head.next.next.next = bll.new Node(4); 
	        rll.head.next.next.next.next = bll.new Node(5); 
	        rll.head.next.next.next.next.next =bll.new Node(6); 
	       rll.head.next.next.next.next.next.next =bll.new Node(7); 
	       rll.head.next.next.next.next.next.next.next =bll.new Node(8); 
	       
	}
	
	

}
