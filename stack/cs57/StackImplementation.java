package eg.edu.alexu.csd.datastructure.stack.cs57;
import java.util.Scanner;
/**
 * @author nada
 */
public class StackImplementation {
	/**
	 * flage to check.
	 */
	static int check = 0;
	/**
	 * stack.
	 */
	static Stack myStack = new Stack();
	/**
	 * main.
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int q = 3;
		final int p = 4;
		final int v = 5;
		while (check == 0) {
		System.out.println("1: Push\r\n"
		+ "2: Pop\r\n"
		+ "3: Peek\r\n"
		+ "4: Get size\r\n"
		+ "5: Check if empty");
		Scanner sc = new Scanner(System.in);
	     int i = sc.nextInt();
	     if (i == 1) {
	    	 System.out.println(
	    			 "Enter element to pop it in stack :");
	    	 Scanner sc1 = new Scanner(System.in);
		     Object i1 = sc1.nextInt();
	    	 myStack.push(i1);
	    	 System.out.println(myStack.print());
	     } else if (i == 2) {
	    	 System.out.println(""
	    	 		+ "The pop element is : "
	    			 +  myStack.pop());
	    	 System.out.println("The stack become:");
	    	 System.out.println(myStack.print());
	     } else if (i == q) {
	    	 System.out.println("The peek element is : "
	     +  myStack.peek());
	    	 System.out.println(myStack.print());
	     } else if (i == p) {
	    	 System.out.println("The size of stack is : "
	     +  myStack.size());
	     } else if (i == v) {
	    	 if (myStack.isEmpty()) {
	    		 System.out.println("the stack is empty");
	    	 } else {
	    		 System.out.println("the stack is not empty");
	    	 }
	     } else {
	    	 System.out.println("please choose number from 1 to 5");
	     }
	     int flag = 1;
	     while (flag == 1) {
	    	 System.out.println("Do you want continue?");
		     System.out.println("1: Yes.");
		     System.out.println("2: No.");
		     Scanner scW = new Scanner(System.in);
		     int i6 = scW.nextInt();
	     if (i6 == 1) {
	    	 check = 0;
	    	 flag = 0;
	     } else if (i6 == 2) {
	    	 check = 1;
	    	 flag = 0;
	     } else {
	    	 System.out.println("please choose number 1 or 2");
	    	 flag = 1;
	     }
	     }
		}
	}
}
