/******************************************************************************
* ArrayQueue.java
* 
* A generic Array Queue 
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;
import java.util.NoSuchElementException;
import cs463lab9_queue.QueueInterface.MyQueue;


public class ArrayQueue<E> implements MyQueue<E> {

	int front; // the front of a queue
	int rear;  // the rear of the queue
	E[] data;  // an array for holding the queue elements
	int size;  // the number of elements in the queue
	
	/**
	 * non-arguments constructor
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		final int INITIAL_CAPACITY = 10;
		data = (E[])new Object[INITIAL_CAPACITY];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	/**
	 * constructor with initialCapacity
	 * @param initialCapacity - capacity to be initialized
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("initialCapacity is negative: ");
		}
		size = 0;
		data = (E[])new Object[initialCapacity];
	}
	
	
	/**
	 * Add a new item to the queue. The new item may be the null reference.
	 * @param e - the item to be added
	 * @throws : OutOfMemoryException - Indicates insufficient memory
	 */
	public void enqueue(E e) {
		//if full, double size
		if (size == data.length) {
			ensureCapacity(size*2 + 1);
		}
		if (size == 0) {
			rear = front = 0;
		}
		else {
			// find the next rear position in the queue
			rear = (++rear) % data.length;
		}
		data[rear] = e;
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
		//if not empty, find the next front position
		answer = data[front];
		this.front = (++front) % data.length;
		size--;
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
		//not empty
		return data[front];
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
	 * ensure the minimum capacity
	 * @param minimumCapacity - the minimum capacity to be ensured
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int minimumCapacity) {
		E[] biggerArr;
		int n1, n2;
		if (data.length >= minimumCapacity) {
			// No change needed
			return;
		}
		//if empty, initialize with minimumCapacity
		else if (size == 0) {
			data = (E[])new Object[minimumCapacity];
		}
		//front at the left of rear, copy once
		else if(front <= rear) {
			biggerArr = (E[])new Object[minimumCapacity];
			System.arraycopy(data, front, biggerArr, front, size);
			data = biggerArr;
		}
		//front at the right of rear, copy twice
		else {
			biggerArr = (E[])new Object[minimumCapacity];
			n1 = data.length - front; 
			n2 = rear + 1;
			System.arraycopy(data, front, biggerArr, 0, n1);// copy from front to the end
			System.arraycopy(data, 0, biggerArr, n1, n2); // copy from start to rear
			front = 0; //reset the front
			rear = size - 1; //reset the rear
			data = biggerArr; 
		}
	}
	
	/**
	 * Get capacity of the queue
	 * @return the capacity of the queue
	 */
	public int getCapacity() {
		return this.data.length;
	}
	

	/**
	 * toString for queue
	 * @return a string shows the detail of data stored in the queue
	 */
	public String toString() {
		String str = "front - ";
		//if empty
		if (size == 0) {
			return "Empty Queen. ";
		}
		//front at the left of rear
		if(front <= rear) {
			for (int i=front;i<=rear;i++) {
				if (i==rear) {
					str += data[rear] + "- rear";
				}
				else {
					str += data[i] + " ";
				}
			}
		}
		//front at the right of rear
		else if(front > rear) {
			for (int i=front;i<data.length;i++) {
				str += data[i] + " ";
			}
			for (int i=0;i<=rear;i++) {
				if (i==rear) {
					str += data[rear] + "- rear";
				}
				else {
					str += data[i] + " ";
				}
			}
		}
		return str;
	}
	
}
