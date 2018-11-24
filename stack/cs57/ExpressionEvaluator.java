package eg.edu.alexu.csd.datastructure.stack.cs57;
import java.util.Arrays;
import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 * @author nada
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	 * stack of letter.
	 */
	Stack letter = new Stack();
	/**
	 * stack of oper.
	 */
	Stack oper = new Stack();
	/**
	 * stack of number.
	 */
	Stack number = new Stack();
	/**
	 * stack to print.
	 */
	Stack print = new Stack();
	/**
	 * flage to check.
	 */
	int flag = 0;
	/**
	 * flage to check.
	 */
	int flag2 = 0;
	/**
	 * number of symbol.
	 */
	int noSy = 0;
	/**
	 * number of digit.
	 */
	int no = 0;
	/**
	 * flage to check.
	 */
	int check = 0;
	/**
	 * @param name
	 * @return boolean
	 */
	private boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();
	    for (char c : chars) {
	        if (Character.isLetter(c)) {
	            return true;
	        }
	    }
	    return false;
	}
	/**
	 * convert.
	 */
	@Override
	public String infixToPostfix(String expression) {
		expression = expression.trim().replaceAll(" +", " ");
		if (expression.length() <= 2) {
			throw new RuntimeException();
		}
		String[] a = expression.split("\\s");
		int z = a.length;
		final int q = 1000000;
		String[] wor = new String[q];
		for (int i = 0, j = 0; i < a.length; i++, j++) {
			if (a[i].length() > 1 && (a[i].contains("/")
|| a[i].contains("*") || a[i].contains("-")
				|| a[i].contains("+"))) {
		String[] h = new String[a[i].length()];
				h = a[i].split("(?!^)");
				for (int y = j, l = 0;
	l < a[i].length(); y++, l++) {
					wor[y] = h[l];
					z++;
				}
				j = j + a[i].length();
				z--;
			} else {
				wor[j] = a[i];
			}
		}
		String[] word =  Arrays.copyOf(wor, z);
		//print array of expression
		for (int m = 0, n = 1; m < (word.length - 1)
				&& n < word.length; m++, n++) {
	if (word[m].contains("/") || word[m].contains("*")
|| word[m].contains("-")
|| word[m].contains("+")) {
				check++;
			}
	if (word[n].contains("/") || word[n].contains("*")
|| word[n].contains("-") || word[n].contains("+")) {
				check++;
			}
			if (check == 2) {
				throw new RuntimeException();
				}
			check = 0;
		}
		if (word.length <= 2
				&& expression.length() != 0) {
			throw new RuntimeException();
		}
if (word[word.length - 1].contains("*")
		|| word[word.length - 1].contains("/")
|| word[word.length - 1].contains("+")
|| word[word.length - 1].contains("-")) {
			throw new RuntimeException();
		}
		String prin = "";
		for (int n = 0; n < word.length; n++) {
			if (word[n].charAt(0) == '(') {
				   int  count = 0;
				   for (int i = word[n].length() - 1;
						   i >= 0; i--) {
				   if (word[n].charAt(i) == '(') {
				       count++;
				   }
				   }
				   flag2 = flag2 + count;
				   System.out.println(flag2);
				word[n] = word[n].replaceAll("\\(", "");
				prin = prin + word[n] + " ";
				flag = 1;
			} else if (word[n].charAt(word[n].length() - 1)
					== ')') {
				 int  count = 0;
				   for (int i = word[n].length() - 1;
						   i >= 0; i--) {
				   if (word[n].charAt(i) == ')') {
				       count++;
				   }
				   }
				   flag2 = flag2 - count;
				   System.out.println(flag2);
				word[n] = word[n].replaceAll("\\)", "");
				prin = prin + word[n] + " ";
				flag = 0;
				prin = prin + oper.pop() + " ";
			} else if (word[n].contains("+")) {
				if (oper.isEmpty() || flag == 1) {
					if (!oper.isEmpty()) {
				prin = prin + oper.pop() + " ";
					}
				oper.push("+");
				noSy++;
				} else {
					while (!oper.isEmpty()) {
					prin = prin + oper.pop() + " ";
					}
					oper.push("+");
					noSy++;
				}
			} else if (word[n].contains("-")) {
				if (oper.isEmpty() || flag == 1) {
				oper.push("-");
				noSy++;
				} else {
					while (!oper.isEmpty()) {
						prin = prin + oper.pop() + " ";
						}
					oper.push("-");
					noSy++;
				}
			} else if (word[n].contains("*")) {
				if (oper.isEmpty() || flag == 1) {
				oper.push("*");
				noSy++;
				} else {
					if (oper.peek() == "+"
							|| oper.peek() == "-") {
					oper.push("*");
					noSy++;
					} else {
						while (!oper.isEmpty()) {
					prin = prin + oper.pop() + " ";
							}
						oper.push("*");
						noSy++;
					}
				}
			} else if (word[n].contains("/")) {
				if (oper.isEmpty() || flag == 1) {
				oper.push("/");
				noSy++;
				} else {
					if (oper.peek() == "+"
							|| oper.peek() == "-") {
					oper.push("/");
					noSy++;
					} else {
						while (!oper.isEmpty()) {
					prin = prin + oper.pop() + " ";
							}
						oper.push("/");
						noSy++;
					}
				}
			} else {
				prin = prin + word[n] + " ";
				no++;
			}
		}
		while (!oper.isEmpty()) {
			prin = prin + oper.pop() + " ";
		}
		if (flag == 1) {
			throw new RuntimeException();
		} else if (flag == 0 && flag2 != 0) {
			throw new RuntimeException();
		}
		prin = (String) prin.substring(0,
				prin.length() - 1);
		return prin;
	}
	/**
	 * evaluate.
	 */
	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		expression = expression.trim().replaceAll(" +", " ");
		String[] a = expression.split("\\s");
		if (expression.length() == 1) {
			return 0;
		}
		int z = a.length;
		final int q = 1000000;
		String[] wor = new String[q];
		for (int i = 0, j = 0; i < a.length; i++, j++) {
			if (a[i].length() > 1 && (a[i].contains("/")
					|| a[i].contains("*")
					|| a[i].contains("-")
					|| a[i].contains("+"))) {
				String[] h = new String[a[i].length()];
				h = a[i].split("(?!^)");
				for (int y = j, l = 0; l < a[i].length();
						y++, l++) {
					wor[y] = h[l];
					z++;
				}
				j = j + a[i].length();
				z--;
			} else {
				wor[j] = a[i];
			}
		}
		String[] word =  Arrays.copyOf(wor, z);
		if (word.length == 2) {
			if (word[0].contains("/")
					|| word[0].contains("*")
					|| word[0].contains("-")
					|| word[0].contains("+")) {
			return 0;
			}
			if (word[1].contains("/")
					|| word[1].contains("*")
					|| word[1].contains("-")
					|| word[1].contains("+")) {
			return 0;
			}
			}
		if (word.length == 2) {
			throw new RuntimeException();
		}
		if (isAlpha(expression)) {
			throw new RuntimeException();
		}
		for (int m = 0; m < word.length; m++) {
		if (word[m].contains("+")) {
			Object l = letter.pop();
			String p = l.toString();
			int i = Integer.parseInt(p);
			Object l2 = letter.pop();
			String p2 = l2.toString();
			int j = Integer.parseInt(p2);
			int k = i + j;
			Object x = (int) k;
			letter.push(x);
		} else if (word[m].contains("-")) {
			Object l = letter.pop();
			String p = l.toString();
			int i = Integer.parseInt(p);
			Object l2 = letter.pop();
			String p2 = l2.toString();
			int j = Integer.parseInt(p2);
			int k = j - i;
			Object x = (int) k;
			letter.push(x);
		} else if (word[m].contains("*")) {
			Object l = letter.pop();
			String p = l.toString();
			int i = Integer.parseInt(p);
			Object l2 = letter.pop();
			String p2 = l2.toString();
			int j = Integer.parseInt(p2);
			int k = i * j;
			Object x = Integer.toString(k);
			letter.push(x);
			System.out.println(x);
		} else if (word[m].contains("/")) {
			Object l = letter.pop();
			String p = l.toString();
			int i = Integer.parseInt(p);
			Object l2 = letter.pop();
			String p2 = l2.toString();
			int j = Integer.parseInt(p2);
			int k = j / i;
			Object x = (int) k;
			letter.push(x);
		} else if (word[m].matches("\\d+")) {
			letter.push(word[m]);
		} else {
			return 0;
		}
		}
		Object l = letter.peek();
		String p = l.toString();
		int f = Integer.parseInt(p);
		final int w = -2;
		if (f == w) {
			return 0;
		}
		return f;
	}
}
