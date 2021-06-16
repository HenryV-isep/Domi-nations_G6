package Grap_int;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
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
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import LimitJTextField.LimitJTextField;
import Main.Domino;
import Main.Game;
import Main.Player;
import TextPrompt.TextPrompt;


/**
 * * This is the documentation of all know bugs:
 *
 * ! Bug with changement between start menu and new game menu
 * * 
 * ? Influence on the program
 * * 
 * ? How resolve it ?
 * y 
 */
public class Graphic_interface extends JFrame implements Action {
    // Global variable
    public static Integer numberPlayers;
    public static Integer numberDominos;
    public static Integer sizeKingdom;
    public static Player currentPlayer;
    public static int turn = 0;
    public static int turnDraw = 0;
    public static int turnPlaced = 0;

    // Define Option
    public static int dynastie = 0;
    public static int harmonie = 0;
    public static int middleEmpire = 0;
    public static int theGrandDuel = 0;
    public static int displayTime = 0;
    public static int displayTimeLimited = 0;

    public static Integer getNumberPlayers() {
        return numberPlayers;
    }

    public static Integer getNumberDominos() {
        return numberDominos;
    }

    public static Integer getSizeKingdom() {
        return sizeKingdom;
    }

    public static int getDynastie() {
        return dynastie;
    }

    public static int getHarmonie() {
        return harmonie;
    }

    public static int getMiddleEmpire() {
        return middleEmpire;
    }

    public static int getTheGrandDuel() {
        return theGrandDuel;
    }

    public static int getDisplayTime() {
        return displayTime;
    }

    public static int getDisplayTimeLimited() {
        return displayTimeLimited;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer( Player currentPlayer ) {
        Graphic_interface.currentPlayer = currentPlayer;
    }

    // Variables for swing
    private static JLabel banner;
    private static JLabel background;
    private static int position;
    private static int rotation;
    private static String police = "Century Gothic";
    private static Game game = new Game();
    public static Player[] playersFinal;
    public static Domino[] dominoBegun;
    public static Domino[] currentDominos = new Domino[4];
    public static Domino[] nextDominos = new Domino[4];
    
    // Get the height and the width of the screen
    private static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private static int height = ( int )dimension.getHeight() + 100;
    private static int width  = ( int )dimension.getWidth() + 100;

    // Define all buttons in attribut for more efficiency in the actionListener
    private JButton newGameBtn = new JButton( "Nouvelle partie" );
    private JButton soundBtn = new JButton( "Son activé" );
    private JButton leave = new JButton( "Quitter" );
    private JButton credits = new JButton( "Crédits" );
    private JButton backToStartMenu = new JButton("Retour");
    private JButton backToStartMenu2 = new JButton("Retour");
    private JButton twoPlayersBtn = new JButton( "2 joueurs" );
    private JButton threePlayersBtn = new JButton( "3 joueurs" );
    private JButton fourPlayersBtn = new JButton( "4 joueurs" );
    private JButton backToSelection = new JButton( "Retour sélection" );
    private JButton launchGame = new JButton( "Lancer la partie" );
    private JButton leaveGameBtn = new JButton( "Quitter la partie" );
    private JButton rotationBtn = new JButton( "Rotation" );
    private JButton endTour = new JButton( "Fin du tour" );
    private JRadioButton displayTimeBtn = new JRadioButton( "Afficher le temps" );
    private JRadioButton displayTimeLimitedBtn = new JRadioButton( "Ajouter une limite de temps" );
    private JRadioButton domino1 = new JRadioButton();
    private JRadioButton domino2 = new JRadioButton();
    private JRadioButton domino3 = new JRadioButton();
    private JRadioButton domino4 = new JRadioButton();
    private JLabel domino1JL = new JLabel();
    private JLabel domino2JL = new JLabel();
    private JLabel domino3JL = new JLabel();
    private JLabel domino4JL = new JLabel();
    private JCheckBox dynastieBtn = new JCheckBox( "Dynastie" );
    private JCheckBox harmonieBtn = new JCheckBox( "Harmonie" );
    private JCheckBox middleEmpireBtn = new JCheckBox( "Empire du milieu" );
    private JCheckBox theGrandDuelBtn = new JCheckBox( "Le Grand Duel" );

    // Button for the kingdom
    private JButton box00Button = new JButton();
    private JButton box01Button = new JButton();
    private JButton box02Button = new JButton();
    private JButton box03Button = new JButton();
    private JButton box04Button = new JButton();
    private JButton box05Button = new JButton();
    private JButton box06Button = new JButton();

    private JButton box10Button = new JButton();
    private JButton box11Button = new JButton();
    private JButton box12Button = new JButton();
    private JButton box13Button = new JButton();
    private JButton box14Button = new JButton();
    private JButton box15Button = new JButton();
    private JButton box16Button = new JButton();

    private JButton box20Button = new JButton();
    private JButton box21Button = new JButton();
    private JButton box22Button = new JButton();
    private JButton box23Button = new JButton();
    private JButton box24Button = new JButton();
    private JButton box25Button = new JButton();
    private JButton box26Button = new JButton();

    private JButton box30Button = new JButton();
    private JButton box31Button = new JButton();
    private JButton box32Button = new JButton();
    private JButton box33Button = new JButton();
    private JButton box34Button = new JButton();
    private JButton box35Button = new JButton();
    private JButton box36Button = new JButton();

    private JButton box40Button = new JButton();
    private JButton box41Button = new JButton();
    private JButton box42Button = new JButton();
    private JButton box43Button = new JButton();
    private JButton box44Button = new JButton();
    private JButton box45Button = new JButton();
    private JButton box46Button = new JButton();

    private JButton box50Button = new JButton();
    private JButton box51Button = new JButton();
    private JButton box52Button = new JButton();
    private JButton box53Button = new JButton();
    private JButton box54Button = new JButton();
    private JButton box55Button = new JButton();
    private JButton box56Button = new JButton();

    private JButton box60Button = new JButton();
    private JButton box61Button = new JButton();
    private JButton box62Button = new JButton();
    private JButton box63Button = new JButton();
    private JButton box64Button = new JButton();
    private JButton box65Button = new JButton();
    private JButton box66Button = new JButton();

    // Define all panels
    private static JPanel panelNorth;
    private static JPanel panelSouth;
    private static JPanel panelEast;
    private static JPanel panelWest;
    private static JPanel panelCenter;

    // Initializes the frame of the game and set up the frame to start menu
    static JFrame frame = new JFrame( "Domi-nation" );

    public Graphic_interface() {
        super( "Domi-nation" );

        // Set the size of the frame
        frame.setSize( new Dimension( width,height ) );
        // Center the frame to the center of the screen
        frame.setLocationRelativeTo( null );
        
        // Launch the first page
        startMenu();

        // Maximized the frame
        frame.setExtendedState( frame.getExtendedState() | JFrame.MAXIMIZED_BOTH );
        // If there are two frame or more, juste close the frame, else close swing
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.setVisible( true );
    }

    /**
     * Function to display the start menu
     * @param none
     * @return none
     */
    private void startMenu() {
        frame.add( panelEastForStartMenu(), BorderLayout.LINE_END );

        // Set the image for the banner
        banner = new JLabel();
        BufferedImage bannerImage = null;

        try {
            bannerImage = ImageIO.read( new File( "Image/banner.png" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

        banner.setIcon( new ImageIcon( fitimage( bannerImage, width, 135 ) ) );

        // Set the image for the background
        background = new JLabel();
        BufferedImage backgroundImage = null;

        try {
            backgroundImage = ImageIO.read( new File( "Image/kingdomino.jpg" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        int backgroundWidth = width - (int) panelEast.getPreferredSize().width;
        int backgroundHeight = height - (int) banner.getPreferredSize().height;

        background.setIcon( new ImageIcon( fitimage( backgroundImage, backgroundWidth, backgroundHeight ) ) );

        // Add the contents into the frame
        frame.add( banner, BorderLayout.NORTH );
        frame.add( background, BorderLayout.LINE_START );
    }

    /**
     * This function resize the imag.
     * Example of use ==> function startMenu()
     * @param img : The image who need resizing
     * @param width : The width for resizing
     * @param height : The height for resizing
     * @return Image
     */
    private Image fitimage( Image img , int width , int height ) {

        BufferedImage resizedimage = new BufferedImage( width, height, BufferedImage.TYPE_INT_RGB );
        Graphics2D g2 = resizedimage.createGraphics();

        g2.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
        g2.drawImage( img, 0, 0, width, height, null );
        g2.dispose();

        return resizedimage;
    }

    /**
     * Create the panel for the start menu.
     * @param none
     * @return JPanel : panelEast
     */
    private JPanel panelEastForStartMenu() {

        // Initializes the main panel
        panelEast = new JPanel();
        panelEast.setLayout( new GridLayout( 6, 1, 0, 50 ) );
        panelEast.setPreferredSize( new Dimension( 170, 0 ) );

        // Initializes variables for this panel
        int color = 0xf1c232;
        int widthBtn = 165;
        int heightbtn = 60;

        panelEast.setBackground( new Color( color ) );

        // Create all panels for grid layout
        JLabel nothing = new JLabel();

        JPanel panel1 = new JPanel();
        panel1.setBackground( new Color( color ) );

        JPanel panel2 = new JPanel();
        panel2.setBackground( new Color( color ) );

        JPanel panel3 = new JPanel();
        panel3.setBackground( new Color( color ) );

        JPanel panel4 = new JPanel();
        panel4.setBackground( new Color( color ) );

        // Create all contents for this panel
        newGameBtn.setPreferredSize( new Dimension(widthBtn, heightbtn) );
        newGameBtn.setFont( new Font ( police, Font.PLAIN, 18 ));

        soundBtn.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        soundBtn.setFont( new Font ( police, Font.PLAIN, 20 ) );

        leave.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        leave.setFont( new Font ( police, Font.PLAIN, 20 ) );

        credits.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        credits.setFont( new Font ( police, Font.PLAIN, 20 ) );

        // Listener
        leave.addActionListener( e -> {
            frame.dispose();
        } );

        newGameBtn.addActionListener( this );
        soundBtn.addActionListener( this );
        credits.addActionListener( this );

        // Add all contents into there panel
        panel1.add( newGameBtn) ;
        panel2.add( soundBtn );
        panel3.add( leave );
        panel4.add( credits );

        // Add all panels into the main panel
        panelEast.add(nothing);
        panelEast.add(panel1);
        panelEast.add(panel2);
        panelEast.add(panel3);
        panelEast.add(panel4);

        return panelEast;
    }

    /**
     * Function to display the new game menu.
     * @param none
     * @return none
     */
    private void newGameMenu() {

        // Add the contents into the frame
        frame.add( panelNorthForNewGameMenu(), BorderLayout.NORTH );
        frame.add( panelWestForNewGameMenu(), BorderLayout.LINE_START );
        frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );
        frame.add( panelSouthForNewGameMenu( 0 ), BorderLayout.SOUTH );
    }

    /**
     * Create the north panel for the new game menu.
     * @param none
     * @return JPanel : panelNorth
     */
    private JPanel panelNorthForNewGameMenu() {

        // Initializes the main panel
        panelNorth = new JPanel();
        panelNorth.setLayout( new BorderLayout() );
        panelNorth.setPreferredSize( new Dimension( 0, 60 ) );
        panelNorth.setBackground( new Color( 0xd4a373 ) );

        // Create the contents for this panel
        JLabel textNorth = new JLabel( "Création de partie", SwingConstants.CENTER );
        textNorth.setFont( new Font( police, Font.PLAIN, 30 ) );

        backToStartMenu.setPreferredSize( new Dimension( 100,50 ) );
        backToStartMenu.setFont( new Font( police, Font.PLAIN, 20 ) );

        // Listener
        backToStartMenu.addActionListener( this );

        // Add contents to main panel
        panelNorth.add( textNorth, BorderLayout.CENTER );
        panelNorth.add( backToStartMenu, BorderLayout.LINE_END );

        return panelNorth;
    }

    /**
     * Create the west panel for the new game menu.
     * @param none
     * @return JPanel : panelWest
     */
    private JPanel panelWestForNewGameMenu() {

        // Initializes main panel
        panelWest = new JPanel();
        panelWest.setLayout( new GridLayout( 6, 1, 0, 50 ) );
        panelWest.setPreferredSize( new Dimension( 200, 0 ) );

        // Initializes variables use in this panel
        int color = 0xf6b26b;
        int widthBtn = 170;
        int heightbtn = 50;

        panelWest.setBackground(new Color( 0xf6b26b ));

        // Create all panels
        JLabel nothing = new JLabel();

        JPanel panel1 = new JPanel();
        panel1.setBackground( new Color( color ) );

        JPanel panel2 = new JPanel();
        panel2.setBackground( new Color( color ) );

        JPanel panel3 = new JPanel();
        panel3.setBackground( new Color( color ) );

        JPanel panel4 = new JPanel();
        panel4.setBackground( new Color( color ) );

        // Create all contents
        JLabel selectText1 = new JLabel( "Nombre de", SwingConstants.CENTER );
        selectText1.setPreferredSize( new Dimension( 200, 20 ) );
        selectText1.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText2 = new JLabel( "joueurs :", SwingConstants.CENTER );
        selectText2.setPreferredSize( new Dimension( 200, 28 ) );
        selectText2.setFont( new Font( police, Font.PLAIN, 22 ) );

        twoPlayersBtn.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        twoPlayersBtn.setFont( new Font( police, Font.PLAIN, 22 ) );

        threePlayersBtn.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        threePlayersBtn.setFont( new Font( police, Font.PLAIN, 22 ) );

        fourPlayersBtn.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        fourPlayersBtn.setFont( new Font( police, Font.PLAIN, 22 ) );

        // Listeners
        twoPlayersBtn.addActionListener( this );
        threePlayersBtn.addActionListener( this );
        fourPlayersBtn.addActionListener( this );

        // Add all contents into there panel
        panel1.add( selectText1 );
        panel1.add( selectText2 );
        panel2.add( twoPlayersBtn );
        panel3.add( threePlayersBtn );
        panel4.add( fourPlayersBtn );

        // Add all panels into the main panel
        panelWest.add( nothing );
        panelWest.add( panel1 );
        panelWest.add( panel2 );
        panelWest.add( panel3 );
        panelWest.add( panel4 );

        return panelWest;
    }

    /**
     * Create the west panel for the new game menu for 2 players selection.
     * @param none
     * @return JPanel : panelWest
     */
    private JPanel twoPlayers() {

        // Initializes the main panel
        panelWest = new JPanel();
        panelWest.setLayout( new GridLayout( 7, 1, 0, 50 ) );
        panelWest.setPreferredSize( new Dimension( 200, 0 ) );

        // initializes variables use in this panel
        int color = 0xf6b26b;
        int widthBtn = 170;
        int heightbtn = 50;

        panelWest.setBackground(new Color( 0xf6b26b ));

        // Create all panels for grid layout
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

        // Create all contents
        JLabel selectText1 = new JLabel( numberPlayers + " joueurs", SwingConstants.CENTER );
        selectText1.setPreferredSize( new Dimension( 200, 23 ) );
        selectText1.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER );
        selectText2.setPreferredSize( new Dimension( 200, 20 ) );
        selectText2.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER );
        selectText3.setPreferredSize( new Dimension( 200, 20 ) );
        selectText3.setFont( new Font( police, Font.PLAIN, 20 ) );

        JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER );
        selectText4.setPreferredSize( new Dimension( 200, 23 ) );
        selectText4.setFont( new Font( police, Font.PLAIN, 20 ) );

        JTextField playerOne = new JTextField();
        playerOne.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerOne.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerOne.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerOnePrompt = new TextPrompt( "Premier joueur", playerOne );

        JTextField playerTwo = new JTextField();
        playerTwo.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerTwo.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerTwo.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerTwoPrompt = new TextPrompt( "Deuxième joueur", playerTwo );

        backToSelection.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        backToSelection.setFont( new Font( police, Font.PLAIN, 18 ) );

        // Listeners
        playerOne.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerOne.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerOne.getText(),1,"blue");
                        playerTwo.requestFocusInWindow();

                        if ( !playerTwo.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerTwo.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerTwo.getText(),2,"red");
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
                        
                        if ( !playerOne.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }

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

        backToSelection.addActionListener( this );

        // Add all contents into there panel
        panel1.add( selectText1 );
        panel1.add( selectText2 );
        panel2.add( selectText3 );
        panel2.add( selectText4 );
        panel3.add( playerOne );
        panel4.add( playerTwo );
        panel5.add( backToSelection );

        // Add all panels into the main panel
        panelWest.add( panel1 );
        panelWest.add( panel2 );
        panelWest.add( panel3 );
        panelWest.add( panel4);
        panelWest.add( nothing1 );
        panelWest.add( nothing2 );
        panelWest.add( panel5 );

        return panelWest;
    }

    /**
     * Create the west panel for the new game menu for 3 players selection.
     * @param none
     * @return JPanel : panelWest
     */
    private JPanel threePlayers() {

        // Initializes maint panel
        panelWest = new JPanel();
        panelWest.setLayout( new GridLayout( 7, 1, 0, 50 ) );
        panelWest.setPreferredSize( new Dimension( 200, 0 ) );

        // Initializes variables use in this panel
        int color = 0xf6b26b;
        int widthBtn = 170;
        int heightbtn = 50;

        panelWest.setBackground( new Color( 0xf6b26b ) );

        // Create all panels
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

        // Create all contents
        JLabel selectText1 = new JLabel( numberPlayers + " joueurs", SwingConstants.CENTER );
        selectText1.setPreferredSize( new Dimension( 200, 23 ) );
        selectText1.setFont( new Font( police, Font.PLAIN, 22 ));

        JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER );
        selectText2.setPreferredSize( new Dimension( 200, 20 ) );
        selectText2.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER );
        selectText3.setPreferredSize( new Dimension( 200, 20 ) );
        selectText3.setFont( new Font( police, Font.PLAIN, 20 ) );

        JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER );
        selectText4.setPreferredSize( new Dimension( 200, 23 ) );
        selectText4.setFont( new Font( police, Font.PLAIN, 20 ));

