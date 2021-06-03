package Grap_int;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import TextPrompt.TextPrompt;

public class swing extends JFrame implements Action {
   // Global variable
   private static JLabel banner;
   private static JLabel background;
   private static String  police = "Century Gothic";
   public static Integer numberPlayers;
   public static Integer numberDominos;
   public static Integer sizeKingdom;

   // Define Option
   public static int dynastie = 0;
   public static int harmonie = 0;
   public static int middleEmpire = 0;
   public static int theGrandDuel = 0;
   public static int displayTime = 0;
   public static int displayTimeLimited = 0;

   // Define all button in attribut for more efficiency in the actionListener
   private JButton newGameBtn = new JButton( "Nouvelle partie" );
   private JButton soundBtn = new JButton( "Son activé" );
   private JButton leave = new JButton( "Quitter" );
   private JButton credits = new JButton( "Crédits" );
   private JButton backToStartMenu = new JButton("Retour");
   private JButton twoPlayersBtn = new JButton( "2 joueurs" );
   private JButton threePlayersBtn = new JButton( "3 joueurs" );
   private JButton fourPlayersBtn = new JButton( "4 joueurs" );
   private JButton backToSelection = new JButton( "Retour sélection" );
   private JRadioButton displayTimeBtn = new JRadioButton("Afficher le temps");
   private JRadioButton displayTimeLimitedBtn = new JRadioButton("Ajouter une limite de temps");
   private JCheckBox dynastieBtn = new JCheckBox("Dynastie");
   private JCheckBox harmonieBtn = new JCheckBox("Harmonie");
   private JCheckBox middleEmpireBtn = new JCheckBox("Empire du milieu");
   private JCheckBox theGrandDuelBtn = new JCheckBox("Le Grand Duel");
   private JButton launchGame = new JButton( "Lancer la partie" );

   // Define all panel
   private static JPanel panelNorth;
   private static JPanel panelSouth;
   private static JPanel panelEast;
   private static JPanel panelWest;
   private static JPanel panelCenter;

   // Initializes the frame of the game and set up ths frame on the start menu
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
      banner.setIcon(new ImageIcon("Image/banner.png"));

      // Set the image for the background
      background = new JLabel();
      background.setIcon(new ImageIcon("Image/kingdomino.jpg"));

