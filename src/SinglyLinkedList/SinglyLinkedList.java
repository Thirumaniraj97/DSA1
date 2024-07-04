package SinglyLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public void displayReversedhead(ListNode head) {
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

	public void 	insertFirst(int value) {
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

	public ListNode deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

	public ListNode deleteLast() {
		//3 --> 4 --> 7 --> 8 --> 9 --> null
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			ListNode temp = head;
			head = null;
			return temp;
		}
		ListNode current = head;
		ListNode previous = null;
		//to remove link to the previous node we need to set previous to be at second last node ans current at last node
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
	}

	//delete node at any given position
	public void delete(int position) {
		if (position == 1) {
			head = head.next;  //first node is Garbage Collected
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position - 1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;  //now current node is Garbage Collected
		}
	}

	public boolean find(int searchKey) {
		if (head == null) {
			return false;
		}
		ListNode current = head;
		while (current != null) {
			if (current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public ListNode reverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous; //previous becomes head
	}

	public ListNode getMiddleNode() {
		if (head == null) {
			return null;
		}
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	public ListNode getNthNodeFromEnd(int n) {
		if (head == null) {
			return null;
		}
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid Value n = " + n);
		}

		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;
		while (count < n) {
			if (refPtr == null) {
				throw new IllegalArgumentException(n + "is greater than the number of nodes in List");
			}
			refPtr = refPtr.next;
			count++;
		}
		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;
		if (head == null) {
			return null;
		}
		while (count < n) {
			refPtr = refPtr.next;
			count++;
		}

		while (refPtr.next != null) {
			mainPtr = mainPtr.next;
			refPtr = refPtr.next;
		}
		return mainPtr;
	}

	public void removeDuplicates() {
		if (head == null) {
			return;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}

	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			return newNode;
		}
		ListNode current = head;
		ListNode temp = null;
		while (current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		return head;
	}

	public void deleteNode(int key) {
		ListNode current = head;
		ListNode temp = null;
		//when head is the key
		if (current != null && current.data == key) {
			head = current.next;
			return;
		}
		while (current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		if (current == null) {  //key not found
			return;
		}
		temp.next = current.next;
	}

	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (fastPtr == slowPtr) {
				return true;
			}
		}
		return false;
	}

	public void createLoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);

		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}

	public ListNode startNodeInALoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		return null;
	}

	private ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while (temp != slowPtr) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp; //starting node of the loop
	}

	public void removeLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (fastPtr == slowPtr) {
				removeLoop(slowPtr);
				return;
			}
		}
	}
	public void removeLoop(ListNode slowPtr){
		ListNode temp = head;
		while (temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
	}

	public static ListNode merge(ListNode a, ListNode b){
		// a --> 1 --> 3 --> 5 --> null
		// b --> 2 --> 4 --> 6 --> null
		// result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(a != null && b!= null){
			if(a.data < b.data){
				tail.next = a;
				a = a.next;
			}else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}

		if(a == null){
			tail.next = b;
		}else {
			tail.next = a;
		}
		return dummy.next;
	}

	//Leetcode
	public static ListNode mergeKLists(ListNode[] lists) {
		List<Integer> x = new ArrayList<>();
		for(int i=0; i < lists.length; i++){
			ListNode temp = lists[i];
			while(temp != null){
				x.add(temp.data);
				temp =temp.next;
			}
		}
		Collections.sort(x);
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for(int i : x){
			ListNode node = new ListNode(i);
			tail.next = node;
			tail = tail.next;
		}
		return dummy.next;
	}

	//Leetcode
	public static ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;

		while(a != null || b != null){
			int x = (a != null) ? a.data : 0;
			int y = (b != null) ? b.data : 0;
			int sum = carry + x + y;
			ListNode node = new ListNode(sum%10);
			carry = sum/10;
			tail.next = node;
			tail = tail.next;
			if(a != null)
				a = a.next;
			if(b != null)
				b = b.next;
		}
		if(carry > 0){
			ListNode newNode = new ListNode(carry);
			tail.next = newNode;
		}
		return dummy.next;
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
		singlyLinkedList.insert(13, 3);
		singlyLinkedList.display();

		System.out.println("Length: " + singlyLinkedList.length());
		System.out.println(singlyLinkedList.deleteFirst().data);
		System.out.println(singlyLinkedList.deleteLast().data);
		singlyLinkedList.display();

		System.out.println("********** sl2 ******************");
		SinglyLinkedList sl2 = new SinglyLinkedList();
		sl2.head = new ListNode(33);
		ListNode sl2second = new ListNode(44);
//		ListNode sl2third = new ListNode(55);
		sl2.head.next = sl2second;
//		sl2second.next = sl2third;
		sl2.display();

		ListNode middleNode = sl2.getMiddleNode();
		System.out.println("Middle node is : " + middleNode.data);

		ListNode nthNodeFromEnd = sl2.getNthNodeFromEnd(2);
		System.out.println("Nth node from end is : " + nthNodeFromEnd.data);

		ListNode removeNthFromEnd = sl2.removeNthFromEnd(sl2.head, 1);
		System.out.println("Nth node from end is : " + removeNthFromEnd.data);

		ListNode reversedList = sl2.reverse(sl2.head);  //this cuts off head. So only we are returning previous
		sl2.displayReversedhead(reversedList);

		System.out.println(sl2.deleteLast().data);
		sl2.display();

		System.out.println("****************************");
		singlyLinkedList.delete(1);
		singlyLinkedList.delete(3);
		singlyLinkedList.display();

		if (singlyLinkedList.find(33))
			System.out.println("Search Key Found");
		else
			System.out.println("Search Key Not Found");

		System.out.println("******* sl3 *********************");
		SinglyLinkedList sl3 = new SinglyLinkedList();
		sl3.insertFirst(15);
		sl3.insertFirst(3);
		sl3.insertFirst(3);
		sl3.insertFirst(2);
		sl3.insertFirst(1);
		sl3.insertFirst(1);
		sl3.display();
		sl3.removeDuplicates();
		sl3.display();
		sl3.insertInSortedList(11);
		sl3.display();
		sl3.deleteNode(3);
		sl3.display();

		System.out.println("******* sl4 *********************");
		SinglyLinkedList sl4 = new SinglyLinkedList();
		sl4.createLoopInLinkedList();
		System.out.println("Contains Loop: " + sl4.containsLoop());
		System.out.println("Starting Node data is : "+ sl4.startNodeInALoop().data);
		//now remove loop
		sl4.removeLoop();
		sl4.display();
		System.out.println("******* sl5 *********************");

		SinglyLinkedList sl5 = new SinglyLinkedList();
		sl5.insertLast(1);
		sl5.insertLast(4);
		sl5.insertLast(8);

		SinglyLinkedList sl6 = new SinglyLinkedList();
		sl6.insertLast(3);
		sl6.insertLast(5);
		sl6.insertLast(8);
		sl6.insertLast(9);
		sl6.insertLast(14);
		sl6.insertLast(18);
		sl5.display();
		sl6.display();
		SinglyLinkedList result = new SinglyLinkedList();
		result.head = merge(sl5.head, sl6.head);
		result.display();

		List<ListNode> list = new ArrayList<>();
		list.add(sl5.head);
		list.add(sl6.head);
		var ans = mergeKLists(list.toArray(new ListNode[list.size()]));
		while(ans != null){
			System.out.print(ans.data + " --> ");
			ans = ans.next;
		}

	}
}