        JTextField playerOne = new JTextField();
        playerOne.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerOne.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerOne.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerOnePrompt = new TextPrompt( "Premier joueur", playerOne );

        JTextField playerTwo = new JTextField();
        playerTwo.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerTwo.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerTwo.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerTwoPrompt = new TextPrompt( "Deuxième joueur", playerTwo );

        JTextField playerThree = new JTextField();
        playerThree.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerThree.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerThree.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerThreePrompt = new TextPrompt( "Troisième joueur", playerThree );

        backToSelection.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        backToSelection.setFont( new Font( police, Font.PLAIN, 18 ) );

        // Listener
        playerOne.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerOne.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerOne.getText(),1,"blue");
                        playerTwo.requestFocusInWindow();

                        if ( !playerTwo.getText().equals("") && !playerThree.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerTwo.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerTwo.getText(),2,"red");
                        playerThree.requestFocusInWindow();

                        if ( !playerTwo.getText().equals("") && !playerThree.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerThree.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerThree.getText(),3,"green");
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
                        
                        if ( !playerOne.getText().equals("") && !playerTwo.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }

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

        backToSelection.addActionListener( this );

        // Add all button into there panel
        panel1.add( selectText1 );
        panel1.add( selectText2 );
        panel2.add( selectText3 );
        panel2.add( selectText4 );
        panel3.add( playerOne );
        panel4.add( playerTwo );
        panel5.add( playerThree );
        panel6.add( backToSelection );

        // Add all panel into the main panel
        panelWest.add( panel1 );
        panelWest.add( panel2 );
        panelWest.add( panel3 );
        panelWest.add( panel4 );
        panelWest.add( panel5 );
        panelWest.add( nothing2 );
        panelWest.add( panel6 );

        return panelWest;
    }

    /**
     * Create the west panel for the new game menu for 4 players selection.
     * @param none
     * @return JPanel : panelWest
     */
    private JPanel fourPlayers() {

        // Initializes main panel
        panelWest = new JPanel();
        panelWest.setLayout( new GridLayout( 7, 1, 0, 50 ) );
        panelWest.setPreferredSize( new Dimension( 200, 0 ) );

        // Initializes variables use in this panel
        int color = 0xf6b26b;
        int widthBtn = 170;
        int heightbtn = 50;

        panelWest.setBackground( new Color( 0xf6b26b ) );

        // Create all panels
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

        // Create all contents
        JLabel selectText1 = new JLabel( numberPlayers +" joueurs", SwingConstants.CENTER );
        selectText1.setPreferredSize( new Dimension( 200, 23 ) );
        selectText1.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText2 = new JLabel( "sélectionnés", SwingConstants.CENTER );
        selectText2.setPreferredSize( new Dimension( 200, 20 ) );
        selectText2.setFont( new Font( police, Font.PLAIN, 22 ) );

        JLabel selectText3 = new JLabel( "Appuyer sur ENTRER", SwingConstants.CENTER );
        selectText3.setPreferredSize( new Dimension( 200, 20 ) );
        selectText3.setFont( new Font( police, Font.PLAIN, 20 ) );

        JLabel selectText4 = new JLabel( "pour chaque joueur", SwingConstants.CENTER );
        selectText4.setPreferredSize( new Dimension( 200, 23 ) );
        selectText4.setFont( new Font( police, Font.PLAIN, 20 ) );

        JTextField playerOne = new JTextField();
        playerOne.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerOne.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerOne.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerOnePrompt = new TextPrompt( "Premier joueur", playerOne );

        JTextField playerTwo = new JTextField();
        playerTwo.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerTwo.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerTwo.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerTwoPrompt = new TextPrompt( "Deuxième joueur", playerTwo );

        JTextField playerThree = new JTextField();
        playerThree.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerThree.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerThree.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerThreePrompt = new TextPrompt( "Troisième joueur", playerThree );

        JTextField playerFour = new JTextField();
        playerFour.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        playerFour.setFont( new Font( police, Font.PLAIN, 18 ) );
        playerFour.setDocument( new LimitJTextField( 10 ) );
        TextPrompt playerFourPrompt = new TextPrompt( "Quatrième joueur", playerFour );

        backToSelection.setPreferredSize( new Dimension( widthBtn, heightbtn ) );
        backToSelection.setFont( new Font( police, Font.PLAIN, 18 ) );

        // Listeners
        playerOne.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerOne.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerOne.getText(),1,"blue");
                        playerTwo.requestFocusInWindow();

                        if ( !playerTwo.getText().equals("") && !playerThree.getText().equals("") && !playerFour.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerTwo.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerTwo.getText(),2,"red");
                        playerThree.requestFocusInWindow();

                        if ( !playerOne.getText().equals("") && !playerThree.getText().equals("") && !playerFour.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if ( e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerThree.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerThree.getText(),3,"green");
                        playerFour.requestFocusInWindow();

                        if ( !playerTwo.getText().equals("") && !playerOne.getText().equals("") && !playerFour.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
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
            public void keyTyped( KeyEvent e ) {
                if  (e.getKeyChar() == KeyEvent.VK_ENTER ) {
                    if ( !playerFour.getText().equals("") ) {
                        
                        game.createPlayer(numberPlayers,playerFour.getText(),4,"orange");
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearFocusOwner();
                        
                        if ( !playerTwo.getText().equals("") && !playerThree.getText().equals("") && !playerOne.getText().equals("") ) {
                            launchGame.setEnabled( true );
                        }
                        
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

        backToSelection.addActionListener( this );

        // Add all contents into there panel
        panel1.add( selectText1 );
        panel1.add( selectText2 );
        panel2.add( selectText3 );
        panel2.add( selectText4 );
        panel3.add( playerOne );
        panel4.add( playerTwo );
        panel5.add( playerThree );
        panel6.add( playerFour );
        panel7.add( backToSelection );

        // Add all panels into the main panel
        panelWest.add( panel1 );
        panelWest.add( panel2 );
        panelWest.add( panel3 );
        panelWest.add( panel4 );
        panelWest.add( panel5 );
        panelWest.add( panel6 );
        panelWest.add( panel7 );

        return panelWest;
    }

    /**
     * Create the south panel for the new game menu.
     * @param position set 0,1,2 or 3 to set position.
     * 0 for select numbers players,
     * 1 for 2 players,
     * 2 for 3 players,
     * 3 for 4 players,
     * @return JPanel : panelSouth
     */
    private JPanel panelSouthForNewGameMenu( int position ) {

        // Initializes main panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout( FlowLayout.CENTER ) );

        panelSouth.setPreferredSize( new Dimension( 0, 60 ) );
        panelSouth.setBackground( new Color( 0xd4a373 ) );

        // Create all contents
        JLabel text = new JLabel();

        if ( position == 0 ) {

            text = new JLabel( "Initialisation de la partie" );

        } else {

            // Initializes the numbers of dominos in function of the number of players
            if ( position == 1 ){
                numberDominos = 24;
            } else if ( position == 2 ) {
                numberDominos = 36;
            } else {
                numberDominos = 48;
            }

            // Initializes the size of the kingdom
            sizeKingdom = ( theGrandDuel == 1 ) ? 7 : 5;

            text = new JLabel( numberPlayers + " joueurs - " + numberDominos + " dominos - " + sizeKingdom + " x " + sizeKingdom );

        }

        text.setFont( new Font( police, Font.PLAIN, 30 ) );

        // Add contents into main panel
        panelSouth.add( text );

        return panelSouth;
    }

    /**
     * Create the center panel for the new game menu.
     * @param none
     * @return JPanel : panelCenter
     */
    private JPanel panelCenterForNewGameMenu() {

        // Initializes main panel
        panelCenter = new JPanel();
        panelCenter.setLayout( new FlowLayout( FlowLayout.CENTER ) );

        // Initializes variables for this panel
        int color = 0xfefae0;
        int textSize = 25;

        panelCenter.setBackground( new Color( color ) );

        // Create panel for display content
        JPanel panelInt = new JPanel();
        panelInt.setLayout( new GridLayout( 9,1 ) );
        panelInt.setBackground( new Color( color ) );

        // Create all panels for grid layout
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
        panel2.setLayout( new FlowLayout( FlowLayout.CENTER ) );
        panel2.setPreferredSize( new Dimension( 300, 60 ) );

        JPanel panel3 = new JPanel();
        panel3.setBackground( new Color( color ) );

        JPanel panel4 = new JPanel();
        panel4.setBackground( new Color( color ) );
        if ( numberPlayers != 0 ) {
            panel4.setLayout ( new GridLayout( 2,2, 20, 20 ) );
            panel4.setBackground( new Color( color ) );
        }
        panel4.setPreferredSize( new Dimension( 500, 85 ) );

        JPanel panel5 = new JPanel();
        panel5.setBackground( new Color( color ) );

        // Create all contents
        JLabel gameOptionText = new JLabel( "<html><body><u>Option de partie</u></body></html>" );
        gameOptionText.setFont( new Font( police, Font.PLAIN, textSize ) );

        JLabel gameOptionText2 = new JLabel( "Veuillez sélectionner un nombre" );
        gameOptionText2.setFont( new Font( police, Font.PLAIN, textSize ) );

        JLabel gameOptionText3 = new JLabel( "de joueurs pour accéder aux options" );
        gameOptionText3.setFont( new Font( police, Font.PLAIN, textSize ) );

        displayTimeBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        displayTimeLimitedBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        dynastieBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        harmonieBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        middleEmpireBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        theGrandDuelBtn.setFont( new Font( police, Font.PLAIN, textSize ) );

        ButtonGroup btnRadio1 = new ButtonGroup();
        btnRadio1.add( displayTimeBtn );
        btnRadio1.add( displayTimeLimitedBtn );

        JLabel bonusText = new JLabel( "<html><body><u>Bonus</u></body></html>" );
        bonusText.setFont( new Font( police, Font.PLAIN, textSize ) );

        JLabel bonusText2 = new JLabel( "Veuillez sélectionner un nombre" );
        bonusText2.setFont( new Font( police, Font.PLAIN, textSize ) );

        JLabel bonusText3 = new JLabel( "de joueurs pour accéder aux bonus" );
        bonusText3.setFont( new Font( police, Font.PLAIN, textSize ) );

        launchGame.setBackground( new Color( 0xf6b26b ) );
        launchGame.setPreferredSize( new Dimension( 500, 50 ) );
        launchGame.setEnabled( false );
        launchGame.setFont( new Font( police, Font.PLAIN, textSize ) );

        // Listeners
        if ( numberPlayers != 0 ) {
            displayTimeBtn.addActionListener( this );
            displayTimeLimitedBtn.addActionListener( this );
            dynastieBtn.addActionListener( this );
            harmonieBtn.addActionListener( this );
            middleEmpireBtn.addActionListener( this );
            theGrandDuelBtn.addActionListener( this );
            launchGame.addActionListener( this );
        } else {
            displayTimeBtn.removeActionListener( this );;
            displayTimeLimitedBtn.removeActionListener( this );
            dynastieBtn.removeActionListener( this );
            harmonieBtn.removeActionListener( this );
            middleEmpireBtn.removeActionListener( this );
            theGrandDuelBtn.removeActionListener( this );
            launchGame.removeActionListener( this );
        }

        // Add all contents into the each panel
        panel1.add( gameOptionText );
        panel3.add( bonusText );

        if ( numberPlayers == 0 ) {

            panel2.add( gameOptionText2 );
            panel2.add( gameOptionText3 );
            panel4.add( bonusText2 );
            panel4.add( bonusText3 );

        } else {

            panel2.add( displayTimeBtn );
            panel2.add( displayTimeLimitedBtn );
            panel4.add( dynastieBtn );
            panel4.add( harmonieBtn );
            panel4.add( middleEmpireBtn );
            panel5.add( launchGame );

            if ( numberPlayers == 2 ) {
                panel4.add( theGrandDuelBtn );
            }
        }


        // Add all panels the panel
        panelInt.add( nothing1 );
        panelInt.add( panel1 );
        panelInt.add( panel2 );
        panelInt.add( nothing2 );
        panelInt.add( panel3 );
        panelInt.add( panel4 );
        panelInt.add( nothing3 );
        panelInt.add( panel5 );
        panelInt.add( nothing4 );

        // Add the panels into the main panel
        panelCenter.add( panelInt );

        return panelCenter;
    }

    /**
     * Function display credit
     * @param none
     * @return none
     */
    private void credit() {

        // Initializes the main panel
        panelEast = new JPanel();
        panelEast.setPreferredSize( new Dimension( 150,0 ) );
        panelEast.setBackground( new Color( 0xf1c232 ) );

        panelWest = new JPanel();
        panelWest.setPreferredSize( new Dimension( 150,0 ) );
        panelWest.setBackground( new Color( 0xf1c232 ) );

        // Add panels into the frame
        frame.add( panelNorthForCredit(), BorderLayout.NORTH );
        frame.add( panelEast, BorderLayout.EAST );
        frame.add( panelWest, BorderLayout.WEST );
        frame.add( panelCenterForCredit(), BorderLayout.CENTER );
    }

    /**
     * Create the north panel for credit
     * @param none
     * @return JPanelNorth
     */
    private JPanel panelNorthForCredit () {

        // Initialaze the main panel
        panelNorth = new JPanel();
        panelNorth.setLayout( new FlowLayout( FlowLayout.LEFT ) );
        panelNorth.setBackground( new Color( 0xf1c232 ) );

        // Create all contents
        backToStartMenu2.setPreferredSize( new Dimension( 100,50 ) );
        backToStartMenu2.setFont( new Font (police, Font.PLAIN, 20) );

        // Listeners
        backToStartMenu2.addActionListener( this );

        // Add all contents into the main panel
        panelNorth.add( backToStartMenu2 );

        return panelNorth;
    }

    /**
     * Create the center panel for credit
     * @param none
     * @return JPanelCenter
     */
    private JPanel panelCenterForCredit() {

        // Initialaze the main panel
        panelCenter = new JPanel();
        panelCenter.setLayout( new FlowLayout( FlowLayout.CENTER, 0, 50 ) );
        panelCenter.setBackground( new Color( 0xf1c232 ) );
        
        int widthCredit  = ( int )dimension.getWidth() - 300;

        // Create all panels for grid layout
        JPanel panel1 = new JPanel();
        panel1.setBackground( new Color( 0xfff2cc ) );
        panel1.setPreferredSize( new Dimension( widthCredit, 50 ) );

        JPanel panel2 = new JPanel();
        panel2.setLayout( new FlowLayout( FlowLayout.CENTER ) );
        panel2.setBackground( new Color( 0xfff2cc ) );
        panel2.setPreferredSize( new Dimension( widthCredit, 500 ) );

        // Create all contents
        JLabel creditTitle = new JLabel( "Crédits" );
        creditTitle.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text1 = new JLabel( "Domination (v1.2.1 HD)", SwingConstants.CENTER );
        text1.setPreferredSize( new Dimension( widthCredit, 80 ) );
        text1.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text2 = new JLabel( "@ 2021 ISEPG6GAME3", SwingConstants.CENTER );
        text2.setPreferredSize( new Dimension( widthCredit, 80 ) );
        text2.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text3 = new JLabel( "isepG6game3.com", SwingConstants.CENTER );
        text3.setPreferredSize( new Dimension( widthCredit, 100 ) );
        text3.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text4 = new JLabel( "Jeu créé par :", SwingConstants.CENTER );
        text4.setPreferredSize( new Dimension( widthCredit, 80 ) );
        text4.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text5 = new JLabel( "Tendzin ROFFLER", SwingConstants.CENTER );
        text5.setPreferredSize( new Dimension( widthCredit, 40 ) );
        text5.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text6 = new JLabel( "Henry VIEN", SwingConstants.CENTER );
        text6.setPreferredSize( new Dimension( widthCredit, 40 ) );
        text6.setFont( new Font( police, Font.PLAIN, 30 ) );

        JLabel text7 = new JLabel( "Cécile LI", SwingConstants.CENTER );
        text7.setPreferredSize( new Dimension( widthCredit, 40 ) );
        text7.setFont( new Font( police, Font.PLAIN, 30 ) );

        // Add contents into there panel
        panel1.add( creditTitle );
        panel2.add( text1 );
        panel2.add( text2 );
        panel2.add( text3 );
        panel2.add( text4 );
        panel2.add( text5 );
        panel2.add( text6 );
        panel2.add( text7 );

        // Add panels to main panel
        panelCenter.add( panel1 );
        panelCenter.add( panel2 );

        return panelCenter;
    }

    /**
     * Function display game menu
     * @param none
     * @return none
     */
    private void gameMenu() {
        
        // Add panels into the frame
        frame.add( panelEastForGameMenu(), BorderLayout.EAST );
        frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        frame.add( panelSouthForGameMenu(), BorderLayout.SOUTH );
        frame.add( panelWestForGameMenu(), BorderLayout.WEST );

    }

    /**
     * Create the east panel for game menu
     * @param none
     * @return JPanelEast
     */
    private JPanel panelEastForGameMenu() {
        
        // Initialaze the main panel
        panelEast = new JPanel();
        panelEast.setPreferredSize( new Dimension( 180,0 ) );
        panelEast.setLayout( new GridLayout( 3,1 ) );

        // Some variables for this panel
        int font = 18;

        // Create all panels for grid layout
        JPanel panel1_1 = new JPanel();
        panel1_1.setBackground( new Color( 0xfefae0 ) );
        panel1_1.setLayout( new FlowLayout( FlowLayout.CENTER, 100, 15 ) );

        JPanel panel1_2 = new JPanel();
        panel1_2.setBackground( new Color( 0xfefae0 ) );
        panel1_2.setLayout( new FlowLayout( FlowLayout.CENTER, 100, 15 ) );

        JPanel panel2 = new JPanel();
        panel2.setLayout( new FlowLayout( FlowLayout.CENTER, 50, 10 ) );
        panel2.setBackground( new Color( 0xe9edc9 ) );

        // Create all contents
        leaveGameBtn.setBackground( new Color( 0xf1c232 ) );
        leaveGameBtn.setFont( new Font( police, Font.PLAIN, font ) );

        panelEast.add( leaveGameBtn );

        JLabel playerOneText;
        JLabel playerTwoText;
        JLabel playerThreeText;
        JLabel playerFourText;

        JLabel playerOneTextScore;
        JLabel playerTwoTextScore;
        JLabel playerThreeTextScore;
        JLabel playerFourTextScore;

        int i = 0;
        for (Player player : playersFinal) {
            switch ( i ) {
                case 1:

                    playerTwoText = new JLabel( "<html><font color =" + player.getColor() + ">[R] " + player.getName() + "</font></html>" );
                    playerTwoText.setFont( new Font( police, Font.PLAIN, font ) );

                    playerTwoTextScore = new JLabel( "<html><font color =" + player.getColor() + ">Score :  " + player.getScore() + "</font></html>" );
                    playerTwoTextScore.setFont( new Font( police, Font.PLAIN, font ) );

                    panel1_1.add( playerTwoText );
                    panel1_1.add( playerTwoTextScore );

                    i++;
                    break;
                case 2:

                    panelEast.setLayout( new GridLayout( 4,1 ) );

                    playerThreeText = new JLabel( "<html><font color =" + player.getColor() + ">[G] " + player.getName() + "</font></html>" );
                    playerThreeText.setFont( new Font( police, Font.PLAIN, font ) );

                    playerThreeTextScore = new JLabel( "<html><font color =" + player.getColor() + ">Score :  " + player.getScore() + "</font></html>" );
                    playerThreeTextScore.setFont( new Font( police, Font.PLAIN, font ) );

                    panel1_2.add( playerThreeText );
                    panel1_2.add( playerThreeTextScore );

                    i++;
                    break;
                case 3:

                    playerFourText = new JLabel( "<html><font color =" + player.getColor() + ">[O] " + player.getName() + "</font></html>" );
                    playerFourText.setFont( new Font( police, Font.PLAIN, font ) );

                    playerFourTextScore = new JLabel( "<html><font color =" + player.getColor() + ">Score :  " + player.getScore() + "</font></html>" );
                    playerFourTextScore.setFont( new Font( police, Font.PLAIN, font ) );

                    panel1_2.add( playerFourText );
                    panel1_2.add( playerFourTextScore );

                    i++;
                    break;
                default:

                    playerOneText = new JLabel( "<html><font color =" + player.getColor() + ">[B] " + player.getName() + "</font></html>" );
                    playerOneText.setFont( new Font( police, Font.PLAIN, font ) );

                    playerOneTextScore = new JLabel( "<html><font color =" + player.getColor() + ">Score :  " + player.getScore() + "</font></html>" );
                    playerOneTextScore.setFont( new Font( police, Font.PLAIN, font ) );

                    panel1_1.add( playerOneText );
                    panel1_1.add( playerOneTextScore );

                    i++;
                    break;
            }
        }

        JLabel bonusText1 = new JLabel( "Auncun bonus" );
        bonusText1.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusText1_1 = new JLabel( "n'est activé(s)" );
        bonusText1_1.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusText2 = new JLabel( "Bonus actif :" );
        bonusText2.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusTextDynastie = new JLabel( "- Dynastie" );
        bonusTextDynastie.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusTextHarmonie = new JLabel( "- Harmonie" );
        bonusTextHarmonie.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusTextMiddleEmpire = new JLabel( "- Empire du milieu" );
        bonusTextMiddleEmpire.setFont( new Font( police, Font.PLAIN, font ) );

        JLabel bonusTextTheGrandDuel = new JLabel( "- Le grand duel" );
        bonusTextTheGrandDuel.setFont( new Font( police, Font.PLAIN, font ) );

        // Add all contents into there panel
        if ( dynastie == 0 && harmonie == 0 && middleEmpire == 0 && theGrandDuel == 0 ) {
            panel2.add( bonusText1 );
            panel2.add( bonusText1_1 );
        } else {
            panel2.add( bonusText2 );

            if ( dynastie == 1 ) {
                panel2.add(bonusTextDynastie);
            }

            if ( harmonie == 1 ) {
                panel2.add(bonusTextHarmonie);
            }

            if ( middleEmpire == 1 ) {
                panel2.add(bonusTextMiddleEmpire);
            }

            if ( theGrandDuel == 1 ) {
                panel2.add(bonusTextTheGrandDuel);
            }
        }

        // Listener
        leaveGameBtn.addActionListener( this );

        // Add all contents into the main panel
        panelEast.add( panel1_1 );
        if ( numberPlayers > 2 ){
            panelEast.add( panel1_2 );   
        }
        panelEast.add( panel2 );

        return panelEast;
    }

    /**
     * Create the south panel for game menu
     * @param none
     * @return JPanel : panelSouth
     */
    private JPanel panelSouthForGameMenu() {
        
        // Initialaze the main panel
        panelSouth = new JPanel();
        panelSouth.setLayout( new GridLayout( 1,3 ) );
        panelSouth.setBorder( BorderFactory.createLineBorder( Color.black ) );
        panelSouth.setPreferredSize( new Dimension( 0,200 ) );
        
        /* JScrollBar scrollBar = new JScrollBar();
        panelSouth.add( scrollBar ); */

        // Initializes variables use in this panel
        int fontNotPanel = 25;
        int sizePanelKingdom = 90;

        // Create all panels for grid layout
        JPanel panel1 = new JPanel();
        panel1.setLayout( new BorderLayout() );
        panel1.setBackground( new Color( 0x6a8eae ) );
        JPanel panel1_1;
        JPanel notPanel1;
        JPanel notPanel2;
        JPanel panel1_2;

        JPanel panel2 = new JPanel();
        panel2.setLayout( new BorderLayout() );
        panel2.setBackground( new Color( 0x6a8eae ) );
        JPanel panel2_1;
        JPanel notPanel4;
        JPanel notPanel5;
        JPanel panel2_2;

        JPanel panel3 = new JPanel();
        panel3.setLayout( new BorderLayout() );
        panel3.setBackground( new Color( 0x6a8eae ) );
        JPanel panel3_1;
        JPanel notPanel7;
        JPanel notPanel8;
        JPanel panel3_2;

        // Add all contents into there panel
        // Create all contents
        JLabel namePlayer1;
        JLabel namePlayer2;
        JLabel namePlayer3;

        int i = 0;
        for (Player player : game.getPlayers()) {
            if ( currentPlayer != player ) {

                switch ( i ) {
                    case 1:
                        
                        namePlayer2 = new JLabel( "Plateau de " + player.getName() );
                        namePlayer2.setFont( new Font( police, Font.PLAIN, 18 ) );
                
                        panel2_1 = new JPanel();
                        panel2_1.setPreferredSize( new Dimension( 0, sizePanelKingdom ) );
                        panel2_1.setBackground( new Color( 0xd4a373 ) );
                
                        notPanel4 = new JPanel();
                        notPanel4.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel4.setBackground( new Color( 0x6a8eae ) );
                
                        notPanel5 = new JPanel();
                        notPanel5.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel5.setBackground( new Color( 0x6a8eae ) );
                
                        panel2_2 = new JPanel();
                        panel2_2.setPreferredSize( new Dimension( 0, fontNotPanel ) );
                        panel2_2.setBackground( new Color( 0x6a8eae ) );

                        panel2.add( notPanel4, BorderLayout.EAST );
                        panel2.add( notPanel5, BorderLayout.WEST );
                        panel2_2.add( namePlayer2 );
                        panel2.add( panel2_2, BorderLayout.NORTH );
                        panel2.add( panel2_1, BorderLayout.CENTER );

                        i++;
                        break;

                    case 2:
                        
                        namePlayer3 = new JLabel( "Plateau de " + player.getName() );
                        namePlayer3.setFont( new Font( police, Font.PLAIN, 18 ) );

                        panel3_1 = new JPanel();
                        panel3_1.setPreferredSize( new Dimension( 0, sizePanelKingdom ) );
                        panel3_1.setBackground( new Color( 0xd4a373 ) );

                        notPanel7 = new JPanel();
                        notPanel7.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel7.setBackground( new Color( 0x6a8eae ) );

                        notPanel8 = new JPanel();
                        notPanel8.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel8.setBackground( new Color( 0x6a8eae ) );

                        panel3_2 = new JPanel();
                        panel3_2.setPreferredSize( new Dimension( 0, fontNotPanel ) );
                        panel3_2.setBackground( new Color( 0x6a8eae ) );

                        panel3.add( notPanel7, BorderLayout.EAST );
                        panel3.add( notPanel8, BorderLayout.WEST );
                        panel3_2.add( namePlayer3 );
                        panel3.add( panel3_2, BorderLayout.NORTH );
                        panel3.add( panel3_1, BorderLayout.CENTER );
                        
                        i++;
                        break;
                
                    default:

                        namePlayer1 = new JLabel( "Plateau de " + player.getName() );
                        namePlayer1.setFont( new Font( police, Font.PLAIN, 18 ) );
                
                        panel1_1 = new JPanel();
                        panel1_1.setPreferredSize( new Dimension( 0, sizePanelKingdom ) );
                        panel1_1.setBackground( new Color( 0xd4a373 ) );
                
                        notPanel1 = new JPanel();
                        notPanel1.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel1.setBackground( new Color( 0x6a8eae ) );
                
                        notPanel2 = new JPanel();
                        notPanel2.setPreferredSize( new Dimension( fontNotPanel, 0 ) );
                        notPanel2.setBackground( new Color( 0x6a8eae ) );
                
                        panel1_2 = new JPanel();
                        panel1_2.setPreferredSize( new Dimension( 0, fontNotPanel ) );
                        panel1_2.setBackground( new Color( 0x6a8eae ) );
                        
                        panel1.add( notPanel1, BorderLayout.EAST );
                        panel1.add( notPanel2, BorderLayout.WEST );
                        panel1_2.add( namePlayer1 );
                        panel1.add( panel1_2, BorderLayout.NORTH );
                        panel1.add( panel1_1, BorderLayout.CENTER );

                        i++;
                        break;
                }
            }
        }

        // Add all contents into there panel

        // Add all contents into the main panel
        panelSouth.add( panel1 );
        panelSouth.add( panel2 );
        panelSouth.add( panel3 );
        
        return panelSouth;
    }

    /**
     * Create the center panel for game menu
     * @param none
     * @return JPanel : panelCenter
     */
    private JPanel panelCenterForGameMenu() {

        // Initialaze the main panel
        panelCenter = new JPanel();
        panelCenter.setBorder( BorderFactory.createLineBorder( Color.black ) );
        panelCenter.setLayout( new BorderLayout() );

        // Create all panels for grid layout
        JPanel north = new JPanel();
        north.setLayout( new FlowLayout( FlowLayout.CENTER ) );
        north.setBackground( new Color( 0xe9edc9 ) );
        north.setPreferredSize( new Dimension( 0,50 ) );

        JPanel east = new JPanel();
        east.setBackground( new Color( 0xc57b57 ) );

        JPanel west = new JPanel();
        west.setBackground( new Color( 0xc57b57 ) );

        JPanel south = new JPanel();
        south.setBackground( new Color( 0xc57b57 ) );

        JPanel center = new JPanel();
        center.setLayout( new GridLayout( sizeKingdom, sizeKingdom ) );
        center.setBackground( new Color( 0xd4a373 ) );

        // Create all contents
        JLabel northText = null;
        if ( turnDraw >= 0 && turnDraw < numberPlayers + 2 && numberPlayers == 2 || turnDraw >= 0 && turnDraw < numberPlayers && numberPlayers != 2 ) {
            northText = new JLabel( "<html><font color =" + currentPlayer.getColor() + "> C'est au tour de " + currentPlayer.getName() + " de piocher </font></html>" );
        } else {
            northText = new JLabel( "<html><font color =" + currentPlayer.getColor() + "> C'est au tour de " + currentPlayer.getName() + " de poser </font></html>" );
        }
        northText.setFont( new Font( police, Font.PLAIN, 25 ) );
       
        if ( sizeKingdom == 7 ) {

            box33Button = new JButton( " Chateau" );
            box33Button.setFont( new Font( police, Font.PLAIN, 18 ) );
            box33Button.setEnabled( false );
            box22Button.setEnabled( true );
        } else {

            box22Button = new JButton( " Chateau" );
            box22Button.setFont( new Font( police, Font.PLAIN, 18 ) );
            box22Button.setEnabled( false );
            box33Button.setEnabled( true );
        }

        // Listener
        box00Button.addActionListener( this );
        box01Button.addActionListener( this );
        box02Button.addActionListener( this );
        box03Button.addActionListener( this );
        box04Button.addActionListener( this );
        box05Button.addActionListener( this );
        box06Button.addActionListener( this );

        box10Button.addActionListener( this );
        box11Button.addActionListener( this );
        box12Button.addActionListener( this );
        box13Button.addActionListener( this );
        box14Button.addActionListener( this );
        box15Button.addActionListener( this );
        box16Button.addActionListener( this );

        box20Button.addActionListener( this );
        box21Button.addActionListener( this );
        box22Button.addActionListener( this );
        box23Button.addActionListener( this );
        box24Button.addActionListener( this );
        box25Button.addActionListener( this );
        box26Button.addActionListener( this );

        box30Button.addActionListener( this );
        box31Button.addActionListener( this );
        box32Button.addActionListener( this );
        box33Button.addActionListener( this );
        box34Button.addActionListener( this );
        box35Button.addActionListener( this );
        box36Button.addActionListener( this );

        box40Button.addActionListener( this );
        box41Button.addActionListener( this );
        box42Button.addActionListener( this );
        box43Button.addActionListener( this );
        box44Button.addActionListener( this );
        box45Button.addActionListener( this );
        box46Button.addActionListener( this );

        box50Button.addActionListener( this );
        box51Button.addActionListener( this );
        box52Button.addActionListener( this );
        box53Button.addActionListener( this );
        box54Button.addActionListener( this );
        box55Button.addActionListener( this );
        box56Button.addActionListener( this );

        box60Button.addActionListener( this );
        box61Button.addActionListener( this );
        box62Button.addActionListener( this );
        box63Button.addActionListener( this );
        box64Button.addActionListener( this );
        box65Button.addActionListener( this );
        box66Button.addActionListener( this );

        // Add all contents into there panel
        north.add( northText );

        center.add( box00Button );
        center.add( box01Button );
        center.add( box02Button );
        center.add( box03Button );
        center.add( box04Button );
        if ( sizeKingdom == 7 ) {

            center.add( box05Button );
            center.add( box06Button );
        }

        center.add( box10Button );
        center.add( box11Button );
        center.add( box12Button );
        center.add( box13Button );
        center.add( box14Button );
        if ( sizeKingdom == 7 ) {

            center.add( box15Button );
            center.add( box16Button );
        }

        center.add( box20Button );
        center.add( box21Button );
        center.add( box22Button );
        center.add( box23Button );
        center.add( box24Button );
        if ( sizeKingdom == 7 ) {

            center.add( box25Button );
            center.add( box26Button );
        }

        center.add( box30Button );
        center.add( box31Button );
        center.add( box32Button );
        center.add( box33Button );
        center.add( box34Button );
        if ( sizeKingdom == 7 ) {
            
            center.add( box35Button );
            center.add( box36Button );
        }

        center.add( box40Button );
        center.add( box41Button );
        center.add( box42Button );
        center.add( box43Button );
        center.add( box44Button );
        if ( sizeKingdom == 7 ) {
            
            center.add( box45Button );
            center.add( box46Button );

            center.add( box50Button );
            center.add( box51Button );
            center.add( box52Button );
            center.add( box53Button );
            center.add( box54Button );
            center.add( box55Button );
            center.add( box56Button );

            center.add( box60Button );
            center.add( box61Button );
            center.add( box62Button );
            center.add( box63Button );
            center.add( box64Button );
            center.add( box65Button );
            center.add( box66Button );
        }

        // Add all contents into the main panel
        panelCenter.add( north, BorderLayout.NORTH );
        panelCenter.add( east, BorderLayout.EAST );
        panelCenter.add( west, BorderLayout.WEST );
        panelCenter.add( south, BorderLayout.SOUTH );
        panelCenter.add( center, BorderLayout.CENTER );

        return panelCenter;
    }

    /**
     * Create the west panel for game menu
     * @param none
     * @return JPanel : panelWest
     */
    private JPanel panelWestForGameMenu() {

        // Initialaze the main panel
        panelWest = new JPanel();
        if ( numberPlayers == 3 ) {

            panelWest.setLayout( new GridLayout( 4,2 ) );
        } else {

            panelWest.setLayout( new GridLayout( 5,2 ) );
        }
        panelWest.setPreferredSize( new Dimension( 430, (int) ((int) width - panelSouth.getPreferredSize().getHeight()) ) );
        panelWest.setBackground( new Color( 0xd4a373 ) );

        // Initializes variables for this game
        int widthPanelWest = (int) panelWest.getPreferredSize().getWidth()/2;
        int heightPanelWest = ( numberPlayers == 3 ) ? (int) panelWest.getPreferredSize().getHeight()/8 : (int) panelWest.getPreferredSize().getHeight()/10;

        // Create all panels for grid layout
        JPanel panel1 = new JPanel();
        panel1.setLayout( new GridBagLayout() );
        GridBagConstraints gbc1 = new GridBagConstraints(); 
        panel1.setBackground( new Color( 0xd4a373 ) );
        panel1.setBorder( BorderFactory.createLineBorder( Color.black ) );

        JPanel panel2 = new JPanel();
        panel2.setLayout( new GridBagLayout() );
        GridBagConstraints gbc2 = new GridBagConstraints(); 
        panel2.setBackground( new Color( 0xd4a373 ) );

        JPanel panel3 = new JPanel();
        panel3.setLayout( new GridBagLayout() );
        GridBagConstraints gbc3 = new GridBagConstraints(); 
        panel3.setBackground( new Color( 0xd4a373 ) );
        panel3.setBorder( BorderFactory.createLineBorder( Color.black ) );

        JPanel panel4 = new JPanel();
        panel4.setLayout( new GridBagLayout() );
        GridBagConstraints gbc4 = new GridBagConstraints(); 
        panel4.setBackground( new Color( 0xd4a373 ) );

        // Create all contents
        rotationBtn.setFont( new Font( police, Font.PLAIN, 18 ) );
        rotationBtn.setBackground( new Color( 0xfefae0 ) );

        endTour.setFont( new Font( police, Font.PLAIN, 18 ) );
        endTour.setBackground( new Color( 0xfefae0 ) );
        endTour.setEnabled( false );

        //  Next Domino image
        JLabel nextDomino1 = null;
        JLabel nextDomino2 = null;
        JLabel nextDomino3 = null;
        JLabel nextDomino4 = null;

        int i = 0;
        for (Domino nextDomino : nextDominos ) {
            switch ( i ) {
                case 1:
                    nextDomino2 = new JLabel();
                    nextDomino2.setBorder( BorderFactory.createLineBorder( Color.black ) );
                    BufferedImage nextDomino2Image = null;
            
                    try {
                        // TODO Implement domino.getNameFiles
                        nextDomino2Image = ImageIO.read( new File( "imagesdomino/" + nextDomino.getNameFile() + ".png" ) );
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   
            
                    nextDomino2.setIcon( new ImageIcon( fitimage( nextDomino2Image, widthPanelWest, heightPanelWest ) ) );
                    i++;
                    break;

                case 2:
                    nextDomino3 = new JLabel();
                    BufferedImage nextDomino3Image = null;

                    try {
                        // TODO Implement domino.getNameFiles
                        nextDomino3Image = ImageIO.read( new File( "imagesdomino/" + nextDomino.getNameFile() + ".png" ) );
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   

                    nextDomino3.setIcon( new ImageIcon( fitimage( nextDomino3Image, widthPanelWest, heightPanelWest ) ) );
                    i++;
                    break;

                case 3:
                    if ( numberPlayers != 3 ) {
                        nextDomino4 = new JLabel();
                        nextDomino4.setBorder( BorderFactory.createLineBorder( Color.black ) );
                        BufferedImage nextDomino4Image = null;
    
                        try {
                            // TODO Implement domino.getNameFiles
                            nextDomino4Image = ImageIO.read( new File( "imagesdomino/" + nextDomino.getNameFile() + ".png" ) );
                        } catch ( Exception e ) {
                            e.printStackTrace();
                        }   
    
                        nextDomino4.setIcon( new ImageIcon( fitimage( nextDomino4Image, widthPanelWest, heightPanelWest ) ) );
                        i++;
                    } 
                    break;
            
                default:
                    nextDomino1 = new JLabel();
                    BufferedImage nextDomino1Image = null;

        
                    try {
                        // TODO Implement domino.getNameFiles
                        nextDomino1Image = ImageIO.read( new File( "imagesdomino/" + nextDomino.getNameFile() + ".png" ) );
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   

                    nextDomino1.setIcon( new ImageIcon( fitimage( nextDomino1Image, widthPanelWest, heightPanelWest ) ) );
                    i++;
                    break;
            }
        }        

        // Domino drawn image
        JLabel domino1Image = null;
        JLabel domino2Image = null;
        JLabel domino3Image = null;
        JLabel domino4Image = null;

        i = 0;
        for (Domino currentDomino : currentDominos ) {
            switch ( i ) {
                case 1:
                    domino2Image = new JLabel();
                    BufferedImage imageDomino2 = null;
                    BufferedImage imageDomino2JL = null;
            
                    try {
                        // TODO Implement domino.getNameFiles
                        imageDomino2 = ImageIO.read( new File( "imagesdomino/" + currentDomino.getNameFile() + ".png" ) );

                        for( Player player : playersFinal ) {

                            if ( player.getDominoTaken().size() == 2 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[1] ) {

                                    imageDomino2JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                } else if ( player.getDominoTaken().get( 1 ) == currentDominos[1] ) {
                                    
                                    imageDomino2JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            } else if ( player.getDominoTaken().size() == 1 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[1] ) {
                                    
                                    imageDomino2JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            }
                            
                        }
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   
            
                    domino2Image.setIcon( new ImageIcon( fitimage( imageDomino2, widthPanelWest-25, heightPanelWest) ) );
                    domino2JL.setIcon( new ImageIcon( fitimage( imageDomino2JL, 25, 25) ) );
                    i++;
                    break;

                case 2:
                    domino3Image = new JLabel();
                    BufferedImage imageDomino3 = null;
                    BufferedImage imageDomino3JL = null;
            
                    try {
                        // TODO Implement domino.getNameFiles
                        imageDomino3 = ImageIO.read( new File( "imagesdomino/" + currentDomino.getNameFile() + ".png" ) );

                        for( Player player : playersFinal ) {

                            if ( player.getDominoTaken().size() == 2 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[2] ) {

                                    imageDomino3JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                } else if ( player.getDominoTaken().get( 1 ) == currentDominos[2] ) {
                                    
                                    imageDomino3JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            } else if ( player.getDominoTaken().size() == 1 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[2] ) {
                                    
                                    imageDomino3JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            }
                            
                        }
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   
            
                    domino3Image.setIcon( new ImageIcon( fitimage( imageDomino3, widthPanelWest-25, heightPanelWest) ) );
                    domino3JL.setIcon( new ImageIcon( fitimage( imageDomino3JL, 25, 25) ) );
                    i++;
                    break;

                case 3:
                    if ( numberPlayers != 3 ) {
                        domino4Image = new JLabel();
                        BufferedImage imageDomino4 = null;
                        BufferedImage imageDomino4JL = null;
                
                        try {
                            // TODO Implement domino.getNameFiles
                            imageDomino4 = ImageIO.read( new File( "imagesdomino/" + currentDomino.getNameFile() + ".png" ) );
    
                            for( Player player : playersFinal ) {
    
                                if ( player.getDominoTaken().size() == 2 ) {
    
                                    if ( player.getDominoTaken().get( 0 ) == currentDominos[3] ) {
    
                                        imageDomino4JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                        break;
                                    } else if ( player.getDominoTaken().get( 1 ) == currentDominos[3] ) {
                                        
                                        imageDomino4JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                        break;
                                    }
                                } else if ( player.getDominoTaken().size() == 1 ) {
    
                                    if ( player.getDominoTaken().get( 0 ) == currentDominos[3] ) {
                                        
                                        imageDomino4JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                        break;
                                    }
                                }
                                
                            }
                        } catch ( Exception e ) {
                            e.printStackTrace();
                        }   
                
                        domino4Image.setIcon( new ImageIcon( fitimage( imageDomino4, widthPanelWest-25, heightPanelWest) ) );
                        domino4JL.setIcon( new ImageIcon( fitimage( imageDomino4JL, 25, 25) ) );
                        i++;
                    }
                    break;
            
                default:
                    domino1Image = new JLabel();
                    BufferedImage imageDomino1 = null;
                    BufferedImage imageDomino1JL = null;
            
                    try {
                        // TODO Implement domino.getNameFiles
                        imageDomino1 = ImageIO.read( new File( "imagesdomino/" + currentDomino.getNameFile() + ".png" ) );

                        for( Player player : playersFinal ) {

                            if ( player.getDominoTaken().size() == 2 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[0] ) {

                                    imageDomino1JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                } else if ( player.getDominoTaken().get( 1 ) == currentDominos[0] ) {
                                    
                                    imageDomino1JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            } else if ( player.getDominoTaken().size() == 1 ) {

                                if ( player.getDominoTaken().get( 0 ) == currentDominos[0] ) {
                                    
                                    imageDomino1JL = ImageIO.read( new File( "imagesdomino/King-" + player.getColor() + ".png" ) );
                                    break;
                                }
                            }
                            
                        }
                        
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }   
            
                    domino1Image.setIcon( new ImageIcon( fitimage( imageDomino1, widthPanelWest-25, heightPanelWest) ) );
                    domino1JL.setIcon( new ImageIcon( fitimage( imageDomino1JL, 25, 25) ) );
                    i++;
                    break;
            }
        }
        
        ButtonGroup btnRadio = new ButtonGroup();
        btnRadio.add( domino1 );
        btnRadio.add( domino2 );
        btnRadio.add( domino3 );            
        btnRadio.add( domino4 );

        // Listener
        rotationBtn.addActionListener( this );
        endTour.addActionListener( this );
        domino1.addActionListener( this );
        domino2.addActionListener( this );
        domino3.addActionListener( this );
        domino4.addActionListener( this );

        // Add all contents into the main panel
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        panel1.add( domino1Image );
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        if ( currentDominos[0].isSelected() ) {
            panel1.add( domino1JL );
        } else {
            panel1.add( domino1 );
        }

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panel2.add( domino2Image );
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        if ( currentDominos[1].isSelected() ) {
            panel2.add( domino2JL );
        } else {
            panel2.add( domino2 );
        }

        gbc3.gridx = 0;
        gbc3.gridy = 0;
        panel3.add( domino3Image );
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        if ( currentDominos[2].isSelected() ) {
            panel3.add( domino3JL );
        } else {
            panel3.add( domino3 );
        }

        if ( numberPlayers != 3 ) {

            gbc4.gridx = 0;
            gbc4.gridy = 0;
            panel4.add( domino4Image );
            gbc4.gridx = 1;
            gbc4.gridy = 1;
            if ( currentDominos[3].isSelected() ) {
                panel4.add( domino4JL );
            } else {
                panel4.add( domino4 );
            }
        }

        // Add all contents into the main panel
        panelWest.add( endTour );
        panelWest.add( rotationBtn );

        panelWest.add( nextDomino1 );
        panelWest.add( panel1 );

        panelWest.add( nextDomino2 );
        panelWest.add( panel2 );

        panelWest.add( nextDomino3 );
        panelWest.add( panel3 );

        if ( numberPlayers != 3 ) {

            panelWest.add( nextDomino4 );
            panelWest.add( panel4 );
        }
        
        return panelWest;
    }

    /**
     * Clean all jpanel
     * @param none
     * @return none
     */
    private void cleanJPanel() {
        if ( panelNorth != null ) {
            panelNorth = null;
        }

        if ( panelSouth != null ) {
            panelSouth = null;
        }

        if ( panelEast != null ) {
            panelEast = null;
        }

        if ( panelWest != null ) {
            panelWest = null;
        }

        if ( panelCenter != null ) {
            panelCenter = null;
        }

        if ( banner != null ) {
            banner = null;
        }

        if ( background != null ) {
            background = null;
        }
    }

    /**
     * Clean all button for action event
     * @param none
     * @return none
     */
    private void cleanButton() {

        if ( newGameBtn.getActionListeners().length > 1 ) {
            newGameBtn = null;
            newGameBtn = new JButton( "Nouvelle partie" );
        }
        
        if ( soundBtn.getActionListeners().length > 1 ) {
            soundBtn = null;
            soundBtn = new JButton( "Son activé" );
        }
        
        if ( leave.getActionListeners().length > 1 ) {
            leave = null;
            leave = new JButton( "Quitter" );
        }
        
        if ( credits.getActionListeners().length > 1 ) {
            credits = null;
            credits = new JButton( "Crédits" );
        }
        
        if ( backToStartMenu.getActionListeners().length > 1 ) {
            backToStartMenu = null;
            backToStartMenu = new JButton("Retour");
        }
        
        if ( backToStartMenu2.getActionListeners().length > 1 ) {
            backToStartMenu2 = null;
            backToStartMenu2 = new JButton("Retour");
        }
        
        if ( twoPlayersBtn.getActionListeners().length > 1 ) {
            twoPlayersBtn = null;
            twoPlayersBtn = new JButton( "2 joueurs" );
        }
        
        if ( threePlayersBtn.getActionListeners().length > 1 ) {
            threePlayersBtn = null;
            threePlayersBtn = new JButton( "3 joueurs" );
        }
        
        if ( fourPlayersBtn.getActionListeners().length > 1 ) {
            fourPlayersBtn = null;
            fourPlayersBtn = new JButton( "4 joueurs" );
        }
        
        if ( backToSelection.getActionListeners().length > 1 ) {
            backToSelection = null;
            backToSelection = new JButton( "Retour sélection" );
        }
        
        if ( launchGame.getActionListeners().length > 1 ) {
            launchGame = null;
            launchGame = new JButton( "Lancer la partie" );
        }

        if ( leaveGameBtn.getActionListeners().length > 1 ) {
            leaveGameBtn = null;
            leaveGameBtn = new JButton( "Quitter la partie" );
        }

        if ( dynastieBtn.getActionListeners().length > 1 ) {
            dynastieBtn = null;
            dynastieBtn = new JCheckBox( "Dynastie" );
        }

        if ( harmonieBtn.getActionListeners().length > 1) {
            harmonieBtn = null;
            harmonieBtn = new JCheckBox( "Harmonie" );
        }

        if ( middleEmpireBtn.getActionListeners().length > 1 ) {
            middleEmpireBtn = null;
            middleEmpireBtn = new JCheckBox( "Empire du milieu" );
        }

        if ( theGrandDuelBtn.getActionListeners().length > 1 ) {
            theGrandDuelBtn = null;
            theGrandDuelBtn = new JCheckBox( "Le Grand Duel" );
        }

        if ( displayTimeBtn.getActionListeners().length > 1 ) {
            displayTimeBtn = null;
            displayTimeBtn = new JRadioButton( "Afficher le temps" );
        }

        if ( displayTimeLimitedBtn.getActionListeners().length > 1 ) {
            displayTimeLimitedBtn = null;
            displayTimeLimitedBtn = new JRadioButton( "Ajouter une limite de temps" );
        }

        if ( rotationBtn.getActionListeners().length > 1 ) {
            rotationBtn = null;
            rotationBtn = new JButton( "Rotation" );
        }

        if ( endTour.getActionListeners().length > 1 ) {
            endTour = null;
            endTour = new JButton( "Fin du tour" );
        }
    
        box00Button = null;
        box00Button = new JButton();

        box01Button = null;
        box01Button = new JButton();

        box02Button = null;
        box02Button = new JButton();

        box03Button = null;
        box03Button = new JButton();

        box04Button = null;
        box04Button = new JButton();

        box05Button = null;
        box05Button = new JButton();

        box06Button = null;
        box06Button = new JButton();
    
        box10Button = null;
        box10Button = new JButton();

        box11Button = null;
        box11Button = new JButton();
        
        box12Button = null;
        box12Button = new JButton();

        box13Button = null;
        box13Button = new JButton();

        box14Button = null;
        box14Button = new JButton();

        box15Button = null;
        box15Button = new JButton();

        box16Button = null;
        box16Button = new JButton();
    
        box20Button = null;
        box20Button = new JButton();

        box21Button = null;
        box21Button = new JButton();

        box22Button = null;
        box22Button = new JButton();

        box23Button = null;
        box23Button = new JButton();

        box24Button = null;
        box24Button = new JButton();

        box25Button = null;
        box25Button = new JButton();

        box26Button = null;
        box26Button = new JButton();
    
        box30Button = null;
        box30Button = new JButton();

        box31Button = null;
        box31Button = new JButton();

        box32Button = null;
        box32Button = new JButton();

        box33Button = null;
        box33Button = new JButton();

        box34Button = null;
        box34Button = new JButton();

        box35Button = null;
        box35Button = new JButton();

        box36Button = null;
        box36Button = new JButton();
    
        box40Button = null;
        box40Button = new JButton();

        box41Button = null;
        box41Button = new JButton();

        box42Button = null;
        box42Button = new JButton();

        box43Button = null;
        box43Button = new JButton();

        box44Button = null;
        box44Button = new JButton();

        box45Button = null;
        box45Button = new JButton();

        box46Button = null;
        box46Button = new JButton();
    
        box50Button = null;
        box50Button = new JButton();

        box51Button = null;
        box51Button = new JButton();

        box52Button = null;
        box52Button = new JButton();

        box53Button = null;
        box53Button = new JButton();

        box54Button = null;
        box54Button = new JButton();

        box55Button = null;
        box55Button = new JButton();

        box56Button = null;
        box56Button = new JButton();
    
        box60Button = null;
        box60Button = new JButton();

        box61Button = null;
        box61Button = new JButton();

        box62Button = null;
        box62Button = new JButton();

        box63Button = null;
        box63Button = new JButton();

        box64Button = null;
        box64Button = new JButton();

        box65Button = null;
        box65Button = new JButton();

        box66Button = null;
        box66Button = new JButton();
    }

    // All listeners for buttons
    @Override
    public void actionPerformed( ActionEvent e ) {

        if ( e.getSource() == backToStartMenu ) {

            // Remove all panels from the frame
            frame.remove( panelNorth );
            frame.remove( panelWest );
            frame.remove( panelCenter );
            frame.remove( panelSouth );

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            startMenu();

        } else if ( e.getSource() == backToStartMenu2 ) {

            // Remove all panels from the frame
            frame.remove( panelEast );
            frame.remove( panelNorth );
            frame.remove( panelWest );
            frame.remove( panelCenter );

            // Clean panels and button used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            startMenu();

        } else if ( e.getSource() == newGameBtn ) {

            // Set the number of players
            numberPlayers = 0;

            // Remove all panels from the frame
            frame.remove(panelEast);
            frame.remove(banner);
            frame.remove(background);

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            newGameMenu();

        } else if ( e.getSource() == twoPlayersBtn ) {

            // Set the number of players
            numberPlayers = 2;

            // Remove all panels from the frame
            frame.remove( panelWest );
            frame.remove( panelSouth );
            frame.remove( panelCenter );

            // Clean panels and buttons used
            if ( panelWest != null ) {
                panelWest = null;
            }
            if ( panelSouth != null ) {
                panelSouth = null;
            }
            if ( twoPlayersBtn.getActionListeners().length > 1 ) {
                twoPlayersBtn = null;
                twoPlayersBtn = new JButton( "2 joueurs" );
            }
            if ( launchGame.getActionListeners().length > 1 ) {
                launchGame = null;
                launchGame = new JButton( "Lancer la partie" );
            }
            
            position = 1;

            // Add new panels to the frame
            frame.add( twoPlayers(), BorderLayout.LINE_START );
            frame.add( panelSouthForNewGameMenu( position ), BorderLayout.SOUTH );
            frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

        } else if ( e.getSource() == threePlayersBtn ) {

            // Set the number of players
            numberPlayers = 3;

            // Remove all panels from the frame
            frame.remove( panelWest );
            frame.remove( panelSouth );
            frame.remove( panelCenter );

            // Clean panels and buttons used
            if ( panelWest != null ) {
                panelWest = null;
            }
            if ( panelSouth != null ) {
                panelSouth = null;
            }
            if ( threePlayersBtn.getActionListeners().length > 1 ) {
                threePlayersBtn = null;
                threePlayersBtn = new JButton( "3 joueurs" );
            }
            if ( launchGame.getActionListeners().length > 1 ) {
                launchGame = null;
                launchGame = new JButton( "Lancer la partie" );
            }

            position = 2;

            // Add new panels to the frame
            frame.add( threePlayers(), BorderLayout.LINE_START );
            frame.add( panelSouthForNewGameMenu( position ), BorderLayout.SOUTH );
            frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

        } else if ( e.getSource() == fourPlayersBtn ) {

            // Set the number of players
            numberPlayers = 4;

            // Remove all panels from the frame
            frame.remove( panelWest );
            frame.remove( panelSouth );
            frame.remove( panelCenter );

            // Clean panels and buttons used
            if ( panelWest != null ) {
                panelWest = null;
            }
            if ( panelSouth != null ) {
                panelSouth = null;
            }
            if ( fourPlayersBtn.getActionListeners().length > 1 ) {
                fourPlayersBtn = null;
                fourPlayersBtn = new JButton( "4 joueurs" );
            }
            if ( launchGame.getActionListeners().length > 1 ) {
                launchGame = null;
                launchGame = new JButton( "Lancer la partie" );
            }

            position = 3;

            // Add new panels to the frame
            frame.add( fourPlayers(), BorderLayout.LINE_START );
            frame.add( panelSouthForNewGameMenu( position ), BorderLayout.SOUTH );
            frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

        } else if ( e.getSource() == backToSelection ) {

            // Set the number of players
            numberPlayers = 0;

            // Remove all panels from the frame
            frame.remove( panelWest );
            frame.remove( panelSouth );
            frame.remove( panelCenter );

            // Clean panels and buttons used
            if ( panelWest != null ) {
                panelWest = null;
            }
            if ( panelSouth != null ) {
                panelSouth = null;
            }
            if ( backToSelection.getActionListeners().length > 1 ) {
                backToSelection = null;
                backToSelection = new JButton( "Retour sélection" );
            }
            if ( launchGame.getActionListeners().length > 1 ) {
                launchGame = null;
                launchGame = new JButton( "Lancer la partie" );
            }

            // Clean all option selected
            if ( dynastie != 0 ) {

                dynastie = 0;
                dynastieBtn.setSelected( false );
            }
            if ( harmonie != 0 ) {

                harmonie = 0;
                harmonieBtn.setSelected( false );
            }
            if ( middleEmpire != 0 ) {

                middleEmpire = 0;
                middleEmpireBtn.setSelected( false );
            }
            if ( theGrandDuel != 0 ) {

                theGrandDuel = 0;
                theGrandDuelBtn.setSelected( false );
            }
            if ( displayTime != 0 ) {

                displayTime = 0;
                displayTimeBtn = null;
                displayTimeBtn = new JRadioButton( "Afficher le temps" );
            }
            if ( displayTimeLimited != 0 ) {

                displayTimeLimited = 0;
                displayTimeLimitedBtn = null;
                displayTimeLimitedBtn = new JRadioButton( "Ajouter une limite de temps" );
            }

            position = 0;

            // Add new panels to the frame
            frame.add( panelWestForNewGameMenu(), BorderLayout.LINE_START );
            frame.add( panelSouthForNewGameMenu( position ), BorderLayout.SOUTH );
            frame.add( panelCenterForNewGameMenu(), BorderLayout.CENTER );

        } else if ( e.getSource() == soundBtn ) {
            
            if ( soundBtn.getText() == "Son activé" ) {

                soundBtn.setText( "Son désactivé" );
                soundBtn.setFont( new Font ( police, Font.PLAIN, 17 ));
            } else {

                soundBtn.setText( "Son activé" );
                soundBtn.setFont( new Font ( police, Font.PLAIN, 20 ));
            }
            /**
             * TODO Cut the sound when is activated, and inversement
             */

        } else if ( e.getSource() == credits ) {

            // Remove all panels from the frame
            frame.remove( panelEast );
            frame.remove( banner );
            frame.remove( background );

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            credit();

        } else if ( e.getSource() == displayTimeBtn ) {

            displayTimeLimited = 0;
            displayTime = 1;

        } else if ( e.getSource() == displayTimeLimitedBtn ) {

            displayTime = 0;
            displayTimeLimited = 1;

        } else if ( e.getSource() == dynastieBtn ) {

            // Set the game option
            dynastie = ( dynastieBtn.isSelected() ) ? 1 : 0;

        } else if ( e.getSource() == harmonieBtn ) {

            // Set the game option
            harmonie = ( harmonieBtn.isSelected() ) ? 1 : 0;

        } else if ( e.getSource() == middleEmpireBtn ) {

            // Set the game option
            middleEmpire = ( middleEmpireBtn.isSelected() ) ? 1 : 0;

        } else if ( e.getSource() == theGrandDuelBtn ) {

            // Set the game option
            theGrandDuel = ( theGrandDuelBtn.isSelected() ) ? 1 : 0;

            // Remove all panel from the frame
            frame.remove( panelSouth );

            // Clean panel used
            if ( panelSouth != null ) {
                panelSouth = null;
            }

            // Add new panels to the frame
            frame.add( panelSouthForNewGameMenu( position ), BorderLayout.SOUTH );
        } else if ( e.getSource() == launchGame ) {

            // This part create the list of the players for first turn of the game
            playersFinal = new Player[numberPlayers];
            Player[] players = game.getPlayers();
            List<Integer> numPlayers = new ArrayList<Integer>();

            for ( int i = 0; i < numberPlayers; i++ ){
                numPlayers.add( i );
            }

            for ( int i = 0; i < numberPlayers; i++ ) {

                int indiceRandom = (int) ( Math.random() * ( numPlayers.size() ) );
                playersFinal[i] = players[numPlayers.get( indiceRandom )];
                numPlayers.remove( indiceRandom );
                /*System.out.println(indiceRandom);
                System.out.println(numPlayers);
                System.out.println(playersFinal[i].getName());*/
            }

            try {
                game.createDomino();
            } catch ( Exception exception ) {
                exception.printStackTrace();
            }

            currentPlayer = playersFinal[0];

            // This part create the list of the the current and next dominos for first turn of the game
            dominoBegun = game.getDomino();

            if( numberPlayers % 2 == 0 ) {

                for (int k = 0; k < numberDominos; k += 4) {

                    for (int i = 0; i < k + 3; i++) {

                        int indiceMin = i;

                        for (int j = i; j < k + 4; j++) {

                            if (dominoBegun[j].getNumber() < dominoBegun[indiceMin].getNumber()) {
                                indiceMin = j;
                            }
                        }

                        Domino swap = dominoBegun[i];
                        dominoBegun[i] = dominoBegun[indiceMin];
                        dominoBegun[indiceMin] = swap;
                    }

                }

                currentDominos[0] = dominoBegun[0];
                currentDominos[1] = dominoBegun[1];
                currentDominos[2] = dominoBegun[2];
                currentDominos[3] = dominoBegun[3];

                nextDominos[0] = dominoBegun[4];
                nextDominos[1] = dominoBegun[5];
                nextDominos[2] = dominoBegun[6];
                nextDominos[3] = dominoBegun[7];
            } else {

                for (int k = 0; k < numberDominos; k += 3) {

                    for (int i = k; i < k + 2; i++) {

                        int indiceMin = i;

                        for (int j = i; j < k + 3; j++) {

                            if (dominoBegun[j].getNumber() < dominoBegun[indiceMin].getNumber()) {
                                indiceMin = j;
                            }
                        }

                        Domino swap = dominoBegun[i];
                        dominoBegun[i] = dominoBegun[indiceMin];
                        dominoBegun[indiceMin] = swap;
                    }
                }

                currentDominos[0] = dominoBegun[0];
                currentDominos[1] = dominoBegun[1];
                currentDominos[2] = dominoBegun[2];

                nextDominos[0] = dominoBegun[3];
                nextDominos[1] = dominoBegun[4];
                nextDominos[2] = dominoBegun[5];

            }

            currentPlayer = playersFinal[0];

            for ( Player player : playersFinal ){
                player.setBoard( game.initializeBoard( player ) );
                // game.printBoard( player );
            }

            // Remove all panels from the frame
            frame.remove( panelNorth );
            frame.remove( panelWest );
            frame.remove( panelCenter );
            frame.remove( panelSouth );

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            gameMenu();

        } else if ( e.getSource() == leaveGameBtn ) {

            // Remove all panels from the frame
            frame.remove( panelEast );
            frame.remove( panelSouth );
            frame.remove( panelCenter );
            frame.remove( panelWest );

            // Clean all option selected
            dynastie = 0;
            dynastieBtn.setSelected( false );

            harmonie = 0;
            harmonieBtn.setSelected( false );

            middleEmpire = 0;
            middleEmpireBtn.setSelected( false );

            theGrandDuel = 0;
            theGrandDuelBtn.setSelected( false );

            displayTime = 0;
            displayTimeBtn = null;
            displayTimeBtn = new JRadioButton( "Afficher le temps" );

            displayTimeLimited = 0;
            displayTimeLimitedBtn = null;
            displayTimeLimitedBtn = new JRadioButton( "Ajouter une limite de temps" );

            turn = 0;
            turnDraw = 0;

            domino1 = null;
            domino2 = null;
            domino3 = null;
            domino4 = null;
            domino1 = new JRadioButton();
            domino2 = new JRadioButton();
            domino3 = new JRadioButton();
            domino4 = new JRadioButton();

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            startMenu();
        } else if ( e.getSource() == rotationBtn ) {
            if ( rotation == 1 ) {
                rotation = 0;
            } else {
                rotation = 1;
            }
        } else if ( e.getSource() == endTour ) {
            
            if ( turnDraw >= 0 && turnDraw < numberPlayers + 2 && numberPlayers == 2 ) {

                if ( domino1.isSelected() ) {

                    currentPlayer.getDominoTaken().add( currentDominos[0]  );
                    currentDominos[0].setSelected( true );
                } else if ( domino2.isSelected() ) {

                    currentPlayer.getDominoTaken().add( currentDominos[1]  );
                    currentDominos[1].setSelected( true );
                } else if ( domino3.isSelected() ) {

                    currentPlayer.getDominoTaken().add( currentDominos[2]  );
                    currentDominos[2].setSelected( true );
                } else if ( domino4.isSelected() ) {

                    currentPlayer.getDominoTaken().add( currentDominos[3]  );
                    currentDominos[3].setSelected( true );
                }
                
                turnDraw++;
                currentPlayer = playersFinal[turnDraw%2];
                
            } else if ( turnDraw >= 0 && turnDraw < numberPlayers ) { 
            
                if ( domino1.isSelected() ) {

                    currentPlayer.setDominoTaken( Arrays.asList( currentDominos[0] )  );
                    currentDominos[0].setSelected( true );
                } else if ( domino2.isSelected() ) {

                    currentPlayer.setDominoTaken( Arrays.asList( currentDominos[1] )  );
                    currentDominos[1].setSelected( true );
                } else if ( domino3.isSelected() ) {

                    currentPlayer.setDominoTaken( Arrays.asList( currentDominos[2] )  );
                    currentDominos[2].setSelected( true );
                } else if ( domino4.isSelected() ) {

                    currentPlayer.setDominoTaken( Arrays.asList( currentDominos[3] )  );
                    currentDominos[3].setSelected( true );
                }

                turnDraw++;
                currentPlayer = ( numberPlayers == 3 ) ? playersFinal[turnDraw%3] : playersFinal[turnDraw%4];

            } else {
                turnDraw = 0;

            }
            
            frame.remove( panelCenter );
            frame.remove( panelWest );
            frame.remove( panelEast );
            frame.remove( panelSouth );

            cleanJPanel();
            cleanButton();

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
            frame.add( panelSouthForGameMenu(), BorderLayout.SOUTH );
            frame.add( panelWestForGameMenu(), BorderLayout.WEST );
            frame.add( panelEastForGameMenu(), BorderLayout.EAST );
            
        } else if ( e.getSource() == domino1 ) {

            domino1 = null;
            domino2 = null;
            domino3 = null;
            domino4 = null;
            
            try {
                domino1 = new JRadioButton( new ImageIcon( fitimage( ImageIO.read( new File( "imagesdomino/King-" + currentPlayer.getColor() + ".png" ) ), 25, 25) ) );
                domino1.setSelected( true );
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            domino2 = new JRadioButton();
            domino3 = new JRadioButton();
            domino4 = new JRadioButton();

            frame.remove( panelWest );

            panelWest = null;

            frame.add( panelWestForGameMenu(), BorderLayout.WEST );
            endTour.setEnabled( true );
        } else if ( e.getSource() == domino2 ) {

            domino1 = null;
            domino2 = null;
            domino3 = null;
            domino4 = null;
            
            try {
                domino2 = new JRadioButton( new ImageIcon( fitimage( ImageIO.read( new File( "imagesdomino/King-" + currentPlayer.getColor() + ".png" ) ), 25, 25) ) );
                domino2.setSelected( true );
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            domino1 = new JRadioButton();
            domino3 = new JRadioButton();
            domino4 = new JRadioButton();

            frame.remove( panelWest );

            panelWest = null;

            frame.add( panelWestForGameMenu(), BorderLayout.WEST );
            endTour.setEnabled( true );
        } else if ( e.getSource() == domino3 ) {

            domino1 = null;
            domino2 = null;
            domino3 = null;
            domino4 = null;
            
            try {
                domino3 = new JRadioButton( new ImageIcon( fitimage( ImageIO.read( new File( "imagesdomino/King-" + currentPlayer.getColor() + ".png" ) ), 25, 25) ) );
                domino3.setSelected( true );
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            domino1 = new JRadioButton();
            domino2= new JRadioButton();
            domino4 = new JRadioButton();

            frame.remove( panelWest );

            panelWest = null;

            frame.add( panelWestForGameMenu(), BorderLayout.WEST );
            endTour.setEnabled( true );
        } else if ( e.getSource() == domino4 ) {

            domino1 = null;
            domino2 = null;
            domino3 = null;
            domino4 = null;
            
            try {
                domino4 = new JRadioButton( new ImageIcon( fitimage( ImageIO.read( new File( "imagesdomino/King-" + currentPlayer.getColor() + ".png" ) ), 25, 25) ) );
                domino4.setSelected( true );
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            domino1 = new JRadioButton();
            domino2= new JRadioButton();
            domino3 = new JRadioButton();

            frame.remove( panelWest );

            panelWest = null;

            frame.add( panelWestForGameMenu(), BorderLayout.WEST );
            endTour.setEnabled( true );
        } else if ( e.getSource() == box00Button ) {


            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box00Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            if ( rotation == 1 ) {

                box10Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box01Button = null;
                box01Button = new JButton();

                if ( game.isValidMove( 0, 0, 1, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box01Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box10Button = null;
                box10Button = new JButton();

                if ( game.isValidMove( 0, 0, 0, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box01Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box01Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            if ( rotation == 1 ) {

                box11Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box00Button = null;
                box00Button = new JButton();

                if ( game.isValidMove( 0, 1, 1, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box00Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box11Button = null;
                box11Button = new JButton();

                if ( game.isValidMove( 0, 1, 0, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box02Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box02Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            if ( rotation == 1 ) {

                box12Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box01Button = null;
                box01Button = new JButton();

                if ( game.isValidMove( 0, 2, 1, 2, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box01Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box12Button = null;
                box12Button = new JButton();

                if ( game.isValidMove( 0, 2, 0, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box03Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box03Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            if ( rotation == 1 ) {

                box13Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box02Button = null;
                box02Button = new JButton();

                if ( game.isValidMove( 0, 3, 1, 3, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box02Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box13Button = null;
                box13Button = new JButton();

                if ( game.isValidMove( 0, 3, 0, 2, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box04Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box04Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            if ( rotation == 1 ) {

                box14Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box03Button = null;
                box03Button = new JButton();

                if ( game.isValidMove( 0, 4, 1, 4, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box03Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box14Button = null;
                box14Button = new JButton();

                if ( game.isValidMove( 0, 4, 0, 3, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box05Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box05Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box15Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box04Button = null;
                box04Button = new JButton();

                if ( game.isValidMove( 0, 5, 1, 5, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box04Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box15Button = null;
                box15Button = new JButton();

                if ( game.isValidMove( 0, 5, 0, 4, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box06Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box06Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box16Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box05Button = null;
                box05Button = new JButton();

                if ( game.isValidMove( 0, 6, 1, 6, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box05Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box16Button = null;
                box16Button = new JButton();

                if ( game.isValidMove( 0, 6, 0, 5, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box10Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box10Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box20Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box11Button = null;
                box11Button = new JButton();

                if ( game.isValidMove( 1, 0, 2, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box11Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box20Button = null;
                box20Button = new JButton();

                if ( game.isValidMove( 1, 0, 1, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box11Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box11Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box21Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box10Button = null;
                box10Button = new JButton();

                if ( game.isValidMove( 1, 1, 2, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box10Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box21Button = null;
                box21Button = new JButton();

                if ( game.isValidMove( 1, 1, 1, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box12Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box12Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box02Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box11Button = null;
                box11Button = new JButton();

                if ( game.isValidMove( 1, 2, 0, 2, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box11Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box02Button = null;
                box02Button = new JButton();

                if ( game.isValidMove( 1, 2, 1, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box13Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box13Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box23Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box12Button = null;
                box12Button = new JButton();

                if ( game.isValidMove( 1, 3, 2, 3, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box12Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box23Button = null;
                box23Button = new JButton();

                if ( game.isValidMove( 1, 3, 1, 2, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box14Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box14Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box24Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box13Button = null;
                box13Button = new JButton();

                if ( game.isValidMove( 1, 4, 2, 4, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box13Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box24Button = null;
                box24Button = new JButton();

                if ( game.isValidMove( 1, 4, 1, 3, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box15Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box15Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box25Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box14Button = null;
                box14Button = new JButton();

                if ( game.isValidMove( 1, 5, 2, 5, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box14Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box25Button = null;
                box25Button = new JButton();

                if ( game.isValidMove( 1, 5, 2, 5, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box16Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box16Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box26Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box15Button = null;
                box15Button = new JButton();

                if ( game.isValidMove( 1, 6, 2, 6, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box15Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box26Button = null;
                box26Button = new JButton();

                if ( game.isValidMove( 1, 6, 1, 5, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box20Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
            
            cleanButton();
            
            box20Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box30Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box21Button = null;
                box21Button = new JButton();

                if ( game.isValidMove( 2, 0, 3, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box21Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                box30Button = null;
                box30Button = new JButton();

                if ( game.isValidMove( 2, 0, 3, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box21Button ) {

            frame.remove( panelCenter );

            panelCenter = null;
        
            cleanButton();
            
            box21Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );

            
            if ( rotation == 1 ) {

                box31Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                /* box20Button = null;
                box20Button = new JButton(); */

                if ( game.isValidMove( 2, 1, 3, 1, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            } else {

                box20Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                /* box31Button = null;
                box31Button = new JButton(); */

                if ( game.isValidMove( 2, 1, 3, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                    endTour.setEnabled( true );
                }
            }

            frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
        } else if ( e.getSource() == box22Button ) {

            if ( sizeKingdom == 7 ) {
                
                frame.remove( panelCenter );

                panelCenter = null;
                
                cleanButton();
                
                box22Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
    
                
                if ( rotation == 1 ) {
    
                    box32Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                    box20Button = null;
                    box20Button = new JButton();
    
                    if ( game.isValidMove( 2, 2, 3, 2, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                        endTour.setEnabled( true );
                    }
                } else {
    
                    box20Button = new JButton( currentPlayer.getDominoTaken().get( 0 ).dominoSideTwo.getType() + currentPlayer.getDominoTaken().get( 0 ).dominoSideOne.getCrown() );
                    box32Button = null;
                    box32Button = new JButton();
    
                    if ( game.isValidMove( 2, 2, 2, 0, currentPlayer.getDominoTaken().get( 0 )  ) ) {
                        endTour.setEnabled( true );
                    }
                }
    
                frame.add( panelCenterForGameMenu(), BorderLayout.CENTER );
            }
        } else if ( e.getSource() == box23Button ) {

        } else if ( e.getSource() == box24Button ) {

        } else if ( e.getSource() == box25Button ) {

        } else if ( e.getSource() == box26Button ) {

        } else if ( e.getSource() == box30Button ) {

        } else if ( e.getSource() == box31Button ) {

        } else if ( e.getSource() == box32Button ) {

        } else if ( e.getSource() == box33Button ) {

        } else if ( e.getSource() == box34Button ) {

        } else if ( e.getSource() == box35Button ) {

        } else if ( e.getSource() == box36Button ) {

        } else if ( e.getSource() == box40Button ) {

        } else if ( e.getSource() == box41Button ) {

        } else if ( e.getSource() == box42Button ) {

        } else if ( e.getSource() == box43Button ) {

        } else if ( e.getSource() == box44Button ) {

        } else if ( e.getSource() == box45Button ) {

        } else if ( e.getSource() == box46Button ) {

        } else if ( e.getSource() == box50Button ) {

        } else if ( e.getSource() == box51Button ) {

        } else if ( e.getSource() == box52Button ) {

        } else if ( e.getSource() == box53Button ) {

        } else if ( e.getSource() == box54Button ) {

        } else if ( e.getSource() == box55Button ) {

        } else if ( e.getSource() == box56Button ) {

        } else if ( e.getSource() == box60Button ) {

        } else if ( e.getSource() == box61Button ) {

        } else if ( e.getSource() == box62Button ) {

        } else if ( e.getSource() == box63Button ) {

        } else if ( e.getSource() == box64Button ) {

        } else if ( e.getSource() == box65Button ) {

        } else if ( e.getSource() == box66Button ) {

        }

        // Actualize the frame
        frame.validate();
        frame.repaint();
    }

    // Method getValue and putValue is use for action event, don't change it
    @Override
    public Object getValue( String key ) {
        return null;
    }

    @Override
    public void putValue( String key, Object value ) {

    }

    // Temporary launch for debug swing application
    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );

        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                new Graphic_interface();
            }
        });
    }
}