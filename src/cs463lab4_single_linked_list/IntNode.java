package cs463lab4_single_linked_list;


/**
 * An IntNode provides a node for a linked list with integer data in each node.
 * @author Huiying Chen
 * 
 */
public class IntNode {
	private int data;
	private IntNode link;
		
	/**
	 * The no-argument constructor which sets the node value to be 0 and the point reference to be null
reference.
	 */
	public IntNode() {
		data = 0;
		link = null;
	}
	
	/**
	 * A constructor with the given node value and the point reference.
	 * @param _data - the initial data of this new node
	 * @param _node - a reference to the node after this new node
	 */
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;	
	}
	
	/**
	 * get the node value
	 * @return the node value
	 * @throws NullPointerException - Indicates that the node is null.
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * get the node point reference
	 * @return the node point reference
	 * @throws NullPointerException - Indicates that the node is null.
	 */
	public IntNode getLink() {
		return link;
	}
	
	/**
	 * set the new node value
	 * @param newData � the new data to place in this node
	 * @throws NullPointerException - Indicates that the node is null.
	 */
	public void setData(int newData) {
		data = newData;
	}
	
	/**
	 * set the new node point reference
	 * @param newLink - a reference to the node that should appear after this node in
the linked list (or the null reference if there should be no node after
this node)
	 * @throws NullPointerException - Indicates that the node is null.
	 */
	public void setLink(IntNode newLink) {
		link = newLink;
	}
	
	/**
	 * A method to get a String for the linked list starting from the node that activates this
method
	 * @return a String for the linked list starting from the node that activates this
	 * @throws NullPointerException - Indicates that the node is null.
method
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
	 * This method creates a new node with value newdata and let the current node�s link point
to this new node.
	 * @param newdata - data of the new node
	 * @throws OutOfMemoryError - Indicates that there is insufficient memory for a new IntNode.
	 * @throws NullPointerException - Indicates that the node is null.
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}
	
	/**
	 * This method removes the node that this node�s link points to.
	 * @throws NullPointerException - Indicates that this was the tail node of the list, so there is nothing after it to remove.
	 */
	public void removeNodeAfterThis() {
		//precondition that the node is not the tail node
		if(link != null) {
			link = link.link;
		}
		else {
			System.out.println("Cannot remove the tail node");
		}
	}
	
	/**
	 * A method to get the number of nodes in the list starting from a given node head.
	 * @param head � the head reference for a linked list (which may be an empty list with a null head)
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
	 * @param head � the head reference for a linked list (which may be an empty list
with a null head)
	 * @param data - the target data 
	 * @return true if data exists in the linked list starting with head; It returns false
	 * @throws NullPointerException - Indicates that the head is null.
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
	
	
	
	
}
