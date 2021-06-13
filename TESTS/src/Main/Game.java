package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Grap_int.Graphic_interface.numberDominos;
import static Grap_int.Graphic_interface.numberPlayers;
import static java.lang.Math.random;

public class Game {
	
	// Class attribute
	private King[] king = null;
	private Player[] players = null;
	private Castle[] castle = null;
	private Domino[] domino = null;
	int numberKing;

	// Getter and Setter
	public King[] getKing() {
		return king;
	}

	public Player[] getPlayers() {
		return players;
	}

	public Castle[] getCastle() {
		return castle;
	}

	public void createPlayer( int numberPlayers, String namePlayer, int numPlayer, String color ) {

		if ( ( this.players == null ) || ( this.players.length != numberPlayers ) ) {
			this.players = new Player[numberPlayers];
			this.king = new King[numberPlayers];
			this.castle = new Castle[numberPlayers];
		}
		
		numberKing = ( numberPlayers > 2 ) ? 1 : 2;
		
		this.castle[numPlayer-1] = new Castle( color );
		this.king[numPlayer-1] = new King( color, numberKing );
		this.players[numPlayer-1] = new Player( namePlayer, color );

		//System.out.println(players[numPlayer-1].getName());// to check if the name are correct
		//players[0].setScore(4);
		//System.out.println(players[numPlayer-1].getScore());
		// System.out.println(Arrays.toString(players)); // to check if the list is completed
		//System.out.println(king[numPlayer-1].getNumberKing()); // to check the numberKing of each player
		// System.out.println(players[numPlayer-1].getName()+ " " +king[numPlayer-1].getColor()+" "+players[numPlayer-1].getColor()+" "+castle[numPlayer-1].getColor()); // Gros bordel
	}

	public void createDomino() throws FileNotFoundException {

		Scanner scanner = new Scanner( new File( "dominos.csv" ) );
		StringBuilder sb = new StringBuilder();
		while ( scanner.hasNextLine() ) {
			sb.append( scanner.nextLine() )
					.append( "\n" );
		}
		scanner.close();

		String data = sb.toString();

		@SuppressWarnings("unused")

		List<String> lines = new ArrayList<String>( Arrays.asList( data.split( "\n" ) ) );
		this.domino = new Domino[numberDominos];

		for ( int i = 1; i < numberDominos; i++ ) {

			int linesMax = lines.size() -1;
			int indiceRandom = (int) Math.random()*( linesMax - 1 );

			String s = lines.get( indiceRandom );
			String[] dataLines = s.split( ";" );

			lines.remove( indiceRandom );

			this.domino[i-1] = new Domino( new DominoSideOne( Integer.parseInt( dataLines[0] ), dataLines[1] ), new DominoSideTwo( Integer.parseInt( dataLines[2] ), dataLines[3] ), Integer.parseInt( dataLines[4] ), dataLines[5] );
		}
	}


	private boolean isValidMove() {
		return true;
	}


	private void initializeBoard() {
		
	}


	
	// On decrit brievement la logique du jeu
	public void play() {
	   while (true) {
	        // attribution des rois, châteaux et connaissance du nombre de joueurs.
	       //createPlayer();

	       // on placera le château et on choisira la couleur qui commence grâce à une liste de couleur qui donnera random l'ordre
	       initializeBoard();  
	       
	       // A voir si on choisi un while ou un for
	       for (int tour = 0; tour != numberDominos/numberPlayers; tour++){
	           for (int tourDominos = 1; tourDominos != 4; tourDominos++) {
	                // on pioche les tuiles et on les range dans l'ordre
	                //pioche();
	 
	                if (tour==0) {
	                    // choix des dominos en fonction de l�ordre des couleurs
	                    //choix1();
	                } else {
	                    // choix des dominos en fonction de l�ordre des dominos
	                    //choixDomino();
	               }

	                //printBoard();       // En a t�on besoin ??
	        
	               String move;
	               //do {
	               //    move = askMove();
	               //}
	               //while (!isValidMove(move));

	               //placementDomino(move);     // placer le domino sur le plateau
	               //switchPlayer();
	           }
	       }
	   }
	}

	private void updateBoard() {
		
	}
	private void askLayTitles() {
		
	}
	private void switchPlayer() {
		
	}
	private void calculatePoints() {
		
	}
}