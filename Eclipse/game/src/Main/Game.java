package Main;

public class Game {
	private void createPlayer() {
		
	}
	private boolean isValidMove() {
		return true;
	}
	private void initializeGame() {
		
	}
	private void initializeBoard() {
		
	}
	
	// On decrit brievement la logique du jeu
	public void play() {
	   while (true) {
	        // attribution des rois, ch�teaux et connaissance du                  nombre de joueurs.
	       createPlayers();

	       // initialiser le nombre de tuiles suivant le nombre de joueurs ainsi que la liste de couleurs    
	       initializeGame();

	       // on placera le ch�teau et on choisira la couleur qui commence gr�ce � une liste de couleur qui donnera random l'ordre  
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