package cs463lab10_Recursion;

public class HanoiTowerNPeg {
	
	//solve Tower of Hanoi with n disks and n pegs
	//time complexity: O(n)
	private static void HanoiTowerNPeg(int n) {
		//move all disks to the next peg except the bottom most one
		for (int i=1;i<n;i++) {
			System.out.printf("disk " + i + " -> Peg " + (i+1) + "\n");
		}
		//move the topmost disk to the third peg 
		System.out.printf("disk " + 1 + " -> Peg " + 3 + "\n");
		//move the second last disk to the second empty peg
		System.out.printf("disk " + (n-1) + " -> Peg " + 2 + "\n");
		//move the last disk to the last peg
		System.out.printf("disk " + n + " -> Peg " + n + "\n");
		//move all the rest disks to the last peg
		for (int i=n-1;i>=1;i--) {
			System.out.printf("disk " + i + " -> Peg " + n + "\n");
		}
	}

	
	
	public static void main(String args[]) { 
		HanoiTowerNPeg(4);
	}
	
	
	
}
