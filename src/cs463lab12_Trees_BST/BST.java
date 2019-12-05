/**
 * BST.java
 * Binary Search Tree
 * @since 20 NOV 2019
 * @author Huiying Chen
 */
package cs463lab12_Trees_BST;

class BSTNode{
	private int data;   //the element value for this node
	private BST left;	//the left child of this node
	private BST right;	//the right child of this node
	
	/**
	 * No-argument constructor
	 */
	public BSTNode(){}
	
	/**
	 * Constructor with the initial element
	 * @param initData: the initial element
	 */
	public BSTNode(int initData){
		data = initData; 
		left = new BST();
		right = new BST();
	}
	
	/**
	 * Constructor with the initial element, initial left and right children
	 * @param initData: the initial element
	 * @param initParent: the initial parent tree
	 * @param initLeft: left child
	 * @param initRight: right child
	 */
	public BSTNode(int initData, BST initLeft, BST initRight){
		data = initData;
		left = initLeft;
		right = initRight;
	}

	/**
	 * Evaluate whether this node is a leaf node or not
	 * @return true if it is a leaf node; otherwise, return false.
	 */
	public boolean isLeaf()
	{
		return (((left==null)||(left!=null && left.root==null))
				&&((right==null)||(right!=null && right.root==null)));
	}
	
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * @param set the element in this node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * @return the left child
	 */
	public BST getLeft() {
		return left;
	}

	/**
	 * @param the left child to be set
	 */
	public void setLeft(BST left) {
		this.left = left;
	}

	/**
	 * @return the right child
	 */
	public BST getRight() {
		return right;
	}

	/**
	 * @param the right child to be set
	 */
	public void setRight(BST right) {
		this.right = right;
	}
	
	
	/**
	 * Convert this BTNode to a string
	 */
	public String toString()
	{
		String str="";
		
		if((left==null)||(left!=null && left.root==null)) str +="(null)";
		else str +="("+left.root.getData()+")";
		
		str += data;
		
		if((right==null)||(right!=null&&right.root==null)) str +="(null)";
		else str +="("+right.root.getData()+")";
		
		return str;
	}
}


/**
 * The class for Binary Search Tree
 * @author Huiping Cao
 *
 */
public class BST {
	protected BSTNode root; //the tree root
	
	
	/**
	 * Get the left subtree of this tree
	 * @return the left subtree of this tree
	 */
	private BST getLeftSubtree(){
		return root.getLeft();
	}
	
	/**
	 * Get the right subtree of this tree
	 * @return the right subtree of this tree
	 */
	private BST getRightSubtree(){
		return root.getRight();
	}
	
	/**
	 * Print the tree using in-order traversal strategy
	 */
	public void inOrderPrt(){
		inOrderPrt(0);
	}
	
	/**
	 * private, recursive function
	 *     I slightly changed the method to print right subtree first
	 *     It is to make the display more easier to read
	 * 
	 * @param node
	 * @param indentation
	 * @param branch
	 */
	private void inOrderPrt(int indentation){
		if(root!=null){
			if(getRightSubtree()!=null) getRightSubtree().inOrderPrt(indentation+1);
			
			for(int i=0;i<indentation*4;i++) System.out.print(" ");
			
			System.out.println(root.getData());
			
			if(getLeftSubtree()!=null) getLeftSubtree().inOrderPrt(indentation+1);
		}
	}
	
	
	/**
	 * Debug function, print the tree for debugging purpose
	 */
	public String toString()
	{
		if(root!=null) return root.toString();
		else return null;
	}
	
	///////////////////////////////////////
    ///////////////////////////////////////
	// Please add the functions required for your lab homework here.
	/**
	 * Insert a new element e into the binary search tree without duplicate values allowed
	 * @param e - a new element need to be added
	 * @return When e exists in the tree, return false; Otherwise, insert e to the tree and return true
	 */
	public boolean insert (int e) {
		//base case, the current tree root is empty, create a new root
		if (root == null) {
			root = new BSTNode(e, new BST(), new BST());
			return true;
		}
		//base case, if e already exists
		if (e==root.getData()) {
			return false;
		}
		//the current tree root is not empty and no duplicates
		//e is less than the root data, recursive call, insert to the left subtree
		if (e<root.getData()){
			return root.getLeft().insert(e);
		}
		//e is greater than the root data, recursive call, insert to the right subtree
		else {
			return root.getRight().insert(e);
			
		}
	}
	
