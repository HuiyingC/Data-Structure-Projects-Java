package cs463lab7;

/******************************************************************************
* DoublyLinkedListDummy.java
* 
* A DIntNode provides a node for a doubly linked list with 
* integer data in each node.
*
* Lists of nodes can be made of any length, limited only by the amount of
* free memory in the heap. But beyond Integer.MAX_VALUE 
* 
* @author Huiying Chen 
*
*
******************************************************************************/



public class DoublyLinkedListDummy {
	private DIntNode head;
	private DIntNode tail;
	
	/**
	* No argument constructor which creates the dummy head and tail and link them together
	*/
	public DoublyLinkedListDummy() {
		DIntNode head = new DIntNode();
		DIntNode tail = new DIntNode();
		head.setNext(tail);
		tail.setPrev(head);
	}

	/**
	* 
	*/
	public DIntNode getHead() {
		return this.head;
	}
	
	public DIntNode getTail() {
		return this.tail;
	}
	
	public void setHead(DIntNode node) {
		this.head = node;
	}
	
	public void setTail(DIntNode node) {
		this.tail = node;
	}
	
	
	/**
	 * A method to add an element from the end of the list
	 * time complexity: O(1)
	 * @param element - the data to be added to the doubly linked list
	 */
	public void addEnd(int element) {
		//if the list is empty
		//create a new node, add and set links
		if(this.head.getNext() == null) {
			DIntNode newNode = new DIntNode(element, this.head, this.tail);
			this.head.setNext(newNode);
			this.tail.setPrev(newNode);
			return;
		}
		//if the list is not empty
		//create a new node, add to the end and set links
		DIntNode newNode = new DIntNode(element, this.tail.getPrev(), this.tail);
		this.tail.getPrev().setNext(newNode);
		this.tail.setPrev(newNode);
	}
	
	
	/**
	 * A method to remove the first actual node (i.e., the node that the dummy head points to)
	 * time complexity: O(1)
	 */
	public void removeFromHead() {
		//if the list is empty, do nothing
		if (this.head.getNext() == null) {
			return;
		}
		//if the list has only one actual node, remove and set links
		if (this.head.getNext().getNext() == null) {
			this.head.setNext(this.tail);
			this.tail.setPrev(this.head);
		}
		//if the list has more than one actual nodes, remove and set links
		this.head.getNext().getNext().setPrev(this.head);
		this.head.setNext(this.head.getNext().getNext());	
	}
	
	/**
	 * A method to convert the list to a string(including forward and backward)
	 * @return  a String with two lines where the first line lists all the nodes starting from
the first node, and the second line lists all the nodes starting from the last node
	 */
	public String toString() {
		DIntNode cursor;
		String strFwd = "";
		String strBwd = "";
		//if the list is empty
		if (this.head.getNext() == null) {
			return "Empty list. ";
		}
		//if the list is not empty
		//toString forward
		System.out.print("(Forward)   ");
		for (cursor = this.head.getNext();cursor!=null;cursor=cursor.getNext()) {
			//if cursor point to the last actual node
			if (cursor.getNext() == null) {
				strFwd = strFwd + cursor.getData();
			}
			//if cursor point to the middle
			else {
				strFwd = strFwd + cursor.getData() + "<->";
			}
		}
		
		//toString backward
		System.out.print("(backward)  ");
		for (cursor = this.tail.getPrev();cursor!=null;cursor=cursor.getPrev()) {
			//if cursor point to the first actual node
			if (cursor.getPrev() == null) {
				strBwd = strBwd + cursor.getData();
			}
			//if cursor point to the middle
			else {
				strBwd = strBwd + cursor.getData() + "<->";
			}
		}
		return strFwd + "\n" + strBwd;
	}
	
	
	/**
	 * A method to compute the number of times that the given value e occurs in nodes in this
linked list
	 * time complexity: O(n)
	 * @param e - the number to be computed
	 * @return the occurrence of the given number in the list
	 */
	public int countOccurrence(int e) {
		int count = 0;
		DIntNode cursor;
		//if the list is empty
		if (this.head.getNext() == null) {
			return 0;
		}
		//if the list is not empty, traverse to compare 
		for (cursor = this.head.getNext();cursor!=null;cursor=cursor.getNext()) {
			if (cursor.getData() == e) {
				count++;
			}
		}
		return count;
	}
	
	
	/**
	 * A method to remove all the nodes that contain element e from the list
	 * time complexity: O(n)
	 * @param e - the element to be removed
	 * @return true if removed, false if the list is empty or the element is not found
	 */
	public boolean removeAll(int e) {
		DIntNode cursor;
		boolean found = false; //variable for checking the element exists in the list 
		//if list is empty, directly return false
		if (this.head.getNext() == null) {
			return false;
		}
		//if the list is not empty, traverse to remove target
		for (cursor=this.head.getNext();cursor!=null;cursor=cursor.getNext()) {
			//found and remove
			if (cursor.getData() == e) {
				//if the node is the only node in the list
				if(cursor.getNext()==null&&cursor.getPrev()==null) {
					this.head.setNext(tail);
					this.tail.setPrev(head);
				}
				//if the node is not the only node and is the node after head
				else if (cursor.getNext()!=null&&cursor.getPrev() == this.head) {
					cursor.getNext().setPrev(head);
					this.head.setNext(cursor.getNext());
				}
				//if the node is not the only node and is the before tail
				else if (cursor.getPrev()!=null&&cursor.getNext() == this.tail) {
					cursor.getPrev().setNext(tail);
					this.tail.setPrev(cursor.getPrev());
				}
				//if the node is in the middle
				else if (cursor.getPrev()!=null&&cursor.getNext()!=null) {
					cursor.getPrev().setNext(cursor.getNext());
					cursor.getNext().setPrev(cursor.getPrev());
				}
				//if founded, set found to true
				found = true;
			}
		}
		//if founded and removed, return true 
		return found;
	}
	
	
	
	/**
	 * A method to extract a sublist of this list
	 * time complexity: O(n)
	 * @param beginIdx - target sublist starting index
	 * @param endIdx - target sublist ending index
	 * @return a new doubly linked list which copies the portion of this list between the specified beginIdx,
inclusive, and endIdx, exclusive
	 */
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		//get the size of the source list
		DIntNode cursor;
		int size = 0; //for storing source list size
		int index = 0; //for go through source list index
		//if source list is empty
		if (this.head.getNext() == null) {
			return null;
		}
		//if source list is not empty
		for (cursor = this.head.getNext();cursor!=null;cursor=cursor.getNext()) {
			size++;
		}
		//ensure precondition:
		//(1) beginIdx is no less than 0
		//(2) beginIdx is no greater than the size of this list
		//(3) beginIdx is no greater than endInx
		if (beginIdx < 0 || beginIdx > size-1 || beginIdx > endIdx) {
			return null;
		}
		//copy the portion of the list
		//traverse the list and copy while in the target index range
		for (int i=0;i<size;i++) {
			if ()
		}
		
		 
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
