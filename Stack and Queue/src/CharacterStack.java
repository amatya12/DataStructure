public class CharacterStack {
	char[] stack = new char[99];
	int top = -1;
	

	public static void main(String[] args) {
		CharacterStack cs = new CharacterStack();
		String String1 = "bob";
		cs.pushingAllCharacter(String1);
		cs.poppingAllCharacter();
		String String2 = "tae nomel";
		cs.pushingAllCharacter(String2);
		cs.poppingAllCharacter();
		String String3 = "snoino dna revil etah I";
		cs.pushingAllCharacter(String3);
		cs.poppingAllCharacter();
		String String4 = "SELUR LOBOC";
		cs.pushingAllCharacter(String4);
		cs.poppingAllCharacter();

	
		
		
		}

	

	public void pushingAllCharacter(String variable) {
		
		char[] array = variable.toCharArray();

		for (int i = 0; i < array.length; i++) {
			push(array[i]);
		}
	}
	
	public void poppingAllCharacter() {
		
		while(!isEmpty()) {
			System.out.print(pop());
			}
		System.out.println();
	}

	public void push(char variable) {

		if (top == stack.length - 1) {
			System.out.println("stack is full");
		} else {
			top += 1;

			stack[top] = variable;

		}
	}

	public char pop() {

		if (top == -1) {

			throw new RuntimeException("stack is empty");
		} else {
			char popVariable = stack[top];
			top = top - 1;
			return popVariable;
		}

	}

	public char peek() {
		if (top == -1) {

			throw new RuntimeException("peeking an empty stack");
		} else {
			char popVariable = stack[top];

			return popVariable;
		}

	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public String tostring() {
		String result = "";
		for (int i = top; i >= 0; i--) {
			
			result += stack[i] + "\n";

		}
		return "The items in the stack are: " + "\n" + result;
	}

}
