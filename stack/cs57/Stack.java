package eg.edu.alexu.csd.datastructure.stack.cs57;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 * @author nada
 */
public class Stack implements IStack {
	/**
	 * size of stack.
	 */
	private int size;
	/**
	 * top of stack.
	 */
	private SNode top;
	/**
	 * constructor that creates an empty stack.
	 */
	public Stack() {
		size = 0;
		top = new SNode(null, null);
	}
	/**
	 * remove and return element.
	 */
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (size == 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SNode current = top.getnext();
		top.setNext(current.getnext());
		current.setNext(null);
		size--;
		return current.getElement();
	}
	/**
	 * return element.
	 */
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (size == 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SNode current = top.getnext();
		return current.getElement();
	}
	/**
	 * add a new element.
	 */
	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		SNode current = new SNode(element , null);
		SNode currNext;
		if (size == 0) {
			top.setNext(current);
			size++;
		} else {
			currNext = top.getnext();
			top.setNext(current);
			current.setNext(currNext);
			size++;
		}
	}
	/**
	 * check empty.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	/**
	 * return size.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	/**
	 * print stack.
	 * @return the final string of stack
	 */
	public String print() {
		  String result = "";
          SNode current = top;
          while (current.getnext() != null) {
              current = current.getnext();
              result = result + current.getElement() + ", ";
          }
          return "Stack: " + result;
	}
}
