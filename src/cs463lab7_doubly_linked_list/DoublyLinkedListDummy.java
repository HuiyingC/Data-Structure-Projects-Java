package cs463lab7_doubly_linked_list;

/******************************************************************************
* DoublyLinkedListDummy.java
* 
* A Doubly Linked List collection with Dummy Head and Tail
* Main function includes all methods and special cases testing
* 
* @author Huiying Chen 
* @since 9 OCT 2019
*
******************************************************************************/


public class DoublyLinkedListDummy {
	private DIntNode head = null;
	private DIntNode tail = null;
	
	/**
	* No argument constructor which creates the dummy head and tail and link them together
	*/
	public DoublyLinkedListDummy() {
	    this.head = new DIntNode();
		this.tail = new DIntNode();
		this.head.setNext(tail);
		this.tail.setPrev(head);
	}


	/**
	 * get the Doubly Linked List Dummy head 
	 * @return this Doubly Linked List Dummy head 
	 */
	public DIntNode getHead() {
		return this.head;
	}
	
	/**
	 * get the Doubly Linked List Dummy tail
	 * @return this Doubly Linked List Dummy tail 
	 */
	public DIntNode getTail() {
		return this.tail;
	}
	
	
	/**
	 * get the number of actual nodes in this Doubly Linked List 
	 * time complexity: O(n), n is the number of actual nodes in the doubly linked list
	 * @return the number of actual nodes in this Doubly Linked List. If list is empty, return 0
	 */
	public int getSize() {
		if (this.head.getNext() == this.tail) {
			return 0;
		}
		int size = 0;
		DIntNode cursor = this.head.getNext();
		for (cursor = this.head.getNext();cursor!=this.tail;cursor=cursor.getNext()) {
			size++;
		}
		return size;
	}
	
	/**
	 * set the Doubly Linked List Dummy head with given node
	 * @param node - given node to set as the Doubly Linked List Dummy head
	 */
	public void setHead(DIntNode node) {
		this.head = node;
	}
	

	/**
	 * set the Doubly Linked List Dummy tail with given node
	 * @param node - given node to set as the Doubly Linked List Dummy tail
	 */
	public void setTail(DIntNode node) {
		this.tail = node;
	}
	
	
	/**
	 * A method to add an element from the end of the list
	 * time complexity: O(1)
	 * @param element - the data to be added to the doubly linked list
	 */
	public void addEnd(int element) {
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
		if (this.head.getNext() == this.tail) {
			System.out.println("list is empty. Nothing changed");
			return;
		}
		//if the list has at least one actual node, remove and set links
		this.head.getNext().getNext().setPrev(this.head);
		this.head.setNext(this.head.getNext().getNext());	
		
	}
	
	/**
	 * A method to convert the list to a string(includes forward and backward)
	 * @return  a String with two lines where the first line lists all the nodes starting from the first node, and the second line lists all the nodes starting from the last node
	 */
	public String toString() {   
		DIntNode cursor;
		String strFwd = "";
		String strBwd = "";
		//if the list is empty
		if (this.head.getNext() == this.tail) {
			return "Empty list. ";
		}
		//if the list is not empty
		//toString forward
		for (cursor = this.head.getNext();cursor!=this.tail;cursor=cursor.getNext()) {
			//if cursor point to the last actual node
			if (cursor.getNext() == this.tail) {
				strFwd = strFwd + cursor.getData();
			}
			//if cursor point to the middle
			else {
				strFwd = strFwd + cursor.getData() + "<->";
			}
		}
		
		//toString backward
		for (cursor = this.tail.getPrev();cursor!=this.head;cursor=cursor.getPrev()) {
			//if cursor point to the first actual node
			if (cursor.getPrev() == this.head) {
				strBwd = strBwd + cursor.getData();
			}
			//if cursor point to the middle
			else {
				strBwd = strBwd + cursor.getData() + "<->";
			}
		}
		return "(Forward)   " + strFwd + "\n" + "(Backward)  " + strBwd;
	}
	
	
	/**
	 * A method to compute the number of times that the given value e occurs in nodes in this linked list
	 * time complexity: O(n), n is the number of actual nodes in the doubly linked list
	 * @param e - the number to be computed
	 * @return the number of times that the given value e occurs in nodes in this linked list. If no node in this list contains data e, return 0
	 */
	public int countOccurrence(int e) {
		int count = 0;
		DIntNode cursor;
		//if the list is empty
		if (this.head.getNext() == this.tail) {
			System.out.println("list is empty");
			return 0;
		}
		//if the list is not empty, traverse to compare 
		for (cursor = this.head.getNext();cursor!=this.tail;cursor=cursor.getNext()) {
			if (cursor.getData() == e) {
				count++;
			}
		}
		return count;
	}
	
	
	/**
	 * A method to remove all the nodes that contain element e from the list
	 * time complexity: O(n), n is the number of actual nodes in the doubly linked list
	 * @param e - the element to be removed
	 * @return true if removed, false if the list is empty or the element is not found
	 */
	public boolean removeAll(int e) {  
		DIntNode cursor;
		boolean found = false; //variable for checking the element exists in the list 
		//if list is empty, directly return false
		if (this.head.getNext() == this.tail) {
			System.out.println("list is empty");
			return false;
		}
		//if the list is not empty, traverse to remove target
		for (cursor=this.head.getNext();cursor!=this.tail;cursor=cursor.getNext()) {
			//found and remove, set found to true
			if (cursor.getData() == e) {
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				found = true;
			}
		}
		//if founded and removed, return true, otherwise return false
		return found;
	}
	
	
	
