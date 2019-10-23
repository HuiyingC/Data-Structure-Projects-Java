/******************************************************************************
* Palindrome.java
* 
* A program to test an input string and tell whether or not it is
* a word-by-word palindrome. (A word-by-word palindrome is a string of words such that the words
* read the same forward and backward. Consider upper- and lowercase letters
* to be the same letter. Define a word as any string consisting of
* only letters or an apostrophe and bounded at each end with one of
* the following: a space, a punctuation mark, the beginning of the
* line, or the end of the line.)
* 
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;
import java.util.Scanner;

public class Palindrome {
	
	//main
	public static void main(String[] args) {
		// Using Scanner for Getting Input from User 
		System.out.println("Type a string: ");
        Scanner in = new Scanner(System.in); 
        String s = in.nextLine(); 
        System.out.println("You entered string is: " + s);
		if (isPalindrome(s)) {
			System.out.println("It's a word-by-word palindrome. ");
		}
		else {
			System.out.println("Not a word-by-word palindrome. ");
		}
		
/*		
		System.out.println("Test 1:" );
		String string1 =  "You can cage a swallow, cann’t you, but, you cann’t swallow a cage, can you \n?";
		if (isPalindrome(string1)) {
			System.out.println("It's a word-by-word palindrome. ");
		}
		else {
			System.out.println("Not a word-by-word palindrome. ");
		}
		
		System.out.println("Test 2:" );
		String string2 =  "You can cage a swallow, cann’t you, but, you can swallow a cage, can you?";
		if (isPalindrome(string2)) {
			System.out.println("It's a word-by-word palindrome. ");
		}
		else {
			System.out.println("Not a word-by-word palindrome. ");
		}
*/		
	}	
	
	
	/**
	 * Determine whether a string is a word-by-word palindrome
	 * @param s - a string to be checked
	 * @return true if the string is a word-by-word palindrome, otherwise return false
	 */
	public static boolean isPalindrome(String s) {
		LinkedQueue<String> PQueue = new LinkedQueue<String>();
		LinkedQueue<String> PQueueBwd = new LinkedQueue<String>();
		//remove all punctuation marks, the beginning of the line, or the end of the line, 
		//split the string with whitespace, convert all words to lower case then add into an array
		String[] words = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		//add every word forward to a queue
		for (String word : words) {
			PQueue.enqueue(word);
		}
		System.out.printf("Forward:  %s\n", PQueue.toString());
		//add every word backward to a queue
		for (int i=words.length-1;i>=0;i--) {
			PQueueBwd.enqueue(words[i]);
		}
		System.out.printf("Backward: %s\n", PQueueBwd.toString());
		//traverse two queues at the same time to check whether every element in two queues are equal
		SNode<String> cursor1, cursor2;
		for (cursor1=PQueue.front,cursor2=PQueueBwd.front;
			cursor1!=PQueue.rear&&cursor2!=PQueueBwd.rear;
			cursor1=cursor1.link,cursor2=cursor2.link) {
			if (cursor1.data.equals(cursor2.data)){
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
