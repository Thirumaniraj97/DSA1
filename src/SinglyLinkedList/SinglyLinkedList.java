package SinglyLinkedList;

public class SinglyLinkedList {
	private ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void display() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public int length() {
		if (head == null)
			return 0;
		int count = 0;
		ListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}

	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	//insert at any position
	public void insert(int value, int position) {
		//1 --> 4 --> 5
		//1 --> 6 --> 4 --> 5    insert(6,2)
		ListNode newNode = new ListNode(value);
		if (position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next; //temp node to save remaing nodes after previous
			previous.next = newNode;
			newNode.next = current;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);

		//connecting them to form a chain
		singlyLinkedList.head.next = second;  //10 --> 1
		second.next = third;  //10 --> 1 --> 8
		third.next = fourth;  //10 --> 1 --> 8 --> 11 --> null
		singlyLinkedList.insertFirst(12);
		singlyLinkedList.insertLast(35);
		singlyLinkedList.insert(13,3);
		singlyLinkedList.display();
		System.out.println("Length: " + singlyLinkedList.length());


	}
}

