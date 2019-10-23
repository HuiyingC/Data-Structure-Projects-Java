/******************************************************************************
* SNode.java
* 
* A generic node class
* 
* @author Huiying Chen 
* @since 22 OCT 2019
*
******************************************************************************/
package cs463lab9_queue;

public class SNode<E> {
	E data;  //the value of the node
	SNode<E> link; // the point reference of the node
	
	/**
	 * The no-argument constructor which sets the node value to be null and the point reference to be null
reference.
	 */
	public SNode() {
		data = null;
		link = null;
	}
	
	/**
	 * A constructor with the given node value and the point reference.
	 * @param _data - the initial data of this new node
	 * @param _node - a reference to the node after this new node
	 */
	public SNode(E e, SNode<E> link) {
		this.data = e;
		this.link = link;
	}
	
	/**
	 * set the new node value
	 * @param newData – the new data to place in this node
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void setData(E e) {
		this.data = e;
	}
	
	
	/**
	 * set the new node point reference
	 * @param newLink - a reference to the node that should appear after this node in the linked list (or the null reference if there should be no node after this node)
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void setLink(SNode<E> link) {
		this.link = link;
	}
	
	/**
	 * This method creates a new node with value newdata and let the current node’s link point
to this new node.
	 * @param newdata - data of the new node
	 * @throws OutOfMemoryError - Indicates that there is insufficient memory for a new IntNode.
	 * @throws IllegalStateException - Indicates that the node is null.
	 */
	public void addNodeAfterThis(E newdata) {
		this.link = new SNode<E>(newdata, this.link);
	}
	
}