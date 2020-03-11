
public class View {
	Model model = new Model();

	public void printBoard(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				// Uses the "global" constants to print out appropriate letter.
				if (matrix[row][col] == model.getX())
					System.out.print("X ");
				else if (matrix[row][col] == model.getO())
					System.out.print("O ");
				else
					System.out.print(". ");
			}
			// Goes to new line after printing each row
			System.out.println("");
		}
	}

}
