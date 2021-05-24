package Main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Grap_int.swing;

public class Main extends JFrame {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());

      	SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new swing();
                  }
            });
	}
}

