/******************************************************************************
* NQueen.java
* 
* Solve N-queens problem for N[1,16] by using Integer ArrayList stack
* 
* @author Huiying Chen 
* @since 16 OCT 2019
*
******************************************************************************/
package cs463lab8_stack_generic_programming;


public class NQueen {
	
	/**
	 * find solution for N-queens problem
	 * @param N - number of queens needed to be placed
	 * @return total number of possible solutions
	 */
	public static int solve(int N) {
		//check N is between [1,16]
		if (N<1||N>16) { throw new IllegalArgumentException("N must between [1,16].");}
		ArraylistStack<Integer> s;
		int numSol = 0; //number of solutions
		int colid = 1; //starting column position
		s = new ArraylistStack<Integer>(); //using stack to store placed queens position
		s.push(0); // start with the 1st queen at position 0

		//find all possible solutions
		while (true) {
			//if still have place and no conflict, push queen into stack
			if (colid < N && checkConflict(colid, s)) {
				s.push(colid);
				colid = 0;  //reset colid which means starts a new row
			} else if (colid >= N) { //no place in this row
				if (s.isEmpty()) /* we are dead:( */
					break;
				colid = s.pop() + 1; /* back tracking and move to next column*/
			} else
				colid++;
			if (s.size() == N) { /* found a solution */
				printSolution(s);
				numSol++;
				colid = s.pop() + 1; /* continue to find next */
			}
		}

		return numSol;

	}

	/**
	 * Check if we can place a queen in the colid
	 * @param colid - column position of placed queen
	 * @param s - the stack which to store placed queens 
	 * @return true if no conflict, false if have conflict
	 */
	private static boolean checkConflict(int colid, ArraylistStack<Integer> s) {
		int j = s.size();
		for (int i = 0; i < j; i++) {
			int prevcolid = s.get(i);
			if (colid == prevcolid) // queen on same colidumn
				return false;
			else if (j - i == colid - prevcolid) // diagonal conflict
				return false;
			else if (j - i == prevcolid - colid)// diagonal conflict
				return false;
		}

		return true;
	}

	
	
	/**
	 * print solution for N-queens problem
	 * @param s - the stack which to store placed queens  
	 */
	private static void printSolution(ArraylistStack<Integer> s) {
		for (int i = 0; i < s.size(); i++) {
			for (int j = 0; j < s.size(); j++) {
				if (j == s.get(i))
					System.out.print("Q ");
				else
					System.out.print("- ");
			}//
			System.out.println();
		}// 
		System.out.println();
	}

	//main
	public static void main(String[] args) {
		int N = 5;
		System.out.println("Solving " + N + "-queens problem:  Have Fun!:)\n");
		int number = solve(N);
		System.out.println("Cool! There are " + number + " solutions to the " + N
				+ "-queens problem.");
	}

}