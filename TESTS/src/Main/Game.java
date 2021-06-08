package Main;

import static Grap_int.swing.numberDominos;
import static Grap_int.swing.numberPlayers;

public class Game {
	private King[] king = null;
	private Player[] players = null;
	private Castle[] castle = null;
	int numberKing;

	public void createPlayer(int numberPlayers, String namePlayer, int numPlayer, String color) {
		if ((this.players == null) || (this.players.length != numberPlayers)){
			this.players = new Player[numberPlayers];
			this.king = new King[numberPlayers];
			this.castle = new Castle[numberPlayers];
		}
		if (numberPlayers > 2) {
			numberKing = 1;
		} else {
			numberKing = 2;
		}
		this.castle[numPlayer-1] = new Castle(color);
		this.king[numPlayer-1] = new King(color,numberKing);
		this.players[numPlayer-1] = new Player(namePlayer,color);
		//System.out.println(players[numPlayer-1].getName());// to check if the name are correct
		// System.out.println(Arrays.toString(players)); // to check if the list is completed
		//System.out.println(king[numPlayer-1].getNumberKing()); // to check the numberKing of each player
		// System.out.println(players[numPlayer-1].getName()+ " " +king[numPlayer-1].getColor()+" "+players[numPlayer-1].getColor()+" "+castle[numPlayer-1].getColor()); // Gros bordel
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