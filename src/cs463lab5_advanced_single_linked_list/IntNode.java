package cs463lab5_advanced_single_linked_list;

/**
 * An IntNode provides a node for a linked list with integer data in each node.
 * @author Huiying Chen
 * @since 9/26/2019
 */
public class IntNode {
	private int data;
	private IntNode link;
		
	/**
	 * The no-argument constructor which sets the node value to be 0 and the point reference to be null
reference.
	 */
	public IntNode() {
		this.data = 0;
		this.link = null;
	}
	
	/**
	 * A constructor with the given node value and the point reference.
	 * @param _data - the initial data of this new node
	 * @param _node - a reference to the node after this new node
	 */
	public IntNode(int _data, IntNode _node) {
		this.data = _data;
		this.link = _node;	
	}
	
	/**
	 * get the node value
	 * @return the node value
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public int getData() {
		return this.data;
	}
	
	/**
	 * get the node point reference
	 * @return the node point reference
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public IntNode getLink() {
		return this.link;
	}
	
	/**
	 * set the new node value
	 * @param newData – the new data to place in this node
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void setData(int newData) {
		this.data = newData;
	}
	
	/**
	 * set the new node point reference
	 * @param newLink - a reference to the node that should appear after this node in the linked list (or the null reference if there should be no node after this node)
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void setLink(IntNode newLink) {
		this.link = newLink;
	}
	
	/**
	 * A method to get a String for the linked list starting from the node that activates this method
	 * @return a String for the linked list starting from the node that activates this method
	 * @throws IllegalStateException - Indicates that the node is null.

	 */
	public String toString() {	
		String str = String.valueOf(this.data);
		IntNode cursor;
		//traverse linked list
		for (cursor = this.link;cursor != null;cursor = cursor.link) {
			str = str + "->" + String.valueOf(cursor.data);
		}
		return str;
	}
	
	/**
	 * This method creates a new node with value newdata and let the current node’s link point
to this new node.
	 * @param newdata - data of the new node
	 * @throws OutOfMemoryError - Indicates that there is insufficient memory for a new IntNode.
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void addNodeAfterThis(int newdata) {
		this.link = new IntNode(newdata, this.link);
	}
	
	/**
	 * This method removes the node that this node’s link points to.
	 * @throws NullPointerException - Indicates that this was the tail node of the list, so there is nothing after it to remove.
	 */
	public void removeNodeAfterThis() {
		//precondition that the node is not the tail node
		if(this.link != null) {
			this.link = link.link;
		}
		else {
			System.out.println("Cannot remove the tail node");
		}
	}
	
	/**
	 * A method to get the number of nodes in the list starting from a given node head.
	 * @param head – the head reference for a linked list (which may be an empty list with a null head)
	 * @return the number of nodes in the list starting from a given node head
	 * @throws IllegalArgumentException - Indicates that the head is null.
	 */
	public static int listLength(IntNode head) {
		IntNode cursor;
		int answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		return answer;	
	}
	
	/**
	 * A method to search whether a linked list starting with head contains a given value data.
	 * @param head – the head reference for a linked list (which may be an empty list with a null head)
	 * @param data - the target data 
	 * @return true if data exists in the linked list starting with head; It returns false
	 * @throws IllegalArgumentException - Indicates that the head is null.
	 */
	public static boolean search(IntNode head, int data) {
		IntNode cursor;
		//precondition that the head is not null
		if(head != null) { 
			//traverse linked list to check target data
			for (cursor = head; cursor != null; cursor = cursor.link) {
				if (data == cursor.data) {
					System.out.println("Found data in the list");
					return true;
				}
			}		
			System.out.println("List does not contain this data");
			return false;
		}	
		else {
			System.out.println("The head cannot be null");
		}
		return false;
	}
	
	
//______________________________________________lab5:	
	

	/**
	 * A method to calculate the number of even elements in the linked list staring from the given head.
	 * @param head – the head reference for a linked list
	 * @return the number of even elements in the linked list staring from the given head. When head is null, return 0.
	 * @throws IllegalArgumentException - Indicates that the head is null.
	 */
	public static int listEvenNumber(IntNode head) {
		IntNode cursor;
		int count = 0;
		//traverse to check whether each element is even
		if (head != null) {
			for (cursor = head; cursor != null; cursor = cursor.link) {
				if (cursor.data % 2 == 0) {
					//count the number of even elements
					count++;
				}
			}
			return count;
		}
		//when head is null, return 0
		return 0;
	}
	
