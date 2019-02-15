import java.util.Scanner;
public class BalancedParenthesis {
	
	
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);	

		System.out.println("Enter the expression: ");
		String expression = "(3+2)+{4+5}";
		if(isBalanced(expression)) {
			System.out.println("Balanced");
		}
		else {	
			System.out.println("Not balanced");
		}
	}
	public static  boolean CheckOfPair(char character1 , char character2) {
		if(character1 == '(' && character2 == ')')
			return true;
		else if(character1 =='{' && character2== '}')
			return true;
		else if(character1=='[' && character2==']')
			return true;
		else
			return false;
	}
	public static boolean isBalanced(String expression) {
		char[] arithmeticExpression = expression.toCharArray();
		CharacterStack cs = new CharacterStack();
		for(int i = 0 ; i < arithmeticExpression.length ; i++) {
			if(arithmeticExpression[i]=='(' || arithmeticExpression[i]== '{' || arithmeticExpression[i]=='[') {
				cs.push(arithmeticExpression[i]);
			}
			if(arithmeticExpression[i]==')' || arithmeticExpression[i]== '}' || arithmeticExpression[i]==']') {
				if(cs.isEmpty()) {
					return false;
				}
				else if(!(CheckOfPair(cs.pop() , arithmeticExpression[i]))) {
					return false;
				}
			}
		}
		if(cs.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