	/**
	 * A method to extract a sublist of this list
	 * time complexity: O(n), n is the number of actual nodes in the doubly linked list
	 * precondition: 1)beginIdx is no less than 0. 2) beginIdx is no greater than the size of this list. 3) beginIdx is no greater than endInx
	 * @param beginIdx - target sublist starting index
	 * @param endIdx - target sublist ending index
	 * @return a new doubly linked list which copies the portion of this list between the specified beginIdx, inclusive, and endIdx, exclusive
	 * @throws IllegalArgumentException - indicates beginIdx is less than 0. or 2) beginIdx is greater than the size of this list. or 3) beginIdx is greater than endInx
	 */
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		DIntNode cursor = this.head.getNext();
		int size = 0; //for storing source list size
		int index = 0; //index for go through source list nodes
		//if source list is empty
		if (cursor == this.tail) {
			System.out.println("The source linked list is empty.");
			return null;
		}
		//if source list is not empty
		size = this.getSize();
		System.out.print("Src list size: " + size);
		System.out.print(", index: 0 - " + (size-1) + "\n");
		//ensure precondition:
		//(1) beginIdx is no less than 0
		//(2) beginIdx is no greater than the size of this list
		//(3) beginIdx is no greater than endInx
		if (beginIdx < 0 || beginIdx > size-1 || beginIdx >= endIdx) {
			throw new IllegalArgumentException("precondition: 1)beginIdx is no less than 0. \n2) beginIdx is no greater than the size of this list. \n3) beginIdx is no greater than endInx");
		}
		//create a new DoublyLinkedListDummy
		DoublyLinkedListDummy copySub = new DoublyLinkedListDummy();
		copySub.setHead(new DIntNode(-1, null, copySub.tail));
		copySub.setTail(new DIntNode(-1, copySub.head, null));
		//move cursor to the beginIdx node
		while (index < beginIdx) {
			index++;
			cursor = cursor.getNext();
		}
		//copy the portion of the list in the target index range
		while (index < endIdx && index < size) {
			copySub.addEnd(cursor.getData());
			cursor = cursor.getNext();
			index++;
		}
		return copySub;
	}
	
	
	/**
	 * This method would print a brief summary of this list
	 * time complexity: O(n), n is the number of actual nodes in the doubly linked list
	 */
	public void printStatistics() {
		//empty list, directly return
		if (this.head.getNext() == this.tail) {
			System.out.println("Empty list");
			return;
		}
		//copy the dummy doubly linked list to do statistic
		DoublyLinkedListDummy copyStatistic = new DoublyLinkedListDummy();
		copyStatistic = this.subList(0, this.getSize());
		
		//traverse to print statistics
		System.out.println("number  occurrence");
		DIntNode cursor = copyStatistic.head.getNext();
		while (cursor != copyStatistic.tail) {
			int data = cursor.getData();
			int occurrence = copyStatistic.countOccurrence(data);		
			copyStatistic.removeAll(data);
			System.out.printf("%6d  %10d \n", data, occurrence);
			cursor = cursor.getNext();
		}
		
	}
	
	
	
    //main 
	public static void main(String[] args) {
		//initialize one Doubly Linked List for testing
		DoublyLinkedListDummy testDLLD = new DoublyLinkedListDummy();

		//test getHead(), getTail()
		System.out.println("test getHead(), getTail(): ");
		System.out.print("head data: " + testDLLD.getHead().getData());
		System.out.println(", tail data: " + testDLLD.getTail().getData());
		
		//test addEnd(int element)
		testDLLD.addEnd(1);
		testDLLD.addEnd(2);
		testDLLD.addEnd(3);
		testDLLD.addEnd(2);
		testDLLD.addEnd(1);
		testDLLD.addEnd(3);
		testDLLD.addEnd(7);
		testDLLD.addEnd(9);
				
		//test toString()
		System.out.println(testDLLD.toString());
		
		//test removeFromHead()
		testDLLD.removeFromHead();
		System.out.println("After remove from head: \n" + testDLLD.toString());
		System.out.println();
		
		//test countOccurrence(int e)
		System.out.println("test countOccurrence(int e): ");
		System.out.printf("%d occurs %d time(s) in this linked list\n", 3, testDLLD.countOccurrence(3));
		System.out.printf("%d occurs %d time(s) in this linked list\n", 1, testDLLD.countOccurrence(1));
		System.out.printf("%d occurs %d time(s) in this linked list\n", 5, testDLLD.countOccurrence(5));
		System.out.println();
		
		//test removeAll(int e)
		System.out.println("test  removeAll(int e): ");
		//remove first actual node
		System.out.print("Remove 9: ");
		boolean answer = testDLLD.removeAll(9);
		if (answer) {
			System.out.println("Removed successfully");
		}else {
			System.out.println("list is empty or element does not exist in this list");
		}
		System.out.println(testDLLD.toString());
		//remove node that occurrence is more than one
		System.out.print("Remove 2: ");
		answer = testDLLD.removeAll(2);
		if (answer) {
			System.out.println("Removed successfully");
		}else {
			System.out.println("list is empty or element does not exist in this list");
		}
		System.out.println(testDLLD.toString());
		//remove node non-exist
		System.out.print("Remove 0: ");
		answer = testDLLD.removeAll(0);
		if (answer) {
			System.out.println("Removed successfully");
		}else {
			System.out.println("Failed. List is empty or element does not exist in this list");
		}
		System.out.println(testDLLD.toString());
		System.out.println();
		
		//test subList()
		System.out.println("test subList(copy the portion of this list, includes beginIdx, excludes endIdx): ");
		System.out.println("test subList(3, 4): (only contain ones node)");
		System.out.println(testDLLD.subList(3, 4).toString());
		System.out.println("test subList(0, 5): (endIdx > list size)");
		System.out.println(testDLLD.subList(0, 5).toString());
		System.out.println("test subList(0, 3): (normal case)");
		System.out.println(testDLLD.subList(0, 3).toString());
		System.out.println();
		
		//test printStatistics()
		System.out.println("test printStatistics(): ");
		testDLLD.addEnd(9);
		testDLLD.addEnd(3);
		testDLLD.addEnd(1);
		testDLLD.addEnd(5);
		System.out.println(testDLLD.toString());
		testDLLD.printStatistics();
		System.out.println("Check after statistic, source list is not changed: ");
		System.out.println(testDLLD.toString());
		System.out.println();
		
		//test all special cases
		//create new empty Doubly Linked List 
		DoublyLinkedListDummy emptyDLLD = new DoublyLinkedListDummy();
		System.out.println("Special cases test: ");
		System.out.println("removeFromHead for empty list: ");
		emptyDLLD.removeFromHead();
		System.out.println("removeAll for empty list: ");
		emptyDLLD.removeAll(5);
		System.out.println("countOccurrence for empty list: ");
		emptyDLLD.countOccurrence(3);
		System.out.println("printStatistics for empty list: ");
		emptyDLLD.printStatistics();
		System.out.println("subList for empty list: ");
		emptyDLLD.subList(0, 3);
//		System.out.println("test subList(3, 3): (Error because exclude endIdx)");
//		System.out.println(testDLLD.subList(3, 3).toString());
//		System.out.println("test subList(-1, 3): (Error because beginIdx is less than 0)");
//		System.out.println(testDLLD.subList(-1, 3).toString());
//		System.out.println("test subList(10, 12): (Error because beginIdx is greater than size)");
//		System.out.println(testDLLD.subList(10, 12).toString());
	}
	
	
	
	
	
	
	
	
	
}
