package cs463lab5;
/**
 * An IntNode provides a node for a linked list with integer data in each node.
 * @author Huiying Chen
 * 
 */
public class IntNode {
	private int data;
	private IntNode link;
		
	/**
	 * The no-argument constructor which sets the node value to be 0 and the link to be null
reference.
	 */
	public IntNode() {
		data = 0;
		link = null;
	}
	
	/**
	 * A constructor with the given node value and the link.
	 * @param _data - the initial data of this new node
	 * @param _node - a reference to the node after this new node
	 */
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;	
	}
	
	/**
	 * @return the node value
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * @return the node link
	 */
	public IntNode getLink() {
		return link;
	}
	
	/**
	 * set the new node value
	 * @param newData – the new data to place in this node
	 */
	public void setData(int newData) {
		data = newData;
	}
	
	/**
	 * set the new node link
	 * @param newLink - a reference to the node that should appear after this node in
the linked list (or the null reference if there should be no node after
this node)
	 */
	public void setLink(IntNode newLink) {
		link = newLink;
	}
	
	/**
	 * @return a String for the linked list starting from the node that activates this
method
	 */
	public String toString() {
		String str = String.valueOf(this.data);
		IntNode cursor;
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
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}
	
	/**
	 * This method removes the node that this node’s link points to.
	 * @throws NullPointerException - Indicates that this was the tail node of the list, so there is nothing after it to remove.
	 */
	public void removeNodeAfterThis() {
		if(link != null) {
			link = link.link;
		}
		System.out.println("Cannot remove the tail node");
	}
	
	/**
	 * A method to get the number of nodes in the list starting from a given node head.
	 * @param head – the head reference for a linked list (which may be an empty list with a null head)
	 * @return the number of nodes in the list starting from a given node head
	 */
	public static int listLength(IntNode head) {
		IntNode cursor;
		int answer;
		answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		return answer;	
	}
	
	/**
	 * A method to search whether a linked list starting with head contains a given value data.
	 * @param head – the head reference for a linked list (which may be an empty list
with a null head)
	 * @param data - the target data 
	 * @return true if data exists in the linked list starting with head; It returns false
	 * @throws NullPointerException - Indicates that the head is null.
	 */
	public static boolean search(IntNode head, int data) {
		IntNode cursor;
		if (head != null) {
			for (cursor = head; cursor != null; cursor = cursor.link) {
				if (data == cursor.data) {
					System.out.println("Found data in the list");
					return true;
				}
			}
			System.out.println("List does not contain this data");
			return false;
		}
		System.out.println("The list is null");
		return false;
	}
	
	/**
	 * A method to calculate the number of even elements in the linked list staring from the
given head.
	 * @param head – the head reference for a linked list
	 * @return the number of even elements in the linked list staring from the
given head. When head is null, return 0.
	 */
	public static int listEvenNumber(IntNode head) {
		IntNode cursor;
		int count = 0;
		if (head != null) {
			for (cursor = head; cursor != null; cursor = cursor.link) {
				if (cursor.data % 2 == 0) {
					count++;
				}
			}
			return count;
		}
		return 0;
	}
	
	/**
	 * A method to add the given newdata to the end of the linked list that starts from the
current node.
	 * @param newdata - the data to be added
	 */
	public void addToEnd(int newdata) {
		IntNode cursor;
		for (cursor = this; cursor != null; cursor = cursor.link) {
			if (cursor.link == null) {
				cursor.addNodeAfterThis(newdata);
			}
		}
	}
	
	/**
	 * A method to calculate the summation of elements in the last num nodes in a
given linked list.
	 * @param head  – the head reference for a linked list (which may be an empty list with a null head)
	 * @param num - the number of nodes in the list
	 * @return the summation of elements in the last num nodes in a
given linked list. If the list is empty, prints error message and return 0;
	 * @throws IllegalArgumentException - Indicates that num is not positive
	 */
	public static int sumLast(IntNode head, int num) {
		IntNode cursor = head;
		int sum = 0;
		int count;
		if (head != null) {
			if (num > 0) {
				for (count = 0;count < num; count++) {
					while (cursor.link != null) {
						sum = sum + cursor.getData();
						cursor = cursor.link;
					}
				}
			}
			System.out.print("The number should be positive");
		}
		System.out.print("The list is empty");
		return 0;
	}
	
	/**
	 * Copy part of a given linked list.
	 * @param head  – the head reference for a linked list
	 * @return If head is null, this method returns null.
If head is not null, this method should copy all the odd elements in the linked list starting from
the given head, create a new linked list with all these odd numbers, and return the linked list
with the new head.
	 * @throws OutOfMemoryError - Indicates that there is insufficient memory for a new IntNode.
	 */
	public static IntNode copyOdd (IntNode head) {
		IntNode copyHead;
		IntNode copyTail;
		if (head == null) {
			return null;
		}
		// Make the first node for the newly created list.
		copyHead = new IntNode(head.data, null);
		copyTail = copyHead;
		// Make the rest of the nodes for the newly created list.
		while (head.link != null) {
			head = head.link;
			if (head.getData() % 2 != 0) {
				copyTail.addNodeAfterThis(head.data);
				copyTail = copyTail.link;
			}
		}
		// Return the head reference for the new list.
		return copyHead;
	}
	
	
	/**
	 * A method to remove ALL the nodes that have the data value e from the linked list
starting from the given head.
	 * @param head  – the head reference for a linked list
	 * @param e - the data value e from the linked list to be removed
	 * @return the linked list with the new head. If head is null, this method returns null.
	 */
	public static IntNode removeAll(IntNode head, int e) {
		if (head == null) {
			return null;
		}
//???special process, if the starting nodes	contain	x		
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
	 * A method to reverse a linked list.
	 * @param head  – the head reference for a linked list
	 * @return the linked list with the new head with the reversed linked list.
	 */
	public static IntNode reverse (IntNode head) {
		
	}
	
	
	
	
	
}
