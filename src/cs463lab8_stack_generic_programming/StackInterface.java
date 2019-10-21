/******************************************************************************
* StackInterface.java
* 
* A generic interface for stack
* 
* @author Huiying Chen 
* @since 14 OCT 2019
*
******************************************************************************/
package cs463lab8_stack_generic_programming;


public class StackInterface {

	public interface MyStack<E>{
		/** 
		* Get the reference to the top element and remove it from the stack
		* @return top element 
		* @throws EmptyStackException - indicates a stack underflow
		**/
		public E pop();
		
		/**
		 * Push a new item onto this stack. The new item may be the null reference.
		 * @param e - the item to be pushed onto this stack
		 * @throws : OutOfMemoryException - Indicates insufficient memory
		 */
		public void push(E e);
		
		/**
		 * Return a reference to the top element without removing it
		 * @return top element 
		 * @throws EmptyStackException - Indicates a stack underflow
		 */
		public E top();

		/**
		 * @return the number of elements in the stack
		 */
		public int size();
		
		/**
		 * @return true if the stack is empty and false otherwise
		 */
		public boolean isEmpty();
		
	}
	
	
	
	
}
