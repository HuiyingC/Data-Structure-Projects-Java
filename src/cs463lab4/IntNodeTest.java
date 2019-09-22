package cs463lab4;

public class IntNodeTest {

	
	public static void main(String[] args) {
		IntNode listTest;
		listTest = new IntNode(10, null);
		listTest.addNodeAfterThis(20);
		listTest.addNodeAfterThis(48);
		listTest.addNodeAfterThis(36);
		
		int length = IntNode.listLength(listTest);
		System.out.println("The length of the list is: " + length);
		String listTestStr = listTest.toString(listTest);
		System.out.println("The list is: " + listTestStr);
		listTest.removeNodeAfterThis();
		String listTestStrRm = listTest.toString(listTest);
		System.out.println("After remove, the list is: " + listTestStrRm);
		
		listTest.getLink().setLink(null);
		String listTestStrSetLink = listTest.toString(listTest);
		System.out.println("After set link, the list is: " + listTestStrSetLink);
		
		listTest.setData(100);
		String listTestStrSetData = listTest.toString(listTest);
		System.out.println("After set data, the list is: " + listTestStrSetData);
	
		IntNode.search(listTest, 48);
		IntNode.search(null, 22);
		IntNode.search(listTest, 22);
	}
	
	
	
}
