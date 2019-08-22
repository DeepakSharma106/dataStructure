package linkedList;


class Node {
	
	int data;
	Node next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	public String toString() {
		return ""+this.data;
	}
}


class LinkedList {
	Node head;
	
	public LinkedList() {
	  head = null;	
	}
	
	public Node getHead() {
		return  head;
	}
	
	
	public int length() {
		Node current = head;
		int counter=0;
		while(current != null) {
			counter++;
			current = current.getNext();
		}
		return counter;
	}
	
	public void insertAtBeginning(Node nodeTobeInserted) {
		if(head == null) {
			head = nodeTobeInserted;
			return;
		}
		nodeTobeInserted.setNext(head);
		head = nodeTobeInserted;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node current = head;
		
		while(current != null) {
			sb.append(current.getData());
			sb.append("-->");
			current = current.getNext();
		}
		sb.delete(sb.length()-3, sb.length());
		return sb.toString();
	}
}

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Node n1 = new Node();
		n1.setData(11);
		
		Node n2 = new Node();
		n2.setData(12);
		
		list.insertAtBeginning(n1);
		list.insertAtBeginning(n2);
		System.out.println(list);
		
		

	}

}
