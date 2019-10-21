/******************************************************************************
* ArraylistStack.java
* 
* A generic ArrayList stack
* 
* @author Huiying Chen 
* @since 14 OCT 2019
*
******************************************************************************/
package cs463lab8_stack_generic_programming;

import cs463lab8_stack_generic_programming.StackInterface.MyStack;
import java.util.*;

public class ArraylistStack<E> implements MyStack<E> {
	ArrayList<E> data;

	/**
	 * non-arguments constructor
	 */
	public ArraylistStack() {
		data = new ArrayList<E>();
	}
	
	/** 
	* Get the reference to the top element and remove it from the stack
	* @return top element 
	* @throws EmptyStackException - indicates a stack underflow
	**/
	public E pop() {
		return data.remove(data.size()-1);
	}
	
	/**
	 * Push a new item onto this stack. The new item may be the null reference.
	 * @param e - the item to be pushed onto this stack
	 * @throws : OutOfMemoryException - Indicates insufficient memory
	 */
	public void push(E e) {
		data.add(e);
	}
	
	/**
	 * Return a reference to the top element without removing it
	 * @return top element 
	 * @throws EmptyStackException - Indicates a stack underflow
	 */
	public E top() {
		return data.get(data.size()-1);
	}

	/**
	 * @return the number of elements in the stack
	 */ 
	public int size() {
		return data.size();
	}
	
	/**
	 * @return true if the stack is empty and false otherwise
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}
	

	/**
	 * toString for stack
	 * @return a string shows the detail of data stored in the stack
	 */
	public String toString() {
		String str = "";
		Iterator<E> it = this.data.iterator();
		while (it.hasNext()) {
	         str += it.next() + "  ";
	    }
		str = str + "<-top";
		return str;
	}
	
	
	
	/**
	 * @param index - the target index in the stack 
	 * @return the content of the target index in the stack
	 */
	public E get(int index) {
		return this.data.get(index);
	}
	
}
