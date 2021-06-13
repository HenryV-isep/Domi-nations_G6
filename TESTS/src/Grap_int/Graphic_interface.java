package Grap_int;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import Main.*;
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
    private static String police = "Century Gothic";
    private static Game game = new Game();
    public static Player[] playersFinal;
    
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
    private JButton rotation = new JButton( "Rotation" );
    private JButton endTour = new JButton( "Fin du tour" );
    private JRadioButton displayTimeBtn = new JRadioButton( "Afficher le temps" );
    private JRadioButton displayTimeLimitedBtn = new JRadioButton( "Ajouter une limite de temps" );
    private JRadioButton domino1 = new JRadioButton();
    private JRadioButton domino2 = new JRadioButton();
    private JRadioButton domino3 = new JRadioButton();
    private JRadioButton domino4 = new JRadioButton();
    private JCheckBox dynastieBtn = new JCheckBox( "Dynastie" );
    private JCheckBox harmonieBtn = new JCheckBox( "Harmonie" );
    private JCheckBox middleEmpireBtn = new JCheckBox( "Empire du milieu" );
    private JCheckBox theGrandDuelBtn = new JCheckBox( "Le Grand Duel" );

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
        for (Player player : game.getPlayers()) {
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
        center.setBackground( new Color( 0xd4a373 ) );

        // Create all contents
        JLabel northText = new JLabel( "<html><font color =" + currentPlayer.getColor() + "> c'est le tour de " + currentPlayer.getName() + "</font></html>" );
        northText.setFont( new Font( police, Font.PLAIN, 25 ) );

        // Add all contents into the main panel
        north.add( northText );

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
        panelWest.setLayout( new GridLayout( 5,2 ) );
        panelWest.setPreferredSize( new Dimension( 300,0 ) );
        panelWest.setBackground( new Color( 0xd4a373 ) );

        // Initializes variables for this game
        int widthPanelWest = (int) panelWest.getPreferredSize().getWidth()/2;
        int heightPanelWest = (int) panelWest.getPreferredSize().getHeight()/5;

        // Create all panels for grid layout
        JPanel panel1 = new JPanel();
        panel1.setLayout( new BorderLayout() );
        panel1.setBackground( new Color( 0xd4a373 ) );
        panel1.setBorder( BorderFactory.createLineBorder( Color.black ) );
        JPanel panel2 = new JPanel();
        panel2.setLayout( new BorderLayout() );
        panel2.setBackground( new Color( 0xd4a373 ) );
        JPanel panel3 = new JPanel();
        panel3.setLayout( new BorderLayout() );
        panel3.setBackground( new Color( 0xd4a373 ) );
        panel3.setBorder( BorderFactory.createLineBorder( Color.black ) );
        JPanel panel4 = new JPanel();
        panel4.setLayout( new BorderLayout() );
        panel4.setBackground( new Color( 0xd4a373 ) );

        // Create all contents
        rotation.setFont( new Font( police, Font.PLAIN, 18 ) );
        rotation.setBackground( new Color( 0xfefae0 ) );
        endTour.setFont( new Font( police, Font.PLAIN, 18 ) );
        endTour.setBackground( new Color( 0xfefae0 ) );
        
        JLabel nextDomino1 = new JLabel();
        BufferedImage nextDomino1Image = null;

        try {
            // TODO Implement domino.getNameFiles
            nextDomino1Image = ImageIO.read( new File( "imagesdomino/1Cchamp-foret.png" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }   

        // nextDomino1.setIcon( new ImageIcon( fitimage( nextDomino1Image, widthPanelWest, heightPanelWest ) ) );

        JLabel nextDomino2 = new JLabel();
        nextDomino2.setBorder( BorderFactory.createLineBorder( Color.black ) );
        BufferedImage nextDomino2Image = null;

        try {
            // TODO Implement domino.getNameFiles
            nextDomino2Image = ImageIO.read( new File( "imagesdomino/1Cchamp-foret.png" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }   

        // nextDomino2.setIcon( new ImageIcon( fitimage( nextDomino2Image, widthPanelWest, heightPanelWest ) ) );

        JLabel nextDomino3 = new JLabel();
        BufferedImage nextDomino3Image = null;

        try {
            // TODO Implement domino.getNameFiles
            nextDomino3Image = ImageIO.read( new File( "imagesdomino/1Cchamp-foret.png" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }   

        // nextDomino3.setIcon( new ImageIcon( fitimage( nextDomino3Image, widthPanelWest, heightPanelWest ) ) );
        
        JLabel nextDomino4 = new JLabel();
        nextDomino4.setBorder( BorderFactory.createLineBorder( Color.black ) );
        BufferedImage nextDomino4Image = null;

        try {
            // TODO Implement domino.getNameFiles
            nextDomino4Image = ImageIO.read( new File( "imagesdomino/1Cchamp-foret.png" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }   

        // nextDomino4.setIcon( new ImageIcon( fitimage( nextDomino4Image, widthPanelWest, heightPanelWest ) ) );
        
        ButtonGroup btnRadio = new ButtonGroup();
        btnRadio.add( domino1 );
        btnRadio.add( domino2 );
        btnRadio.add( domino3 );
        btnRadio.add( domino4 );

        // Listenere
        rotation.addActionListener( this );
        endTour.addActionListener( this ); 

        // Add all contents into the main panel
        panel1.add( domino1, BorderLayout.LINE_END );
        panel2.add( domino2, BorderLayout.LINE_END );
        panel3.add( domino3, BorderLayout.LINE_END );
        panel4.add( domino4, BorderLayout.LINE_END );

        // Add all contents into the main panel
        panelWest.add( endTour );
        panelWest.add( rotation );
        panelWest.add( nextDomino1 );
        panelWest.add( panel1 );
        panelWest.add( nextDomino2 );
        panelWest.add( panel2 );
        panelWest.add( nextDomino3 );
        panelWest.add( panel3 );
        panelWest.add( nextDomino4 );
        panelWest.add( panel4 );
        
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

        if ( rotation.getActionListeners().length > 1 ) {
            rotation = null;
            rotation = new JButton( "Rotation" );
        }

        if ( endTour.getActionListeners().length > 1 ) {
            endTour = null;
            endTour = new JButton( "Fin du tour" );
        }
    
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

            /**
             * TODO implement the function to create game
             * TODO initializes the currentPlayers when the game is launching
             */

            playersFinal = new Player[numberPlayers];
            Player[] players = game.getPlayers();
            List<Integer> numbers = new ArrayList<Integer>();

            for ( int i = 0; i < numberPlayers; i++ ){
                numbers.add(i);
            }

            for ( int i = 0; i < numberPlayers; i++ ) {
                int indiceRandom = (int) (Math.random() * (numbers.size()));
                playersFinal[i] = players[numbers.get(indiceRandom)];
                numbers.remove(indiceRandom);
                /*System.out.println(indiceRandom);
                System.out.println(numbers);
                System.out.println(playersFinal[i].getName());*/
            }

            try {
                game.createDomino();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            currentPlayer = playersFinal[0];

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
            /**
             * TODO If needed, remove/delete game
             */

            // Remove all panels from the frame
            frame.remove( panelEast );
            frame.remove( panelSouth );
            frame.remove( panelCenter );
            frame.remove( panelWest );

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

            // Clean panels and buttons used
            cleanJPanel();
            cleanButton();

            // Add new panels to the frame
            startMenu();
        } else if ( e.getSource() == rotation ) {
            
        } else if ( e.getSource() == endTour ) {
            
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