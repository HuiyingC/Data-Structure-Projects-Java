package cs463lab10_Recursion;

public class nPeg {
	private static void HanoiTowerNPeg(int nDisk, int nPeg) {
		for (int i=1;i<nDisk;i++) {
			System.out.printf("disk " + i + " -> Peg " + (i+1) + "\n");
		}
		System.out.printf("disk " + nDisk + " -> Peg " + nPeg + "\n");
		for (int i=nDisk-1;i>=1;i--) {
			System.out.printf("disk " + i + " -> Peg " + nPeg + "\n");
		}
	}
	
}
