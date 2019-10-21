/******************************************************************************
* StackTest.java
* 
* Testing program for ArraylistStack.java and LinkStack.java
* 
* @author Huiying Chen 
* @since 14 OCT 2019
*
******************************************************************************/
package cs463lab8_stack_generic_programming;


public class StackTest {
	public static void main(String[] args) {

		//test LinkStack
		System.out.println("test LinkStack: ");
		LinkStack<Integer> LStack = new LinkStack<Integer>();
		//test isEmpty(), push(), pop(), top(), size()
		System.out.println(LStack.isEmpty());
		LStack.push(10);
		LStack.push(5);
		LStack.push(9);
		LStack.push(2);
		LStack.push(-1);
		LStack.push(5);
		System.out.println(LStack.isEmpty());
		System.out.println(LStack.toString());
		System.out.printf("Size: %d\n", LStack.size());
		System.out.printf("Top(): %d\n", LStack.top());
		System.out.println(LStack.toString());
		System.out.printf("Pop(): %d\n", LStack.pop());
		System.out.println(LStack.toString());
		System.out.println();
	
		
		//test ArrayListStack
		System.out.println("test ArrayListStack: ");
		ArraylistStack<Integer> AStack = new ArraylistStack<Integer>();
		//test isEmpty(), push(), pop(), top(), size()
		System.out.println(AStack.isEmpty());
		AStack.push(8);
		AStack.push(3);
		AStack.push(1);
		AStack.push(5);
		AStack.push(21);
		AStack.push(4);
		System.out.println(AStack.isEmpty());
		System.out.println(AStack.toString());
		System.out.printf("Size: %d\n", AStack.size());
		System.out.printf("Top(): %d\n", AStack.top());
		System.out.println(AStack.toString());
		System.out.printf("Pop(): %d\n", AStack.pop());
		System.out.println(AStack.toString());
	
	
	}
	
}
