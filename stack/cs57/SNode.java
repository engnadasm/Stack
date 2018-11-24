package eg.edu.alexu.csd.datastructure.stack.cs57;
/**
 * @author nada,toka
 */
public class SNode {
/**
 * element.
 */
private Object element;
/**
 * next.
 */
private SNode next;
	/**
	 * Constructor that creates a node with given fields.
	 * @param data of element
	 * @param n is the next node
	 */
	public SNode(final Object data, final SNode n) {
		element = data;
		next = n;
	}
	/**
	 * Returns the element of this node.
	 * @return the data of element
	 */
	public Object getElement() {
		return element;
	}
	/**
	 * Returns the next node of this node.
	 * @return the next node
	 */
	public SNode getnext() {
		return next;
	}
	/**
	 * sets the element of this node.
	 * @param data of element
	 */
	public void setElement(final Object data) {
		element = data;
	}
	/**
	 * sets the next node of this node.
	 * @param n is the next node
	 */
	public void setNext(final SNode n) {
		next = n;
	}
}
