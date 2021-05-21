package Grap_int;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import TextPrompt.TextPrompt;

public class swing extends JFrame implements Action {
   // Global variable
   private static JLabel banner;
   private static JLabel background;
   public static Integer numberPlayers;

   // Define all button in attribut for more efficiency in the actionListener
   private JButton newGameBtn = new JButton( "Nouvelle partie" );
   private JButton soundBtn = new JButton( "Desactiver le son" );
   private JButton leave = new JButton( "Quitter" );
   private JButton credits = new JButton( "Crédits" );
   private JButton backToStartMenu = new JButton("Retour");
   private JButton twoPlayersBtn = new JButton( "2 joueurs" );
   private JButton threePlayersBtn = new JButton( "3 joueurs" );
   private JButton fourPlayersBtn = new JButton( "4 joueurs" );
   private JButton backToSelection = new JButton( "Retour selection" );

   // Define all panel
   private static JPanel panelNorth;
   private static JPanel panelSouth;
   private static JPanel panelEast;
   private static JPanel panelWest;
   private static JPanel panelCenter;

   /**
    * * Initializes the frame of the game and set up ths frame on the start menu
    */
   static JFrame frame = new JFrame("Domi-nation");
   public swing() {
      super("Domi-nation");
      
      // Get the height and the width of the screen
      Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
      int height = (int)dimension.getHeight() + 100;
      int width  = (int)dimension.getWidth() + 100;

      // set the size of the frame
      frame.setSize(new Dimension(width,height));
      // Center the frame to the center of the screen
      frame.setLocationRelativeTo(null);

      /**
       * * Start with the start menu
       * * Change this to change the start
       * ! Don't forget to put startMenu() at the end of your work
       * ? startMenu();
       * ? newGameMenu();
       */
      startMenu();

      frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH ); 
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      frame.setVisible(true);
   }

   /**
    * Create the banner and image background for the start menu.
    * Add the banner, the background and the panel to the frame.
    * @param none
    * @return none
    */
   private void startMenu() {

      // Set the image for the banner
      banner = new JLabel();
      banner.setIcon(new ImageIcon("Image/banner.jpg"));

      // Set the image for the background
      background = new JLabel();
      background.setIcon(new ImageIcon("Image/kingdomino.jpg"));

      panelEast = new JPanel();
      // Add the different content into the frame
      frame.add(banner, BorderLayout.NORTH);
      frame.add(background, BorderLayout.LINE_START);
      frame.add(panelEastForStartMenu(panelEast), BorderLayout.LINE_END);
   }

   /**
    * Create the panel for the start menu.
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel panelEastForStartMenu(JPanel panelEast) {

      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 6 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 5
       * * Each row is a panel and this panel contain the content
       */
      // panelEast = new JPanel();
      panelEast.setLayout( new GridLayout(6, 1, 0, 50) );
      panelEast.setPreferredSize( new Dimension( 170, 0 ) );

      //Some variable use in this panel
      int color = 0xf1c232;
      int widthBtn = 150;
      int heightbtn = 50;

      panelEast.setBackground(new Color( color ) );

      // Create all panel
      JLabel nothing = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      // Create all button
      newGameBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      newGameBtn.setFont( new Font ("Arial", Font.PLAIN, 18));
      
      soundBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      soundBtn.setFont( new Font ("Arial", Font.PLAIN, 16));
      
      leave.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      leave.setFont( new Font ("Arial", Font.PLAIN, 25));
      
      credits.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      credits.setFont( new Font ("Arial", Font.PLAIN, 25));

      //Listener
      leave.addActionListener(e -> {
         frame.dispose();
      });
      newGameBtn.addActionListener(this);

      // Add all buttons into there panel
      panel1.add(newGameBtn);
      panel2.add(soundBtn);
      panel3.add(leave);
      panel4.add(credits);

      // Add all panels into the main panel
      panelEast.add(nothing);
      panelEast.add(panel1);
      panelEast.add(panel2);
      panelEast.add(panel3);
      panelEast.add(panel4);

      return panelEast;
   }

   /**
    * Add all panels to the frame for the new game menu.
    * ! Not all panels is make
    * @param none
    * @return none
    */
   private void newGameMenu() {

      // Add the different content into the frame
      frame.add(panelNorthForNewGameMenu(), BorderLayout.NORTH);
      frame.add(panelWestForNewGameMenu(), BorderLayout.LINE_START);
      // frame.add(panelLeftForStarMenu(), BorderLayout.LINE_END);
      // frame.add(panelSouthForNewGameMenu()), BorderLayout.LINE_END);
   }

   /**
    * Create the north panel for the new game menu.
    * The layout of the panel is a BorderLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel panelNorthForNewGameMenu() {
      panelNorth = new JPanel();
      
      panelNorth.setPreferredSize( new Dimension( 0, 60 ) );
      panelNorth.setBackground(new Color( 0xd4a373 ));

      JLabel textNorth = new JLabel("Création de partie", SwingConstants.CENTER);
      textNorth.setVerticalAlignment(SwingConstants.CENTER);
      textNorth.setFont( new Font ("Arial", Font.PLAIN, 30));
      textNorth.setPreferredSize(new Dimension(1100, 50));
      
      backToStartMenu.setPreferredSize(new Dimension(100,50));
      backToStartMenu.setFont( new Font ("Arial", Font.PLAIN, 20));
      backToStartMenu.addActionListener(this);

      panelNorth.add(textNorth, BorderLayout.CENTER);
      panelNorth.add(backToStartMenu, BorderLayout.LINE_END);

      return panelNorth;
   }

   /**
    * Create the west panel for the new game menu.
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel panelWestForNewGameMenu() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 6 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 5
       * * Each row is a panel and this panel contain the content
       */
      panelWest = new JPanel();
      panelWest.setLayout( new GridLayout(6, 1, 0, 50) );
      panelWest.setPreferredSize( new Dimension( 200, 0 ) );

      //Some variable use in this panel
      int color = 0xf6b26b;
      int widthBtn = 170;
      int heightbtn = 50;

      panelWest.setBackground(new Color( 0xf6b26b ));

      /**
       * * This part create the different panel and button
       */
      // Create all panel
      JLabel nothing = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( "Sélectionner le", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 20) );
      selectText1.setFont( new Font ("Arial", Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "nombre de joueur :", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font ("Arial", Font.PLAIN, 22));
      
      twoPlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      twoPlayersBtn.setFont( new Font ("Arial", Font.PLAIN, 22));
      
      threePlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      threePlayersBtn.setFont( new Font ("Arial", Font.PLAIN, 22));
      
      fourPlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      fourPlayersBtn.setFont( new Font ("Arial", Font.PLAIN, 22));

      twoPlayersBtn.addActionListener(this);
      threePlayersBtn.addActionListener(this);
      fourPlayersBtn.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(twoPlayersBtn);
      panel3.add(threePlayersBtn);
      panel4.add(fourPlayersBtn);

      // Add all panel into the main panel
      panelWest.add(nothing);
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);

      return panelWest;
   }

   /**
    * Create the west panel for the new game menu.
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   /* private JPanel panelSouthForNewGameMenu() {
      
   } */

   /**
    * Create the west panel for the new game menu for 2 players selection.
    * It's here the players is create
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel twoPlayers() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 7 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 4 and 7
       * * Each row is a panel and this panel contain the content
       */
      panelWest = new JPanel();
      panelWest.setLayout( new GridLayout(7, 1, 0, 50) );
      panelWest.setPreferredSize( new Dimension( 200, 0 ) );

      //Some variable use in this panel
      int color = 0xf6b26b;
      int widthBtn = 170;
      int heightbtn = 50;

      panelWest.setBackground(new Color( 0xf6b26b ));

      // Create all panel
      JLabel nothing1 = new JLabel();
      JLabel nothing2 = new JLabel();
      JLabel nothing3 = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( "2 joueurs", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 20) );
      selectText1.setFont( new Font ("Arial", Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "sélectionné", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font ("Arial", Font.PLAIN, 22));

      JTextField playerOne = new JTextField();
      playerOne.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerOne.setFont( new Font ("Arial", Font.PLAIN, 18));
      TextPrompt playerOnePrompt = new TextPrompt("Premier joueur", playerOne);

      JTextField playerTwo = new JTextField();
      playerTwo.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerTwo.setFont( new Font ("Arial", Font.PLAIN, 18));
      TextPrompt playerTwoPrompt = new TextPrompt("Deuxième joueur", playerTwo);
      
      backToSelection.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      backToSelection.setFont( new Font ("Arial", Font.PLAIN, 18));

      // Listener
      playerOne.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               /**
                * * Create a player, when enter is press
                * * Put here the code to create player
                * todo Check if the player is create
                * todo if is create update him
                * todo else create him
                */
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            
         }

         @Override
         public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
         }
      });

      playerTwo.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               /**
                * * Put here the code to create player
                * todo Check if the player is create
                * todo if is create update him
                * todo else create him
                */
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
            
         }

         @Override
         public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
         }
      });
      backToSelection.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(playerOne);
      panel3.add(playerTwo);
      panel4.add(backToSelection);

      // Add all panel into the main panel
      panelWest.add(nothing1);
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(nothing2);
      panelWest.add(nothing3);
      panelWest.add(panel4);

      return panelWest;
   }

   /**
    * ! The three and four players panel is not done
    * todo Create function for 3 and 4 players
    */
   private JPanel threePlayers() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 6 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 5
       * * Each row is a panel and this panel contain the content
       */
      panelWest = new JPanel();
      panelWest.setLayout( new GridLayout(6, 1, 0, 50) );
      panelWest.setPreferredSize( new Dimension( 200, 0 ) );

      //Some variable use in this panel
      int color = 0xf6b26b;
      int widthBtn = 170;
      int heightbtn = 50;

      panelWest.setBackground(new Color( 0xf6b26b ));

      /**
       * * This part create the different panel and button
       */
      // Create all panel
      JLabel nothing = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( "Sélectionner le", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 20) );
      selectText1.setFont( new Font ("Arial", Font.PLAIN, 22));
      JLabel selectText2 = new JLabel( "nombre de joueur :", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton twoPlayers = new JButton( "2 joueurs" );
      twoPlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      twoPlayers.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton threePlayers = new JButton( "3 joueurs" );
      threePlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      threePlayers.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton fourPlayers = new JButton( "4 joueurs" );
      fourPlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      fourPlayers.setFont( new Font ("Arial", Font.PLAIN, 22));

      twoPlayers.addActionListener(this);
      threePlayers.addActionListener(this);
      fourPlayers.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(twoPlayers);
      panel3.add(threePlayers);
      panel4.add(fourPlayers);

      // Add all panel into the main panel
      panelWest.add(nothing);
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);

      return panelWest;
   }

   private JPanel fourPlayers() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 6 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 5
       * * Each row is a panel and this panel contain the content
       */
      panelWest = new JPanel();
      panelWest.setLayout( new GridLayout(6, 1, 0, 50) );
      panelWest.setPreferredSize( new Dimension( 200, 0 ) );

      //Some variable use in this panel
      int color = 0xf6b26b;
      int widthBtn = 170;
      int heightbtn = 50;

      panelWest.setBackground(new Color( 0xf6b26b ));

      /**
       * * This part create the different panel and button
       */
      // Create all panel
      JLabel nothing = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( "Sélectionner le", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 20) );
      selectText1.setFont( new Font ("Arial", Font.PLAIN, 22));
      JLabel selectText2 = new JLabel( "nombre de joueur :", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton twoPlayers = new JButton( "2 joueurs" );
      twoPlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      twoPlayers.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton threePlayers = new JButton( "3 joueurs" );
      threePlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      threePlayers.setFont( new Font ("Arial", Font.PLAIN, 22));
      JButton fourPlayers = new JButton( "4 joueurs" );
      fourPlayers.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      fourPlayers.setFont( new Font ("Arial", Font.PLAIN, 22));

      twoPlayers.addActionListener(this);
      threePlayers.addActionListener(this);
      fourPlayers.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(twoPlayers);
      panel3.add(threePlayers);
      panel4.add(fourPlayers);

      // Add all panel into the main panel
      panelWest.add(nothing);
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);

      return panelWest;
   }

   private void cleanJPanel() {
      if (panelNorth != null) {
         panelNorth = null;
      }
      if (panelSouth != null) {
         panelSouth = null;
      }
      if (panelEast != null) {
         panelEast = null;
      }
      if (panelWest != null) {
         panelWest = null;
      }
      if (panelCenter != null) {
         panelCenter = null;
      }
      if (banner != null) {
         banner = null;
      }
      if (background != null) {
         background = null;
      }
   }

   // All listener for button/action
   @Override
   public void actionPerformed(ActionEvent e) {
      if ( e.getSource() == backToStartMenu ) {
         frame.remove(panelNorth);
         frame.remove(panelWest);
         cleanJPanel();
         startMenu();
      } else if ( e.getSource() == newGameBtn ) {
         numberPlayers = 0;
         frame.remove(panelEast);
         frame.remove(banner);
         frame.remove(background);
         cleanJPanel();
         newGameMenu();
      } else if ( e.getSource() == twoPlayersBtn ) {
         numberPlayers = 2;
         System.out.println(numberPlayers);
         frame.remove(panelWest);
         if (panelWest != null) {
            panelWest = null;
         }
         frame.add(twoPlayers(), BorderLayout.LINE_START);
      } else if ( e.getSource() == threePlayersBtn ) {
         numberPlayers = 3;
         System.out.println(numberPlayers);
         frame.remove(panelWest);
         if (panelWest != null) {
            panelWest = null;
         }
         frame.add(threePlayers(), BorderLayout.LINE_START);
      } else if ( e.getSource() == fourPlayersBtn ) {
         numberPlayers = 4;
         System.out.println(numberPlayers);
         frame.remove(panelWest);
         if (panelWest != null) {
            panelWest = null;
         }
         frame.add(fourPlayers(), BorderLayout.LINE_START);
      } else if ( e.getSource() == backToSelection ) {
         /**
          * todo destroy player when he back to the selection of the number of players
          */
         numberPlayers = 0;
         System.out.println(numberPlayers);
         frame.remove(panelWest);
         if (panelWest != null) {
            panelWest = null;
         }
         frame.add(panelWestForNewGameMenu(), BorderLayout.LINE_START);
      }
      frame.validate();
      frame.repaint();
   }

   // Don't check this part
   @Override
   public Object getValue(String key) {
      return null;
   }

   @Override
   public void putValue(String key, Object value) {
      
   }

   public static void main(String [] args) throws Exception{
      UIManager.setLookAndFeel(new NimbusLookAndFeel());

      SwingUtilities.invokeLater(new Runnable()
      {
         @Override
         public void run()
         {
               new swing();
         }
      });
   }
}