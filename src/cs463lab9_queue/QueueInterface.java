/******************************************************************************
* QueueInterface.java
* 
* A generic interface for Queue
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;
import java.util.NoSuchElementException;

public class QueueInterface {
	
	public interface MyQueue<E> {
		
		/**
		 * Add a new item to the queue. The new item may be the null reference.
		 * @param e - the item to be added
		 * @throws : OutOfMemoryException - Indicates insufficient memory
		 */
		public void enqueue(E e);
		
		/**
		 * Get the reference to the front element and remove it from the queue
		 * @return front element 
		 * @throws NoSuchElementException - indicates the queue underflow
		 */
		public E dequeue();
		
		/**
		 * Get the reference to the front element without remove it
		 * @return front element
		 * @throws NoSuchElementException - indicates the queue underflow
		 */
		public E front();
		
		/**
		 * Get the number of items in this queue
		 * @return the number of items in this queue
		 */
		public int size();
		
		/**
		 * Determine the queue is empty or not
		 * @return true if empty, otherwise return false
		 */
		public boolean isEmpty();
	}
}
