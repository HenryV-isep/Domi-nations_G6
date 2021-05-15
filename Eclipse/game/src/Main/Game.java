package Main;

import java.util.Scanner;

public class Game {

	private Player[] players;
	public int nbTuiles;
	private Scanner clavier = new Scanner(System.in);

	private void createPlayer() {
		this.players = new Player[4]; // changer pour 2 et if more players players.add
		this.players[0] = new Player(this.clavier.nextLine(),blue);  // à remplacer par la fonction qui donne la couleur
		this.players[1] = new Player(this.clavier.nextLine(),green);
		this.players[2] = new Player(this.clavier.nextLine(),orange);
		this.players[3] = new Player(this.clavier.nextLine(),brown);
		currentPlayer = this.players[0];
	}
	private boolean isValidMove() {
		return true;
	}

	private void initializeGame() {
		if (this.players.length ==2){
			nbTuiles = 24;

		}
		if else (this.players.length ==3){
			nbTuiles = 36;
		}
		else (this.players.length ==4){
			nbTuiles = 48;
		}
	}

	private void initializeBoard() {
		
	}


	
	// On decrit brievement la logique du jeu
	public void play() {
	   while (true) {
	        // attribution des rois, châteaux et connaissance du nombre de joueurs.
	       createPlayers();

	       // initialiser le nombre de tuiles suivant le nombre de joueurs ainsi que la liste de couleurs    
	       initializeGame();

	       // on placera le château et on choisira la couleur qui commence grâce à une liste de couleur qui donnera random l'ordre
	       initializeBoard();  
	       
	       // A voir si on choisi un while ou un for
	       for (int tour = 0; tour != nbTuile/nbPlayers; tour++){
	           for (int tourDominos = 1; tourDominos != 4; tourDominos++) {
	                // on pioche les tuiles et on les range dans l'ordre
	                pioche();
	 
	                if (tour==0) {
	                    // choix des dominos en fonction de l�ordre des couleurs
	                    choix1();    
	                } else {
	                    // choix des dominos en fonction de l�ordre des dominos
	                    choixDomino();   
	               }

	               printBoard();       // En a t�on besoin ?? 
	        
	               String move;
	               do {
	                   move = askMove();
	               } 
	               while (!isValidMove(move));

	               placementDomino(move);     // placer le domino sur le plateau
	               switchPlayer();
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