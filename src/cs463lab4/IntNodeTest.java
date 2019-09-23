package cs463lab4;

/**
 * test all the methods in IntNode.java
 * @author Huiying Chen
 *
 */
public class IntNodeTest {
	public static void main(String[] args) {
		IntNode listTest;
		listTest = new IntNode(10, null);
		listTest.addNodeAfterThis(20);
		listTest.addNodeAfterThis(48);
		listTest.addNodeAfterThis(36);
		
		int length = IntNode.listLength(listTest);
		System.out.println("The length of the list is: " + length);
		System.out.println("The list is: " + listTest.toString());
		listTest.removeNodeAfterThis();
		System.out.println("After remove, the list is: " + listTest.toString());
		
		listTest.getLink().setLink(null);
		System.out.println("After set link, the list is: " + listTest.toString());
		
		listTest.setData(100);
		System.out.println("After set data, the list is: " + listTest.toString());
		
		System.out.println("Search Test: ");
		System.out.println("Search for 48: ");
		IntNode.search(listTest, 48);
		System.out.println("Search for null head: ");
		IntNode.search(null, 22);
		System.out.println("Search for 22: ");
		IntNode.search(listTest, 22);
		System.out.println("Search for head.getLink().getData(): ");
		IntNode.search(listTest, listTest.getLink().getData());
	}
	
	
	
}
