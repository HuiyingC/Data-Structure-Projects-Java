/******************************************************************************
* RecursiveQuestion.java
* 
* recursive algorithms
* 
* @author Huiying Chen 
* @since 26 OCT 2019
*
******************************************************************************/
package cs463lab10_Recursion;


public class RecursiveQuestion {

	/**
	 * an algorithm to calculate the kth Fibonacci number F k using binary recursion
	 * @param k - the kth sequence of Fibonacci number
	 * @return the kth Fibonacci number
	 */
	public static int FibBinaryRecursive(int k) {
		//F_0 = 0
		if (k == 0) {
			return 0;
		}
		//F_1 = 1
		if (k == 1) {
			return 1;
		}
		//F_n = F_(n-1) + F_(n-2) for n > 1
		return FibBinaryRecursive(k-1) + FibBinaryRecursive(k-2);
	}
	
	
	/**
	 * an algorithm to solve the Towers of Hanoi problem
	 * @param n - the number of disks
	 * @param start - the original peg
	 * @param via - the temp peg 
	 * @param end - the destination peg 
	 */
	private static void HanoiTower(int n, String start, String via, String end) {
		//Move the last disk from original peg to destination peg
		if (n == 1) {
			System.out.printf("Move disk 1 from %s to %s\n", start, end);
	    } else {
	    	//Move the N-1 topmost disks from the original peg to the temp peg
	    	HanoiTower(n - 1, start, end, via);
	    	//Move the largest disk from original peg to the destination peg
	    	System.out.printf("Move disk %d from %s to %s\n", n, start, end);
	    	//Move N-1 disks from the temp peg to the destination peg
	        HanoiTower(n - 1, via, start, end);
	    }
	}
	
	
	/**
	 * @param L - the specified recursion depth level
	 * @param curl - the curl level
	 * @return a string of an output of call level
	 */
	public static String showCallLevel(int L, int curl) {
		String space = ""; String space1 = ""; String space2 = ""; 
		String output = "";
		//base case
		if (L == 1) {
			for (int i=0;i<curl;i++) {space += " ";}
			System.out.print(space + "This was written by call number 4x\n");
			return "This was written by call number 1y\n";
		} else{
			//print upside lines
			for (int i=0;i<curl;i++) {space1 += " ";}
			System.out.printf(space1 + "This was written by call number " + curl + "x\n");
			//recursion calls to get downside lines
			for (int i=0;i<L;i++) {space2 += " ";}     
			output = space2 +"This was written by call number " + L + "y\n";;
			return output + showCallLevel(L-1, curl+1); 
		}
		
	}
	
	
	/**
	 * prints the value of n as a binary number
	 * @param n - a non-negative integer number
	 */
	public static void BinaryPrint(int n) {
		//base case
		if (n == 0) {  
			System.out.print(0);  
		}
		//base case
		else if (n == 1) {
			System.out.print(1); 
		} else {
			//recursion calls
			BinaryPrint(n / 2);
			System.out.print((n % 2)); 
		}
	}
	
	
	/**
	 * print pattern of asterisks and blanks
	 * @param n - the number of asterisks to be printed in the longest line( a power of 2 greater than zero)
	 * @param c - the column number where the asterisks should start printing
	 */
	public static void Pattern(int n, int c) {      
		//get times of recursion calls
	    int times = (int)(Math.log(n)/Math.log(2));
	    //base case
	    if (times == 0) {
            for (int i = 0; i < c; i++) {
            	System.out.print(" ");;
            }
            System.out.print("*\n");  
	    } else {
	    	//recursion calls to get the specified pattern
            Pattern(n / 2, c);
            for (int i = 0; i < c; i++) {
            	System.out.print(" ");
            }
            for (int i = 0; i < n; i++) {
            	System.out.print("*");
            }
            System.out.print("\n"); 
            Pattern(n / 2, c + n / 2);
        }
	}
	

	
	
	/**
	 * main
	 */
	public static void main(String args[]) { 
		/*
		System.out.println(FibBinaryRecursive(0));
		System.out.println(FibBinaryRecursive(1));
		System.out.println(FibBinaryRecursive(2));
		System.out.println(FibBinaryRecursive(3));
		System.out.println(FibBinaryRecursive(4));
		System.out.println(FibBinaryRecursive(5));
		System.out.println(FibBinaryRecursive(6));
	    */
		System.out.println(showCallLevel(4,1));
        //HanoiTower(4, "A", "B", "C"); 
		//BinaryPrint(4);
		//Pattern(8, 0);
    } 
	
	
	
}
