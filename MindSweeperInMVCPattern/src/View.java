import java.awt.Graphics;
import javax.swing.JLabel;

public class View extends Model{

	 public View(JLabel statusbar) {
		super(statusbar);
		
	}

	public void paintComponent(Graphics g) {

	        int uncover = 0;

	        for (int i = 0; i < N_ROWS; i++) {

	            for (int j = 0; j < N_COLS; j++) {

	                int cell = field[(i * N_COLS) + j];

	                if (inGame && cell == MINE_CELL) {

	                    inGame = false;
	                }

	                if (!inGame) {

	                    if (cell == COVERED_MINE_CELL) {
	                        cell = DRAW_MINE;
	                    } else if (cell == MARKED_MINE_CELL) {
	                        cell = DRAW_MARK;
	                    } else if (cell > COVERED_MINE_CELL) {
	                        cell = DRAW_WRONG_MARK;
	                    } else if (cell > MINE_CELL) {
	                        cell = DRAW_COVER;
	                    }

	                } else {

	                    if (cell > COVERED_MINE_CELL) {
	                        cell = DRAW_MARK;
	                    } else if (cell > MINE_CELL) {
	                        cell = DRAW_COVER;
	                        uncover++;
	                    }
	                }

	                g.drawImage(img[cell], (j * CELL_SIZE),
	                        (i * CELL_SIZE), this);
	            }
	        }

	        if (uncover == 0 && inGame) {

	            inGame = false;
	            statusbar.setText("Game won");

	        } else if (!inGame) {

	            statusbar.setText("Game lost");
	        }
	    }
	
	
	
}
