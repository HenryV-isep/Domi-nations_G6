package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Grap_int.Graphic_interface.*;

public class Game {
	
	// Class attribute
	private Player[] players = null;
	private Domino[] domino = null;
	private Board[][] board;

	// Getter and Setter


	public Board[][] getBoard() {
		return board;
	}

	public Player[] getPlayers() {
		return players;
	}

	public Domino[] getDomino() {
		return domino;
	}

	/**
	* Create the list of players
	* @param numberPlayers for the total number of players
	* @param namePlayer for the name of the players at the position numPlayer
	* @param numPlayer for the position of the player ( player 1,2,3 or 4)
	* @param color for the color of the player
	* @return none
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

	/**
	* Create the list of domino which would be use during the game
	* it's retrieve the list from the csv
	* we convert it to a list and remove the title of the column
	* then we do a for to randomly choose domino to add to the Domino class domino
	* @param none
	* @return none
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

	/**
	 * Check if the move you made is possible for the domino you have chosen
	 * @param column1 (0 to sizeKingdom-1) : the column you put the first side of the domino
	 * @param row1 (0 to sizeKingdom-1) : the row you put the first side of the domino
	 * @param column2 (0 to sizeKingdom-1) : the column you put the second side of the domino
	 * @param row2 (0 to sizeKingdom-1) : the row you put the second side of the domino

	 */
	public boolean isValidMove(int row1,int column1, int row2,int column2, Domino dominoSelected) {
		if (board[row1][column1]==null && board[row2][column2] ==null){
				int middleBoard = sizeKingdom/2;
				if((row1 == middleBoard-1 && column1 ==middleBoard) || (row1 == middleBoard && column1 ==middleBoard-1) ||
						(row1 == middleBoard && column1 ==middleBoard+1) || (row1 == middleBoard+1 && column1 ==middleBoard) ||
						(row2 == middleBoard-1 && column2 ==middleBoard) || (row2 == middleBoard && column2 ==middleBoard-1) ||
						(row2 == middleBoard && column2 ==middleBoard+1) || (row2 == middleBoard+1 && column2 ==middleBoard)){
					return true;
				}
				else{
					String typeDominoSideOne = dominoSelected.dominoSideOne.getType();
					//String typeDominoSideTwo = dominoSelected.dominoSideTwo.getType();

					if(row1==0) {
						if (column1 == 0) {
							if(board[row1][column1 + 1] ==null && board[row1+1][column1] ==null){
								return false;
							}
							else if(board[row1][column1 + 1] !=null && board[row1+1][column1] !=null) {
								return typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType());
							}
							else if(board[row1 + 1][column1] ==null){
								return typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType());
							}
							else{
								return typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType());
							}
						} else if (column1 == 4) {
							if(board[row1][column1 - 1] ==null && board[row1+1][column1] ==null){
								return false;
							}
							else if(board[row1][column1 - 1] !=null && board[row1+1][column1] !=null) {
								return typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType());
							}
							else if(board[row1 + 1][column1] ==null){
								return typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType());
							}
							else{
								return typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType());
							}
						} else { //faire les check null
							return typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType()) ||
									typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
									typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType());
						}
					}
					else if (row1==4)	{
							if (column1 == 0) {//faire les check null
								return typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ;
							}
							else if (column1 == 4){//faire les check null
								return typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType()) ;
							}
							else {//faire les check null
								return typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
										typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ;
							}
					}
					else if (column1==0) {//faire les check null
						return typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1 ][column1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ;
					}
					else if (column1==4) {//faire les check null
						return typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1 ][column1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ;
					}
					else{//faire les check null
						return typeDominoSideOne.equals(board[row1 - 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 - 1][column1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1][column1 - 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 - 1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1][column1 + 1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1][column1 + 1].getDomino2().getType()) ||
								typeDominoSideOne.equals(board[row1 + 1][column1].getDomino1().getType()) || typeDominoSideOne.equals(board[row1 + 1][column1].getDomino2().getType()); /* ||
								typeDominoSideTwo.equals(board[row2 - 1][column2].getDomino1().getType()) || typeDominoSideTwo.equals(board[row2 - 1][column2].getDomino2().getType()) ||
								typeDominoSideTwo.equals(board[row2][column2 - 1].getDomino1().getType()) || typeDominoSideTwo.equals(board[row2][column2 - 1].getDomino2().getType()) ||
								typeDominoSideTwo.equals(board[row2][column2 + 1].getDomino1().getType()) || typeDominoSideTwo.equals(board[row2][column2 + 1].getDomino2().getType()) ||
								typeDominoSideTwo.equals(board[row2 + 1][column2].getDomino1().getType()) || typeDominoSideTwo.equals(board[row2 + 1][column2].getDomino2().getType());*/
					}
				}
		}
		else {
			return false;
		}
	}

	/**
	* Function which create the board of the player and put his castle in the middle of his board
	* @param player to know who is playing
	 * @return 
	*/
	public Board[][] initializeBoard( Player player ) {
		
		this.board = new Board[sizeKingdom][sizeKingdom];

		int middleBoard = sizeKingdom/2;

		//System.out.println(castlePlayer.getColor());
		//System.out.println(currentDominos[0].getNameFile());
		this.board[middleBoard][middleBoard] = new Board( player.castle );
		this.board[middleBoard][middleBoard].setEmpty( false );

		return this.board;
		//System.out.println(board[middleBoard][middleBoard].getCastle().getColor());

		/*this.board[1][1] = new Board(currentDominos[0].dominoSideOne);
		this.board[1][1].setEmpty(false);
		this.board[1][2] = new Board(currentDominos[0].dominoSideTwo);
		this.board[1][2].setEmpty(false);

		System.out.println(board[1][1].getDomino1().getType() + board[1][1].getDomino1().getCrown());
		System.out.println(board[1][2].getDomino2().getType() + board[1][2].getDomino2().getCrown());*/
	}

	/* print the board on the console log
	 * @param player to know who is playing
	 */

	public void printBoard( Player player ) {

		System.out.println(player.getName());
		//System.out.println( player.getBoard()[2][2].getCastle().getColor() );
		for( int li = 0; li < sizeKingdom; li++ ){

			for( int co = 0; co < sizeKingdom; co++ ){

				Board cell = player.getBoard()[li][co];
				if ( cell == null ){

					System.out.print( "null " );
				} else {

					if ( cell.getCastle() != null ) {
						System.out.print( cell.getCastle().getColor() + " " );
					}
					else if( cell.getDomino1() != null ){
						System.out.print( cell.getDomino1().getType() + cell.getDomino1().getCrown() + " " );
					}
					else{
						System.out.print( cell.getDomino2().getType() + cell.getDomino2().getCrown() + " " );
					}
				}
			}
			System.out.println();
		}
	}

	/* update the board after you put a domino on the board
	 * @param column1 (0 to sizeKingdom-1) : the column you put the first side of the domino
	 * @param row1 (0 to sizeKingdom-1) : the row you put the first side of the domino
	 * @param column2 (0 to sizeKingdom-1) : the column you put the second side of the domino
	 * @param row2 (0 to sizeKingdom-1) : the row you put the second side of the domino
	 * @param dominoSelected : domino which is going to be placed on the board
	 * @param player : who is playing this board

	 */

	public void updateBoard( int row1, int column1, int row2, int column2, Domino dominoSelected, Player player ) {
		if ( isValidMove( row1, column1, row2, column2, dominoSelected ) ){
			player.getBoard()[row1][column1] = new Board( dominoSelected.dominoSideOne );
			player.getBoard()[row1][column1].setEmpty( false );
			player.getBoard()[row2][column2] = new Board( dominoSelected.dominoSideTwo );
			player.getBoard()[row2][column2].setEmpty(false);

			//System.out.println( player.getBoard()[row1][column1].getDomino1().getType() + player.getBoard()[row1][column1].getDomino1().getCrown() );
			//System.out.println( player.getBoard()[row2][column2].getDomino2().getType() + player.getBoard()[row2][column2].getDomino2().getCrown() );
		}
		else {
			System.out.println( "Not a valid move." );
		}

		printBoard(player);
	}

	private void calculatePoints(Player player) {

	}
}