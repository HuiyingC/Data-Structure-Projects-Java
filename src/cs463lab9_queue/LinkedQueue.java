/******************************************************************************
* LinkedQueue.java
* 
* A generic Linked Queue 
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;
import java.util.NoSuchElementException;
import cs463lab9_queue.QueueInterface.MyQueue;




public class LinkedQueue<E> implements MyQueue<E> {
	
	SNode<E> front; // the front of a queue
	SNode<E> rear; // the rear of the queue
	int size;  // the number of elements in the queue
	
	
	/**
	 * non-arguments constructor
	 */
	public LinkedQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	
	/**
	 * Add a new item to the queue. The new item may be the null reference.
	 * @param e - the item to be added
	 * @throws : OutOfMemoryException - Indicates insufficient memory
	 */
	public void enqueue(E e) {
		//if empty, create first node
		if (this.isEmpty()) {
			this.front = new SNode<E>(e,null);
			this.rear = this.front;
		}
		//if not empty, add to the end
		else {
			this.rear.addNodeAfterThis(e);
			this.rear = rear.link;
		}
		size++;
	}
	
	/**
	 * Get the reference to the front element and remove it from the queue
	 * @return front element 
	 * @throws NoSuchElementException - indicates the queue underflow
	 */
	public E dequeue() {
		E answer;
		//if empty
		if (size == 0) {
			throw new NoSuchElementException("Queue underflow.");
		}
		answer = front.data;
		front = front.link;
		size--;
		//after remove, the queue is empty, set rear to null
		if (size == 0) {
			rear = null;
		}
		return answer;
	}
	
	/**
	 * Get the reference to the front element without remove it
	 * @return front element
	 * @throws NoSuchElementException - indicates the queue underflow
	 */
	public E front() {
		//if empty
		if (size == 0) {
			throw new NoSuchElementException("Queue underflow.");
		}
		return this.front.data;
	}
	
	/**
	 * Get the number of items in this queue
	 * @return the number of items in this queue
	 */
	public int size() {
		return this.size;
	}
	
	
	
	/**
	 * Determine the queue is empty or not
	 * @return true if empty, otherwise return false
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	

	/**
	 * toString for the queue
	 * @return a string shows the detail of data stored in the queue
	 */
	public String toString() {
		SNode<E> cursor;
		String str = "";
		for (cursor = front;cursor!=null;cursor=cursor.link) {
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
