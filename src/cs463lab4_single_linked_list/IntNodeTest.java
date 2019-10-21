package cs463lab4_single_linked_list;

/**
 * test all the methods in IntNode.java
 * @author Huiying Chen
 *
 */
public class IntNodeTest {
	public static void main(String[] args) {
		//create the test list
		IntNode listTest;
		listTest = new IntNode(10, null);
		listTest.addNodeAfterThis(20);
		listTest.addNodeAfterThis(48);
		listTest.addNodeAfterThis(36);
		//IntNode.listLength() test
		int length = IntNode.listLength(listTest);
		System.out.println("The length of the list is: " + length);
		//.toString() test
		System.out.println("The list is: " + listTest.toString());
		System.out.println();
		//.removeNodeAfterThis() test
		listTest.removeNodeAfterThis();
		System.out.println("After remove, the list is: " + listTest.toString());
		//.removeNodeAfterThis() for tail node test
		System.out.println("(Special cases)Remove tail test: ");
		listTest.getLink().getLink().removeNodeAfterThis();
		System.out.println();
		//.setLink() test
		listTest.getLink().setLink(null);
		System.out.println("After set link, the list is: " + listTest.toString());
		//.setData() test
		listTest.setData(100);
		System.out.println("After set data, the list is: " + listTest.toString());
		System.out.println();
		//Null.toString() Test & try-catch test
		System.out.println("(Special cases)Null.toString() Test: ");
		IntNode null_test = null;
		try {
			System.out.println(null_test.toString());
		}
		catch(NullPointerException e) {
			System.out.println("This list is empty");
		}
		System.out.println();
		//IntNode.search() test
		System.out.println("Search Test: ");
		//IntNode.search() for exists test
		System.out.println("Search for 48: ");
		IntNode.search(listTest, 48);
		System.out.println();
		System.out.println("(Special cases)Search for null head: ");
		//IntNode.search() for null test
		IntNode.search(null, 22);
		System.out.println();
		//IntNode.search() for non-exists test
		System.out.println("Search for 22: ");
		IntNode.search(listTest, 22);
		//head.getLink().getData() test
		System.out.println();
		System.out.println("Search for head.getLink().getData(): ");
		IntNode.search(listTest, listTest.getLink().getData());
		
		
	}
	
	
	
}
