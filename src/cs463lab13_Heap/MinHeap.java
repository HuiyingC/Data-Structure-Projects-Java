/**
 * MinHeap.java
 * min Heap implement by using arraylist java class
 * @since 20 NOV 2019
 * @author Huiying Chen
 */
package cs463lab13_Heap;
import java.util.ArrayList;


public class MinHeap {
	ArrayList<Integer> heap;
	
	/**
	 * constructor
	 */
	public MinHeap() {
		heap = new ArrayList<Integer>();
	}
	
	/**
	 * get the index of the parent node
	 * @param i - the index of current node
	 * @return the parent index of the current node
	 */
	public int getParent(int i) {
		return (i-1)/2;
	}
	
	/**
	 * get the index of the left child node
	 * @param i - the index of current node
	 * @return the index of the left child node
	 */
	public int getLeftChild(int i) {
		return 2*i + 1;
	}
	
	
	/**
	 * get the index of the right child node
	 * @param i - the index of current node
	 * @return the index of the right child node
	 */
	public int getRightChild(int i) {
		return 2*i + 2;
	}
	
	
	/**
	 * swap two element at specified indexs
	 * @param i - first index 
	 * @param j - second index
	 */
	public void swap(int i, int parent) {
		int temp = heap.get(parent);
		heap.set(parent, heap.get(i));
		heap.set(i, temp);
	}
	
	
	/**
	 * check if specified index in the heap is leaf
	 * @param index - the index of element in the heap
	 * @return true is the element is leaf, otherwise return false
	 */
	public boolean isLeaf(int index) {
		if (getLeftChild(index)>(heap.size()-1) && getRightChild(index)>(heap.size()-1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Add a new element e into the heap
	 * @param e - the new element to be added
	 */
	public void add(int e) {
		//add to the end
		heap.add(e);
		//reheapUpward
		int index = heap.size() - 1;
		while (index > 0 && heap.get(index) < heap.get(getParent(index))) {
			swap(index, getParent(index));
			index = getParent(index);
		}
	}
	
	
	/**
	 * Get and remove the top element of the heap
	 * @return the top/smallest element of the heap
	 * @throws NullPointerException if the heap is empty
	 */
	public int remove() {
		//if the heap is empty
		if (heap.size() == 0) {
			throw new NullPointerException("Empty Heap");
		//remove
		}else {
			//store the minimum value
			int min = heap.get(0);
			//set the top to the last element's value
			//System.out.printf("min: " + min + "\n");
			swap(0, heap.size()-1);
			//System.out.printf("root: " + heap.get(0) + "\n");
			//remove the last element
			heap.remove(heap.get(heap.size()-1));
			//reheapDownward
			reheapDownward(heap);
			return min;
		}
	}
	
	
	/**
	 * Restore the min-heap
	 * @param h - the heap to be restored
	 */
	public void reheapDownward(ArrayList<Integer> h) {
		int root = h.get(0);
		//System.out.printf("root: " + root + "\n");
		int lastIndex = h.size()-1;
		int index = 0;
		//reheapDownward
		while(true) {
			int childLeftIndex = getLeftChild(index);
			//System.out.printf("childLeftIndex: " + childLeftIndex + "\n");
			int childRightIndex = getRightChild(index);
			//System.out.printf("childRightIndex: " + childRightIndex + "\n");
			int child, childIndex;
	        if (childLeftIndex <= lastIndex) {
	        	//get smaller child
	        	if (childRightIndex<=childLeftIndex&&h.get(childLeftIndex)>h.get(childRightIndex)) {
	        		child = h.get(childRightIndex);
	        		childIndex = childRightIndex;
	        	}else {
	        		child = h.get(childLeftIndex);
	        		childIndex = childLeftIndex;
	        	}
	        	//System.out.printf("childIndex: " + childIndex + "\n");
	        	//check if root is less than the smaller child, if so, swap
	        	if (root > child) {
	        		swap (index, childIndex);
	        		index = childIndex;
	        		//System.out.printf("root: " + root + "\n");
	        	}else { //root is smaller than both child
	        		break;
	        	}
	        }else { //no child
	        	break;
	        }
		}
	}
	
	

	/**
	 * Get the top element of the heap
	 * @return the top element of the heap
	 * @throws NullPointerException if the heap is empty
	 */
	public int top() {
		if (heap.size() == 0) {
			throw new NullPointerException("Empty Heap");
		}else {
			return heap.get(0);
		}
	}
	
	
	/**
	 * print heap
	 */
	public void printHeap() { 
		int lastIndex = heap.size()-1;
        for (int i = 0; i <= heap.size() / 2-1; i++) { 
            System.out.print(" PARENT : " + heap.get(i));
            if (2*i+1<=lastIndex) {
                System.out.print(" LEFT CHILD : " + heap.get(2*i+1));
            }
            if (2*i+2<=lastIndex) {
            	System.out.print(" RIGHT CHILD :" + heap.get(2*i+2)); 
            }
            System.out.println(); 
        } 
    } 
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		//remove from empty heap
		//System.out.printf("Remove from empty heap: " + minHeap.remove() + "\n");
		//System.out.printf("Top from empty heap: " + minHeap.top() + "\n");
		
		//build minHeap
		minHeap.add(5);
		minHeap.add(3);
		minHeap.add(17);
		minHeap.add(10);
		minHeap.add(84);
		minHeap.add(19);
		minHeap.add(6);
		minHeap.add(22);
		minHeap.add(9);
		//print minHeap
		minHeap.printHeap();
		//test top()
		System.out.printf("Top: " + minHeap.top() + "\n");
		//test remove()
		System.out.printf("Remove: " + minHeap.remove() + "\n");
		System.out.println("After remove: ");
		minHeap.printHeap(); 
		System.out.printf("Top: " + minHeap.top() + "\n");
		System.out.printf("Remove: " + minHeap.remove() + "\n");
		System.out.println("After remove: ");
		minHeap.printHeap(); 
		System.out.printf("Top: " + minHeap.top() + "\n");
		System.out.printf("Remove: " + minHeap.remove() + "\n");
		System.out.println("After remove: ");
		minHeap.printHeap(); 

	}
	
}