	/**
	 * Remove a specified element from the binary search tree
	 * @param e - the element to be removed
	 * @return When e exists in the tree and one instance is successfully removed, return true; Otherwise, return false.
	 */
	public boolean remove (int e) {
		//the current tree is empty, return false
		if (root == null) {return false;}
		//found e in the current root
		if (root.getData() == e) {
			//if the root has neither left or right subtree, set root to null
			if (root.getLeft().root == null && root.getRight().root == null) {
				root = null;
				return true;
			}
			//if current root only has right subtree, set this root to the root of current node’s right subtree
			if (root.getLeft().root == null && root.getRight().root != null) {
				root = root.getRight().root;
				return true;
			}
			//if current root only has left subtree, set this root to the root of current node’s left subtree
			if (root.getLeft().root != null && root.getRight().root == null) {
				root = root.getLeft().root;
				return true;
			}
			//if current root has both left and right subtrees, replace root by the maximum value of left subtree
			if (root.getLeft().root != null && root.getRight().root != null) {
				int maxLeft = this.getLeftSubtree().removeRightmost();
				root.setData(maxLeft);
				return true;
			}
		}
		//e is less than the root's data, recursive call to the left subtree
		if (e < root.getData()) {
			return this.getLeftSubtree().remove(e);
		}
		//e is greater than the root's data, recursive call to the right subtree
		else {
			return this.getRightSubtree().remove(e);
		}
	}
	
	/**
	 * Remove the right most node of called BST, and return its data
	 * @return the data of the right most node of the BST
	 */
	public int removeRightmost() {
		//base case, if the right subtree is empty, set current root to be the left subtree's root, and return original root's data 
		if ( this.getRightSubtree().root == null) { 
			int max = this.root.getData();
			this.root = this.getLeftSubtree().root;
			return max;
		//A recursive call removes the rightmost node from my own right subtree
		}else { 
			return this.getRightSubtree().removeRightmost( );
		}
	}
	
	
	/**
	 * a recursive function to search whether an element exists in a binary search tree
	 * Time complexity: [ANALYZE]
	 * -Let n = the number of nodes in the BST, N = the number of recursive calls(N>0)
	 * -In the worst case, all node in the BST only have all left subtree or all nodes only have all right subtree, like a linked list
	 * -T(n) = N recursive calls, each call reach one node further, and move forward one level(N=n)
	 * ->time complexity = O(n)  
	 * @param e - the target element 
	 * @return If e exists, return the node that contains this element; Otherwise, return null
	 */
	public BSTNode searchRecursion(int e) {
		//base case, if the tree is empty, return null
		if (root == null) {return null;}
		//base case, if found e 
		if (e == root.getData()) {
			return root;
		}
		//if e is less than current root's data, recursive call the left subtree
		if (e < root.getData()) {
			return root.getLeft().searchRecursion(e);
		}
		//if e is greater than current root's data, recursive call the right subtree
		else {
			return root.getRight().searchRecursion(e);
		}
		
	}
	
	
	/**
	 * a non-recursive function to search whether an element exists in a binary search tree
	 * @param e - the target element
	 * @return If e exists, return the node that contains this element; Otherwise, return null
	 */
	public BSTNode searchNonRecursion(int e) {
		//if root is null, the tree is empty, return null
		if (root == null) { return null;}
		//if root is not null, set cursor to the tree's root
		BSTNode cursor = root;
		//while cursor is not null, loop to search e
		while (cursor != null) {
			//if found e
			if (cursor.getData() == e) {return cursor;}
			//if e is less than cursor's data, set cursor to its left subtree's root
			if (e < cursor.getData()) {
				cursor = cursor.getLeft().root;
			}
			//if e is greater than cursor's data, set cursor to its right subtree's root
			else {
				cursor = cursor.getRight().root;
			}
		}
		return cursor;	
	}
	
	
	/**
	 * a recursive function to add up all the elements in this binary search tree
	 * @return the summation of all the elements
	 */
	public int sum() {
		//base case, when reach empty tree
		if (root == null) {return 0;}
		//Traversal to add up all elements
		else {
			return root.getData() + this.getLeftSubtree().sum() + getRightSubtree().sum();
		}
	}
	
	
	
