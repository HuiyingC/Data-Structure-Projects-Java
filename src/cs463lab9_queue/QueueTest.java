/******************************************************************************
* QueueTest.java
* 
* A test program for Linked Queue and Array Queue 
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;


public class QueueTest {
	public static void main(String[] args) {
		
		//test LinkedQueue
		System.out.println("test LinkedQueue: ");
		LinkedQueue<Integer> LQueue = new LinkedQueue<Integer>();
		//test isEmpty(), enqueue(), dequeue(), front(), size()
		System.out.println(LQueue.isEmpty());
		//test dequeue() for empty queue
		//LQueue.dequeue();
		LQueue.enqueue(5);
		LQueue.enqueue(8);
		LQueue.enqueue(1);
		LQueue.enqueue(24);
		LQueue.enqueue(6);
		LQueue.enqueue(11);
		System.out.println(LQueue.toString());
		System.out.println(LQueue.isEmpty());
		System.out.printf("Size: %d\n", LQueue.size());
		System.out.printf("Dequeue: %d\n", LQueue.dequeue());
		System.out.println(LQueue.toString());
		System.out.printf("Front: %d\n", LQueue.front());
		System.out.println();
		
		//test ArrayQueue
		System.out.println("test ArrayQueue: ");
		ArrayQueue<Integer> AQueue = new ArrayQueue<Integer>(4);
		//test isEmpty(), enqueue(), dequeue(), front(), size(), ensureCapacity()
		System.out.println(AQueue.isEmpty());
		//test dequeue() for empty queue
		//AQueue.dequeue();
		System.out.printf("Capacity: %d\n", AQueue.getCapacity());
		AQueue.enqueue(3);
		AQueue.enqueue(1);
		AQueue.enqueue(2);
		AQueue.enqueue(7);
		System.out.println(AQueue.toString());
		System.out.println(AQueue.isEmpty());
		System.out.printf("Size: %d\n", AQueue.size());
		System.out.printf("Front: %d\n", AQueue.front());
		System.out.printf("Dequeue: %d\n", AQueue.dequeue());
		System.out.printf("Dequeue: %d\n", AQueue.dequeue());
		System.out.printf("Dequeue: %d\n", AQueue.dequeue());
		System.out.printf("Dequeue: %d\n", AQueue.dequeue());
		System.out.println(AQueue.toString());
		AQueue.enqueue(5);
		AQueue.enqueue(8);
		AQueue.enqueue(2);
		AQueue.enqueue(3);
		AQueue.enqueue(4);
		System.out.println(AQueue.toString());
		System.out.printf("Capacity: %d\n", AQueue.getCapacity());
	}
	
	
	
}
