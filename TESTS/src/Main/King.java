package Main;

public class King {
	
	// Class attribute
	private String color;
	private int numberKing;

	// Getter and Setter
	public String getColor() {
		return color;
	}

	public int getNumberKing() {
		return numberKing;
	}

	// Class Builder
	public King( String color, int numberKing ) {
		this.color = color;
		this.numberKing = numberKing;
	}
}