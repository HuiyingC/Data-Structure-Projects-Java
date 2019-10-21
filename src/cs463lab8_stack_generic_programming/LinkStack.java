/******************************************************************************
* LinkStack.java
* 
* A generic linked list stack
* 
* @author Huiying Chen 
* @since 14 OCT 2019
*
******************************************************************************/
package cs463lab8_stack_generic_programming;

import cs463lab8_stack_generic_programming.StackInterface.MyStack;
import java.util.EmptyStackException;

public class LinkStack<E> implements MyStack<E> {
	// Invariant of the LinkedStack class:
	// 1. The items in the stack are stored in a linked list, with the top of the stack stored
	// at the head node, down to the bottom of the stack at the final node.
	// 2. The instance variable top is the head reference of the linked list of items.
	SNode<E> top;
	
	public LinkStack( ) {
		top = null;
	}
	/** 
	* Get the reference to the top element and remove it from the stack
	* @return top element 
	* @throws EmptyStackException - indicates a stack underflow
	**/
	public E pop() {
		E answer;
		if (this.top == null) {
			throw new EmptyStackException( );
		}
		answer = this.top.data;
		this.top = this.top.link;
		return answer;	
	}
	
	/**
	 * Push a new item onto this stack. The new item may be the null reference.
	 * @param e - the item to be pushed onto this stack
	 * @throws : OutOfMemoryException - Indicates insufficient memory
	 */
	public void push(E e) {
		top = new SNode<E>(e, top);
	}
	
	/**
	 * Return a reference to the top element without removing it
	 * @return top element 
	 * @throws EmptyStackException - Indicates a stack underflow
	 */
	public E top() {
		if (this.top == null) {
			throw new EmptyStackException( );
		}
		return this.top.data;
			
	}

	/**
	 * @return the number of elements in the stack
	 */
	public int size() {
		int answer = 0;
		SNode<E> cursor = top;
		if(top == null) {
			throw new EmptyStackException( );
		}
		while(cursor != null) {
			answer++;
			cursor = cursor.link;
		}
		return answer;
	}
	
	/**
	 * @return true if the stack is empty and false otherwise
	 */
	public boolean isEmpty() {
		return (top == null);
	}
	

	
	/**
	 * toString for stack
	 * @return a string shows the detail of data stored in the stack
	 */
	public String toString() {
		SNode<E> cursor;
		String str = "";
		for (cursor = top;cursor!=null;cursor=cursor.link) {
			if (cursor.link == null) {
				str += cursor.data.toString();
			}
			else {
				str += cursor.data.toString() + "->";
			}
		}
		return str;
	}

	
	
	
	
	
	
	
	
}


	