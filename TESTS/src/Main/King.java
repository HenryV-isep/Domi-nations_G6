package Main;

public class King {
	private String color;
	private int numberKing;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	public int getNumberKing() {
		return numberKing;
	}

	public void setNumberKing(int numberKing) {
		this.numberKing = numberKing;
	}

	public King(String color, int numberKing) {
		this.color = color;
		this.numberKing = numberKing;
	}
}