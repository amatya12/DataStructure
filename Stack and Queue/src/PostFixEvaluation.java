import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class PostFixEvaluation {
	public static void main(String[] args) {
		BalancedParenthesis BP = new BalancedParenthesis();
		InfixToPostFix itpf = new InfixToPostFix();
		try {
			FileInputStream f;
			DataInputStream in;

			boolean looping;
			String line;
			int j, len;

			f = new FileInputStream("ArithmeticExpression.txt");
			in = new DataInputStream(f);

			looping = true;
			while (looping) {
				/* Get a line of input from the file. */
				if (null == (line = in.readLine())) {
					looping = false;
					/* Close and free up system resource. */
					in.close();
				} else {
					System.out.println("The expression is " + line);
					if (BP.isBalanced(line)) {
						String postFixEquation = itpf.infixToPostFix(line);
						System.out.println(Evaluating(postFixEquation));
						System.out.println();
					} else {
						System.out.println("It is not balanced");
						System.out.println();
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error " + e);
		}

	}

	public static double Evaluating(String postFixExpression) {
		Stack<Double> os = new Stack<>();
		char[] ch = postFixExpression.toCharArray();
		for (int i = 0; i < postFixExpression.length(); i++) {

			if (Character.isDigit(ch[i])) {
				os.push((double) ch[i] - '0');

			} else {
				double variable1 = os.pop();
				double variable2 = os.pop();
				switch (ch[i]) {
				case '+':
					os.push(variable1 + variable2);
					break;
				case '-':
					os.push(variable2 - variable1);
					break;
				case '*':
					os.push(variable2 * variable1);
					break;
				case '/':
					os.push(variable2 / variable1);
					break;
				}
			}
		}
		return os.pop();

	}

}
