package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Grap_int.Graphic_interface.numberDominos; // number of Domino depending the number of players
import static Grap_int.Graphic_interface.numberPlayers; // number of players
import static java.lang.Math.random;

public class Game {
	
	// Class attribute
	private Player[] players = null;
	private Domino[] domino = null;

	// Getter and Setter

	public Player[] getPlayers() {
		return players;
	}

	public Domino[] getDomino() {
		return domino;
	}

	/*
	*create the list of players
	*@param numberPlayers for the total number of players
	*@param namePlayer for the name of the players at the position numPlayer
	*@param numPlayer for the position of the player ( player 1,2,3 or 4)
	*@param color for the color of the player
	*/
	public void createPlayer( int numberPlayers, String namePlayer, int numPlayer, String color ) {

		if ( ( this.players == null ) || ( this.players.length != numberPlayers ) ) {
			this.players = new Player[numberPlayers];
		}

		this.players[numPlayer-1] = new Player( namePlayer, color );

		/*System.out.println(players[numPlayer-1].king.getColor() + players[numPlayer-1].king.getNumberKing() + players[numPlayer-1].castle.getColor() + players[numPlayer-1].getName());// to check if the name are correct
		players[0].setScore(4);
		System.out.println(players[numPlayer-1].getScore());
		System.out.println(Arrays.toString(players)); // to check if the list is completed
		System.out.println(Arrays.toString(getPlayers())); //same
		 */
	}

	/*
	* create the list of domino which would be use during the game
	* it's retrieve the list from the csv
	* we convert it to a list and remove the title of the column
	* then we do a for to randomly choose domino to add to the Domino class domino
	*/
	public void createDomino() throws Exception {

		Scanner scanner = new Scanner( new File( "Document/dominos.csv" ) );
		StringBuilder sb = new StringBuilder();
		while ( scanner.hasNextLine() ) {
			sb.append( scanner.nextLine() )
					.append( "\n" );
		}
		scanner.close();

		String data = sb.toString();

		List<String> lines = new ArrayList<String>( Arrays.asList( data.split( "\n" ) ) );
		lines.remove(lines.get(0));

		//System.out.println(Arrays.deepToString(new List[]{lines}));

		this.domino = new Domino[numberDominos];
		int linesMax = lines.size();

		for ( int i = 1; i <= numberDominos; i++ ) {
			int indiceRandom = (int) (Math.random() * (linesMax));
			String s = lines.get(indiceRandom);
			String[] dataLines = s.split( ";" );
			lines.remove( lines.get(indiceRandom) );
			linesMax--;
			this.domino[i-1] = new Domino( new DominoSideOne( Integer.parseInt( dataLines[0] ), dataLines[1] ), new DominoSideTwo( Integer.parseInt( dataLines[2] ), dataLines[3] ), Integer.parseInt( dataLines[4] ), dataLines[5] );
			//System.out.println(domino[i-1].dominoSideOne.getType() + domino[i-1].dominoSideOne.getCrown() + domino[i-1].dominoSideTwo.getType() + domino[i-1].dominoSideTwo.getCrown() + domino[i-1].getNumber() + domino[i-1].getNameFile());
		}
		//System.out.println(Arrays.deepToString(domino));

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