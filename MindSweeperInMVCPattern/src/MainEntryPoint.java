import java.awt.EventQueue;

public class MainEntryPoint {
	
	 public static void main(String[] args) {

	        EventQueue.invokeLater(() -> {

	            Controller ex = new Controller();
	            ex.setVisible(true);
	        });
	    }

}