      // Add the different content into the frame
      frame.add(banner, BorderLayout.NORTH);
      frame.add(background, BorderLayout.LINE_START);
      frame.add(panelEastForStartMenu(), BorderLayout.LINE_END);
   }

   /**
    * Create the panel for the start menu.
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel panelEastForStartMenu() {

      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 6 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 2 to 5
       * * Each row is a panel and this panel contain the content
       */
      panelEast = new JPanel();
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
      newGameBtn.setFont( new Font (police, Font.PLAIN, 16));
      
      soundBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      soundBtn.setFont( new Font (police, Font.PLAIN, 18));
      
      leave.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      leave.setFont( new Font (police, Font.PLAIN, 20));
      
      credits.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      credits.setFont( new Font (police, Font.PLAIN, 20));

      //Listener
      leave.addActionListener(e -> {
         frame.dispose();
      });
      newGameBtn.addActionListener(this);
      soundBtn.addActionListener(this);
      credits.addActionListener(this);

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
    * @param none
    * @return none
    */
   private void newGameMenu() {

      // Add the different content into the frame
      frame.add(panelNorthForNewGameMenu(), BorderLayout.NORTH);
      frame.add(panelWestForNewGameMenu(), BorderLayout.LINE_START);
      frame.add(panelCenterForNewGameMenu(), BorderLayout.CENTER);
      frame.add(panelSouthForNewGameMenu(0), BorderLayout.SOUTH);
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
      textNorth.setFont( new Font (police, Font.PLAIN, 30));
      textNorth.setPreferredSize(new Dimension(1100, 50));
      
      backToStartMenu.setPreferredSize(new Dimension(100,50));
      backToStartMenu.setFont( new Font (police, Font.PLAIN, 20));
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
      JLabel selectText1 = new JLabel( "Nombre de", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 20) );
      selectText1.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "joueurs :", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 28) );
      selectText2.setFont( new Font (police, Font.PLAIN, 22));
      
      twoPlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      twoPlayersBtn.setFont( new Font (police, Font.PLAIN, 22));
      
      threePlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      threePlayersBtn.setFont( new Font (police, Font.PLAIN, 22));
      
      fourPlayersBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      fourPlayersBtn.setFont( new Font (police, Font.PLAIN, 22));

      // Listener
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
       * * The button use the row 3 to 4 and 7
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
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );
      JPanel panel5 = new JPanel();
      panel5.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( numberPlayers +" joueurs", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 23) );
      selectText1.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER);
      selectText3.setPreferredSize( new Dimension(200, 20) );
      selectText3.setFont( new Font (police, Font.PLAIN, 20));

      JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER);
      selectText4.setPreferredSize( new Dimension(200, 23) );
      selectText4.setFont( new Font (police, Font.PLAIN, 20));

      JTextField playerOne = new JTextField();
      playerOne.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerOne.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerOnePrompt = new TextPrompt("Premier joueur", playerOne);

      JTextField playerTwo = new JTextField();
      playerTwo.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerTwo.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerTwoPrompt = new TextPrompt("Deuxième joueur", playerTwo);
      
      backToSelection.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      backToSelection.setFont( new Font (police, Font.PLAIN, 18));

      // Listener
      playerOne.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerOne.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerTwo.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerTwo.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerTwo.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });
      backToSelection.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(selectText3);
      panel2.add(selectText4);
      panel3.add(playerOne);
      panel4.add(playerTwo);
      panel5.add(backToSelection);

      // Add all panel into the main panel
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);
      panelWest.add(nothing1);
      panelWest.add(nothing2);
      panelWest.add(panel5);

      return panelWest;
   }
   
   /**
    * Create the west panel for the new game menu for 3 players selection.
    * It's here the players is create
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel threePlayers() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 7 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 3 to 5 and 7
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
      JLabel nothing2 = new JLabel();
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );
      JPanel panel5 = new JPanel();
      panel5.setBackground( new Color( color ) );
      JPanel panel6 = new JPanel();
      panel6.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( numberPlayers +" joueurs", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 23) );
      selectText1.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER);
      selectText3.setPreferredSize( new Dimension(200, 20) );
      selectText3.setFont( new Font (police, Font.PLAIN, 20));

      JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER);
      selectText4.setPreferredSize( new Dimension(200, 23) );
      selectText4.setFont( new Font (police, Font.PLAIN, 20));

      JTextField playerOne = new JTextField();
      playerOne.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerOne.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerOnePrompt = new TextPrompt("Premier joueur", playerOne);

      JTextField playerTwo = new JTextField();
      playerTwo.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerTwo.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerTwoPrompt = new TextPrompt("Deuxième joueur", playerTwo);

      JTextField playerThree = new JTextField();
      playerThree.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerThree.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerThreePrompt = new TextPrompt("Troisième joueur", playerThree);

      backToSelection.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      backToSelection.setFont( new Font (police, Font.PLAIN, 18));

      // Listener
      playerOne.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerOne.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerTwo.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerTwo.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerTwo.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerThree.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerThree.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerThree.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      backToSelection.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(selectText3);
      panel2.add(selectText4);
      panel3.add(playerOne);
      panel4.add(playerTwo);
      panel5.add(playerThree);
      panel6.add(backToSelection);

      // Add all panel into the main panel
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);
      panelWest.add(panel5);
      panelWest.add(nothing2);
      panelWest.add(panel6);

      return panelWest;
   }

   /**
    * Create the west panel for the new game menu for 4 players selection.
    * It's here the players is create
    * The layout of the panel is a GridLayout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel fourPlayers() {
      /**
       * * Set the panel
       * * The layout of the panel is a GridLayout.
       * * The layout have 7 rows and 1 column
       * * The layout have marging of 0 for width and 50 for height
       * * The button use the row 3 to 7
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
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );
      JPanel panel5 = new JPanel();
      panel5.setBackground( new Color( color ) );
      JPanel panel6 = new JPanel();
      panel6.setBackground( new Color( color ) );
      JPanel panel7 = new JPanel();
      panel7.setBackground( new Color( color ) );

      // Create all button
      JLabel selectText1 = new JLabel( numberPlayers +" joueurs", SwingConstants.CENTER);
      selectText1.setPreferredSize( new Dimension(200, 23) );
      selectText1.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER);
      selectText2.setPreferredSize( new Dimension(200, 20) );
      selectText2.setFont( new Font (police, Font.PLAIN, 22));

      JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER);
      selectText3.setPreferredSize( new Dimension(200, 20) );
      selectText3.setFont( new Font (police, Font.PLAIN, 20));

      JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER);
      selectText4.setPreferredSize( new Dimension(200, 23) );
      selectText4.setFont( new Font (police, Font.PLAIN, 20));

      JTextField playerOne = new JTextField();
      playerOne.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerOne.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerOnePrompt = new TextPrompt("Premier joueur", playerOne);

      JTextField playerTwo = new JTextField();
      playerTwo.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerTwo.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerTwoPrompt = new TextPrompt("Deuxième joueur", playerTwo);

      JTextField playerThree = new JTextField();
      playerThree.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerThree.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerThreePrompt = new TextPrompt("Troisième joueur", playerThree);

      JTextField playerFour = new JTextField();
      playerFour.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      playerFour.setFont( new Font (police, Font.PLAIN, 18));
      TextPrompt playerFourPrompt = new TextPrompt("Quatrième joueur", playerFour);

      backToSelection.setPreferredSize( new Dimension(widthBtn, heightbtn) );
      backToSelection.setFont( new Font (police, Font.PLAIN, 18));

      // Listener
      playerOne.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerOne.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerTwo.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerTwo.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerTwo.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerThree.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerThree.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerThree.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  playerFour.requestFocusInWindow();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      playerFour.addKeyListener( new KeyListener() { 
         @Override
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
               if (!playerFour.getText().equals("")) {
                  /**
                   * * Create a player, when enter is press
                   * * Put here the code to create player
                   * TODO Check if the player is create
                   * TODO if is create update him
                   * TODO else create him
                  */
                  KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
               }
            }
         }

         // Dont check this part
         @Override
         public void keyPressed(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }

         @Override
         public void keyReleased(KeyEvent e) {
            /**
             * ! Don't look this part 
             */
         }
      });

      backToSelection.addActionListener(this);

      // Add all button into there panel
      panel1.add(selectText1);
      panel1.add(selectText2);
      panel2.add(selectText3);
      panel2.add(selectText4);
      panel3.add(playerOne);
      panel4.add(playerTwo);
      panel5.add(playerThree);
      panel6.add(playerFour);
      panel7.add(backToSelection);

      // Add all panel into the main panel
      panelWest.add(panel1);
      panelWest.add(panel2);
      panelWest.add(panel3);
      panelWest.add(panel4);
      panelWest.add(panel5);
      panelWest.add(panel6);
      panelWest.add(panel7);

      return panelWest;
   }

   /**
    * Create the south panel for the new game menu.
    * The layout of the panel is a Flow layout.
    * @param position set 0,1,2 or 3 to set position.
    * 0 for select numbers players.
    * 1 for 2 players
    * 2 for 3 players
    * 3 for 4 players
    * @return JPanel : panel
    */
   private JPanel panelSouthForNewGameMenu(int position) {
      panelSouth = new JPanel();
      panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));

      panelSouth.setPreferredSize( new Dimension( 0, 60 ) );
      panelSouth.setBackground(new Color( 0xd4a373 ));

      JLabel text = new JLabel();
      if (position == 0) {
         text = new JLabel("Initialisation de la partie");
      } else {
         if (position == 1){
            numberDominos = 24;
         } else if (position == 2) {
            numberDominos = 36;
         } else {
            numberDominos = 48;
         }
         if (middleEmpire == 0) {
            sizeKingdom = 5;
            text = new JLabel(numberPlayers + " joueurs - " + numberDominos + " dominos - " + sizeKingdom + " x " + sizeKingdom);
         }
      }

      text.setFont( new Font (police, Font.PLAIN, 30));

      panelSouth.add(text);

      return panelSouth;
   }

   /**
    * Create the center panel for the new game menu.
    * The layout of the panel is a Flow layout.
    * @param none
    * @return JPanel : panel
    */
   private JPanel panelCenterForNewGameMenu() {
      panelCenter = new JPanel();
      panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER));

      // Define some variables
      int color = 0xfefae0;
      int textSize = 25;

      panelCenter.setBackground(new Color(color));

      /**
       * * Create a panel inside the main panel to contain all content
       * * The layout of the inside panel is GridLayout
       * * He have 9 rows and 1 column
       */
      JPanel panelInt = new JPanel();
      panelInt.setLayout(new GridLayout(9,1));
      panelInt.setBackground( new Color( color ) );

      // Create all panel
      JPanel nothing1 = new JPanel();
      nothing1.setBackground( new Color( color ) );
      JPanel nothing2 = new JPanel();
      nothing2.setBackground( new Color( color ) );
      JPanel nothing3 = new JPanel();
      nothing3.setBackground( new Color( color ) );
      JPanel nothing4 = new JPanel();
      nothing4.setBackground( new Color( color ) );
      JPanel panel1 = new JPanel();
      panel1.setBackground( new Color( color ) );
      JPanel panel2 = new JPanel();
      panel2.setBackground( new Color( color ) );
      panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
      panel2.setPreferredSize( new Dimension( 300, 60 ) );
      JPanel panel3 = new JPanel();
      panel3.setBackground( new Color( color ) );
      JPanel panel4 = new JPanel();
      panel4.setBackground( new Color( color ) );
      if ( numberPlayers != 0 ) {
         panel4.setLayout(new GridLayout(2,2, 20, 20));
         panel4.setBackground( new Color( color ) );
      }
      panel4.setPreferredSize( new Dimension( 500, 85 ) );
      JPanel panel5 = new JPanel();
      panel5.setBackground( new Color( color ) );
      
      // All content ( Button, JLabel )
      JLabel gameOptionText = new JLabel("<html><body><u>Option de partie</u></body></html>");
      gameOptionText.setFont( new Font (police, Font.PLAIN, textSize));

      displayTimeBtn.setFont( new Font (police, Font.PLAIN, textSize));
      displayTimeLimitedBtn.setFont( new Font (police, Font.PLAIN, textSize));

      dynastieBtn.setFont( new Font (police, Font.PLAIN, textSize));
      harmonieBtn.setFont( new Font (police, Font.PLAIN, textSize));
      middleEmpireBtn.setFont( new Font (police, Font.PLAIN, textSize));
      theGrandDuelBtn.setFont( new Font (police, Font.PLAIN, textSize));

      ButtonGroup btnRadio1 = new ButtonGroup();
      btnRadio1.add(displayTimeBtn);
      btnRadio1.add(displayTimeLimitedBtn);

      JLabel bonusText = new JLabel("<html><body><u>Bonus</u></body></html>");
      bonusText.setFont( new Font (police, Font.PLAIN, textSize));

      JLabel bonusText2 = new JLabel("Veuillez sélectionner un nombre");
      bonusText2.setFont( new Font (police, Font.PLAIN, textSize));
      
      JLabel bonusText3 = new JLabel("de joueurs pour accéder aux bonus");
      bonusText3.setFont( new Font (police, Font.PLAIN, textSize));
      
      launchGame.setFont( new Font (police, Font.PLAIN, textSize));

      // Event Listenent
      displayTimeBtn.addActionListener(this);
      displayTimeLimitedBtn.addActionListener(this);
      dynastieBtn.addActionListener(this);
      harmonieBtn.addActionListener(this);
      middleEmpireBtn.addActionListener(this);
      theGrandDuelBtn.addActionListener(this);
            
      // Add all content into the each panel
      panel1.add(gameOptionText);
      panel2.add(displayTimeBtn);
      panel2.add(displayTimeLimitedBtn);
      panel3.add(bonusText);
      if ( numberPlayers == 0 ) {
         panel4.add(bonusText2);
         panel4.add(bonusText3);
      } else {
         panel4.add(dynastieBtn);
         panel4.add(harmonieBtn);
         panel4.add(middleEmpireBtn);
         if ( numberPlayers == 2 ) {
            panel4.add(theGrandDuelBtn);
         }
      }
      panel5.add(launchGame);

      // Add all panel into the inside panel
      panelInt.add(nothing1);
      panelInt.add(panel1);
      panelInt.add(panel2);
      panelInt.add(nothing2);
      panelInt.add(panel3);
      panelInt.add(panel4);
      panelInt.add(nothing3);
      panelInt.add(panel5);
      panelInt.add(nothing4);

      // Add the panel into the main panel
      panelCenter.add(panelInt);
      
      return panelCenter;
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
         frame.remove(panelCenter);
         frame.remove(panelSouth);

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

         frame.remove( panelWest );
         frame.remove( panelSouth );
         frame.remove( panelCenter );

         if ( panelWest != null ) {
            panelWest = null;
         }
         if ( panelSouth != null ) {
            panelSouth = null;
         }

         frame.add( twoPlayers(), BorderLayout.LINE_START );
         frame.add( panelSouthForNewGameMenu(1), BorderLayout.SOUTH );
         frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );
      } else if ( e.getSource() == threePlayersBtn ) {

         numberPlayers = 3;

         frame.remove( panelWest );
         frame.remove( panelSouth );
         frame.remove( panelCenter );

         if ( panelWest != null ) {
            panelWest = null;
         }
         if ( panelSouth != null ) {
            panelSouth = null;
         }

         frame.add( threePlayers(), BorderLayout.LINE_START );
         frame.add( panelSouthForNewGameMenu(2), BorderLayout.SOUTH );
         frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

      } else if ( e.getSource() == fourPlayersBtn ) {

         numberPlayers = 4;

         frame.remove( panelWest );
         frame.remove( panelSouth );
         frame.remove( panelCenter );

         if ( panelWest != null ) {
            panelWest = null;
         }
         if ( panelSouth != null ) {
            panelSouth = null;
         }

         frame.add( fourPlayers(), BorderLayout.LINE_START );
         frame.add( panelSouthForNewGameMenu(3), BorderLayout.SOUTH );
         frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

      } else if ( e.getSource() == backToSelection ) {
         /**
          * TODO destroy player when he back to the selection of the number of players
          */
         numberPlayers = 0;

         frame.remove( panelWest );
         frame.remove( panelSouth );
         frame.remove( panelCenter );

         if ( panelWest != null ) {
            panelWest = null;
         }
         if ( panelSouth != null ) {
            panelSouth = null;
         }

         if ( dynastie != 0 ) {
            dynastie = 0;
            if ( dynastieBtn.isSelected() ) {
               dynastieBtn.setSelected(false);
            }
         }
         if ( harmonie != 0 ) {
            harmonie = 0;
            if ( harmonieBtn.isSelected() ) {
               harmonieBtn.setSelected(false);
            }
         }
         if ( middleEmpire != 0 ) {
            middleEmpire = 0;
            if ( middleEmpireBtn.isSelected() ) {
               middleEmpireBtn.setSelected(false);
            }
         }
         if ( theGrandDuel != 0 ) {
            theGrandDuel = 0;
            if ( theGrandDuelBtn.isSelected() ) {
               theGrandDuelBtn.setSelected(false);
            }
         }

         frame.add( panelWestForNewGameMenu(), BorderLayout.LINE_START );
         frame.add( panelSouthForNewGameMenu(0), BorderLayout.SOUTH );
         frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

      } else if ( e.getSource() == soundBtn ) {
         
         /**
          * TODO Cut the sound when is activated, and inversement
          */

      } else if ( e.getSource() == credits) {

         /**
          * TODO make the transition between pages
          */

      } else if ( e.getSource() == displayTimeBtn ) {

         if ( displayTimeBtn.isSelected() ) {
            System.out.println("test");
         } 
         displayTime = 1;
         if ( displayTimeLimited == 1 ) {
            displayTimeLimited = 0;
         }
         /**
          * * This part is for display the time you take to play
          * TODO create the funtion to do this
          */

      } else if ( e.getSource() == displayTimeLimitedBtn ) {

         displayTimeLimited = 1;
         if ( displayTime == 1 ) {
            displayTime = 0;
         }

         /**
          * * This part is for display the limitation if time you have
          * TODO create the funtion to do this
          */

      } else if ( e.getSource() == dynastieBtn ) {
         dynastie = 1;
      } else if ( e.getSource() == harmonieBtn ) {
         harmonie = 1;
      } else if ( e.getSource() == middleEmpireBtn ) {
         middleEmpire = 1;
      } else if ( e.getSource() == theGrandDuelBtn ) {
         theGrandDuel = 1;
      }

      frame.validate();
      frame.repaint();
   }

   // Don't check this part
   @Override
   public Object getValue( String key ) {
      return null;
   }

   @Override
   public void putValue( String key, Object value ) {
      
   }

   public static void main(String [] args) throws Exception{
      UIManager.setLookAndFeel( new NimbusLookAndFeel() );

      SwingUtilities.invokeLater( new Runnable()
      {
         @Override
         public void run()
         {
               new swing();
         }
      });
   }
}