	/**
	 * A method to add the given newdata to the end of the linked list that starts from the current node.
	 * @param newdata - the data to be added
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void addToEnd(int newdata) {
		//point a cursor to current node
		IntNode cursor = this;
		//traverse to the tail node
		while (cursor.link != null) {
			cursor = cursor.link;
		}
		cursor.addNodeAfterThis(newdata);
	}
	
	/**
	 * A method to calculate the summation of elements in the last num nodes in a given linked list. The idea is to reverse the linked list as a new linked list, then traverse to sum
	 * @param head  – the head reference for a linked list (which may be an empty list with a null head)
	 * @param num - the number of last nodes to be counted in the list
	 * @return the summation of elements in the last num nodes in a given linked list. If the list is empty or the given number is non-positive, prints error message and return 0;
	 * @throws IllegalArgumentException - Indicates that num is not positive
	 */
	public static int sumLast(IntNode head, int num) {
		IntNode cursor = head;
		int sum = 0;
		int count;
		//ensure the given head is not null
		if (head != null) {
			//ensure the given number is positive
			if (num > 0) {
				//if the given number is greater than the list length, sum all the elements
				if (num > IntNode.listLength(head)) {
					num = IntNode.listLength(head);
				}
				//get reversed list to sum last nodes 
				cursor = IntNode.reverse(head);
				for (count = 0;count < num; count++) {
					sum = sum + cursor.getData();
					cursor = cursor.link;
					}
				return sum;
			}
			//if given number is non-positive, print error message and return 0
			else {
				System.out.println("The number should be positive");
				return 0;
			}
		}
		//if the head is null, print error message and return 0
		else {
			System.out.println("The list is empty");
			return 0;
		}
	}
	
	
	/**
	 * Copy all the odd elements of a given linked list.
	 * @param head  – the head reference for a linked list
	 * @return If head is null, this method returns null. If head is not null, this method should copy all the odd elements in the linked list starting from the given head, create a new linked list with all these odd numbers, and return the linked list with the new head.
	 * @throws OutOfMemoryError - Indicates that there is insufficient memory for a new IntNode.
	 */
	public static IntNode copyOdd (IntNode head) {
		IntNode copyHead = null;
		IntNode copyTail = null;
		//if head is null, return null
		if (head == null) {
			return null;
		}
		//now ensure head is not null
		//Find the first odd element as new head
		while (head.link != null && head.getData() % 2 == 0) {
			head = head.link;
		}
		//if the linked list don't contain any odd elements, directly return null
		if (head.getData() % 2 == 0) {
			return null;
		}
		//now ensure the linked list contain at least one odd element, make the first node for the newly created list
		copyHead = new IntNode(head.data, null);
		copyTail = copyHead;
		// Make the rest of the nodes for the newly created list
		while (head.link != null) {	
			head = head.link;
			//traverse to add rest odd elements to the new created linked list
			if (head.getData() % 2 != 0) {
				copyTail.addNodeAfterThis(head.data);
				copyTail = copyTail.link;
			}
		}
		// Return the head reference for the new linked list
		return copyHead;
	}
	
	
	/**
	 * A method to remove ALL the nodes that have the data value e from the linked list starting from the given head.
	 * @param head  – the head reference for a linked list
	 * @param e - the data value e from the linked list to be removed
	 * @return the linked list with the new head. If head is null, this method returns null.
	 */
	public static IntNode removeAll(IntNode head, int e) {
		//if head is null, return null
		if (head == null) {
			return null;
		}
		//if the starting nodes contain e	
		while (head.getData() == e) { 
			head = head.getLink();
		}
		//remove rest of nodes contain e
		//now head.getData for sure is not e
		IntNode preCursor = head;
		IntNode cursor = preCursor.getLink();
		while(cursor != null) {
			if (cursor.getData() == e) {//remove
				preCursor.setLink(cursor.getLink());
				cursor = preCursor.getLink();
			}else {//moves cursor, not remove
				preCursor =	cursor;
				cursor	= cursor.getLink();
			}
		}
		return head;
	}
	
	/**
	 * A method to reverse a linked list from the starting node. The idea is add node to the newly created list after head along with traversing 
	 * @param head  – the head reference for a linked list
	 * @return the linked list with the new head with the reversed linked list
	 */
	public static IntNode reverse(IntNode head) {
		IntNode reverseHead;
		//if the starting node is null, return null
		if (head == null) {
			return null;
		}
		//if the starting node is not null, create a new linked list with reference head
		reverseHead = new IntNode();
		//add the rest of the nodes for the newly created reversed linked list
		while (head != null) {	
			reverseHead.addNodeAfterThis(head.data);
			head = head.link;
		}
		//return new head with the reversed linked list
		return reverseHead.link;	
	}
	
	
	/**
	 * A method to test whether a linked list starting from the given head is cyclic or acyclic. The idea is to store head of the linked list and traverse it. If we reach NULL, linked list is acyclic. If reach head again, linked list is cyclic.
	 * @param head  – the head reference for a linked list
	 * @return true if it is cyclic. return false if the list is acyclic or empty
	 */
	public static boolean hasCycle(IntNode head) {
		IntNode cursor = head;
		//An empty linked list is acyclic
		if (head == null) {
			return false;
		}
		//[FIXME]if only contain one node?
		//traverse to check cursor will reach null or head again
		for (cursor = head; cursor != null; cursor = cursor.link) {
			//if reach head, cyclic
			if (cursor.link == head) {
				return true;
			}
		}
		//if reach null, acyclic
		return false;
	}
	
	
	
}



//1)exception types??
//2)one element linked list could be cyclic??



