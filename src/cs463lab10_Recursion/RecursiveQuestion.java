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
	 * an algorithm to calculate the kth Fibonacci number F_k using binary recursion
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
	 * an algorithm to show call level
	 * @param L - the deepest recursion level
	 * @param curl - the current recursion depth level
	 * @return a string shows call level
	 */
	public static String showCallLevel(int L, int curl) {
		String space = ""; 
		//base case
		if (curl == L) {
			for (int i=0;i<curl;i++) {space += " ";}
			return space + "This was written by call number " + curl + "x\n" + space + "This was written by call number " + curl +"y\n";
		} else{
			//generate two lines, and call recursion between the two lines
			for (int i=0;i<curl;i++) {space += " ";}
			return space + "This was written by call number " + curl + "x\n" + showCallLevel(L, curl+1) + space + "This was written by call number " + curl +"y\n"; 
		}
		
	}
	
	
	/**
	 * prints the value of n as a binary number.  If n is zero, then a single zero is printed; otherwise, no leading zeros are printed in the output.
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
		
		System.out.println("FibBinaryRecursive Test: ");
		System.out.printf("F_0: %d\n", FibBinaryRecursive(0));
		System.out.printf("F_1: %d\n", FibBinaryRecursive(1));
		System.out.printf("F_2: %d\n", FibBinaryRecursive(2));
		System.out.printf("F_3: %d\n", FibBinaryRecursive(3));
		System.out.printf("F_4: %d\n", FibBinaryRecursive(4));
		System.out.printf("F_5: %d\n", FibBinaryRecursive(5));
		System.out.printf("F_6: %d\n", FibBinaryRecursive(6));
		System.out.println();
		
		System.out.println("showCallLevel(4,1) Test: ");
		System.out.println(showCallLevel(4,1));
		System.out.println();
		System.out.println("showCallLevel(6,1) Test: ");
		System.out.println(showCallLevel(6,1));
		System.out.println();
		
		System.out.println("HanoiTower(4, 'A', 'B', 'C') Test: ");
        HanoiTower(4, "A", "B", "C"); 
        System.out.println();
        
        System.out.println("BinaryPrint Test: ");
        System.out.print("BinaryPrint(0): ");
        BinaryPrint(0);
        System.out.println();
        System.out.print("BinaryPrint(4): ");
		BinaryPrint(4);
		System.out.println();
        System.out.print("BinaryPrint(27): ");
		BinaryPrint(27);
		System.out.println("\n");
		
		System.out.println("Pattern(8, 0) Test: ");
		Pattern(8, 0);
    } 
	
	
	
}
