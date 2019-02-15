
public class InfixToPostFix {
	public static void main(String[] args) {
		String result = infixToPostFix("((2+3)*((8*9)/2)");
		System.out.print(result);

	}

	static int precedence(char variable) {
		switch (variable) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;

		}
		return -1;
	}

	public static String infixToPostFix(String expression) {
		String result = "";
		CharacterStack cs = new CharacterStack();

		for (int i = 0; i < expression.length(); ++i) {
			char[] ch = expression.toCharArray();
			if (Character.isLetterOrDigit(ch[i])) {
				result += ch[i];
			} else if (ch[i] == '(') {
				cs.push(ch[i]);
			} else if (ch[i] == ')') {
				while ((!cs.isEmpty()) && cs.peek() != '(') {
					result += cs.pop();
				}
				if (!cs.isEmpty() && cs.peek() != '(')
					throw new RuntimeException("Invalid expression");
				else if (!cs.isEmpty())
					cs.pop();

			} else {

				while ((!cs.isEmpty()) && (precedence(ch[i]) <= precedence(cs.peek()))) {
					result += cs.pop();
				}
				cs.push(ch[i]);

			}
		}
		while (!(cs.isEmpty())) {
			result += cs.pop();

		}
		return result;
	}

}
