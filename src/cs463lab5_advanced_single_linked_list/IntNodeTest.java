package cs463lab5;


/**
 * test all the methods in IntNode.java
 * @author Huiying Chen
 * @since 9/29/2019
 */


public class IntNodeTest {
	public static void main(String[] args) {

		
	
		//create the test linked list
		IntNode nodeTest = new IntNode(7,null);
		nodeTest.addNodeAfterThis(11);
		nodeTest.addNodeAfterThis(2);
		nodeTest.addNodeAfterThis(0);
		nodeTest.addNodeAfterThis(7);
		nodeTest.addNodeAfterThis(13);
		nodeTest.addNodeAfterThis(-4);
		nodeTest.addNodeAfterThis(2);

		//print linked list
		System.out.println(nodeTest.toString());
		
		//removeAllOdd(IntNode head)
		IntNode.removeAllOdd(nodeTest);
		System.out.println(nodeTest.toString());

	}
}
/*		
		//test listEvenNumber
		System.out.println("The even number of the linked list is:" + IntNode.listEvenNumber(nodeTest));
		
		//test addToEnd
		nodeTest.addToEnd(5);
		System.out.println("After add to end, the linked list is: " + nodeTest.toString());
		
		//test sumLast
		System.out.println();
		System.out.println("test sumLast(if given number is non-positive or null head, it will return 0): ");
		//(special case)test empty list
		System.out.print("Test empty list: ");
		System.out.println("Return value is: " + IntNode.sumLast(null, 5));
		int sum = 0;
		System.out.println("The length of the linked list is: " + IntNode.listLength(nodeTest));
		//(special case)given number is non-positive
		System.out.println("(special case)given number is non-positive: ");
		sum = IntNode.sumLast(nodeTest, -1);
		System.out.println("The summation of elements in the last -1 nodes is: " + sum);
		//given number is normal
		System.out.println("Test given number is normal: ");
		sum = IntNode.sumLast(nodeTest, 3);
		System.out.println("The summation of elements in the last 3 nodes is: " + sum);
		//(special case)given number is greater than list size
		System.out.println("(special case)given number is greater than list size: ");
		sum = IntNode.sumLast(nodeTest, 10);
		System.out.println("The summation of elements in the last 10 nodes is: " + sum);
		System.out.println("Note: There is one negative element in the linked list(-4)");
		System.out.println();
		
		//test copyOdd
		System.out.println("test copyOdd: ");
		//normal cases
		System.out.println("normal cases test: ");
		System.out.println("The odd part of the linked list is: " + IntNode.copyOdd(nodeTest).toString());
		//(special case)test if no odd elements in the linked list
		System.out.println("(special case)test if no odd elements in the linked list: ");
		IntNode noOdd = new IntNode(2,null);
		noOdd.addNodeAfterThis(4);
		if (IntNode.copyOdd(noOdd) == null) {
			System.out.println("There is no odd elements in the linked list");
		}
		System.out.println();
		
		//test removeAll
		System.out.println("test removeAll including head node: ");
		System.out.println("After remove 7(include head), the linked list is: " + IntNode.removeAll(nodeTest, 7).toString());
		System.out.println("(special case)test removeAll non-exist value: ");
		System.out.println("Remove 1(non-exist): " + IntNode.removeAll(nodeTest, 1).toString());
		System.out.println();
		
		//test reverse
		System.out.println("After reverse, the linked list is: " + IntNode.reverse(nodeTest).toString());
		//(special case)reverse starting from the middle node
		System.out.println("(special case-Start from middle)After reverse, the linked list is: " + IntNode.reverse(nodeTest.getLink()).toString());
		System.out.println();
		
		//test hasCycle
		System.out.println("test hasCycle: ");
		System.out.println("Normal case for hasCycle test: ");
		boolean isCyclic = IntNode.hasCycle(nodeTest);
		if (isCyclic == true) {
			System.out.println("This linked list is cyclic.");
		}
		if (isCyclic == false) {
			System.out.println("This linked list is acyclic.");
		}
		//create a cyclic linked list and test
		IntNode cyclicTest = new IntNode(2,null);
		cyclicTest.addNodeAfterThis(11);
		cyclicTest.getLink().setLink(cyclicTest);
		boolean isCyclic2 = IntNode.hasCycle(cyclicTest);
		if (isCyclic2 == true) {
			System.out.println("This linked list is cyclic.");
		}
		if (isCyclic2 == false) {
			System.out.println("This linked list is acyclic.");
		}
		
		//(special case)empty linked list cyclic test
		System.out.print("(special case)empty linked list cyclic test: ");
		IntNode emptyList = new IntNode();
		boolean isCyclic3 = IntNode.hasCycle(emptyList);
		if (isCyclic3 == true) {
			System.out.println("This linked list is cyclic.");
		}
		if (isCyclic3 == false) {
			System.out.println("This linked list is acyclic.");
		}
	
		
	}
	
}
*/	
