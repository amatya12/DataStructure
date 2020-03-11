
public class Model {
	private int X = 1;
	private int O = -1;
	int[][] matrix = new int[5][5];
	private boolean retVal = false;

	public int getX() {
		return X;
	}

	public int getO() {
		return O;
	}

	public boolean hasWon() {

		// Check for horizontal win
		for (int row = 0; row < matrix.length; row++) {
			int sum = 0;
			for (int col = 0; col < matrix[0].length; col++) {
				sum += matrix[row][col];
			}
			// Check to see if the sum of that row was 5 or -5, a win...
			if (sum == 5) {
				System.out.println("X wins.");
				retVal = true;
			} else if (sum == -5) {
				System.out.println("O wins.");
				retVal = true;
			}
		}

		// Check for vertical win
		for (int col = 0; col < matrix[0].length; col++) {
			int sum = 0;
			for (int row = 0; row < matrix.length; row++) {
				sum += matrix[row][col];
			}
			// Check to see if the sum of that column was 5 or -5, a win...
			if (sum == 5) {
				System.out.println("X wins.");
				retVal = true;
			} else if (sum == -5) {
				System.out.println("O wins.");
				retVal = true;
			}
		}

		// Check for diagonal win
		if ((matrix[0][0] + matrix[1][1] + matrix[2][2] + matrix[3][3] + matrix[4][4] == 5)) {
			System.out.println("X wins.");
			retVal = true;
		} else if ((matrix[0][0] + matrix[1][1] + matrix[2][2] + matrix[3][3] + matrix[4][4]) == -5) {
			System.out.println("O wins.");
			retVal = true;
		}
		if ((matrix[0][4] + matrix[3][1] + matrix[4][0] + matrix[1][3] + matrix[2][2]) == 5) {
			System.out.println("X wins.");
			retVal = true;
		} else if ((matrix[0][4] + matrix[3][1] + matrix[4][0] + matrix[1][3] + matrix[2][2]) == -5) {
			System.out.println("O wins.");
			retVal = true;
		}

		// Check for cat game
		boolean foundSpace = false;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0)
					foundSpace = true;
			}
		}
		if (foundSpace == false) {
			System.out.println("Ends in tie.");
			retVal = true;
		}

		return retVal;

	}

	


}
