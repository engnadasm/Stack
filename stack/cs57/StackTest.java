package eg.edu.alexu.csd.datastructure.stack.cs57;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * @author nada
 */
public class StackTest {
	/**
	 * test1.
	 */
	@Test
	public void test() {
		Stack test = new Stack();
		assertEquals(true, test.isEmpty());
		final int i = 0;
		test.push(i);
		final int i1 = 1;
		test.push(i1);
		final int i2 = 2;
		test.push(i2);
		final int i3 = 3;
		test.push(i3);
		final int i4 = 4;
		test.push(i4);
		final int i5 = 5;
        assertEquals(i5, test.size());
        assertEquals(false, test.isEmpty());
        String res = "Stack: " + "4, 3, 2, 1, 0, ";
        assertEquals(res, test.print());
        assertEquals(i4, test.peek());
        final String res2 = "Stack: " + "4, 3, 2, 1, 0, ";
        assertEquals(res2, test.print());
        assertEquals(i4, test.pop());
        final String res3 = "Stack: " + "3, 2, 1, 0, ";
        assertEquals(res3, test.print());
        assertEquals(i4, test.size());
	}
	/**
	 * test2.
	 */
	@Test
	public void test1() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("2 + 3 * 4");
		String res = "2 3 4 * +";
        assertEquals(res , expression);
	}
	/**
	 * test3.
	 */
	@Test
	public void test2() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a * b + 5");
		String res = "a b * 5 +";
        assertEquals(res, expression);
	}
	/**
	 * test4.
	 */
	@Test
	public void test3() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("(1 + 2) * 7");
		String res = "1 2 + 7 *";
        assertEquals(res, expression);
	}
	/**
	 * test5.
	 */
	@Test
	public void test4() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix("a * b / c");
		String res = "a b * c /";
        assertEquals(res, expression);
	}
	/**
	 * test6.
	 */
	@Test
	public void test5() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix(
				"a / b - c + d * e - a * c ");
		String res = "a b / c - d e * + a c * -";
        assertEquals(res, expression);
	}
	/**
	 * test7.
	 */
	@Test
	public void test6() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = test.infixToPostfix(
				"(a / (b - c + d)) * (e - a) * c");
		String res = "a b c - d + / e a - * c *";
        assertEquals(res, expression);
	}
}
