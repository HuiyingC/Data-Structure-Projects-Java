package cs463lab8_stack_generic_programming;


public class SNode<E> {
	E data;
	SNode<E> link;
	
	public SNode() {
		data = null;
		link = null;
	}
	
	public SNode(E e, SNode<E> link) {
		this.data = e;
		this.link = link;
	}
	
	public void setData(E e) {
		this.data = e;
	}
	
	public void setLink(SNode<E> link) {
		this.link = link;
	}
	
}
