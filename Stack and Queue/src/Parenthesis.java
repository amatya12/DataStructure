import java.util.Arrays;

public class Parenthesis {

	public static void main(String[] args) {
		Parenthesis p = new Parenthesis();
		p.initialisingArray("[(])");
	}

	public int openingArraySize(String ch) {

		char[] expression = ch.toCharArray();
		int count = 0;
		for (int i = 0; i < expression.length; i++) {

			if (expression[i] == '(' || expression[i] == '{' || expression[i] == '[') {
				count++;
			}

		}
		return count;
	}

	public int closingArraySize(String ch) {
		char[] expression = ch.toCharArray();
		int count = 0;
		for (int i = 0; i < expression.length; i++) {

			if (expression[i] == ')' || expression[i] == '}' || expression[i] == ']') {
				count++;
			}

		}
		return count;
	}

	public char[] reverse(char[] variable) {
		char[] reversedCharacterArray = new char[variable.length];
		for (int i = 0; i < variable.length; i++) {
			reversedCharacterArray[i] = variable[variable.length - 1 - i];
		}
		return reversedCharacterArray;
	}

	public boolean CheckOfPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	public void initialisingArray(String expression) {
		char[] characterArray1 = new char[openingArraySize(expression)];
		char[] characterArray2 = new char[closingArraySize(expression)];

		char[] ch1 = expression.toCharArray();
		char[] ch2 = expression.toCharArray();
		int j = 0;
		int k = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (ch1[i] == '(' || ch1[i] == '{' || ch1[i] == '[') {
				characterArray1[j] = ch1[i];
				j++;

			}
			if (ch2[i] == ')' || ch2[i] == '}' || ch2[i] == ']') {
				characterArray2[k] = ch2[i];
				k++;

			}
		}
		char[] reversedArray = reverse(characterArray2);
		if ((characterArray1.length == characterArray2.length) == true) {

			for (int i = 0; i < characterArray1.length; i++) {
				if (CheckOfPair(characterArray1[i], reversedArray[i])) {
					System.out.println(characterArray1[i] + " is balanced");

				}else {
					System.out.println(characterArray1[i] + " is not balanced");
				}
			}
			/*
			 * for(int i = 0 ; i< characterArray1.length;i++) {
			 * if(CheckOfPair(characterArray1[i], reversedArray[i])) {
			 * System.out.println("Balanced");
			 */

		} else {
			System.out.println("this is not balanced");
		}
	}
}
