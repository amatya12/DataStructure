import java.util.Scanner;

public class Controller {
	private Model model;
	private View view;

	Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		UserChoice();
	}

	public void UserChoice() {
		Scanner input = new Scanner(System.in);

		while (model.hasWon() == false) {

			System.out.print("X, enter row: ");
			int row = input.nextInt();
			System.out.print("X, enter column: ");
			int col = input.nextInt();

			if (model.matrix[row][col] == 0)
				model.matrix[row][col] = model.getX();

			view.printBoard(model.matrix);

			// Check to see if X's move won the game. If so, break out of game loop
			if (model.hasWon() == true)
				break;

			// Get the O player input and make the change if not taken.

			System.out.print("O, enter row: ");
			row = input.nextInt();
			System.out.print("O, enter column: ");
			col = input.nextInt();
			if (model.matrix[row][col] == 0)
				model.matrix[row][col] = model.getO();
			view.printBoard(this.model.matrix);

		}

		System.out.println("Game over.");
	}

}
