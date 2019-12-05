/**
 * search.java
 * binary search function to search an element e in an array A
 * all the elements in array A are useful elements, and the values in A are ordered in ascending order.
 * @since 21 NOV 2019
 * @author Huiying Chen
 */
package cs463lab13_Heap;

public class search {
	
	/**
	 * @param A - an ascending ordered array to be searched
	 * @param e - the target element
	 * @return the index of the target element, if not found, return -1
	 */
	public static int binarySearch (int[] A, int e) {
		//call the function
		int resultPos = binarySearch(A,	0, A.length-1, e);
		return resultPos;
	}
	
	/**
	 * @param array - an array to be searched
	 * @param idxs - start index
	 * @param idxe - end index
	 * @param e - the target element
	 * @return index of the target element, return -1 if not found
	 */
	private	static int binarySearch (int[]array, int idxs, int idxe, int e){
		//base case, if not found, return -1
		if(idxe < idxs) return -1;
		//get the middle index
		int idx_middle = (idxe+idxs)/2;
		//base case, if found, return the index
		if(array[idx_middle] == e) {	
			return idx_middle;
		//if e is less than the middle value, set end index to middle-1 and recursive call
		}else if(e < array[idx_middle]) {	
			return binarySearch(array, idxs, idx_middle-1, e);
		//if e is greater than the middle value, set start index to middle+1 and recursive call
		}else {	 
			return binarySearch(array, idx_middle+1, idxe, e);
		}
	}
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		System.out.println("Binary search test: ");
		int[] A = {2, 5, 8, 20, 34, 61, 93, 100};
		System.out.print("Array: ");
		for (int i : A) {System.out.printf(i + " ");}
		System.out.println();
		//test cases
		System.out.printf("The index of 20 in the array is: " + binarySearch (A, 20) + "\n");
		System.out.printf("The index of 2 in the array is: " + binarySearch (A, 2) + "\n");
		System.out.printf("The index of 100 in the array is: " + binarySearch (A, 100) + "\n");
		//test non-exist element
		System.out.printf("The index of 77(non-exists) in the array is: " + binarySearch (A, 77) + "\n");
	}
		
}
