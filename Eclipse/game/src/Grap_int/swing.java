package Grap_int;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;

public class swing extends JFrame {

   /**
    * * Initializes the frame of the game and set up ths frame on the Main menu
    */
   public swing() {
      super("Domi-nation");

      JFrame frame = new JFrame("Domi-nation");
      
      // Get the height and the width of the screen
      Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      int height = (int)dimension.getHeight() + 100;
      int width  = (int)dimension.getWidth() + 100;

      // set the size of the frame
      frame.setSize(new Dimension(width,height));
      // Center the frame to the center of the screen
      frame.setLocationRelativeTo(null);

      // Banner is the 
      JLabel banner = new JLabel();
      banner.setIcon(new ImageIcon("Image/banner.jpg"));
      frame.add(banner, BorderLayout.NORTH);

      JLabel image = new JLabel();
      image.setIcon(new ImageIcon("Image/kingdomino.jpg"));
      frame.add(image, BorderLayout.LINE_START);

      frame.add(panelLeft(), BorderLayout.LINE_END);

      /**
       * * setDefaultCloseOperation 
       * ? DISPOSE_ON_CLOSE : close only the window and not all swing windows
       * * setVisible
       * ? True : display the window
       */
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      frame.setVisible(true);
   }

   /**
    * Create the panel for the main button
    * The layout of the panel is GrisLayout
    * @param none
    * @return JPanel : panelLeft 
    */
   private JPanel panelLeft() {

      //Create the pannel
      JPanel panelLeft = new JPanel();
      panelLeft.setLayout( new GridLayout(6, 1, 0, 50) );

      //Some variable use in this pannel
      int color = 0x6aa84f;
      int widthBtn = 150;
      int heightbtn = 50;

      panelLeft.setPreferredSize( new Dimension( 170, 0 ) );
      panelLeft.setBackground(new Color( color ) );

      JLabel nothing = new JLabel();
      panelLeft.add(nothing);

      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      
      JButton newGameBtn = new JButton( "Nouvelle partie" );
      newGameBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );

      panel1.add(newGameBtn);
      panelLeft.add(panel1);

      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );

      JButton soundBtn = new JButton( "Desactiver le son" );
      soundBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );

      panel2.add(soundBtn);
      panelLeft.add(panel2);

      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );

      JButton leave = new JButton( "Quitter" );
      leave.setPreferredSize( new Dimension(widthBtn, heightbtn) );

      panel3.add(leave);
      panelLeft.add(panel3);

      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      JButton credits = new JButton( "Crédits" );
      credits.setPreferredSize( new Dimension(widthBtn, heightbtn) );

      panel4.add(credits);
      panelLeft.add(panel4);

      return panelLeft;
   }

   public static void main(String [] args) throws Exception{
      UIManager.setLookAndFeel(new NimbusLookAndFeel());

      swing frame = new swing();
   }
}