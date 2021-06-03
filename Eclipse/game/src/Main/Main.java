package Main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

<<<<<<< HEAD
public class Main {
	public static void main(String[] args) {
		swing interfaces = new swing();
		Game game = new Game();
		game.play();
	}
=======
import Grap_int.swing;

public class Main extends JFrame {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
>>>>>>> Tendzin

      	SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new swing();
                  }
            });
	}
}

