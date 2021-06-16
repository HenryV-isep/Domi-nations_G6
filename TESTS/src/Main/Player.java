package Main;

import java.util.ArrayList;
import java.util.List;

import static Grap_int.Graphic_interface.numberPlayers;

public class Player {
	
	// Class attribute
	public King king;
	public Castle castle;
	private String name;
	private int score = 0;
	private String color;
	public int numberKing = ( numberPlayers > 2 ) ? 1 : 2;
	private List<Domino> dominoTaken = new ArrayList<Domino>(numberKing);

	public List<Domino> getDominoTaken() {
		return dominoTaken;
	}

	public void setDominoTaken(List<Domino> dominoTaken) {
		this.dominoTaken = dominoTaken;
	}

	// Getter and Setter
	public int getScore() {
		return score;
	}

	public void setScore( int score ) {
		this.score += score;
	}

	public String getName() {
		return name;
	}
	
	public String getColor() {
		return color;
	}

	// Class Builder
	public Player( String name, String color ) {
		super();
		this.name = name;
		this.color = color;
		this.king = new King(color,numberKing);
		this.castle = new Castle(color);

	}

}
