package cs463lab4;

public class IntNode {
	private int data;
	private IntNode link;
		
	public IntNode() {
		data = 0;
		link = null;
	}
	
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;	
	}
	
	public int getData() {
		return data;
	}
	
	public IntNode getLink() {
		return link;
	}
	
	public void setData(int newData) {
		data = newData;
	}
	
	public void setLink(IntNode newLink) {
		link = newLink;
	}
	
	public String toString(IntNode startNode) {
		String str = String.valueOf(startNode.data);
		IntNode cursor;
		for (cursor = startNode.link;cursor != null;cursor = cursor.link) {
			str = str + "->" + String.valueOf(cursor.data);
		}
		return str;
	}
	
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}
	
	public void removeNodeAfterThis() {
		link = link.link;
	}
	
	public static int listLength(IntNode head) {
		IntNode cursor;
		int answer;
		answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		return answer;	
	}
	
	public static boolean search(IntNode head, int data) {
		IntNode cursor;
		if (head != null) {
			for (cursor = head; cursor != null; cursor = cursor.link) {
				if (data == cursor.data) {
					System.out.println("Found data in the list");
					return true;
				}
			}
			System.out.println("List does not contain this data");
			return false;
		}
		System.out.println("The list is null");
		return false;
	}
	
	
	
	
	
}
