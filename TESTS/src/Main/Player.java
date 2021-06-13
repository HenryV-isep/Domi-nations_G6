package Main;

public class Player {
	
	// Class attribute
	public King king;
	public Castle castle;
	private String name;
	private int score = 0;
	private String color;

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

	}

}
