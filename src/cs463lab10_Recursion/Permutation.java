/******************************************************************************
* Permutation.java
* 
* Permutation algorithm for arrays by using recursion
* 
* @author Huiying Chen 
* @since 30 OCT 2019
*
******************************************************************************/
package cs463lab10_Recursion;

public class Permutation {
	/**
	 * Permutation algorithm for a generic array by using recursion
	 * @param array - a generic array
	 * @param prefixLen - the start index
	 */
	public static<E> void PermuteArray(E[] array, int prefixLen) {
		//base case
		if (prefixLen == array.length) {
			printArray(array);
		}
		//Recursive	case
		if (prefixLen < array.length) {
			//For (each position from [prefixlen] to array.length)
			for (int i=prefixLen;i<array.length;i++) {
				//swap array[i] and array[prefixLen]
				swap(array, prefixLen, i);
				//permutate all the elements in	array[prefixLen+1] ... array[arrayl.length-1]
				PermuteArray(array, prefixLen+1);
				//swap back
				swap(array, prefixLen, i);
			}		
		}
	}
	
	/**
	 * Swap two elements in a generic array
	 * @param array - a generic array
	 * @param i - the first element index
	 * @param j - the second element index
	 */
	public static<E> void swap(E[] array, int i, int j) {
		E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * print an array
	 * @param array - a generic array
	 */
	public static<E> void printArray(E[] array) {
		for (int i=0;i<array.length;i++) {
			System.out.printf(array[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * main
	 * A test function to test Permutation algorithm when the array length
is 1, 2, 5, and 10
	 */
	public static void main(String args[]) { 
		//Test array length = 1
		System.out.println("Test array length = 1: ");
		Integer[] Arr_len1 = new Integer[]{1};
		PermuteArray(Arr_len1,0);
		//Test array length = 2
		System.out.println("Test array length = 2: ");
		Integer[] Arr_len2 = new Integer[]{1,2};
		PermuteArray(Arr_len2,0);
		//Test array length = 5
		System.out.println("Test array length = 5: ");
		Integer[] Arr_len5 = new Integer[]{1,2,3,4,5};
		PermuteArray(Arr_len5,0);
		//Test array length = 10
		System.out.println("Test array length = 10: ");
		Integer[] Arr_len10 = new Integer[]{1,2,3,4,5,6,7,8,9,0};
		PermuteArray(Arr_len10,0);
	}
	
	
	
	
	
}
