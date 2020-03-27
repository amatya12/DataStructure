import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Controller extends JFrame
{
	private JLabel statusbar;

	    public Controller() {

	        initUI();
	    }

	    private void initUI() {

	        statusbar = new JLabel("");
	        add(statusbar, BorderLayout.SOUTH);

	        add(new View(statusbar));

	        setResizable(false);
	        pack();

	        setTitle("Minesweeper");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	   
}