	/**
	 * Test cases provided by the instructor
	 * @throws Exception
	 */
	private static void test1() throws Exception{
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		
		boolean rc = true;
		
		//test 1: insert method, and test 2 in-order traversal
		rc = tree.insert(12); System.out.println("\nInsert 12, inserted="+rc+", after adding 12:"); tree.inOrderPrt();
		rc = tree.insert(6);  System.out.println("\nInsert 6, inserted="+rc+", after adding 6:"); tree.inOrderPrt();
		rc = tree.insert(19); System.out.println("\nInsert 19, inserted="+rc+", after adding 19:"); tree.inOrderPrt();
		rc = tree.insert(4);  System.out.println("\nInsert 4, inserted="+rc+", after adding 4:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8, inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(16); System.out.println("\nInsert 16, inserted="+rc+", after adding 16:"); tree.inOrderPrt();
		rc = tree.insert(8);  System.out.println("\nInsert 8 (second), inserted="+rc+", after adding 8:"); tree.inOrderPrt();
		rc = tree.insert(5);  System.out.println("\nInsert 5, inserted="+rc+", after adding 5:"); tree.inOrderPrt();
		rc = tree.insert(9);  System.out.println("\nInsert 9, inserted="+rc+", after adding 9:"); tree.inOrderPrt();
		rc = tree.insert(20);  System.out.println("\nInsert 20, inserted="+rc+", after adding 20:"); tree.inOrderPrt();
		
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
	
		//test 3: search method
		BSTNode node = tree.searchRecursion(6);
		System.out.println("searchRecursion 6, node="+node);
		node = tree.searchRecursion(22);
		System.out.println("searchRecursion 22, node="+node);
		node = tree.searchRecursion(8);
		System.out.println("searchRecursion 8, node="+node+"\n");
		
		node = tree.searchNonRecursion(6);
		System.out.println("searchNonRecursion 6, node="+node);
		node = tree.searchNonRecursion(22);
		System.out.println("searchNonRecursion 22, node="+node);
		node = tree.searchNonRecursion(8);
		System.out.println("searchNonRecursion 8, node="+node);

		//test 4: remove method
		rc = tree.remove(30); //test case 0: e does not exist
		System.out.println("\nRemove 30, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(20); //test case 1: leaf
		System.out.println("\nRemove 20, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(4); //test case 2: left is empty
		System.out.println("\nRemove 4, rc="+rc);
		tree.inOrderPrt();
		
		
		rc = tree.remove(19); //test case 3: right is empty
		System.out.println("\nRemove 19, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(6); //test case 4: no subtree is empty
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(12); //more tests: remove root
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		
		rc = tree.remove(5); //more tests
		System.out.println("\nRemove 5, rc="+rc);
		tree.inOrderPrt();
	
		rc = tree.remove(8); //more tests
		System.out.println("\nRemove 8, rc="+rc);
		tree.inOrderPrt();
		rc = tree.remove(16); //more tests
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();

		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("\nAdding a series of numbers:");
		tree.insert(30);
		tree.insert(20);tree.insert(10);tree.insert(25);tree.insert(28);tree.insert(24);
		tree.insert(11);tree.insert(5);tree.insert(11);tree.insert(12);
		tree.insert(50);tree.insert(40);tree.insert(35);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.print("sum="+tree.sum()+"\n");
		System.out.print("\n\n");
		
		System.out.println("\nRemove 20 (removeNode case 4):");
		tree.remove(20);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		System.out.println("Inorder traversal results: ");
		tree.inOrderPrt();
		System.out.print("\n");
		System.out.print("sum="+tree.sum()+"\n");

	
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//You need to let your program pass the  test cases in this function
		test1(); 
		
		//You can add your own test cases here. 
		System.out.print("\n\n");
		System.out.println("My own test cases, which cover other branches\n");
		BST tree = new BST();
		System.out.println("Initial tree:");
		tree.inOrderPrt(); //test inOrder traversal
		boolean rc = true;
		//test remove from empty tree
		rc = tree.remove(6);
		System.out.printf("Remove from empty tree: " + rc + "\n");
		
		//build tree
		tree.insert(12);
		tree.insert(6);  
		tree.insert(19);
		tree.insert(4); 
		tree.insert(8);  
		tree.insert(16); 
		System.out.println("Inorder traversal results:");
		tree.inOrderPrt(); 
		System.out.print("\n\n");
		
		//more search test cases
		//searchRecursion
		BSTNode node = tree.searchRecursion(19);
		System.out.println("searchRecursion 19, node="+node);
		node = tree.searchRecursion(16);
		System.out.println("searchRecursion 16, node="+node);
		node = tree.searchRecursion(12);
		System.out.println("searchRecursion 12, node="+node+"\n");
		//searchNonRecursion
		node = tree.searchNonRecursion(19);
		System.out.println("searchNonRecursion 19, node="+node);
		node = tree.searchNonRecursion(16);
		System.out.println("searchNonRecursion 16, node="+node);
		node = tree.searchNonRecursion(12);
		System.out.println("searchNonRecursion 12, node="+node);
		System.out.print("sum="+tree.sum()+"\n");
		//more tests
		rc = tree.remove(16); 
		System.out.println("\nRemove 16, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		rc = tree.remove(0); 
		System.out.println("\nRemove 0, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		rc = tree.remove(12); 
		System.out.println("\nRemove 12, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
		rc = tree.remove(6); 
		System.out.println("\nRemove 6, rc="+rc);
		tree.inOrderPrt();
		System.out.print("sum="+tree.sum()+"\n");
		
	}

}
